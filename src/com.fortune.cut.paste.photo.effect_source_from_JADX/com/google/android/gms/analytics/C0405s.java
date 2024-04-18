package com.google.android.gms.analytics;

/* renamed from: com.google.android.gms.analytics.s */
public final class C0405s {
    public static String m1554A(int i) {
        return C0405s.m1560d("&pr", i);
    }

    public static String m1555B(int i) {
        return C0405s.m1560d("&promo", i);
    }

    public static String m1556C(int i) {
        return C0405s.m1560d("pi", i);
    }

    public static String m1557D(int i) {
        return C0405s.m1560d("&il", i);
    }

    public static String m1558E(int i) {
        return C0405s.m1560d("cd", i);
    }

    public static String m1559F(int i) {
        return C0405s.m1560d("cm", i);
    }

    private static String m1560d(String str, int i) {
        if (i > 0) {
            return str + i;
        }
        ae.m1485T("index out of range for " + str + " (" + i + ")");
        return "";
    }

    static String m1561y(int i) {
        return C0405s.m1560d("&cd", i);
    }

    static String m1562z(int i) {
        return C0405s.m1560d("&cm", i);
    }
}
