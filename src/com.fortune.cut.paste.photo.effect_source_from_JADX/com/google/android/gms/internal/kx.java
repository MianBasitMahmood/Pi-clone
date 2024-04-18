package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.internal.kv.C1278a;
import com.google.android.gms.internal.kv.C1279b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

public class kx implements Creator<C1278a> {
    static void m5294a(C1278a c1278a, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1278a.versionCode);
        C0542b.m1968a(parcel, 2, c1278a.className, false);
        C0542b.m1981c(parcel, 3, c1278a.NY, false);
        C0542b.m1956H(parcel, H);
    }

    public C1278a m5295P(Parcel parcel) {
        ArrayList arrayList = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
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
                    arrayList = C0541a.m1928c(parcel, F, C1279b.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1278a(i, str, arrayList);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1278a[] aQ(int i) {
        return new C1278a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5295P(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return aQ(i);
    }
}
