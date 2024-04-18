package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AddEventListenerRequest implements SafeParcelable {
    public static final Creator<AddEventListenerRequest> CREATOR;
    final int CK;
    final DriveId Oj;
    final int Pm;

    static {
        CREATOR = new C0567a();
    }

    AddEventListenerRequest(int i, DriveId driveId, int i2) {
        this.CK = i;
        this.Oj = driveId;
        this.Pm = i2;
    }

    public AddEventListenerRequest(DriveId driveId, int i) {
        this(1, driveId, i);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0567a.m2032a(this, parcel, i);
    }
}
