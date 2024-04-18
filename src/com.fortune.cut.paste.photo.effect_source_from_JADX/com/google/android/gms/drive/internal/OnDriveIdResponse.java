package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OnDriveIdResponse implements SafeParcelable {
    public static final Creator<OnDriveIdResponse> CREATOR;
    final int CK;
    DriveId Pp;

    static {
        CREATOR = new ao();
    }

    OnDriveIdResponse(int i, DriveId driveId) {
        this.CK = i;
        this.Pp = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.Pp;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ao.m2162a(this, parcel, i);
    }
}
