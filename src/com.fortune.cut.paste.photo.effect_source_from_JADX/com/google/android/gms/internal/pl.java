package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.internal.pi.C1439b;
import com.google.android.gms.internal.pi.C1439b.C1437a;
import com.google.android.gms.internal.pi.C1439b.C1438b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.Set;

public class pl implements Creator<C1439b> {
    static void m5801a(C1439b c1439b, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        Set set = c1439b.aon;
        if (set.contains(Integer.valueOf(1))) {
            C0542b.m1980c(parcel, 1, c1439b.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            C0542b.m1964a(parcel, 2, c1439b.apG, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            C0542b.m1964a(parcel, 3, c1439b.apH, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            C0542b.m1980c(parcel, 4, c1439b.apI);
        }
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dB(parcel);
    }

    public C1439b dB(Parcel parcel) {
        C1438b c1438b = null;
        int i = 0;
        int G = C0541a.m1920G(parcel);
        Set hashSet = new HashSet();
        C1437a c1437a = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    C1437a c1437a2 = (C1437a) C0541a.m1922a(parcel, F, C1437a.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    c1437a = c1437a2;
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    C1438b c1438b2 = (C1438b) C0541a.m1922a(parcel, F, C1438b.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c1438b = c1438b2;
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1439b(hashSet, i2, c1437a, c1438b, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1439b[] fz(int i) {
        return new C1439b[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fz(i);
    }
}
