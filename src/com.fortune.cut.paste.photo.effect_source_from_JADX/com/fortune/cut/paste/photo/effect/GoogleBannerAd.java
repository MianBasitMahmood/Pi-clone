package com.fortune.cut.paste.photo.effect;

import android.app.Activity;
import android.widget.LinearLayout;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/* renamed from: com.fortune.cut.paste.photo.effect.b */
public final class GoogleBannerAd {
    public AdView f1066a;
    LinearLayout f1067b;

    public GoogleBannerAd(Activity activity) {
        this.f1066a = new AdView(activity);
        this.f1066a.setAdSize(AdSize.BANNER);
        this.f1066a.setAdUnitId(activity.getString(R.string.ADMOB_BANNER_ADUNIT_ID));
        this.f1067b = (LinearLayout) activity.findViewById(R.id.bannerAd);
        this.f1067b.addView(this.f1066a);
        this.f1066a.loadAd(new Builder().build());
    }
}
