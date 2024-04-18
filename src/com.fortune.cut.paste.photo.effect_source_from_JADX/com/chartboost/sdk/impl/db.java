package com.chartboost.sdk.impl;

public class db {

    /* renamed from: com.chartboost.sdk.impl.db.a */
    static class C0316a extends IllegalArgumentException {
        C0316a(String str) {
            super(str + " should not be null!");
        }
    }

    public static <T> T m1322a(String str, T t) throws IllegalArgumentException {
        if (t != null) {
            return t;
        }
        throw new C0316a(str);
    }
}
