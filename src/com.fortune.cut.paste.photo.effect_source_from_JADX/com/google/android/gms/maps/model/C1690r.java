package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.model.r */
public class C1690r implements Creator<StreetViewPanoramaLink> {
    static void m6241a(StreetViewPanoramaLink streetViewPanoramaLink, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, streetViewPanoramaLink.getVersionCode());
        C0542b.m1968a(parcel, 2, streetViewPanoramaLink.panoId, false);
        C0542b.m1959a(parcel, 3, streetViewPanoramaLink.bearing);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dj(parcel);
    }

    public StreetViewPanoramaLink dj(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        float f = 0.0f;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    f = C0541a.m1938l(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new StreetViewPanoramaLink(i, str, f);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public StreetViewPanoramaLink[] ff(int i) {
        return new StreetViewPanoramaLink[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return ff(i);
    }
}
