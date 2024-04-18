package com.chartboost.sdk;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C0148a;
import com.chartboost.sdk.Model.C0148a.C0145b;
import com.chartboost.sdk.Model.C0148a.C0146c;
import com.chartboost.sdk.Model.C0148a.C0147d;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.impl.bh;
import com.chartboost.sdk.impl.bh.C0167a;
import com.chartboost.sdk.impl.bh.C0262b;
import com.chartboost.sdk.impl.bp;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.chartboost.sdk.e */
public final class C0173e {
    private static C0173e f289c;
    private bp f290a;
    private C0148a f291b;

    /* renamed from: com.chartboost.sdk.e.1 */
    class C01681 implements C0167a {
        final /* synthetic */ C0173e f282a;

        C01681(C0173e c0173e) {
            this.f282a = c0173e;
        }

        public void m477a(C0148a c0148a) {
            c0148a.m308o();
        }
    }

    /* renamed from: com.chartboost.sdk.e.2 */
    class C01712 implements Runnable {
        final /* synthetic */ C0148a f286a;
        final /* synthetic */ C0173e f287b;

        /* renamed from: com.chartboost.sdk.e.2.1 */
        class C01701 implements C0167a {
            final /* synthetic */ C01712 f285a;

            /* renamed from: com.chartboost.sdk.e.2.1.1 */
            class C01691 implements Runnable {
                final /* synthetic */ C0148a f283a;
                final /* synthetic */ C01701 f284b;

                C01691(C01701 c01701, C0148a c0148a) {
                    this.f284b = c01701;
                    this.f283a = c0148a;
                }

                public void run() {
                    this.f284b.f285a.f287b.m490d(this.f283a);
                }
            }

            C01701(C01712 c01712) {
                this.f285a = c01712;
            }

            public void m478a(C0148a c0148a) {
                CBUtility.m120e().post(new C01691(this, c0148a));
                c0148a.m306m();
            }
        }

        C01712(C0173e c0173e, C0148a c0148a) {
            this.f287b = c0173e;
            this.f286a = c0148a;
        }

        public void run() {
            this.f286a.f191b = C0145b.DISMISSING;
            C0262b c0262b = C0262b.CBAnimationTypePerspectiveRotate;
            if (this.f286a.f192c == C0146c.MORE_APPS) {
                c0262b = C0262b.CBAnimationTypePerspectiveZoom;
            }
            C0262b a = C0262b.m1102a(this.f286a.m316w().m164f("animation"));
            if (a != null) {
                c0262b = a;
            }
            if (C0153b.m392f()) {
                c0262b = C0262b.CBAnimationTypeNone;
            }
            bh.m1107b(c0262b, this.f286a, new C01701(this));
        }
    }

