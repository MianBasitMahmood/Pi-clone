package com.chartboost.sdk;

import android.content.Context;
import android.os.Handler;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C0148a;
import com.chartboost.sdk.Model.C0148a.C0145b;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Tracking.C0151a;
import com.chartboost.sdk.impl.ay;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.az.C0085c;
import com.chartboost.sdk.impl.az.C0086d;
import com.google.android.gms.wallet.WalletConstants;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.chartboost.sdk.d */
public abstract class C0166d {
    protected static Handler f277a;
    private Map<String, C0148a> f278b;
    private Map<String, C0148a> f279c;
    private Map<String, C0148a> f280d;
    private C0165a f281e;

    /* renamed from: com.chartboost.sdk.d.1 */
    class C01621 implements Runnable {
        final /* synthetic */ String f270a;
        final /* synthetic */ C0148a f271b;
        final /* synthetic */ C0166d f272c;

        C01621(C0166d c0166d, String str, C0148a c0148a) {
            this.f272c = c0166d;
            this.f270a = str;
            this.f271b = c0148a;
        }

        public void run() {
            if (this.f272c.m456c(this.f270a)) {
                C0148a d = this.f272c.m458d(this.f270a);
                if (d.f191b == C0145b.NONE) {
                    d.f191b = C0145b.CACHED;
                }
                this.f272c.m464g(d);
                return;
            }
            this.f272c.m455c(this.f271b);
        }
    }

    /* renamed from: com.chartboost.sdk.d.2 */
    class C01632 extends C0086d {
        final /* synthetic */ C0148a f273a;
        final /* synthetic */ C0166d f274b;

        C01632(C0166d c0166d, C0148a c0148a) {
            this.f274b = c0166d;
            this.f273a = c0148a;
        }

