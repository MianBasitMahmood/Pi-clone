package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.C0113e;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.C0139j;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Tracking.C0151a;
import com.chartboost.sdk.impl.ai.C0201a;
import com.chartboost.sdk.impl.bg.C0253a;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.location.LocationStatusCodes;

public final class ao extends RelativeLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private static final CharSequence f469a;
    private static Handler f470l;
    private RelativeLayout f471b;
    private an f472c;
    private an f473d;
    private bk f474e;
    private TextView f475f;
    private ak f476g;
    private bg f477h;
    private ai f478i;
    private boolean f479j;
    private boolean f480k;
    private Runnable f481m;
    private Runnable f482n;
    private Runnable f483o;

    /* renamed from: com.chartboost.sdk.impl.ao.1 */
    class C02071 extends bk {
        final /* synthetic */ ao f463a;

        C02071(ao aoVar, Context context) {
            this.f463a = aoVar;
            super(context);
        }

        protected void m764a(MotionEvent motionEvent) {
            this.f463a.f478i.m511a(null, C0113e.m180a(C0113e.m181a("paused", Integer.valueOf(1))));
            C0151a.m332a("install-button", this.f463a.f478i.f423r, this.f463a.f478i.n, Math.round(motionEvent.getX()), Math.round(motionEvent.getY()));
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ao.2 */
    class C02082 implements Runnable {
        final /* synthetic */ ao f464a;

        C02082(ao aoVar) {
            this.f464a = aoVar;
        }

        public void run() {
            this.f464a.m771d(false);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ao.3 */
    class C02093 implements Runnable {
        final /* synthetic */ ao f465a;

        C02093(ao aoVar) {
            this.f465a = aoVar;
        }

        public void run() {
            if (this.f465a.f472c != null) {
                this.f465a.f472c.setVisibility(8);
            }
            if (this.f465a.f478i.f413I) {
                this.f465a.f476g.setVisibility(8);
            }
            this.f465a.f473d.setVisibility(8);
            if (this.f465a.f474e != null) {
                this.f465a.f474e.setEnabled(false);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ao.4 */
    class C02104 implements Runnable {
        final /* synthetic */ ao f466a;
        private int f467b;

        C02104(ao aoVar) {
            this.f466a = aoVar;
            this.f467b = 0;
        }

        public void run() {
            if (this.f466a.f477h.m1101b().m1027e()) {
                float f;
                int d = this.f466a.f477h.m1101b().m1026d();
                if (d > 0) {
                    this.f466a.f478i.f424s = d;
                    f = (float) this.f466a.f478i.f424s;
                    if (this.f466a.f477h.m1101b().m1027e() && f / 1000.0f > 0.0f && !this.f466a.f478i.m737s()) {
                        this.f466a.f478i.m735q();
                        this.f466a.f478i.m722a(true);
                    }
                }
                f = ((float) d) / ((float) this.f466a.f477h.m1101b().m1025c());
                if (this.f466a.f478i.f413I) {
                    this.f466a.f476g.m749a(f);
                }
                d /= LocationStatusCodes.GEOFENCE_NOT_AVAILABLE;
                if (this.f467b != d) {
                    this.f467b = d;
                    int i = d / 60;
                    d %= 60;
                    this.f466a.f475f.setText(String.format("%02d:%02d", new Object[]{Integer.valueOf(i), Integer.valueOf(d)}));
                }
            }
            C0201a p = this.f466a.f478i.m734p();
            if (p.m693g()) {
                View b = p.m688b(true);
                if (b.getVisibility() == 8) {
                    this.f466a.f478i.m508a(true, b);
                    b.setEnabled(true);
                }
            }
            ao.f470l.removeCallbacks(this.f466a.f483o);
            ao.f470l.postDelayed(this.f466a.f483o, 16);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ao.5 */
    class C02115 implements Runnable {
        final /* synthetic */ ao f468a;

        C02115(ao aoVar) {
            this.f468a = aoVar;
        }

        public void run() {
            this.f468a.f477h.setVisibility(0);
        }
    }

    static {
        f469a = "00:00";
        f470l = CBUtility.m120e();
    }

    public ao(Context context, ai aiVar) {
        super(context);
        this.f479j = false;
        this.f480k = false;
        this.f481m = new C02082(this);
        this.f482n = new C02093(this);
        this.f483o = new C02104(this);
        this.f478i = aiVar;
        m766a(context);
    }

    private void m766a(Context context) {
        LayoutParams layoutParams;
        Context context2 = getContext();
        C0111a g = this.f478i.m519g();
        float f = getContext().getResources().getDisplayMetrics().density;
        int round = Math.round(f * 10.0f);
        this.f477h = new bg(context2);
        this.f478i.m734p().m495a(this.f477h);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(13);
        addView(this.f477h, layoutParams2);
        this.f471b = new RelativeLayout(context2);
        if (g.m158c() && g.m151a("video-click-button").m158c()) {
            this.f472c = new an(context2);
            this.f472c.setVisibility(8);
            this.f474e = new C02071(this, context2);
            this.f474e.m642a(ScaleType.FIT_CENTER);
            C0139j c0139j = this.f478i.f409E;
            Point b = this.f478i.m671b("video-click-button");
            LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.leftMargin = Math.round(((float) b.x) / c0139j.m272g());
            layoutParams3.topMargin = Math.round(((float) b.y) / c0139j.m272g());
            this.f478i.m669a(layoutParams3, c0139j, TextTrackStyle.DEFAULT_FONT_SCALE);
            this.f474e.m643a(c0139j);
            this.f472c.addView(this.f474e, layoutParams3);
            layoutParams = new RelativeLayout.LayoutParams(-1, Math.round(((float) layoutParams3.height) + (10.0f * f)));
            layoutParams.addRule(10);
            this.f471b.addView(this.f472c, layoutParams);
        }
        this.f473d = new an(context2);
        this.f473d.setVisibility(8);
        layoutParams = new RelativeLayout.LayoutParams(-1, Math.round(32.5f * f));
        layoutParams.addRule(12);
        this.f471b.addView(this.f473d, layoutParams);
        this.f473d.setGravity(16);
        this.f473d.setPadding(round, round, round, round);
        this.f475f = new TextView(context2);
        this.f475f.setTextColor(-1);
        this.f475f.setTextSize(2, 11.0f);
        this.f475f.setText(f469a);
        this.f475f.setPadding(0, 0, round, 0);
        this.f475f.setSingleLine();
        this.f475f.measure(0, 0);
        int measuredWidth = this.f475f.getMeasuredWidth();
        this.f475f.setGravity(17);
        this.f473d.addView(this.f475f, new LinearLayout.LayoutParams(measuredWidth, -1));
        this.f476g = new ak(context2);
        this.f476g.setVisibility(8);
        LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, Math.round(10.0f * f));
        layoutParams4.setMargins(0, CBUtility.m109a(1, getContext()), 0, 0);
        this.f473d.addView(this.f476g, layoutParams4);
        layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.addRule(6, this.f477h.getId());
        layoutParams4.addRule(8, this.f477h.getId());
        layoutParams4.addRule(5, this.f477h.getId());
        layoutParams4.addRule(7, this.f477h.getId());
        addView(this.f471b, layoutParams4);
        m777a();
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.f474e != null) {
            this.f474e.setEnabled(z);
        }
        if (z) {
            m780a(false);
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f470l.removeCallbacks(this.f483o);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f477h.m1101b().m1027e() || motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (this.f478i != null) {
            C0151a.m351e(this.f478i.f423r, this.f478i.n, this.f479j);
        }
        m771d(true);
        return true;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        this.f478i.f424s = this.f477h.m1101b().m1025c();
        if (this.f478i.m734p() != null) {
            this.f478i.m734p().m692f();
        }
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        this.f478i.f425t = this.f477h.m1101b().m1025c();
        this.f478i.m734p().m496a(true);
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f478i.m738t();
        return false;
    }

    private void m771d(boolean z) {
        m781a(!this.f479j, z);
    }

    protected final void m781a(boolean z, boolean z2) {
        f470l.removeCallbacks(this.f481m);
        f470l.removeCallbacks(this.f482n);
        if (this.f478i.f426u && this.f478i.m733o() && z != this.f479j) {
            this.f479j = z;
            Animation alphaAnimation = this.f479j ? new AlphaAnimation(0.0f, TextTrackStyle.DEFAULT_FONT_SCALE) : new AlphaAnimation(TextTrackStyle.DEFAULT_FONT_SCALE, 0.0f);
            alphaAnimation.setDuration(z2 ? 100 : 200);
            alphaAnimation.setFillAfter(true);
            if (!(this.f480k || this.f472c == null)) {
                this.f472c.setVisibility(0);
                this.f472c.startAnimation(alphaAnimation);
                if (this.f474e != null) {
                    this.f474e.setEnabled(true);
                }
            }
            if (this.f478i.f413I) {
                this.f476g.setVisibility(0);
            }
            this.f473d.setVisibility(0);
            this.f473d.startAnimation(alphaAnimation);
            if (this.f479j) {
                f470l.postDelayed(this.f481m, 3000);
            } else {
                f470l.postDelayed(this.f482n, alphaAnimation.getDuration());
            }
        }
    }

    public final void m780a(boolean z) {
        f470l.removeCallbacks(this.f481m);
        f470l.removeCallbacks(this.f482n);
        if (z) {
            if (!(this.f480k || this.f472c == null)) {
                this.f472c.setVisibility(0);
            }
            if (this.f478i.f413I) {
                this.f476g.setVisibility(0);
            }
            this.f473d.setVisibility(0);
            if (this.f474e != null) {
                this.f474e.setEnabled(true);
            }
        } else {
            if (this.f472c != null) {
                this.f472c.clearAnimation();
                this.f472c.setVisibility(8);
            }
            this.f473d.clearAnimation();
            if (this.f478i.f413I) {
                this.f476g.setVisibility(8);
            }
            this.f473d.setVisibility(8);
            if (this.f474e != null) {
                this.f474e.setEnabled(false);
            }
        }
        this.f479j = z;
    }

    public final void m783b(boolean z) {
        setBackgroundColor(z ? ViewCompat.MEASURED_STATE_MASK : 0);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (!z) {
            layoutParams.addRule(6, this.f477h.getId());
            layoutParams.addRule(8, this.f477h.getId());
            layoutParams.addRule(5, this.f477h.getId());
            layoutParams.addRule(7, this.f477h.getId());
        }
        this.f471b.setLayoutParams(layoutParams);
        if (this.f472c != null) {
            this.f472c.setGravity(19);
            this.f472c.requestLayout();
        }
    }

    public final void m777a() {
        m783b(CBUtility.m118c().m189b());
    }

    public final C0253a m782b() {
        return this.f477h.m1101b();
    }

    public final ak m784c() {
        return this.f476g;
    }

    public final void m778a(int i) {
        if (this.f472c != null) {
            this.f472c.setBackgroundColor(i);
        }
        this.f473d.setBackgroundColor(i);
    }

    public final void m786d() {
        if (this.f472c != null) {
            this.f472c.setVisibility(8);
        }
        this.f480k = true;
        if (this.f474e != null) {
            this.f474e.setEnabled(false);
        }
    }

    public final void m785c(boolean z) {
        this.f475f.setVisibility(z ? 0 : 8);
    }

    public final void m779a(String str) {
        this.f477h.m1101b().m1020a((OnCompletionListener) this);
        this.f477h.m1101b().m1021a((OnErrorListener) this);
        this.f477h.m1101b().m1022a((OnPreparedListener) this);
        this.f477h.m1101b().m1023a(Uri.parse(str));
    }

    public final void m787e() {
        if (!this.f477h.m1100a()) {
            f470l.postDelayed(new C02115(this), 250);
        }
        this.f477h.m1101b().m1017a();
        f470l.removeCallbacks(this.f483o);
        f470l.postDelayed(this.f483o, 16);
    }

    public final void m788f() {
        if (this.f477h.m1101b().m1027e()) {
            this.f478i.f424s = this.f477h.m1101b().m1026d();
            this.f477h.m1101b().m1024b();
        }
        if (this.f478i.m734p().d.getVisibility() == 0) {
            this.f478i.m734p().d.postInvalidate();
        }
        f470l.removeCallbacks(this.f483o);
    }

    public final void m789g() {
        if (this.f477h.m1101b().m1027e()) {
            this.f478i.f424s = this.f477h.m1101b().m1026d();
        }
        this.f477h.m1101b().m1024b();
        f470l.removeCallbacks(this.f483o);
    }

    public final void m790h() {
        if (!this.f477h.m1100a()) {
            this.f477h.setVisibility(8);
            invalidate();
        }
    }

    public final boolean m791i() {
        return this.f477h.m1101b().m1027e();
    }
}
