package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.maps.model.m */
public class C1685m implements Creator<PolygonOptions> {
    static void m6236a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, polygonOptions.getVersionCode());
        C0542b.m1981c(parcel, 2, polygonOptions.getPoints(), false);
        C0542b.m1982d(parcel, 3, polygonOptions.of(), false);
        C0542b.m1959a(parcel, 4, polygonOptions.getStrokeWidth());
        C0542b.m1980c(parcel, 5, polygonOptions.getStrokeColor());
        C0542b.m1980c(parcel, 6, polygonOptions.getFillColor());
        C0542b.m1959a(parcel, 7, polygonOptions.getZIndex());
        C0542b.m1971a(parcel, 8, polygonOptions.isVisible());
        C0542b.m1971a(parcel, 9, polygonOptions.isGeodesic());
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dg(parcel);
    }

    public PolygonOptions dg(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        List list = null;
        List arrayList = new ArrayList();
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    list = C0541a.m1928c(parcel, F, LatLng.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    C0541a.m1925a(parcel, F, arrayList, getClass().getClassLoader());
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    f2 = C0541a.m1938l(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    f = C0541a.m1938l(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    z2 = C0541a.m1929c(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new PolygonOptions(i3, list, arrayList, f2, i2, i, f, z2, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public PolygonOptions[] fc(int i) {
        return new PolygonOptions[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fc(i);
    }
}
