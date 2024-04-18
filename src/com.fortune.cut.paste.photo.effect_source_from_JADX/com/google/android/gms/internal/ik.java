package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wearable.DataEvent;

public class ik implements Creator<ij> {
    static void m4975a(ij ijVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, ijVar.getVersionCode());
        C0542b.m1968a(parcel, 2, ijVar.fT(), false);
        C0542b.m1956H(parcel, H);
    }

    public ij[] ac(int i) {
        return new ij[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4976x(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return ac(i);
    }

    public ij m4976x(Parcel parcel) {
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
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ij(i, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }
}
