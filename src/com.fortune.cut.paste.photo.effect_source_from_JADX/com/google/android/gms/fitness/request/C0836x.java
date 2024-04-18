package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.fitness.request.x */
public class C0836x implements Creator<C0835w> {
    static void m2776a(C0835w c0835w, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, c0835w.getSession(), i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, c0835w.getVersionCode());
        C0542b.m1956H(parcel, H);
    }

    public C0835w bV(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        Session session = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    session = (Session) C0541a.m1922a(parcel, F, Session.CREATOR);
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
            return new C0835w(i, session);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bV(parcel);
    }

    public C0835w[] dq(int i) {
        return new C0835w[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dq(i);
    }
}
