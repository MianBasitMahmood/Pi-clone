package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.bh;

public final class AdView extends ViewGroup {
    private final bh ll;

    public AdView(Context context) {
        super(context);
        this.ll = new bh(this);
    }

    public AdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ll = new bh(this, attributeSet, false);
    }

    public AdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ll = new bh(this, attributeSet, false);
    }

    public final void destroy() {
        this.ll.destroy();
    }

    public final AdListener getAdListener() {
        return this.ll.getAdListener();
    }

    public final AdSize getAdSize() {
        return this.ll.getAdSize();
    }

    public final String getAdUnitId() {
        return this.ll.getAdUnitId();
    }

    public final InAppPurchaseListener getInAppPurchaseListener() {
        return this.ll.getInAppPurchaseListener();
    }

    public final String getMediationAdapterClassName() {
        return this.ll.getMediationAdapterClassName();
    }

    public final void loadAd(AdRequest adRequest) {
        this.ll.m4249a(adRequest.m1437Y());
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    protected final void onMeasure(int i, int i2) {
        int measuredWidth;
        int i3 = 0;
        View childAt = getChildAt(0);
        AdSize adSize = getAdSize();
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, i, i2);
            measuredWidth = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        } else if (adSize != null) {
            Context context = getContext();
            measuredWidth = adSize.getWidthInPixels(context);
            i3 = adSize.getHeightInPixels(context);
        } else {
            measuredWidth = 0;
        }
        setMeasuredDimension(View.resolveSize(Math.max(measuredWidth, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public final void pause() {
        this.ll.pause();
    }

    public final void resume() {
        this.ll.resume();
    }

    public final void setAdListener(AdListener adListener) {
        this.ll.setAdListener(adListener);
    }

    public final void setAdSize(AdSize adSize) {
        this.ll.setAdSizes(adSize);
    }

    public final void setAdUnitId(String str) {
        this.ll.setAdUnitId(str);
    }

    public final void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.ll.setInAppPurchaseListener(inAppPurchaseListener);
    }

    public final void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        this.ll.setPlayStorePurchaseParams(playStorePurchaseListener, str);
    }
}
