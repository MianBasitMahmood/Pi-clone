package com.chartboost.sdk.Libraries;

import android.util.Log;
import com.chartboost.sdk.C0153b;

public final class CBLogging {
    public static Level f77a;
    private static String f78b;

    public enum Level {
        NONE,
        INTEGRATION,
        ALL
    }

    static {
        f77a = Level.INTEGRATION;
        f78b = "Chartboost SDK";
    }

    private static String m96a(Object obj) {
        String name = (obj == null || (obj instanceof String)) ? obj : obj.getClass().getName();
        return name;
    }

    private static boolean m100a() {
        return f77a == Level.ALL || (f77a == Level.INTEGRATION && CBUtility.m115a(C0153b.m400l()));
    }

    public static void m99a(String str) {
        if (m100a()) {
            Log.e(f78b, str);
        }
    }

    public static void m97a(Object obj, String str) {
        if (f77a == Level.ALL) {
            Log.d(m96a(obj), str);
        }
    }

    public static void m98a(Object obj, String str, Throwable th) {
        if (f77a == Level.ALL) {
            Log.d(m96a(obj), str, th);
        }
    }

    public static void m101b(Object obj, String str) {
        if (f77a == Level.ALL) {
            Log.e(m96a(obj), str);
        }
    }

    public static void m102b(Object obj, String str, Throwable th) {
        if (f77a == Level.ALL) {
            Log.e(m96a(obj), str, th);
        }
    }

    public static void m103c(Object obj, String str) {
        if (f77a == Level.ALL) {
            Log.v(m96a(obj), str);
        }
    }

    public static void m104c(Object obj, String str, Throwable th) {
        if (f77a == Level.ALL) {
            Log.v(m96a(obj), str, th);
        }
    }

    public static void m105d(Object obj, String str) {
        if (f77a == Level.ALL) {
            Log.w(m96a(obj), str);
        }
    }

    public static void m106d(Object obj, String str, Throwable th) {
        if (f77a == Level.ALL) {
            Log.w(m96a(obj), str, th);
        }
    }

    public static void m107e(Object obj, String str) {
        if (f77a == Level.ALL) {
            Log.i(m96a(obj), str);
        }
    }
}
