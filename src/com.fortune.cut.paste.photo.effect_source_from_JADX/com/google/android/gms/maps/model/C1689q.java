package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.model.q */
public class C1689q implements Creator<StreetViewPanoramaCamera> {
    static void m6240a(StreetViewPanoramaCamera streetViewPanoramaCamera, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, streetViewPanoramaCamera.getVersionCode());
        C0542b.m1959a(parcel, 2, streetViewPanoramaCamera.zoom);
        C0542b.m1959a(parcel, 3, streetViewPanoramaCamera.tilt);
        C0542b.m1959a(parcel, 4, streetViewPanoramaCamera.bearing);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return di(parcel);
    }

    public StreetViewPanoramaCamera di(Parcel parcel) {
        float f = 0.0f;
        int G = C0541a.m1920G(parcel);
        float f2 = 0.0f;
        int i = 0;
        float f3 = 0.0f;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    f2 = C0541a.m1938l(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    f3 = C0541a.m1938l(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    f = C0541a.m1938l(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new StreetViewPanoramaCamera(i, f2, f3, f);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public StreetViewPanoramaCamera[] fe(int i) {
        return new StreetViewPanoramaCamera[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fe(i);
    }
}
