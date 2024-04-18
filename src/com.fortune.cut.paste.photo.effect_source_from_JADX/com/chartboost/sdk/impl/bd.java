package com.chartboost.sdk.impl;

import android.text.TextUtils;
import com.chartboost.sdk.C0153b;
import com.chartboost.sdk.Libraries.C0104a;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.C0131g;
import com.chartboost.sdk.Libraries.C0131g.C0125k;
import com.chartboost.sdk.Libraries.C0132h;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C0148a;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C0151a;
import com.chartboost.sdk.impl.C0182l.C0332a;
import com.chartboost.sdk.impl.C0336n.C0096a;
import com.chartboost.sdk.impl.az.C0085c;
import java.io.File;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;

public class bd {
    public static bd f646a;
    private static final String f647b;
    private static C0132h f648c;
    private static C0335m f649d;
    private static ConcurrentHashMap<Integer, C0245b> f650e;
    private static C0243a f651f;
    private static C0243a f652g;
    private static AtomicInteger f653h;
    private static AtomicInteger f654i;
    private static boolean f655j;
    private static C0148a f656k;
    private static boolean f657l;
    private static Observer f658m;
    private static C0085c f659n;

    /* renamed from: com.chartboost.sdk.impl.bd.1 */
    static class C02411 implements Observer {
        C02411() {
        }

