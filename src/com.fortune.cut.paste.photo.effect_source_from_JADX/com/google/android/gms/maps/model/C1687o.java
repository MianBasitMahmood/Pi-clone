package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.maps.model.o */
public class C1687o implements Creator<PolylineOptions> {
    static void m6238a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, polylineOptions.getVersionCode());
        C0542b.m1981c(parcel, 2, polylineOptions.getPoints(), false);
        C0542b.m1959a(parcel, 3, polylineOptions.getWidth());
        C0542b.m1980c(parcel, 4, polylineOptions.getColor());
        C0542b.m1959a(parcel, 5, polylineOptions.getZIndex());
        C0542b.m1971a(parcel, 6, polylineOptions.isVisible());
        C0542b.m1971a(parcel, 7, polylineOptions.isGeodesic());
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dh(parcel);
    }

    public PolylineOptions dh(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        List list = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    list = C0541a.m1928c(parcel, F, LatLng.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    f2 = C0541a.m1938l(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    f = C0541a.m1938l(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    z2 = C0541a.m1929c(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new PolylineOptions(i2, list, f2, i, f, z2, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public PolylineOptions[] fd(int i) {
        return new PolylineOptions[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fd(i);
    }
}
