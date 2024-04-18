package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.d */
public final class C1847d implements SafeParcelable {
    public static final Creator<C1847d> CREATOR;
    private final int CK;
    LoyaltyWalletObject auJ;
    OfferWalletObject auK;

    static {
        CREATOR = new C1848e();
    }

    C1847d() {
        this.CK = 2;
    }

    C1847d(int i, LoyaltyWalletObject loyaltyWalletObject, OfferWalletObject offerWalletObject) {
        this.CK = i;
        this.auJ = loyaltyWalletObject;
        this.auK = offerWalletObject;
    }

    public final int describeContents() {
        return 0;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1848e.m6713a(this, parcel, i);
    }
}