        public final void update(Observable observable, Object obj) {
            bd.m1016n();
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bd.2 */
    static class C02422 implements C0085c {
        C02422() {
        }

        public final void m981a(C0111a c0111a, az azVar) {
            synchronized (bd.class) {
                bd.f651f = C0243a.kCBIntial;
                if (c0111a != null) {
                    CBLogging.m97a(bd.f647b, "Got Video list from server :)" + c0111a);
                    bd.m994a(c0111a.m151a("videos"));
                }
            }
        }

        public final void m982a(C0111a c0111a, az azVar, CBError cBError) {
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bd.a */
    public enum C0243a {
        kCBIntial,
        kCBInProgress
    }

    /* renamed from: com.chartboost.sdk.impl.bd.b */
    private static class C0245b extends C0182l<Object> {
        private String f642a;
        private long f643b;
        private String f644c;

        /* renamed from: com.chartboost.sdk.impl.bd.b.1 */
        class C02441 implements Runnable {
            final /* synthetic */ C0148a f640a;
            final /* synthetic */ C0245b f641b;

            C02441(C0245b c0245b, C0148a c0148a) {
                this.f641b = c0245b;
                this.f640a = c0148a;
            }

            public void run() {
                if (this.f640a != null) {
                    this.f640a.m310q().m475r(this.f640a);
                }
            }
        }

        public C0245b(int i, String str, C0246c c0246c, String str2) {
            super(i, str, c0246c);
            this.f642a = str2;
            this.f644c = str;
            this.f643b = System.currentTimeMillis();
        }

        protected void m987b(Object obj) {
        }

        protected C0336n<Object> m986a(C0328i c0328i) {
            if (c0328i != null) {
                C0151a.m347d(this.f642a, Long.valueOf((System.currentTimeMillis() - this.f643b) / 1000).toString(), this.f644c);
                CBLogging.m97a(bd.f647b, "Video download Success. Storing video in cache" + this.f642a);
                bd.f648c.m237a(this.f642a, c0328i.f913b);
                C0151a.m350e("cache", "hit", this.f642a);
            }
            if (bd.f654i.get() > 0 && bd.f653h.incrementAndGet() > 0 && bd.f656k != null) {
                C0148a k = bd.f656k;
                bd.f656k = null;
                CBUtility.m120e().post(new C02441(this, k));
            }
            if (bd.f653h.get() == bd.f654i.get()) {
                bd.f653h.set(0);
                bd.f654i.set(0);
                bd.f652g = C0243a.kCBIntial;
                bd.f650e.clear();
            }
            return C0336n.m1362a(null, null);
        }

        public C0332a m988s() {
            return C0332a.LOW;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bd.c */
    private static class C0246c implements C0096a {
        private C0245b f645a;

        private C0246c() {
        }

        public void m990a(C0178s c0178s) {
            if ((c0178s instanceof C0338r) || (c0178s instanceof C0337q) || (c0178s instanceof C0327h)) {
                if (this.f645a != null) {
                    C0151a.m333a(this.f645a.f642a, Long.valueOf((System.currentTimeMillis() - this.f645a.f643b) / 1000).toString(), this.f645a.f644c, c0178s.getMessage());
                    C0151a.m350e("cache", "miss", this.f645a.f642a);
                }
                bd.f650e.put(Integer.valueOf(this.f645a.hashCode()), this.f645a);
                CBLogging.m101b(bd.f647b, "Error downloading video " + c0178s.getMessage() + this.f645a.f642a);
            }
        }
    }

    static {
        f647b = bd.class.getSimpleName();
        f653h = new AtomicInteger();
        f654i = new AtomicInteger();
        f655j = true;
        f657l = false;
        f658m = new C02411();
        f659n = new C02422();
    }

    private bd() {
    }

    public static synchronized bd m992a() {
        bd bdVar;
        synchronized (bd.class) {
            if (f646a == null) {
                f646a = new bd();
                m1015m();
            }
            bdVar = f646a;
        }
        return bdVar;
    }

    private static synchronized void m1015m() {
        synchronized (bd.class) {
            if (!f657l) {
                f657l = true;
                f648c = new C0132h("CBVideoDirectory", true);
                f650e = new ConcurrentHashMap();
                f651f = C0243a.kCBIntial;
                f652g = C0243a.kCBIntial;
                f649d = ba.m938a(C0153b.m400l()).m949a();
                ay.m871a().addObserver(f658m);
            }
        }
    }

    public static synchronized void m1000b() {
        synchronized (bd.class) {
            if (!f657l) {
                m1015m();
            }
            CBLogging.m97a(f647b, "Calling Prfetch Video");
            if (!(C0243a.kCBInProgress == f651f || C0243a.kCBInProgress == f652g)) {
                if (!(f650e == null || f650e.isEmpty())) {
                    f650e.clear();
                    f649d.m1356a(Integer.valueOf(f658m.hashCode()));
                    f652g = C0243a.kCBIntial;
                    CBLogging.m97a(f647b, "prefetchVideo: Clearing all volley request for new start");
                }
                f651f = C0243a.kCBInProgress;
                Object jSONArray = new JSONArray();
                if (m1005c() != null) {
                    for (Object put : m1005c()) {
                        jSONArray.put(put);
                    }
                }
                C0151a.m345d();
                f654i.set(0);
                f653h.set(0);
                az azVar = new az("/api/video-prefetch");
                azVar.m891a("local-videos", jSONArray);
                C0125k[] c0125kArr = new C0125k[2];
                c0125kArr[0] = C0131g.m223a("status", C0104a.f83a);
                c0125kArr[1] = C0131g.m223a("videos", C0131g.m225b(C0131g.m221a(C0131g.m223a("video", C0131g.m218a(C0131g.m217a())), C0131g.m223a("id", C0131g.m217a()))));
                azVar.m885a(C0131g.m221a(c0125kArr));
                azVar.m899b(true);
                azVar.m886a(f659n);
            }
        }
    }

    public static synchronized void m994a(C0111a c0111a) {
        synchronized (bd.class) {
            C0151a.m349e();
            if (c0111a != null) {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                String[] c = m1005c();
                for (int i = 0; i < c0111a.m177o(); i++) {
                    C0111a c2 = c0111a.m157c(i);
                    if (!(c2.m156b("id") || c2.m156b("video"))) {
                        String e = c2.m162e("id");
                        String e2 = c2.m162e("video");
                        if (!f648c.m243c(e)) {
                            hashMap2.put(e, e2);
                            f654i.incrementAndGet();
                        }
                        hashMap.put(e, e2);
                    }
                }
                if (!hashMap2.isEmpty()) {
                    f652g = C0243a.kCBInProgress;
                }
                if (f655j) {
                    f655j = false;
                }
                CBLogging.m97a(f647b, "synchronizeVideos: Delete and Download new videos");
                m997a(hashMap, c);
                if (C0153b.m408t()) {
                    m996a(hashMap2);
                }
            }
        }
    }

    private static synchronized void m997a(HashMap<String, String> hashMap, String[] strArr) {
        synchronized (bd.class) {
            CBLogging.m97a(f647b, "deleteVideos: Deleteing videos in cache");
            if (!(hashMap == null || strArr == null)) {
                for (String str : strArr) {
                    if (!hashMap.containsKey(str)) {
                        File d = f648c.m244d(str);
                        if (d != null) {
                            f648c.m242c(d);
                        }
                    }
                }
            }
        }
    }

    private static synchronized void m996a(HashMap<String, String> hashMap) {
        synchronized (bd.class) {
            CBLogging.m97a(f647b, "downloadVideos: Downloading videos from server");
            for (String str : hashMap.keySet()) {
                C0246c c0246c = new C0246c();
                C0182l c0245b = new C0245b(0, (String) hashMap.get(str), c0246c, str);
                c0245b.m541a(new C0303d(30000, 0, 0.0f));
                c0246c.f645a = c0245b;
                c0245b.m542a((Object) Integer.valueOf(f658m.hashCode()));
                C0151a.m327a((String) hashMap.get(str), str);
                f649d.m1353a(c0245b);
            }
        }
    }

    public static String[] m1005c() {
        if (f648c == null) {
            return null;
        }
        return f648c.m238a();
    }

    public static synchronized void m1006d() {
        synchronized (bd.class) {
            f649d.m1356a(Integer.valueOf(f658m.hashCode()));
        }
    }

    public static String m993a(String str) {
        if (f648c.m243c(str)) {
            return f648c.m244d(str).getPath();
        }
        return null;
    }

    public static String m999b(C0111a c0111a) {
        if (c0111a == null) {
            return null;
        }
        C0111a a = c0111a.m151a("assets");
        if (a.m155b()) {
            return null;
        }
        C0111a a2 = a.m151a(CBUtility.m118c().m189b() ? "video-portrait" : "video-landscape");
        if (a2.m155b()) {
            return null;
        }
        String e = a2.m162e("id");
        if (TextUtils.isEmpty(e)) {
            return null;
        }
        return m993a(e);
    }

    public static void m1001b(String str) {
        if (f648c.m243c(str)) {
            f648c.m240b(str);
        }
    }

    public static boolean m1004c(C0111a c0111a) {
        return !TextUtils.isEmpty(m999b(c0111a));
    }

    public static synchronized boolean m1007e() {
        boolean z;
        synchronized (bd.class) {
            if (f652g == C0243a.kCBInProgress) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    private static synchronized void m1016n() {
        synchronized (bd.class) {
            CBLogging.m97a(f647b, "Process Request called");
            if (!(f651f == C0243a.kCBInProgress || f652g == C0243a.kCBInProgress)) {
                if ((f652g == C0243a.kCBIntial && f650e != null) || f650e.size() > 0) {
                    for (Integer num : f650e.keySet()) {
                        f652g = C0243a.kCBInProgress;
                        f649d.m1353a((C0182l) f650e.get(num));
                        f650e.remove(num);
                    }
                }
            }
        }
    }

    public static synchronized void m995a(C0148a c0148a) {
        synchronized (bd.class) {
            f656k = c0148a;
        }
    }

    public static synchronized boolean m1002b(C0148a c0148a) {
        boolean z;
        synchronized (bd.class) {
            if (m1007e()) {
                CBLogging.m107e(f647b, "Saving video impression request for video prefetch completion");
                m995a(c0148a);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
