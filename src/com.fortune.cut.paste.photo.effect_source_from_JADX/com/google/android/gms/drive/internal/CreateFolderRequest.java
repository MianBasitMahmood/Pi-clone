package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.jx;

public class CreateFolderRequest implements SafeParcelable {
    public static final Creator<CreateFolderRequest> CREATOR;
    final int CK;
    final MetadataBundle Px;
    final DriveId Pz;

    static {
        CREATOR = new C0587l();
    }

    CreateFolderRequest(int i, DriveId driveId, MetadataBundle metadataBundle) {
        this.CK = i;
        this.Pz = (DriveId) jx.m5223i(driveId);
        this.Px = (MetadataBundle) jx.m5223i(metadataBundle);
    }

    public CreateFolderRequest(DriveId driveId, MetadataBundle metadataBundle) {
        this(1, driveId, metadataBundle);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0587l.m2208a(this, parcel, i);
    }
}
