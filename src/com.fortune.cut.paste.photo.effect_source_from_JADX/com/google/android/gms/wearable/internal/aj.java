package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class aj implements Creator<ai> {
    static void m6948a(ai aiVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, aiVar.CK);
        C0542b.m1980c(parcel, 2, aiVar.getRequestId());
        C0542b.m1968a(parcel, 3, aiVar.getPath(), false);
        C0542b.m1972a(parcel, 4, aiVar.getData(), false);
        C0542b.m1968a(parcel, 5, aiVar.getSourceNodeId(), false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ey(parcel);
    }

    public ai ey(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = C0541a.m1920G(parcel);
        byte[] bArr = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    bArr = C0541a.m1944r(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ai(i2, i, str2, bArr, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public ai[] gH(int i) {
        return new ai[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gH(i);
    }
}
