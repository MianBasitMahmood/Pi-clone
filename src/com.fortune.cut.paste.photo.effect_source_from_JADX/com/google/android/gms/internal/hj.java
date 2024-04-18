package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hj implements SafeParcelable {
    public static final hk CREATOR;
    final int CK;
    final Bundle Db;
    public final int id;

    static {
        CREATOR = new hk();
    }

    hj(int i, int i2, Bundle bundle) {
        this.CK = i;
        this.id = i2;
        this.Db = bundle;
    }

    public int describeContents() {
        hk hkVar = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        hk hkVar = CREATOR;
        hk.m4843a(this, parcel, i);
    }
}
