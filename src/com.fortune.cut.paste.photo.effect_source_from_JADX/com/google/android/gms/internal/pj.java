package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.internal.pi.C1436a;
import com.google.android.gms.internal.pi.C1439b;
import com.google.android.gms.internal.pi.C1440c;
import com.google.android.gms.internal.pi.C1441d;
import com.google.android.gms.internal.pi.C1443f;
import com.google.android.gms.internal.pi.C1444g;
import com.google.android.gms.internal.pi.C1445h;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class pj implements Creator<pi> {
    static void m5799a(pi piVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        Set set = piVar.aon;
        if (set.contains(Integer.valueOf(1))) {
            C0542b.m1980c(parcel, 1, piVar.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            C0542b.m1968a(parcel, 2, piVar.apl, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            C0542b.m1964a(parcel, 3, piVar.apm, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            C0542b.m1968a(parcel, 4, piVar.apn, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            C0542b.m1968a(parcel, 5, piVar.apo, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            C0542b.m1980c(parcel, 6, piVar.app);
        }
        if (set.contains(Integer.valueOf(7))) {
            C0542b.m1964a(parcel, 7, piVar.apq, i, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            C0542b.m1968a(parcel, 8, piVar.apr, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            C0542b.m1968a(parcel, 9, piVar.OS, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            C0542b.m1980c(parcel, 12, piVar.ow);
        }
        if (set.contains(Integer.valueOf(14))) {
            C0542b.m1968a(parcel, 14, piVar.CE, true);
        }
        if (set.contains(Integer.valueOf(15))) {
            C0542b.m1964a(parcel, 15, piVar.aps, i, true);
        }
        if (set.contains(Integer.valueOf(16))) {
            C0542b.m1971a(parcel, 16, piVar.apt);
        }
        if (set.contains(Integer.valueOf(19))) {
            C0542b.m1964a(parcel, 19, piVar.apu, i, true);
        }
        if (set.contains(Integer.valueOf(18))) {
            C0542b.m1968a(parcel, 18, piVar.FR, true);
        }
        if (set.contains(Integer.valueOf(21))) {
            C0542b.m1980c(parcel, 21, piVar.apw);
        }
        if (set.contains(Integer.valueOf(20))) {
            C0542b.m1968a(parcel, 20, piVar.apv, true);
        }
        if (set.contains(Integer.valueOf(23))) {
            C0542b.m1981c(parcel, 23, piVar.apy, true);
        }
        if (set.contains(Integer.valueOf(22))) {
            C0542b.m1981c(parcel, 22, piVar.apx, true);
        }
        if (set.contains(Integer.valueOf(25))) {
            C0542b.m1980c(parcel, 25, piVar.apA);
        }
        if (set.contains(Integer.valueOf(24))) {
            C0542b.m1980c(parcel, 24, piVar.apz);
        }
        if (set.contains(Integer.valueOf(27))) {
            C0542b.m1968a(parcel, 27, piVar.vf, true);
        }
        if (set.contains(Integer.valueOf(26))) {
            C0542b.m1968a(parcel, 26, piVar.apB, true);
        }
        if (set.contains(Integer.valueOf(29))) {
            C0542b.m1971a(parcel, 29, piVar.apD);
        }
        if (set.contains(Integer.valueOf(28))) {
            C0542b.m1981c(parcel, 28, piVar.apC, true);
        }
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dz(parcel);
    }

    public pi dz(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        C1436a c1436a = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        C1439b c1439b = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        C1440c c1440c = null;
        boolean z = false;
        String str7 = null;
        C1441d c1441d = null;
        String str8 = null;
        int i4 = 0;
        List list = null;
        List list2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        List list3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    C1436a c1436a2 = (C1436a) C0541a.m1922a(parcel, F, C1436a.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c1436a = c1436a2;
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str2 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str3 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Error.OTHER /*6*/:
                    i2 = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case Error.AVS_DECLINE /*7*/:
                    C1439b c1439b2 = (C1439b) C0541a.m1922a(parcel, F, C1439b.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    c1439b = c1439b2;
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    str4 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    str5 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    i3 = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    str6 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    C1440c c1440c2 = (C1440c) C0541a.m1922a(parcel, F, C1440c.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    c1440c = c1440c2;
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    z = C0541a.m1929c(parcel, F);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 18:
                    str7 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    C1441d c1441d2 = (C1441d) C0541a.m1922a(parcel, F, C1441d.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    c1441d = c1441d2;
                    break;
                case 20:
                    str8 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    i4 = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    list = C0541a.m1928c(parcel, F, C1443f.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    list2 = C0541a.m1928c(parcel, F, C1444g.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    i5 = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    i6 = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case 26:
                    str9 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str10 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    list3 = C0541a.m1928c(parcel, F, C1445h.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    z2 = C0541a.m1929c(parcel, F);
                    hashSet.add(Integer.valueOf(29));
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new pi(hashSet, i, str, c1436a, str2, str3, i2, c1439b, str4, str5, i3, str6, c1440c, z, str7, c1441d, str8, i4, list, list2, i5, i6, str9, str10, list3, z2);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public pi[] fx(int i) {
        return new pi[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fx(i);
    }
}
