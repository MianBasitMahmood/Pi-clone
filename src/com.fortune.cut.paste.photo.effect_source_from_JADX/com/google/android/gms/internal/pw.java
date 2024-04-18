package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class pw implements SafeParcelable {
    public static final Creator<pw> CREATOR;
    private final int CK;
    int[] avX;

    static {
        CREATOR = new px();
    }

    pw() {
        this(1, null);
    }

    pw(int i, int[] iArr) {
        this.CK = i;
        this.avX = iArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        px.m5814a(this, parcel, i);
    }
}
