package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.chartboost.sdk.Tracking.C0151a;
import com.google.android.gms.cast.TextTrackStyle;

public final class ag extends am {
    private LinearLayout f361b;
    private LinearLayout f362c;
    private bj f363d;
    private bk f364e;
    private TextView f365f;
    private TextView f366g;

    /* renamed from: com.chartboost.sdk.impl.ag.1 */
    class C01901 extends bk {
        final /* synthetic */ ag f357a;

        C01901(ag agVar, Context context) {
            this.f357a = agVar;
            super(context);
        }

        protected void m647a(MotionEvent motionEvent) {
            this.f357a.a.m734p().m694h();
            C0151a.m332a("install-click", this.f357a.a.f423r, this.f357a.a.n, Math.round(motionEvent.getX()), Math.round(motionEvent.getY()));
        }
    }

    public ag(Context context, ai aiVar) {
        super(context, aiVar);
    }

    protected final View m654a() {
        Context context = getContext();
        int round = Math.round(getContext().getResources().getDisplayMetrics().density * 6.0f);
        this.f361b = new LinearLayout(context);
        this.f361b.setOrientation(0);
        this.f361b.setGravity(17);
        this.f362c = new LinearLayout(context);
        this.f362c.setOrientation(1);
        this.f362c.setGravity(19);
        this.f363d = new bj(context);
        this.f363d.setPadding(round, round, round, round);
        if (this.a.f410F.m270e()) {
            this.f363d.m814a(this.a.f410F);
        }
        this.f364e = new C01901(this, context);
        this.f364e.setPadding(round, round, round, round);
        if (this.a.f411G.m270e()) {
            this.f364e.m643a(this.a.f411G);
        }
        this.f365f = new TextView(getContext());
        this.f365f.setTextColor(-15264491);
        this.f365f.setTypeface(null, 1);
        this.f365f.setGravity(3);
        this.f365f.setPadding(round, round, round, round / 2);
        this.f366g = new TextView(getContext());
        this.f366g.setTextColor(-15264491);
        this.f366g.setTypeface(null, 1);
        this.f366g.setGravity(3);
        this.f366g.setPadding(round, 0, round, round);
        this.f365f.setTextSize(2, 14.0f);
        this.f366g.setTextSize(2, 11.0f);
        this.f362c.addView(this.f365f);
        this.f362c.addView(this.f366g);
        this.f361b.addView(this.f363d);
        this.f361b.addView(this.f362c, new LayoutParams(0, -2, TextTrackStyle.DEFAULT_FONT_SCALE));
        this.f361b.addView(this.f364e);
        return this.f361b;
    }

    public final void m655a(String str, String str2) {
        this.f365f.setText(str);
        this.f366g.setText(str2);
    }

    protected final int m656b() {
        return 72;
    }
}
