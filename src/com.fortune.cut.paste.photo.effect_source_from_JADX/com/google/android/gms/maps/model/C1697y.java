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

/* renamed from: com.google.android.gms.maps.model.y */
public class C1697y implements Creator<VisibleRegion> {
    static void m6248a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, visibleRegion.getVersionCode());
        C0542b.m1964a(parcel, 2, visibleRegion.nearLeft, i, false);
        C0542b.m1964a(parcel, 3, visibleRegion.nearRight, i, false);
        C0542b.m1964a(parcel, 4, visibleRegion.farLeft, i, false);
        C0542b.m1964a(parcel, 5, visibleRegion.farRight, i, false);
        C0542b.m1964a(parcel, 6, visibleRegion.latLngBounds, i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6249do(parcel);
    }

    public VisibleRegion m6249do(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    latLng4 = (LatLng) C0541a.m1922a(parcel, F, LatLng.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    latLng3 = (LatLng) C0541a.m1922a(parcel, F, LatLng.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    latLng2 = (LatLng) C0541a.m1922a(parcel, F, LatLng.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    latLng = (LatLng) C0541a.m1922a(parcel, F, LatLng.CREATOR);
                    break;
                case Error.OTHER /*6*/:
                    latLngBounds = (LatLngBounds) C0541a.m1922a(parcel, F, LatLngBounds.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public VisibleRegion[] fk(int i) {
        return new VisibleRegion[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fk(i);
    }
}
