package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.ads.AdSize;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class pe implements Creator<pd> {
    static void m5774a(pd pdVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        Set set = pdVar.aon;
        if (set.contains(Integer.valueOf(1))) {
            C0542b.m1980c(parcel, 1, pdVar.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            C0542b.m1964a(parcel, 2, pdVar.aoo, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            C0542b.m1979b(parcel, 3, pdVar.aop, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            C0542b.m1964a(parcel, 4, pdVar.aoq, i, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            C0542b.m1968a(parcel, 5, pdVar.aor, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            C0542b.m1968a(parcel, 6, pdVar.aos, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            C0542b.m1968a(parcel, 7, pdVar.aot, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            C0542b.m1981c(parcel, 8, pdVar.aou, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            C0542b.m1980c(parcel, 9, pdVar.aov);
        }
        if (set.contains(Integer.valueOf(10))) {
            C0542b.m1981c(parcel, 10, pdVar.aow, true);
        }
        if (set.contains(Integer.valueOf(11))) {
            C0542b.m1964a(parcel, 11, pdVar.aox, i, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            C0542b.m1981c(parcel, 12, pdVar.aoy, true);
        }
        if (set.contains(Integer.valueOf(13))) {
            C0542b.m1968a(parcel, 13, pdVar.aoz, true);
        }
        if (set.contains(Integer.valueOf(14))) {
            C0542b.m1968a(parcel, 14, pdVar.aoA, true);
        }
        if (set.contains(Integer.valueOf(15))) {
            C0542b.m1964a(parcel, 15, pdVar.aoB, i, true);
        }
        if (set.contains(Integer.valueOf(17))) {
            C0542b.m1968a(parcel, 17, pdVar.aoD, true);
        }
        if (set.contains(Integer.valueOf(16))) {
            C0542b.m1968a(parcel, 16, pdVar.aoC, true);
        }
        if (set.contains(Integer.valueOf(19))) {
            C0542b.m1981c(parcel, 19, pdVar.aoE, true);
        }
        if (set.contains(Integer.valueOf(18))) {
            C0542b.m1968a(parcel, 18, pdVar.ov, true);
        }
        if (set.contains(Integer.valueOf(21))) {
            C0542b.m1968a(parcel, 21, pdVar.aoG, true);
        }
        if (set.contains(Integer.valueOf(20))) {
            C0542b.m1968a(parcel, 20, pdVar.aoF, true);
        }
        if (set.contains(Integer.valueOf(23))) {
            C0542b.m1968a(parcel, 23, pdVar.UO, true);
        }
        if (set.contains(Integer.valueOf(22))) {
            C0542b.m1968a(parcel, 22, pdVar.aoH, true);
        }
        if (set.contains(Integer.valueOf(25))) {
            C0542b.m1968a(parcel, 25, pdVar.aoJ, true);
        }
        if (set.contains(Integer.valueOf(24))) {
            C0542b.m1968a(parcel, 24, pdVar.aoI, true);
        }
        if (set.contains(Integer.valueOf(27))) {
            C0542b.m1968a(parcel, 27, pdVar.aoL, true);
        }
        if (set.contains(Integer.valueOf(26))) {
            C0542b.m1968a(parcel, 26, pdVar.aoK, true);
        }
        if (set.contains(Integer.valueOf(29))) {
            C0542b.m1964a(parcel, 29, pdVar.aoN, i, true);
        }
        if (set.contains(Integer.valueOf(28))) {
            C0542b.m1968a(parcel, 28, pdVar.aoM, true);
        }
        if (set.contains(Integer.valueOf(31))) {
            C0542b.m1968a(parcel, 31, pdVar.aoP, true);
        }
        if (set.contains(Integer.valueOf(30))) {
            C0542b.m1968a(parcel, 30, pdVar.aoO, true);
        }
        if (set.contains(Integer.valueOf(34))) {
            C0542b.m1964a(parcel, 34, pdVar.aoR, i, true);
        }
        if (set.contains(Integer.valueOf(32))) {
            C0542b.m1968a(parcel, 32, pdVar.CE, true);
        }
        if (set.contains(Integer.valueOf(33))) {
            C0542b.m1968a(parcel, 33, pdVar.aoQ, true);
        }
        if (set.contains(Integer.valueOf(38))) {
            C0542b.m1958a(parcel, 38, pdVar.agh);
        }
        if (set.contains(Integer.valueOf(39))) {
            C0542b.m1968a(parcel, 39, pdVar.mName, true);
        }
        if (set.contains(Integer.valueOf(36))) {
            C0542b.m1958a(parcel, 36, pdVar.agg);
        }
        if (set.contains(Integer.valueOf(37))) {
            C0542b.m1964a(parcel, 37, pdVar.aoS, i, true);
        }
        if (set.contains(Integer.valueOf(42))) {
            C0542b.m1968a(parcel, 42, pdVar.aoV, true);
        }
        if (set.contains(Integer.valueOf(43))) {
            C0542b.m1968a(parcel, 43, pdVar.aoW, true);
        }
        if (set.contains(Integer.valueOf(40))) {
            C0542b.m1964a(parcel, 40, pdVar.aoT, i, true);
        }
        if (set.contains(Integer.valueOf(41))) {
            C0542b.m1981c(parcel, 41, pdVar.aoU, true);
        }
        if (set.contains(Integer.valueOf(46))) {
            C0542b.m1964a(parcel, 46, pdVar.aoZ, i, true);
        }
        if (set.contains(Integer.valueOf(47))) {
            C0542b.m1968a(parcel, 47, pdVar.apa, true);
        }
        if (set.contains(Integer.valueOf(44))) {
            C0542b.m1968a(parcel, 44, pdVar.aoX, true);
        }
        if (set.contains(Integer.valueOf(45))) {
            C0542b.m1968a(parcel, 45, pdVar.aoY, true);
        }
        if (set.contains(Integer.valueOf(51))) {
            C0542b.m1968a(parcel, 51, pdVar.ape, true);
        }
        if (set.contains(Integer.valueOf(50))) {
            C0542b.m1964a(parcel, 50, pdVar.apd, i, true);
        }
        if (set.contains(Integer.valueOf(49))) {
            C0542b.m1968a(parcel, 49, pdVar.apc, true);
        }
        if (set.contains(Integer.valueOf(48))) {
            C0542b.m1968a(parcel, 48, pdVar.apb, true);
        }
        if (set.contains(Integer.valueOf(55))) {
            C0542b.m1968a(parcel, 55, pdVar.apg, true);
        }
        if (set.contains(Integer.valueOf(54))) {
            C0542b.m1968a(parcel, 54, pdVar.vf, true);
        }
        if (set.contains(Integer.valueOf(53))) {
            C0542b.m1968a(parcel, 53, pdVar.vc, true);
        }
        if (set.contains(Integer.valueOf(52))) {
            C0542b.m1968a(parcel, 52, pdVar.apf, true);
        }
        if (set.contains(Integer.valueOf(56))) {
            C0542b.m1968a(parcel, 56, pdVar.aph, true);
        }
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dx(parcel);
    }

    public pd dx(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        pd pdVar = null;
        List list = null;
        pd pdVar2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        List list2 = null;
        int i2 = 0;
        List list3 = null;
        pd pdVar3 = null;
        List list4 = null;
        String str4 = null;
        String str5 = null;
        pd pdVar4 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        List list5 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        pd pdVar5 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        pd pdVar6 = null;
        double d = 0.0d;
        pd pdVar7 = null;
        double d2 = 0.0d;
        String str22 = null;
        pd pdVar8 = null;
        List list6 = null;
        String str23 = null;
        String str24 = null;
        String str25 = null;
        String str26 = null;
        pd pdVar9 = null;
        String str27 = null;
        String str28 = null;
        String str29 = null;
        pd pdVar10 = null;
        String str30 = null;
        String str31 = null;
        String str32 = null;
        String str33 = null;
        String str34 = null;
        String str35 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            pd pdVar11;
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    pdVar11 = (pd) C0541a.m1922a(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    pdVar = pdVar11;
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    list = C0541a.m1916C(parcel, F);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    pdVar11 = (pd) C0541a.m1922a(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    pdVar2 = pdVar11;
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Error.OTHER /*6*/:
                    str2 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case Error.AVS_DECLINE /*7*/:
                    str3 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    list2 = C0541a.m1928c(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    i2 = C0541a.m1933g(parcel, F);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    list3 = C0541a.m1928c(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(10));
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    pdVar11 = (pd) C0541a.m1922a(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(11));
                    pdVar3 = pdVar11;
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    list4 = C0541a.m1928c(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    str4 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(13));
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    str5 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    pdVar11 = (pd) C0541a.m1922a(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    pdVar4 = pdVar11;
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    str6 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 17:
                    str7 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(17));
                    break;
                case 18:
                    str8 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    list5 = C0541a.m1928c(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    break;
                case 20:
                    str9 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    str10 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    str11 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    str12 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    str13 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    str14 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case 26:
                    str15 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str16 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    str17 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    pdVar11 = (pd) C0541a.m1922a(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(29));
                    pdVar5 = pdVar11;
                    break;
                case MetadataChangeSet.MAX_PUBLIC_PROPERTIES_PER_RESOURCE /*30*/:
                    str18 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(30));
                    break;
                case Notifications.NOTIFICATION_TYPES_ALL /*31*/:
                    str19 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(31));
                    break;
                case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                    str20 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(32));
                    break;
                case 33:
                    str21 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(33));
                    break;
                case 34:
                    pdVar11 = (pd) C0541a.m1922a(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(34));
                    pdVar6 = pdVar11;
                    break;
                case 36:
                    d = C0541a.m1939m(parcel, F);
                    hashSet.add(Integer.valueOf(36));
                    break;
                case 37:
                    pdVar11 = (pd) C0541a.m1922a(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(37));
                    pdVar7 = pdVar11;
                    break;
                case 38:
                    d2 = C0541a.m1939m(parcel, F);
                    hashSet.add(Integer.valueOf(38));
                    break;
                case 39:
                    str22 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(39));
                    break;
                case 40:
                    pdVar11 = (pd) C0541a.m1922a(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(40));
                    pdVar8 = pdVar11;
                    break;
                case 41:
                    list6 = C0541a.m1928c(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(41));
                    break;
                case 42:
                    str23 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(42));
                    break;
                case 43:
                    str24 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(43));
                    break;
                case 44:
                    str25 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(44));
                    break;
                case 45:
                    str26 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(45));
                    break;
                case 46:
                    pdVar11 = (pd) C0541a.m1922a(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(46));
                    pdVar9 = pdVar11;
                    break;
                case 47:
                    str27 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(47));
                    break;
                case 48:
                    str28 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(48));
                    break;
                case 49:
                    str29 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(49));
                    break;
                case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                    pdVar11 = (pd) C0541a.m1922a(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(50));
                    pdVar10 = pdVar11;
                    break;
                case 51:
                    str30 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(51));
                    break;
                case 52:
                    str31 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(52));
                    break;
                case 53:
                    str32 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(53));
                    break;
                case 54:
                    str33 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(54));
                    break;
                case 55:
                    str34 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(55));
                    break;
                case 56:
                    str35 = C0541a.m1941o(parcel, F);
                    hashSet.add(Integer.valueOf(56));
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new pd(hashSet, i, pdVar, list, pdVar2, str, str2, str3, list2, i2, list3, pdVar3, list4, str4, str5, pdVar4, str6, str7, str8, list5, str9, str10, str11, str12, str13, str14, str15, str16, str17, pdVar5, str18, str19, str20, str21, pdVar6, d, pdVar7, d2, str22, pdVar8, list6, str23, str24, str25, str26, pdVar9, str27, str28, str29, pdVar10, str30, str31, str32, str33, str34, str35);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public pd[] fv(int i) {
        return new pd[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fv(i);
    }
}
