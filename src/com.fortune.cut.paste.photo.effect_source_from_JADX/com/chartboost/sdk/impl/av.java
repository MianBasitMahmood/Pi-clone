package com.chartboost.sdk.impl;

import com.chartboost.sdk.C0153b;
import com.chartboost.sdk.C0166d;
import com.chartboost.sdk.C0166d.C0165a;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Model.C0148a;
import com.chartboost.sdk.Model.C0148a.C0146c;
import com.chartboost.sdk.Model.C0149b;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.impl.C0182l.C0332a;

public class av extends C0166d {
    private static av f517c;
    protected int f518b;
    private C0148a f519d;
    private boolean f520e;
    private boolean f521f;

    /* renamed from: com.chartboost.sdk.impl.av.1 */
    class C02161 implements C0165a {
        final /* synthetic */ av f516a;

        C02161(av avVar) {
            this.f516a = avVar;
        }

        public void m818a(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                C0153b.m387d().didClickMoreApps(c0148a.f193d);
            }
        }

        public void m820b(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                C0153b.m387d().didCloseMoreApps(c0148a.f193d);
            }
        }

        public void m821c(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                C0153b.m387d().didDismissMoreApps(c0148a.f193d);
            }
        }

        public void m822d(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                C0153b.m387d().didCacheMoreApps(c0148a.f193d);
            }
        }

        public void m819a(C0148a c0148a, CBImpressionError cBImpressionError) {
            if (C0153b.m387d() != null) {
                C0153b.m387d().didFailToLoadMoreApps(c0148a.f193d, cBImpressionError);
            }
        }

        public void m823e(C0148a c0148a) {
            this.f516a.f518b = 0;
            this.f516a.m837g();
            if (C0153b.m387d() != null) {
                C0153b.m387d().didDisplayMoreApps(c0148a.f193d);
            }
        }

        public boolean m824f(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                return C0153b.m387d().shouldDisplayMoreApps(c0148a.f193d);
            }
            return true;
        }

        public boolean m825g(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                return C0153b.m387d().shouldRequestMoreApps(c0148a.f193d);
            }
            return true;
        }

        public boolean m826h(C0148a c0148a) {
            return true;
        }
    }

    private av() {
        this.f519d = null;
    }

    public static av m827f() {
        if (f517c == null) {
            synchronized (av.class) {
                if (f517c == null) {
                    f517c = new av();
                }
            }
        }
        return f517c;
    }

    public void m831a(String str) {
        this.f518b = 0;
        m837g();
        super.m449a(str);
    }

    protected void m830a(C0148a c0148a, C0111a c0111a) {
        if (!this.f520e && this.f521f) {
            this.f521f = false;
            this.f518b = c0111a.m151a("cells").m177o();
        }
        super.m446a(c0148a, c0111a);
    }

    protected C0148a m828a(String str, boolean z) {
        return new C0148a(C0146c.MORE_APPS, z, str, false);
    }

    protected az m834e(C0148a c0148a) {
        az azVar = new az("/more/get");
        azVar.m888a(C0332a.HIGH);
        azVar.m885a(C0149b.f215c);
        return azVar;
    }

    protected az m838l(C0148a c0148a) {
        az azVar = new az("/more/show");
        if (c0148a.f193d != null) {
            azVar.m891a("location", c0148a.f193d);
        }
        if (c0148a.m316w().m159c("cells")) {
            azVar.m891a("cells", c0148a.m316w().m151a("cells"));
        }
        return azVar;
    }

    public void m829a() {
        this.f519d = null;
    }

    protected C0148a m833d(String str) {
        return this.f519d;
    }

    protected void m836e(String str) {
        this.f519d = null;
    }

    protected void m839q(C0148a c0148a) {
        this.f519d = c0148a;
    }

    protected C0165a m832c() {
        return new C02161(this);
    }

    protected void m837g() {
    }

    public String m835e() {
        return "more-apps";
    }
}
