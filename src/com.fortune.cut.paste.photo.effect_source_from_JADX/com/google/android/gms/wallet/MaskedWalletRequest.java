package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest implements SafeParcelable {
    public static final Creator<MaskedWalletRequest> CREATOR;
    private final int CK;
    String auG;
    String auM;
    Cart auV;
    boolean avA;
    boolean avB;
    String avC;
    String avD;
    boolean avE;
    boolean avF;
    CountrySpecification[] avG;
    boolean avH;
    boolean avI;
    ArrayList<CountrySpecification> avJ;
    boolean avz;

    public final class Builder {
        final /* synthetic */ MaskedWalletRequest avK;

        private Builder(MaskedWalletRequest maskedWalletRequest) {
            this.avK = maskedWalletRequest;
        }

        public final Builder addAllowedCountrySpecificationForShipping(CountrySpecification countrySpecification) {
            if (this.avK.avJ == null) {
                this.avK.avJ = new ArrayList();
            }
            this.avK.avJ.add(countrySpecification);
            return this;
        }

        public final Builder addAllowedCountrySpecificationsForShipping(Collection<CountrySpecification> collection) {
            if (collection != null) {
                if (this.avK.avJ == null) {
                    this.avK.avJ = new ArrayList();
                }
                this.avK.avJ.addAll(collection);
            }
            return this;
        }

        public final MaskedWalletRequest build() {
            return this.avK;
        }

        public final Builder setAllowDebitCard(boolean z) {
            this.avK.avI = z;
            return this;
        }

        public final Builder setAllowPrepaidCard(boolean z) {
            this.avK.avH = z;
            return this;
        }

        public final Builder setCart(Cart cart) {
            this.avK.auV = cart;
            return this;
        }

        public final Builder setCurrencyCode(String str) {
            this.avK.auG = str;
            return this;
        }

        public final Builder setEstimatedTotalPrice(String str) {
            this.avK.avC = str;
            return this;
        }

        public final Builder setIsBillingAgreement(boolean z) {
            this.avK.avF = z;
            return this;
        }

        public final Builder setMerchantName(String str) {
            this.avK.avD = str;
            return this;
        }

        public final Builder setMerchantTransactionId(String str) {
            this.avK.auM = str;
            return this;
        }

        public final Builder setPhoneNumberRequired(boolean z) {
            this.avK.avz = z;
            return this;
        }

        public final Builder setShippingAddressRequired(boolean z) {
            this.avK.avA = z;
            return this;
        }

        public final Builder setShouldRetrieveWalletObjects(boolean z) {
            this.avK.avE = z;
            return this;
        }

        public final Builder setUseMinimalBillingAddress(boolean z) {
            this.avK.avB = z;
            return this;
        }
    }

    static {
        CREATOR = new C1868l();
    }

    MaskedWalletRequest() {
        this.CK = 3;
        this.avH = true;
        this.avI = true;
    }

    MaskedWalletRequest(int i, String str, boolean z, boolean z2, boolean z3, String str2, String str3, String str4, Cart cart, boolean z4, boolean z5, CountrySpecification[] countrySpecificationArr, boolean z6, boolean z7, ArrayList<CountrySpecification> arrayList) {
        this.CK = i;
        this.auM = str;
        this.avz = z;
        this.avA = z2;
        this.avB = z3;
        this.avC = str2;
        this.auG = str3;
        this.avD = str4;
        this.auV = cart;
        this.avE = z4;
        this.avF = z5;
        this.avG = countrySpecificationArr;
        this.avH = z6;
        this.avI = z7;
        this.avJ = arrayList;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest maskedWalletRequest = new MaskedWalletRequest();
        maskedWalletRequest.getClass();
        return new Builder(null);
    }

    public final boolean allowDebitCard() {
        return this.avI;
    }

    public final boolean allowPrepaidCard() {
        return this.avH;
    }

    public final int describeContents() {
        return 0;
    }

    public final ArrayList<CountrySpecification> getAllowedCountrySpecificationsForShipping() {
        return this.avJ;
    }

    public final CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.avG;
    }

    public final Cart getCart() {
        return this.auV;
    }

    public final String getCurrencyCode() {
        return this.auG;
    }

    public final String getEstimatedTotalPrice() {
        return this.avC;
    }

    public final String getMerchantName() {
        return this.avD;
    }

    public final String getMerchantTransactionId() {
        return this.auM;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final boolean isBillingAgreement() {
        return this.avF;
    }

    public final boolean isPhoneNumberRequired() {
        return this.avz;
    }

    public final boolean isShippingAddressRequired() {
        return this.avA;
    }

    public final boolean shouldRetrieveWalletObjects() {
        return this.avE;
    }

    public final boolean useMinimalBillingAddress() {
        return this.avB;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1868l.m6795a(this, parcel, i);
    }
}
