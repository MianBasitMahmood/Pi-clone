package com.fortune.cut.paste.photo.effect;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;

/* renamed from: com.fortune.cut.paste.photo.effect.a */
public final class GoogleAd {
    AdRequest f1064a;
    private InterstitialAd f1065b;

    public GoogleAd(Context context) {
        this.f1064a = new Builder().build();
        this.f1065b = new InterstitialAd(context);
        this.f1065b.setAdUnitId(context.getString(R.string.ADMOB_INTRESTITIAL_ADUNIT_ID));
        this.f1065b.loadAd(this.f1064a);
    }

    public final void m1429a() {
        this.f1065b.show();
        this.f1065b.loadAd(this.f1064a);
    }
}
