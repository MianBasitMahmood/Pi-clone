package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.internal.cv.C1065a;

@ey
public final class cu implements C1065a {
    private final cy lA;
    private final Context mContext;
    private final Object mH;
    private final av mw;
    private final String qF;
    private final long qG;
    private final cq qH;
    private final ay qI;
    private final gs qJ;
    private cz qK;
    private int qL;

    /* renamed from: com.google.android.gms.internal.cu.1 */
    class C10641 implements Runnable {
        final /* synthetic */ ct qM;
        final /* synthetic */ cu qN;

        C10641(cu cuVar, ct ctVar) {
            this.qN = cuVar;
            this.qM = ctVar;
        }

        public void run() {
            synchronized (this.qN.mH) {
                if (this.qN.qL != -2) {
                    return;
                }
                this.qN.qK = this.qN.bP();
                if (this.qN.qK == null) {
                    this.qN.m4379k(4);
                    return;
                }
                this.qM.m4367a(this.qN);
                this.qN.m4372a(this.qM);
            }
        }
    }

    public cu(Context context, String str, cy cyVar, cr crVar, cq cqVar, av avVar, ay ayVar, gs gsVar) {
        this.mH = new Object();
        this.qL = -2;
        this.mContext = context;
        this.lA = cyVar;
        this.qH = cqVar;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.qF = bO();
        } else {
            this.qF = str;
        }
        this.qG = crVar.qv != -1 ? crVar.qv : 10000;
        this.mw = avVar;
        this.qI = ayVar;
        this.qJ = gsVar;
    }

    private void m4371a(long j, long j2, long j3, long j4) {
        while (this.qL == -2) {
            m4375b(j, j2, j3, j4);
        }
    }

    private void m4372a(ct ctVar) {
        try {
            if (this.qJ.wU < 4100000) {
                if (this.qI.oq) {
                    this.qK.m4391a(C0755e.m2594k(this.mContext), this.mw, this.qH.qt, ctVar);
                } else {
                    this.qK.m4393a(C0755e.m2594k(this.mContext), this.qI, this.mw, this.qH.qt, (da) ctVar);
                }
            } else if (this.qI.oq) {
                this.qK.m4392a(C0755e.m2594k(this.mContext), this.mw, this.qH.qt, this.qH.qn, (da) ctVar);
            } else {
                this.qK.m4394a(C0755e.m2594k(this.mContext), this.qI, this.mw, this.qH.qt, this.qH.qn, ctVar);
            }
        } catch (Throwable e) {
            gr.m4777d("Could not request ad from mediation adapter.", e);
            m4379k(5);
        }
    }

    private void m4375b(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        elapsedRealtime = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || elapsedRealtime <= 0) {
            gr.m4771U("Timed out waiting for adapter.");
            this.qL = 3;
            return;
        }
        try {
            this.mH.wait(Math.min(j5, elapsedRealtime));
        } catch (InterruptedException e) {
            this.qL = -1;
        }
    }

    private String bO() {
        try {
            if (!TextUtils.isEmpty(this.qH.qr)) {
                return this.lA.m4383y(this.qH.qr) ? "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter" : "com.google.ads.mediation.customevent.CustomEventAdapter";
            }
        } catch (RemoteException e) {
            gr.m4773W("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private cz bP() {
        gr.m4771U("Instantiating mediation adapter: " + this.qF);
        try {
            return this.lA.m4382x(this.qF);
        } catch (Throwable e) {
            gr.m4774a("Could not instantiate mediation adapter: " + this.qF, e);
            return null;
        }
    }

    public final cv m4378b(long j, long j2) {
        cv cvVar;
        synchronized (this.mH) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ct ctVar = new ct();
            gq.wR.post(new C10641(this, ctVar));
            m4371a(elapsedRealtime, this.qG, j, j2);
            cvVar = new cv(this.qH, this.qK, this.qF, ctVar, this.qL);
        }
        return cvVar;
    }

    public final void cancel() {
        synchronized (this.mH) {
            try {
                if (this.qK != null) {
                    this.qK.destroy();
                }
            } catch (Throwable e) {
                gr.m4777d("Could not destroy mediation adapter.", e);
            }
            this.qL = -1;
            this.mH.notify();
        }
    }

    public final void m4379k(int i) {
        synchronized (this.mH) {
            this.qL = i;
            this.mH.notify();
        }
    }
}
