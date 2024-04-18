package com.chartboost.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.C0115f;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C0148a;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.impl.bh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.chartboost.sdk.f */
public abstract class C0177f {
    public static Handler f303a;
    public boolean f304b;
    protected List<C0138b> f305c;
    protected List<C0138b> f306d;
    protected C0111a f307e;
    protected C0148a f308f;
    protected C0115f f309g;
    public Map<Integer, Runnable> f310h;
    protected boolean f311i;
    protected boolean f312j;
    private boolean f313k;
    private C0176a f314l;

    /* renamed from: com.chartboost.sdk.f.b */
    public interface C0138b {
        boolean m260a();
    }

    /* renamed from: com.chartboost.sdk.f.1 */
    class C01741 implements Runnable {
        final /* synthetic */ boolean f292a;
        final /* synthetic */ View f293b;
        final /* synthetic */ C0177f f294c;

        C01741(C0177f c0177f, boolean z, View view) {
            this.f294c = c0177f;
            this.f292a = z;
            this.f293b = view;
        }

        public void run() {
            if (!this.f292a) {
                this.f293b.setVisibility(8);
                this.f293b.setClickable(false);
            }
            this.f294c.f310h.remove(Integer.valueOf(this.f293b.hashCode()));
        }
    }

    /* renamed from: com.chartboost.sdk.f.a */
    public abstract class C0176a extends RelativeLayout {
        final /* synthetic */ C0177f f296a;
        private boolean f297b;
        private int f298c;
        private int f299d;
        private int f300e;
        private int f301f;
        private C0115f f302g;

        /* renamed from: com.chartboost.sdk.f.a.1 */
        class C01751 implements Runnable {
            final /* synthetic */ C0176a f295a;

            C01751(C0176a c0176a) {
                this.f295a = c0176a;
            }

            public void run() {
                this.f295a.requestLayout();
            }
        }

        protected abstract void m494a(int i, int i2);

        public C0176a(C0177f c0177f, Context context) {
            this.f296a = c0177f;
            super(context);
            this.f297b = false;
            this.f298c = -1;
            this.f299d = -1;
            this.f300e = -1;
            this.f301f = -1;
            this.f302g = null;
            c0177f.f314l = this;
            c0177f.f313k = false;
            setFocusableInTouchMode(true);
            requestFocus();
        }

        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            this.f300e = i;
            this.f301f = i2;
            if (this.f298c != -1 && this.f299d != -1) {
                m496a(false);
            }
        }

        private boolean m492b(int i, int i2) {
            boolean z = true;
            if (this.f297b) {
                return false;
            }
            C0115f c = CBUtility.m118c();
            if (this.f298c == i && this.f299d == i2 && this.f302g == c) {
                return true;
            }
            this.f297b = true;
            try {
                if (this.f296a.f311i && c.m189b()) {
                    this.f296a.f309g = c;
                } else if (this.f296a.f312j && c.m190c()) {
                    this.f296a.f309g = c;
                }
                m494a(i, i2);
                post(new C01751(this));
                this.f298c = i;
                this.f299d = i2;
                this.f302g = c;
            } catch (Throwable e) {
                CBLogging.m102b("CBViewProtocol", "Exception raised while layouting Subviews", e);
                z = false;
            }
            this.f297b = false;
            return z;
        }

        public final void m493a() {
            m496a(false);
        }

        public final void m496a(boolean z) {
            if (z) {
                this.f302g = null;
            }
            m497a((Activity) getContext());
        }

        public void m498b() {
        }

