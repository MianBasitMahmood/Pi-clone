package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

public class op {
    private final ox amU;
    private ov amV;

    /* renamed from: com.google.android.gms.internal.op.a */
    public interface C1410a {
        void m5717d(PendingIntent pendingIntent);

        void on();

        void oo();
    }

    public op(Context context, int i, String str, String str2, C1410a c1410a, boolean z) {
        int i2 = 0;
        String packageName = context.getPackageName();
        try {
            i2 = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.wtf("PlayLogger", "This can't happen.");
        }
        this.amV = new ov(packageName, i2, i, str, str2, z);
        this.amU = new ox(context, new ou(c1410a));
    }

    public void m5720a(long j, String str, byte[] bArr, String... strArr) {
        this.amU.m5738b(this.amV, new or(j, str, bArr, strArr));
    }

    public void m5721b(String str, byte[] bArr, String... strArr) {
        m5720a(System.currentTimeMillis(), str, bArr, strArr);
    }

    public void start() {
        this.amU.start();
    }

    public void stop() {
        this.amU.stop();
    }
}
