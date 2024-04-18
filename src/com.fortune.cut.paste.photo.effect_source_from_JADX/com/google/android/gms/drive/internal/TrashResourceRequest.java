package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class TrashResourceRequest implements SafeParcelable {
    public static final Creator<TrashResourceRequest> CREATOR;
    final int CK;
    final DriveId Pp;

    static {
        CREATOR = new bh();
    }

    TrashResourceRequest(int i, DriveId driveId) {
        this.CK = i;
        this.Pp = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        bh.m2197a(this, parcel, i);
    }
}
