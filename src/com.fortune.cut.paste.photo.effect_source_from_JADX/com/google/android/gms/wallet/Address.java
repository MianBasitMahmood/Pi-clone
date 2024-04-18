package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public final class Address implements SafeParcelable {
    public static final Creator<Address> CREATOR;
    private final int CK;
    String afK;
    String afL;
    String afM;
    String afR;
    String afT;
    boolean afU;
    String afV;
    String auD;
    String auE;
    String name;
    String vk;

    static {
        CREATOR = new C1844a();
    }

    Address() {
        this.CK = 1;
    }

    Address(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, String str10) {
        this.CK = i;
        this.name = str;
        this.afK = str2;
        this.afL = str3;
        this.afM = str4;
        this.vk = str5;
        this.auD = str6;
        this.auE = str7;
        this.afR = str8;
        this.afT = str9;
        this.afU = z;
        this.afV = str10;
    }

    public final int describeContents() {
        return 0;
    }

    public final String getAddress1() {
        return this.afK;
    }

    public final String getAddress2() {
        return this.afL;
    }

    public final String getAddress3() {
        return this.afM;
    }

    public final String getCity() {
        return this.auD;
    }

    public final String getCompanyName() {
        return this.afV;
    }

    public final String getCountryCode() {
        return this.vk;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPhoneNumber() {
        return this.afT;
    }

    public final String getPostalCode() {
        return this.afR;
    }

    public final String getState() {
        return this.auE;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final boolean isPostBox() {
        return this.afU;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1844a.m6710a(this, parcel, i);
    }
}
