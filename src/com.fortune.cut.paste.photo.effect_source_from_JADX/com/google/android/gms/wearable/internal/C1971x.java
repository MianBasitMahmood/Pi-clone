package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wearable.internal.x */
public class C1971x implements SafeParcelable {
    public static final Creator<C1971x> CREATOR;
    public final C1960m axM;
    public final int statusCode;
    public final int versionCode;

    static {
        CREATOR = new C1972y();
    }

    C1971x(int i, int i2, C1960m c1960m) {
        this.versionCode = i;
        this.statusCode = i2;
        this.axM = c1960m;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1972y.m7042a(this, parcel, i);
    }
}
