package com.google.android.gms.internal;

import android.os.SystemClock;

public final class lf implements ld {
    private static lf Of;

    public static synchronized ld m5325if() {
        ld ldVar;
        synchronized (lf.class) {
            if (Of == null) {
                Of = new lf();
            }
            ldVar = Of;
        }
        return ldVar;
    }

    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }
}
