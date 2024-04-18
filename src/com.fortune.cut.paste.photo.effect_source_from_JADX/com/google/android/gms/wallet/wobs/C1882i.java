package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.wobs.i */
public class C1882i implements Creator<C1879f> {
    static void m6803a(C1879f c1879f, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1879f.getVersionCode());
        C0542b.m1968a(parcel, 2, c1879f.label, false);
        C0542b.m1964a(parcel, 3, c1879f.awM, i, false);
        C0542b.m1968a(parcel, 4, c1879f.type, false);
        C0542b.m1964a(parcel, 5, c1879f.avm, i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return eg(parcel);
    }

    public C1879f eg(Parcel parcel) {
        C1885l c1885l = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        C1880g c1880g = null;
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
                    c1880g = (C1880g) C0541a.m1922a(parcel, F, C1880g.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    c1885l = (C1885l) C0541a.m1922a(parcel, F, C1885l.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1879f(i, str2, c1880g, str, c1885l);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1879f[] gp(int i) {
        return new C1879f[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gp(i);
    }
}
