package com.google.android.gms.internal;

import android.content.Context;
import android.util.Log;

public final class jp {
    private final String Nq;

    public jp(String str) {
        this.Nq = (String) jx.m5223i(str);
    }

    public final void m5111a(Context context, String str, String str2, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < stackTrace.length && i < 2) {
            stringBuilder.append(stackTrace[i].toString());
            stringBuilder.append("\n");
            i++;
        }
        oo ooVar = new oo(context, 10);
        ooVar.m5718a("GMS_WTF", null, "GMS_WTF", stringBuilder.toString());
        ooVar.send();
        if (aF(7)) {
            Log.e(str, str2, th);
            Log.wtf(str, str2, th);
        }
    }

    public final void m5112a(String str, String str2, Throwable th) {
        if (aF(4)) {
            Log.i(str, str2, th);
        }
    }

    public final boolean aF(int i) {
        return Log.isLoggable(this.Nq, i);
    }

    public final void m5113b(String str, String str2, Throwable th) {
        if (aF(5)) {
            Log.w(str, str2, th);
        }
    }

    public final void m5114c(String str, String str2, Throwable th) {
        if (aF(6)) {
            Log.e(str, str2, th);
        }
    }

    public final void m5115m(String str, String str2) {
        if (aF(3)) {
            Log.d(str, str2);
        }
    }

    public final void m5116n(String str, String str2) {
        if (aF(2)) {
            Log.v(str, str2);
        }
    }

    public final void m5117o(String str, String str2) {
        if (aF(5)) {
            Log.w(str, str2);
        }
    }

    public final void m5118p(String str, String str2) {
        if (aF(6)) {
            Log.e(str, str2);
        }
    }
}
