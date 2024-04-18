package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ObjectChangedDetails implements SafeParcelable {
    public static final Creator<ObjectChangedDetails> CREATOR;
    final int CK;
    final int SO;
    final int SP;

    static {
        CREATOR = new C0696a();
    }

    ObjectChangedDetails(int i, int i2, int i3) {
        this.CK = i;
        this.SO = i2;
        this.SP = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0696a.m2449a(this, parcel, i);
    }
}
