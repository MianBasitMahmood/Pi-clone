package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.C0139j;
import com.chartboost.sdk.Libraries.CBUtility;

public final class aj extends am {
    private LinearLayout f432b;
    private bj f433c;
    private TextView f434d;

    public aj(Context context, ai aiVar) {
        super(context, aiVar);
    }

    protected final View m741a() {
        Context context = getContext();
        int round = Math.round(getContext().getResources().getDisplayMetrics().density * 8.0f);
        this.f432b = new LinearLayout(context);
        this.f432b.setOrientation(0);
        this.f432b.setGravity(17);
        int a = CBUtility.m109a(36, context);
        this.f433c = new bj(context);
        this.f433c.setPadding(round, round, round, round);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(a, a);
        this.f433c.setScaleType(ScaleType.FIT_CENTER);
        this.f434d = new TextView(context);
        this.f434d.setPadding(round / 2, round, round, round);
        this.f434d.setTextColor(-15264491);
        this.f434d.setTextSize(2, 16.0f);
        this.f434d.setTypeface(null, 1);
        this.f434d.setGravity(17);
        this.f432b.addView(this.f433c, layoutParams);
        this.f432b.addView(this.f434d, new LinearLayout.LayoutParams(-2, -1));
        return this.f432b;
    }

    public final void m742a(C0139j c0139j) {
        this.f433c.m814a(c0139j);
        this.f433c.setScaleType(ScaleType.FIT_CENTER);
    }

    public final void m743a(String str) {
        this.f434d.setText(str);
    }

    protected final int m744b() {
        return 48;
    }
}
