package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.query.internal.k */
public class C0683k implements Creator<NotFilter> {
    static void m2433a(NotFilter notFilter, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, notFilter.CK);
        C0542b.m1964a(parcel, 1, notFilter.Sv, i, false);
        C0542b.m1956H(parcel, H);
    }

    public NotFilter ba(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        FilterHolder filterHolder = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    filterHolder = (FilterHolder) C0541a.m1922a(parcel, F, FilterHolder.CREATOR);
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
            return new NotFilter(i, filterHolder);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public NotFilter[] cp(int i) {
        return new NotFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ba(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cp(i);
    }
}
