package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.a */
public class C1580a implements Creator<GoogleMapOptions> {
    static void m6137a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, googleMapOptions.getVersionCode());
        C0542b.m1957a(parcel, 2, googleMapOptions.nD());
        C0542b.m1957a(parcel, 3, googleMapOptions.nE());
        C0542b.m1980c(parcel, 4, googleMapOptions.getMapType());
        C0542b.m1964a(parcel, 5, googleMapOptions.getCamera(), i, false);
        C0542b.m1957a(parcel, 6, googleMapOptions.nF());
        C0542b.m1957a(parcel, 7, googleMapOptions.nG());
        C0542b.m1957a(parcel, 8, googleMapOptions.nH());
        C0542b.m1957a(parcel, 9, googleMapOptions.nI());
        C0542b.m1957a(parcel, 10, googleMapOptions.nJ());
        C0542b.m1957a(parcel, 11, googleMapOptions.nK());
        C0542b.m1957a(parcel, 12, googleMapOptions.nL());
        C0542b.m1957a(parcel, 14, googleMapOptions.nM());
        C0542b.m1956H(parcel, H);
    }

    public GoogleMapOptions cX(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        byte b = (byte) 0;
        byte b2 = (byte) 0;
        int i2 = 0;
        CameraPosition cameraPosition = null;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        byte b6 = (byte) 0;
        byte b7 = (byte) 0;
        byte b8 = (byte) 0;
        byte b9 = (byte) 0;
        byte b10 = (byte) 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    b = C0541a.m1931e(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    b2 = C0541a.m1931e(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    cameraPosition = (CameraPosition) C0541a.m1922a(parcel, F, CameraPosition.CREATOR);
                    break;
                case Error.OTHER /*6*/:
                    b3 = C0541a.m1931e(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    b4 = C0541a.m1931e(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    b5 = C0541a.m1931e(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    b6 = C0541a.m1931e(parcel, F);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    b7 = C0541a.m1931e(parcel, F);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    b8 = C0541a.m1931e(parcel, F);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    b9 = C0541a.m1931e(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    b10 = C0541a.m1931e(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new GoogleMapOptions(i, b, b2, i2, cameraPosition, b3, b4, b5, b6, b7, b8, b9, b10);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cX(parcel);
    }

    public GoogleMapOptions[] eT(int i) {
        return new GoogleMapOptions[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eT(i);
    }
}
