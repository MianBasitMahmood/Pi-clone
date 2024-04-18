package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.jx;

public class CreateFileRequest implements SafeParcelable {
    public static final Creator<CreateFileRequest> CREATOR;
    final int CK;
    final String Oy;
    final boolean PA;
    final int PB;
    final int PC;
    final Contents Pr;
    final MetadataBundle Px;
    final Integer Py;
    final DriveId Pz;

    static {
        CREATOR = new C0586k();
    }

    CreateFileRequest(int i, DriveId driveId, MetadataBundle metadataBundle, Contents contents, Integer num, boolean z, String str, int i2, int i3) {
        if (!(contents == null || i3 == 0)) {
            jx.m5221b(contents.getRequestId() == i3, (Object) "inconsistent contents reference");
        }
        if ((num == null || num.intValue() == 0) && contents == null && i3 == 0) {
            throw new IllegalArgumentException("Need a valid contents");
        }
        this.CK = i;
        this.Pz = (DriveId) jx.m5223i(driveId);
        this.Px = (MetadataBundle) jx.m5223i(metadataBundle);
        this.Pr = contents;
        this.Py = num;
        this.Oy = str;
        this.PB = i2;
        this.PA = z;
        this.PC = i3;
    }

    public CreateFileRequest(DriveId driveId, MetadataBundle metadataBundle, int i, int i2, ExecutionOptions executionOptions) {
        this(2, driveId, metadataBundle, null, Integer.valueOf(i2), executionOptions.iw(), executionOptions.iv(), executionOptions.ix(), i);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0586k.m2207a(this, parcel, i);
    }
}
