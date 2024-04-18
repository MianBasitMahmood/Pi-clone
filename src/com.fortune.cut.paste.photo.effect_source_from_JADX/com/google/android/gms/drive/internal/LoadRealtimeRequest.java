package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class LoadRealtimeRequest implements SafeParcelable {
    public static final Creator<LoadRealtimeRequest> CREATOR;
    final int CK;
    final DriveId Oj;
    final boolean QF;

    static {
        CREATOR = new aj();
    }

    LoadRealtimeRequest(int i, DriveId driveId, boolean z) {
        this.CK = i;
        this.Oj = driveId;
        this.QF = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        aj.m2141a(this, parcel, i);
    }
}
