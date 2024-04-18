package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
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
import java.util.List;

public class fi implements Creator<fh> {
    static void m4600a(fh fhVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, fhVar.versionCode);
        C0542b.m1961a(parcel, 2, fhVar.tK, false);
        C0542b.m1964a(parcel, 3, fhVar.tL, i, false);
        C0542b.m1964a(parcel, 4, fhVar.lS, i, false);
        C0542b.m1968a(parcel, 5, fhVar.lL, false);
        C0542b.m1964a(parcel, 6, fhVar.applicationInfo, i, false);
        C0542b.m1964a(parcel, 7, fhVar.tM, i, false);
        C0542b.m1968a(parcel, 8, fhVar.tN, false);
        C0542b.m1968a(parcel, 9, fhVar.tO, false);
        C0542b.m1968a(parcel, 10, fhVar.tP, false);
        C0542b.m1964a(parcel, 11, fhVar.lO, i, false);
        C0542b.m1961a(parcel, 12, fhVar.tQ, false);
        C0542b.m1980c(parcel, 13, fhVar.tR);
        C0542b.m1979b(parcel, 14, fhVar.mc, false);
        C0542b.m1961a(parcel, 15, fhVar.tS, false);
        C0542b.m1971a(parcel, 16, fhVar.tT);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4601h(parcel);
    }

    public fh m4601h(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        Bundle bundle = null;
        av avVar = null;
        ay ayVar = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        gs gsVar = null;
        Bundle bundle2 = null;
        int i2 = 0;
        List list = null;
        Bundle bundle3 = null;
        boolean z = false;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    bundle = C0541a.m1943q(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    avVar = (av) C0541a.m1922a(parcel, F, av.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    ayVar = (ay) C0541a.m1922a(parcel, F, ay.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    applicationInfo = (ApplicationInfo) C0541a.m1922a(parcel, F, ApplicationInfo.CREATOR);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    packageInfo = (PackageInfo) C0541a.m1922a(parcel, F, PackageInfo.CREATOR);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    gsVar = (gs) C0541a.m1922a(parcel, F, gs.CREATOR);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    bundle2 = C0541a.m1943q(parcel, F);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    list = C0541a.m1916C(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    bundle3 = C0541a.m1943q(parcel, F);
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new fh(i, bundle, avVar, ayVar, str, applicationInfo, packageInfo, str2, str3, str4, gsVar, bundle2, i2, list, bundle3, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4602q(i);
    }

    public fh[] m4602q(int i) {
        return new fh[i];
    }
}
