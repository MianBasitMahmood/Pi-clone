package com.google.android.gms.internal;

import android.os.SystemClock;
import org.json.JSONObject;

public final class iw {
    private static final is Hh;
    public static final Object Ip;
    private long Il;
    private long Im;
    private long In;
    private iv Io;

    static {
        Hh = new is("RequestTracker");
        Ip = new Object();
    }

    public iw(long j) {
        this.Il = j;
        this.Im = -1;
        this.In = 0;
    }

    private void gq() {
        this.Im = -1;
        this.Io = null;
        this.In = 0;
    }

    public final void m5054a(long j, iv ivVar) {
        synchronized (Ip) {
            iv ivVar2 = this.Io;
            long j2 = this.Im;
            this.Im = j;
            this.Io = ivVar;
            this.In = SystemClock.elapsedRealtime();
        }
        if (ivVar2 != null) {
            ivVar2.m1749n(j2);
        }
    }

    public final boolean m5055b(long j, int i, JSONObject jSONObject) {
        boolean z = true;
        iv ivVar = null;
        synchronized (Ip) {
            if (this.Im == -1 || this.Im != j) {
                z = false;
            } else {
                Hh.m5050b("request %d completed", Long.valueOf(this.Im));
                ivVar = this.Io;
                gq();
            }
        }
        if (ivVar != null) {
            ivVar.m1748a(j, i, jSONObject);
        }
        return z;
    }

    public final void clear() {
        synchronized (Ip) {
            if (this.Im != -1) {
                gq();
            }
        }
    }

    public final boolean m5056d(long j, int i) {
        return m5055b(j, i, null);
    }

    public final boolean m5057e(long j, int i) {
        iv ivVar;
        boolean z = true;
        long j2 = 0;
        synchronized (Ip) {
            if (this.Im == -1 || j - this.In < this.Il) {
                z = false;
                ivVar = null;
            } else {
                Hh.m5050b("request %d timed out", Long.valueOf(this.Im));
                j2 = this.Im;
                ivVar = this.Io;
                gq();
            }
        }
        if (ivVar != null) {
            ivVar.m1748a(j2, i, null);
        }
        return z;
    }

    public final boolean gr() {
        boolean z;
        synchronized (Ip) {
            z = this.Im != -1;
        }
        return z;
    }

    public final boolean m5058p(long j) {
        boolean z;
        synchronized (Ip) {
            z = this.Im != -1 && this.Im == j;
        }
        return z;
    }
}
