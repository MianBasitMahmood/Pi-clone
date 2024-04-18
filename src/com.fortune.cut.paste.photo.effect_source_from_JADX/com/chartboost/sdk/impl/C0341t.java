package com.chartboost.sdk.impl;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.chartboost.sdk.impl.t */
public class C0341t {
    public static String f947a;
    public static boolean f948b;

    /* renamed from: com.chartboost.sdk.impl.t.a */
    static class C0340a {
        public static final boolean f944a;
        private final List<C0339a> f945b;
        private boolean f946c;

        /* renamed from: com.chartboost.sdk.impl.t.a.a */
        private static class C0339a {
            public final String f941a;
            public final long f942b;
            public final long f943c;

            public C0339a(String str, long j, long j2) {
                this.f941a = str;
                this.f942b = j;
                this.f943c = j2;
            }
        }

        C0340a() {
            this.f945b = new ArrayList();
            this.f946c = false;
        }

        static {
            f944a = C0341t.f948b;
        }

        public synchronized void m1366a(String str, long j) {
            if (this.f946c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f945b.add(new C0339a(str, j, SystemClock.elapsedRealtime()));
        }

        public synchronized void m1365a(String str) {
            this.f946c = true;
            if (m1364a() > 0) {
                long j = ((C0339a) this.f945b.get(0)).f943c;
                C0341t.m1369b("(%-4d ms) %s", Long.valueOf(r2), str);
                long j2 = j;
                for (C0339a c0339a : this.f945b) {
                    C0341t.m1369b("(+%-4d) [%2d] %s", Long.valueOf(c0339a.f943c - j2), Long.valueOf(c0339a.f942b), c0339a.f941a);
                    j2 = c0339a.f943c;
                }
            }
        }

        protected void finalize() throws Throwable {
            if (!this.f946c) {
                m1365a("Request on the loose");
                C0341t.m1370c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        private long m1364a() {
            if (this.f945b.size() == 0) {
                return 0;
            }
            return ((C0339a) this.f945b.get(this.f945b.size() - 1)).f943c - ((C0339a) this.f945b.get(0)).f943c;
        }
    }

    static {
        String str = "Volley";
        f947a = str;
        f948b = Log.isLoggable(str, 2);
    }

    public static void m1367a(String str, Object... objArr) {
        if (f948b) {
            Log.v(f947a, C0341t.m1371d(str, objArr));
        }
    }

    public static void m1369b(String str, Object... objArr) {
        Log.d(f947a, C0341t.m1371d(str, objArr));
    }

    public static void m1370c(String str, Object... objArr) {
        Log.e(f947a, C0341t.m1371d(str, objArr));
    }

    public static void m1368a(Throwable th, String str, Object... objArr) {
        Log.e(f947a, C0341t.m1371d(str, objArr), th);
    }

    private static String m1371d(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str3 = "<unknown>";
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClass().equals(C0341t.class)) {
                str3 = stackTrace[i].getClassName();
                str3 = str3.substring(str3.lastIndexOf(46) + 1);
                str2 = str3.substring(str3.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            }
        }
        str2 = str3;
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
