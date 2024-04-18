package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class RemoveEventListenerRequest implements SafeParcelable {
    public static final Creator<RemoveEventListenerRequest> CREATOR;
    final int CK;
    final DriveId Oj;
    final int Pm;

    static {
        CREATOR = new bc();
    }

    RemoveEventListenerRequest(int i, DriveId driveId, int i2) {
        this.CK = i;
        this.Oj = driveId;
        this.Pm = i2;
    }

    public RemoveEventListenerRequest(DriveId driveId, int i) {
        this(1, driveId, i);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        bc.m2192a(this, parcel, i);
    }
}
