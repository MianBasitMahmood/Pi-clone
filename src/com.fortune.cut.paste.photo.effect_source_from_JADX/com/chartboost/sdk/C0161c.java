package com.chartboost.sdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C0148a;
import com.chartboost.sdk.Model.C0148a.C0144a;
import com.chartboost.sdk.Model.C0148a.C0145b;
import com.chartboost.sdk.Model.C0148a.C0146c;
import com.chartboost.sdk.Model.CBError.CBClickError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Tracking.C0151a;
import com.chartboost.sdk.impl.ai;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.bb;
import com.chartboost.sdk.impl.bb.C0158a;
import com.chartboost.sdk.impl.bp;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.chartboost.sdk.c */
public final class C0161c {
    private static final String f265c;
    private static C0161c f266d;
    public C0144a f267a;
    public C0158a f268b;
    private bb f269e;

    /* renamed from: com.chartboost.sdk.c.b */
    public interface C0094b {
        void m75a();
    }

    /* renamed from: com.chartboost.sdk.c.a */
    public interface C0155a {
        void m410a(boolean z);
    }

    /* renamed from: com.chartboost.sdk.c.1 */
    class C01561 implements C0155a {
        final /* synthetic */ C0148a f258a;
        final /* synthetic */ String f259b;
        final /* synthetic */ C0094b f260c;
        final /* synthetic */ C0161c f261d;

        /* renamed from: com.chartboost.sdk.c.1.1 */
        class C01541 implements Runnable {
            final /* synthetic */ boolean f256a;
            final /* synthetic */ C01561 f257b;

            C01541(C01561 c01561, boolean z) {
                this.f257b = c01561;
                this.f256a = z;
            }

            public void run() {
                if (this.f256a) {
                    this.f257b.f261d.m423a(this.f257b.f258a, this.f257b.f259b, this.f257b.f260c);
                } else {
                    this.f257b.f261d.f268b.m418a(this.f257b.f258a, false, this.f257b.f259b, CBClickError.AGE_GATE_FAILURE, this.f257b.f260c);
                }
            }
        }

        C01561(C0161c c0161c, C0148a c0148a, String str, C0094b c0094b) {
            this.f261d = c0161c;
            this.f258a = c0148a;
            this.f259b = str;
            this.f260c = c0094b;
        }

        public void m411a(boolean z) {
            Chartboost.m36a(new C01541(this, z));
        }
    }

    /* renamed from: com.chartboost.sdk.c.2 */
    class C01572 implements C0144a {
        final /* synthetic */ C0161c f262a;

        C01572(C0161c c0161c) {
            this.f262a = c0161c;
        }

        public void m412a(C0148a c0148a) {
            synchronized (this.f262a) {
                boolean z = c0148a.f195f;
            }
            if (c0148a.f191b == C0145b.LOADING) {
                c0148a.f191b = C0145b.LOADED;
                if (z) {
                    c0148a.m310q().m445a(c0148a);
                }
            }
            if (!z) {
                c0148a.m310q().m464g(c0148a);
            }
            c0148a.m310q().m472o(c0148a);
        }

        public void m415b(C0148a c0148a) {
            if (c0148a.f191b == C0145b.DISPLAYED) {
                C0173e g = Chartboost.m57g();
                if (g != null) {
                    g.m485b(c0148a);
                }
            }
            C0151a.m343c(c0148a.m310q().m461e(), c0148a.f193d, c0148a.m309p());
        }

        public void m414a(C0148a c0148a, String str, C0111a c0111a) {
            c0148a.m310q().m450b().m432a(c0148a);
            if (c0148a.m293a() && c0148a.f191b == C0145b.DISPLAYED) {
                C0173e g = Chartboost.m57g();
                if (g != null) {
                    g.m485b(c0148a);
                }
            }
            if (!TextUtils.isEmpty(str)) {
                az d = this.f262a.m428d();
                d.m890a("to", c0148a.m316w());
                d.m890a("cgn", c0148a.m316w());
                d.m890a("creative", c0148a.m316w());
                d.m890a("ad_id", c0148a.m316w());
                d.m890a("cgn", c0111a);
                d.m890a("creative", c0111a);
                d.m890a("type", c0111a);
                d.m890a("more_type", c0111a);
                d.m891a("location", c0148a.f193d);
                if (c0148a.m297d()) {
                    d.m891a("retarget_reinstall", Boolean.valueOf(c0148a.m298e()));
                }
                c0148a.f203n = d;
                this.f262a.m425b(c0148a, str, null);
            } else {
                this.f262a.f268b.m418a(c0148a, false, str, CBClickError.URI_INVALID, null);
            }
            C0151a.m340b(c0148a.m310q().m461e(), c0148a.f193d, c0148a.m309p());
        }

        public void m413a(C0148a c0148a, CBImpressionError cBImpressionError) {
            c0148a.m310q().m447a(c0148a, cBImpressionError);
        }

        public void m416c(C0148a c0148a) {
            c0148a.f201l = true;
            if (c0148a.f192c == C0146c.REWARDED_VIDEO && C0153b.m387d() != null) {
                C0153b.m387d().didCompleteRewardedVideo(c0148a.f193d, c0148a.m316w().m164f("reward"));
            }
            C0161c.m422b(c0148a);
        }

