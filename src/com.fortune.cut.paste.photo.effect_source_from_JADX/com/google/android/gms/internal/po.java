package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.internal.pi.C1440c;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.Set;

public class po implements Creator<C1440c> {
    static void m5804a(C1440c c1440c, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        Set set = c1440c.aon;
        if (set.contains(Integer.valueOf(1))) {
            C0542b.m1980c(parcel, 1, c1440c.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            C0542b.m1968a(parcel, 2, c1440c.vf, true);
        }
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dE(parcel);
    }

    public C1440c dE(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1440c(hashSet, i, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1440c[] fC(int i) {
        return new C1440c[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fC(i);
    }
}
