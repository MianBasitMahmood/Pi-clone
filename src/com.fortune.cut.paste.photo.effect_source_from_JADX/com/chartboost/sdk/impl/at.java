package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout.LayoutParams;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.google.android.gms.analytics.ecommerce.Promotion;

public class at extends ap {
    private WebView f507a;
    private OnClickListener f508b;

    /* renamed from: com.chartboost.sdk.impl.at.1 */
    class C02151 extends WebViewClient {
        final /* synthetic */ at f506a;

        C02151(at atVar) {
            this.f506a = atVar;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null) {
                return false;
            }
            if (str.contains("chartboost") && str.contains(Promotion.ACTION_CLICK) && this.f506a.f508b != null) {
                this.f506a.f508b.onClick(this.f506a);
            }
            return true;
        }
    }

    public at(aw awVar, Context context) {
        super(context);
        this.f508b = null;
        this.f507a = new WebView(context);
        addView(this.f507a, new LayoutParams(-1, -1));
        this.f507a.setBackgroundColor(0);
        this.f507a.setWebViewClient(new C02151(this));
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.f508b = onClickListener;
    }

    public void m812a(C0111a c0111a, int i) {
        String e = c0111a.m162e("html");
        if (e != null) {
            try {
                this.f507a.loadDataWithBaseURL("file:///android_res/", e, "text/html", "UTF-8", null);
            } catch (Throwable e2) {
                CBLogging.m102b("AppCellWebView", "Exception raised loading data into webview", e2);
            }
        }
    }

    public int m811a() {
        return CBUtility.m109a(100, getContext());
    }
}
