package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

public class fk implements Creator<fj> {
    static void m4603a(fj fjVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, fjVar.versionCode);
        C0542b.m1968a(parcel, 2, fjVar.sg, false);
        C0542b.m1968a(parcel, 3, fjVar.tU, false);
        C0542b.m1979b(parcel, 4, fjVar.qw, false);
        C0542b.m1980c(parcel, 5, fjVar.errorCode);
        C0542b.m1979b(parcel, 6, fjVar.qx, false);
        C0542b.m1960a(parcel, 7, fjVar.tV);
        C0542b.m1971a(parcel, 8, fjVar.tW);
        C0542b.m1960a(parcel, 9, fjVar.tX);
        C0542b.m1979b(parcel, 10, fjVar.tY, false);
        C0542b.m1960a(parcel, 11, fjVar.qA);
        C0542b.m1980c(parcel, 12, fjVar.orientation);
        C0542b.m1968a(parcel, 13, fjVar.tZ, false);
        C0542b.m1960a(parcel, 14, fjVar.ua);
        C0542b.m1968a(parcel, 15, fjVar.ub, false);
        C0542b.m1968a(parcel, 19, fjVar.ud, false);
        C0542b.m1971a(parcel, 18, fjVar.uc);
        C0542b.m1968a(parcel, 21, fjVar.ue, false);
        C0542b.m1971a(parcel, 23, fjVar.ug);
        C0542b.m1971a(parcel, 22, fjVar.uf);
        C0542b.m1971a(parcel, 25, fjVar.uh);
        C0542b.m1971a(parcel, 24, fjVar.tT);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4604i(parcel);
    }

    public fj m4604i(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        int i2 = 0;
        List list2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        List list3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    list = C0541a.m1916C(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    list2 = C0541a.m1916C(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    list3 = C0541a.m1916C(parcel, F);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    j3 = C0541a.m1935i(parcel, F);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    j4 = C0541a.m1935i(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case 18:
                    z2 = C0541a.m1929c(parcel, F);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    str5 = C0541a.m1941o(parcel, F);
                    break;
                case 21:
                    str6 = C0541a.m1941o(parcel, F);
                    break;
                case 22:
                    z3 = C0541a.m1929c(parcel, F);
                    break;
                case 23:
                    z4 = C0541a.m1929c(parcel, F);
                    break;
                case 24:
                    z5 = C0541a.m1929c(parcel, F);
                    break;
                case 25:
                    z6 = C0541a.m1929c(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new fj(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4605r(i);
    }

    public fj[] m4605r(int i) {
        return new fj[i];
    }
}
