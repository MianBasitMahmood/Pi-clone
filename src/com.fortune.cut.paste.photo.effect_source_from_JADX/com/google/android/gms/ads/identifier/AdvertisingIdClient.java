package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.C0488a;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C1483s;
import com.google.android.gms.internal.C1483s.C1485a;
import com.google.android.gms.internal.jx;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    C0488a ln;
    C1483s lo;
    boolean lp;
    Object lq;
    C0372a lr;
    final long ls;
    private final Context mContext;

    public static final class Info {
        private final String lx;
        private final boolean ly;

        public Info(String str, boolean z) {
            this.lx = str;
            this.ly = z;
        }

        public final String getId() {
            return this.lx;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.ly;
        }

        public final String toString() {
            return "{" + this.lx + "}" + this.ly;
        }
    }

    /* renamed from: com.google.android.gms.ads.identifier.AdvertisingIdClient.a */
    static class C0372a extends Thread {
        private WeakReference<AdvertisingIdClient> lt;
        private long lu;
        CountDownLatch lv;
        boolean lw;

        public C0372a(AdvertisingIdClient advertisingIdClient, long j) {
            this.lt = new WeakReference(advertisingIdClient);
            this.lu = j;
            this.lv = new CountDownLatch(1);
            this.lw = false;
            start();
        }

        private void disconnect() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.lt.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.lw = true;
            }
        }

        public boolean aa() {
            return this.lw;
        }

        public void cancel() {
            this.lv.countDown();
        }

        public void run() {
            try {
                if (!this.lv.await(this.lu, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException e) {
                disconnect();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000);
    }

    public AdvertisingIdClient(Context context, long j) {
        this.lq = new Object();
        jx.m5223i(context);
        this.mContext = context;
        this.lp = false;
        this.ls = j;
    }

    private void m1442Z() {
        synchronized (this.lq) {
            if (this.lr != null) {
                this.lr.cancel();
                try {
                    this.lr.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.ls > 0) {
                this.lr = new C0372a(this, this.ls);
            }
        }
    }

    static C1483s m1443a(Context context, C0488a c0488a) throws IOException {
        try {
            return C1485a.m6038b(c0488a.gs());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        }
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1);
        try {
            advertisingIdClient.m1445b(false);
            Info info = advertisingIdClient.getInfo();
            return info;
        } finally {
            advertisingIdClient.finish();
        }
    }

    static C0488a m1444h(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            try {
                GooglePlayServicesUtil.m1769C(context);
                Object c0488a = new C0488a();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
                if (context.bindService(intent, c0488a, 1)) {
                    return c0488a;
                }
                throw new IOException("Connection failure");
            } catch (Throwable e) {
                throw new IOException(e);
            }
        } catch (NameNotFoundException e2) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    protected void m1445b(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        jx.aV("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.lp) {
                finish();
            }
            this.ln = m1444h(this.mContext);
            this.lo = m1443a(this.mContext, this.ln);
            this.lp = true;
            if (z) {
                m1442Z();
            }
        }
    }

    protected void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    public void finish() {
        jx.aV("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.mContext == null || this.ln == null) {
                return;
            }
            try {
                if (this.lp) {
                    this.mContext.unbindService(this.ln);
                }
            } catch (Throwable e) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", e);
            }
            this.lp = false;
            this.lo = null;
            this.ln = null;
        }
    }

    public Info getInfo() throws IOException {
        Info info;
        jx.aV("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.lp) {
                synchronized (this.lq) {
                    if (this.lr == null || !this.lr.aa()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    m1445b(false);
                    if (!this.lp) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            jx.m5223i(this.ln);
            jx.m5223i(this.lo);
            info = new Info(this.lo.getId(), this.lo.m6034c(true));
        }
        m1442Z();
        return info;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        m1445b(true);
    }
}
