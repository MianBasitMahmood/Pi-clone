package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.gr;

public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    private View f1093n;
    private CustomEventBanner xu;
    private CustomEventInterstitial xv;

    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter.a */
    private static final class C0373a implements CustomEventBannerListener {
        private final MediationBannerListener f1091l;
        private final CustomEventAdapter xw;

        public C0373a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.xw = customEventAdapter;
            this.f1091l = mediationBannerListener;
        }

        public final void onAdClicked() {
            gr.m4769S("Custom event adapter called onAdClicked.");
            this.f1091l.onAdClicked(this.xw);
        }

        public final void onAdClosed() {
            gr.m4769S("Custom event adapter called onAdClosed.");
            this.f1091l.onAdClosed(this.xw);
        }

        public final void onAdFailedToLoad(int i) {
            gr.m4769S("Custom event adapter called onAdFailedToLoad.");
            this.f1091l.onAdFailedToLoad(this.xw, i);
        }

        public final void onAdLeftApplication() {
            gr.m4769S("Custom event adapter called onAdLeftApplication.");
            this.f1091l.onAdLeftApplication(this.xw);
        }

        public final void onAdLoaded(View view) {
            gr.m4769S("Custom event adapter called onAdLoaded.");
            this.xw.f1093n = view;
            this.f1091l.onAdLoaded(this.xw);
        }

        public final void onAdOpened() {
            gr.m4769S("Custom event adapter called onAdOpened.");
            this.f1091l.onAdOpened(this.xw);
        }
    }

    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter.b */
    private class C0374b implements CustomEventInterstitialListener {
        private final MediationInterstitialListener f1092m;
        private final CustomEventAdapter xw;
        final /* synthetic */ CustomEventAdapter xx;

        public C0374b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.xx = customEventAdapter;
            this.xw = customEventAdapter2;
            this.f1092m = mediationInterstitialListener;
        }

        public void onAdClicked() {
            gr.m4769S("Custom event adapter called onAdClicked.");
            this.f1092m.onAdClicked(this.xw);
        }

        public void onAdClosed() {
            gr.m4769S("Custom event adapter called onAdClosed.");
            this.f1092m.onAdClosed(this.xw);
        }

        public void onAdFailedToLoad(int i) {
            gr.m4769S("Custom event adapter called onFailedToReceiveAd.");
            this.f1092m.onAdFailedToLoad(this.xw, i);
        }

        public void onAdLeftApplication() {
            gr.m4769S("Custom event adapter called onAdLeftApplication.");
            this.f1092m.onAdLeftApplication(this.xw);
        }

        public void onAdLoaded() {
            gr.m4769S("Custom event adapter called onReceivedAd.");
            this.f1092m.onAdLoaded(this.xx);
        }

        public void onAdOpened() {
            gr.m4769S("Custom event adapter called onAdOpened.");
            this.f1092m.onAdOpened(this.xw);
        }
    }

    private static <T> T m1446a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            gr.m4773W("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    private void m1447a(View view) {
        this.f1093n = view;
    }

    public final View getBannerView() {
        return this.f1093n;
    }

    public final void onDestroy() {
        if (this.xu != null) {
            this.xu.onDestroy();
        }
        if (this.xv != null) {
            this.xv.onDestroy();
        }
    }

    public final void onPause() {
        if (this.xu != null) {
            this.xu.onPause();
        }
        if (this.xv != null) {
            this.xv.onPause();
        }
    }

    public final void onResume() {
        if (this.xu != null) {
            this.xu.onResume();
        }
        if (this.xv != null) {
            this.xv.onResume();
        }
    }

    public final void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.xu = (CustomEventBanner) m1446a(bundle.getString("class_name"));
        if (this.xu == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.xu.requestBannerAd(context, new C0373a(this, mediationBannerListener), bundle.getString("parameter"), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.xv = (CustomEventInterstitial) m1446a(bundle.getString("class_name"));
        if (this.xv == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.xv.requestInterstitialAd(context, new C0374b(this, this, mediationInterstitialListener), bundle.getString("parameter"), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public final void showInterstitial() {
        this.xv.showInterstitial();
    }
}
