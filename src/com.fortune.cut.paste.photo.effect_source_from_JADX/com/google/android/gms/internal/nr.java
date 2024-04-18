package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

public class nr implements Creator<nq> {
    static void m5679a(nq nqVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1971a(parcel, 1, nqVar.nr());
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, nqVar.CK);
        C0542b.m1981c(parcel, 2, nqVar.ahn, false);
        C0542b.m1956H(parcel, H);
    }

    public nq cO(Parcel parcel) {
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    list = C0541a.m1928c(parcel, F, oa.CREATOR);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new nq(i, z, list);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cO(parcel);
    }

    public nq[] eK(int i) {
        return new nq[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eK(i);
    }
}
