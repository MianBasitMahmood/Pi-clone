package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.internal.pi.C1441d;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.Set;

public class pp implements Creator<C1441d> {
    static void m5805a(C1441d c1441d, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        Set set = c1441d.aon;
        if (set.contains(Integer.valueOf(1))) {
            C0542b.m1980c(parcel, 1, c1441d.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            C0542b.m1968a(parcel, 2, c1441d.aoL, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            C0542b.m1968a(parcel, 3, c1441d.apL, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            C0542b.m1968a(parcel, 4, c1441d.aoO, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            C0542b.m1968a(parcel, 5, c1441d.apM, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            C0542b.m1968a(parcel, 6, c1441d.apN, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            C0542b.m1968a(parcel, 7, c1441d.apO, true);
        }
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dF(parcel);
    }

    public C1441d dF(Parcel parcel) {
        String str = null;
        int G = C0541a.m1920G(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str6 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str5 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str4 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str3 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Error.OTHER /*6*/:
                    str2 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(6));
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
            return new C1441d(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1441d[] fD(int i) {
        return new C1441d[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fD(i);
    }
}
