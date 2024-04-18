package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.C1901c;

@Deprecated
/* renamed from: com.google.android.gms.wearable.internal.r */
public class C1965r implements SafeParcelable {
    public static final Creator<C1965r> CREATOR;
    public final C1901c axJ;
    public final int statusCode;
    public final int versionCode;

    static {
        CREATOR = new C1966s();
    }

    C1965r(int i, int i2, C1901c c1901c) {
        this.versionCode = i;
        this.statusCode = i2;
        this.axJ = c1901c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1966s.m7039a(this, parcel, i);
    }
}
