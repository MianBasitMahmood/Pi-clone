package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.wearable.DataEvent;

public final class FileUploadPreferencesImpl implements SafeParcelable, FileUploadPreferences {
    public static final Creator<FileUploadPreferencesImpl> CREATOR;
    final int CK;
    int QA;
    boolean QB;
    int Qz;

    static {
        CREATOR = new ab();
    }

    FileUploadPreferencesImpl(int i, int i2, int i3, boolean z) {
        this.CK = i;
        this.Qz = i2;
        this.QA = i3;
        this.QB = z;
    }

    public static boolean by(int i) {
        switch (i) {
            case DataEvent.TYPE_CHANGED /*1*/:
            case DataEvent.TYPE_DELETED /*2*/:
                return true;
            default:
                return false;
        }
    }

    public static boolean bz(int i) {
        switch (i) {
            case FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED /*256*/:
            case FileUploadPreferences.BATTERY_USAGE_CHARGING_ONLY /*257*/:
                return true;
            default:
                return false;
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final int getBatteryUsagePreference() {
        return !bz(this.QA) ? 0 : this.QA;
    }

    public final int getNetworkTypePreference() {
        return !by(this.Qz) ? 0 : this.Qz;
    }

    public final boolean isRoamingAllowed() {
        return this.QB;
    }

    public final void setBatteryUsagePreference(int i) {
        if (bz(i)) {
            this.QA = i;
            return;
        }
        throw new IllegalArgumentException("Invalid battery usage preference value.");
    }

    public final void setNetworkTypePreference(int i) {
        if (by(i)) {
            this.Qz = i;
            return;
        }
        throw new IllegalArgumentException("Invalid data connection preference value.");
    }

    public final void setRoamingAllowed(boolean z) {
        this.QB = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ab.m2036a(this, parcel, i);
    }
}
