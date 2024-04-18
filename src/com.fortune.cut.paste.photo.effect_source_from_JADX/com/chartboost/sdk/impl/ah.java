package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.chartboost.sdk.C0177f;
import com.chartboost.sdk.C0177f.C0176a;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.C0139j;
import com.chartboost.sdk.Model.C0148a;
import com.google.android.gms.cast.TextTrackStyle;

public class ah extends C0177f {
    protected C0139j f376k;
    protected C0139j f377l;
    protected C0111a f378m;
    protected String f379n;
    protected float f380o;
    private C0139j f381p;
    private C0139j f382q;
    private C0139j f383r;
    private C0139j f384s;

    /* renamed from: com.chartboost.sdk.impl.ah.a */
    public class C0193a extends C0176a {
        protected bj f370b;
        protected bk f371c;
        protected bk f372d;
        protected ImageView f373e;
        final /* synthetic */ ah f374f;
        private boolean f375g;

        /* renamed from: com.chartboost.sdk.impl.ah.a.1 */
        class C01911 extends bk {
            final /* synthetic */ ah f367a;
            final /* synthetic */ C0193a f368b;

            C01911(C0193a c0193a, Context context, ah ahVar) {
                this.f368b = c0193a;
                this.f367a = ahVar;
                super(context);
            }

            protected void m657a(MotionEvent motionEvent) {
                this.f368b.m659a(motionEvent.getX(), motionEvent.getY());
            }
        }

        /* renamed from: com.chartboost.sdk.impl.ah.a.2 */
        class C01922 extends bk {
            final /* synthetic */ C0193a f369a;

            C01922(C0193a c0193a, Context context) {
                this.f369a = c0193a;
                super(context);
            }

            protected void m658a(MotionEvent motionEvent) {
                this.f369a.m663e();
            }
        }

        protected C0193a(ah ahVar, Context context) {
            this.f374f = ahVar;
            super(ahVar, context);
            this.f375g = false;
            setBackgroundColor(0);
            setLayoutParams(new LayoutParams(-1, -1));
            this.f370b = new bj(context);
            addView(this.f370b, new LayoutParams(-1, -1));
            this.f372d = new C01911(this, context, ahVar);
            m495a(this.f372d);
            this.f373e = new ImageView(context);
            this.f373e.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            addView(this.f373e);
            addView(this.f372d);
        }

        protected void m662d() {
            this.f371c = new C01922(this, getContext());
            addView(this.f371c);
        }

        protected void m659a(float f, float f2) {
            this.f374f.m511a(null, null);
        }

