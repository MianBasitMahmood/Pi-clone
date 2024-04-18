package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.AddressConstants.Extras;

public final class UserAddress implements SafeParcelable {
    public static final Creator<UserAddress> CREATOR;
    private final int CK;
    String afK;
    String afL;
    String afM;
    String afN;
    String afO;
    String afP;
    String afQ;
    String afR;
    String afS;
    String afT;
    boolean afU;
    String afV;
    String afW;
    String name;
    String vk;

    static {
        CREATOR = new C0996b();
    }

    UserAddress() {
        this.CK = 1;
    }

    UserAddress(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, boolean z, String str13, String str14) {
        this.CK = i;
        this.name = str;
        this.afK = str2;
        this.afL = str3;
        this.afM = str4;
        this.afN = str5;
        this.afO = str6;
        this.afP = str7;
        this.afQ = str8;
        this.vk = str9;
        this.afR = str10;
        this.afS = str11;
        this.afT = str12;
        this.afU = z;
        this.afV = str13;
        this.afW = str14;
    }

    public static UserAddress fromIntent(Intent intent) {
        return (intent == null || !intent.hasExtra(Extras.EXTRA_ADDRESS)) ? null : (UserAddress) intent.getParcelableExtra(Extras.EXTRA_ADDRESS);
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

    public final String getAddress4() {
        return this.afN;
    }

    public final String getAddress5() {
        return this.afO;
    }

    public final String getAdministrativeArea() {
        return this.afP;
    }

    public final String getCompanyName() {
        return this.afV;
    }

    public final String getCountryCode() {
        return this.vk;
    }

    public final String getEmailAddress() {
        return this.afW;
    }

    public final String getLocality() {
        return this.afQ;
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

    public final String getSortingCode() {
        return this.afS;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final boolean isPostBox() {
        return this.afU;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C0996b.m4107a(this, parcel, i);
    }
}
