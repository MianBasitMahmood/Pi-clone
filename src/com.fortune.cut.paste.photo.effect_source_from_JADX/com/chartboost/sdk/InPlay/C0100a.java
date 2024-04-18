package com.chartboost.sdk.InPlay;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.chartboost.sdk.C0092a;
import com.chartboost.sdk.C0153b;
import com.chartboost.sdk.C0161c;
import com.chartboost.sdk.C0161c.C0094b;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C0149b;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Model.CBError.CBClickError;
import com.chartboost.sdk.Tracking.C0151a;
import com.chartboost.sdk.impl.C0178s;
import com.chartboost.sdk.impl.C0182l.C0332a;
import com.chartboost.sdk.impl.C0336n.C0096a;
import com.chartboost.sdk.impl.C0336n.C0098b;
import com.chartboost.sdk.impl.ab;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.az.C0085c;
import com.chartboost.sdk.impl.ba;
import com.chartboost.sdk.impl.bb;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* renamed from: com.chartboost.sdk.InPlay.a */
public final class C0100a {
    private static final String f70a;
    private static ArrayList<CBInPlay> f71b;
    private static int f72c;
    private static C0100a f73d;
    private static LinkedHashMap<String, Bitmap> f74e;
    private static volatile boolean f75f;

    /* renamed from: com.chartboost.sdk.InPlay.a.1 */
    class C00931 implements C0085c {
        final /* synthetic */ String f59a;
        final /* synthetic */ boolean f60b;
        final /* synthetic */ C0100a f61c;

        C00931(C0100a c0100a, String str, boolean z) {
            this.f61c = c0100a;
            this.f59a = str;
            this.f60b = z;
        }

        public void m73a(C0111a c0111a, az azVar) {
            C0100a.f75f = false;
            if (c0111a.m158c()) {
                CBInPlay cBInPlay = new CBInPlay();
                cBInPlay.m70a(c0111a);
                cBInPlay.m72b(c0111a.m162e("name"));
                if (!TextUtils.isEmpty(this.f59a)) {
                    cBInPlay.m71a(this.f59a);
                }
                C0111a a = c0111a.m151a("icons");
                if (a.m158c() && !TextUtils.isEmpty(a.m162e("lg"))) {
                    String e = a.m162e("lg");
                    if (C0100a.f74e.get(e) == null) {
                        C0098b c0099b = new C0099b(null);
                        C0096a c0097a = new C0097a(null);
                        c0099b.f68c = cBInPlay;
                        c0099b.f67b = e;
                        c0099b.f66a = this.f60b;
                        ba.m938a(C0153b.m400l()).m949a().m1353a(new ab(e, c0099b, 0, 0, null, c0097a));
                        return;
                    }
                    this.f61c.m83a(cBInPlay, e, true);
                }
            }
        }

