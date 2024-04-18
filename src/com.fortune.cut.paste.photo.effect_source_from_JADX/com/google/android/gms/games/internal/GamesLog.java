package com.google.android.gms.games.internal;

import com.google.android.gms.internal.jp;

public final class GamesLog {
    private static final jp Qp;

    static {
        Qp = new jp("Games");
    }

    private GamesLog() {
    }

    public static void m3238a(String str, String str2, Throwable th) {
        Qp.m5112a(str, str2, th);
    }

    public static void m3239b(String str, String str2, Throwable th) {
        Qp.m5113b(str, str2, th);
    }

    public static void m3240c(String str, String str2, Throwable th) {
        Qp.m5114c(str, str2, th);
    }

    public static void m3241n(String str, String str2) {
        Qp.m5116n(str, str2);
    }

    public static void m3242o(String str, String str2) {
        Qp.m5117o(str, str2);
    }

    public static void m3243p(String str, String str2) {
        Qp.m5118p(str, str2);
    }
}
