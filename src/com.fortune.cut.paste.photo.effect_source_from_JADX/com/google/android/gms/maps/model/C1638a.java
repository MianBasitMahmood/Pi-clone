package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.model.a */
public class C1638a implements Creator<CameraPosition> {
    static void m6192a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, cameraPosition.getVersionCode());
        C0542b.m1964a(parcel, 2, cameraPosition.target, i, false);
        C0542b.m1959a(parcel, 3, cameraPosition.zoom);
        C0542b.m1959a(parcel, 4, cameraPosition.tilt);
        C0542b.m1959a(parcel, 5, cameraPosition.bearing);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return da(parcel);
    }

    public CameraPosition da(Parcel parcel) {
        float f = 0.0f;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
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
                    f3 = C0541a.m1938l(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    f2 = C0541a.m1938l(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    f = C0541a.m1938l(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CameraPosition(i, latLng, f3, f2, f);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public CameraPosition[] eW(int i) {
        return new CameraPosition[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eW(i);
    }
}
