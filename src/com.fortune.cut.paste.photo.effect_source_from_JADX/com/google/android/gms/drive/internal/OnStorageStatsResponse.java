package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.StorageStats;

public class OnStorageStatsResponse implements SafeParcelable {
    public static final Creator<OnStorageStatsResponse> CREATOR;
    final int CK;
    StorageStats QS;

    static {
        CREATOR = new aw();
    }

    OnStorageStatsResponse(int i, StorageStats storageStats) {
        this.CK = i;
        this.QS = storageStats;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        aw.m2170a(this, parcel, i);
    }
}
