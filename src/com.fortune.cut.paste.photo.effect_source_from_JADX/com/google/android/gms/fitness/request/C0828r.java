package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.fitness.request.r */
public class C0828r implements Creator<C0827q> {
    static void m2767a(C0827q c0827q, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1962a(parcel, 1, c0827q.kg(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, c0827q.getVersionCode());
        C0542b.m1964a(parcel, 2, c0827q.kb(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public C0827q bR(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    iBinder = C0541a.m1942p(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    pendingIntent = (PendingIntent) C0541a.m1922a(parcel, F, PendingIntent.CREATOR);
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
            return new C0827q(i, iBinder, pendingIntent);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bR(parcel);
    }

    public C0827q[] dm(int i) {
        return new C0827q[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dm(i);
    }
}
