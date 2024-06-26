package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.op.C1410a;

public class oo implements C1410a {
    private final op amS;
    private boolean amT;

    public oo(Context context, int i) {
        this(context, i, null);
    }

    public oo(Context context, int i, String str) {
        this(context, i, str, null, true);
    }

    public oo(Context context, int i, String str, String str2, boolean z) {
        this.amS = new op(context, i, str, str2, this, z);
        this.amT = true;
    }

    private void om() {
        if (!this.amT) {
            throw new IllegalStateException("Cannot reuse one-time logger after sending.");
        }
    }

    public void m5718a(String str, byte[] bArr, String... strArr) {
        om();
        this.amS.m5721b(str, bArr, strArr);
    }

    public void m5719d(PendingIntent pendingIntent) {
        Log.w("OneTimePlayLogger", "logger connection failed: " + pendingIntent);
    }

    public void on() {
        this.amS.stop();
    }

    public void oo() {
        Log.w("OneTimePlayLogger", "logger connection failed");
    }

    public void send() {
        om();
        this.amS.start();
        this.amT = false;
    }
}
