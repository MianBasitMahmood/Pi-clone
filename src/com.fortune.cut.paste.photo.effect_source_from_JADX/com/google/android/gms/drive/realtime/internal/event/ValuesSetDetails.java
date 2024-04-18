package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesSetDetails implements SafeParcelable {
    public static final Creator<ValuesSetDetails> CREATOR;
    final int CK;
    final int SO;
    final int SP;
    final int mIndex;

    static {
        CREATOR = new C0705j();
    }

    ValuesSetDetails(int i, int i2, int i3, int i4) {
        this.CK = i;
        this.mIndex = i2;
        this.SO = i3;
        this.SP = i4;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0705j.m2458a(this, parcel, i);
    }
}
