package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.fragment.a */
public class C1860a implements Creator<WalletFragmentInitParams> {
    static void m6787a(WalletFragmentInitParams walletFragmentInitParams, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, walletFragmentInitParams.CK);
        C0542b.m1968a(parcel, 2, walletFragmentInitParams.getAccountName(), false);
        C0542b.m1964a(parcel, 3, walletFragmentInitParams.getMaskedWalletRequest(), i, false);
        C0542b.m1980c(parcel, 4, walletFragmentInitParams.getMaskedWalletRequestCode());
        C0542b.m1964a(parcel, 5, walletFragmentInitParams.getMaskedWallet(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dZ(parcel);
    }

    public WalletFragmentInitParams dZ(Parcel parcel) {
        MaskedWallet maskedWallet = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        int i2 = -1;
        MaskedWalletRequest maskedWalletRequest = null;
        String str = null;
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
                    maskedWalletRequest = (MaskedWalletRequest) C0541a.m1922a(parcel, F, MaskedWalletRequest.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    maskedWallet = (MaskedWallet) C0541a.m1922a(parcel, F, MaskedWallet.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new WalletFragmentInitParams(i, str, maskedWalletRequest, i2, maskedWallet);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public WalletFragmentInitParams[] gh(int i) {
        return new WalletFragmentInitParams[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gh(i);
    }
}
