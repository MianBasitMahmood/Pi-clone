package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.C1901c;

/* renamed from: com.google.android.gms.wearable.internal.t */
public class C1967t implements SafeParcelable {
    public static final Creator<C1967t> CREATOR;
    public final C1901c[] axK;
    public final int statusCode;
    public final int versionCode;

    static {
        CREATOR = new C1968u();
    }

    C1967t(int i, int i2, C1901c[] c1901cArr) {
        this.versionCode = i;
        this.statusCode = i2;
        this.axK = c1901cArr;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1968u.m7040a(this, parcel, i);
    }
}
