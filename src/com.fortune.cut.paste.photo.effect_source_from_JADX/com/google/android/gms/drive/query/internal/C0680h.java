package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.query.internal.h */
public class C0680h implements Creator<InFilter> {
    static void m2430a(InFilter inFilter, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, inFilter.CK);
        C0542b.m1964a(parcel, 1, inFilter.Si, i, false);
        C0542b.m1956H(parcel, H);
    }

    public InFilter aX(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    metadataBundle = (MetadataBundle) C0541a.m1922a(parcel, F, MetadataBundle.CREATOR);
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
            return new InFilter(i, metadataBundle);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public InFilter[] cm(int i) {
        return new InFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return aX(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cm(i);
    }
}
