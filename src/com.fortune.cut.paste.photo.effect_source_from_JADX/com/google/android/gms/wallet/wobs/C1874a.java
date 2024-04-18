package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.internal.la;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.wobs.a */
public class C1874a implements Creator<CommonWalletObject> {
    static void m6799a(CommonWalletObject commonWalletObject, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, commonWalletObject.getVersionCode());
        C0542b.m1968a(parcel, 2, commonWalletObject.fl, false);
        C0542b.m1968a(parcel, 3, commonWalletObject.avk, false);
        C0542b.m1968a(parcel, 4, commonWalletObject.name, false);
        C0542b.m1968a(parcel, 5, commonWalletObject.ave, false);
        C0542b.m1968a(parcel, 6, commonWalletObject.avg, false);
        C0542b.m1968a(parcel, 7, commonWalletObject.avh, false);
        C0542b.m1968a(parcel, 8, commonWalletObject.avi, false);
        C0542b.m1968a(parcel, 9, commonWalletObject.avj, false);
        C0542b.m1980c(parcel, 10, commonWalletObject.state);
        C0542b.m1981c(parcel, 11, commonWalletObject.avl, false);
        C0542b.m1964a(parcel, 12, commonWalletObject.avm, i, false);
        C0542b.m1981c(parcel, 13, commonWalletObject.avn, false);
        C0542b.m1968a(parcel, 14, commonWalletObject.avo, false);
        C0542b.m1968a(parcel, 15, commonWalletObject.avp, false);
        C0542b.m1971a(parcel, 17, commonWalletObject.avr);
        C0542b.m1981c(parcel, 16, commonWalletObject.avq, false);
        C0542b.m1981c(parcel, 19, commonWalletObject.avt, false);
        C0542b.m1981c(parcel, 18, commonWalletObject.avs, false);
        C0542b.m1981c(parcel, 20, commonWalletObject.avu, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ec(parcel);
    }

    public CommonWalletObject ec(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        int i2 = 0;
        ArrayList ie = la.ie();
        C1885l c1885l = null;
        ArrayList ie2 = la.ie();
        String str9 = null;
        String str10 = null;
        ArrayList ie3 = la.ie();
        boolean z = false;
        ArrayList ie4 = la.ie();
        ArrayList ie5 = la.ie();
        ArrayList ie6 = la.ie();
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
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    str5 = C0541a.m1941o(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    str6 = C0541a.m1941o(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    str7 = C0541a.m1941o(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    str8 = C0541a.m1941o(parcel, F);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    ie = C0541a.m1928c(parcel, F, C1889p.CREATOR);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    c1885l = (C1885l) C0541a.m1922a(parcel, F, C1885l.CREATOR);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    ie2 = C0541a.m1928c(parcel, F, LatLng.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    str9 = C0541a.m1941o(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    str10 = C0541a.m1941o(parcel, F);
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    ie3 = C0541a.m1928c(parcel, F, C1877d.CREATOR);
                    break;
                case 17:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case 18:
                    ie4 = C0541a.m1928c(parcel, F, C1887n.CREATOR);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    ie5 = C0541a.m1928c(parcel, F, C1883j.CREATOR);
                    break;
                case 20:
                    ie6 = C0541a.m1928c(parcel, F, C1887n.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CommonWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, i2, ie, c1885l, ie2, str9, str10, ie3, z, ie4, ie5, ie6);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public CommonWalletObject[] gl(int i) {
        return new CommonWalletObject[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gl(i);
    }
}