        public void m74a(C0111a c0111a, az azVar, CBError cBError) {
            CBLogging.m101b(C0100a.f70a, "InPlay cache call failed" + cBError);
            C0100a.f75f = false;
            if (C0153b.m387d() != null) {
                C0153b.m387d().didFailToLoadInPlay(this.f59a, cBError != null ? cBError.m282c() : null);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.InPlay.a.2 */
    class C00952 implements C0094b {
        final /* synthetic */ CBInPlay f62a;
        final /* synthetic */ C0111a f63b;
        final /* synthetic */ C0100a f64c;

        C00952(C0100a c0100a, CBInPlay cBInPlay, C0111a c0111a) {
            this.f64c = c0100a;
            this.f62a = cBInPlay;
            this.f63b = c0111a;
        }

        public void m76a() {
            az d = C0161c.m420a().m428d();
            d.m891a("location", this.f62a.getLocation());
            d.m890a("to", this.f63b);
            d.m890a("cgn", this.f63b);
            d.m890a("creative", this.f63b);
            d.m890a("ad_id", this.f63b);
            d.m890a("type", this.f63b);
            d.m890a("more_type", this.f63b);
            d.m893a(true);
            d.m918s();
        }
    }

    /* renamed from: com.chartboost.sdk.InPlay.a.a */
    private class C0097a implements C0096a {
        final /* synthetic */ C0100a f65a;

        private C0097a(C0100a c0100a) {
            this.f65a = c0100a;
        }

        public void m78a(C0178s c0178s) {
            CBLogging.m101b(C0100a.f70a, "Bitmap download failed " + c0178s.getMessage());
        }
    }

    /* renamed from: com.chartboost.sdk.InPlay.a.b */
    private class C0099b implements C0098b<Bitmap> {
        protected boolean f66a;
        protected String f67b;
        protected CBInPlay f68c;
        final /* synthetic */ C0100a f69d;

        private C0099b(C0100a c0100a) {
            this.f69d = c0100a;
        }

        public void m80a(Bitmap bitmap) {
            C0100a.f74e.put(this.f67b, bitmap);
            this.f69d.m83a(this.f68c, this.f67b, this.f66a);
        }
    }

    static {
        f70a = C0100a.class.getSimpleName();
        f72c = 4;
        f75f = false;
    }

    private C0100a() {
        f71b = new ArrayList();
        f74e = new LinkedHashMap(f72c);
    }

    public static C0100a m82a() {
        if (f73d == null) {
            synchronized (C0100a.class) {
                if (f73d == null) {
                    f73d = new C0100a();
                }
            }
        }
        return f73d;
    }

    public final synchronized void m92a(String str) {
        if (!(C0100a.m90e() || f75f)) {
            m85a(str, true);
        }
    }

    private static boolean m90e() {
        return f71b.size() == f72c;
    }

    public final synchronized boolean m94b(String str) {
        boolean z = true;
        synchronized (this) {
            if (f71b.size() > 0) {
                C0151a.m341b("in-play", str, true);
            } else {
                CBLogging.m97a(f70a, "InPlay is not available :(");
                z = false;
            }
        }
        return z;
    }

    public final synchronized CBInPlay m95c(String str) {
        CBInPlay cBInPlay;
        cBInPlay = null;
        if (f71b.size() > 0) {
            cBInPlay = (CBInPlay) f71b.get(0);
            f71b.remove(0);
        }
        if (!(C0100a.m90e() || f75f)) {
            m85a(str, true);
        }
        if (cBInPlay == null) {
            CBLogging.m97a(f70a, "InPlay Object not available returning null :(");
        }
        return cBInPlay;
    }

    private void m85a(String str, boolean z) {
        f75f = true;
        az azVar = new az("/inplay/get");
        azVar.m891a("raw", Boolean.valueOf(true));
        azVar.m891a("cache", Boolean.valueOf(true));
        azVar.m888a(C0332a.HIGH);
        azVar.m899b(true);
        azVar.m891a("location", (Object) str);
        azVar.m885a(C0149b.f216d);
        azVar.m886a(new C00931(this, str, z));
    }

    private synchronized void m83a(CBInPlay cBInPlay, String str, boolean z) {
        cBInPlay.m69a((Bitmap) f74e.get(str));
        f71b.add(cBInPlay);
        C0092a d = C0153b.m387d();
        if (d != null && z) {
            d.didCacheInPlay(cBInPlay.getLocation());
        }
        if (!(C0100a.m90e() || f75f)) {
            m85a(cBInPlay.getLocation(), false);
        }
    }

    protected final void m91a(CBInPlay cBInPlay) {
        Object a = cBInPlay.m68a();
        az azVar = new az("/inplay/show");
        azVar.m891a("inplay-dictionary", a);
        azVar.m891a("location", cBInPlay.getLocation());
        azVar.m893a(true);
        azVar.m918s();
        String str = null;
        if (cBInPlay.m68a().m158c()) {
            str = a.m162e("ad_id");
        }
        C0151a.m330a("in-play", cBInPlay.getLocation(), str);
    }

    protected final void m93b(CBInPlay cBInPlay) {
        String str;
        C0111a a = cBInPlay.m68a();
        if (a != null) {
            String e = a.m162e("link");
            String e2 = a.m162e("deep-link");
            if (!TextUtils.isEmpty(e2)) {
                try {
                    if (!bb.m962a(e2)) {
                        e2 = e;
                    }
                    str = e2;
                } catch (Exception e3) {
                    CBLogging.m101b(f70a, "Cannot open a url");
                }
            }
            str = e;
        } else {
            str = null;
        }
        C0094b c00952 = new C00952(this, cBInPlay, a);
        C0161c a2 = C0161c.m420a();
        if (TextUtils.isEmpty(str)) {
            a2.f268b.m418a(null, false, str, CBClickError.URI_INVALID, c00952);
        } else {
            a2.m425b(null, str, c00952);
        }
    }

    public static void m87b() {
        if (f74e != null) {
            f74e.clear();
        }
        if (f71b != null) {
            f71b.clear();
        }
    }
}
