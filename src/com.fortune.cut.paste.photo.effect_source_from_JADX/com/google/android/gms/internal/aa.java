package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

@ey
class aa implements ac {
    private gu mt;

    public aa(gu guVar) {
        this.mt = guVar;
    }

    public void m4109a(af afVar, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        this.mt.m4787a("onAdVisibilityChanged", hashMap);
    }
}
