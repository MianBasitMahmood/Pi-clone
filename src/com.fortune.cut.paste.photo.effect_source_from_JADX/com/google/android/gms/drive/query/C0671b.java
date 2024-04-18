package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.b */
public class C0671b implements Creator<SortOrder> {
    static void m2399a(SortOrder sortOrder, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, sortOrder.CK);
        C0542b.m1981c(parcel, 1, sortOrder.Sf, false);
        C0542b.m1971a(parcel, 2, sortOrder.Sg);
        C0542b.m1956H(parcel, H);
    }

    public SortOrder aR(Parcel parcel) {
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    list = C0541a.m1928c(parcel, F, FieldWithSortOrder.CREATOR);
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
            return new SortOrder(i, list, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public SortOrder[] cg(int i) {
        return new SortOrder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return aR(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cg(i);
    }
}
