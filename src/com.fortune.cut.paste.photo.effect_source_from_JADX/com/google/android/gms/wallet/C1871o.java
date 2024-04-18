package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.o */
public class C1871o implements Creator<ProxyCard> {
    static void m6798a(ProxyCard proxyCard, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, proxyCard.getVersionCode());
        C0542b.m1968a(parcel, 2, proxyCard.avP, false);
        C0542b.m1968a(parcel, 3, proxyCard.avQ, false);
        C0542b.m1980c(parcel, 4, proxyCard.avR);
        C0542b.m1980c(parcel, 5, proxyCard.avS);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dW(parcel);
    }

    public ProxyCard dW(Parcel parcel) {
        String str = null;
        int i = 0;
        int G = C0541a.m1920G(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ProxyCard(i3, str2, str, i2, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public ProxyCard[] gd(int i) {
        return new ProxyCard[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gd(i);
    }
}
