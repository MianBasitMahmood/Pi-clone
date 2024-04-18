package com.google.android.gms.analytics;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.C0391c.C0389b;
import com.google.android.gms.analytics.C0391c.C0390c;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.google.android.gms.analytics.w */
class C0418w implements ak, C0389b, C0390c {
    private final Context mContext;
    private ld wb;
    private C0383d yU;
    private final C0393f yV;
    private boolean yX;
    private volatile long zh;
    private volatile C0413a zi;
    private volatile C0387b zj;
    private C0383d zk;
    private final GoogleAnalytics zl;
    private final Queue<C0416d> zm;
    private volatile int zn;
    private volatile Timer zo;
    private volatile Timer zp;
    private volatile Timer zq;
    private boolean zr;
    private boolean zs;
    private boolean zt;
    private long zu;

    /* renamed from: com.google.android.gms.analytics.w.1 */
    class C04111 implements Runnable {
        final /* synthetic */ C0418w zv;

        C04111(C0418w c0418w) {
            this.zv = c0418w;
        }

        public void run() {
            this.zv.eC();
        }
    }

    /* renamed from: com.google.android.gms.analytics.w.2 */
    static /* synthetic */ class C04122 {
        static final /* synthetic */ int[] zw;

        static {
            zw = new int[C0413a.values().length];
            try {
                zw[C0413a.CONNECTED_LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zw[C0413a.CONNECTED_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zw[C0413a.CONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                zw[C0413a.PENDING_CONNECTION.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                zw[C0413a.PENDING_DISCONNECT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                zw[C0413a.DISCONNECTED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                zw[C0413a.BLOCKED.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* renamed from: com.google.android.gms.analytics.w.a */
    private enum C0413a {
        CONNECTING,
        CONNECTED_SERVICE,
        CONNECTED_LOCAL,
        BLOCKED,
        PENDING_CONNECTION,
        PENDING_DISCONNECT,
        DISCONNECTED
    }

    /* renamed from: com.google.android.gms.analytics.w.b */
    private class C0414b extends TimerTask {
        final /* synthetic */ C0418w zv;

        private C0414b(C0418w c0418w) {
            this.zv = c0418w;
        }

        public void run() {
            if (this.zv.zi == C0413a.CONNECTED_SERVICE && this.zv.zm.isEmpty() && this.zv.zh + this.zv.zu < this.zv.wb.elapsedRealtime()) {
                ae.m1487V("Disconnecting due to inactivity");
                this.zv.cJ();
                return;
            }
            this.zv.zq.schedule(new C0414b(this.zv), this.zv.zu);
        }
    }

    /* renamed from: com.google.android.gms.analytics.w.c */
    private class C0415c extends TimerTask {
        final /* synthetic */ C0418w zv;

        private C0415c(C0418w c0418w) {
            this.zv = c0418w;
        }

        public void run() {
            if (this.zv.zi == C0413a.CONNECTING) {
                this.zv.eE();
            }
        }
    }

    /* renamed from: com.google.android.gms.analytics.w.d */
    private static class C0416d {
        private final Map<String, String> zF;
        private final long zG;
        private final String zH;
        private final List<ha> zI;

        public C0416d(Map<String, String> map, long j, String str, List<ha> list) {
            this.zF = map;
            this.zG = j;
            this.zH = str;
            this.zI = list;
        }

        public Map<String, String> eH() {
            return this.zF;
        }

        public long eI() {
            return this.zG;
        }

        public List<ha> eJ() {
            return this.zI;
        }

        public String getPath() {
            return this.zH;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PATH: ");
            stringBuilder.append(this.zH);
            if (this.zF != null) {
                stringBuilder.append("  PARAMS: ");
                for (Entry entry : this.zF.entrySet()) {
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append("=");
                    stringBuilder.append((String) entry.getValue());
                    stringBuilder.append(",  ");
                }
            }
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.google.android.gms.analytics.w.e */
    private class C0417e extends TimerTask {
        final /* synthetic */ C0418w zv;

        private C0417e(C0418w c0418w) {
            this.zv = c0418w;
        }

        public void run() {
            this.zv.eF();
        }
    }

    C0418w(Context context, C0393f c0393f) {
        this(context, c0393f, null, GoogleAnalytics.getInstance(context));
    }

    C0418w(Context context, C0393f c0393f, C0383d c0383d, GoogleAnalytics googleAnalytics) {
        this.zm = new ConcurrentLinkedQueue();
        this.zu = 300000;
        this.zk = c0383d;
        this.mContext = context;
        this.yV = c0393f;
        this.zl = googleAnalytics;
        this.wb = lf.m5325if();
        this.zn = 0;
        this.zi = C0413a.DISCONNECTED;
    }

    private Timer m1572a(Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }

    private synchronized void cJ() {
        if (this.zj != null && this.zi == C0413a.CONNECTED_SERVICE) {
            this.zi = C0413a.PENDING_DISCONNECT;
            this.zj.disconnect();
        }
    }

    private void eA() {
        this.zo = m1572a(this.zo);
        this.zp = m1572a(this.zp);
        this.zq = m1572a(this.zq);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void eC() {
        /*
        r7 = this;
        monitor-enter(r7);
        r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0070 }
        r2 = r7.yV;	 Catch:{ all -> 0x0070 }
        r2 = r2.getThread();	 Catch:{ all -> 0x0070 }
        r1 = r1.equals(r2);	 Catch:{ all -> 0x0070 }
        if (r1 != 0) goto L_0x0021;
    L_0x0011:
        r1 = r7.yV;	 Catch:{ all -> 0x0070 }
        r1 = r1.dX();	 Catch:{ all -> 0x0070 }
        r2 = new com.google.android.gms.analytics.w$1;	 Catch:{ all -> 0x0070 }
        r2.<init>(r7);	 Catch:{ all -> 0x0070 }
        r1.add(r2);	 Catch:{ all -> 0x0070 }
    L_0x001f:
        monitor-exit(r7);
        return;
    L_0x0021:
        r1 = r7.zr;	 Catch:{ all -> 0x0070 }
        if (r1 == 0) goto L_0x0028;
    L_0x0025:
        r7.dQ();	 Catch:{ all -> 0x0070 }
    L_0x0028:
        r1 = com.google.android.gms.analytics.C0418w.C04122.zw;	 Catch:{ all -> 0x0070 }
        r2 = r7.zi;	 Catch:{ all -> 0x0070 }
        r2 = r2.ordinal();	 Catch:{ all -> 0x0070 }
        r1 = r1[r2];	 Catch:{ all -> 0x0070 }
        switch(r1) {
            case 1: goto L_0x0036;
            case 2: goto L_0x0086;
            case 3: goto L_0x0035;
            case 4: goto L_0x0035;
            case 5: goto L_0x0035;
            case 6: goto L_0x00dd;
            case 7: goto L_0x0073;
            default: goto L_0x0035;
        };	 Catch:{ all -> 0x0070 }
    L_0x0035:
        goto L_0x001f;
    L_0x0036:
        r1 = r7.zm;	 Catch:{ all -> 0x0070 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0070 }
        if (r1 != 0) goto L_0x007e;
    L_0x003e:
        r1 = r7.zm;	 Catch:{ all -> 0x0070 }
        r1 = r1.poll();	 Catch:{ all -> 0x0070 }
        r0 = r1;
        r0 = (com.google.android.gms.analytics.C0418w.C0416d) r0;	 Catch:{ all -> 0x0070 }
        r6 = r0;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0070 }
        r2 = "Sending hit to store  ";
        r1.<init>(r2);	 Catch:{ all -> 0x0070 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x0070 }
        r1 = r1.toString();	 Catch:{ all -> 0x0070 }
        com.google.android.gms.analytics.ae.m1487V(r1);	 Catch:{ all -> 0x0070 }
        r1 = r7.yU;	 Catch:{ all -> 0x0070 }
        r2 = r6.eH();	 Catch:{ all -> 0x0070 }
        r3 = r6.eI();	 Catch:{ all -> 0x0070 }
        r5 = r6.getPath();	 Catch:{ all -> 0x0070 }
        r6 = r6.eJ();	 Catch:{ all -> 0x0070 }
        r1.m1493a(r2, r3, r5, r6);	 Catch:{ all -> 0x0070 }
        goto L_0x0036;
    L_0x0070:
        r1 = move-exception;
        monitor-exit(r7);
        throw r1;
    L_0x0073:
        r1 = "Blocked. Dropping hits.";
        com.google.android.gms.analytics.ae.m1487V(r1);	 Catch:{ all -> 0x0070 }
        r1 = r7.zm;	 Catch:{ all -> 0x0070 }
        r1.clear();	 Catch:{ all -> 0x0070 }
        goto L_0x001f;
    L_0x007e:
        r1 = r7.yX;	 Catch:{ all -> 0x0070 }
        if (r1 == 0) goto L_0x001f;
    L_0x0082:
        r7.eD();	 Catch:{ all -> 0x0070 }
        goto L_0x001f;
    L_0x0086:
        r1 = r7.zm;	 Catch:{ all -> 0x0070 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0070 }
        if (r1 != 0) goto L_0x00d3;
    L_0x008e:
        r1 = r7.zm;	 Catch:{ all -> 0x0070 }
        r1 = r1.peek();	 Catch:{ all -> 0x0070 }
        r0 = r1;
        r0 = (com.google.android.gms.analytics.C0418w.C0416d) r0;	 Catch:{ all -> 0x0070 }
        r6 = r0;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0070 }
        r2 = "Sending hit to service   ";
        r1.<init>(r2);	 Catch:{ all -> 0x0070 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x0070 }
        r1 = r1.toString();	 Catch:{ all -> 0x0070 }
        com.google.android.gms.analytics.ae.m1487V(r1);	 Catch:{ all -> 0x0070 }
        r1 = r7.zl;	 Catch:{ all -> 0x0070 }
        r1 = r1.isDryRunEnabled();	 Catch:{ all -> 0x0070 }
        if (r1 != 0) goto L_0x00cd;
    L_0x00b2:
        r1 = r7.zj;	 Catch:{ all -> 0x0070 }
        r2 = r6.eH();	 Catch:{ all -> 0x0070 }
        r3 = r6.eI();	 Catch:{ all -> 0x0070 }
        r5 = r6.getPath();	 Catch:{ all -> 0x0070 }
        r6 = r6.eJ();	 Catch:{ all -> 0x0070 }
        r1.m1527a(r2, r3, r5, r6);	 Catch:{ all -> 0x0070 }
    L_0x00c7:
        r1 = r7.zm;	 Catch:{ all -> 0x0070 }
        r1.poll();	 Catch:{ all -> 0x0070 }
        goto L_0x0086;
    L_0x00cd:
        r1 = "Dry run enabled. Hit not actually sent to service.";
        com.google.android.gms.analytics.ae.m1487V(r1);	 Catch:{ all -> 0x0070 }
        goto L_0x00c7;
    L_0x00d3:
        r1 = r7.wb;	 Catch:{ all -> 0x0070 }
        r1 = r1.elapsedRealtime();	 Catch:{ all -> 0x0070 }
        r7.zh = r1;	 Catch:{ all -> 0x0070 }
        goto L_0x001f;
    L_0x00dd:
        r1 = "Need to reconnect";
        com.google.android.gms.analytics.ae.m1487V(r1);	 Catch:{ all -> 0x0070 }
        r1 = r7.zm;	 Catch:{ all -> 0x0070 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0070 }
        if (r1 != 0) goto L_0x001f;
    L_0x00ea:
        r7.eF();	 Catch:{ all -> 0x0070 }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.w.eC():void");
    }

    private void eD() {
        this.yU.dispatch();
        this.yX = false;
    }

    private synchronized void eE() {
        if (this.zi != C0413a.CONNECTED_LOCAL) {
            if (this.mContext == null || !GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE.equals(this.mContext.getPackageName())) {
                eA();
                ae.m1487V("falling back to local store");
                if (this.zk != null) {
                    this.yU = this.zk;
                } else {
                    C0410v eu = C0410v.eu();
                    eu.m1570a(this.mContext, this.yV);
                    this.yU = eu.ex();
                }
                this.zi = C0413a.CONNECTED_LOCAL;
                eC();
            } else {
                this.zi = C0413a.BLOCKED;
                this.zj.disconnect();
                ae.m1488W("Attempted to fall back to local store from service.");
            }
        }
    }

    private synchronized void eF() {
        if (this.zt || this.zj == null || this.zi == C0413a.CONNECTED_LOCAL) {
            ae.m1488W("client not initialized.");
            eE();
        } else {
            try {
                this.zn++;
                m1572a(this.zp);
                this.zi = C0413a.CONNECTING;
                this.zp = new Timer("Failed Connect");
                this.zp.schedule(new C0415c(), 3000);
                ae.m1487V("connecting to Analytics service");
                this.zj.connect();
            } catch (SecurityException e) {
                ae.m1488W("security exception on connectToService");
                eE();
            }
        }
    }

    private void eG() {
        this.zo = m1572a(this.zo);
        this.zo = new Timer("Service Reconnect");
        this.zo.schedule(new C0417e(), 5000);
    }

    public synchronized void m1583a(int i, Intent intent) {
        this.zi = C0413a.PENDING_CONNECTION;
        if (this.zn < 2) {
            ae.m1488W("Service unavailable (code=" + i + "), will retry.");
            eG();
        } else {
            ae.m1488W("Service unavailable (code=" + i + "), using local store.");
            eE();
        }
    }

    public void m1584b(Map<String, String> map, long j, String str, List<ha> list) {
        ae.m1487V("putHit called");
        this.zm.add(new C0416d(map, j, str, list));
        eC();
    }

    public void dQ() {
        ae.m1487V("clearHits called");
        this.zm.clear();
        switch (C04122.zw[this.zi.ordinal()]) {
            case DataEvent.TYPE_CHANGED /*1*/:
                this.yU.m1494l(0);
                this.zr = false;
            case DataEvent.TYPE_DELETED /*2*/:
                this.zj.dQ();
                this.zr = false;
            default:
                this.zr = true;
        }
    }

    public synchronized void dW() {
        if (!this.zt) {
            ae.m1487V("setForceLocalDispatch called.");
            this.zt = true;
            switch (C04122.zw[this.zi.ordinal()]) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    cJ();
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    this.zs = true;
                    break;
                default:
                    break;
            }
        }
    }

    public void dispatch() {
        switch (C04122.zw[this.zi.ordinal()]) {
            case DataEvent.TYPE_CHANGED /*1*/:
                eD();
            case DataEvent.TYPE_DELETED /*2*/:
            default:
                this.yX = true;
        }
    }

    public void eB() {
        if (this.zj == null) {
            this.zj = new C0391c(this.mContext, this, this);
            eF();
        }
    }

    public synchronized void onConnected() {
        this.zp = m1572a(this.zp);
        this.zn = 0;
        ae.m1487V("Connected to service");
        this.zi = C0413a.CONNECTED_SERVICE;
        if (this.zs) {
            cJ();
            this.zs = false;
        } else {
            eC();
            this.zq = m1572a(this.zq);
            this.zq = new Timer("disconnect check");
            this.zq.schedule(new C0414b(), this.zu);
        }
    }

    public synchronized void onDisconnected() {
        if (this.zi == C0413a.BLOCKED) {
            ae.m1487V("Service blocked.");
            eA();
        } else if (this.zi == C0413a.PENDING_DISCONNECT) {
            ae.m1487V("Disconnected from service");
            eA();
            this.zi = C0413a.DISCONNECTED;
        } else {
            ae.m1487V("Unexpected disconnect.");
            this.zi = C0413a.PENDING_CONNECTION;
            if (this.zn < 2) {
                eG();
            } else {
                eE();
            }
        }
    }
}
