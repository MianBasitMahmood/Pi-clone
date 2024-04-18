package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.model.g */
public class C1644g implements Creator<LatLngBounds> {
    static void m6198a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, latLngBounds.getVersionCode());
        C0542b.m1964a(parcel, 2, latLngBounds.southwest, i, false);
        C0542b.m1964a(parcel, 3, latLngBounds.northeast, i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dd(parcel);
    }

    public LatLngBounds dd(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        LatLng latLng = null;
        int i = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    latLng = (LatLng) C0541a.m1922a(parcel, F, LatLng.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    latLng2 = (LatLng) C0541a.m1922a(parcel, F, LatLng.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new LatLngBounds(i, latLng, latLng2);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public LatLngBounds[] eZ(int i) {
        return new LatLngBounds[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eZ(i);
    }
}
