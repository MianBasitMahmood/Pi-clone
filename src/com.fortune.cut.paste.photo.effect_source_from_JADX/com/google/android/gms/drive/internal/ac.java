package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class ac implements Creator<GetDriveIdFromUniqueIdentifierRequest> {
    static void m2037a(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, getDriveIdFromUniqueIdentifierRequest.CK);
        C0542b.m1968a(parcel, 2, getDriveIdFromUniqueIdentifierRequest.QC, false);
        C0542b.m1971a(parcel, 3, getDriveIdFromUniqueIdentifierRequest.QD);
        C0542b.m1956H(parcel, H);
    }

    public GetDriveIdFromUniqueIdentifierRequest am(Parcel parcel) {
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new GetDriveIdFromUniqueIdentifierRequest(i, str, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public GetDriveIdFromUniqueIdentifierRequest[] bB(int i) {
        return new GetDriveIdFromUniqueIdentifierRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return am(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bB(i);
    }
}
