package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View;

public final class bi extends View {
    private boolean f734a;

    public bi(Context context) {
        super(context);
        this.f734a = false;
        setFocusable(false);
        setBackgroundColor(-1442840576);
    }

    public final void m1110a() {
        if (!this.f734a) {
            bh.m1105a(true, this);
            this.f734a = true;
        }
    }
}