    /* renamed from: com.chartboost.sdk.e.3 */
    static /* synthetic */ class C01723 {
        static final /* synthetic */ int[] f288a;

        static {
            f288a = new int[C0145b.values().length];
            try {
                f288a[C0145b.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    private C0173e() {
        this.f290a = null;
    }

    public static C0173e m479a() {
        if (f289c == null) {
            f289c = new C0173e();
        }
        return f289c;
    }

    protected final void m483a(C0148a c0148a) {
        switch (C01723.f288a[c0148a.f191b.ordinal()]) {
            case DataEvent.TYPE_CHANGED /*1*/:
                if (c0148a.f198i && C0153b.m407s()) {
                    m482f(c0148a);
                }
            default:
                m481e(c0148a);
        }
    }

    private void m481e(C0148a c0148a) {
        if (this.f290a == null || this.f290a.m1130h() == c0148a) {
            Object obj = c0148a.f191b != C0145b.DISPLAYED ? 1 : null;
            c0148a.f191b = C0145b.DISPLAYED;
            Context e = Chartboost.m52e();
            CBImpressionError cBImpressionError = e == null ? CBImpressionError.NO_HOST_ACTIVITY : null;
            if (cBImpressionError == null) {
                cBImpressionError = c0148a.m304k();
            }
            if (cBImpressionError != null) {
                CBLogging.m101b("CBViewController", "Cannot able to create the view while trying th display the impression");
                c0148a.m291a(cBImpressionError);
                return;
            }
            if (this.f290a == null) {
                this.f290a = new bp(e, c0148a);
                e.addContentView(this.f290a, new LayoutParams(-1, -1));
            }
            this.f290a.m1123a();
            CBLogging.m101b("CBViewController", "Displaying the impression");
            c0148a.f197h = this.f290a;
            if (obj != null) {
                this.f290a.m1127e().m1110a();
                C0262b c0262b = C0262b.CBAnimationTypePerspectiveRotate;
                if (c0148a.f192c == C0146c.MORE_APPS) {
                    c0262b = C0262b.CBAnimationTypePerspectiveZoom;
                }
                C0262b a = C0262b.m1102a(c0148a.m316w().m164f("animation"));
                if (a != null) {
                    c0262b = a;
                }
                if (C0153b.m392f()) {
                    c0262b = C0262b.CBAnimationTypeNone;
                }
                c0148a.m307n();
                bh.m1103a(c0262b, c0148a, new C01681(this));
                if (C0153b.m387d() != null && (c0148a.f194e == C0147d.INTERSTITIAL_VIDEO || c0148a.f194e == C0147d.INTERSTITIAL_REWARD_VIDEO)) {
                    C0153b.m387d().willDisplayVideo(c0148a.f193d);
                }
                if (c0148a.m310q().m450b() != null) {
                    c0148a.m310q().m450b().m437e(c0148a);
                    return;
                }
                return;
            }
            return;
        }
        CBLogging.m101b("CBViewController", "Impression already visible");
        c0148a.m291a(CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
    }

    public final void m485b(C0148a c0148a) {
        CBLogging.m101b("CBViewController", "Dismissing impression");
        Runnable c01712 = new C01712(this, c0148a);
        if (c0148a.f200k) {
            c0148a.m292a(c01712);
        } else {
            c01712.run();
        }
    }

    private void m482f(C0148a c0148a) {
        Context e = Chartboost.m52e();
        if (e == null) {
            CBLogging.m105d(this, "No host activity to display loading view");
            return;
        }
        if (this.f290a == null) {
            this.f290a = new bp(e, c0148a);
            e.addContentView(this.f290a, new LayoutParams(-1, -1));
        }
        this.f290a.m1124b();
        this.f291b = c0148a;
    }

    public final void m484a(C0148a c0148a, boolean z) {
        if (c0148a == null) {
            return;
        }
        if (c0148a == this.f291b || c0148a == C0161c.m420a().m427c()) {
            this.f291b = null;
            CBLogging.m101b("CBViewController", "Dismissing loading view");
            if (m486b()) {
                this.f290a.m1125c();
                if (z && this.f290a != null && this.f290a.m1130h() != null) {
                    m490d(this.f290a.m1130h());
                }
            }
        }
    }

    public final void m487c(C0148a c0148a) {
        CBLogging.m101b("CBViewController", "Removing impression silently");
        if (m486b()) {
            m484a(c0148a, false);
        }
        c0148a.m303j();
        try {
            ((ViewGroup) this.f290a.getParent()).removeView(this.f290a);
        } catch (Throwable e) {
            CBLogging.m102b("CBViewController", "Exception removing impression silently", e);
        }
        this.f290a = null;
    }

    public final void m490d(C0148a c0148a) {
        CBLogging.m101b("CBViewController", "Removing impression");
        c0148a.f191b = C0145b.NONE;
        c0148a.m310q().m450b().m435c(c0148a);
        if (c0148a.m318y()) {
            c0148a.m310q().m450b().m434b(c0148a);
        }
        if (this.f290a != null) {
            try {
                ((ViewGroup) this.f290a.getParent()).removeView(this.f290a);
            } catch (Throwable e) {
                CBLogging.m102b("CBViewController", "Exception removing impression ", e);
            }
            c0148a.m302i();
            this.f290a = null;
            if (C0153b.m390e()) {
                m480e();
            }
        } else if (C0153b.m390e()) {
            m480e();
        }
    }

    private void m480e() {
        CBLogging.m101b("CBViewController", " Closing impression activity");
        Activity e = Chartboost.m52e();
        if (e != null && (e instanceof CBImpressionActivity)) {
            CBLogging.m101b("CBViewController", " Closing impression activity #######");
            Chartboost.m55f();
            e.finish();
        }
    }

    public final boolean m486b() {
        return this.f290a != null && this.f290a.m1129g();
    }

    public final boolean m488c() {
        return this.f290a != null;
    }

    public final bp m489d() {
        return this.f290a;
    }
}
