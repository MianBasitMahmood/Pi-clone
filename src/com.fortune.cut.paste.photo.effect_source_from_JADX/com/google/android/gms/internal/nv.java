package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

public class nv implements Creator<nu> {
    static void m5682a(nu nuVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1981c(parcel, 1, nuVar.ahn, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, nuVar.CK);
        C0542b.m1968a(parcel, 2, nuVar.nu(), false);
        C0542b.m1971a(parcel, 3, nuVar.nv());
        C0542b.m1981c(parcel, 4, nuVar.aht, false);
        C0542b.m1979b(parcel, 6, nuVar.ahu, false);
        C0542b.m1956H(parcel, H);
    }

    public nu cQ(Parcel parcel) {
        boolean z = false;
        List list = null;
        int G = C0541a.m1920G(parcel);
        List list2 = null;
        String str = null;
        List list3 = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    list3 = C0541a.m1928c(parcel, F, oa.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    list2 = C0541a.m1928c(parcel, F, oe.CREATOR);
                    break;
                case Error.OTHER /*6*/:
                    list = C0541a.m1916C(parcel, F);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new nu(i, list3, str, z, list2, list);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cQ(parcel);
    }

    public nu[] eM(int i) {
        return new nu[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eM(i);
    }
}
