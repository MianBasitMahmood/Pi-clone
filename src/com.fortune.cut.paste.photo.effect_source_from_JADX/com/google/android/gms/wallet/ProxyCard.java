package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard implements SafeParcelable {
    public static final Creator<ProxyCard> CREATOR;
    private final int CK;
    String avP;
    String avQ;
    int avR;
    int avS;

    static {
        CREATOR = new C1871o();
    }

    ProxyCard(int i, String str, String str2, int i2, int i3) {
        this.CK = i;
        this.avP = str;
        this.avQ = str2;
        this.avR = i2;
        this.avS = i3;
    }

    public final int describeContents() {
        return 0;
    }

    public final String getCvn() {
        return this.avQ;
    }

    public final int getExpirationMonth() {
        return this.avR;
    }

    public final int getExpirationYear() {
        return this.avS;
    }

    public final String getPan() {
        return this.avP;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1871o.m6798a(this, parcel, i);
    }
}
