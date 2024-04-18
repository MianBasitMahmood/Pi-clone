package com.chartboost.sdk.impl;

import android.content.Intent;

/* renamed from: com.chartboost.sdk.impl.a */
public class C0179a extends C0178s {
    private Intent f316b;

    public C0179a(C0328i c0328i) {
        super(c0328i);
    }

    public String getMessage() {
        if (this.f316b != null) {
            return "User needs to (re)enter credentials.";
        }
        return super.getMessage();
    }
}