        protected void m660a(int i, int i2) {
            C0139j c0139j;
            int round;
            int round2;
            if (!this.f375g) {
                m662d();
                this.f375g = true;
            }
            boolean b = this.f374f.m504a().m189b();
            C0139j a = b ? this.f374f.f381p : this.f374f.f382q;
            if (b) {
                c0139j = this.f374f.f376k;
            } else {
                c0139j = this.f374f.f377l;
            }
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
            this.f374f.m669a(layoutParams, a, TextTrackStyle.DEFAULT_FONT_SCALE);
            this.f374f.f380o = Math.min(Math.min(((float) i) / ((float) layoutParams.width), ((float) i2) / ((float) layoutParams.height)), TextTrackStyle.DEFAULT_FONT_SCALE);
            layoutParams.width = (int) (((float) layoutParams.width) * this.f374f.f380o);
            layoutParams.height = (int) (((float) layoutParams.height) * this.f374f.f380o);
            Point b2 = this.f374f.m671b(b ? "frame-portrait" : "frame-landscape");
            layoutParams.leftMargin = Math.round((((float) (i - layoutParams.width)) / 2.0f) + ((((float) b2.x) / a.m272g()) * this.f374f.f380o));
            layoutParams.topMargin = Math.round(((((float) b2.y) / a.m272g()) * this.f374f.f380o) + (((float) (i2 - layoutParams.height)) / 2.0f));
            this.f374f.m669a(layoutParams2, c0139j, TextTrackStyle.DEFAULT_FONT_SCALE);
            Point b3 = this.f374f.m671b(b ? "close-portrait" : "close-landscape");
            if (b3.x == 0 && b3.y == 0) {
                round = (layoutParams.leftMargin + layoutParams.width) + Math.round(((float) (-layoutParams2.width)) / 2.0f);
                round2 = layoutParams.topMargin + Math.round(((float) (-layoutParams2.height)) / 2.0f);
            } else {
                round = Math.round(((((float) layoutParams.leftMargin) + (((float) layoutParams.width) / 2.0f)) + ((float) b3.x)) - (((float) layoutParams2.width) / 2.0f));
                round2 = Math.round((((float) b3.y) + (((float) layoutParams.topMargin) + (((float) layoutParams.height) / 2.0f))) - (((float) layoutParams2.height) / 2.0f));
            }
            layoutParams2.leftMargin = Math.min(Math.max(0, round), i - layoutParams2.width);
            layoutParams2.topMargin = Math.min(Math.max(0, round2), i2 - layoutParams2.height);
            this.f370b.setLayoutParams(layoutParams);
            this.f371c.setLayoutParams(layoutParams2);
            this.f370b.setScaleType(ScaleType.FIT_CENTER);
            this.f370b.m814a(a);
            this.f371c.m643a(c0139j);
            c0139j = b ? this.f374f.f383r : this.f374f.f384s;
            ViewGroup.LayoutParams layoutParams3 = new LayoutParams(-2, -2);
            this.f374f.m669a(layoutParams3, c0139j, this.f374f.f380o);
            b2 = this.f374f.m671b(b ? "ad-portrait" : "ad-landscape");
            layoutParams3.leftMargin = Math.round((((float) (i - layoutParams3.width)) / 2.0f) + ((((float) b2.x) / c0139j.m272g()) * this.f374f.f380o));
            layoutParams3.topMargin = Math.round(((((float) b2.y) / c0139j.m272g()) * this.f374f.f380o) + (((float) (i2 - layoutParams3.height)) / 2.0f));
            this.f373e.setLayoutParams(layoutParams3);
            this.f372d.setLayoutParams(layoutParams3);
            this.f372d.m642a(ScaleType.FIT_CENTER);
            this.f372d.m643a(c0139j);
        }

        protected void m663e() {
            this.f374f.m520h();
        }

        public void m661b() {
            super.m498b();
            this.f370b = null;
            this.f371c = null;
            this.f372d = null;
            this.f373e = null;
        }
    }

    public ah(C0148a c0148a) {
        super(c0148a);
        this.f380o = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.f381p = new C0139j(this);
        this.f382q = new C0139j(this);
        this.f376k = new C0139j(this);
        this.f377l = new C0139j(this);
        this.f383r = new C0139j(this);
        this.f384s = new C0139j(this);
    }

    protected C0176a m672b(Context context) {
        return new C0193a(this, context);
    }

    public boolean m670a(C0111a c0111a) {
        if (!super.m510a(c0111a)) {
            return false;
        }
        this.f379n = c0111a.m162e("ad_id");
        this.f378m = c0111a.m151a("ux");
        if (this.e.m156b("frame-portrait") || this.e.m156b("close-portrait")) {
            this.i = false;
        }
        if (this.e.m156b("frame-landscape") || this.e.m156b("close-landscape")) {
            this.j = false;
        }
        this.f382q.m265a("frame-landscape");
        this.f381p.m265a("frame-portrait");
        this.f377l.m265a("close-landscape");
        this.f376k.m265a("close-portrait");
        if (this.e.m156b("ad-portrait")) {
            this.i = false;
        }
        if (this.e.m156b("ad-landscape")) {
            this.j = false;
        }
        this.f384s.m265a("ad-landscape");
        this.f383r.m265a("ad-portrait");
        return true;
    }

    protected Point m671b(String str) {
        C0111a a = this.e.m151a(str).m151a("offset");
        if (a.m158c()) {
            return new Point(a.m164f("x"), a.m164f("y"));
        }
        return new Point(0, 0);
    }

    public void m669a(ViewGroup.LayoutParams layoutParams, C0139j c0139j, float f) {
        layoutParams.width = (int) ((((float) c0139j.m267b()) / c0139j.m272g()) * f);
        layoutParams.height = (int) ((((float) c0139j.m268c()) / c0139j.m272g()) * f);
    }

    public void m673d() {
        super.m516d();
        this.f382q.m269d();
        this.f381p.m269d();
        this.f377l.m269d();
        this.f376k.m269d();
        this.f384s.m269d();
        this.f383r.m269d();
        this.f382q = null;
        this.f381p = null;
        this.f377l = null;
        this.f376k = null;
        this.f384s = null;
        this.f383r = null;
    }
}