        public void m429a(C0111a c0111a, az azVar) {
            if (C0153b.m394g() && !this.f274b.m456c(this.f273a.f193d)) {
                this.f274b.m451b(this.f273a.f193d);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.d.3 */
    class C01643 implements C0085c {
        final /* synthetic */ C0148a f275a;
        final /* synthetic */ C0166d f276b;

        C01643(C0166d c0166d, C0148a c0148a) {
            this.f276b = c0166d;
            this.f275a = c0148a;
        }

        public void m430a(C0111a c0111a, az azVar) {
            this.f275a.f206q = false;
            if (c0111a.m155b() || c0111a.m151a("assets").m155b()) {
                this.f276b.m447a(this.f275a, CBImpressionError.NO_AD_FOUND);
            } else {
                this.f276b.m446a(this.f275a, c0111a);
            }
        }

        public void m431a(C0111a c0111a, az azVar, CBError cBError) {
            this.f275a.f206q = false;
            String str = "network failure";
            String str2 = "request %s failed with error %s: %s";
            Object[] objArr = new Object[3];
            objArr[0] = azVar.m906g();
            objArr[1] = cBError.m280a().name();
            objArr[2] = cBError.m281b() != null ? cBError.m281b() : "";
            CBLogging.m105d(str, String.format(str2, objArr));
            this.f276b.m447a(this.f275a, cBError.m282c());
        }
    }

    /* renamed from: com.chartboost.sdk.d.a */
    protected interface C0165a {
        void m432a(C0148a c0148a);

        void m433a(C0148a c0148a, CBImpressionError cBImpressionError);

        void m434b(C0148a c0148a);

        void m435c(C0148a c0148a);

        void m436d(C0148a c0148a);

        void m437e(C0148a c0148a);

        boolean m438f(C0148a c0148a);

        boolean m439g(C0148a c0148a);

        boolean m440h(C0148a c0148a);
    }

    protected abstract C0148a m443a(String str, boolean z);

    protected abstract C0165a m454c();

    protected abstract az m460e(C0148a c0148a);

    public abstract String m461e();

    protected abstract az m469l(C0148a c0148a);

    static {
        f277a = CBUtility.m120e();
    }

    public C0166d() {
        this.f281e = null;
        this.f279c = new HashMap();
        this.f278b = new HashMap();
        this.f280d = new HashMap();
    }

    public void m449a(String str) {
        C0148a a = m443a(str, false);
        C0173e g = Chartboost.m57g();
        if (g != null && g.m488c()) {
            m447a(a, CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
        } else if (!m453b(a)) {
            f277a.post(new C01621(this, str, a));
        }
    }

    public void m451b(String str) {
        C0148a d;
        if (m456c(str)) {
            d = m458d(str);
            if (d != null) {
                m450b().m436d(d);
                return;
            }
            return;
        }
        d = m443a(str, true);
        if (!m453b(d)) {
            m455c(d);
        }
    }

    protected void m445a(C0148a c0148a) {
        m474q(c0148a);
        m450b().m436d(c0148a);
        c0148a.f191b = C0145b.CACHED;
    }

    protected final boolean m453b(C0148a c0148a) {
        if (m450b().m440h(c0148a) || CBUtility.m110a().getInt("cbPrefSessionCount", 0) != 1) {
            return false;
        }
        m447a(c0148a, CBImpressionError.FIRST_SESSION_INTERSTITIALS_DISABLED);
        return true;
    }

    protected void m455c(C0148a c0148a) {
        if (m463f(c0148a) && m450b().m439g(c0148a) && !m442s(c0148a)) {
            if (!c0148a.f195f && C0153b.m407s()) {
                c0148a.f198i = true;
                Chartboost.m35a(c0148a);
            }
            if (m459d(c0148a)) {
                az e = m460e(c0148a);
                if (e != null) {
                    m448a(e, c0148a);
                    C0151a.m335a(m461e(), c0148a.f193d, c0148a.f195f);
                    return;
                }
                return;
            }
            m472o(c0148a);
        }
    }

    protected boolean m459d(C0148a c0148a) {
        return true;
    }

    private final synchronized boolean m442s(C0148a c0148a) {
        boolean z = true;
        synchronized (this) {
            if (m471n(c0148a) != null) {
                CBLogging.m101b(getClass().getSimpleName(), String.format("%s %s", new Object[]{"Request already in process for impression with location", c0148a.f193d}));
            } else {
                m473p(c0148a);
                z = false;
            }
        }
        return z;
    }

    protected void m447a(C0148a c0148a, CBImpressionError cBImpressionError) {
        m472o(c0148a);
        C0173e g = Chartboost.m57g();
        if (g != null && g.m486b()) {
            g.m484a(c0148a, true);
        } else if (g != null && g.m488c()) {
            g.m485b(c0148a);
        }
        C0151a.m329a(m461e(), c0148a.f193d, cBImpressionError);
        m450b().m433a(c0148a, cBImpressionError);
    }

    protected final boolean m463f(C0148a c0148a) {
        if (C0153b.m401m()) {
            C0173e g = Chartboost.m57g();
            if (!c0148a.f195f && g != null && g.m488c()) {
                m447a(c0148a, CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
                return false;
            } else if (ay.m871a().m878c()) {
                return true;
            } else {
                m447a(c0148a, CBImpressionError.INTERNET_UNAVAILABLE);
                return false;
            }
        }
        m447a(c0148a, CBImpressionError.SESSION_NOT_STARTED);
        return false;
    }

    protected void m464g(C0148a c0148a) {
        m472o(c0148a);
        boolean z = c0148a.f191b != C0145b.DISPLAYED;
        if (z) {
            if (C0153b.m373a() != null && C0153b.m373a().doesWrapperUseCustomShouldDisplayBehavior()) {
                this.f280d.put(c0148a.f193d == null ? "" : c0148a.f193d, c0148a);
            }
            if (!m450b().m438f(c0148a)) {
                return;
            }
        }
        m441a(c0148a, z);
    }

    protected void m452b(String str, boolean z) {
        if (str == null) {
            str = "";
        }
        C0148a c0148a = (C0148a) this.f280d.get(str);
        if (c0148a != null) {
            this.f280d.remove(str);
            if (z) {
                m441a(c0148a, true);
            }
        }
    }

    private void m441a(C0148a c0148a, boolean z) {
        boolean z2 = c0148a.f191b == C0145b.CACHED;
        m466i(c0148a);
        C0173e g = Chartboost.m57g();
        if (g != null) {
            if (g.m486b()) {
                g.m484a(c0148a, false);
            } else if (!(!c0148a.f198i || z2 || c0148a.f191b == C0145b.DISPLAYED)) {
                return;
            }
        }
        if (z) {
            m465h(c0148a);
        } else {
            Chartboost.m35a(c0148a);
        }
    }

    protected void m465h(C0148a c0148a) {
        Chartboost.m35a(c0148a);
    }

    protected void m466i(C0148a c0148a) {
        m467j(c0148a);
    }

    public final void m467j(C0148a c0148a) {
        if (!c0148a.f196g) {
            c0148a.f196g = true;
            c0148a.f195f = false;
            m468k(c0148a);
            if (m458d(c0148a.f193d) == c0148a) {
                m462e(c0148a.f193d);
            }
        }
    }

    protected final void m468k(C0148a c0148a) {
        az l = m469l(c0148a);
        l.m893a(true);
        l.m896b(m457d());
        if (c0148a.f195f) {
            l.m891a("cached", (Object) "1");
        } else {
            l.m891a("cached", (Object) "0");
        }
        Object e = c0148a.m316w().m162e("ad_id");
        if (e != null) {
            l.m891a("ad_id", e);
        }
        l.m891a("location", c0148a.f193d);
        l.m886a(new C01632(this, c0148a));
        C0151a.m330a(m461e(), c0148a.f193d, c0148a.m309p());
    }

    protected final boolean m470m(C0148a c0148a) {
        return TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - c0148a.f190a.getTime()) >= 86400;
    }

    protected void m446a(C0148a c0148a, C0111a c0111a) {
        if (c0111a.m164f("status") == WalletConstants.ERROR_CODE_INVALID_PARAMETERS) {
            CBLogging.m101b(c0148a.f192c, "Invalid status code" + c0111a.m151a("status"));
            m447a(c0148a, CBImpressionError.NO_AD_FOUND);
        } else if (c0111a.m164f("status") != 200) {
            CBLogging.m101b(c0148a.f192c, "Invalid status code" + c0111a.m151a("status"));
            m447a(c0148a, CBImpressionError.INVALID_RESPONSE);
        } else {
            C0151a.m344c(m461e(), c0148a.m309p(), c0148a.f195f);
            c0148a.m290a(c0111a, C0161c.m420a().f267a);
        }
    }

    protected final void m448a(az azVar, C0148a c0148a) {
        azVar.m891a("location", c0148a.f193d);
        if (c0148a.f195f) {
            azVar.m891a("cache", (Object) "1");
            azVar.m899b(true);
        }
        azVar.m896b(Chartboost.getValidContext());
        c0148a.f206q = true;
        azVar.m886a(new C01643(this, c0148a));
    }

    protected synchronized C0148a m471n(C0148a c0148a) {
        C0148a c0148a2;
        if (c0148a != null) {
            c0148a2 = (C0148a) this.f278b.get(c0148a.f193d);
        } else {
            c0148a2 = null;
        }
        return c0148a2;
    }

    protected synchronized void m472o(C0148a c0148a) {
        if (c0148a != null) {
            this.f278b.remove(c0148a.f193d);
        }
    }

    protected synchronized void m473p(C0148a c0148a) {
        if (c0148a != null) {
            this.f278b.put(c0148a.f193d, c0148a);
        }
    }

    public boolean m456c(String str) {
        return m458d(str) != null;
    }

    protected C0148a m458d(String str) {
        C0148a c0148a = (C0148a) this.f279c.get(str);
        return (c0148a == null || m470m(c0148a)) ? null : c0148a;
    }

    protected void m462e(String str) {
        this.f279c.remove(str);
    }

    protected void m444a() {
        this.f279c.clear();
    }

    protected void m474q(C0148a c0148a) {
        this.f279c.put(c0148a.f193d, c0148a);
    }

    protected final C0165a m450b() {
        if (this.f281e == null) {
            this.f281e = m454c();
        }
        return this.f281e;
    }

    protected Context m457d() {
        try {
            Method declaredMethod = Chartboost.class.getDeclaredMethod("getValidContext", new Class[0]);
            declaredMethod.setAccessible(true);
            return (Context) declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable e) {
            CBLogging.m102b(this, "Error encountered getting valid context", e);
            CBUtility.throwProguardError(e);
            return C0153b.m400l();
        }
    }

    public void m475r(C0148a c0148a) {
    }
}
