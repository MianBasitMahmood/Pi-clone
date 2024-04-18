package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.bi;

public final class PublisherInterstitialAd {
    private final bi lm;

    public PublisherInterstitialAd(Context context) {
        this.lm = new bi(context, this);
    }

    public final AdListener getAdListener() {
        return this.lm.getAdListener();
    }

    public final String getAdUnitId() {
        return this.lm.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.lm.getAppEventListener();
    }

    public final String getMediationAdapterClassName() {
        return this.lm.getMediationAdapterClassName();
    }

    public final boolean isLoaded() {
        return this.lm.isLoaded();
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.lm.m4253a(publisherAdRequest.m1440Y());
    }

    public final void setAdListener(AdListener adListener) {
        this.lm.setAdListener(adListener);
    }

    public final void setAdUnitId(String str) {
        this.lm.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.lm.setAppEventListener(appEventListener);
    }

    public final void show() {
        this.lm.show();
    }
}
