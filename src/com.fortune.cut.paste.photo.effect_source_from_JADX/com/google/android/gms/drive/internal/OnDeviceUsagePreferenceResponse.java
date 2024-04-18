package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDeviceUsagePreferenceResponse implements SafeParcelable {
    public static final Creator<OnDeviceUsagePreferenceResponse> CREATOR;
    final int CK;
    final FileUploadPreferencesImpl QK;

    static {
        CREATOR = new am();
    }

    OnDeviceUsagePreferenceResponse(int i, FileUploadPreferencesImpl fileUploadPreferencesImpl) {
        this.CK = i;
        this.QK = fileUploadPreferencesImpl;
    }

    public int describeContents() {
        return 0;
    }

    public FileUploadPreferencesImpl iN() {
        return this.QK;
    }

    public void writeToParcel(Parcel parcel, int i) {
        am.m2160a(this, parcel, i);
    }
}
