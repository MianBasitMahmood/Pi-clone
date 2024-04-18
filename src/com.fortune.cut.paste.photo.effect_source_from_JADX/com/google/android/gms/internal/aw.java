package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
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
import java.util.List;

public class aw implements Creator<av> {
    static void m4195a(av avVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, avVar.versionCode);
        C0542b.m1960a(parcel, 2, avVar.od);
        C0542b.m1961a(parcel, 3, avVar.extras, false);
        C0542b.m1980c(parcel, 4, avVar.oe);
        C0542b.m1979b(parcel, 5, avVar.of, false);
        C0542b.m1971a(parcel, 6, avVar.og);
        C0542b.m1980c(parcel, 7, avVar.oh);
        C0542b.m1971a(parcel, 8, avVar.oi);
        C0542b.m1968a(parcel, 9, avVar.oj, false);
        C0542b.m1964a(parcel, 10, avVar.ok, i, false);
        C0542b.m1964a(parcel, 11, avVar.ol, i, false);
        C0542b.m1968a(parcel, 12, avVar.om, false);
        C0542b.m1961a(parcel, 13, avVar.on, false);
        C0542b.m1956H(parcel, H);
    }

    public av m4196b(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        bj bjVar = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    bundle = C0541a.m1943q(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    list = C0541a.m1916C(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    z2 = C0541a.m1929c(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    bjVar = (bj) C0541a.m1922a(parcel, F, bj.CREATOR);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    location = (Location) C0541a.m1922a(parcel, F, Location.CREATOR);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    bundle2 = C0541a.m1943q(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new av(i, j, bundle, i2, list, z, i3, z2, str, bjVar, location, str2, bundle2);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4196b(parcel);
    }

    public av[] m4197f(int i) {
        return new av[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4197f(i);
    }
}
