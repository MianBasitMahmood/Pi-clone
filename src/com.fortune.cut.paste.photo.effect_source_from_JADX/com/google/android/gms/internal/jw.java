package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.internal.jg.C1244a;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

public class jw implements Creator<C1244a> {
    static void m5213a(C1244a c1244a, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, c1244a.getAccountName(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, c1244a.getVersionCode());
        C0542b.m1979b(parcel, 2, c1244a.ho(), false);
        C0542b.m1980c(parcel, 3, c1244a.hn());
        C0542b.m1968a(parcel, 4, c1244a.hq(), false);
        C0542b.m1956H(parcel, H);
    }

    public C1244a m5214E(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = C0541a.m1920G(parcel);
        List list = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    list = C0541a.m1916C(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str = C0541a.m1941o(parcel, F);
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
            return new C1244a(i2, str2, list, i, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1244a[] aG(int i) {
        return new C1244a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5214E(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return aG(i);
    }
}
