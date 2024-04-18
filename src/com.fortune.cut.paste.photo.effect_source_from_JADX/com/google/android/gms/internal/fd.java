package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.fc.C1139a;
import com.google.android.gms.internal.fy.C1160a;
import com.google.android.gms.internal.gv.C1012a;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

@ey
public class fd extends gf implements C1012a {
    private final cy lA;
    private final Context mContext;
    private final Object mH;
    private final gu mo;
    private cr qi;
    private final C1139a tA;
    private final C1160a tB;
    private boolean tC;
    private cp tD;
    private cv tE;
    private final Object tj;
    private fj tn;

    /* renamed from: com.google.android.gms.internal.fd.1 */
    class C11401 implements Runnable {
        final /* synthetic */ fd tF;

        C11401(fd fdVar) {
            this.tF = fdVar;
        }

        public void run() {
            this.tF.onStop();
        }
    }

    /* renamed from: com.google.android.gms.internal.fd.2 */
    class C11412 implements Runnable {
        final /* synthetic */ fd tF;
        final /* synthetic */ fy tG;

        C11412(fd fdVar, fy fyVar) {
            this.tF = fdVar;
            this.tG = fyVar;
        }

        public void run() {
            synchronized (this.tF.mH) {
                this.tF.tA.m4581a(this.tG);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.fd.3 */
    class C11423 implements Runnable {
        final /* synthetic */ fd tF;

        C11423(fd fdVar) {
            this.tF = fdVar;
        }

        public void run() {
            synchronized (this.tF.mH) {
                if (this.tF.tn.errorCode != -2) {
                    return;
                }
                this.tF.mo.dD().m4797a(this.tF);
                if (this.tF.tn.errorCode == -3) {
                    gr.m4772V("Loading URL in WebView: " + this.tF.tn.sg);
                    this.tF.mo.loadUrl(this.tF.tn.sg);
                } else {
                    gr.m4772V("Loading HTML in WebView.");
                    this.tF.mo.loadDataWithBaseURL(gi.m4715L(this.tF.tn.sg), this.tF.tn.tU, "text/html", "UTF-8", null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.fd.4 */
    class C11434 implements Runnable {
        final /* synthetic */ fd tF;
        final /* synthetic */ fb tH;

        C11434(fd fdVar, fb fbVar) {
            this.tF = fdVar;
            this.tH = fbVar;
        }

        public void run() {
            synchronized (this.tF.mH) {
                if (this.tF.tn.errorCode != -2) {
                    return;
                }
                this.tF.mo.dD().m4797a(this.tF);
                this.tH.m4580b(this.tF.tn);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.fd.a */
    private static final class C1144a extends Exception {
        private final int tq;

        public C1144a(String str, int i) {
            super(str);
            this.tq = i;
        }

        public final int getErrorCode() {
            return this.tq;
        }
    }

    public fd(Context context, C1160a c1160a, gu guVar, cy cyVar, C1139a c1139a) {
        this.tj = new Object();
        this.mH = new Object();
        this.tC = false;
        this.mContext = context;
        this.tB = c1160a;
        this.tn = c1160a.vK;
        this.mo = guVar;
        this.lA = cyVar;
        this.tA = c1139a;
        this.qi = c1160a.vE;
    }

    private void m4584a(fh fhVar, long j) throws C1144a {
        synchronized (this.tj) {
            this.tD = new cp(this.mContext, fhVar, this.lA, this.qi);
        }
        this.tE = this.tD.m4363a(j, 60000);
        switch (this.tE.qO) {
            case WalletFragmentState.UNKNOWN /*0*/:
            case DataEvent.TYPE_CHANGED /*1*/:
                throw new C1144a("No fill from any mediation ad networks.", 3);
            default:
                throw new C1144a("Unexpected mediation result: " + this.tE.qO, 0);
        }
    }

    private boolean m4587c(long j) throws C1144a {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.mH.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new C1144a("Ad request cancelled.", -1);
        }
    }

    private void m4589f(long j) throws C1144a {
        gq.wR.post(new C11423(this));
        m4590h(j);
    }

    private void m4590h(long j) throws C1144a {
        while (m4587c(j)) {
            if (this.tC) {
                return;
            }
        }
        throw new C1144a("Timed out waiting for WebView to finish loading.", 2);
    }

    public void m4591a(gu guVar) {
        synchronized (this.mH) {
            gr.m4769S("WebView finished loading.");
            this.tC = true;
            this.mH.notify();
        }
    }

    public void cx() {
        synchronized (this.mH) {
            gr.m4769S("AdRendererBackgroundTask started.");
            fh fhVar = this.tB.vJ;
            int i = this.tB.errorCode;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (this.tn.tW) {
                    m4584a(fhVar, elapsedRealtime);
                } else if (this.tn.uc) {
                    m4592g(elapsedRealtime);
                } else {
                    m4589f(elapsedRealtime);
                }
            } catch (C1144a e) {
                i = e.getErrorCode();
                if (i == 3 || i == -1) {
                    gr.m4771U(e.getMessage());
                } else {
                    gr.m4773W(e.getMessage());
                }
                if (this.tn == null) {
                    this.tn = new fj(i);
                } else {
                    this.tn = new fj(i, this.tn.qA);
                }
                gq.wR.post(new C11401(this));
            }
            gq.wR.post(new C11412(this, new fy(fhVar.tL, this.mo, this.tn.qw, i, this.tn.qx, this.tn.tY, this.tn.orientation, this.tn.qA, fhVar.tO, this.tn.tW, this.tE != null ? this.tE.qP : null, this.tE != null ? this.tE.qQ : null, this.tE != null ? this.tE.qR : AdMobAdapter.class.getName(), this.qi, this.tE != null ? this.tE.qS : null, this.tn.tX, this.tB.lS, this.tn.tV, this.tB.vG, this.tn.ua, this.tn.ub, this.tB.vD, null)));
        }
    }

    protected void m4592g(long j) throws C1144a {
        int i;
        int i2;
        ay ac = this.mo.ac();
        if (ac.oq) {
            i = this.mContext.getResources().getDisplayMetrics().widthPixels;
            i2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
        } else {
            i = ac.widthPixels;
            i2 = ac.heightPixels;
        }
        fb fbVar = new fb(this, this.mo, i, i2);
        gq.wR.post(new C11434(this, fbVar));
        m4590h(j);
        if (fbVar.cH()) {
            gr.m4769S("Ad-Network indicated no fill with passback URL.");
            throw new C1144a("AdNetwork sent passback url", 3);
        } else if (!fbVar.cI()) {
            throw new C1144a("AdNetwork timed out", 2);
        }
    }

    public void onStop() {
        synchronized (this.tj) {
            this.mo.stopLoading();
            gi.m4729a(this.mo);
            if (this.tD != null) {
                this.tD.cancel();
            }
        }
    }
}
