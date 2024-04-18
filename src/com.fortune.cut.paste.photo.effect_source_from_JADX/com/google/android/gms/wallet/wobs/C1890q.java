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

/* renamed from: com.google.android.gms.wallet.wobs.q */
public class C1890q implements Creator<C1889p> {
    static void m6807a(C1889p c1889p, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1889p.getVersionCode());
        C0542b.m1968a(parcel, 2, c1889p.awT, false);
        C0542b.m1968a(parcel, 3, c1889p.tU, false);
        C0542b.m1964a(parcel, 4, c1889p.awX, i, false);
        C0542b.m1964a(parcel, 5, c1889p.awY, i, false);
        C0542b.m1964a(parcel, 6, c1889p.awZ, i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ek(parcel);
    }

    public C1889p ek(Parcel parcel) {
        C1887n c1887n = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        C1887n c1887n2 = null;
        C1885l c1885l = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    c1885l = (C1885l) C0541a.m1922a(parcel, F, C1885l.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    c1887n2 = (C1887n) C0541a.m1922a(parcel, F, C1887n.CREATOR);
                    break;
                case Error.OTHER /*6*/:
                    c1887n = (C1887n) C0541a.m1922a(parcel, F, C1887n.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1889p(i, str2, str, c1885l, c1887n2, c1887n);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1889p[] gt(int i) {
        return new C1889p[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gt(i);
    }
}
