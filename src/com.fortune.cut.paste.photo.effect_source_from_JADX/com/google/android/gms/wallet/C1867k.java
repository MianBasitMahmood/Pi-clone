package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0366R;
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

/* renamed from: com.google.android.gms.wallet.k */
public class C1867k implements Creator<MaskedWallet> {
    static void m6794a(MaskedWallet maskedWallet, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, maskedWallet.getVersionCode());
        C0542b.m1968a(parcel, 2, maskedWallet.auL, false);
        C0542b.m1968a(parcel, 3, maskedWallet.auM, false);
        C0542b.m1975a(parcel, 4, maskedWallet.auR, false);
        C0542b.m1968a(parcel, 5, maskedWallet.auO, false);
        C0542b.m1964a(parcel, 6, maskedWallet.auP, i, false);
        C0542b.m1964a(parcel, 7, maskedWallet.auQ, i, false);
        C0542b.m1974a(parcel, 8, maskedWallet.avw, i, false);
        C0542b.m1974a(parcel, 9, maskedWallet.avx, i, false);
        C0542b.m1964a(parcel, 10, maskedWallet.auS, i, false);
        C0542b.m1964a(parcel, 11, maskedWallet.auT, i, false);
        C0542b.m1974a(parcel, 12, maskedWallet.auU, i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dS(parcel);
    }

    public MaskedWallet dS(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String[] strArr = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        LoyaltyWalletObject[] loyaltyWalletObjectArr = null;
        OfferWalletObject[] offerWalletObjectArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
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
                    strArr = C0541a.m1914A(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    address = (Address) C0541a.m1922a(parcel, F, Address.CREATOR);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    address2 = (Address) C0541a.m1922a(parcel, F, Address.CREATOR);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    loyaltyWalletObjectArr = (LoyaltyWalletObject[]) C0541a.m1927b(parcel, F, LoyaltyWalletObject.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    offerWalletObjectArr = (OfferWalletObject[]) C0541a.m1927b(parcel, F, OfferWalletObject.CREATOR);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    userAddress = (UserAddress) C0541a.m1922a(parcel, F, UserAddress.CREATOR);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    userAddress2 = (UserAddress) C0541a.m1922a(parcel, F, UserAddress.CREATOR);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    instrumentInfoArr = (InstrumentInfo[]) C0541a.m1927b(parcel, F, InstrumentInfo.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new MaskedWallet(i, str, str2, strArr, str3, address, address2, loyaltyWalletObjectArr, offerWalletObjectArr, userAddress, userAddress2, instrumentInfoArr);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public MaskedWallet[] fZ(int i) {
        return new MaskedWallet[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fZ(i);
    }
}
