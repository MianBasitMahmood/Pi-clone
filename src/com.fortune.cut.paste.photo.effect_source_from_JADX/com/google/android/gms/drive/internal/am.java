package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wearable.DataEvent;

public class am implements Creator<OnDeviceUsagePreferenceResponse> {
    static void m2160a(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, onDeviceUsagePreferenceResponse.CK);
        C0542b.m1964a(parcel, 2, onDeviceUsagePreferenceResponse.QK, i, false);
        C0542b.m1956H(parcel, H);
    }

    public OnDeviceUsagePreferenceResponse ar(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        FileUploadPreferencesImpl fileUploadPreferencesImpl = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    fileUploadPreferencesImpl = (FileUploadPreferencesImpl) C0541a.m1922a(parcel, F, FileUploadPreferencesImpl.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OnDeviceUsagePreferenceResponse(i, fileUploadPreferencesImpl);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public OnDeviceUsagePreferenceResponse[] bG(int i) {
        return new OnDeviceUsagePreferenceResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ar(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bG(i);
    }
}
