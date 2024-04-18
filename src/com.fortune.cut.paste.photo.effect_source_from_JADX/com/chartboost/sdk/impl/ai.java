package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.chartboost.sdk.C0177f;
import com.chartboost.sdk.C0177f.C0176a;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.C0132h;
import com.chartboost.sdk.Libraries.C0139j;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C0148a;
import com.chartboost.sdk.Model.C0148a.C0147d;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Tracking.C0151a;
import com.chartboost.sdk.impl.ah.C0193a;
import com.chartboost.sdk.impl.am.C0206a;
import com.chartboost.sdk.impl.bl.C0184b;
import com.chartboost.sdk.impl.bl.C0269a;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class ai extends ah {
    protected C0139j f405A;
    protected C0139j f406B;
    protected C0139j f407C;
    protected C0139j f408D;
    protected C0139j f409E;
    protected C0139j f410F;
    protected C0139j f411G;
    protected C0139j f412H;
    protected boolean f413I;
    protected boolean f414J;
    protected boolean f415K;
    private boolean f416L;
    private boolean f417M;
    private boolean f418N;
    private boolean f419O;
    private boolean f420P;
    protected C0202b f421p;
    protected int f422q;
    protected String f423r;
    protected int f424s;
    protected int f425t;
    protected boolean f426u;
    protected boolean f427v;
    protected boolean f428w;
    protected boolean f429x;
    protected boolean f430y;
    protected int f431z;

    /* renamed from: com.chartboost.sdk.impl.ai.1 */
    class C01941 extends C0184b {
        final /* synthetic */ ai f385a;

        C01941(ai aiVar) {
            this.f385a = aiVar;
        }

        public void m674a(bl blVar) {
            C0201a p = this.f385a.m734p();
            if (p != null) {
                p.f396i.m787e();
            }
        }

        public void m675a(bl blVar, int i) {
            C0201a p = this.f385a.m734p();
            if (i != 1) {
                if (p != null) {
                    p.m684d(false);
                    p.f396i.m790h();
                }
                this.f385a.m520h();
            } else if (p != null) {
                p.f396i.m787e();
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ai.2 */
    static /* synthetic */ class C01952 {
        static final /* synthetic */ int[] f386a;

        static {
            f386a = new int[C0202b.values().length];
            try {
                f386a[C0202b.REWARD_OFFER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f386a[C0202b.VIDEO_PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f386a[C0202b.POST_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ai.a */
    public class C0201a extends C0193a {
        final /* synthetic */ ai f394g;
        private bk f395h;
        private ao f396i;
        private al f397j;
        private ag f398k;
        private aj f399l;
        private bk f400m;

        /* renamed from: com.chartboost.sdk.impl.ai.a.1 */
        class C01961 extends bk {
            final /* synthetic */ ai f387a;
            final /* synthetic */ C0201a f388b;

            C01961(C0201a c0201a, Context context, ai aiVar) {
                this.f388b = c0201a;
                this.f387a = aiVar;
                super(context);
            }

            protected void m676a(MotionEvent motionEvent) {
                if (this.f388b.f394g.f.f194e == C0147d.INTERSTITIAL_REWARD_VIDEO) {
                    this.f388b.f399l.m652a(false);
                }
                if (this.f388b.f394g.f421p == C0202b.VIDEO_PLAYING) {
                    this.f388b.m684d(false);
                }
                C0151a.m342c(this.f388b.f394g.f423r, this.f388b.f394g.f.m309p());
                this.f388b.m683c(true);
            }
        }

        /* renamed from: com.chartboost.sdk.impl.ai.a.2 */
        class C01972 extends bk {
            final /* synthetic */ ai f389a;
            final /* synthetic */ C0201a f390b;

            C01972(C0201a c0201a, Context context, ai aiVar) {
                this.f390b = c0201a;
                this.f389a = aiVar;
                super(context);
            }

            protected void m677a(MotionEvent motionEvent) {
                this.f390b.m691e();
            }
        }

        /* renamed from: com.chartboost.sdk.impl.ai.a.3 */
        class C01983 implements Runnable {
            final /* synthetic */ C0201a f391a;

            C01983(C0201a c0201a) {
                this.f391a = c0201a;
            }

            public void run() {
                boolean z;
                String str = "InterstitialVideoViewProtocol";
                String str2 = "controls %s automatically from timer";
                Object[] objArr = new Object[1];
                objArr[0] = this.f391a.f394g.f426u ? "hidden" : "shown";
                CBLogging.m103c(str, String.format(str2, objArr));
                ao b = this.f391a.f396i;
                if (this.f391a.f394g.f426u) {
                    z = false;
                } else {
                    z = true;
                }
                b.m781a(z, true);
                this.f391a.f394g.h.remove(Integer.valueOf(this.f391a.f396i.hashCode()));
            }
        }

        /* renamed from: com.chartboost.sdk.impl.ai.a.4 */
        class C01994 implements Runnable {
            final /* synthetic */ C0201a f392a;

            C01994(C0201a c0201a) {
                this.f392a = c0201a;
            }

            public void run() {
                this.f392a.f399l.m652a(false);
            }
        }

        /* renamed from: com.chartboost.sdk.impl.ai.a.5 */
        class C02005 implements Runnable {
            final /* synthetic */ C0201a f393a;

            C02005(C0201a c0201a) {
                this.f393a = c0201a;
            }

            public void run() {
                this.f393a.f394g.m520h();
            }
        }

        private C0201a(ai aiVar, Context context) {
            this.f394g = aiVar;
            super(aiVar, context);
            if (aiVar.f.f194e == C0147d.INTERSTITIAL_REWARD_VIDEO) {
                this.f397j = new al(context, aiVar);
                this.f397j.setVisibility(8);
                addView(this.f397j);
            }
            this.f396i = new ao(context, aiVar);
            this.f396i.setVisibility(8);
            addView(this.f396i);
            this.f398k = new ag(context, aiVar);
            this.f398k.setVisibility(8);
            addView(this.f398k);
            if (aiVar.f.f194e == C0147d.INTERSTITIAL_REWARD_VIDEO) {
                this.f399l = new aj(context, aiVar);
                this.f399l.setVisibility(8);
                addView(this.f399l);
            }
            this.f395h = new C01961(this, getContext(), aiVar);
            this.f395h.setVisibility(8);
            addView(this.f395h);
            this.f400m = new C01972(this, getContext(), aiVar);
            this.f400m.setVisibility(8);
            addView(this.f400m);
            if (aiVar.m.m151a("progress").m159c("background-color") && aiVar.m.m151a("progress").m159c("border-color") && aiVar.m.m151a("progress").m159c("progress-color") && aiVar.m.m151a("progress").m159c("radius")) {
                aiVar.f413I = true;
                ak c = this.f396i.m784c();
                c.m750a(C0177f.m500a(aiVar.m.m151a("progress").m162e("background-color")));
                c.m753b(C0177f.m500a(aiVar.m.m151a("progress").m162e("border-color")));
                c.m754c(C0177f.m500a(aiVar.m.m151a("progress").m162e("progress-color")));
                c.m752b(aiVar.m.m151a("progress").m151a("radius").m172j());
            }
            if (aiVar.m.m151a("video-controls-background").m159c("color")) {
                this.f396i.m778a(C0177f.m500a(aiVar.m.m151a("video-controls-background").m162e("color")));
            }
            if (aiVar.f.f194e == C0147d.INTERSTITIAL_REWARD_VIDEO && aiVar.f428w) {
                this.f398k.m655a(aiVar.m.m151a("post-video-toaster").m162e(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE), aiVar.m.m151a("post-video-toaster").m162e("tagline"));
            }
            if (aiVar.f.f194e == C0147d.INTERSTITIAL_REWARD_VIDEO && aiVar.f427v) {
                this.f397j.m760a(aiVar.m.m151a("confirmation").m162e("text"), C0177f.m500a(aiVar.m.m151a("confirmation").m162e("color")));
            }
            if (aiVar.f.f194e == C0147d.INTERSTITIAL_REWARD_VIDEO && aiVar.f429x) {
                this.f399l.m651a(aiVar.m.m151a("post-video-reward-toaster").m151a("position").equals("inside-top") ? C0206a.TOP : C0206a.BOTTOM);
                this.f399l.m743a(aiVar.m.m151a("post-video-reward-toaster").m162e("text"));
                if (aiVar.f410F.m270e()) {
                    this.f399l.m742a(aiVar.f412H);
                }
            }
            if (aiVar.e.m151a("video-click-button").m155b()) {
                this.f396i.m786d();
            }
            this.f396i.m785c(aiVar.m.m171i("video-progress-timer-enabled"));
            if (aiVar.f415K || aiVar.f414J) {
                this.e.setVisibility(4);
            }
            aiVar.f423r = aiVar.e.m151a(aiVar.m504a().m189b() ? "video-portrait" : "video-landscape").m162e("id");
            this.f396i.m779a(bd.m993a(aiVar.f423r));
        }

        protected void m690d() {
            super.m662d();
            if (this.f394g.f421p != C0202b.REWARD_OFFER || (this.f394g.f427v && !this.f394g.m731m())) {
                m680a(this.f394g.f421p, false);
            } else {
                m683c(false);
            }
        }

        public void m692f() {
            m684d(true);
            this.f396i.m790h();
            ai aiVar = this.f394g;
            aiVar.f422q++;
            if (this.f394g.f422q <= 1 && !this.f394g.f420P) {
                this.f394g.m719w();
                if (this.f394g.f424s > 0) {
                    this.f394g.f.m299f();
                }
            }
        }

        protected void m687a(int i, int i2) {
            super.m660a(i, i2);
            m680a(this.f394g.f421p, false);
            boolean b = this.f394g.m504a().m189b();
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
            this.f394g.m669a(layoutParams, b ? this.f394g.f406B : this.f394g.f405A, TextTrackStyle.DEFAULT_FONT_SCALE);
            Point b2 = this.f394g.m671b(b ? "replay-portrait" : "replay-landscape");
            int round = Math.round(((((float) layoutParams5.leftMargin) + (((float) layoutParams5.width) / 2.0f)) + ((float) b2.x)) - (((float) layoutParams.width) / 2.0f));
            int round2 = Math.round((((((float) layoutParams5.height) / 2.0f) + ((float) layoutParams5.topMargin)) + ((float) b2.y)) - (((float) layoutParams.height) / 2.0f));
            layoutParams.leftMargin = Math.min(Math.max(0, round), i - layoutParams.width);
            layoutParams.topMargin = Math.min(Math.max(0, round2), i2 - layoutParams.height);
            this.f395h.bringToFront();
            if (b) {
                this.f395h.m643a(this.f394g.f406B);
            } else {
                this.f395h.m643a(this.f394g.f405A);
            }
            layoutParams5 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
            if (this.f394g.m736r()) {
                LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
                C0139j c0139j = b ? this.f394g.k : this.f394g.l;
                this.f394g.m669a(layoutParams6, c0139j, TextTrackStyle.DEFAULT_FONT_SCALE);
                layoutParams6.leftMargin = 0;
                layoutParams6.topMargin = 0;
                layoutParams6.addRule(11);
                this.f400m.setLayoutParams(layoutParams6);
                this.f400m.m643a(c0139j);
            } else {
                layoutParams2.width = layoutParams5.width;
                layoutParams2.height = layoutParams5.height;
                layoutParams2.leftMargin = layoutParams5.leftMargin;
                layoutParams2.topMargin = layoutParams5.topMargin;
                layoutParams3.width = layoutParams5.width;
                layoutParams3.height = layoutParams5.height;
                layoutParams3.leftMargin = layoutParams5.leftMargin;
                layoutParams3.topMargin = layoutParams5.topMargin;
            }
            layoutParams4.width = layoutParams5.width;
            layoutParams4.height = 72;
            layoutParams4.leftMargin = layoutParams5.leftMargin;
            layoutParams4.topMargin = (layoutParams5.height + layoutParams5.topMargin) - 72;
            if (this.f394g.f.f194e == C0147d.INTERSTITIAL_REWARD_VIDEO) {
                this.f397j.setLayoutParams(layoutParams2);
            }
            this.f396i.setLayoutParams(layoutParams3);
            this.f398k.setLayoutParams(layoutParams4);
            this.f395h.setLayoutParams(layoutParams);
            if (this.f394g.f.f194e == C0147d.INTERSTITIAL_REWARD_VIDEO) {
                this.f397j.m759a();
            }
            this.f396i.m777a();
        }

        private void m683c(boolean z) {
            if (this.f394g.f421p != C0202b.VIDEO_PLAYING) {
                if (this.f394g.f427v) {
                    C0151a.m338b("integrated", this.f394g.n);
                    m680a(C0202b.REWARD_OFFER, z);
                    return;
                }
                m680a(C0202b.VIDEO_PLAYING, z);
                if (this.f394g.f422q > 0 || !this.f394g.m.m151a("timer").m159c("delay")) {
                    this.f396i.m780a(!this.f394g.f426u);
                } else {
                    String str = "InterstitialVideoViewProtocol";
                    String str2 = "controls starting %s, setting timer";
                    Object[] objArr = new Object[1];
                    objArr[0] = this.f394g.f426u ? "visible" : "hidden";
                    CBLogging.m103c(str, String.format(str2, objArr));
                    this.f396i.m780a(this.f394g.f426u);
                    this.f394g.m505a(this.f396i, new C01983(this), Math.round(1000.0d * this.f394g.m.m151a("timer").m166g("delay")));
                }
                C0151a.m328a(this.f394g.f423r, this.f394g.n, this.f394g.f422q);
                this.f396i.m787e();
                if (this.f394g.f422q <= 1) {
                    this.f394g.f.m300g();
                }
            }
        }

        private void m684d(boolean z) {
            this.f396i.m788f();
            C0151a.m346d(this.f394g.f423r, this.f394g.n);
            if (this.f394g.f421p == C0202b.VIDEO_PLAYING && z) {
                if (this.f394g.f422q <= 0 && this.f394g.m.m159c("post-video-reward-toaster") && this.f394g.f429x && this.f394g.f410F.m270e() && this.f394g.f411G.m270e()) {
                    m685e(true);
                }
                m680a(C0202b.POST_VIDEO, true);
                if (CBUtility.m118c().m189b()) {
                    requestLayout();
                }
            }
        }

        private void m685e(boolean z) {
            if (z) {
                this.f399l.m652a(true);
            } else {
                this.f399l.setVisibility(0);
            }
            C0177f.f303a.postDelayed(new C01994(this), 2500);
        }

        private void m680a(C0202b c0202b, boolean z) {
            boolean z2;
            boolean z3 = true;
            this.f394g.f421p = c0202b;
            switch (C01952.f386a[c0202b.ordinal()]) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    this.f394g.m509a(!this.f394g.m736r(), this.d, z);
                    if (this.f394g.f.f194e == C0147d.INTERSTITIAL_REWARD_VIDEO) {
                        this.f394g.m509a(true, this.f397j, z);
                    }
                    this.f394g.m509a(false, this.f396i, z);
                    this.f394g.m509a(false, this.f395h, z);
                    this.f394g.m509a(false, this.f398k, z);
                    this.d.setEnabled(false);
                    this.f395h.setEnabled(false);
                    this.f396i.setEnabled(false);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    this.f394g.m509a(false, this.d, z);
                    if (this.f394g.f.f194e == C0147d.INTERSTITIAL_REWARD_VIDEO) {
                        this.f394g.m509a(false, this.f397j, z);
                    }
                    this.f394g.m509a(true, this.f396i, z);
                    this.f394g.m509a(false, this.f395h, z);
                    this.f394g.m509a(false, this.f398k, z);
                    this.d.setEnabled(true);
                    this.f395h.setEnabled(false);
                    this.f396i.setEnabled(true);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    this.f394g.m509a(true, this.d, z);
                    if (this.f394g.f.f194e == C0147d.INTERSTITIAL_REWARD_VIDEO) {
                        this.f394g.m509a(false, this.f397j, z);
                    }
                    this.f394g.m509a(false, this.f396i, z);
                    this.f394g.m509a(true, this.f395h, z);
                    z2 = this.f394g.f411G.m270e() && this.f394g.f410F.m270e() && this.f394g.f428w;
                    this.f394g.m509a(z2, this.f398k, z);
                    this.f395h.setEnabled(true);
                    this.d.setEnabled(true);
                    this.f396i.setEnabled(false);
                    if (this.f394g.f430y) {
                        m685e(false);
                        break;
                    }
                    break;
            }
            z2 = m693g();
            View b = m688b(true);
            b.setEnabled(z2);
            this.f394g.m509a(z2, b, z);
            View b2 = m688b(false);
            b2.setEnabled(false);
            this.f394g.m509a(false, b2, z);
            if (this.f394g.f415K || this.f394g.f414J) {
                this.f394g.m509a(!this.f394g.m736r(), this.e, z);
            }
            ai aiVar = this.f394g;
            if (this.f394g.m736r()) {
                z2 = false;
            } else {
                z2 = true;
            }
            aiVar.m509a(z2, this.b, z);
            if (c0202b == C0202b.REWARD_OFFER) {
                z3 = false;
            }
            m496a(z3);
        }

        protected boolean m693g() {
            if (this.f394g.f421p == C0202b.VIDEO_PLAYING && this.f394g.f422q <= 0) {
                float a = this.f394g.e.m151a("close-" + (this.f394g.m504a().m189b() ? "portrait" : "landscape")).m151a("delay").m149a((float) GroundOverlayOptions.NO_DIMENSION);
                int round = a >= 0.0f ? Math.round(a * 1000.0f) : -1;
                this.f394g.f431z = round;
                if (round < 0 || round > this.f396i.m782b().m1026d()) {
                    return false;
                }
            }
            return true;
        }

        public void m689b() {
            this.f394g.m730l();
            super.m661b();
        }

        protected void m691e() {
            if (this.f394g.f421p == C0202b.VIDEO_PLAYING && this.f394g.m.m151a("cancel-popup").m159c(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE) && this.f394g.m.m151a("cancel-popup").m159c("text") && this.f394g.m.m151a("cancel-popup").m159c("cancel") && this.f394g.m.m151a("cancel-popup").m159c("confirm")) {
                this.f396i.m789g();
                if (this.f394g.f422q <= 0) {
                    this.f394g.m732n();
                    return;
                }
            }
            if (this.f394g.f421p == C0202b.VIDEO_PLAYING) {
                m684d(false);
                this.f396i.m790h();
                if (this.f394g.f422q <= 0) {
                    ai aiVar = this.f394g;
                    aiVar.f422q++;
                    this.f394g.m719w();
                    this.f394g.f.m299f();
                }
            }
            C0177f.f303a.post(new C02005(this));
            C0151a.m339b(this.f394g.f423r, this.f394g.n, this.f394g.f431z);
        }

        protected void m686a(float f, float f2) {
            if ((!this.f394g.f426u || this.f394g.f421p != C0202b.VIDEO_PLAYING) && this.f394g.f421p != C0202b.REWARD_OFFER) {
                m694h();
                C0151a.m332a("insterstitial", this.f394g.f423r, this.f394g.f.m309p(), (int) f, (int) f2);
            }
        }

        protected void m694h() {
            if (this.f394g.f421p == C0202b.VIDEO_PLAYING) {
                m684d(false);
            }
            this.f394g.m511a(null, null);
        }

        protected void m695i() {
            C0151a.m348d("integrated", this.f394g.n, true);
            this.f394g.f427v = false;
            m683c(true);
        }

        public bk m688b(boolean z) {
            return (!(this.f394g.m736r() && z) && (this.f394g.m736r() || z)) ? this.c : this.f400m;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ai.b */
    protected enum C0202b {
        REWARD_OFFER,
        VIDEO_PLAYING,
        POST_VIDEO
    }

    public /* synthetic */ C0176a m726e() {
        return m734p();
    }

    public ai(C0148a c0148a) {
        super(c0148a);
        this.f421p = C0202b.REWARD_OFFER;
        this.f416L = true;
        this.f417M = false;
        this.f418N = false;
        this.f424s = 0;
        this.f425t = 0;
        this.f419O = false;
        this.f420P = false;
        this.f430y = false;
        this.f431z = 0;
        this.f413I = false;
        this.f414J = false;
        this.f415K = false;
        this.f421p = C0202b.REWARD_OFFER;
        this.f405A = new C0139j(this);
        this.f406B = new C0139j(this);
        this.f407C = new C0139j(this);
        this.f408D = new C0139j(this);
        this.f409E = new C0139j(this);
        this.f410F = new C0139j(this);
        this.f411G = new C0139j(this);
        this.f412H = new C0139j(this);
        this.f422q = 0;
    }

    public boolean m731m() {
        return this.f.f194e == C0147d.INTERSTITIAL_VIDEO;
    }

    public void m732n() {
        C0269a c0269a = new C0269a();
        c0269a.m1113a(this.m.m151a("cancel-popup").m162e(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)).m1115b(this.m.m151a("cancel-popup").m162e("text")).m1117d(this.m.m151a("cancel-popup").m162e("confirm")).m1116c(this.m.m151a("cancel-popup").m162e("cancel"));
        c0269a.m1114a(m734p().getContext(), new C01941(this));
    }

    protected C0176a m724b(Context context) {
        return new C0201a(context, null);
    }

    public boolean m728j() {
        if (!(m734p().m688b(true).getVisibility() == 4 || m734p().m688b(true).getVisibility() == 8)) {
            m734p().m691e();
        }
        return true;
    }

    public void m729k() {
        super.m523k();
        if (this.f421p == C0202b.VIDEO_PLAYING && this.f417M) {
            m734p().f396i.m782b().m1018a(this.f424s);
            if (!this.f418N) {
                m734p().f396i.m787e();
            }
        }
        this.f418N = false;
        this.f417M = false;
    }

    public void m730l() {
        super.m524l();
        if (this.f421p == C0202b.VIDEO_PLAYING && !this.f417M) {
            if (!m734p().f396i.m791i()) {
                this.f418N = true;
            }
            this.f417M = true;
            m734p().f396i.m789g();
            if (this.f422q <= 0 && this.f419O) {
                m721x();
            }
        }
    }

    private void m719w() {
        C0132h.m230c().m240b(Integer.toString(this.f.hashCode()));
    }

    private void m721x() {
        float f = (float) this.f424s;
        float f2 = (float) this.f425t;
        az azVar = new az("/api/video-complete");
        azVar.m897b(null);
        azVar.m891a("location", this.f.f193d);
        azVar.m891a("reward", this.f.m316w().m162e("reward"));
        azVar.m891a("currency-name", this.f.m316w().m162e("currency-name"));
        azVar.m891a("ad_id", this.f.m309p());
        azVar.m891a("total_time", Float.valueOf(f2 / 1000.0f));
        azVar.m891a("playback_time", Float.valueOf(f / 1000.0f));
        azVar.m891a("force_close", Boolean.valueOf(true));
        C0132h.m230c().m236a(Integer.toString(this.f.hashCode()), azVar.m919t());
    }

    public boolean m723a(C0111a c0111a) {
        boolean z = false;
        if (!super.m670a(c0111a)) {
            return false;
        }
        if (this.e.m156b("video-landscape") || this.e.m156b("replay-landscape")) {
            this.j = false;
        }
        this.f405A.m265a("replay-landscape");
        this.f406B.m265a("replay-portrait");
        this.f409E.m265a("video-click-button");
        this.f410F.m265a("post-video-reward-icon");
        this.f411G.m265a("post-video-button");
        this.f407C.m265a("video-confirmation-button");
        this.f408D.m265a("video-confirmation-icon");
        this.f412H.m265a("post-video-reward-icon");
        this.f426u = c0111a.m151a("ux").m171i("video-controls-togglable");
        this.f414J = c0111a.m151a("fullscreen").m155b() ? false : c0111a.m151a("fullscreen").m175m();
        if (!c0111a.m151a("preroll_popup_fullscreen").m155b()) {
            z = c0111a.m151a("preroll_popup_fullscreen").m175m();
        }
        this.f415K = z;
        if (this.f.f194e == C0147d.INTERSTITIAL_REWARD_VIDEO && this.m.m151a("post-video-toaster").m159c(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE) && this.m.m151a("post-video-toaster").m159c("tagline")) {
            this.f428w = true;
        }
        if (this.f.f194e == C0147d.INTERSTITIAL_REWARD_VIDEO && this.m.m151a("confirmation").m159c("text") && this.m.m151a("confirmation").m159c("color")) {
            this.f427v = true;
        }
        if (this.f.f194e == C0147d.INTERSTITIAL_REWARD_VIDEO && this.m.m159c("post-video-reward-toaster")) {
            this.f429x = true;
        }
        return true;
    }

    protected void m727i() {
        if (this.f427v && !(this.f407C.m270e() && this.f408D.m270e())) {
            this.f427v = false;
        }
        if (this.f416L) {
            super.m521i();
        } else {
            m506a(CBImpressionError.ERROR_DISPLAYING_VIEW);
        }
    }

    public void m725d() {
        super.m673d();
        this.f405A.m269d();
        this.f406B.m269d();
        this.f409E.m269d();
        this.f410F.m269d();
        this.f411G.m269d();
        this.f407C.m269d();
        this.f408D.m269d();
        this.f412H.m269d();
        this.f405A = null;
        this.f406B = null;
        this.f409E = null;
        this.f410F = null;
        this.f411G = null;
        this.f407C = null;
        this.f408D = null;
        this.f412H = null;
    }

    public boolean m733o() {
        return this.f421p == C0202b.VIDEO_PLAYING;
    }

    public C0201a m734p() {
        return (C0201a) super.m517e();
    }

    protected void m735q() {
        this.f.m311r();
    }

    protected boolean m736r() {
        if (this.f421p == C0202b.POST_VIDEO) {
            return false;
        }
        boolean b = CBUtility.m118c().m189b();
        if (this.f421p == C0202b.REWARD_OFFER) {
            if (this.f415K || b) {
                return true;
            }
            return false;
        } else if (this.f421p == C0202b.VIDEO_PLAYING) {
            if (this.f414J || b) {
                return true;
            }
            return false;
        } else if (!b || this.f421p == C0202b.POST_VIDEO) {
            return false;
        } else {
            return true;
        }
    }

    public boolean m737s() {
        return this.f419O;
    }

    public void m722a(boolean z) {
        this.f419O = z;
    }

    public void m738t() {
        this.f420P = true;
        bd.m1001b(this.f423r);
        m506a(CBImpressionError.ERROR_PLAYING_VIDEO);
    }

    public int m739u() {
        return this.f425t;
    }

    public int m740v() {
        return this.f424s;
    }
}
