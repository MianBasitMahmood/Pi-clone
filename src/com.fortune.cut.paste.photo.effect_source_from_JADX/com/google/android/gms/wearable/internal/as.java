package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wearable.DataEvent;

public class as implements Creator<ar> {
    static void m6966a(ar arVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, arVar.CK);
        C0542b.m1962a(parcel, 2, arVar.rm(), false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return eC(parcel);
    }

    public ar eC(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    iBinder = C0541a.m1942p(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ar(i, iBinder);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public ar[] gL(int i) {
        return new ar[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gL(i);
    }
}
