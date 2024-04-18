package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWalletRequest implements SafeParcelable {
    public static final Creator<FullWalletRequest> CREATOR;
    private final int CK;
    String auL;
    String auM;
    Cart auV;

    public final class Builder {
        final /* synthetic */ FullWalletRequest auW;

        private Builder(FullWalletRequest fullWalletRequest) {
            this.auW = fullWalletRequest;
        }

        public final FullWalletRequest build() {
            return this.auW;
        }

        public final Builder setCart(Cart cart) {
            this.auW.auV = cart;
            return this;
        }

        public final Builder setGoogleTransactionId(String str) {
            this.auW.auL = str;
            return this;
        }

        public final Builder setMerchantTransactionId(String str) {
            this.auW.auM = str;
            return this;
        }
    }

    static {
        CREATOR = new C1863g();
    }

    FullWalletRequest() {
        this.CK = 1;
    }

    FullWalletRequest(int i, String str, String str2, Cart cart) {
        this.CK = i;
        this.auL = str;
        this.auM = str2;
        this.auV = cart;
    }

    public static Builder newBuilder() {
        FullWalletRequest fullWalletRequest = new FullWalletRequest();
        fullWalletRequest.getClass();
        return new Builder(null);
    }

    public final int describeContents() {
        return 0;
    }

    public final Cart getCart() {
        return this.auV;
    }

    public final String getGoogleTransactionId() {
        return this.auL;
    }

    public final String getMerchantTransactionId() {
        return this.auM;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1863g.m6790a(this, parcel, i);
    }
}
