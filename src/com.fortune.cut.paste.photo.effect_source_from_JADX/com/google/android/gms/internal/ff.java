package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.fe.C1137a;

@ey
public abstract class ff extends gf {
    private final fh qh;
    private final C1137a tI;

    @ey
    /* renamed from: com.google.android.gms.internal.ff.a */
    public static final class C1145a extends ff {
        private final Context mContext;

        public C1145a(Context context, fh fhVar, C1137a c1137a) {
            super(fhVar, c1137a);
            this.mContext = context;
        }

        public final void cJ() {
        }

        public final fl cK() {
            Bundle bN = ga.bN();
            return fq.m4632a(this.mContext, new bm(bN.getString("gads:sdk_core_location"), bN.getString("gads:sdk_core_experiment_id"), bN.getString("gads:block_autoclicks_experiment_id"), bN.getString("gads:spam_app_context:experiment_id")), new co(), new fx());
        }
    }

    @ey
    /* renamed from: com.google.android.gms.internal.ff.b */
    public static final class C1146b extends ff implements ConnectionCallbacks, OnConnectionFailedListener {
        private final Object mH;
        private final C1137a tI;
        private final fg tJ;

        public C1146b(Context context, fh fhVar, C1137a c1137a) {
            super(fhVar, c1137a);
            this.mH = new Object();
            this.tI = c1137a;
            this.tJ = new fg(context, this, this, fhVar.lO.wU);
            this.tJ.connect();
        }

        public final void cJ() {
            synchronized (this.mH) {
                if (this.tJ.isConnected() || this.tJ.isConnecting()) {
                    this.tJ.disconnect();
                }
            }
        }

        public final fl cK() {
            fl cL;
            synchronized (this.mH) {
                try {
                    cL = this.tJ.cL();
                } catch (IllegalStateException e) {
                    cL = null;
                    return cL;
                } catch (DeadObjectException e2) {
                    cL = null;
                    return cL;
                }
            }
            return cL;
        }

        public final void onConnected(Bundle bundle) {
            start();
        }

        public final void onConnectionFailed(ConnectionResult connectionResult) {
            this.tI.m4562a(new fj(0));
        }

        public final void onConnectionSuspended(int i) {
            gr.m4769S("Disconnected from remote ad request service.");
        }
    }

    public ff(fh fhVar, C1137a c1137a) {
        this.qh = fhVar;
        this.tI = c1137a;
    }

    private static fj m4596a(fl flVar, fh fhVar) {
        fj fjVar = null;
        try {
            fjVar = flVar.m4606b(fhVar);
        } catch (Throwable e) {
            gr.m4777d("Could not fetch ad response from ad request service.", e);
        } catch (Throwable e2) {
            gr.m4777d("Could not fetch ad response from ad request service due to an Exception.", e2);
        } catch (Throwable e22) {
            gr.m4777d("Could not fetch ad response from ad request service due to an Exception.", e22);
        } catch (Throwable e222) {
            ga.m4690e(e222);
        }
        return fjVar;
    }

    public abstract void cJ();

    public abstract fl cK();

    public final void cx() {
        try {
            fj fjVar;
            fl cK = cK();
            if (cK == null) {
                fjVar = new fj(0);
            } else {
                fjVar = m4596a(cK, this.qh);
                if (fjVar == null) {
                    fjVar = new fj(0);
                }
            }
            cJ();
            this.tI.m4562a(fjVar);
        } catch (Throwable th) {
            cJ();
        }
    }

    public final void onStop() {
        cJ();
    }
}
