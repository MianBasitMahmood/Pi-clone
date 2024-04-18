package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wearable.DataEvent;

public class kn implements Creator<km> {
    static void m5260a(km kmVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, kmVar.getVersionCode());
        C0542b.m1964a(parcel, 2, kmVar.hF(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public km m5261J(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        ko koVar = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    koVar = (ko) C0541a.m1922a(parcel, F, ko.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new km(i, koVar);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public km[] aK(int i) {
        return new km[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5261J(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return aK(i);
    }
}
