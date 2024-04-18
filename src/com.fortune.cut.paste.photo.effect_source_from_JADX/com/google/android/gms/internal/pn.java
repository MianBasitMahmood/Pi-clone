package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.internal.pi.C1439b.C1438b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.Set;

public class pn implements Creator<C1438b> {
    static void m5803a(C1438b c1438b, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        Set set = c1438b.aon;
        if (set.contains(Integer.valueOf(1))) {
            C0542b.m1980c(parcel, 1, c1438b.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            C0542b.m1980c(parcel, 2, c1438b.lj);
        }
        if (set.contains(Integer.valueOf(3))) {
            C0542b.m1968a(parcel, 3, c1438b.vf, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            C0542b.m1980c(parcel, 4, c1438b.li);
        }
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dD(parcel);
    }

    public C1438b dD(Parcel parcel) {
        int i = 0;
        int G = C0541a.m1920G(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i2 = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(3));
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
            return new C1438b(hashSet, i3, i2, str, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1438b[] fB(int i) {
        return new C1438b[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fB(i);
    }
}
