package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.data.h */
public class C0773h implements Creator<DataType> {
    static void m2659a(DataType dataType, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, dataType.getName(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, dataType.getVersionCode());
        C0542b.m1981c(parcel, 2, dataType.getFields(), false);
        C0542b.m1956H(parcel, H);
    }

    public DataType bw(Parcel parcel) {
        List list = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    list = C0541a.m1928c(parcel, F, Field.CREATOR);
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
            return new DataType(i, str, list);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public DataType[] cP(int i) {
        return new DataType[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bw(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cP(i);
    }
}
