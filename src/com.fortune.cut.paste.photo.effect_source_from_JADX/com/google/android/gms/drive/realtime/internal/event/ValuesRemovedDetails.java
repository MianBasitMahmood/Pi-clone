package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesRemovedDetails implements SafeParcelable {
    public static final Creator<ValuesRemovedDetails> CREATOR;
    final int CK;
    final int SO;
    final int SP;
    final String Tm;
    final int Tn;
    final int mIndex;

    static {
        CREATOR = new C0704i();
    }

    ValuesRemovedDetails(int i, int i2, int i3, int i4, String str, int i5) {
        this.CK = i;
        this.mIndex = i2;
        this.SO = i3;
        this.SP = i4;
        this.Tm = str;
        this.Tn = i5;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0704i.m2457a(this, parcel, i);
    }
}
