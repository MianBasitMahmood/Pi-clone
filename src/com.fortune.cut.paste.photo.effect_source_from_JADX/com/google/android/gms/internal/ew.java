package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.er.C1116a;

@ey
public final class ew extends C1116a {
    private final PlayStorePurchaseListener oN;

    public ew(PlayStorePurchaseListener playStorePurchaseListener) {
        this.oN = playStorePurchaseListener;
    }

    public final void m4537a(eq eqVar) {
        this.oN.onInAppPurchaseFinished(new eu(eqVar));
    }

    public final boolean isValidPurchase(String str) {
        return this.oN.isValidPurchase(str);
    }
}
