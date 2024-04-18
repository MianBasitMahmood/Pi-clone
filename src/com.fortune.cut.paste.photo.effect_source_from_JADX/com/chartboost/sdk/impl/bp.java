package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.chartboost.sdk.C0177f.C0176a;
import com.chartboost.sdk.Model.C0148a;

public final class bp extends RelativeLayout {
    private C0176a f757a;
    private bi f758b;
    private bi f759c;
    private bo f760d;
    private C0148a f761e;

    public bp(Context context, C0148a c0148a) {
        super(context);
        this.f761e = null;
        this.f761e = c0148a;
        this.f758b = new bi(context);
        addView(this.f758b, new LayoutParams(-1, -1));
        this.f759c = new bi(context);
        addView(this.f759c, new LayoutParams(-1, -1));
        this.f759c.setVisibility(8);
    }

    public final void m1123a() {
        if (this.f757a == null) {
            this.f757a = this.f761e.m305l();
            if (this.f757a != null) {
                addView(this.f757a, new LayoutParams(-1, -1));
                this.f757a.m493a();
            }
        }
        m1125c();
    }

    public final void m1124b() {
        boolean z = !this.f761e.f199j;
        this.f761e.f199j = true;
        if (this.f760d == null) {
            this.f760d = new bo(getContext());
            this.f760d.setVisibility(8);
            addView(this.f760d, new LayoutParams(-1, -1));
        } else {
            this.f759c.bringToFront();
            this.f759c.setVisibility(0);
            this.f759c.m1110a();
            bh.m1105a(false, this.f758b);
            this.f760d.bringToFront();
            this.f760d.m1122a();
        }
        if (!m1129g()) {
            this.f760d.setVisibility(0);
            if (z) {
                m1127e().m1110a();
                bh.m1105a(true, this.f760d);
            }
        }
    }

    public final void m1125c() {
        if (this.f760d != null) {
            this.f760d.clearAnimation();
            this.f760d.setVisibility(8);
        }
    }

    public final void m1126d() {
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public final bi m1127e() {
        return this.f758b;
    }

    public final View m1128f() {
        return this.f757a;
    }

    public final boolean m1129g() {
        return this.f760d != null && this.f760d.getVisibility() == 0;
    }

    public final C0148a m1130h() {
        return this.f761e;
    }
}
