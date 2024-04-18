package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.fitness.data.r */
public class C0787r implements Creator<C0786q> {
    static void m2673a(C0786q c0786q, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, c0786q.getSession(), i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, c0786q.CK);
        C0542b.m1964a(parcel, 2, c0786q.jH(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public C0786q bD(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        Session session = null;
        int i = 0;
        DataSet dataSet = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    session = (Session) C0541a.m1922a(parcel, F, Session.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    dataSet = (DataSet) C0541a.m1922a(parcel, F, DataSet.CREATOR);
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
            return new C0786q(i, session, dataSet);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C0786q[] cX(int i) {
        return new C0786q[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bD(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cX(i);
    }
}
