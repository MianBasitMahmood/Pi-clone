package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.pi.C1443f;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.Set;

public class pq implements Creator<C1443f> {
    static void m5806a(C1443f c1443f, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        Set set = c1443f.aon;
        if (set.contains(Integer.valueOf(1))) {
            C0542b.m1980c(parcel, 1, c1443f.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            C0542b.m1968a(parcel, 2, c1443f.apP, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            C0542b.m1968a(parcel, 3, c1443f.UO, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            C0542b.m1968a(parcel, 4, c1443f.aoK, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            C0542b.m1968a(parcel, 5, c1443f.apQ, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            C0542b.m1968a(parcel, 6, c1443f.mName, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            C0542b.m1971a(parcel, 7, c1443f.apR);
        }
        if (set.contains(Integer.valueOf(8))) {
            C0542b.m1968a(parcel, 8, c1443f.apa, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            C0542b.m1968a(parcel, 9, c1443f.OH, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            C0542b.m1980c(parcel, 10, c1443f.Gt);
        }
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dG(parcel);
    }

    public C1443f dG(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = C0541a.m1920G(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str7 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str6 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str5 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str4 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Error.OTHER /*6*/:
                    str3 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case Error.AVS_DECLINE /*7*/:
                    z = C0541a.m1929c(parcel, F);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    str2 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    str = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    i = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1443f(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1443f[] fE(int i) {
        return new C1443f[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fE(i);
    }
}
