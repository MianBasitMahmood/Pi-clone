package com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

@ey
public final class dd implements MediationBannerListener, MediationInterstitialListener {
    private final da qW;

    public dd(da daVar) {
        this.qW = daVar;
    }

    public final void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        jx.aU("onAdClicked must be called on the main UI thread.");
        gr.m4769S("Adapter called onAdClicked.");
        try {
            this.qW.onAdClicked();
        } catch (Throwable e) {
            gr.m4777d("Could not call onAdClicked.", e);
        }
    }

    public final void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        jx.aU("onAdClicked must be called on the main UI thread.");
        gr.m4769S("Adapter called onAdClicked.");
        try {
            this.qW.onAdClicked();
        } catch (Throwable e) {
            gr.m4777d("Could not call onAdClicked.", e);
        }
    }

    public final void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        jx.aU("onAdClosed must be called on the main UI thread.");
        gr.m4769S("Adapter called onAdClosed.");
        try {
            this.qW.onAdClosed();
        } catch (Throwable e) {
            gr.m4777d("Could not call onAdClosed.", e);
        }
    }

    public final void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        jx.aU("onAdClosed must be called on the main UI thread.");
        gr.m4769S("Adapter called onAdClosed.");
        try {
            this.qW.onAdClosed();
        } catch (Throwable e) {
            gr.m4777d("Could not call onAdClosed.", e);
        }
    }

    public final void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i) {
        jx.aU("onAdFailedToLoad must be called on the main UI thread.");
        gr.m4769S("Adapter called onAdFailedToLoad with error. " + i);
        try {
            this.qW.onAdFailedToLoad(i);
        } catch (Throwable e) {
            gr.m4777d("Could not call onAdFailedToLoad.", e);
        }
    }

    public final void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        jx.aU("onAdFailedToLoad must be called on the main UI thread.");
        gr.m4769S("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.qW.onAdFailedToLoad(i);
        } catch (Throwable e) {
            gr.m4777d("Could not call onAdFailedToLoad.", e);
        }
    }

    public final void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        jx.aU("onAdLeftApplication must be called on the main UI thread.");
        gr.m4769S("Adapter called onAdLeftApplication.");
        try {
            this.qW.onAdLeftApplication();
        } catch (Throwable e) {
            gr.m4777d("Could not call onAdLeftApplication.", e);
        }
    }

    public final void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        jx.aU("onAdLeftApplication must be called on the main UI thread.");
        gr.m4769S("Adapter called onAdLeftApplication.");
        try {
            this.qW.onAdLeftApplication();
        } catch (Throwable e) {
            gr.m4777d("Could not call onAdLeftApplication.", e);
        }
    }

    public final void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        jx.aU("onAdLoaded must be called on the main UI thread.");
        gr.m4769S("Adapter called onAdLoaded.");
        try {
            this.qW.onAdLoaded();
        } catch (Throwable e) {
            gr.m4777d("Could not call onAdLoaded.", e);
        }
    }

    public final void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        jx.aU("onAdLoaded must be called on the main UI thread.");
        gr.m4769S("Adapter called onAdLoaded.");
        try {
            this.qW.onAdLoaded();
        } catch (Throwable e) {
            gr.m4777d("Could not call onAdLoaded.", e);
        }
    }

    public final void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        jx.aU("onAdOpened must be called on the main UI thread.");
        gr.m4769S("Adapter called onAdOpened.");
        try {
            this.qW.onAdOpened();
        } catch (Throwable e) {
            gr.m4777d("Could not call onAdOpened.", e);
        }
    }

    public final void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        jx.aU("onAdOpened must be called on the main UI thread.");
        gr.m4769S("Adapter called onAdOpened.");
        try {
            this.qW.onAdOpened();
        } catch (Throwable e) {
            gr.m4777d("Could not call onAdOpened.", e);
        }
    }
}
