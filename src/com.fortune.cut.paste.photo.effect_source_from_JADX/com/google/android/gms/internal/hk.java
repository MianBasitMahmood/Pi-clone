package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class hk implements Creator<hj> {
    static void m4843a(hj hjVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, hjVar.id);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, hjVar.CK);
        C0542b.m1961a(parcel, 2, hjVar.Db, false);
        C0542b.m1956H(parcel, H);
    }

    public hj[] m4844M(int i) {
        return new hj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4845o(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4844M(i);
    }

    public hj m4845o(Parcel parcel) {
        int i = 0;
        int G = C0541a.m1920G(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    bundle = C0541a.m1943q(parcel, F);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new hj(i2, i, bundle);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }
}
