package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TextDeletedDetails implements SafeParcelable {
    public static final Creator<TextDeletedDetails> CREATOR;
    final int CK;
    final int Ti;
    final int mIndex;

    static {
        CREATOR = new C0700e();
    }

    TextDeletedDetails(int i, int i2, int i3) {
        this.CK = i;
        this.mIndex = i2;
        this.Ti = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0700e.m2453a(this, parcel, i);
    }
}
