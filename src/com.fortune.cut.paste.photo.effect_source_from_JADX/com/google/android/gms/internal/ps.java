package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.internal.pi.C1445h;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.Set;

public class ps implements Creator<C1445h> {
    static void m5808a(C1445h c1445h, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        Set set = c1445h.aon;
        if (set.contains(Integer.valueOf(1))) {
            C0542b.m1980c(parcel, 1, c1445h.CK);
        }
        if (set.contains(Integer.valueOf(3))) {
            C0542b.m1980c(parcel, 3, c1445h.oU());
        }
        if (set.contains(Integer.valueOf(4))) {
            C0542b.m1968a(parcel, 4, c1445h.mValue, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            C0542b.m1968a(parcel, 5, c1445h.XL, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            C0542b.m1980c(parcel, 6, c1445h.Gt);
        }
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dI(parcel);
    }

    public C1445h dI(Parcel parcel) {
        String str = null;
        int i = 0;
        int G = C0541a.m1920G(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str2 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Error.OTHER /*6*/:
                    i2 = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1445h(hashSet, i3, str2, i2, str, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1445h[] fG(int i) {
        return new C1445h[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fG(i);
    }
}
