package com.chartboost.sdk.impl;

import com.google.android.gms.cast.TextTrackStyle;

/* renamed from: com.chartboost.sdk.impl.d */
public class C0303d implements C0302p {
    private int f873a;
    private int f874b;
    private final int f875c;
    private final float f876d;

    public C0303d() {
        this(2500, 1, TextTrackStyle.DEFAULT_FONT_SCALE);
    }

    public C0303d(int i, int i2, float f) {
        this.f873a = i;
        this.f875c = i2;
        this.f876d = f;
    }

    public int m1296a() {
        return this.f873a;
    }

    public int m1298b() {
        return this.f874b;
    }

    public void m1297a(C0178s c0178s) throws C0178s {
        this.f874b++;
        this.f873a = (int) (((float) this.f873a) + (((float) this.f873a) * this.f876d));
        if (!m1299c()) {
            throw c0178s;
        }
    }

    protected boolean m1299c() {
        return this.f874b <= this.f875c;
    }
}
