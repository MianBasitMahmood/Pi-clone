package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ey
public final class gs implements SafeParcelable {
    public static final gt CREATOR;
    public final int versionCode;
    public String wS;
    public int wT;
    public int wU;
    public boolean wV;

    static {
        CREATOR = new gt();
    }

    public gs(int i, int i2, boolean z) {
        this(1, "afma-sdk-a-v" + i + "." + i2 + "." + (z ? "0" : "1"), i, i2, z);
    }

    gs(int i, String str, int i2, int i3, boolean z) {
        this.versionCode = i;
        this.wS = str;
        this.wT = i2;
        this.wU = i3;
        this.wV = z;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        gt.m4779a(this, parcel, i);
    }
}
