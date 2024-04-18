package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class at implements SafeParcelable {
    public static final Creator<at> CREATOR;
    public final int ayd;
    public final int statusCode;
    public final int versionCode;

    static {
        CREATOR = new au();
    }

    at(int i, int i2, int i3) {
        this.versionCode = i;
        this.statusCode = i2;
        this.ayd = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        au.m6967a(this, parcel, i);
    }
}
