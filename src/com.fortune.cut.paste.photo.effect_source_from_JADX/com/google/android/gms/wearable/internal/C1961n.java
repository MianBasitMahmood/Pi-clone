package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wearable.internal.n */
public class C1961n implements Creator<C1960m> {
    static void m7037a(C1960m c1960m, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1960m.CK);
        C0542b.m1964a(parcel, 2, c1960m.getUri(), i, false);
        C0542b.m1961a(parcel, 4, c1960m.rk(), false);
        C0542b.m1972a(parcel, 5, c1960m.getData(), false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return eq(parcel);
    }

    public C1960m eq(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        Bundle bundle = null;
        Uri uri = null;
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    uri = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    bundle = C0541a.m1943q(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    bArr = C0541a.m1944r(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1960m(i, uri, bundle, bArr);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1960m[] gz(int i) {
        return new C1960m[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gz(i);
    }
}
