package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.dynamic.C0752d;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.internal.bv.C1036a;
import com.google.android.gms.internal.bx.C1037a;

@ey
public class bu extends C1037a implements C1036a {
    private final Object mH;
    private final String pB;
    private final Drawable pC;
    private final String pD;
    private final String pF;
    private bv pJ;
    private final Drawable pK;
    private final String pL;

    public bu(String str, Drawable drawable, String str2, Drawable drawable2, String str3, String str4) {
        this.mH = new Object();
        this.pB = str;
        this.pC = drawable;
        this.pD = str2;
        this.pK = drawable2;
        this.pF = str3;
        this.pL = str4;
    }

    public void m4274a(bv bvVar) {
        synchronized (this.mH) {
            this.pJ = bvVar;
        }
    }

    public void aw() {
        synchronized (this.mH) {
            if (this.pJ == null) {
                gr.m4770T("Attempt to record impression before content ad initialized.");
                return;
            }
            this.pJ.aw();
        }
    }

    public String bB() {
        return this.pB;
    }

    public C0752d bC() {
        return C0755e.m2594k(this.pC);
    }

    public String bE() {
        return this.pF;
    }

    public C0752d bI() {
        return C0755e.m2594k(this.pK);
    }

    public String bJ() {
        return this.pL;
    }

    public String getBody() {
        return this.pD;
    }

    public void m4275j(int i) {
        synchronized (this.mH) {
            if (this.pJ == null) {
                gr.m4770T("Attempt to perform click before content ad initialized.");
                return;
            }
            this.pJ.m4276b("1", i);
        }
    }
}
