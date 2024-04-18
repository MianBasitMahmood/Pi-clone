package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.internal.i */
public class C0681i implements Creator<LogicalFilter> {
    static void m2431a(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, logicalFilter.CK);
        C0542b.m1964a(parcel, 1, logicalFilter.Sh, i, false);
        C0542b.m1981c(parcel, 2, logicalFilter.Su, false);
        C0542b.m1956H(parcel, H);
    }

    public LogicalFilter aY(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        Operator operator = null;
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    operator = (Operator) C0541a.m1922a(parcel, F, Operator.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    list = C0541a.m1928c(parcel, F, FilterHolder.CREATOR);
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
            return new LogicalFilter(i, operator, list);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public LogicalFilter[] cn(int i) {
        return new LogicalFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return aY(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cn(i);
    }
}
