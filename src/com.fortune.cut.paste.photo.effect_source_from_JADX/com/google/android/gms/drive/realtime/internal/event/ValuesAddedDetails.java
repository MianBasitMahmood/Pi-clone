package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesAddedDetails implements SafeParcelable {
    public static final Creator<ValuesAddedDetails> CREATOR;
    final int CK;
    final int SO;
    final int SP;
    final String Tk;
    final int Tl;
    final int mIndex;

    static {
        CREATOR = new C0703h();
    }

    ValuesAddedDetails(int i, int i2, int i3, int i4, String str, int i5) {
        this.CK = i;
        this.mIndex = i2;
        this.SO = i3;
        this.SP = i4;
        this.Tk = str;
        this.Tl = i5;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0703h.m2456a(this, parcel, i);
    }
}
