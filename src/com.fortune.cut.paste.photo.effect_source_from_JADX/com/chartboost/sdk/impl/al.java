package com.chartboost.sdk.impl;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chartboost.sdk.C0177f;
import com.google.android.gms.cast.TextTrackStyle;

public final class al extends LinearLayout {
    private ai f446a;
    private LinearLayout f447b;
    private bj f448c;
    private TextView f449d;
    private bk f450e;
    private int f451f;

    /* renamed from: com.chartboost.sdk.impl.al.1 */
    class C02031 extends bk {
        final /* synthetic */ al f445a;

        C02031(al alVar, Context context) {
            this.f445a = alVar;
            super(context);
        }

        protected void m755a(MotionEvent motionEvent) {
            this.f445a.f450e.setEnabled(false);
            this.f445a.f446a.m734p().m695i();
        }
    }

    public al(Context context, ai aiVar) {
        super(context);
        this.f451f = ExploreByTouchHelper.INVALID_ID;
        this.f446a = aiVar;
        m757a(context);
    }

    private void m757a(Context context) {
        Context context2 = getContext();
        int round = Math.round(getContext().getResources().getDisplayMetrics().density * 8.0f);
        setOrientation(1);
        setGravity(17);
        this.f447b = new LinearLayout(context2);
        this.f447b.setGravity(17);
        this.f447b.setOrientation(0);
        this.f447b.setPadding(round, round, round, round);
        this.f448c = new bj(context2);
        this.f448c.setScaleType(ScaleType.FIT_CENTER);
        this.f448c.setPadding(0, 0, round, 0);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f446a.m669a(layoutParams, this.f446a.f408D, TextTrackStyle.DEFAULT_FONT_SCALE);
        this.f449d = new TextView(getContext());
        this.f449d.setTextColor(-1);
        this.f449d.setTypeface(null, 1);
        this.f449d.setGravity(17);
        this.f449d.setTextSize(2, C0177f.m502a(context) ? 26.0f : 16.0f);
        this.f447b.addView(this.f448c, layoutParams);
        this.f447b.addView(this.f449d, new LinearLayout.LayoutParams(-2, -2));
        this.f450e = new C02031(this, getContext());
        this.f450e.setPadding(0, 0, 0, round);
        this.f450e.m642a(ScaleType.FIT_CENTER);
        this.f450e.setPadding(round, round, round, round);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.f446a.m669a(layoutParams2, this.f446a.f407C, TextTrackStyle.DEFAULT_FONT_SCALE);
        if (this.f446a.f408D.m270e()) {
            this.f448c.m814a(this.f446a.f408D);
        }
        if (this.f446a.f407C.m270e()) {
            this.f450e.m643a(this.f446a.f407C);
        }
        addView(this.f447b, new LinearLayout.LayoutParams(-2, -2));
        addView(this.f450e, layoutParams2);
        m759a();
    }

    public final void m761a(boolean z) {
        setBackgroundColor(z ? ViewCompat.MEASURED_STATE_MASK : this.f451f);
    }

    public final void m760a(String str, int i) {
        this.f449d.setText(str);
        this.f451f = i;
        m761a(this.f446a.m736r());
    }

    public final void m759a() {
        m761a(this.f446a.m736r());
    }
}
