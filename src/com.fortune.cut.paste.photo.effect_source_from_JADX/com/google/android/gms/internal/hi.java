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

public class hi implements Creator<hh> {
    static void m4840a(hh hhVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, hhVar.CX, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, hhVar.CK);
        C0542b.m1964a(parcel, 3, hhVar.CY, i, false);
        C0542b.m1980c(parcel, 4, hhVar.CZ);
        C0542b.m1972a(parcel, 5, hhVar.Da, false);
        C0542b.m1956H(parcel, H);
    }

    public hh[] m4841L(int i) {
        return new hh[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4842n(parcel);
    }

    public hh m4842n(Parcel parcel) {
        byte[] bArr = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        int i2 = -1;
        hp hpVar = null;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    hpVar = (hp) C0541a.m1922a(parcel, F, hp.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    bArr = C0541a.m1944r(parcel, F);
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
            return new hh(i, str, hpVar, i2, bArr);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4841L(i);
    }
}
