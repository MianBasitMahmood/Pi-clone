package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@ey
public final class df<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final da qW;

    /* renamed from: com.google.android.gms.internal.df.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ df qZ;
        final /* synthetic */ ErrorCode ra;

        AnonymousClass10(df dfVar, ErrorCode errorCode) {
            this.qZ = dfVar;
            this.ra = errorCode;
        }

        public void run() {
            try {
                this.qZ.qW.onAdFailedToLoad(dg.m4417a(this.ra));
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.df.1 */
    class C10731 implements Runnable {
        final /* synthetic */ df qZ;

        C10731(df dfVar) {
            this.qZ = dfVar;
        }

        public void run() {
            try {
                this.qZ.qW.onAdClicked();
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdClicked.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.df.2 */
    class C10742 implements Runnable {
        final /* synthetic */ df qZ;

        C10742(df dfVar) {
            this.qZ = dfVar;
        }

        public void run() {
            try {
                this.qZ.qW.onAdOpened();
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.df.3 */
    class C10753 implements Runnable {
        final /* synthetic */ df qZ;

        C10753(df dfVar) {
            this.qZ = dfVar;
        }

        public void run() {
            try {
                this.qZ.qW.onAdLoaded();
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.df.4 */
    class C10764 implements Runnable {
        final /* synthetic */ df qZ;

        C10764(df dfVar) {
            this.qZ = dfVar;
        }

        public void run() {
            try {
                this.qZ.qW.onAdClosed();
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdClosed.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.df.5 */
    class C10775 implements Runnable {
        final /* synthetic */ df qZ;
        final /* synthetic */ ErrorCode ra;

        C10775(df dfVar, ErrorCode errorCode) {
            this.qZ = dfVar;
            this.ra = errorCode;
        }

        public void run() {
            try {
                this.qZ.qW.onAdFailedToLoad(dg.m4417a(this.ra));
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.df.6 */
    class C10786 implements Runnable {
        final /* synthetic */ df qZ;

        C10786(df dfVar) {
            this.qZ = dfVar;
        }

        public void run() {
            try {
                this.qZ.qW.onAdLeftApplication();
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdLeftApplication.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.df.7 */
    class C10797 implements Runnable {
        final /* synthetic */ df qZ;

        C10797(df dfVar) {
            this.qZ = dfVar;
        }

        public void run() {
            try {
                this.qZ.qW.onAdOpened();
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.df.8 */
    class C10808 implements Runnable {
        final /* synthetic */ df qZ;

        C10808(df dfVar) {
            this.qZ = dfVar;
        }

        public void run() {
            try {
                this.qZ.qW.onAdLoaded();
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.df.9 */
    class C10819 implements Runnable {
        final /* synthetic */ df qZ;

        C10819(df dfVar) {
            this.qZ = dfVar;
        }

        public void run() {
            try {
                this.qZ.qW.onAdClosed();
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdClosed.", e);
            }
        }
    }

    public df(da daVar) {
        this.qW = daVar;
    }

    public final void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        gr.m4769S("Adapter called onClick.");
        if (gq.dB()) {
            try {
                this.qW.onAdClicked();
                return;
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdClicked.", e);
                return;
            }
        }
        gr.m4773W("onClick must be called on the main UI thread.");
        gq.wR.post(new C10731(this));
    }

    public final void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        gr.m4769S("Adapter called onDismissScreen.");
        if (gq.dB()) {
            try {
                this.qW.onAdClosed();
                return;
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdClosed.", e);
                return;
            }
        }
        gr.m4773W("onDismissScreen must be called on the main UI thread.");
        gq.wR.post(new C10764(this));
    }

    public final void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        gr.m4769S("Adapter called onDismissScreen.");
        if (gq.dB()) {
            try {
                this.qW.onAdClosed();
                return;
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdClosed.", e);
                return;
            }
        }
        gr.m4773W("onDismissScreen must be called on the main UI thread.");
        gq.wR.post(new C10819(this));
    }

    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, ErrorCode errorCode) {
        gr.m4769S("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (gq.dB()) {
            try {
                this.qW.onAdFailedToLoad(dg.m4417a(errorCode));
                return;
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        gr.m4773W("onFailedToReceiveAd must be called on the main UI thread.");
        gq.wR.post(new C10775(this, errorCode));
    }

    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, ErrorCode errorCode) {
        gr.m4769S("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (gq.dB()) {
            try {
                this.qW.onAdFailedToLoad(dg.m4417a(errorCode));
                return;
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        gr.m4773W("onFailedToReceiveAd must be called on the main UI thread.");
        gq.wR.post(new AnonymousClass10(this, errorCode));
    }

    public final void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        gr.m4769S("Adapter called onLeaveApplication.");
        if (gq.dB()) {
            try {
                this.qW.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        gr.m4773W("onLeaveApplication must be called on the main UI thread.");
        gq.wR.post(new C10786(this));
    }

    public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        gr.m4769S("Adapter called onLeaveApplication.");
        if (gq.dB()) {
            try {
                this.qW.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        gr.m4773W("onLeaveApplication must be called on the main UI thread.");
        gq.wR.post(new Runnable() {
            final /* synthetic */ df qZ;

            {
                this.qZ = r1;
            }

            public void run() {
                try {
                    this.qZ.qW.onAdLeftApplication();
                } catch (Throwable e) {
                    gr.m4777d("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public final void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        gr.m4769S("Adapter called onPresentScreen.");
        if (gq.dB()) {
            try {
                this.qW.onAdOpened();
                return;
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdOpened.", e);
                return;
            }
        }
        gr.m4773W("onPresentScreen must be called on the main UI thread.");
        gq.wR.post(new C10797(this));
    }

    public final void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        gr.m4769S("Adapter called onPresentScreen.");
        if (gq.dB()) {
            try {
                this.qW.onAdOpened();
                return;
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdOpened.", e);
                return;
            }
        }
        gr.m4773W("onPresentScreen must be called on the main UI thread.");
        gq.wR.post(new C10742(this));
    }

    public final void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        gr.m4769S("Adapter called onReceivedAd.");
        if (gq.dB()) {
            try {
                this.qW.onAdLoaded();
                return;
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdLoaded.", e);
                return;
            }
        }
        gr.m4773W("onReceivedAd must be called on the main UI thread.");
        gq.wR.post(new C10808(this));
    }

    public final void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        gr.m4769S("Adapter called onReceivedAd.");
        if (gq.dB()) {
            try {
                this.qW.onAdLoaded();
                return;
            } catch (Throwable e) {
                gr.m4777d("Could not call onAdLoaded.", e);
                return;
            }
        }
        gr.m4773W("onReceivedAd must be called on the main UI thread.");
        gq.wR.post(new C10753(this));
    }
}
