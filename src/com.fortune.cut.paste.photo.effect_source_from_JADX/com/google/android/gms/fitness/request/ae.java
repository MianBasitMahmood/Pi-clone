package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class ae implements Creator<ad> {
    static void m2739a(ad adVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1962a(parcel, 1, adVar.km(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, adVar.getVersionCode());
        C0542b.m1956H(parcel, H);
    }

    public ad bZ(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    iBinder = C0541a.m1942p(parcel, F);
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
            return new ad(i, iBinder);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bZ(parcel);
    }

    public ad[] du(int i) {
        return new ad[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return du(i);
    }
}
