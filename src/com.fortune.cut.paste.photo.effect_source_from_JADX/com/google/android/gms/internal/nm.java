package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

public class nm implements Creator<nl> {
    static void m5674a(nl nlVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, nlVar.We, i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, nlVar.getVersionCode());
        C0542b.m1971a(parcel, 2, nlVar.ahh);
        C0542b.m1971a(parcel, 3, nlVar.ahi);
        C0542b.m1971a(parcel, 4, nlVar.ahj);
        C0542b.m1981c(parcel, 5, nlVar.ahk, false);
        C0542b.m1968a(parcel, 6, nlVar.mTag, false);
        C0542b.m1956H(parcel, H);
    }

    public nl cM(Parcel parcel) {
        String str = null;
        boolean z = true;
        boolean z2 = false;
        int G = C0541a.m1920G(parcel);
        List list = nl.ahg;
        boolean z3 = true;
        LocationRequest locationRequest = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    locationRequest = (LocationRequest) C0541a.m1922a(parcel, F, LocationRequest.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    z2 = C0541a.m1929c(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    z3 = C0541a.m1929c(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    list = C0541a.m1928c(parcel, F, nd.CREATOR);
                    break;
                case Error.OTHER /*6*/:
                    str = C0541a.m1941o(parcel, F);
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
            return new nl(i, locationRequest, z2, z3, z, list, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cM(parcel);
    }

    public nl[] eG(int i) {
        return new nl[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eG(i);
    }
}
