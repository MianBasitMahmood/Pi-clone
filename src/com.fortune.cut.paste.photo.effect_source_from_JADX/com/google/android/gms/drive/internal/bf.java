package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

public class bf implements Creator<SetResourceParentsRequest> {
    static void m2195a(SetResourceParentsRequest setResourceParentsRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, setResourceParentsRequest.CK);
        C0542b.m1964a(parcel, 2, setResourceParentsRequest.QW, i, false);
        C0542b.m1981c(parcel, 3, setResourceParentsRequest.QX, false);
        C0542b.m1956H(parcel, H);
    }

    public SetResourceParentsRequest aJ(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        DriveId driveId = null;
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    driveId = (DriveId) C0541a.m1922a(parcel, F, DriveId.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    list = C0541a.m1928c(parcel, F, DriveId.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new SetResourceParentsRequest(i, driveId, list);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public SetResourceParentsRequest[] bY(int i) {
        return new SetResourceParentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return aJ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bY(i);
    }
}
