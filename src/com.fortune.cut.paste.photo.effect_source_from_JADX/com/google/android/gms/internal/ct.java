package com.google.android.gms.internal;

import com.google.android.gms.internal.cv.C1065a;
import com.google.android.gms.internal.da.C1063a;

@ey
public final class ct extends C1063a {
    private final Object mH;
    private C1065a qD;
    private cs qE;

    public ct() {
        this.mH = new Object();
    }

    public final void m4366a(cs csVar) {
        synchronized (this.mH) {
            this.qE = csVar;
        }
    }

    public final void m4367a(C1065a c1065a) {
        synchronized (this.mH) {
            this.qD = c1065a;
        }
    }

    public final void onAdClicked() {
        synchronized (this.mH) {
            if (this.qE != null) {
                this.qE.ai();
            }
        }
    }

    public final void onAdClosed() {
        synchronized (this.mH) {
            if (this.qE != null) {
                this.qE.aj();
            }
        }
    }

    public final void onAdFailedToLoad(int i) {
        synchronized (this.mH) {
            if (this.qD != null) {
                this.qD.m4368k(i == 3 ? 1 : 2);
                this.qD = null;
            }
        }
    }

    public final void onAdLeftApplication() {
        synchronized (this.mH) {
            if (this.qE != null) {
                this.qE.ak();
            }
        }
    }

    public final void onAdLoaded() {
        synchronized (this.mH) {
            if (this.qD != null) {
                this.qD.m4368k(0);
                this.qD = null;
                return;
            }
            if (this.qE != null) {
                this.qE.am();
            }
        }
    }

    public final void onAdOpened() {
        synchronized (this.mH) {
            if (this.qE != null) {
                this.qE.al();
            }
        }
    }
}
