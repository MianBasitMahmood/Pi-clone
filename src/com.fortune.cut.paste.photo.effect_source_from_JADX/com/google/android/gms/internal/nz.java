package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class nz implements Creator<ny> {
    static void m5684a(ny nyVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, nyVar.CK);
        C0542b.m1964a(parcel, 2, nyVar.nt(), i, false);
        C0542b.m1960a(parcel, 3, nyVar.getInterval());
        C0542b.m1980c(parcel, 4, nyVar.getPriority());
        C0542b.m1956H(parcel, H);
    }

    public ny cS(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        nu nuVar = null;
        long j = ny.ahz;
        int i2 = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_DELETED /*2*/:
                    nuVar = (nu) C0541a.m1922a(parcel, F, nu.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i2 = C0541a.m1933g(parcel, F);
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
            return new ny(i, nuVar, j, i2);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cS(parcel);
    }

    public ny[] eO(int i) {
        return new ny[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eO(i);
    }
}
