package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class kz implements Creator<ky> {
    static void m5308a(ky kyVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, kyVar.getVersionCode());
        C0542b.m1963a(parcel, 2, kyVar.ic(), false);
        C0542b.m1964a(parcel, 3, kyVar.id(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public ky m5309Q(Parcel parcel) {
        kv kvVar = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    parcel2 = C0541a.m1917D(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    kvVar = (kv) C0541a.m1922a(parcel, F, kv.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ky(i, parcel2, kvVar);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public ky[] aR(int i) {
        return new ky[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5309Q(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return aR(i);
    }
}
