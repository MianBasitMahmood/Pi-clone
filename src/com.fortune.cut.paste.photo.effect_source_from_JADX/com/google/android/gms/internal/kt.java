package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.kr.C1277a;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class kt implements Creator<C1277a> {
    static void m5284a(C1277a c1277a, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1277a.getVersionCode());
        C0542b.m1980c(parcel, 2, c1277a.hI());
        C0542b.m1971a(parcel, 3, c1277a.hO());
        C0542b.m1980c(parcel, 4, c1277a.hJ());
        C0542b.m1971a(parcel, 5, c1277a.hP());
        C0542b.m1968a(parcel, 6, c1277a.hQ(), false);
        C0542b.m1980c(parcel, 7, c1277a.hR());
        C0542b.m1968a(parcel, 8, c1277a.hT(), false);
        C0542b.m1964a(parcel, 9, c1277a.hV(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public C1277a m5285M(Parcel parcel) {
        km kmVar = null;
        int i = 0;
        int G = C0541a.m1920G(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i4 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    z2 = C0541a.m1929c(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    kmVar = (km) C0541a.m1922a(parcel, F, km.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1277a(i4, i3, z2, i2, z, str2, i, str, kmVar);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1277a[] aN(int i) {
        return new C1277a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5285M(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return aN(i);
    }
}
