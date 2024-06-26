package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class ListParentsRequest implements SafeParcelable {
    public static final Creator<ListParentsRequest> CREATOR;
    final int CK;
    final DriveId QE;

    static {
        CREATOR = new ai();
    }

    ListParentsRequest(int i, DriveId driveId) {
        this.CK = i;
        this.QE = driveId;
    }

    public ListParentsRequest(DriveId driveId) {
        this(1, driveId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ai.m2140a(this, parcel, i);
    }
}
