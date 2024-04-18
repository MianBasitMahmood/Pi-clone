package com.google.android.gms.maps.model.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.model.internal.d */
public class C1652d implements Creator<C1651c> {
    static void m6202a(C1651c c1651c, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1651c.getVersionCode());
        C0542b.m1980c(parcel, 2, c1651c.getType());
        C0542b.m1961a(parcel, 3, c1651c.oi(), false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dq(parcel);
    }

    public C1651c dq(Parcel parcel) {
        int i = 0;
        int G = C0541a.m1920G(parcel);
        Bundle bundle = null;
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
                    bundle = C0541a.m1943q(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1651c(i2, i, bundle);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1651c[] fm(int i) {
        return new C1651c[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fm(i);
    }
}
