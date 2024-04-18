package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.internal.nn;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.location.a */
public class C1505a implements Creator<GeofencingRequest> {
    static void m6092a(GeofencingRequest geofencingRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1981c(parcel, 1, geofencingRequest.ng(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, geofencingRequest.getVersionCode());
        C0542b.m1980c(parcel, 2, geofencingRequest.getInitialTrigger());
        C0542b.m1956H(parcel, H);
    }

    public GeofencingRequest cI(Parcel parcel) {
        int i = 0;
        int G = C0541a.m1920G(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    list = C0541a.m1928c(parcel, F, nn.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i = C0541a.m1933g(parcel, F);
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
            return new GeofencingRequest(i2, list, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cI(parcel);
    }

    public GeofencingRequest[] ex(int i) {
        return new GeofencingRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return ex(i);
    }
}
