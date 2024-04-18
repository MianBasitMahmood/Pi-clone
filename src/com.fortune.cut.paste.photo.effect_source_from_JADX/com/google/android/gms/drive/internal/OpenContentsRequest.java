package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenContentsRequest implements SafeParcelable {
    public static final Creator<OpenContentsRequest> CREATOR;
    final int CK;
    final int Oi;
    final DriveId Pp;
    final int QT;

    static {
        CREATOR = new ay();
    }

    OpenContentsRequest(int i, DriveId driveId, int i2, int i3) {
        this.CK = i;
        this.Pp = driveId;
        this.Oi = i2;
        this.QT = i3;
    }

    public OpenContentsRequest(DriveId driveId, int i, int i2) {
        this(1, driveId, i, i2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ay.m2172a(this, parcel, i);
    }
}
