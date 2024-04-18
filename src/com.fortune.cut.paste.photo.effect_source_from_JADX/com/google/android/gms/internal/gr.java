package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

@ey
public final class gr {
    public static void m4769S(String str) {
        if (m4778v(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }

    public static void m4770T(String str) {
        if (m4778v(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    public static void m4771U(String str) {
        if (m4778v(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    public static void m4772V(String str) {
        if (m4778v(2)) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static void m4773W(String str) {
        if (m4778v(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }

    public static void m4774a(String str, Throwable th) {
        if (m4778v(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    public static void m4775b(String str, Throwable th) {
        if (m4778v(6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
    }

    public static void m4776c(String str, Throwable th) {
        if (m4778v(4)) {
            Log.i(AdRequest.LOGTAG, str, th);
        }
    }

    public static void m4777d(String str, Throwable th) {
        if (m4778v(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    public static boolean m4778v(int i) {
        return (i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i)) && i != 2;
    }
}
