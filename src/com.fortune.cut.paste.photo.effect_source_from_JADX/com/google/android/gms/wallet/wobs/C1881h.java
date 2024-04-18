package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.wobs.h */
public class C1881h implements Creator<C1880g> {
    static void m6802a(C1880g c1880g, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1880g.getVersionCode());
        C0542b.m1980c(parcel, 2, c1880g.awN);
        C0542b.m1968a(parcel, 3, c1880g.awO, false);
        C0542b.m1958a(parcel, 4, c1880g.awP);
        C0542b.m1968a(parcel, 5, c1880g.awQ, false);
        C0542b.m1960a(parcel, 6, c1880g.awR);
        C0542b.m1980c(parcel, 7, c1880g.awS);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ef(parcel);
    }

    public C1880g ef(Parcel parcel) {
        String str = null;
        int i = 0;
        int G = C0541a.m1920G(parcel);
        double d = 0.0d;
        long j = 0;
        int i2 = -1;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    d = C0541a.m1939m(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1880g(i3, i, str2, d, str, j, i2);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1880g[] go(int i) {
        return new C1880g[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return go(i);
    }
}
