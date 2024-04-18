package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class DeleteResourceRequest implements SafeParcelable {
    public static final Creator<DeleteResourceRequest> CREATOR;
    final int CK;
    final DriveId Pp;

    static {
        CREATOR = new C0589n();
    }

    DeleteResourceRequest(int i, DriveId driveId) {
        this.CK = i;
        this.Pp = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0589n.m2210a(this, parcel, i);
    }
}
