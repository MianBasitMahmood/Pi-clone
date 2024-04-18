package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class nx implements Creator<nw> {
    static void m5683a(nw nwVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, nwVar.CK);
        C0542b.m1968a(parcel, 2, nwVar.nw(), false);
        C0542b.m1968a(parcel, 3, nwVar.getTag(), false);
        C0542b.m1968a(parcel, 4, nwVar.getSource(), false);
        C0542b.m1956H(parcel, H);
    }

    public nw cR(Parcel parcel) {
        String str = null;
        int G = C0541a.m1920G(parcel);
        String str2 = null;
        int i = 0;
        String str3 = null;
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
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new nw(i, str2, str3, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cR(parcel);
    }

    public nw[] eN(int i) {
        return new nw[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eN(i);
    }
}
