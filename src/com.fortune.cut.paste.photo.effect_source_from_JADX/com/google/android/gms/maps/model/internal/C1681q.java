package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.model.internal.q */
public class C1681q implements Creator<C1680p> {
    static void m6232a(C1680p c1680p, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1680p.getVersionCode());
        C0542b.m1964a(parcel, 2, c1680p.ol(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ds(parcel);
    }

    public C1680p ds(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        C1649a c1649a = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    c1649a = (C1649a) C0541a.m1922a(parcel, F, C1649a.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1680p(i, c1649a);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1680p[] fp(int i) {
        return new C1680p[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fp(i);
    }
}
