package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wearable.DataEvent;

public class px implements Creator<pw> {
    static void m5814a(pw pwVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, pwVar.getVersionCode());
        C0542b.m1973a(parcel, 2, pwVar.avX, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dX(parcel);
    }

    public pw dX(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    iArr = C0541a.m1947u(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new pw(i, iArr);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public pw[] ge(int i) {
        return new pw[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return ge(i);
    }
}
