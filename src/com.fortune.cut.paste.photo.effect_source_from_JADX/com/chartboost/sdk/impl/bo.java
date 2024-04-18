package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class bo extends LinearLayout {
    private TextView f755a;
    private bq f756b;

    public bo(Context context) {
        super(context);
        m1121a(context);
    }

    private void m1121a(Context context) {
        setGravity(17);
        this.f755a = new TextView(getContext());
        this.f755a.setTextColor(-1);
        this.f755a.setTextSize(2, 16.0f);
        this.f755a.setTypeface(null, 1);
        this.f755a.setText("Loading...");
        this.f755a.setGravity(17);
        this.f756b = new bq(getContext());
        addView(this.f755a);
        addView(this.f756b);
        m1122a();
    }

    public final void m1122a() {
        removeView(this.f755a);
        removeView(this.f756b);
        float f = getContext().getResources().getDisplayMetrics().density;
        int round = Math.round(20.0f * f);
        setOrientation(1);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(round, round, round, 0);
        addView(this.f755a, layoutParams);
        layoutParams = new LinearLayout.LayoutParams(-1, Math.round(f * 32.0f));
        layoutParams.setMargins(round, round, round, round);
        addView(this.f756b, layoutParams);
    }
}
