package com.chartboost.sdk.impl;

import com.chartboost.sdk.C0153b;
import com.chartboost.sdk.C0166d;
import com.chartboost.sdk.C0166d.C0165a;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C0148a;
import com.chartboost.sdk.Model.C0148a.C0146c;
import com.chartboost.sdk.Model.C0148a.C0147d;
import com.chartboost.sdk.Model.C0149b;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.impl.C0182l.C0332a;
import org.json.JSONArray;

public class ae extends C0166d {
    private static final String f340b;
    private static ae f341c;

    /* renamed from: com.chartboost.sdk.impl.ae.1 */
    class C01831 implements C0165a {
        final /* synthetic */ ae f339a;

        C01831(ae aeVar) {
            this.f339a = aeVar;
        }

        public void m581a(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                C0153b.m387d().didClickInterstitial(c0148a.f193d);
            }
        }

        public void m583b(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                C0153b.m387d().didCloseInterstitial(c0148a.f193d);
            }
        }

        public void m584c(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                C0153b.m387d().didDismissInterstitial(c0148a.f193d);
            }
        }

        public void m585d(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                C0153b.m387d().didCacheInterstitial(c0148a.f193d);
            }
        }

        public void m582a(C0148a c0148a, CBImpressionError cBImpressionError) {
            if (C0153b.m387d() != null) {
                C0153b.m387d().didFailToLoadInterstitial(c0148a.f193d, cBImpressionError);
            }
        }

        public void m586e(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                C0153b.m387d().didDisplayInterstitial(c0148a.f193d);
            }
        }

        public boolean m587f(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                return C0153b.m387d().shouldDisplayInterstitial(c0148a.f193d);
            }
            return true;
        }

        public boolean m588g(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                return C0153b.m387d().shouldRequestInterstitial(c0148a.f193d);
            }
            return true;
        }

        public boolean m589h(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                return C0153b.m406r();
            }
            return true;
        }
    }

    static {
        f340b = ae.class.getSimpleName();
    }

    protected ae() {
    }

    public static ae m590f() {
        if (f341c == null) {
            f341c = new ae();
        }
        return f341c;
    }

    protected boolean m593b(C0148a c0148a, C0111a c0111a) {
        return c0111a.m151a("media-type").equals("video");
    }

    protected void m592a(C0148a c0148a, C0111a c0111a) {
        if (!m593b(c0148a, c0111a) || bd.m1004c(c0111a)) {
            if (c0111a.m158c() && c0111a.m151a("videos").m158c()) {
                bd.m994a(c0111a.m151a("videos"));
            }
            super.m446a(c0148a, c0111a);
            return;
        }
        CBLogging.m101b(f340b, "Video is unavailable so cannot show the video impression");
        m447a(c0148a, CBImpressionError.VIDEO_UNAVAILABLE);
        if (c0148a.f195f) {
            c0148a.m289a(c0111a);
            bd.m995a(c0148a);
        }
        bd.m1000b();
    }

    public void m600r(C0148a c0148a) {
        if (!c0148a.m316w().m155b()) {
            super.m446a(c0148a, c0148a.m316w());
        } else if (!m456c(c0148a.f193d) && !c0148a.f206q) {
            m448a(m595e(c0148a), c0148a);
        }
    }

    protected C0148a m591a(String str, boolean z) {
        return new C0148a(C0146c.INTERSTITIAL, z, str, false);
    }

    protected az m595e(C0148a c0148a) {
        az azVar = new az("/interstitial/get");
        azVar.m888a(C0332a.HIGH);
        azVar.m885a(C0149b.f214b);
        azVar.m891a("local-videos", m597g());
        return azVar;
    }

    protected void m598i(C0148a c0148a) {
        if (c0148a.f194e != C0147d.INTERSTITIAL_VIDEO) {
            super.m466i(c0148a);
        }
    }

    protected C0165a m594c() {
        return new C01831(this);
    }

    protected az m599l(C0148a c0148a) {
        return new az("/interstitial/show");
    }

    public JSONArray m597g() {
        JSONArray jSONArray = new JSONArray();
        String[] c = bd.m1005c();
        if (c != null) {
            for (Object put : c) {
                jSONArray.put(put);
            }
        }
        return jSONArray;
    }

    public String m596e() {
        return "interstitial";
    }
}
