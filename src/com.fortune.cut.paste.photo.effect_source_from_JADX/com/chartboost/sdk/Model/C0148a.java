package com.chartboost.sdk.Model;

import android.text.TextUtils;
import com.chartboost.sdk.C0166d;
import com.chartboost.sdk.C0177f;
import com.chartboost.sdk.C0177f.C0176a;
import com.chartboost.sdk.CBLocation;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.impl.ae;
import com.chartboost.sdk.impl.af;
import com.chartboost.sdk.impl.ah;
import com.chartboost.sdk.impl.ai;
import com.chartboost.sdk.impl.av;
import com.chartboost.sdk.impl.aw;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.bb;
import com.chartboost.sdk.impl.bp;
import com.chartboost.sdk.impl.br;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.Date;

/* renamed from: com.chartboost.sdk.Model.a */
public final class C0148a {
    public Date f190a;
    public C0145b f191b;
    public C0146c f192c;
    public String f193d;
    public C0147d f194e;
    public boolean f195f;
    public boolean f196g;
    public bp f197h;
    public boolean f198i;
    public boolean f199j;
    public boolean f200k;
    public boolean f201l;
    public boolean f202m;
    public az f203n;
    public boolean f204o;
    public boolean f205p;
    public boolean f206q;
    private C0111a f207r;
    private boolean f208s;
    private Boolean f209t;
    private C0177f f210u;
    private C0144a f211v;
    private Runnable f212w;

