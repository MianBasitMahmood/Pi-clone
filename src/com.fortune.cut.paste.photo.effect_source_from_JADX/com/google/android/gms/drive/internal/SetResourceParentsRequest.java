package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class SetResourceParentsRequest implements SafeParcelable {
    public static final Creator<SetResourceParentsRequest> CREATOR;
    final int CK;
    final DriveId QW;
    final List<DriveId> QX;

    static {
        CREATOR = new bf();
    }

    SetResourceParentsRequest(int i, DriveId driveId, List<DriveId> list) {
        this.CK = i;
        this.QW = driveId;
        this.QX = list;
    }

    public SetResourceParentsRequest(DriveId driveId, List<DriveId> list) {
        this(1, driveId, list);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        bf.m2195a(this, parcel, i);
    }
}
