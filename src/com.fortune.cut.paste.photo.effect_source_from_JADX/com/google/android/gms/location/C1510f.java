package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.location.f */
public class C1510f implements Creator<C1509e> {
    static void m6094a(C1509e c1509e, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1509e.agw);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, c1509e.getVersionCode());
        C0542b.m1980c(parcel, 2, c1509e.agx);
        C0542b.m1960a(parcel, 3, c1509e.agy);
        C0542b.m1956H(parcel, H);
    }

    public C1509e cK(Parcel parcel) {
        int i = 1;
        int G = C0541a.m1920G(parcel);
        int i2 = 0;
        long j = 0;
        int i3 = 1;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    j = C0541a.m1935i(parcel, F);
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
            return new C1509e(i2, i3, i, j);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cK(parcel);
    }

    public C1509e[] eE(int i) {
        return new C1509e[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eE(i);
    }
}
