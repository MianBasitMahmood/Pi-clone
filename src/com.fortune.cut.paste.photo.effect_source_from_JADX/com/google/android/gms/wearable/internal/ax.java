package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

public class ax implements Creator<aw> {
    static void m6968a(aw awVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, awVar.versionCode);
        C0542b.m1980c(parcel, 2, awVar.statusCode);
        C0542b.m1960a(parcel, 3, awVar.ayc);
        C0542b.m1981c(parcel, 4, awVar.aye, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return eE(parcel);
    }

    public aw eE(Parcel parcel) {
        int i = 0;
        int G = C0541a.m1920G(parcel);
        long j = 0;
        List list = null;
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
                    j = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    list = C0541a.m1928c(parcel, F, an.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new aw(i2, i, j, list);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public aw[] gO(int i) {
        return new aw[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gO(i);
    }
}
