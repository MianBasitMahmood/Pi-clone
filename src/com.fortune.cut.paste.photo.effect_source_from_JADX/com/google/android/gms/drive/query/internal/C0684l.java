package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.query.internal.l */
public class C0684l implements Creator<Operator> {
    static void m2434a(Operator operator, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, operator.CK);
        C0542b.m1968a(parcel, 1, operator.mTag, false);
        C0542b.m1956H(parcel, H);
    }

    public Operator bb(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str = C0541a.m1941o(parcel, F);
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
            return new Operator(i, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public Operator[] cq(int i) {
        return new Operator[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bb(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cq(i);
    }
}
