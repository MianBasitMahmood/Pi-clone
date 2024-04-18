package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class nt implements Creator<ns> {
    static void m5680a(ns nsVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, nsVar.np());
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, nsVar.getVersionCode());
        C0542b.m1980c(parcel, 2, nsVar.ns());
        C0542b.m1964a(parcel, 3, nsVar.nt(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public ns cP(Parcel parcel) {
        int i = 0;
        int G = C0541a.m1920G(parcel);
        int i2 = -1;
        nu nuVar = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    nuVar = (nu) C0541a.m1922a(parcel, F, nu.CREATOR);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ns(i3, i, i2, nuVar);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cP(parcel);
    }

    public ns[] eL(int i) {
        return new ns[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eL(i);
    }
}
