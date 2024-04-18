package com.google.android.gms.plus.internal;

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

/* renamed from: com.google.android.gms.plus.internal.i */
public class C1735i implements Creator<C1734h> {
    static void m6355a(C1734h c1734h, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, c1734h.getAccountName(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, c1734h.getVersionCode());
        C0542b.m1975a(parcel, 2, c1734h.oz(), false);
        C0542b.m1975a(parcel, 3, c1734h.oA(), false);
        C0542b.m1975a(parcel, 4, c1734h.oB(), false);
        C0542b.m1968a(parcel, 5, c1734h.oC(), false);
        C0542b.m1968a(parcel, 6, c1734h.oD(), false);
        C0542b.m1968a(parcel, 7, c1734h.oE(), false);
        C0542b.m1968a(parcel, 8, c1734h.oF(), false);
        C0542b.m1964a(parcel, 9, c1734h.oG(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dw(parcel);
    }

    public C1734h dw(Parcel parcel) {
        PlusCommonExtras plusCommonExtras = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str5 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str5 = C0541a.m1941o(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    strArr3 = C0541a.m1914A(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    strArr2 = C0541a.m1914A(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    strArr = C0541a.m1914A(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    plusCommonExtras = (PlusCommonExtras) C0541a.m1922a(parcel, F, PlusCommonExtras.CREATOR);
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
            return new C1734h(i, str5, strArr3, strArr2, strArr, str4, str3, str2, str, plusCommonExtras);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1734h[] fu(int i) {
        return new C1734h[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fu(i);
    }
}
