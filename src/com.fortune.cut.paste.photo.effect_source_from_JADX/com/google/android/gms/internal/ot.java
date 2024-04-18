package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class ot implements Creator<or> {
    static void m5730a(or orVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, orVar.versionCode);
        C0542b.m1960a(parcel, 2, orVar.amW);
        C0542b.m1968a(parcel, 3, orVar.tag, false);
        C0542b.m1972a(parcel, 4, orVar.amX, false);
        C0542b.m1961a(parcel, 5, orVar.amY, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dt(parcel);
    }

    public or dt(Parcel parcel) {
        Bundle bundle = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        long j = 0;
        byte[] bArr = null;
        String str = null;
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
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    bArr = C0541a.m1944r(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    bundle = C0541a.m1943q(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new or(i, j, str, bArr, bundle);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public or[] fq(int i) {
        return new or[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fq(i);
    }
}
