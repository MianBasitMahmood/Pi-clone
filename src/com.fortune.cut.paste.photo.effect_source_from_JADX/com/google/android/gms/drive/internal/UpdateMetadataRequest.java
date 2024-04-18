package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class UpdateMetadataRequest implements SafeParcelable {
    public static final Creator<UpdateMetadataRequest> CREATOR;
    final int CK;
    final DriveId Pp;
    final MetadataBundle Pq;

    static {
        CREATOR = new bi();
    }

    UpdateMetadataRequest(int i, DriveId driveId, MetadataBundle metadataBundle) {
        this.CK = i;
        this.Pp = driveId;
        this.Pq = metadataBundle;
    }

    public UpdateMetadataRequest(DriveId driveId, MetadataBundle metadataBundle) {
        this(1, driveId, metadataBundle);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        bi.m2198a(this, parcel, i);
    }
}
