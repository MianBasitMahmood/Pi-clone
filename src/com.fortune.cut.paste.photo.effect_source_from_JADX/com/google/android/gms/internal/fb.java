package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.internal.gv.C1012a;

@ey
public class fb implements Runnable {
    private final int li;
    private final int lj;
    protected final gu mo;
    private final Handler tr;
    private final long ts;
    private long tt;
    private C1012a tu;
    protected boolean tv;
    protected boolean tw;

    /* renamed from: com.google.android.gms.internal.fb.a */
    protected final class C1138a extends AsyncTask<Void, Void, Boolean> {
        private final WebView tx;
        private Bitmap ty;
        final /* synthetic */ fb tz;

        public C1138a(fb fbVar, WebView webView) {
            this.tz = fbVar;
            this.tx = webView;
        }

        protected final void m4570a(Boolean bool) {
            fb.m4574c(this.tz);
            if (bool.booleanValue() || this.tz.cH() || this.tz.tt <= 0) {
                this.tz.tw = bool.booleanValue();
                this.tz.tu.m4147a(this.tz.mo);
            } else if (this.tz.tt > 0) {
                if (gr.m4778v(2)) {
                    gr.m4769S("Ad not detected, scheduling another run.");
                }
                this.tz.tr.postDelayed(this.tz, this.tz.ts);
            }
        }

        protected final synchronized Boolean m4571b(Void... voidArr) {
            Boolean valueOf;
            int width = this.ty.getWidth();
            int height = this.ty.getHeight();
            if (width == 0 || height == 0) {
                valueOf = Boolean.valueOf(false);
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.ty.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                valueOf = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return valueOf;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return m4571b((Void[]) objArr);
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            m4570a((Boolean) obj);
        }

        protected final synchronized void onPreExecute() {
            this.ty = Bitmap.createBitmap(this.tz.li, this.tz.lj, Config.ARGB_8888);
            this.tx.setVisibility(0);
            this.tx.measure(MeasureSpec.makeMeasureSpec(this.tz.li, 0), MeasureSpec.makeMeasureSpec(this.tz.lj, 0));
            this.tx.layout(0, 0, this.tz.li, this.tz.lj);
            this.tx.draw(new Canvas(this.ty));
            this.tx.invalidate();
        }
    }

    public fb(C1012a c1012a, gu guVar, int i, int i2) {
        this(c1012a, guVar, i, i2, 200, 50);
    }

    public fb(C1012a c1012a, gu guVar, int i, int i2, long j, long j2) {
        this.ts = j;
        this.tt = j2;
        this.tr = new Handler(Looper.getMainLooper());
        this.mo = guVar;
        this.tu = c1012a;
        this.tv = false;
        this.tw = false;
        this.lj = i2;
        this.li = i;
    }

    static /* synthetic */ long m4574c(fb fbVar) {
        long j = fbVar.tt - 1;
        fbVar.tt = j;
        return j;
    }

    public void m4579a(fj fjVar, gz gzVar) {
        this.mo.setWebViewClient(gzVar);
        this.mo.loadDataWithBaseURL(TextUtils.isEmpty(fjVar.sg) ? null : gi.m4715L(fjVar.sg), fjVar.tU, "text/html", "UTF-8", null);
    }

    public void m4580b(fj fjVar) {
        m4579a(fjVar, new gz(this, this.mo, fjVar.ud));
    }

    public void cF() {
        this.tr.postDelayed(this, this.ts);
    }

    public synchronized void cG() {
        this.tv = true;
    }

    public synchronized boolean cH() {
        return this.tv;
    }

    public boolean cI() {
        return this.tw;
    }

    public void run() {
        if (this.mo == null || cH()) {
            this.tu.m4147a(this.mo);
        } else {
            new C1138a(this, this.mo).execute(new Void[0]);
        }
    }
}
