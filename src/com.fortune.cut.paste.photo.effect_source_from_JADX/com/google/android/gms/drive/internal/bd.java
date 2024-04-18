package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.drive.DrivePreferences;
import com.google.android.gms.wearable.DataEvent;

public class bd implements Creator<SetDrivePreferencesRequest> {
    static void m2193a(SetDrivePreferencesRequest setDrivePreferencesRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, setDrivePreferencesRequest.CK);
        C0542b.m1964a(parcel, 2, setDrivePreferencesRequest.QN, i, false);
        C0542b.m1956H(parcel, H);
    }

    public SetDrivePreferencesRequest aH(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        DrivePreferences drivePreferences = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    drivePreferences = (DrivePreferences) C0541a.m1922a(parcel, F, DrivePreferences.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new SetDrivePreferencesRequest(i, drivePreferences);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public SetDrivePreferencesRequest[] bW(int i) {
        return new SetDrivePreferencesRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return aH(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bW(i);
    }
}