        public boolean m497a(Activity activity) {
            if (this.f300e == -1 || this.f301f == -1) {
                int width;
                int height;
                try {
                    width = getWidth();
                    height = getHeight();
                    if (width == 0 || height == 0) {
                        View findViewById = activity.getWindow().findViewById(16908290);
                        if (findViewById == null) {
                            findViewById = activity.getWindow().getDecorView();
                        }
                        width = findViewById.getWidth();
                        height = findViewById.getHeight();
                    }
                } catch (Exception e) {
                    height = 0;
                    width = 0;
                }
                if (width == 0 || r0 == 0) {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    width = displayMetrics.widthPixels;
                    height = displayMetrics.heightPixels;
                }
                this.f300e = width;
                this.f301f = height;
            }
            return m492b(this.f300e, this.f301f);
        }

        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            for (int i = 0; i < this.f296a.f310h.size(); i++) {
                C0177f.f303a.removeCallbacks((Runnable) this.f296a.f310h.get(Integer.valueOf(i)));
            }
            this.f296a.f310h.clear();
        }

        public final void m495a(View view) {
            int i = 200;
            if (200 == getId()) {
                i = 201;
            }
            int i2 = i;
            View findViewById = findViewById(i);
            while (findViewById != null) {
                i2++;
                findViewById = findViewById(i2);
            }
            view.setId(i2);
            view.setSaveEnabled(false);
        }

        protected boolean m499c() {
            return C0177f.m502a(getContext());
        }
    }

    protected abstract C0176a m512b(Context context);

    static {
        f303a = CBUtility.m120e();
    }

    public static boolean m502a(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 4;
    }

    public C0177f(C0148a c0148a) {
        this.f304b = false;
        this.f305c = new ArrayList();
        this.f306d = new ArrayList();
        this.f310h = Collections.synchronizedMap(new HashMap());
        this.f311i = true;
        this.f312j = true;
        this.f308f = c0148a;
        this.f314l = null;
        this.f309g = CBUtility.m118c();
        this.f313k = false;
    }

    public C0115f m504a() {
        return this.f309g;
    }

    public boolean m510a(C0111a c0111a) {
        this.f307e = c0111a.m151a("assets");
        if (!this.f307e.m155b()) {
            return true;
        }
        CBLogging.m101b("CBViewProtocol", "Assets got from the response is null or empty");
        m506a(CBImpressionError.INVALID_RESPONSE);
        return false;
    }

    public void m507a(C0138b c0138b) {
        if (c0138b.m260a()) {
            this.f306d.remove(c0138b);
        }
        this.f305c.remove(c0138b);
        if (this.f305c.isEmpty() && !m514b()) {
            CBLogging.m101b("CBViewProtocol", "Error while downloading the assets");
            m506a(CBImpressionError.ASSETS_DOWNLOAD_FAILURE);
        }
    }

    public boolean m514b() {
        if (this.f306d.isEmpty()) {
            m521i();
            return true;
        }
        CBLogging.m105d("CBViewProtocol", "not completed loading assets for impression");
        return false;
    }

    public CBImpressionError m515c() {
        Activity e = Chartboost.m52e();
        if (e == null) {
            this.f314l = null;
            return CBImpressionError.NO_HOST_ACTIVITY;
        } else if (!this.f312j && !this.f311i) {
            return CBImpressionError.WRONG_ORIENTATION;
        } else {
            this.f309g = CBUtility.m118c();
            if ((this.f309g.m190c() && !this.f312j) || (this.f309g.m189b() && !this.f311i)) {
                this.f309g = this.f309g.m188a();
            }
            if (this.f314l == null) {
                this.f314l = m512b((Context) e);
            }
            if (this.f314l.m497a(e)) {
                return null;
            }
            this.f314l = null;
            return CBImpressionError.ERROR_CREATING_VIEW;
        }
    }

    public void m516d() {
        m518f();
        for (int i = 0; i < this.f310h.size(); i++) {
            f303a.removeCallbacks((Runnable) this.f310h.get(Integer.valueOf(i)));
        }
        this.f310h.clear();
    }

    public C0176a m517e() {
        return this.f314l;
    }

    public void m518f() {
        if (this.f314l != null) {
            this.f314l.m498b();
        }
        this.f314l = null;
    }

    public C0111a m519g() {
        return this.f307e;
    }

    public void m513b(C0138b c0138b) {
        this.f305c.add(c0138b);
        this.f306d.add(c0138b);
    }

    protected void m506a(CBImpressionError cBImpressionError) {
        this.f308f.m291a(cBImpressionError);
    }

    protected void m520h() {
        if (!this.f313k) {
            this.f313k = true;
            this.f308f.m295b();
        }
    }

    protected void m521i() {
        this.f308f.m296c();
    }

    public boolean m511a(String str, C0111a c0111a) {
        return this.f308f.m294a(str, c0111a);
    }

    public void m508a(boolean z, View view) {
        m509a(z, view, true);
    }

    public void m509a(boolean z, View view, boolean z2) {
        int i = 8;
        if (((z && view.getVisibility() == 0) || (!z && view.getVisibility() == 8)) && this.f310h.get(Integer.valueOf(view.hashCode())) == null) {
            return;
        }
        if (z2) {
            Runnable c01741 = new C01741(this, z, view);
            bh.m1106a(z, view, 250);
            m505a(view, c01741, 250);
            return;
        }
        if (z) {
            i = 0;
        }
        view.setVisibility(i);
        view.setClickable(z);
    }

    protected void m505a(View view, Runnable runnable, long j) {
        Runnable runnable2 = (Runnable) this.f310h.get(Integer.valueOf(view.hashCode()));
        if (runnable2 != null) {
            f303a.removeCallbacks(runnable2);
        }
        this.f310h.put(Integer.valueOf(view.hashCode()), runnable);
        f303a.postDelayed(runnable, j);
    }

    public static int m500a(String str) {
        int i = 0;
        if (str != null) {
            if (!str.startsWith("#")) {
                try {
                    i = Color.parseColor(str);
                } catch (IllegalArgumentException e) {
                    str = "#" + str;
                }
            }
            if (str.length() == 4 || str.length() == 5) {
                StringBuilder stringBuilder = new StringBuilder((str.length() * 2) + 1);
                stringBuilder.append("#");
                for (int i2 = i; i2 < str.length() - 1; i2++) {
                    stringBuilder.append(str.charAt(i2 + 1));
                    stringBuilder.append(str.charAt(i2 + 1));
                }
                str = stringBuilder.toString();
            }
            try {
                i = Color.parseColor(str);
            } catch (Throwable e2) {
                CBLogging.m106d("CBViewProtocol", "error parsing color " + str, e2);
            }
        }
        return i;
    }

    public boolean m522j() {
        return false;
    }

    public void m523k() {
        if (this.f304b) {
            this.f304b = false;
        }
        if (m517e() != null && CBUtility.m118c() != m517e().f302g) {
            m517e().m496a(false);
        }
    }

    public void m524l() {
        this.f304b = true;
    }
}
