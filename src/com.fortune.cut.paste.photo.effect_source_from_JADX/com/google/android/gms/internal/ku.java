package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.internal.kr.C1277a;
import com.google.android.gms.internal.kv.C1279b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class ku implements Creator<C1279b> {
    static void m5286a(C1279b c1279b, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1279b.versionCode);
        C0542b.m1968a(parcel, 2, c1279b.fv, false);
        C0542b.m1964a(parcel, 3, c1279b.NZ, i, false);
        C0542b.m1956H(parcel, H);
    }

    public C1279b m5287N(Parcel parcel) {
        C1277a c1277a = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    c1277a = (C1277a) C0541a.m1922a(parcel, F, C1277a.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1279b(i, str, c1277a);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1279b[] aO(int i) {
        return new C1279b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5287N(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return aO(i);
    }
}
