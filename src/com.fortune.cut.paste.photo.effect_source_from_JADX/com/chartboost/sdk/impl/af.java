package com.chartboost.sdk.impl;

import com.chartboost.sdk.C0153b;
import com.chartboost.sdk.C0166d.C0165a;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C0148a;
import com.chartboost.sdk.Model.C0148a.C0146c;
import com.chartboost.sdk.Model.C0149b;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.impl.C0182l.C0332a;
import com.chartboost.sdk.impl.bl.C0184b;
import com.chartboost.sdk.impl.bl.C0269a;
import com.google.android.gms.plus.PlusShare;

public class af extends ae {
    private static af f350b;
    private static String f351c;

    /* renamed from: com.chartboost.sdk.impl.af.1 */
    class C01861 implements Runnable {
        final /* synthetic */ C0111a f343a;
        final /* synthetic */ C0148a f344b;
        final /* synthetic */ af f345c;

        /* renamed from: com.chartboost.sdk.impl.af.1.1 */
        class C01851 extends C0184b {
            final /* synthetic */ C01861 f342a;

            C01851(C01861 c01861) {
                this.f342a = c01861;
            }

            public void m603a(bl blVar) {
                this.f342a.f345c.m447a(this.f342a.f344b, CBImpressionError.USER_CANCELLATION);
            }

            public void m604a(bl blVar, int i) {
                if (i == 1) {
                    super.m465h(this.f342a.f344b);
                } else {
                    this.f342a.f345c.m447a(this.f342a.f344b, CBImpressionError.USER_CANCELLATION);
                }
            }
        }

        C01861(af afVar, C0111a c0111a, C0148a c0148a) {
            this.f345c = afVar;
            this.f343a = c0111a;
            this.f344b = c0148a;
        }

        public void run() {
            C0269a c0269a = new C0269a();
            c0269a.m1113a(this.f343a.m162e(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)).m1115b(this.f343a.m162e("text")).m1117d(this.f343a.m162e("confirm")).m1116c(this.f343a.m162e("cancel"));
            c0269a.m1114a(this.f345c.m457d(), new C01851(this));
        }
    }

    /* renamed from: com.chartboost.sdk.impl.af.2 */
    class C01882 implements Runnable {
        final /* synthetic */ C0111a f347a;
        final /* synthetic */ af f348b;

        /* renamed from: com.chartboost.sdk.impl.af.2.1 */
        class C01871 extends C0184b {
            final /* synthetic */ C01882 f346a;

            C01871(C01882 c01882) {
                this.f346a = c01882;
            }

            public void m605a(bl blVar, int i) {
                CBLogging.m103c(af.f351c, "post-popup dismissed");
            }
        }

        C01882(af afVar, C0111a c0111a) {
            this.f348b = afVar;
            this.f347a = c0111a;
        }

        public void run() {
            C0269a c0269a = new C0269a();
            c0269a.m1113a(this.f347a.m162e(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)).m1115b(this.f347a.m162e("text")).m1116c(this.f347a.m162e("confirm"));
            c0269a.m1114a(this.f348b.m457d(), new C01871(this));
        }
    }

    /* renamed from: com.chartboost.sdk.impl.af.3 */
    class C01893 implements C0165a {
        final /* synthetic */ af f349a;

        C01893(af afVar) {
            this.f349a = afVar;
        }

        public void m606a(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                C0153b.m387d().didClickRewardedVideo(c0148a.f193d);
            }
        }

        public void m608b(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                C0153b.m387d().didCloseRewardedVideo(c0148a.f193d);
            }
        }

        public void m609c(C0148a c0148a) {
            this.f349a.m632s(c0148a);
            if (C0153b.m387d() != null) {
                C0153b.m387d().didDismissRewardedVideo(c0148a.f193d);
            }
        }

        public void m610d(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                C0153b.m387d().didCacheRewardedVideo(c0148a.f193d);
            }
        }

        public void m607a(C0148a c0148a, CBImpressionError cBImpressionError) {
            if (C0153b.m387d() != null) {
                C0153b.m387d().didFailToLoadRewardedVideo(c0148a.f193d, cBImpressionError);
            }
        }

        public void m611e(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                C0153b.m387d().didDisplayRewardedVideo(c0148a.f193d);
            }
        }

        public boolean m612f(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                return C0153b.m387d().shouldDisplayRewardedVideo(c0148a.f193d);
            }
            return true;
        }

        public boolean m613g(C0148a c0148a) {
            return true;
        }

        public boolean m614h(C0148a c0148a) {
            if (C0153b.m387d() != null) {
                return C0153b.m406r();
            }
            return true;
        }
    }

    static {
        f351c = "CBRewardedVideo";
    }

    private af() {
    }

    public static af m620h() {
        if (f350b == null) {
            f350b = new af();
        }
        return f350b;
    }

    protected boolean m623b(C0148a c0148a, C0111a c0111a) {
        return true;
    }

    protected C0148a m622a(String str, boolean z) {
        return new C0148a(C0146c.REWARDED_VIDEO, z, str, false);
    }

    protected boolean m625d(C0148a c0148a) {
        return !bd.m1002b(c0148a);
    }

    protected az m626e(C0148a c0148a) {
        az azVar = new az("/reward/get");
        azVar.m888a(C0332a.HIGH);
        azVar.m885a(C0149b.f214b);
        azVar.m891a("local-videos", m620h().m597g());
        return azVar;
    }

    protected az m631l(C0148a c0148a) {
        az l = super.m599l(c0148a);
        l.m889a("/reward/show");
        return l;
    }

    protected void m630i(C0148a c0148a) {
    }

    protected void m628g(C0148a c0148a) {
        if (bd.m1004c(c0148a.m316w())) {
            super.m464g(c0148a);
            return;
        }
        CBLogging.m101b(f351c, "Video not available in the cache, so cannot show rewarded video");
        m447a(c0148a, CBImpressionError.VIDEO_UNAVAILABLE);
        bd.m1000b();
    }

    protected void m629h(C0148a c0148a) {
        C0111a a = c0148a.m316w().m151a("ux").m151a("pre-popup");
        if (a.m158c() && a.m151a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE).m161d() && a.m151a("text").m161d() && a.m151a("confirm").m161d() && a.m151a("cancel").m161d() && m457d() != null) {
            a.post(new C01861(this, a, c0148a));
        } else {
            super.m465h(c0148a);
        }
    }

    protected void m632s(C0148a c0148a) {
        C0111a a = c0148a.m316w().m151a("ux").m151a("post-popup");
        if (a.m158c() && a.m151a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE).m161d() && a.m151a("text").m161d() && a.m151a("confirm").m161d() && m457d() != null && c0148a.f201l) {
            a.post(new C01882(this, a));
        }
    }

    protected C0165a m624c() {
        return new C01893(this);
    }

    public String m627e() {
        return "rewarded-video";
    }
}
