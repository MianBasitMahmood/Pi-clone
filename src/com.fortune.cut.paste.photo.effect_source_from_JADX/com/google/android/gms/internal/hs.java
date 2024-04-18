package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class hs implements Creator<hr> {
    static void m4866a(hr hrVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, hrVar.Dw, i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, hrVar.CK);
        C0542b.m1960a(parcel, 2, hrVar.Dx);
        C0542b.m1980c(parcel, 3, hrVar.Dy);
        C0542b.m1968a(parcel, 4, hrVar.pc, false);
        C0542b.m1964a(parcel, 5, hrVar.Dz, i, false);
        C0542b.m1956H(parcel, H);
    }

    public hr[] m4867S(int i) {
        return new hr[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4868s(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4867S(i);
    }

    public hr m4868s(Parcel parcel) {
        int i = 0;
        hd hdVar = null;
        int G = C0541a.m1920G(parcel);
        long j = 0;
        String str = null;
        hf hfVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    hfVar = (hf) C0541a.m1922a(parcel, F, hf.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    hdVar = (hd) C0541a.m1922a(parcel, F, hd.CREATOR);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new hr(i2, hfVar, j, i, str, hdVar);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }
}
