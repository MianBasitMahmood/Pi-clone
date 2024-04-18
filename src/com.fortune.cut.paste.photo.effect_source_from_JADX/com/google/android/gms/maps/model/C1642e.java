package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.model.e */
public class C1642e implements Creator<GroundOverlayOptions> {
    static void m6196a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, groundOverlayOptions.getVersionCode());
        C0542b.m1962a(parcel, 2, groundOverlayOptions.od(), false);
        C0542b.m1964a(parcel, 3, groundOverlayOptions.getLocation(), i, false);
        C0542b.m1959a(parcel, 4, groundOverlayOptions.getWidth());
        C0542b.m1959a(parcel, 5, groundOverlayOptions.getHeight());
        C0542b.m1964a(parcel, 6, groundOverlayOptions.getBounds(), i, false);
        C0542b.m1959a(parcel, 7, groundOverlayOptions.getBearing());
        C0542b.m1959a(parcel, 8, groundOverlayOptions.getZIndex());
        C0542b.m1971a(parcel, 9, groundOverlayOptions.isVisible());
        C0542b.m1959a(parcel, 10, groundOverlayOptions.getTransparency());
        C0542b.m1959a(parcel, 11, groundOverlayOptions.getAnchorU());
        C0542b.m1959a(parcel, 12, groundOverlayOptions.getAnchorV());
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dc(parcel);
    }

    public GroundOverlayOptions dc(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    iBinder = C0541a.m1942p(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    latLng = (LatLng) C0541a.m1922a(parcel, F, LatLng.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    f = C0541a.m1938l(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    f2 = C0541a.m1938l(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    latLngBounds = (LatLngBounds) C0541a.m1922a(parcel, F, LatLngBounds.CREATOR);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    f3 = C0541a.m1938l(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    f4 = C0541a.m1938l(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    f5 = C0541a.m1938l(parcel, F);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    f6 = C0541a.m1938l(parcel, F);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    f7 = C0541a.m1938l(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public GroundOverlayOptions[] eY(int i) {
        return new GroundOverlayOptions[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eY(i);
    }
}
