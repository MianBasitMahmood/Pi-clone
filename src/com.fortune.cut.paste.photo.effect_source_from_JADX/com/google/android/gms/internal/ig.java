package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class ig implements Creator<C1213if> {
    static void m4967a(C1213if c1213if, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1213if.responseCode);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, c1213if.versionCode);
        C0542b.m1961a(parcel, 2, c1213if.Ep, false);
        C0542b.m1972a(parcel, 3, c1213if.Eq, false);
        C0542b.m1956H(parcel, H);
    }

    public C1213if[] m4968U(int i) {
        return new C1213if[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4969t(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4968U(i);
    }

    public C1213if m4969t(Parcel parcel) {
        byte[] bArr = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        int i2 = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    bundle = C0541a.m1943q(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    bArr = C0541a.m1944r(parcel, F);
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
            return new C1213if(i2, i, bundle, bArr);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }
}
