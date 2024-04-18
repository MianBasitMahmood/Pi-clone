package com.chartboost.sdk.impl;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.cast.Cast;

public class ck implements ch {
    static final String[] f838a;
    private byte[] f839b;
    private byte[] f840c;
    private cq f841d;

    public ck() {
        this.f839b = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
        this.f840c = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
        this.f841d = new cq();
    }

    static {
        f838a = new String[Cast.MAX_NAMESPACE_LENGTH];
        m1203a((byte) 48, (byte) 57);
        m1203a((byte) 97, (byte) 122);
        m1203a((byte) 65, (byte) 90);
    }

    static void m1203a(byte b, byte b2) {
        while (b < b2) {
            f838a[b] = "" + ((char) b);
            b = (byte) (b + 1);
        }
    }
}
