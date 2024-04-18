package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.f */
public class C1849f implements Creator<FullWallet> {
    static void m6714a(FullWallet fullWallet, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, fullWallet.getVersionCode());
        C0542b.m1968a(parcel, 2, fullWallet.auL, false);
        C0542b.m1968a(parcel, 3, fullWallet.auM, false);
        C0542b.m1964a(parcel, 4, fullWallet.auN, i, false);
        C0542b.m1968a(parcel, 5, fullWallet.auO, false);
        C0542b.m1964a(parcel, 6, fullWallet.auP, i, false);
        C0542b.m1964a(parcel, 7, fullWallet.auQ, i, false);
        C0542b.m1975a(parcel, 8, fullWallet.auR, false);
        C0542b.m1964a(parcel, 9, fullWallet.auS, i, false);
        C0542b.m1964a(parcel, 10, fullWallet.auT, i, false);
        C0542b.m1974a(parcel, 11, fullWallet.auU, i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dN(parcel);
    }

    public FullWallet dN(Parcel parcel) {
        InstrumentInfo[] instrumentInfoArr = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        String[] strArr = null;
        Address address = null;
        Address address2 = null;
        String str = null;
        ProxyCard proxyCard = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    proxyCard = (ProxyCard) C0541a.m1922a(parcel, F, ProxyCard.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    address2 = (Address) C0541a.m1922a(parcel, F, Address.CREATOR);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    address = (Address) C0541a.m1922a(parcel, F, Address.CREATOR);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    strArr = C0541a.m1914A(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    userAddress2 = (UserAddress) C0541a.m1922a(parcel, F, UserAddress.CREATOR);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    userAddress = (UserAddress) C0541a.m1922a(parcel, F, UserAddress.CREATOR);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    instrumentInfoArr = (InstrumentInfo[]) C0541a.m1927b(parcel, F, InstrumentInfo.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new FullWallet(i, str3, str2, proxyCard, str, address2, address, strArr, userAddress2, userAddress, instrumentInfoArr);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public FullWallet[] fU(int i) {
        return new FullWallet[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fU(i);
    }
}
