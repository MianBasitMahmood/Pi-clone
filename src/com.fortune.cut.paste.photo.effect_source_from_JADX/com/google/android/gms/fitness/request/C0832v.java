package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.fitness.request.v */
public class C0832v implements Creator<C0831u> {
    static void m2772a(C0831u c0831u, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, c0831u.kb(), i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, c0831u.getVersionCode());
        C0542b.m1956H(parcel, H);
    }

    public C0831u bU(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
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
            return new C0831u(i, pendingIntent);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bU(parcel);
    }

    public C0831u[] dp(int i) {
        return new C0831u[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dp(i);
    }
}
