package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class OfferWalletObject implements SafeParcelable {
    public static final Creator<OfferWalletObject> CREATOR;
    private final int CK;
    String avN;
    CommonWalletObject avO;
    String fl;

    static {
        CREATOR = new C1870n();
    }

    OfferWalletObject() {
        this.CK = 3;
    }

    OfferWalletObject(int i, String str, String str2, CommonWalletObject commonWalletObject) {
        this.CK = i;
        this.avN = str2;
        if (i < 3) {
            this.avO = CommonWalletObject.rh().dh(str).ri();
        } else {
            this.avO = commonWalletObject;
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final String getId() {
        return this.avO.getId();
    }

    public final String getRedemptionCode() {
        return this.avN;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1870n.m6797a(this, parcel, i);
    }
}
