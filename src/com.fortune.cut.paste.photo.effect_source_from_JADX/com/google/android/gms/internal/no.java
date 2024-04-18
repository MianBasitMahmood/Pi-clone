package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class no implements Creator<nn> {
    static void m5678a(nn nnVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, nnVar.getRequestId(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, nnVar.getVersionCode());
        C0542b.m1960a(parcel, 2, nnVar.getExpirationTime());
        C0542b.m1970a(parcel, 3, nnVar.nn());
        C0542b.m1958a(parcel, 4, nnVar.getLatitude());
        C0542b.m1958a(parcel, 5, nnVar.getLongitude());
        C0542b.m1959a(parcel, 6, nnVar.no());
        C0542b.m1980c(parcel, 7, nnVar.np());
        C0542b.m1980c(parcel, 8, nnVar.getNotificationResponsiveness());
        C0542b.m1980c(parcel, 9, nnVar.nq());
        C0542b.m1956H(parcel, H);
    }

    public nn cN(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    s = C0541a.m1932f(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    d = C0541a.m1939m(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    d2 = C0541a.m1939m(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    f = C0541a.m1938l(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    i4 = C0541a.m1933g(parcel, F);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new nn(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cN(parcel);
    }

    public nn[] eJ(int i) {
        return new nn[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eJ(i);
    }
}