        public void m417d(C0148a c0148a) {
            c0148a.f202m = true;
        }
    }

    /* renamed from: com.chartboost.sdk.c.3 */
    class C01593 implements C0158a {
        final /* synthetic */ C0161c f263a;

        C01593(C0161c c0161c) {
            this.f263a = c0161c;
        }

        public void m419a(C0148a c0148a, boolean z, String str, CBClickError cBClickError, C0094b c0094b) {
            if (c0148a != null) {
                c0148a.f204o = false;
                if (c0148a.m293a()) {
                    c0148a.f191b = C0145b.DISMISSING;
                }
            }
            if (z) {
                if (c0148a != null && c0148a.f203n != null) {
                    c0148a.f203n.m893a(true);
                    c0148a.f203n.m918s();
                } else if (c0094b != null) {
                    c0094b.m75a();
                }
            } else if (C0153b.m387d() != null) {
                C0153b.m387d().didFailToRecordClick(str, cBClickError);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.c.4 */
    static /* synthetic */ class C01604 {
        static final /* synthetic */ int[] f264a;

        static {
            f264a = new int[C0145b.values().length];
            try {
                f264a[C0145b.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f264a[C0145b.CACHED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f264a[C0145b.LOADED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f264a[C0145b.DISPLAYED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    static {
        f265c = C0161c.class.getSimpleName();
    }

    private C0161c() {
        this.f267a = new C01572(this);
        this.f268b = new C01593(this);
        this.f269e = bb.m959a(this.f268b);
    }

    public static C0161c m420a() {
        if (f266d == null) {
            f266d = new C0161c();
        }
        return f266d;
    }

    public final void m423a(C0148a c0148a, String str, C0094b c0094b) {
        this.f269e.m963a(c0148a, str, Chartboost.getHostActivity(), c0094b);
    }

    public final void m425b(C0148a c0148a, String str, C0094b c0094b) {
        C0153b.f240c = new C01561(this, c0148a, str, c0094b);
        if (!C0153b.m405q()) {
            m423a(c0148a, str, c0094b);
        } else if (C0153b.m387d() != null) {
            C0153b.m387d().didPauseClickForConfirmation();
            if (c0148a != null) {
                c0148a.f204o = false;
            }
        }
    }

    protected final boolean m426b() {
        C0148a c = m427c();
        if (c == null) {
            return false;
        }
        c.f205p = true;
        this.f267a.m286b(c);
        return true;
    }

    private static synchronized void m422b(C0148a c0148a) {
        synchronized (C0161c.class) {
            ai aiVar = null;
            if (c0148a.m305l() != null) {
                aiVar = (ai) c0148a.m317x();
            }
            az azVar = new az("/api/video-complete");
            azVar.m891a("location", c0148a.f193d);
            azVar.m891a("reward", c0148a.m316w().m162e("reward"));
            azVar.m891a("currency-name", c0148a.m316w().m162e("currency-name"));
            azVar.m891a("ad_id", c0148a.m309p());
            azVar.m891a("force_close", Boolean.valueOf(false));
            if (aiVar != null) {
                float v = (float) aiVar.m740v();
                float u = (float) aiVar.m739u();
                CBLogging.m97a(c0148a.m310q().getClass().getSimpleName(), String.format("TotalDuration: %f PlaybackTime: %f", new Object[]{Float.valueOf(u), Float.valueOf(v)}));
                azVar.m891a("total_time", Float.valueOf(u / 1000.0f));
                if (v < 0.0f) {
                    azVar.m891a("playback_time", Float.valueOf(u / 1000.0f));
                } else {
                    azVar.m891a("playback_time", Float.valueOf(v / 1000.0f));
                }
            }
            azVar.m893a(true);
            azVar.m918s();
        }
    }

    protected final C0148a m427c() {
        C0173e g = Chartboost.m57g();
        bp d = g == null ? null : g.m489d();
        if (d == null) {
            return null;
        }
        return d.m1130h();
    }

    public final az m428d() {
        az azVar = new az("/api/click");
        Context e = Chartboost.m52e();
        if (e == null) {
            e = Chartboost.getValidContext();
        }
        azVar.m896b(e);
        return azVar;
    }

    public final boolean m424a(Activity activity, C0148a c0148a) {
        if (c0148a != null) {
            switch (C01604.f264a[c0148a.f191b.ordinal()]) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    if (c0148a.f198i) {
                        Chartboost.m35a(c0148a);
                        break;
                    }
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                case WalletFragmentState.PROCESSING /*3*/:
                    Chartboost.m35a(c0148a);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    if (!c0148a.m301h()) {
                        if (C0153b.m373a() == null || !C0153b.m373a().doesWrapperUseCustomBackgroundingBehavior() || (activity instanceof CBImpressionActivity)) {
                            C0173e g = Chartboost.m57g();
                            if (g != null) {
                                CBLogging.m101b(f265c, "Error onActivityStart " + c0148a.f191b.name());
                                g.m490d(c0148a);
                                break;
                            }
                        }
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
