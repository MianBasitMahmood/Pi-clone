package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wearable.DataEvent;

public class be implements Creator<SetFileUploadPreferencesRequest> {
    static void m2194a(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, setFileUploadPreferencesRequest.CK);
        C0542b.m1964a(parcel, 2, setFileUploadPreferencesRequest.QK, i, false);
        C0542b.m1956H(parcel, H);
    }

    public SetFileUploadPreferencesRequest aI(Parcel parcel) {
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
            return new SetFileUploadPreferencesRequest(i, fileUploadPreferencesImpl);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public SetFileUploadPreferencesRequest[] bX(int i) {
        return new SetFileUploadPreferencesRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return aI(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bX(i);
    }
}
