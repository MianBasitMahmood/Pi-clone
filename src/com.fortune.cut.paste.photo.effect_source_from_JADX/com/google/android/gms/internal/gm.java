package com.google.android.gms.internal;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.File;

@ey
public final class gm {
    public static void m4752a(Context context, WebSettings webSettings) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            webSettings.setAppCachePath(cacheDir.getAbsolutePath());
            webSettings.setAppCacheMaxSize(0);
            webSettings.setAppCacheEnabled(true);
        }
        webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
    }

    public static void m4753a(Window window) {
        window.setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
    }

    public static void m4754a(WebView webView) {
        webView.onPause();
    }

    public static void m4755b(WebView webView) {
        webView.onResume();
    }

    public static void m4756i(View view) {
        view.setLayerType(1, null);
    }

    public static void m4757j(View view) {
        view.setLayerType(0, null);
    }
}
