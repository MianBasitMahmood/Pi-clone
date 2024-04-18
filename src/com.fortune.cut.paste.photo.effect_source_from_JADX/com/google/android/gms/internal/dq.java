package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class dq implements Creator<dr> {
    static void m4456a(dr drVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, drVar.versionCode);
        C0542b.m1964a(parcel, 2, drVar.sb, i, false);
        C0542b.m1962a(parcel, 3, drVar.ck(), false);
        C0542b.m1962a(parcel, 4, drVar.cl(), false);
        C0542b.m1962a(parcel, 5, drVar.cm(), false);
        C0542b.m1962a(parcel, 6, drVar.cn(), false);
        C0542b.m1968a(parcel, 7, drVar.sg, false);
        C0542b.m1971a(parcel, 8, drVar.sh);
        C0542b.m1968a(parcel, 9, drVar.si, false);
        C0542b.m1962a(parcel, 10, drVar.cp(), false);
        C0542b.m1980c(parcel, 11, drVar.orientation);
        C0542b.m1980c(parcel, 12, drVar.sk);
        C0542b.m1968a(parcel, 13, drVar.rH, false);
        C0542b.m1964a(parcel, 14, drVar.lO, i, false);
        C0542b.m1962a(parcel, 15, drVar.co(), false);
        C0542b.m1964a(parcel, 17, drVar.sn, i, false);
        C0542b.m1968a(parcel, 16, drVar.sm, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4457f(parcel);
    }

    public dr m4457f(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        C1089do c1089do = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        gs gsVar = null;
        IBinder iBinder6 = null;
        String str4 = null;
        C1499y c1499y = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    c1089do = (C1089do) C0541a.m1922a(parcel, F, C1089do.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    iBinder = C0541a.m1942p(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    iBinder2 = C0541a.m1942p(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    iBinder3 = C0541a.m1942p(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    iBinder4 = C0541a.m1942p(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    iBinder5 = C0541a.m1942p(parcel, F);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    gsVar = (gs) C0541a.m1922a(parcel, F, gs.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    iBinder6 = C0541a.m1942p(parcel, F);
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case 17:
                    c1499y = (C1499y) C0541a.m1922a(parcel, F, C1499y.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new dr(i, c1089do, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, gsVar, iBinder6, str4, c1499y);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public dr[] m4458n(int i) {
        return new dr[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4458n(i);
    }
}
