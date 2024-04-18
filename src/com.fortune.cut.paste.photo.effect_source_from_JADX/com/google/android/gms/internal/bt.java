package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.dynamic.C0752d;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.internal.bv.C1036a;
import com.google.android.gms.internal.bw.C1035a;

@ey
public class bt extends C1035a implements C1036a {
    private final Object mH;
    private final String pB;
    private final Drawable pC;
    private final String pD;
    private final Drawable pE;
    private final String pF;
    private final double pG;
    private final String pH;
    private final String pI;
    private bv pJ;

    public bt(String str, Drawable drawable, String str2, Drawable drawable2, String str3, double d, String str4, String str5) {
        this.mH = new Object();
        this.pB = str;
        this.pC = drawable;
        this.pD = str2;
        this.pE = drawable2;
        this.pF = str3;
        this.pG = d;
        this.pH = str4;
        this.pI = str5;
    }

    public void m4271a(bv bvVar) {
        synchronized (this.mH) {
            this.pJ = bvVar;
        }
    }

    public void aw() {
        synchronized (this.mH) {
            if (this.pJ == null) {
                gr.m4770T("Attempt to record impression before app install ad initialized.");
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

    public C0752d bD() {
        return C0755e.m2594k(this.pE);
    }

    public String bE() {
        return this.pF;
    }

    public double bF() {
        return this.pG;
    }

    public String bG() {
        return this.pH;
    }

    public String bH() {
        return this.pI;
    }

    public String getBody() {
        return this.pD;
    }

    public void m4272j(int i) {
        synchronized (this.mH) {
            if (this.pJ == null) {
                gr.m4770T("Attempt to perform click before app install ad initialized.");
                return;
            }
            this.pJ.m4276b("2", i);
        }
    }
}
