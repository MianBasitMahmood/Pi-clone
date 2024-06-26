package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnLoadRealtimeResponse implements SafeParcelable {
    public static final Creator<OnLoadRealtimeResponse> CREATOR;
    final int CK;
    final boolean wg;

    static {
        CREATOR = new au();
    }

    OnLoadRealtimeResponse(int i, boolean z) {
        this.CK = i;
        this.wg = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        au.m2168a(this, parcel, i);
    }
}
