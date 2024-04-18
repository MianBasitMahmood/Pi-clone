package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.fitness.data.b */
public class C0767b implements Creator<C0766a> {
    static void m2653a(C0766a c0766a, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, c0766a.getPackageName(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, c0766a.getVersionCode());
        C0542b.m1968a(parcel, 2, c0766a.getVersion(), false);
        C0542b.m1968a(parcel, 3, c0766a.jk(), false);
        C0542b.m1956H(parcel, H);
    }

    public C0766a bq(Parcel parcel) {
        String str = null;
        int G = C0541a.m1920G(parcel);
        String str2 = null;
        int i = 0;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
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
            return new C0766a(i, str2, str3, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C0766a[] cH(int i) {
        return new C0766a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cH(i);
    }
}
