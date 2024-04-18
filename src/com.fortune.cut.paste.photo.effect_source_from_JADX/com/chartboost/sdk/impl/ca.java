package com.chartboost.sdk.impl;

import java.util.regex.Pattern;

public class ca {
    private static Pattern f804a;

    /* renamed from: com.chartboost.sdk.impl.ca.a */
    public static class C0296a extends RuntimeException {
        final String f803a;

        C0296a(String str) {
            super(str);
            this.f803a = str;
        }

        public String toString() {
            return this.f803a;
        }
    }

    public static void m1184a(int i, int i2) {
        if (i != i2) {
            throw new C0296a(i + " != " + i2);
        }
    }

    static {
        f804a = Pattern.compile("\\s+", 40);
    }
}
