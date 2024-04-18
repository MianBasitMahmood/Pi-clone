package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.internal.ko.C1275a;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

public class kp implements Creator<ko> {
    static void m5265a(ko koVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, koVar.getVersionCode());
        C0542b.m1981c(parcel, 2, koVar.hH(), false);
        C0542b.m1956H(parcel, H);
    }

    public ko m5266K(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    arrayList = C0541a.m1928c(parcel, F, C1275a.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ko(i, arrayList);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public ko[] aL(int i) {
        return new ko[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5266K(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return aL(i);
    }
}