    /* renamed from: com.chartboost.sdk.Model.a.1 */
    static /* synthetic */ class C01431 {
        static final /* synthetic */ int[] f172a;

        static {
            f172a = new int[C0146c.values().length];
            try {
                f172a[C0146c.INTERSTITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f172a[C0146c.REWARDED_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f172a[C0146c.MORE_APPS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f172a[C0146c.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: com.chartboost.sdk.Model.a.a */
    public interface C0144a {
        void m283a(C0148a c0148a);

        void m284a(C0148a c0148a, CBImpressionError cBImpressionError);

        void m285a(C0148a c0148a, String str, C0111a c0111a);

        void m286b(C0148a c0148a);

        void m287c(C0148a c0148a);

        void m288d(C0148a c0148a);
    }

    /* renamed from: com.chartboost.sdk.Model.a.b */
    public enum C0145b {
        LOADING,
        LOADED,
        DISPLAYED,
        CACHED,
        DISMISSING,
        NONE
    }

    /* renamed from: com.chartboost.sdk.Model.a.c */
    public enum C0146c {
        INTERSTITIAL,
        MORE_APPS,
        REWARDED_VIDEO,
        NONE
    }

    /* renamed from: com.chartboost.sdk.Model.a.d */
    public enum C0147d {
        INTERSTITIAL,
        INTERSTITIAL_VIDEO,
        INTERSTITIAL_REWARD_VIDEO,
        NONE
    }

    public C0148a(C0146c c0146c, boolean z, String str, boolean z2) {
        this.f209t = null;
        this.f199j = false;
        this.f200k = false;
        this.f201l = false;
        this.f202m = false;
        this.f205p = false;
        this.f206q = false;
        this.f191b = C0145b.LOADING;
        this.f195f = z;
        this.f196g = false;
        this.f204o = false;
        this.f205p = true;
        this.f192c = c0146c;
        this.f198i = z2;
        this.f207r = C0111a.f95a;
        this.f194e = C0147d.NONE;
        this.f193d = str;
        this.f208s = true;
        if (this.f193d == null) {
            this.f193d = CBLocation.LOCATION_DEFAULT;
        }
    }

    public final void m290a(C0111a c0111a, C0144a c0144a) {
        if (c0111a == null) {
            c0111a = C0111a.m145a();
        }
        this.f207r = c0111a;
        this.f190a = new Date();
        this.f191b = C0145b.LOADING;
        this.f211v = c0144a;
        if (c0111a.m151a("type").equals("native")) {
            switch (C01431.f172a[this.f192c.ordinal()]) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    if (!c0111a.m151a("media-type").equals("video")) {
                        this.f194e = C0147d.INTERSTITIAL;
                        this.f210u = new ah(this);
                        break;
                    }
                    this.f194e = C0147d.INTERSTITIAL_VIDEO;
                    this.f210u = new ai(this);
                    this.f208s = false;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    this.f194e = C0147d.INTERSTITIAL_REWARD_VIDEO;
                    this.f210u = new ai(this);
                    this.f208s = false;
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    this.f210u = new aw(this);
                    this.f208s = false;
                    break;
            }
        }
        this.f210u = new br(this);
        this.f210u.m510a(c0111a);
    }

    public final boolean m293a() {
        return this.f208s;
    }

    public final void m295b() {
        if (this.f211v != null) {
            this.f205p = true;
            this.f211v.m286b(this);
        }
    }

    public final void m296c() {
        if (this.f211v != null) {
            this.f211v.m283a(this);
        }
    }

    public final boolean m294a(String str, C0111a c0111a) {
        if (this.f191b != C0145b.DISPLAYED || this.f200k) {
            return false;
        }
        if (str == null) {
            str = this.f207r.m162e("link");
        }
        String e = this.f207r.m162e("deep-link");
        if (!TextUtils.isEmpty(e)) {
            try {
                if (bb.m962a(e)) {
                    try {
                        this.f209t = new Boolean(true);
                        str = e;
                    } catch (Exception e2) {
                        str = e;
                    }
                } else {
                    this.f209t = new Boolean(false);
                }
            } catch (Exception e3) {
            }
        }
        if (this.f204o) {
            return false;
        }
        this.f204o = true;
        this.f205p = false;
        this.f211v.m285a(this, str, c0111a);
        return true;
    }

    public final boolean m297d() {
        return this.f209t != null;
    }

    public final boolean m298e() {
        return this.f209t.booleanValue();
    }

    public final void m291a(CBImpressionError cBImpressionError) {
        if (this.f211v != null) {
            this.f211v.m284a(this, cBImpressionError);
        }
    }

    public final void m299f() {
        if (this.f211v != null) {
            this.f211v.m287c(this);
        }
    }

    public final void m300g() {
        if (this.f211v != null) {
            this.f211v.m288d(this);
        }
    }

    public final boolean m301h() {
        if (this.f210u != null) {
            this.f210u.m514b();
            if (this.f210u.m517e() != null) {
                return true;
            }
        }
        CBLogging.m101b("CBImpression", "reinitializing -- no view protocol exists!!");
        CBLogging.m107e("CBImpression", "reinitializing -- view not yet created");
        return false;
    }

    public final void m302i() {
        m303j();
        if (this.f196g) {
            if (this.f210u != null) {
                this.f210u.m516d();
            }
            this.f210u = null;
            CBLogging.m101b("CBImpression", "Destroying the view and view data");
        }
    }

    public final void m303j() {
        if (this.f197h != null) {
            this.f197h.m1126d();
            try {
                if (!(this.f210u == null || this.f210u.m517e() == null || this.f210u.m517e().getParent() == null)) {
                    this.f197h.removeView(this.f210u.m517e());
                }
            } catch (Throwable e) {
                CBLogging.m102b("CBImpression", "Exception raised while cleaning up views", e);
            }
            this.f197h = null;
        }
        if (this.f210u != null) {
            this.f210u.m518f();
        }
        CBLogging.m101b("CBImpression", "Destroying the view");
    }

    public final CBImpressionError m304k() {
        if (this.f210u != null) {
            return this.f210u.m515c();
        }
        return null;
    }

    public final C0176a m305l() {
        if (this.f210u != null) {
            return this.f210u.m517e();
        }
        return null;
    }

    public final void m306m() {
        if (this.f210u != null && this.f210u.m517e() != null) {
            this.f210u.m517e().setVisibility(8);
        }
    }

    public final void m292a(Runnable runnable) {
        this.f212w = runnable;
    }

    public final void m307n() {
        this.f200k = true;
    }

    public final void m308o() {
        if (this.f212w != null) {
            this.f212w.run();
            this.f212w = null;
        }
        this.f200k = false;
        this.f199j = false;
    }

    public final String m309p() {
        return this.f207r.m162e("ad_id");
    }

    public final C0166d m310q() {
        switch (C01431.f172a[this.f192c.ordinal()]) {
            case DataEvent.TYPE_DELETED /*2*/:
                return af.m620h();
            case WalletFragmentState.PROCESSING /*3*/:
                return av.m827f();
            default:
                return ae.m590f();
        }
    }

    public final void m311r() {
        m310q().m467j(this);
    }

    public final boolean m312s() {
        if (this.f210u != null) {
            return this.f210u.m522j();
        }
        return false;
    }

    public final void m313t() {
        this.f204o = false;
        if (this.f210u != null) {
            this.f210u.m523k();
        }
    }

    public final void m314u() {
        this.f204o = false;
    }

    public final void m315v() {
        if (this.f210u != null) {
            this.f210u.m524l();
        }
    }

    public final C0111a m316w() {
        return this.f207r == null ? C0111a.f95a : this.f207r;
    }

    public final void m289a(C0111a c0111a) {
        if (c0111a == null) {
            c0111a = C0111a.f95a;
        }
        this.f207r = c0111a;
    }

    public final C0177f m317x() {
        return this.f210u;
    }

    public final boolean m318y() {
        return this.f205p;
    }
}
