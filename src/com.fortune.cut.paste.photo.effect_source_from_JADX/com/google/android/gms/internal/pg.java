package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.Set;

public class pg implements Creator<pf> {
    static void m5777a(pf pfVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        Set set = pfVar.aon;
        if (set.contains(Integer.valueOf(1))) {
            C0542b.m1980c(parcel, 1, pfVar.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            C0542b.m1968a(parcel, 2, pfVar.CE, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            C0542b.m1964a(parcel, 4, pfVar.api, i, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            C0542b.m1968a(parcel, 5, pfVar.apa, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            C0542b.m1964a(parcel, 6, pfVar.apj, i, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            C0542b.m1968a(parcel, 7, pfVar.vc, true);
        }
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dy(parcel);
    }

    public pf dy(Parcel parcel) {
        String str = null;
        int G = C0541a.m1920G(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        pd pdVar = null;
        String str2 = null;
        pd pdVar2 = null;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            pd pdVar3;
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str3 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    pdVar3 = (pd) C0541a.m1922a(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    pdVar2 = pdVar3;
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str2 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Error.OTHER /*6*/:
                    pdVar3 = (pd) C0541a.m1922a(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    pdVar = pdVar3;
                    break;
                case Error.AVS_DECLINE /*7*/:
                    str = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new pf(hashSet, i, str3, pdVar2, str2, pdVar, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public pf[] fw(int i) {
        return new pf[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fw(i);
    }
}
