package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.model.i */
public class C1646i implements Creator<LatLng> {
    static void m6200a(LatLng latLng, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, latLng.getVersionCode());
        C0542b.m1958a(parcel, 2, latLng.latitude);
        C0542b.m1958a(parcel, 3, latLng.longitude);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return de(parcel);
    }

    public LatLng de(Parcel parcel) {
        double d = 0.0d;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    d2 = C0541a.m1939m(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    d = C0541a.m1939m(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new LatLng(i, d2, d);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public LatLng[] fa(int i) {
        return new LatLng[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fa(i);
    }
}
