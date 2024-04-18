package com.google.android.gms.internal;

import android.content.Context;

@ey
public final class cp {
    private final cy lA;
    private final Context mContext;
    private final Object mH;
    private final fh qh;
    private final cr qi;
    private boolean qj;
    private cu qk;

    /* renamed from: com.google.android.gms.internal.cp.1 */
    class C10621 implements Runnable {
        final /* synthetic */ cv ql;
        final /* synthetic */ cp qm;

        C10621(cp cpVar, cv cvVar) {
            this.qm = cpVar;
            this.ql = cvVar;
        }

        public void run() {
            try {
                this.ql.qQ.destroy();
            } catch (Throwable e) {
                gr.m4777d("Could not destroy mediation adapter.", e);
            }
        }
    }

    public cp(Context context, fh fhVar, cy cyVar, cr crVar) {
        this.mH = new Object();
        this.qj = false;
        this.mContext = context;
        this.qh = fhVar;
        this.lA = cyVar;
        this.qi = crVar;
    }

    public final cv m4363a(long j, long j2) {
        gr.m4769S("Starting mediation.");
        for (cq cqVar : this.qi.qu) {
            gr.m4771U("Trying mediation network: " + cqVar.qo);
            for (String str : cqVar.qp) {
                synchronized (this.mH) {
                    if (this.qj) {
                        cv cvVar = new cv(-1);
                        return cvVar;
                    }
                    this.qk = new cu(this.mContext, str, this.lA, this.qi, cqVar, this.qh.tL, this.qh.lS, this.qh.lO);
                    cvVar = this.qk.m4378b(j, j2);
                    if (cvVar.qO == 0) {
                        gr.m4769S("Adapter succeeded.");
                        return cvVar;
                    } else if (cvVar.qQ != null) {
                        gq.wR.post(new C10621(this, cvVar));
                    }
                }
            }
        }
        return new cv(1);
    }

    public final void cancel() {
        synchronized (this.mH) {
            this.qj = true;
            if (this.qk != null) {
                this.qk.cancel();
            }
        }
    }
}
