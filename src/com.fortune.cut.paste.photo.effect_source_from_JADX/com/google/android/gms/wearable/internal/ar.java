package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ae.C1897a;

public class ar implements SafeParcelable {
    public static final Creator<ar> CREATOR;
    final int CK;
    public final ae axv;

    static {
        CREATOR = new as();
    }

    ar(int i, IBinder iBinder) {
        this.CK = i;
        if (iBinder != null) {
            this.axv = C1897a.bY(iBinder);
        } else {
            this.axv = null;
        }
    }

    public ar(ae aeVar) {
        this.CK = 1;
        this.axv = aeVar;
    }

    public int describeContents() {
        return 0;
    }

    IBinder rm() {
        return this.axv == null ? null : this.axv.asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        as.m6966a(this, parcel, i);
    }
}
