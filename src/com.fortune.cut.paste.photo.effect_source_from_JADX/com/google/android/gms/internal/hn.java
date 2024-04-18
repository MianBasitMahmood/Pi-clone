package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.internal.hl.C1189b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

public class hn implements Creator<C1189b> {
    static void m4849a(C1189b c1189b, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, c1189b.CK);
        C0542b.m1964a(parcel, 1, c1189b.Dd, i, false);
        C0542b.m1981c(parcel, 2, c1189b.De, false);
        C0542b.m1956H(parcel, H);
    }

    public C1189b[] m4850O(int i) {
        return new C1189b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4851q(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4850O(i);
    }

    public C1189b m4851q(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        Status status = null;
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    status = (Status) C0541a.m1922a(parcel, F, Status.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    list = C0541a.m1928c(parcel, F, hr.CREATOR);
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
            return new C1189b(i, status, list);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }
}
