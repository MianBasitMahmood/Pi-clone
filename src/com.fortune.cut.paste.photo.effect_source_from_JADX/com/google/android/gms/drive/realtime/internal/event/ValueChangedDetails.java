package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValueChangedDetails implements SafeParcelable {
    public static final Creator<ValueChangedDetails> CREATOR;
    final int CK;
    final int Tj;

    static {
        CREATOR = new C0702g();
    }

    ValueChangedDetails(int i, int i2) {
        this.CK = i;
        this.Tj = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0702g.m2455a(this, parcel, i);
    }
}
