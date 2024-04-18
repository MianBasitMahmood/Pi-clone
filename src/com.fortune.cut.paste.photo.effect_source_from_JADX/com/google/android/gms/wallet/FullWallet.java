package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet implements SafeParcelable {
    public static final Creator<FullWallet> CREATOR;
    private final int CK;
    String auL;
    String auM;
    ProxyCard auN;
    String auO;
    Address auP;
    Address auQ;
    String[] auR;
    UserAddress auS;
    UserAddress auT;
    InstrumentInfo[] auU;

    static {
        CREATOR = new C1849f();
    }

    private FullWallet() {
        this.CK = 1;
    }

    FullWallet(int i, String str, String str2, ProxyCard proxyCard, String str3, Address address, Address address2, String[] strArr, UserAddress userAddress, UserAddress userAddress2, InstrumentInfo[] instrumentInfoArr) {
        this.CK = i;
        this.auL = str;
        this.auM = str2;
        this.auN = proxyCard;
        this.auO = str3;
        this.auP = address;
        this.auQ = address2;
        this.auR = strArr;
        this.auS = userAddress;
        this.auT = userAddress2;
        this.auU = instrumentInfoArr;
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

    public final String getMerchantTransactionId() {
        return this.auM;
    }

    public final String[] getPaymentDescriptions() {
        return this.auR;
    }

    public final ProxyCard getProxyCard() {
        return this.auN;
    }

    @Deprecated
    public final Address getShippingAddress() {
        return this.auQ;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1849f.m6714a(this, parcel, i);
    }
}
