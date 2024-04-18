package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.en.C1110a;

@ey
public final class es extends C1110a {
    private final InAppPurchaseListener oM;

    public es(InAppPurchaseListener inAppPurchaseListener) {
        this.oM = inAppPurchaseListener;
    }

    public final void m4531a(em emVar) {
        this.oM.onInAppPurchaseRequested(new ev(emVar));
    }
}
