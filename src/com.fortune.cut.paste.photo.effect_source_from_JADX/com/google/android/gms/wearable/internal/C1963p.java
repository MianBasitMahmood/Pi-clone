package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wearable.internal.p */
public class C1963p implements SafeParcelable {
    public static final Creator<C1963p> CREATOR;
    public final int axI;
    public final int statusCode;
    public final int versionCode;

    static {
        CREATOR = new C1964q();
    }

    C1963p(int i, int i2, int i3) {
        this.versionCode = i;
        this.statusCode = i2;
        this.axI = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1964q.m7038a(this, parcel, i);
    }
}
