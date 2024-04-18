package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.if */
public class C1213if implements SafeParcelable {
    public static final ig CREATOR;
    final Bundle Ep;
    final byte[] Eq;
    final int responseCode;
    final int versionCode;

    static {
        CREATOR = new ig();
    }

    public C1213if(int i, int i2, Bundle bundle, byte[] bArr) {
        this.versionCode = i;
        this.responseCode = i2;
        this.Ep = bundle;
        this.Eq = bArr;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ig.m4967a(this, parcel, i);
    }
}
