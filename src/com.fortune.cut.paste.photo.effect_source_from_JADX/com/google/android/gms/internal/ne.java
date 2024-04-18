package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class ne implements Creator<nd> {
    static void m5546a(nd ndVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, ndVar.uid);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, ndVar.getVersionCode());
        C0542b.m1968a(parcel, 2, ndVar.packageName, false);
        C0542b.m1956H(parcel, H);
    }

    public nd cL(Parcel parcel) {
        int i = 0;
        int G = C0541a.m1920G(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0541a.m1941o(parcel, F);
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
            return new nd(i2, i, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cL(parcel);
    }

    public nd[] eF(int i) {
        return new nd[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eF(i);
    }
}
