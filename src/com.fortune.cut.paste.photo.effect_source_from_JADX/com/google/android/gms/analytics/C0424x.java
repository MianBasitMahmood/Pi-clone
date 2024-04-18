package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.ha;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.gms.analytics.x */
class C0424x extends Thread implements C0393f {
    private static C0424x zM;
    private volatile boolean mClosed;
    private final Context mContext;
    private final LinkedBlockingQueue<Runnable> zJ;
    private volatile boolean zK;
    private volatile String zL;
    private volatile ak zN;
    private final Lock zO;
    private final List<ha> zP;

    /* renamed from: com.google.android.gms.analytics.x.a */
    private class C0420a implements Runnable {
        final /* synthetic */ C0424x zQ;

        private C0420a(C0424x c0424x) {
            this.zQ = c0424x;
        }

        public void run() {
            this.zQ.zN.dQ();
        }
    }

    /* renamed from: com.google.android.gms.analytics.x.b */
    private class C0421b implements Runnable {
        final /* synthetic */ C0424x zQ;

        private C0421b(C0424x c0424x) {
            this.zQ = c0424x;
        }

        public void run() {
            this.zQ.zN.dispatch();
        }
    }

    /* renamed from: com.google.android.gms.analytics.x.c */
    private class C0422c implements Runnable {
        final /* synthetic */ C0424x zQ;

        private C0422c(C0424x c0424x) {
            this.zQ = c0424x;
        }

        public void run() {
            this.zQ.zN.dW();
        }
    }

    /* renamed from: com.google.android.gms.analytics.x.d */
    private class C0423d implements Runnable {
        final /* synthetic */ C0424x zQ;
        private final Map<String, String> zR;

        C0423d(C0424x c0424x, Map<String, String> map) {
            this.zQ = c0424x;
            this.zR = new HashMap(map);
            String str = (String) map.get("&ht");
            if (str != null) {
                try {
                    Long.valueOf(str);
                } catch (NumberFormatException e) {
                    str = null;
                }
            }
            if (str == null) {
                this.zR.put("&ht", Long.toString(System.currentTimeMillis()));
            }
        }

        private String m1585v(Map<String, String> map) {
            return map.containsKey("useSecure") ? an.m1526f((String) map.get("useSecure"), true) ? "https:" : "http:" : "https:";
        }

        private void m1586w(Map<String, String> map) {
            C0379q w = C0380a.m1481w(this.zQ.mContext);
            an.m1524a((Map) map, "&adid", w);
            an.m1524a((Map) map, "&ate", w);
        }

        private void m1587x(Map<String, String> map) {
            C0379q dZ = C0394g.dZ();
            an.m1524a((Map) map, "&an", dZ);
            an.m1524a((Map) map, "&av", dZ);
            an.m1524a((Map) map, "&aid", dZ);
            an.m1524a((Map) map, "&aiid", dZ);
            map.put("&v", "1");
        }

        private boolean m1588y(Map<String, String> map) {
            if (map.get("&sf") == null) {
                return false;
            }
            double a = an.m1522a((String) map.get("&sf"), 100.0d);
            if (a >= 100.0d) {
                return false;
            }
            if (((double) (C0424x.ah((String) map.get("&cid")) % 10000)) < a * 100.0d) {
                return false;
            }
            String str = map.get("&t") == null ? FitnessActivities.UNKNOWN : (String) map.get("&t");
            ae.m1487V(String.format("%s hit sampled out", new Object[]{str}));
            return true;
        }

        public void run() {
            m1586w(this.zR);
            if (TextUtils.isEmpty((CharSequence) this.zR.get("&cid"))) {
                this.zR.put("&cid", C0402k.el().getValue("&cid"));
            }
            if (!GoogleAnalytics.getInstance(this.zQ.mContext).getAppOptOut() && !m1588y(this.zR)) {
                if (!TextUtils.isEmpty(this.zQ.zL)) {
                    C0426y.eK().m1599D(true);
                    this.zR.putAll(new HitBuilder().setCampaignParamsFromUrl(this.zQ.zL).build());
                    C0426y.eK().m1599D(false);
                    this.zQ.zL = null;
                }
                m1587x(this.zR);
                this.zQ.zN.m1509b(ac.m1484z(this.zR), Long.valueOf((String) this.zR.get("&ht")).longValue(), m1585v(this.zR), this.zQ.zP);
            }
        }
    }

    private C0424x(Context context) {
        super("GAThread");
        this.zJ = new LinkedBlockingQueue();
        this.zK = false;
        this.mClosed = false;
        this.zP = new ArrayList();
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        this.zP.add(new ha("appendVersion", "&_v".substring(1), "ma4.0.4"));
        this.zO = new ReentrantLock();
        start();
    }

    static C0424x m1589A(Context context) {
        if (zM == null) {
            zM = new C0424x(context);
        }
        return zM;
    }

    static String m1590B(Context context) {
        try {
            FileInputStream openFileInput = context.openFileInput("gaInstallData");
            byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD];
            int read = openFileInput.read(bArr, 0, AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD);
            if (openFileInput.available() > 0) {
                ae.m1485T("Too much campaign data, ignoring it.");
                openFileInput.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            openFileInput.close();
            context.deleteFile("gaInstallData");
            if (read <= 0) {
                ae.m1488W("Campaign file is empty.");
                return null;
            }
            String str = new String(bArr, 0, read);
            ae.m1486U("Campaign found: " + str);
            return str;
        } catch (FileNotFoundException e) {
            ae.m1486U("No campaign data found.");
            return null;
        } catch (IOException e2) {
            ae.m1485T("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }

    static int ah(String str) {
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = (((i << 6) & 268435455) + charAt) + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return i;
    }

    private void m1594b(Runnable runnable) {
        this.zJ.add(runnable);
    }

    private String m1597g(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public void dQ() {
        m1594b(new C0420a());
    }

    public void dW() {
        m1594b(new C0422c());
    }

    public LinkedBlockingQueue<Runnable> dX() {
        return this.zJ;
    }

    public void dY() {
        init();
        Object<Runnable> arrayList = new ArrayList();
        this.zJ.drainTo(arrayList);
        this.zO.lock();
        try {
            this.zK = true;
            for (Runnable run : arrayList) {
                run.run();
            }
        } catch (Throwable th) {
            this.zO.unlock();
        }
        this.zO.unlock();
    }

    public void dispatch() {
        m1594b(new C0421b());
    }

    public Thread getThread() {
        return this;
    }

    protected synchronized void init() {
        if (this.zN == null) {
            this.zN = new C0418w(this.mContext, this);
            this.zN.eB();
        }
    }

    public void run() {
        Process.setThreadPriority(10);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            ae.m1488W("sleep interrupted in GAThread initialize");
        }
        try {
            init();
            this.zL = C0424x.m1590B(this.mContext);
            ae.m1487V("Initialized GA Thread");
        } catch (Throwable th) {
            ae.m1485T("Error initializing the GAThread: " + m1597g(th));
            ae.m1485T("Google Analytics will not start up.");
            this.zK = true;
        }
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.zJ.take();
                this.zO.lock();
                if (!this.zK) {
                    runnable.run();
                }
                this.zO.unlock();
            } catch (InterruptedException e2) {
                ae.m1486U(e2.toString());
            } catch (Throwable th2) {
                ae.m1485T("Error on GAThread: " + m1597g(th2));
                ae.m1485T("Google Analytics is shutting down.");
                this.zK = true;
            }
        }
    }

    public void m1598u(Map<String, String> map) {
        m1594b(new C0423d(this, map));
    }
}
