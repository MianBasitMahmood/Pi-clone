package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetDriveIdFromUniqueIdentifierRequest implements SafeParcelable {
    public static final Creator<GetDriveIdFromUniqueIdentifierRequest> CREATOR;
    final int CK;
    final String QC;
    final boolean QD;

    static {
        CREATOR = new ac();
    }

    GetDriveIdFromUniqueIdentifierRequest(int i, String str, boolean z) {
        this.CK = i;
        this.QC = str;
        this.QD = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ac.m2037a(this, parcel, i);
    }
}
