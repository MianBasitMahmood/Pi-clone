package com.google.android.gms.wallet;

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
import com.google.android.gms.wallet.wobs.C1877d;
import com.google.android.gms.wallet.wobs.C1879f;
import com.google.android.gms.wallet.wobs.C1883j;
import com.google.android.gms.wallet.wobs.C1885l;
import com.google.android.gms.wallet.wobs.C1887n;
import com.google.android.gms.wallet.wobs.C1889p;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.j */
public class C1866j implements Creator<LoyaltyWalletObject> {
    static void m6793a(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, loyaltyWalletObject.getVersionCode());
        C0542b.m1968a(parcel, 2, loyaltyWalletObject.fl, false);
        C0542b.m1968a(parcel, 3, loyaltyWalletObject.avd, false);
        C0542b.m1968a(parcel, 4, loyaltyWalletObject.ave, false);
        C0542b.m1968a(parcel, 5, loyaltyWalletObject.avf, false);
        C0542b.m1968a(parcel, 6, loyaltyWalletObject.aki, false);
        C0542b.m1968a(parcel, 7, loyaltyWalletObject.avg, false);
        C0542b.m1968a(parcel, 8, loyaltyWalletObject.avh, false);
        C0542b.m1968a(parcel, 9, loyaltyWalletObject.avi, false);
        C0542b.m1968a(parcel, 10, loyaltyWalletObject.avj, false);
        C0542b.m1968a(parcel, 11, loyaltyWalletObject.avk, false);
        C0542b.m1980c(parcel, 12, loyaltyWalletObject.state);
        C0542b.m1981c(parcel, 13, loyaltyWalletObject.avl, false);
        C0542b.m1964a(parcel, 14, loyaltyWalletObject.avm, i, false);
        C0542b.m1981c(parcel, 15, loyaltyWalletObject.avn, false);
        C0542b.m1968a(parcel, 17, loyaltyWalletObject.avp, false);
        C0542b.m1968a(parcel, 16, loyaltyWalletObject.avo, false);
        C0542b.m1971a(parcel, 19, loyaltyWalletObject.avr);
        C0542b.m1981c(parcel, 18, loyaltyWalletObject.avq, false);
        C0542b.m1981c(parcel, 21, loyaltyWalletObject.avt, false);
        C0542b.m1981c(parcel, 20, loyaltyWalletObject.avs, false);
        C0542b.m1964a(parcel, 23, loyaltyWalletObject.avv, i, false);
        C0542b.m1981c(parcel, 22, loyaltyWalletObject.avu, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dR(parcel);
    }

    public LoyaltyWalletObject dR(Parcel parcel) {
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
        String str9 = null;
        String str10 = null;
        int i2 = 0;
        ArrayList ie = la.ie();
        C1885l c1885l = null;
        ArrayList ie2 = la.ie();
        String str11 = null;
        String str12 = null;
        ArrayList ie3 = la.ie();
        boolean z = false;
        ArrayList ie4 = la.ie();
        ArrayList ie5 = la.ie();
        ArrayList ie6 = la.ie();
        C1879f c1879f = null;
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
                    str9 = C0541a.m1941o(parcel, F);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    str10 = C0541a.m1941o(parcel, F);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    ie = C0541a.m1928c(parcel, F, C1889p.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    c1885l = (C1885l) C0541a.m1922a(parcel, F, C1885l.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    ie2 = C0541a.m1928c(parcel, F, LatLng.CREATOR);
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    str11 = C0541a.m1941o(parcel, F);
                    break;
                case 17:
                    str12 = C0541a.m1941o(parcel, F);
                    break;
                case 18:
                    ie3 = C0541a.m1928c(parcel, F, C1877d.CREATOR);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case 20:
                    ie4 = C0541a.m1928c(parcel, F, C1887n.CREATOR);
                    break;
                case 21:
                    ie5 = C0541a.m1928c(parcel, F, C1883j.CREATOR);
                    break;
                case 22:
                    ie6 = C0541a.m1928c(parcel, F, C1887n.CREATOR);
                    break;
                case 23:
                    c1879f = (C1879f) C0541a.m1922a(parcel, F, C1879f.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new LoyaltyWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i2, ie, c1885l, ie2, str11, str12, ie3, z, ie4, ie5, ie6, c1879f);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public LoyaltyWalletObject[] fY(int i) {
        return new LoyaltyWalletObject[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fY(i);
    }
}
