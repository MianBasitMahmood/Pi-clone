package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.bc.C1021a;

@ey
public final class at extends C1021a {
    private final AdListener ob;

    public at(AdListener adListener) {
        this.ob = adListener;
    }

    public final void onAdClosed() {
        this.ob.onAdClosed();
    }

    public final void onAdFailedToLoad(int i) {
        this.ob.onAdFailedToLoad(i);
    }

    public final void onAdLeftApplication() {
        this.ob.onAdLeftApplication();
    }

    public final void onAdLoaded() {
        this.ob.onAdLoaded();
    }

    public final void onAdOpened() {
        this.ob.onAdOpened();
    }
}
