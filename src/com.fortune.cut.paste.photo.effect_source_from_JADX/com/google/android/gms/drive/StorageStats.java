package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StorageStats implements SafeParcelable {
    public static final Creator<StorageStats> CREATOR;
    final int CK;
    final long OM;
    final long ON;
    final long OO;
    final long OP;
    final int OQ;

    static {
        CREATOR = new C0564g();
    }

    StorageStats(int i, long j, long j2, long j3, long j4, int i2) {
        this.CK = i;
        this.OM = j;
        this.ON = j2;
        this.OO = j3;
        this.OP = j4;
        this.OQ = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0564g.m2025a(this, parcel, i);
    }
}
