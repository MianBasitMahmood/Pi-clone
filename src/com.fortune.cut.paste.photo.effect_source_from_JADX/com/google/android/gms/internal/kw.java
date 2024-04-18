package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.internal.kv.C1278a;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

public class kw implements Creator<kv> {
    static void m5292a(kv kvVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, kvVar.getVersionCode());
        C0542b.m1981c(parcel, 2, kvVar.hZ(), false);
        C0542b.m1968a(parcel, 3, kvVar.ia(), false);
        C0542b.m1956H(parcel, H);
    }

    public kv m5293O(Parcel parcel) {
        String str = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    arrayList = C0541a.m1928c(parcel, F, C1278a.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new kv(i, arrayList, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public kv[] aP(int i) {
        return new kv[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5293O(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return aP(i);
    }
}
