package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class GetMetadataRequest implements SafeParcelable {
    public static final Creator<GetMetadataRequest> CREATOR;
    final int CK;
    final DriveId Pp;

    static {
        CREATOR = new ad();
    }

    GetMetadataRequest(int i, DriveId driveId) {
        this.CK = i;
        this.Pp = driveId;
    }

    public GetMetadataRequest(DriveId driveId) {
        this(1, driveId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ad.m2038a(this, parcel, i);
    }
}
