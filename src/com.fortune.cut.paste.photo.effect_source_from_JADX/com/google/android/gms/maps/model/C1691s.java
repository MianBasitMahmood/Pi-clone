package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.model.s */
public class C1691s implements Creator<StreetViewPanoramaLocation> {
    static void m6242a(StreetViewPanoramaLocation streetViewPanoramaLocation, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, streetViewPanoramaLocation.getVersionCode());
        C0542b.m1974a(parcel, 2, streetViewPanoramaLocation.links, i, false);
        C0542b.m1964a(parcel, 3, streetViewPanoramaLocation.position, i, false);
        C0542b.m1968a(parcel, 4, streetViewPanoramaLocation.panoId, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dk(parcel);
    }

    public StreetViewPanoramaLocation dk(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        LatLng latLng = null;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = null;
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    streetViewPanoramaLinkArr = (StreetViewPanoramaLink[]) C0541a.m1927b(parcel, F, StreetViewPanoramaLink.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    latLng = (LatLng) C0541a.m1922a(parcel, F, LatLng.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new StreetViewPanoramaLocation(i, streetViewPanoramaLinkArr, latLng, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public StreetViewPanoramaLocation[] fg(int i) {
        return new StreetViewPanoramaLocation[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fg(i);
    }
}
