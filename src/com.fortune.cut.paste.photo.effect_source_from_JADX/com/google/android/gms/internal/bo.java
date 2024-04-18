package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.dynamic.C0752d;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.internal.bq.C1031a;

@ey
public final class bo extends C1031a {
    private final C1493w px;
    private final String py;
    private final String pz;

    public bo(C1493w c1493w, String str, String str2) {
        this.px = c1493w;
        this.py = str;
        this.pz = str2;
    }

    public final void m4263a(C0752d c0752d) {
        if (c0752d != null) {
            this.px.m6041b((View) C0755e.m2593f(c0752d));
        }
    }

    public final void av() {
        this.px.av();
    }

    public final void aw() {
        this.px.aw();
    }

    public final String bA() {
        return this.pz;
    }

    public final String bz() {
        return this.py;
    }
}
