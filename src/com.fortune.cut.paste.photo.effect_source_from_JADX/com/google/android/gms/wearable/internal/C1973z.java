package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wearable.internal.z */
public class C1973z implements SafeParcelable {
    public static final Creator<C1973z> CREATOR;
    public final ParcelFileDescriptor axN;
    public final int statusCode;
    public final int versionCode;

    static {
        CREATOR = new aa();
    }

    C1973z(int i, int i2, ParcelFileDescriptor parcelFileDescriptor) {
        this.versionCode = i;
        this.statusCode = i2;
        this.axN = parcelFileDescriptor;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        aa.m6859a(this, parcel, i | 1);
    }
}
