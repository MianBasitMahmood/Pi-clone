package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AuthorizeAccessRequest implements SafeParcelable {
    public static final Creator<AuthorizeAccessRequest> CREATOR;
    final int CK;
    final DriveId Oj;
    final long Pn;

    static {
        CREATOR = new C0578b();
    }

    AuthorizeAccessRequest(int i, long j, DriveId driveId) {
        this.CK = i;
        this.Pn = j;
        this.Oj = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0578b.m2189a(this, parcel, i);
    }
}
