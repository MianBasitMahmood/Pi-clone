package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableIndexReference implements SafeParcelable {
    public static final Creator<ParcelableIndexReference> CREATOR;
    final int CK;
    final String SM;
    final boolean SN;
    final int mIndex;

    static {
        CREATOR = new C0737q();
    }

    ParcelableIndexReference(int i, String str, int i2, boolean z) {
        this.CK = i;
        this.SM = str;
        this.mIndex = i2;
        this.SN = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0737q.m2568a(this, parcel, i);
    }
}
