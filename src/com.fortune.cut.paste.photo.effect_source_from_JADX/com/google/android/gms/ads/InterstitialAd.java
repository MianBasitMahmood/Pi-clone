package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.bi;

public final class InterstitialAd {
    private final bi lm;

    public InterstitialAd(Context context) {
        this.lm = new bi(context);
    }

    public final AdListener getAdListener() {
        return this.lm.getAdListener();
    }

    public final String getAdUnitId() {
        return this.lm.getAdUnitId();
    }

    public final InAppPurchaseListener getInAppPurchaseListener() {
        return this.lm.getInAppPurchaseListener();
    }

    public final String getMediationAdapterClassName() {
        return this.lm.getMediationAdapterClassName();
    }

    public final boolean isLoaded() {
        return this.lm.isLoaded();
    }

    public final void loadAd(AdRequest adRequest) {
        this.lm.m4253a(adRequest.m1437Y());
    }

    public final void setAdListener(AdListener adListener) {
        this.lm.setAdListener(adListener);
    }

    public final void setAdUnitId(String str) {
        this.lm.setAdUnitId(str);
    }

    public final void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.lm.setInAppPurchaseListener(inAppPurchaseListener);
    }

    public final void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        this.lm.setPlayStorePurchaseParams(playStorePurchaseListener, str);
    }

    public final void show() {
        this.lm.show();
    }
}
