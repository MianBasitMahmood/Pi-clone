package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnSyncMoreResponse implements SafeParcelable {
    public static final Creator<OnSyncMoreResponse> CREATOR;
    final int CK;
    final boolean PJ;

    static {
        CREATOR = new ax();
    }

    OnSyncMoreResponse(int i, boolean z) {
        this.CK = i;
        this.PJ = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ax.m2171a(this, parcel, i);
    }
}
