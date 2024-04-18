package com.google.android.gms.internal;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.Map;

@ey
public class gv extends WebViewClient {
    private final Object mH;
    protected final gu mo;
    private cb pP;
    private cg qa;
    private ce qc;
    private C1497v qd;
    private C1012a tu;
    private final HashMap<String, cd> xe;
    private C1486t xf;
    private ds xg;
    private boolean xh;
    private boolean xi;
    private dv xj;
    private final dl xk;

    /* renamed from: com.google.android.gms.internal.gv.a */
    public interface C1012a {
        void m4147a(gu guVar);
    }

    /* renamed from: com.google.android.gms.internal.gv.1 */
    class C11741 implements Runnable {
        final /* synthetic */ dp xl;
        final /* synthetic */ gv xm;

        C11741(gv gvVar, dp dpVar) {
            this.xm = gvVar;
            this.xl = dpVar;
        }

        public void run() {
            this.xl.cg();
        }
    }

    public gv(gu guVar, boolean z) {
        this(guVar, z, new dl(guVar, guVar.getContext(), new bl(guVar.getContext())));
    }

    gv(gu guVar, boolean z, dl dlVar) {
        this.xe = new HashMap();
        this.mH = new Object();
        this.xh = false;
        this.mo = guVar;
        this.xi = z;
        this.xk = dlVar;
    }

    private static boolean m4792d(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void m4793e(Uri uri) {
        String path = uri.getPath();
        cd cdVar = (cd) this.xe.get(path);
        if (cdVar != null) {
            Map c = gi.m4736c(uri);
            if (gr.m4778v(2)) {
                gr.m4772V("Received GMSG: " + path);
                for (String path2 : c.keySet()) {
                    gr.m4772V("  " + path2 + ": " + ((String) c.get(path2)));
                }
            }
            cdVar.m4120a(this.mo, c);
            return;
        }
        gr.m4772V("No GMSG handler found for GMSG: " + uri);
    }

    public final void m4794A(boolean z) {
        this.xh = z;
    }

    public final void m4795a(C1089do c1089do) {
        ds dsVar = null;
        boolean dH = this.mo.dH();
        C1486t c1486t = (!dH || this.mo.ac().oq) ? this.xf : null;
        if (!dH) {
            dsVar = this.xg;
        }
        m4796a(new dr(c1089do, c1486t, dsVar, this.xj, this.mo.dG()));
    }

    protected void m4796a(dr drVar) {
        dp.m4448a(this.mo.getContext(), drVar);
    }

    public final void m4797a(C1012a c1012a) {
        this.tu = c1012a;
    }

    public void m4798a(C1486t c1486t, ds dsVar, cb cbVar, dv dvVar, boolean z, ce ceVar, cg cgVar, C1497v c1497v) {
        m4799a(c1486t, dsVar, cbVar, dvVar, z, ceVar, c1497v);
        m4800a("/setInterstitialProperties", new cf(cgVar));
        this.qa = cgVar;
    }

    public void m4799a(C1486t c1486t, ds dsVar, cb cbVar, dv dvVar, boolean z, ce ceVar, C1497v c1497v) {
        if (c1497v == null) {
            c1497v = new C1497v(false);
        }
        m4800a("/appEvent", new ca(cbVar));
        m4800a("/canOpenURLs", cc.pR);
        m4800a("/canOpenIntents", cc.pS);
        m4800a("/click", cc.pT);
        m4800a("/close", cc.pU);
        m4800a("/customClose", cc.pV);
        m4800a("/httpTrack", cc.pW);
        m4800a("/log", cc.pX);
        m4800a("/open", new ci(ceVar, c1497v));
        m4800a("/touch", cc.pY);
        m4800a("/video", cc.pZ);
        m4800a("/mraid", new ch());
        this.xf = c1486t;
        this.xg = dsVar;
        this.pP = cbVar;
        this.qc = ceVar;
        this.xj = dvVar;
        this.qd = c1497v;
        this.xh = z;
    }

    public final void m4800a(String str, cd cdVar) {
        this.xe.put(str, cdVar);
    }

    public final void m4801a(boolean z, int i) {
        C1486t c1486t = (!this.mo.dH() || this.mo.ac().oq) ? this.xf : null;
        m4796a(new dr(c1486t, this.xg, this.xj, this.mo, z, i, this.mo.dG()));
    }

    public final void m4802a(boolean z, int i, String str) {
        ds dsVar = null;
        boolean dH = this.mo.dH();
        C1486t c1486t = (!dH || this.mo.ac().oq) ? this.xf : null;
        if (!dH) {
            dsVar = this.xg;
        }
        m4796a(new dr(c1486t, dsVar, this.pP, this.xj, this.mo, z, i, str, this.mo.dG(), this.qc));
    }

    public final void m4803a(boolean z, int i, String str, String str2) {
        boolean dH = this.mo.dH();
        C1486t c1486t = (!dH || this.mo.ac().oq) ? this.xf : null;
        m4796a(new dr(c1486t, dH ? null : this.xg, this.pP, this.xj, this.mo, z, i, str, str2, this.mo.dG(), this.qc));
    }

    public final void cg() {
        synchronized (this.mH) {
            this.xh = false;
            this.xi = true;
            dp dC = this.mo.dC();
            if (dC != null) {
                if (gq.dB()) {
                    dC.cg();
                } else {
                    gq.wR.post(new C11741(this, dC));
                }
            }
        }
    }

    public C1497v dM() {
        return this.qd;
    }

    public boolean dN() {
        boolean z;
        synchronized (this.mH) {
            z = this.xi;
        }
        return z;
    }

    public void dO() {
        if (dN()) {
            this.xk.bY();
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        gr.m4772V("Loading resource: " + str);
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m4793e(parse);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        if (this.tu != null) {
            this.tu.m4147a(this.mo);
            this.tu = null;
        }
    }

    public final void reset() {
        synchronized (this.mH) {
            this.xe.clear();
            this.xf = null;
            this.xg = null;
            this.tu = null;
            this.pP = null;
            this.xh = false;
            this.xi = false;
            this.qc = null;
            this.xj = null;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        gr.m4772V("AdWebView shouldOverrideUrlLoading: " + str);
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m4793e(parse);
        } else if (this.xh && webView == this.mo && m4792d(parse)) {
            return super.shouldOverrideUrlLoading(webView, str);
        } else {
            if (this.mo.willNotDraw()) {
                gr.m4773W("AdWebView unable to handle URL: " + str);
            } else {
                Uri uri;
                try {
                    C1266k dF = this.mo.dF();
                    if (dF != null && dF.m5240b(parse)) {
                        parse = dF.m5237a(parse, this.mo.getContext());
                    }
                    uri = parse;
                } catch (C1280l e) {
                    gr.m4773W("Unable to append parameter to URL: " + str);
                    uri = parse;
                }
                if (this.qd == null || this.qd.az()) {
                    m4795a(new C1089do("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
                } else {
                    this.qd.m6070d(str);
                }
            }
        }
        return true;
    }
}
