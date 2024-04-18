package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable {
    public static final Creator<CloseContentsAndUpdateMetadataRequest> CREATOR;
    final int CK;
    final String Oy;
    final boolean Oz;
    final DriveId Pp;
    final MetadataBundle Pq;
    final Contents Pr;
    final int Ps;

    static {
        CREATOR = new C0581f();
    }

    CloseContentsAndUpdateMetadataRequest(int i, DriveId driveId, MetadataBundle metadataBundle, Contents contents, boolean z, String str, int i2) {
        this.CK = i;
        this.Pp = driveId;
        this.Pq = metadataBundle;
        this.Pr = contents;
        this.Oz = z;
        this.Oy = str;
        this.Ps = i2;
    }

    public CloseContentsAndUpdateMetadataRequest(DriveId driveId, MetadataBundle metadataBundle, Contents contents, ExecutionOptions executionOptions) {
        this(1, driveId, metadataBundle, contents, executionOptions.iw(), executionOptions.iv(), executionOptions.ix());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0581f.m2201a(this, parcel, i);
    }
}
