package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.query.internal.c */
public class C0676c implements Creator<FieldWithSortOrder> {
    static void m2426a(FieldWithSortOrder fieldWithSortOrder, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, fieldWithSortOrder.CK);
        C0542b.m1968a(parcel, 1, fieldWithSortOrder.QY, false);
        C0542b.m1971a(parcel, 2, fieldWithSortOrder.Sk);
        C0542b.m1956H(parcel, H);
    }

    public FieldWithSortOrder aU(Parcel parcel) {
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    z = C0541a.m1929c(parcel, F);
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
            return new FieldWithSortOrder(i, str, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public FieldWithSortOrder[] cj(int i) {
        return new FieldWithSortOrder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return aU(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cj(i);
    }
}
