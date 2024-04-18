package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class dn implements Creator<C1089do> {
    static void m4441a(C1089do c1089do, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1089do.versionCode);
        C0542b.m1968a(parcel, 2, c1089do.rG, false);
        C0542b.m1968a(parcel, 3, c1089do.rH, false);
        C0542b.m1968a(parcel, 4, c1089do.mimeType, false);
        C0542b.m1968a(parcel, 5, c1089do.packageName, false);
        C0542b.m1968a(parcel, 6, c1089do.rI, false);
        C0542b.m1968a(parcel, 7, c1089do.rJ, false);
        C0542b.m1968a(parcel, 8, c1089do.rK, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4442e(parcel);
    }

    public C1089do m4442e(Parcel parcel) {
        String str = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str7 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str6 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str5 = C0541a.m1941o(parcel, F);
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
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1089do(i, str7, str6, str5, str4, str3, str2, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1089do[] m4443m(int i) {
        return new C1089do[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4443m(i);
    }
}
