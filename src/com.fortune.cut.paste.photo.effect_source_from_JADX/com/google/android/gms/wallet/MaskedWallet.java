package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.internal.jx;

public final class MaskedWallet implements SafeParcelable {
    public static final Creator<MaskedWallet> CREATOR;
    private final int CK;
    String auL;
    String auM;
    String auO;
    Address auP;
    Address auQ;
    String[] auR;
    UserAddress auS;
    UserAddress auT;
    InstrumentInfo[] auU;
    LoyaltyWalletObject[] avw;
    OfferWalletObject[] avx;

    public final class Builder {
        final /* synthetic */ MaskedWallet avy;

        private Builder(MaskedWallet maskedWallet) {
            this.avy = maskedWallet;
        }

        public final MaskedWallet build() {
            return this.avy;
        }

        public final Builder setBillingAddress(Address address) {
            this.avy.auP = address;
            return this;
        }

        public final Builder setBuyerBillingAddress(UserAddress userAddress) {
            this.avy.auS = userAddress;
            return this;
        }

        public final Builder setBuyerShippingAddress(UserAddress userAddress) {
            this.avy.auT = userAddress;
            return this;
        }

        public final Builder setEmail(String str) {
            this.avy.auO = str;
            return this;
        }

        public final Builder setGoogleTransactionId(String str) {
            this.avy.auL = str;
            return this;
        }

        public final Builder setInstrumentInfos(InstrumentInfo[] instrumentInfoArr) {
            this.avy.auU = instrumentInfoArr;
            return this;
        }

        public final Builder setLoyaltyWalletObjects(LoyaltyWalletObject[] loyaltyWalletObjectArr) {
            this.avy.avw = loyaltyWalletObjectArr;
            return this;
        }

        public final Builder setMerchantTransactionId(String str) {
            this.avy.auM = str;
            return this;
        }

        public final Builder setOfferWalletObjects(OfferWalletObject[] offerWalletObjectArr) {
            this.avy.avx = offerWalletObjectArr;
            return this;
        }

        public final Builder setPaymentDescriptions(String[] strArr) {
            this.avy.auR = strArr;
            return this;
        }

        public final Builder setShippingAddress(Address address) {
            this.avy.auQ = address;
            return this;
        }
    }

    static {
        CREATOR = new C1867k();
    }

    private MaskedWallet() {
        this.CK = 2;
    }

    MaskedWallet(int i, String str, String str2, String[] strArr, String str3, Address address, Address address2, LoyaltyWalletObject[] loyaltyWalletObjectArr, OfferWalletObject[] offerWalletObjectArr, UserAddress userAddress, UserAddress userAddress2, InstrumentInfo[] instrumentInfoArr) {
        this.CK = i;
        this.auL = str;
        this.auM = str2;
        this.auR = strArr;
        this.auO = str3;
        this.auP = address;
        this.auQ = address2;
        this.avw = loyaltyWalletObjectArr;
        this.avx = offerWalletObjectArr;
        this.auS = userAddress;
        this.auT = userAddress2;
        this.auU = instrumentInfoArr;
    }

    public static Builder newBuilderFrom(MaskedWallet maskedWallet) {
        jx.m5223i(maskedWallet);
        return rd().setGoogleTransactionId(maskedWallet.getGoogleTransactionId()).setMerchantTransactionId(maskedWallet.getMerchantTransactionId()).setPaymentDescriptions(maskedWallet.getPaymentDescriptions()).setInstrumentInfos(maskedWallet.getInstrumentInfos()).setEmail(maskedWallet.getEmail()).setLoyaltyWalletObjects(maskedWallet.getLoyaltyWalletObjects()).setOfferWalletObjects(maskedWallet.getOfferWalletObjects()).setBuyerBillingAddress(maskedWallet.getBuyerBillingAddress()).setBuyerShippingAddress(maskedWallet.getBuyerShippingAddress());
    }

    public static Builder rd() {
        MaskedWallet maskedWallet = new MaskedWallet();
        maskedWallet.getClass();
        return new Builder(null);
    }

    public final int describeContents() {
        return 0;
    }

    @Deprecated
    public final Address getBillingAddress() {
        return this.auP;
    }

    public final UserAddress getBuyerBillingAddress() {
        return this.auS;
    }

    public final UserAddress getBuyerShippingAddress() {
        return this.auT;
    }

    public final String getEmail() {
        return this.auO;
    }

    public final String getGoogleTransactionId() {
        return this.auL;
    }

    public final InstrumentInfo[] getInstrumentInfos() {
        return this.auU;
    }

    public final LoyaltyWalletObject[] getLoyaltyWalletObjects() {
        return this.avw;
    }

    public final String getMerchantTransactionId() {
        return this.auM;
    }

    public final OfferWalletObject[] getOfferWalletObjects() {
        return this.avx;
    }

    public final String[] getPaymentDescriptions() {
        return this.auR;
    }

    @Deprecated
    public final Address getShippingAddress() {
        return this.auQ;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1867k.m6794a(this, parcel, i);
    }
}
