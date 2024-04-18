package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.internal.pi.C1444g;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.Set;

public class pr implements Creator<C1444g> {
    static void m5807a(C1444g c1444g, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        Set set = c1444g.aon;
        if (set.contains(Integer.valueOf(1))) {
            C0542b.m1980c(parcel, 1, c1444g.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            C0542b.m1971a(parcel, 2, c1444g.apR);
        }
        if (set.contains(Integer.valueOf(3))) {
            C0542b.m1968a(parcel, 3, c1444g.mValue, true);
        }
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dH(parcel);
    }

    public C1444g dH(Parcel parcel) {
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    z = C0541a.m1929c(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1444g(hashSet, i, z, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1444g[] fF(int i) {
        return new C1444g[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fF(i);
    }
}
