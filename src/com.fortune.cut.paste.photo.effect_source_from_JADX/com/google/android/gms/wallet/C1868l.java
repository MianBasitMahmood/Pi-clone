package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.l */
public class C1868l implements Creator<MaskedWalletRequest> {
    static void m6795a(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, maskedWalletRequest.getVersionCode());
        C0542b.m1968a(parcel, 2, maskedWalletRequest.auM, false);
        C0542b.m1971a(parcel, 3, maskedWalletRequest.avz);
        C0542b.m1971a(parcel, 4, maskedWalletRequest.avA);
        C0542b.m1971a(parcel, 5, maskedWalletRequest.avB);
        C0542b.m1968a(parcel, 6, maskedWalletRequest.avC, false);
        C0542b.m1968a(parcel, 7, maskedWalletRequest.auG, false);
        C0542b.m1968a(parcel, 8, maskedWalletRequest.avD, false);
        C0542b.m1964a(parcel, 9, maskedWalletRequest.auV, i, false);
        C0542b.m1971a(parcel, 10, maskedWalletRequest.avE);
        C0542b.m1971a(parcel, 11, maskedWalletRequest.avF);
        C0542b.m1974a(parcel, 12, maskedWalletRequest.avG, i, false);
        C0542b.m1971a(parcel, 13, maskedWalletRequest.avH);
        C0542b.m1971a(parcel, 14, maskedWalletRequest.avI);
        C0542b.m1981c(parcel, 15, maskedWalletRequest.avJ, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dT(parcel);
    }

    public MaskedWalletRequest dT(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Cart cart = null;
        boolean z4 = false;
        boolean z5 = false;
        CountrySpecification[] countrySpecificationArr = null;
        boolean z6 = true;
        boolean z7 = true;
        ArrayList arrayList = null;
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
                    z = C0541a.m1929c(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    z2 = C0541a.m1929c(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    z3 = C0541a.m1929c(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    cart = (Cart) C0541a.m1922a(parcel, F, Cart.CREATOR);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    z4 = C0541a.m1929c(parcel, F);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    z5 = C0541a.m1929c(parcel, F);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    countrySpecificationArr = (CountrySpecification[]) C0541a.m1927b(parcel, F, CountrySpecification.CREATOR);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    z6 = C0541a.m1929c(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    z7 = C0541a.m1929c(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    arrayList = C0541a.m1928c(parcel, F, CountrySpecification.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new MaskedWalletRequest(i, str, z, z2, z3, str2, str3, str4, cart, z4, z5, countrySpecificationArr, z6, z7, arrayList);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public MaskedWalletRequest[] ga(int i) {
        return new MaskedWalletRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return ga(i);
    }
}
