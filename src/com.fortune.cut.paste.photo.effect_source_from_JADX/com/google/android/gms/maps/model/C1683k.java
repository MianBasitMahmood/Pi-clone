package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0366R;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.model.k */
public class C1683k implements Creator<MarkerOptions> {
    static void m6234a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, markerOptions.getVersionCode());
        C0542b.m1964a(parcel, 2, markerOptions.getPosition(), i, false);
        C0542b.m1968a(parcel, 3, markerOptions.getTitle(), false);
        C0542b.m1968a(parcel, 4, markerOptions.getSnippet(), false);
        C0542b.m1962a(parcel, 5, markerOptions.oe(), false);
        C0542b.m1959a(parcel, 6, markerOptions.getAnchorU());
        C0542b.m1959a(parcel, 7, markerOptions.getAnchorV());
        C0542b.m1971a(parcel, 8, markerOptions.isDraggable());
        C0542b.m1971a(parcel, 9, markerOptions.isVisible());
        C0542b.m1971a(parcel, 10, markerOptions.isFlat());
        C0542b.m1959a(parcel, 11, markerOptions.getRotation());
        C0542b.m1959a(parcel, 12, markerOptions.getInfoWindowAnchorU());
        C0542b.m1959a(parcel, 13, markerOptions.getInfoWindowAnchorV());
        C0542b.m1959a(parcel, 14, markerOptions.getAlpha());
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return df(parcel);
    }

    public MarkerOptions df(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = TextTrackStyle.DEFAULT_FONT_SCALE;
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
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    iBinder = C0541a.m1942p(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    f = C0541a.m1938l(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    f2 = C0541a.m1938l(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    z2 = C0541a.m1929c(parcel, F);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    z3 = C0541a.m1929c(parcel, F);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    f3 = C0541a.m1938l(parcel, F);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    f4 = C0541a.m1938l(parcel, F);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    f5 = C0541a.m1938l(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    f6 = C0541a.m1938l(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public MarkerOptions[] fb(int i) {
        return new MarkerOptions[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fb(i);
    }
}
