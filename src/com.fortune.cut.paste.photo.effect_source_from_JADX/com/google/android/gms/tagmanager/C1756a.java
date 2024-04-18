package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import java.io.IOException;

/* renamed from: com.google.android.gms.tagmanager.a */
class C1756a {
    private static C1756a aqa;
    private static Object xO;
    private volatile long apW;
    private volatile long apX;
    private volatile long apY;
    private C1753a apZ;
    private volatile boolean mClosed;
    private final Context mContext;
    private final ld wb;
    private final Thread wu;
    private volatile Info xQ;

    /* renamed from: com.google.android.gms.tagmanager.a.a */
    public interface C1753a {
        Info pd();
    }

    /* renamed from: com.google.android.gms.tagmanager.a.1 */
    class C17541 implements C1753a {
        final /* synthetic */ C1756a aqb;

        C17541(C1756a c1756a) {
            this.aqb = c1756a;
        }

        public Info pd() {
            Info info = null;
            try {
                info = AdvertisingIdClient.getAdvertisingIdInfo(this.aqb.mContext);
            } catch (IllegalStateException e) {
                bh.m6461W("IllegalStateException getting Advertising Id Info");
            } catch (GooglePlayServicesRepairableException e2) {
                bh.m6461W("GooglePlayServicesRepairableException getting Advertising Id Info");
            } catch (IOException e3) {
                bh.m6461W("IOException getting Ad Id Info");
            } catch (GooglePlayServicesNotAvailableException e4) {
                bh.m6461W("GooglePlayServicesNotAvailableException getting Advertising Id Info");
            } catch (Exception e5) {
                bh.m6461W("Unknown exception. Could not get the Advertising Id Info.");
            }
            return info;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.a.2 */
    class C17552 implements Runnable {
        final /* synthetic */ C1756a aqb;

        C17552(C1756a c1756a) {
            this.aqb = c1756a;
        }

        public void run() {
            this.aqb.pb();
        }
    }

    static {
        xO = new Object();
    }

    private C1756a(Context context) {
        this(context, null, lf.m5325if());
    }

    C1756a(Context context, C1753a c1753a, ld ldVar) {
        this.apW = 900000;
        this.apX = 30000;
        this.mClosed = false;
        this.apZ = new C17541(this);
        this.wb = ldVar;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (c1753a != null) {
            this.apZ = c1753a;
        }
        this.wu = new Thread(new C17552(this));
    }

    static C1756a m6396W(Context context) {
        if (aqa == null) {
            synchronized (xO) {
                if (aqa == null) {
                    C1756a c1756a = new C1756a(context);
                    aqa = c1756a;
                    c1756a.start();
                }
            }
        }
        return aqa;
    }

    private void pb() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            try {
                this.xQ = this.apZ.pd();
                Thread.sleep(this.apW);
            } catch (InterruptedException e) {
                bh.m6459U("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private void pc() {
        if (this.wb.currentTimeMillis() - this.apY >= this.apX) {
            interrupt();
            this.apY = this.wb.currentTimeMillis();
        }
    }

    void interrupt() {
        this.wu.interrupt();
    }

    public boolean isLimitAdTrackingEnabled() {
        pc();
        return this.xQ == null ? true : this.xQ.isLimitAdTrackingEnabled();
    }

    public String pa() {
        pc();
        return this.xQ == null ? null : this.xQ.getId();
    }

    void start() {
        this.wu.start();
    }
}
