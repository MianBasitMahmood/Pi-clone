package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.net.URISyntaxException;

@ey
public class gz extends WebViewClient {
    private final gu mo;
    private final String xr;
    private boolean xs;
    private final fb xt;

    public gz(fb fbVar, gu guVar, String str) {
        this.xr = m4810Z(str);
        this.xs = false;
        this.mo = guVar;
        this.xt = fbVar;
    }

    private String m4810Z(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.endsWith("/")) {
                    str = str.substring(0, str.length() - 1);
                }
            } catch (IndexOutOfBoundsException e) {
                gr.m4770T(e.getMessage());
            }
        }
        return str;
    }

    protected boolean m4811Y(String str) {
        Object Z = m4810Z(str);
        if (TextUtils.isEmpty(Z)) {
            return false;
        }
        try {
            URI uri = new URI(Z);
            if ("passback".equals(uri.getScheme())) {
                gr.m4769S("Passback received");
                this.xt.cG();
                return true;
            } else if (TextUtils.isEmpty(this.xr)) {
                return false;
            } else {
                URI uri2 = new URI(this.xr);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!jv.equal(host, host2) || !jv.equal(path, path2)) {
                    return false;
                }
                gr.m4769S("Passback received");
                this.xt.cG();
                return true;
            }
        } catch (URISyntaxException e) {
            gr.m4770T(e.getMessage());
            return false;
        }
    }

    public void onLoadResource(WebView webView, String str) {
        gr.m4769S("JavascriptAdWebViewClient::onLoadResource: " + str);
        if (!m4811Y(str)) {
            this.mo.dD().onLoadResource(this.mo, str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        gr.m4769S("JavascriptAdWebViewClient::onPageFinished: " + str);
        if (!this.xs) {
            this.xt.cF();
            this.xs = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        gr.m4769S("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + str);
        if (!m4811Y(str)) {
            return this.mo.dD().shouldOverrideUrlLoading(this.mo, str);
        }
        gr.m4769S("shouldOverrideUrlLoading: received passback url");
        return true;
    }
}
