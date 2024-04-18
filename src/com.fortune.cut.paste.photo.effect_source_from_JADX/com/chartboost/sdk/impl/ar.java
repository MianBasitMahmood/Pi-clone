package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.chartboost.sdk.C0177f;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.C0139j;
import com.chartboost.sdk.Libraries.CBUtility;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.plus.PlusShare;

public class ar extends ap {
    private aw f489a;
    private TextView f490b;
    private TextView f491c;
    private TextView f492d;
    private LinearLayout f493e;
    private au f494f;
    private bk f495g;
    private int f496h;
    private Point f497i;
    private C0139j f498j;
    private OnClickListener f499k;

    /* renamed from: com.chartboost.sdk.impl.ar.1 */
    class C02121 extends bk {
        final /* synthetic */ ar f488a;

        C02121(ar arVar, Context context) {
            this.f488a = arVar;
            super(context);
        }

        protected void m798a(MotionEvent motionEvent) {
            this.f488a.f499k.onClick(this.f488a.f495g);
        }
    }

    public ar(aw awVar, Context context) {
        super(context);
        this.f489a = awVar;
        this.f493e = new LinearLayout(context);
        this.f493e.setOrientation(1);
        setGravity(16);
        boolean a = C0177f.m502a(context);
        this.f490b = new TextView(context);
        this.f490b.setTypeface(null, 1);
        this.f490b.setTextSize(2, a ? 21.0f : 16.0f);
        this.f490b.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f490b.setSingleLine();
        this.f490b.setEllipsize(TruncateAt.END);
        this.f491c = new TextView(context);
        this.f491c.setTextSize(2, a ? 16.0f : 10.0f);
        this.f491c.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f491c.setSingleLine();
        this.f491c.setEllipsize(TruncateAt.END);
        this.f492d = new TextView(context);
        this.f492d.setTextSize(2, a ? 18.0f : 11.0f);
        this.f492d.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f492d.setMaxLines(2);
        this.f492d.setEllipsize(TruncateAt.END);
        this.f495g = new C02121(this, context);
        this.f495g.m642a(ScaleType.FIT_CENTER);
        this.f494f = new au(context);
        setFocusable(false);
        setGravity(16);
        addView(this.f494f);
        addView(this.f493e, new LayoutParams(0, -2, TextTrackStyle.DEFAULT_FONT_SCALE));
        addView(this.f495g);
        setBackgroundColor(0);
        this.f493e.addView(this.f490b, new LayoutParams(-1, -2));
        this.f493e.addView(this.f491c, new LayoutParams(-1, -2));
        this.f493e.addView(this.f492d, new LayoutParams(-1, -1));
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.f499k = onClickListener;
    }

    public void m804a(C0111a c0111a, int i) {
        this.f490b.setText(c0111a.m151a("name").m160d("Unknown App"));
        if (TextUtils.isEmpty(c0111a.m162e("publisher"))) {
            this.f491c.setVisibility(8);
        } else {
            this.f491c.setText(c0111a.m162e("publisher"));
        }
        if (TextUtils.isEmpty(c0111a.m162e(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION))) {
            this.f492d.setVisibility(8);
        } else {
            this.f492d.setText(c0111a.m162e(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION));
        }
        this.f496h = c0111a.m156b("border-color") ? -4802890 : C0177f.m500a(c0111a.m162e("border-color"));
        if (c0111a.m159c("offset")) {
            this.f497i = new Point(c0111a.m151a("offset").m164f("x"), c0111a.m151a("offset").m164f("y"));
        } else {
            this.f497i = new Point(0, 0);
        }
        this.f498j = null;
        if (c0111a.m159c("deep-link") && bb.m962a(c0111a.m162e("deep-link"))) {
            if (this.f489a.f544l.m270e()) {
                this.f498j = this.f489a.f544l;
            } else {
                this.f495g.m645a("Play");
            }
        } else if (this.f489a.f543k.m270e()) {
            this.f498j = this.f489a.f543k;
        } else {
            this.f495g.m645a("Install");
        }
        int a = CBUtility.m109a(C0177f.m502a(getContext()) ? 14 : 7, getContext());
        if (this.f498j != null) {
            this.f495g.m643a(this.f498j);
            a = (a * 2) + Math.round((((float) this.f498j.m267b()) * ((float) m802c())) / ((float) this.f498j.m268c()));
        } else {
            this.f495g.m640a().setTextColor(-14571545);
            a = CBUtility.m109a(8, getContext());
            this.f495g.m640a().setPadding(a, a, a, a);
            a = CBUtility.m109a(100, getContext());
        }
        this.f495g.setLayoutParams(new LayoutParams(a, m802c()));
        m800a(this.f494f, i, c0111a.m151a("assets").m151a("icon"));
        this.f494f.m817a(this.f496h);
        this.f494f.m816a(0.16666667f);
        m805b();
    }

    private void m800a(bj bjVar, int i, C0111a c0111a) {
        if (!c0111a.m155b()) {
            Bundle bundle = new Bundle();
            bundle.putInt("index", i);
            String str = "";
            if (!(c0111a.m162e("checksum") == null || c0111a.m162e("checksum").isEmpty())) {
                str = c0111a.m162e("checksum");
            }
            bc.m973a().m979a(c0111a.m162e(PlusShare.KEY_CALL_TO_ACTION_URL), str, null, bjVar, bundle);
        }
    }

    protected void m805b() {
        int a = CBUtility.m109a(C0177f.m502a(getContext()) ? 14 : 7, getContext());
        ViewGroup.LayoutParams layoutParams = new LayoutParams(m803a() - (a * 2), m803a() - (a * 2));
        layoutParams.setMargins(a, a, a, a);
        this.f493e.setPadding(0, a, 0, a);
        this.f495g.setPadding((this.f497i.x * 2) + a, this.f497i.y * 2, a, 0);
        this.f494f.setLayoutParams(layoutParams);
        this.f494f.setScaleType(ScaleType.FIT_CENTER);
    }

    public int m803a() {
        int i = 134;
        if (CBUtility.m118c().m190c()) {
            if (!C0177f.m502a(getContext())) {
                i = 75;
            }
        } else if (!C0177f.m502a(getContext())) {
            i = 77;
        }
        return CBUtility.m109a(i, getContext());
    }

    private int m802c() {
        int i = 74;
        if (CBUtility.m118c().m190c()) {
            if (!C0177f.m502a(getContext())) {
                i = 41;
            }
        } else if (!C0177f.m502a(getContext())) {
            i = 41;
        }
        return CBUtility.m109a(i, getContext());
    }
}
