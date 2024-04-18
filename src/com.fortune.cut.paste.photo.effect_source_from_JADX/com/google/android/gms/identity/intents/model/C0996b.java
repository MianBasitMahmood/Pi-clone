package com.google.android.gms.identity.intents.model;

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

/* renamed from: com.google.android.gms.identity.intents.model.b */
public class C0996b implements Creator<UserAddress> {
    static void m4107a(UserAddress userAddress, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, userAddress.getVersionCode());
        C0542b.m1968a(parcel, 2, userAddress.name, false);
        C0542b.m1968a(parcel, 3, userAddress.afK, false);
        C0542b.m1968a(parcel, 4, userAddress.afL, false);
        C0542b.m1968a(parcel, 5, userAddress.afM, false);
        C0542b.m1968a(parcel, 6, userAddress.afN, false);
        C0542b.m1968a(parcel, 7, userAddress.afO, false);
        C0542b.m1968a(parcel, 8, userAddress.afP, false);
        C0542b.m1968a(parcel, 9, userAddress.afQ, false);
        C0542b.m1968a(parcel, 10, userAddress.vk, false);
        C0542b.m1968a(parcel, 11, userAddress.afR, false);
        C0542b.m1968a(parcel, 12, userAddress.afS, false);
        C0542b.m1968a(parcel, 13, userAddress.afT, false);
        C0542b.m1971a(parcel, 14, userAddress.afU);
        C0542b.m1968a(parcel, 15, userAddress.afV, false);
        C0542b.m1968a(parcel, 16, userAddress.afW, false);
        C0542b.m1956H(parcel, H);
    }

    public UserAddress cH(Parcel parcel) {
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
        String str11 = null;
        String str12 = null;
        boolean z = false;
        String str13 = null;
        String str14 = null;
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
                    str11 = C0541a.m1941o(parcel, F);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    str12 = C0541a.m1941o(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    str13 = C0541a.m1941o(parcel, F);
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    str14 = C0541a.m1941o(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new UserAddress(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, z, str13, str14);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cH(parcel);
    }

    public UserAddress[] eu(int i) {
        return new UserAddress[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eu(i);
    }
}
