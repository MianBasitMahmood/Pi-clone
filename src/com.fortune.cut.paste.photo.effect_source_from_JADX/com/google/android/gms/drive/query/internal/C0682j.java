package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;

/* renamed from: com.google.android.gms.drive.query.internal.j */
public class C0682j implements Creator<MatchAllFilter> {
    static void m2432a(MatchAllFilter matchAllFilter, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, matchAllFilter.CK);
        C0542b.m1956H(parcel, H);
    }

    public MatchAllFilter aZ(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new MatchAllFilter(i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public MatchAllFilter[] co(int i) {
        return new MatchAllFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return aZ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return co(i);
    }
}
