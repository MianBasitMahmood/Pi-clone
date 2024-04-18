package com.p000a.p001a.p002a;

import com.google.android.gms.cast.TextTrackStyle;

/* renamed from: com.a.a.a.a */
public final class ContrastFilter extends TransferFilter {
    private float f13f;
    private float f14g;

    public ContrastFilter() {
        this.f13f = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.f14g = TextTrackStyle.DEFAULT_FONT_SCALE;
    }

    protected final float m17a(float f) {
        return (((this.f13f * f) - 0.5f) * this.f14g) + 0.5f;
    }

    public final void m18b(float f) {
        this.f13f = f;
        this.e = false;
    }

    public final void m19c(float f) {
        this.f14g = f;
        this.e = false;
    }

    public final String toString() {
        return "Colors/Contrast...";
    }
}
