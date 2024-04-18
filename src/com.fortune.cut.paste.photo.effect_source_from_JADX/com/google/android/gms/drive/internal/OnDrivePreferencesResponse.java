package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

public class OnDrivePreferencesResponse implements SafeParcelable {
    public static final Creator<OnDrivePreferencesResponse> CREATOR;
    final int CK;
    DrivePreferences QN;

    static {
        CREATOR = new ap();
    }

    OnDrivePreferencesResponse(int i, DrivePreferences drivePreferences) {
        this.CK = i;
        this.QN = drivePreferences;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ap.m2163a(this, parcel, i);
    }
}
