package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.chartboost.sdk.C0153b;
import com.chartboost.sdk.C0177f;
import com.chartboost.sdk.C0177f.C0176a;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.C0115f;
import com.chartboost.sdk.Libraries.C0139j;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C0148a;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Tracking.C0151a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class aw extends C0177f {
    protected C0139j f543k;
    protected C0139j f544l;
    private List<C0111a> f545m;
    private C0139j f546n;
    private C0139j f547o;
    private C0139j f548p;
    private C0139j f549q;
    private C0139j f550r;
    private C0139j f551s;
    private C0139j f552t;
    private Set<C0139j> f553u;
    private int f554v;
    private C0111a f555w;
    private int f556x;
    private int f557y;
    private String f558z;

    /* renamed from: com.chartboost.sdk.impl.aw.a */
    public class C0221a extends C0176a {
        final /* synthetic */ aw f529b;
        private bk f530c;
        private bj f531d;
        private TextView f532e;
        private RelativeLayout f533f;
        private ListView f534g;
        private C0220a f535h;

        /* renamed from: com.chartboost.sdk.impl.aw.a.1 */
        class C02181 extends bk {
            final /* synthetic */ aw f522a;
            final /* synthetic */ C0221a f523b;

            C02181(C0221a c0221a, Context context, aw awVar) {
                this.f523b = c0221a;
                this.f522a = awVar;
                super(context);
            }

            protected void m840a(MotionEvent motionEvent) {
                this.f523b.f529b.m520h();
            }
        }

        /* renamed from: com.chartboost.sdk.impl.aw.a.a */
        public class C0220a extends ArrayAdapter<C0111a> {
            final /* synthetic */ C0221a f527a;
            private Context f528b;

            /* renamed from: com.chartboost.sdk.impl.aw.a.a.1 */
            class C02191 implements OnClickListener {
                final /* synthetic */ C0111a f524a;
                final /* synthetic */ int f525b;
                final /* synthetic */ C0220a f526c;

                C02191(C0220a c0220a, C0111a c0111a, int i) {
                    this.f526c = c0220a;
                    this.f524a = c0111a;
                    this.f525b = i;
                }

                public void onClick(View view) {
                    String e = this.f524a.m162e("deep-link");
                    if (TextUtils.isEmpty(e) || !bb.m962a(e)) {
                        e = this.f524a.m162e("link");
                    }
                    if (this.f526c.f527a.f529b.m511a(e, this.f524a)) {
                        C0151a.m331a(this.f526c.f527a.f529b.f.m310q().m461e(), this.f524a.m162e("location"), this.f524a.m162e("ad_id"), this.f525b);
                    }
                }
            }

            public /* synthetic */ Object getItem(int i) {
                return m841a(i);
            }

            public C0220a(C0221a c0221a, Context context) {
                this.f527a = c0221a;
                super(context, 0, c0221a.f529b.f545m);
                this.f528b = context;
            }

            public View getView(int i, View view, ViewGroup viewGroup) {
                int i2 = 0;
                C0111a a = m841a(i);
                C0111a a2 = a.m151a("type");
                View view2 = null;
                C0222b[] values = C0222b.values();
                while (i2 < values.length) {
                    if (a2.equals(values[i2].f541e)) {
                        try {
                            view2 = (ap) values[i2].f542f.getConstructor(new Class[]{aw.class, Context.class}).newInstance(new Object[]{this.f527a.f529b, this.f528b});
                            break;
                        } catch (Throwable e) {
                            CBLogging.m102b(this, "error in more apps list", e);
                        }
                    } else {
                        i2++;
                    }
                }
                if (view2 == null) {
                    return new View(getContext());
                }
                view2.m795a(a, i);
                LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams == null || !(layoutParams instanceof AbsListView.LayoutParams)) {
                    layoutParams = new AbsListView.LayoutParams(-1, view2.m794a());
                } else {
                    layoutParams = (AbsListView.LayoutParams) layoutParams;
                    layoutParams.width = -1;
                    layoutParams.height = view2.m794a();
                }
                view2.setLayoutParams(layoutParams);
                view2.setOnClickListener(new C02191(this, a, i));
                return view2;
            }

            public int getCount() {
                return this.f527a.f529b.f545m.size();
            }

            public C0111a m841a(int i) {
                return (C0111a) this.f527a.f529b.f545m.get(i);
            }

            public int getItemViewType(int i) {
                C0111a a = m841a(i).m151a("type");
                C0222b[] values = C0222b.values();
                for (int i2 = 0; i2 < values.length; i2++) {
                    if (a.equals(values[i2].f541e)) {
                        return i2;
                    }
                }
                return 0;
            }

            public int getViewTypeCount() {
                return C0222b.values().length;
            }
        }

        private C0221a(aw awVar, Context context) {
            this.f529b = awVar;
            super(awVar, context);
            setBackgroundColor(-1);
            this.f531d = new bj(context);
            this.f530c = new C02181(this, context, awVar);
            this.f532e = new TextView(context);
            this.f532e.setBackgroundColor(awVar.f556x);
            this.f532e.setText(awVar.f558z);
            this.f532e.setTextColor(awVar.f557y);
            this.f532e.setTextSize(2, m499c() ? BitmapDescriptorFactory.HUE_ORANGE : 18.0f);
            this.f532e.setGravity(17);
            this.f534g = new ListView(context);
            this.f534g.setBackgroundColor(-1);
            this.f534g.setDividerHeight(0);
            m495a(this.f534g);
            addView(this.f534g);
            this.f531d.setFocusable(false);
            this.f530c.setFocusable(false);
            this.f530c.setClickable(true);
            this.f531d.setScaleType(ScaleType.CENTER_CROP);
            this.f530c.m642a(ScaleType.FIT_CENTER);
            this.f533f = new RelativeLayout(context);
            this.f533f.addView(this.f531d, new RelativeLayout.LayoutParams(-1, -1));
            this.f533f.addView(this.f532e, new RelativeLayout.LayoutParams(-1, -1));
            addView(this.f533f, new RelativeLayout.LayoutParams(-1, -1));
            addView(this.f530c, new RelativeLayout.LayoutParams(-1, -1));
            m495a(this.f533f);
            this.f535h = new C0220a(this, context);
        }

        protected void m842a(int i, int i2) {
            C0139j e;
            int i3;
            Context context = getContext();
            C0115f c = CBUtility.m118c();
            if (c.m189b() && this.f529b.f549q.m270e()) {
                e = this.f529b.f549q;
            } else if (c.m190c() && this.f529b.f550r.m270e()) {
                e = this.f529b.f550r;
            } else if (this.f529b.f552t.m270e()) {
                e = this.f529b.f552t;
            } else {
                e = null;
            }
            if (e != null) {
                this.f529b.f554v = e.m274i();
                if (e.m273h() < i) {
                    this.f529b.f554v = Math.round(((float) this.f529b.f554v) * (((float) i) / ((float) e.m273h())));
                }
                this.f532e.setVisibility(8);
                this.f531d.m814a(e);
            } else {
                this.f529b.f554v = CBUtility.m109a(m499c() ? 80 : 40, context);
                this.f532e.setVisibility(0);
            }
            if (this.f529b.f555w.m158c()) {
                this.f529b.f554v = CBUtility.m109a(this.f529b.f555w.m173k(), context);
            }
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, this.f529b.f554v);
            if (this.f529b.f547o.m270e() && c.m189b()) {
                e = this.f529b.f547o;
            } else if (this.f529b.f548p.m270e() && c.m190c()) {
                e = this.f529b.f548p;
            } else if (this.f529b.f546n.m270e()) {
                e = this.f529b.f546n;
            } else {
                e = null;
            }
            if (e != null) {
                this.f530c.m644a(e, layoutParams2);
                if (m499c()) {
                    i3 = 14;
                } else {
                    i3 = 7;
                }
                i3 = CBUtility.m109a(i3, context);
            } else {
                this.f530c.m645a("X");
                this.f530c.m640a().setTextSize(2, m499c() ? 26.0f : 16.0f);
                this.f530c.m640a().setTextColor(this.f529b.f557y);
                this.f530c.m640a().setTypeface(Typeface.SANS_SERIF, 1);
                layoutParams2.width = this.f529b.f554v / 2;
                layoutParams2.height = this.f529b.f554v / 3;
                if (m499c()) {
                    i3 = 30;
                } else {
                    i3 = 20;
                }
                i3 = CBUtility.m109a(i3, context);
            }
            int round = Math.round(((float) (this.f529b.f554v - layoutParams2.height)) / 2.0f);
            layoutParams2.rightMargin = i3;
            layoutParams2.topMargin = round;
            layoutParams2.addRule(11);
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.addRule(3, this.f533f.getId());
            this.f534g.setAdapter(this.f535h);
            this.f534g.setLayoutParams(layoutParams);
            this.f530c.setLayoutParams(layoutParams2);
            this.f533f.setLayoutParams(layoutParams3);
        }

        public void m843b() {
            super.m498b();
            this.f530c = null;
            this.f531d = null;
            this.f534g = null;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.aw.b */
    private enum C0222b {
        FEATURED("featured", aq.class),
        REGULAR("regular", ar.class),
        WEBVIEW("webview", at.class),
        VIDEO("video", as.class);
        
        private String f541e;
        private Class<? extends ap> f542f;

        private C0222b(String str, Class<? extends ap> cls) {
            this.f541e = str;
            this.f542f = cls;
        }
    }

    public aw(C0148a c0148a) {
        super(c0148a);
        this.f545m = new ArrayList();
        this.f552t = new C0139j(this);
        this.f550r = new C0139j(this);
        this.f549q = new C0139j(this);
        this.f551s = new C0139j(this);
        this.f546n = new C0139j(this);
        this.f548p = new C0139j(this);
        this.f547o = new C0139j(this);
        this.f544l = new C0139j(this);
        this.f543k = new C0139j(this);
    }

    protected C0176a m863b(Context context) {
        return new C0221a(context, null);
    }

    public boolean m862a(C0111a c0111a) {
        int i = 0;
        if (!super.m510a(c0111a)) {
            return false;
        }
        C0111a a = c0111a.m151a("cells");
        if (a.m155b()) {
            m506a(CBImpressionError.INVALID_RESPONSE);
            return false;
        }
        aw awVar;
        this.f553u = new HashSet();
        while (i < a.m177o()) {
            C0111a c = a.m157c(i);
            this.f545m.add(c);
            C0111a a2 = c.m151a("type");
            if (a2.equals("regular")) {
                c = c.m151a("assets");
                if (c.m158c()) {
                    m847a(c, "icon");
                }
            } else if (a2.equals("featured")) {
                c = c.m151a("assets");
                if (c.m158c()) {
                    m847a(c, "portrait");
                    m847a(c, "landscape");
                }
            } else {
                a2.equals("webview");
            }
            i++;
        }
        this.f546n.m265a("close");
        this.f548p.m265a("close-landscape");
        this.f547o.m265a("close-portrait");
        this.f552t.m265a("header-center");
        this.f549q.m265a("header-portrait");
        this.f550r.m265a("header-landscape");
        this.f551s.m265a("header-tile");
        this.f544l.m265a("play-button");
        this.f543k.m265a("install-button");
        this.f555w = this.e.m151a("header-height");
        if (this.f555w.m158c()) {
            i = this.f555w.m173k();
            awVar = this;
        } else if (C0177f.m502a(C0153b.m400l())) {
            i = 80;
            awVar = this;
        } else {
            i = 40;
            awVar = this;
        }
        awVar.f554v = i;
        this.f556x = this.e.m159c("background-color") ? C0177f.m500a(this.e.m162e("background-color")) : -14571545;
        this.f558z = this.e.m159c("header-text") ? this.e.m162e("header-text") : "More Free Games";
        this.f557y = this.e.m159c("text-color") ? C0177f.m500a(this.e.m162e("text-color")) : -1;
        return true;
    }

    private void m847a(C0111a c0111a, String str) {
        if (!c0111a.m156b(str)) {
            C0139j c0139j = new C0139j(this);
            this.f553u.add(c0139j);
            c0139j.m264a(c0111a, str, new Bundle());
        }
    }

    public void m864d() {
        super.m516d();
        this.f545m = null;
        for (C0139j d : this.f553u) {
            d.m269d();
        }
        this.f553u.clear();
        this.f546n.m269d();
        this.f548p.m269d();
        this.f547o.m269d();
        this.f552t.m269d();
        this.f551s.m269d();
        this.f549q.m269d();
        this.f550r.m269d();
        this.f544l.m269d();
        this.f543k.m269d();
    }
}
