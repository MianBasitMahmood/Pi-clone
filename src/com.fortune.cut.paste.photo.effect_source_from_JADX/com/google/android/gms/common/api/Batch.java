package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.BaseImplementation.AbstractPendingResult;
import com.google.android.gms.common.api.BaseImplementation.CallbackHandler;
import com.google.android.gms.common.api.PendingResult.C0491a;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends AbstractPendingResult<BatchResult> {
    private boolean JA;
    private boolean JB;
    private final PendingResult<?>[] JC;
    private int Jz;
    private final Object mH;

    /* renamed from: com.google.android.gms.common.api.Batch.1 */
    class C04921 implements C0491a {
        final /* synthetic */ Batch JD;

        C04921(Batch batch) {
            this.JD = batch;
        }

        public void m1792m(Status status) {
            synchronized (this.JD.mH) {
                if (this.JD.isCanceled()) {
                    return;
                }
                if (status.isCanceled()) {
                    this.JD.JB = true;
                } else if (!status.isSuccess()) {
                    this.JD.JA = true;
                }
                this.JD.Jz = this.JD.Jz - 1;
                if (this.JD.Jz == 0) {
                    if (this.JD.JB) {
                        super.cancel();
                    } else {
                        this.JD.m1615b(new BatchResult(this.JD.JA ? new Status(13) : Status.Kw, this.JD.JC));
                    }
                }
            }
        }
    }

    public static final class Builder {
        private List<PendingResult<?>> JE;
        private Looper JF;

        public Builder(GoogleApiClient googleApiClient) {
            this.JE = new ArrayList();
            this.JF = googleApiClient.getLooper();
        }

        public final <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken(this.JE.size());
            this.JE.add(pendingResult);
            return batchResultToken;
        }

        public final Batch build() {
            return new Batch(this.JF, null);
        }
    }

    private Batch(List<PendingResult<?>> list, Looper looper) {
        super(new CallbackHandler(looper));
        this.mH = new Object();
        this.Jz = list.size();
        this.JC = new PendingResult[this.Jz];
        for (int i = 0; i < list.size(); i++) {
            PendingResult pendingResult = (PendingResult) list.get(i);
            this.JC[i] = pendingResult;
            pendingResult.m1610a(new C04921(this));
        }
    }

    public final /* synthetic */ Result m1802c(Status status) {
        return createFailedResult(status);
    }

    public final void cancel() {
        super.cancel();
        for (PendingResult cancel : this.JC) {
            cancel.cancel();
        }
    }

    public final BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.JC);
    }
}
