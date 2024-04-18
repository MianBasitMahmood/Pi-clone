package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UserMetadata implements SafeParcelable {
    public static final Creator<UserMetadata> CREATOR;
    final int CK;
    final String OR;
    final String OS;
    final String OT;
    final boolean OU;
    final String OV;

    static {
        CREATOR = new C0565h();
    }

    UserMetadata(int i, String str, String str2, String str3, boolean z, String str4) {
        this.CK = i;
        this.OR = str;
        this.OS = str2;
        this.OT = str3;
        this.OU = z;
        this.OV = str4;
    }

    public UserMetadata(String str, String str2, String str3, boolean z, String str4) {
        this(1, str, str2, str3, z, str4);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", new Object[]{this.OR, this.OS, this.OT, Boolean.valueOf(this.OU), this.OV});
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0565h.m2027a(this, parcel, i);
    }
}
