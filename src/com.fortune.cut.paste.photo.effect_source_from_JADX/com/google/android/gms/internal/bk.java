package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
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

public class bk implements Creator<bj> {
    static void m4254a(bj bjVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, bjVar.versionCode);
        C0542b.m1980c(parcel, 2, bjVar.oQ);
        C0542b.m1980c(parcel, 3, bjVar.backgroundColor);
        C0542b.m1980c(parcel, 4, bjVar.oR);
        C0542b.m1980c(parcel, 5, bjVar.oS);
        C0542b.m1980c(parcel, 6, bjVar.oT);
        C0542b.m1980c(parcel, 7, bjVar.oU);
        C0542b.m1980c(parcel, 8, bjVar.oV);
        C0542b.m1980c(parcel, 9, bjVar.oW);
        C0542b.m1968a(parcel, 10, bjVar.oX, false);
        C0542b.m1980c(parcel, 11, bjVar.oY);
        C0542b.m1968a(parcel, 12, bjVar.oZ, false);
        C0542b.m1980c(parcel, 13, bjVar.pa);
        C0542b.m1980c(parcel, 14, bjVar.pb);
        C0542b.m1968a(parcel, 15, bjVar.pc, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4255d(parcel);
    }

    public bj m4255d(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i4 = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i5 = C0541a.m1933g(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    i6 = C0541a.m1933g(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    i7 = C0541a.m1933g(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    i8 = C0541a.m1933g(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    i9 = C0541a.m1933g(parcel, F);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    i10 = C0541a.m1933g(parcel, F);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    i11 = C0541a.m1933g(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    i12 = C0541a.m1933g(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new bj(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public bj[] m4256i(int i) {
        return new bj[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4256i(i);
    }
}
