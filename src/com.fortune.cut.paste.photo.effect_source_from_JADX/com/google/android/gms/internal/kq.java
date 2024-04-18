package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.internal.ko.C1275a;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class kq implements Creator<C1275a> {
    static void m5267a(C1275a c1275a, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1275a.versionCode);
        C0542b.m1968a(parcel, 2, c1275a.NJ, false);
        C0542b.m1980c(parcel, 3, c1275a.NK);
        C0542b.m1956H(parcel, H);
    }

    public C1275a m5268L(Parcel parcel) {
        int i = 0;
        int G = C0541a.m1920G(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1275a(i2, str, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1275a[] aM(int i) {
        return new C1275a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5268L(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return aM(i);
    }
}
