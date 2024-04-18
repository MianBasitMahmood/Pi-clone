package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenFileIntentSenderRequest implements SafeParcelable {
    public static final Creator<OpenFileIntentSenderRequest> CREATOR;
    final int CK;
    final String OH;
    final String[] OI;
    final DriveId OJ;

    static {
        CREATOR = new ba();
    }

    OpenFileIntentSenderRequest(int i, String str, String[] strArr, DriveId driveId) {
        this.CK = i;
        this.OH = str;
        this.OI = strArr;
        this.OJ = driveId;
    }

    public OpenFileIntentSenderRequest(String str, String[] strArr, DriveId driveId) {
        this(1, str, strArr, driveId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ba.m2190a(this, parcel, i);
    }
}
