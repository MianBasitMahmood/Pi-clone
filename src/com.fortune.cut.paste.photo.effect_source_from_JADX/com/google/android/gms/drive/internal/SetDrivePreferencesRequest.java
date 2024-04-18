package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

public class SetDrivePreferencesRequest implements SafeParcelable {
    public static final Creator<SetDrivePreferencesRequest> CREATOR;
    final int CK;
    final DrivePreferences QN;

    static {
        CREATOR = new bd();
    }

    SetDrivePreferencesRequest(int i, DrivePreferences drivePreferences) {
        this.CK = i;
        this.QN = drivePreferences;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        bd.m2193a(this, parcel, i);
    }
}
