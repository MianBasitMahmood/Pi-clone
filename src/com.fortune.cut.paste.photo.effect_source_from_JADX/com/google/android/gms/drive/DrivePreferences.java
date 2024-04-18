package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DrivePreferences implements SafeParcelable {
    public static final Creator<DrivePreferences> CREATOR;
    final int CK;
    final boolean Ox;

    static {
        CREATOR = new C0553d();
    }

    DrivePreferences(int i, boolean z) {
        this.CK = i;
        this.Ox = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0553d.m2005a(this, parcel, i);
    }
}
