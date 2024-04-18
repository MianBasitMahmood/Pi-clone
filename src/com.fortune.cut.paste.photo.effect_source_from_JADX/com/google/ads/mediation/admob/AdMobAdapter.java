package com.google.ads.mediation.admob;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.gq;
import java.util.Date;
import java.util.Set;

public final class AdMobAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    private AdView f1080i;
    private InterstitialAd f1081j;

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter.a */
    private static final class C0362a extends AdListener {
        private final AdMobAdapter f1076k;
        private final MediationBannerListener f1077l;

        public C0362a(AdMobAdapter adMobAdapter, MediationBannerListener mediationBannerListener) {
            this.f1076k = adMobAdapter;
            this.f1077l = mediationBannerListener;
        }

        public final void onAdClosed() {
            this.f1077l.onAdClosed(this.f1076k);
        }

        public final void onAdFailedToLoad(int i) {
            this.f1077l.onAdFailedToLoad(this.f1076k, i);
        }

        public final void onAdLeftApplication() {
            this.f1077l.onAdLeftApplication(this.f1076k);
        }

        public final void onAdLoaded() {
            this.f1077l.onAdLoaded(this.f1076k);
        }

        public final void onAdOpened() {
            this.f1077l.onAdClicked(this.f1076k);
            this.f1077l.onAdOpened(this.f1076k);
        }
    }

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter.b */
    private static final class C0363b extends AdListener {
        private final AdMobAdapter f1078k;
        private final MediationInterstitialListener f1079m;

        public C0363b(AdMobAdapter adMobAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f1078k = adMobAdapter;
            this.f1079m = mediationInterstitialListener;
        }

        public final void onAdClosed() {
            this.f1079m.onAdClosed(this.f1078k);
        }

        public final void onAdFailedToLoad(int i) {
            this.f1079m.onAdFailedToLoad(this.f1078k, i);
        }

        public final void onAdLeftApplication() {
            this.f1079m.onAdLeftApplication(this.f1078k);
        }

        public final void onAdLoaded() {
            this.f1079m.onAdLoaded(this.f1078k);
        }

        public final void onAdOpened() {
            this.f1079m.onAdOpened(this.f1078k);
        }
    }

    static AdRequest m1431a(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Builder builder = new Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(gq.m4768v(context));
        }
        if (bundle2.getInt("tagForChildDirectedTreatment") != -1) {
            builder.tagForChildDirectedTreatment(bundle2.getInt("tagForChildDirectedTreatment") == 1);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("gw", 1);
        bundle.putString("mad_hac", bundle2.getString("mad_hac"));
        if (!TextUtils.isEmpty(bundle2.getString("adJson"))) {
            bundle.putString("_ad", bundle2.getString("adJson"));
        }
        bundle.putBoolean("_noRefresh", true);
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        return builder.build();
    }

    public final View getBannerView() {
        return this.f1080i;
    }

    public final void onDestroy() {
        if (this.f1080i != null) {
            this.f1080i.destroy();
            this.f1080i = null;
        }
        if (this.f1081j != null) {
            this.f1081j = null;
        }
    }

    public final void onPause() {
        if (this.f1080i != null) {
            this.f1080i.pause();
        }
    }

    public final void onResume() {
        if (this.f1080i != null) {
            this.f1080i.resume();
        }
    }

    public final void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f1080i = new AdView(context);
        this.f1080i.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.f1080i.setAdUnitId(bundle.getString("pubid"));
        this.f1080i.setAdListener(new C0362a(this, mediationBannerListener));
        this.f1080i.loadAd(m1431a(context, mediationAdRequest, bundle2, bundle));
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f1081j = new InterstitialAd(context);
        this.f1081j.setAdUnitId(bundle.getString("pubid"));
        this.f1081j.setAdListener(new C0363b(this, mediationInterstitialListener));
        this.f1081j.loadAd(m1431a(context, mediationAdRequest, bundle2, bundle));
    }

    public final void showInterstitial() {
        this.f1081j.show();
    }
}
