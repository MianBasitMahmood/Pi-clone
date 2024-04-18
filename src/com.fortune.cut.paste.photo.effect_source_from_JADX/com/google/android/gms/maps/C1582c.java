package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.c */
public class C1582c implements Creator<StreetViewPanoramaOptions> {
    static void m6139a(StreetViewPanoramaOptions streetViewPanoramaOptions, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, streetViewPanoramaOptions.getVersionCode());
        C0542b.m1964a(parcel, 2, streetViewPanoramaOptions.getStreetViewPanoramaCamera(), i, false);
        C0542b.m1968a(parcel, 3, streetViewPanoramaOptions.getPanoramaId(), false);
        C0542b.m1964a(parcel, 4, streetViewPanoramaOptions.getPosition(), i, false);
        C0542b.m1966a(parcel, 5, streetViewPanoramaOptions.getRadius(), false);
        C0542b.m1957a(parcel, 6, streetViewPanoramaOptions.nS());
        C0542b.m1957a(parcel, 7, streetViewPanoramaOptions.nI());
        C0542b.m1957a(parcel, 8, streetViewPanoramaOptions.nT());
        C0542b.m1957a(parcel, 9, streetViewPanoramaOptions.nU());
        C0542b.m1957a(parcel, 10, streetViewPanoramaOptions.nE());
        C0542b.m1956H(parcel, H);
    }

    public StreetViewPanoramaOptions cY(Parcel parcel) {
        Integer num = null;
        byte b = (byte) 0;
        int G = C0541a.m1920G(parcel);
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        LatLng latLng = null;
        String str = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) C0541a.m1922a(parcel, F, StreetViewPanoramaCamera.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    latLng = (LatLng) C0541a.m1922a(parcel, F, LatLng.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    num = C0541a.m1934h(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    b5 = C0541a.m1931e(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    b4 = C0541a.m1931e(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    b3 = C0541a.m1931e(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    b2 = C0541a.m1931e(parcel, F);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    b = C0541a.m1931e(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new StreetViewPanoramaOptions(i, streetViewPanoramaCamera, str, latLng, num, b5, b4, b3, b2, b);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cY(parcel);
    }

    public StreetViewPanoramaOptions[] eU(int i) {
        return new StreetViewPanoramaOptions[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eU(i);
    }
}
