package com.google.android.gms.internal;

import android.content.Intent;

@ey
public class ek {
    private final String oK;

    public ek(String str) {
        this.oK = str;
    }

    public boolean m4518a(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String e = ei.m4515e(intent);
        String f = ei.m4516f(intent);
        if (e == null || f == null) {
            return false;
        }
        if (!str.equals(ei.m4511D(e))) {
            gr.m4773W("Developer payload not match.");
            return false;
        } else if (this.oK == null || el.m4521b(this.oK, e, f)) {
            return true;
        } else {
            gr.m4773W("Fail to verify signature.");
            return false;
        }
    }

    public String cC() {
        return gi.dx();
    }
}
