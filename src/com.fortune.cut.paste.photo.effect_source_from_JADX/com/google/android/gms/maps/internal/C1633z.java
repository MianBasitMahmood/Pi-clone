package com.google.android.gms.maps.internal;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.internal.z */
public class C1633z implements Creator<C1632y> {
    static void m6179a(C1632y c1632y, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1632y.getVersionCode());
        C0542b.m1964a(parcel, 2, c1632y.oa(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public C1632y cZ(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        Point point = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    point = (Point) C0541a.m1922a(parcel, F, Point.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1632y(i, point);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cZ(parcel);
    }

    public C1632y[] eV(int i) {
        return new C1632y[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eV(i);
    }
}
