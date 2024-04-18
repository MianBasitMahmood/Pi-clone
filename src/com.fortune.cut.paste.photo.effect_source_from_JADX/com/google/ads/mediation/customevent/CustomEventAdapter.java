package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.gr;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View f1087n;
    private CustomEventBanner f1088o;
    private CustomEventInterstitial f1089p;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.a */
    private static final class C0364a implements CustomEventBannerListener {
        private final CustomEventAdapter f1082q;
        private final MediationBannerListener f1083r;

        public C0364a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f1082q = customEventAdapter;
            this.f1083r = mediationBannerListener;
        }

        public final void onClick() {
            gr.m4769S("Custom event adapter called onFailedToReceiveAd.");
            this.f1083r.onClick(this.f1082q);
        }

        public final void onDismissScreen() {
            gr.m4769S("Custom event adapter called onFailedToReceiveAd.");
            this.f1083r.onDismissScreen(this.f1082q);
        }

        public final void onFailedToReceiveAd() {
            gr.m4769S("Custom event adapter called onFailedToReceiveAd.");
            this.f1083r.onFailedToReceiveAd(this.f1082q, ErrorCode.NO_FILL);
        }

        public final void onLeaveApplication() {
            gr.m4769S("Custom event adapter called onFailedToReceiveAd.");
            this.f1083r.onLeaveApplication(this.f1082q);
        }

        public final void onPresentScreen() {
            gr.m4769S("Custom event adapter called onFailedToReceiveAd.");
            this.f1083r.onPresentScreen(this.f1082q);
        }

        public final void onReceivedAd(View view) {
            gr.m4769S("Custom event adapter called onReceivedAd.");
            this.f1082q.f1087n = view;
            this.f1083r.onReceivedAd(this.f1082q);
        }
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.b */
    private class C0365b implements CustomEventInterstitialListener {
        private final CustomEventAdapter f1084q;
        private final MediationInterstitialListener f1085s;
        final /* synthetic */ CustomEventAdapter f1086t;

        public C0365b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.f1086t = customEventAdapter;
            this.f1084q = customEventAdapter2;
            this.f1085s = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            gr.m4769S("Custom event adapter called onDismissScreen.");
            this.f1085s.onDismissScreen(this.f1084q);
        }

        public void onFailedToReceiveAd() {
            gr.m4769S("Custom event adapter called onFailedToReceiveAd.");
            this.f1085s.onFailedToReceiveAd(this.f1084q, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            gr.m4769S("Custom event adapter called onLeaveApplication.");
            this.f1085s.onLeaveApplication(this.f1084q);
        }

        public void onPresentScreen() {
            gr.m4769S("Custom event adapter called onPresentScreen.");
            this.f1085s.onPresentScreen(this.f1084q);
        }

        public void onReceivedAd() {
            gr.m4769S("Custom event adapter called onReceivedAd.");
            this.f1085s.onReceivedAd(this.f1086t);
        }
    }

    private static <T> T m1432a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            gr.m4773W("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    private void m1433a(View view) {
        this.f1087n = view;
    }

    public final void destroy() {
        if (this.f1088o != null) {
            this.f1088o.destroy();
        }
        if (this.f1089p != null) {
            this.f1089p.destroy();
        }
    }

    public final Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public final View getBannerView() {
        return this.f1087n;
    }

    public final Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public final void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f1088o = (CustomEventBanner) m1432a(customEventServerParameters.className);
        if (this.f1088o == null) {
            mediationBannerListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f1088o.requestBannerAd(new C0364a(this, mediationBannerListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    public final void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f1089p = (CustomEventInterstitial) m1432a(customEventServerParameters.className);
        if (this.f1089p == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f1089p.requestInterstitialAd(new C0365b(this, this, mediationInterstitialListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    public final void showInterstitial() {
        this.f1089p.showInterstitial();
    }
}
