package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReferenceShiftedDetails implements SafeParcelable {
    public static final Creator<ReferenceShiftedDetails> CREATOR;
    final int CK;
    final String Te;
    final String Tf;
    final int Tg;
    final int Th;

    static {
        CREATOR = new C0699d();
    }

    ReferenceShiftedDetails(int i, String str, String str2, int i2, int i3) {
        this.CK = i;
        this.Te = str;
        this.Tf = str2;
        this.Tg = i2;
        this.Th = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0699d.m2452a(this, parcel, i);
    }
}
