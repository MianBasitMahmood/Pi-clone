package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

public class mr implements Creator<mq> {
    static void m5502a(mq mqVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1981c(parcel, 1, mqVar.getDataTypes(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, mqVar.getVersionCode());
        C0542b.m1956H(parcel, H);
    }

    public mq bG(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    list = C0541a.m1928c(parcel, F, DataType.CREATOR);
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
            return new mq(i, list);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bG(parcel);
    }

    public mq[] da(int i) {
        return new mq[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return da(i);
    }
}
