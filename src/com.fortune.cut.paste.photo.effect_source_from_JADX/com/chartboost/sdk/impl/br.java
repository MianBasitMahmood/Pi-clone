package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout.LayoutParams;
import com.chartboost.sdk.C0177f;
import com.chartboost.sdk.C0177f.C0176a;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C0148a;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import java.net.URI;
import java.net.URLDecoder;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class br extends C0177f {
    private String f777k;

    /* renamed from: com.chartboost.sdk.impl.br.a */
    public class C0272a extends C0176a {
        public WebView f773b;
        final /* synthetic */ br f774c;

        public C0272a(br brVar, Context context, String str) {
            this.f774c = brVar;
            super(brVar, context);
            setFocusable(false);
            this.f773b = new C0273b(brVar, context);
            this.f773b.setWebViewClient(new C0274c(null));
            addView(this.f773b);
            this.f773b.loadDataWithBaseURL("file:///android_asset/", str, "text/html", "utf-8", null);
        }

        protected void m1136a(int i, int i2) {
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: com.chartboost.sdk.impl.br.b */
    private class C0273b extends WebView {
        final /* synthetic */ br f775a;

        public C0273b(br brVar, Context context) {
            this.f775a = brVar;
            super(context);
            setLayoutParams(new LayoutParams(-1, -1));
            setBackgroundColor(0);
            getSettings().setJavaScriptEnabled(true);
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 || i == 3) {
                this.f775a.m520h();
            }
            return super.onKeyDown(i, keyEvent);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.br.c */
    private class C0274c extends WebViewClient {
        final /* synthetic */ br f776a;

        private C0274c(br brVar) {
            this.f776a = brVar;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.f776a.m521i();
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            this.f776a.m506a(CBImpressionError.INTERNAL);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String str2;
            Throwable th;
            Object obj = null;
            CBLogging.m107e("CBWebViewProtocol", "loading url: " + str);
            try {
                if (new URI(str).getScheme().equals("chartboost")) {
                    String[] split = str.split("/");
                    Integer valueOf = Integer.valueOf(split.length);
                    if (valueOf.intValue() < 3) {
                        this.f776a.m520h();
                        return false;
                    }
                    String str3 = split[2];
                    if (str3.equals("close")) {
                        this.f776a.m520h();
                    } else if (str3.equals("link")) {
                        if (valueOf.intValue() < 4) {
                            this.f776a.m520h();
                            return false;
                        }
                        try {
                            str3 = URLDecoder.decode(split[3], "UTF-8");
                            try {
                                JSONObject jSONObject;
                                if (valueOf.intValue() > 4) {
                                    jSONObject = new JSONObject(new JSONTokener(URLDecoder.decode(split[4], "UTF-8")));
                                } else {
                                    jSONObject = null;
                                }
                                obj = jSONObject;
                                str2 = str3;
                            } catch (Throwable e) {
                                Throwable th2 = e;
                                str2 = str3;
                                th = th2;
                                CBLogging.m102b("CBWebViewProtocol", "Error decoding URL or JSON", th);
                                this.f776a.m511a(str2, C0111a.m146a(obj));
                                return true;
                            }
                        } catch (Throwable e2) {
                            th = e2;
                            str2 = null;
                            CBLogging.m102b("CBWebViewProtocol", "Error decoding URL or JSON", th);
                            this.f776a.m511a(str2, C0111a.m146a(obj));
                            return true;
                        }
                        this.f776a.m511a(str2, C0111a.m146a(obj));
                    }
                }
                return true;
            } catch (Exception e3) {
                this.f776a.m520h();
                return false;
            }
        }
    }

    public br(C0148a c0148a) {
        super(c0148a);
        this.f777k = null;
    }

    protected final C0176a m1145b(Context context) {
        return new C0272a(this, context, this.f777k);
    }

    public final boolean m1144a(C0111a c0111a) {
        String e = c0111a.m162e("html");
        if (e == null) {
            m506a(CBImpressionError.INTERNAL);
            return false;
        }
        this.f777k = e;
        m514b();
        return true;
    }
}
