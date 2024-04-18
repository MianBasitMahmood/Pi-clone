package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.g */
public class C1863g implements Creator<FullWalletRequest> {
    static void m6790a(FullWalletRequest fullWalletRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, fullWalletRequest.getVersionCode());
        C0542b.m1968a(parcel, 2, fullWalletRequest.auL, false);
        C0542b.m1968a(parcel, 3, fullWalletRequest.auM, false);
        C0542b.m1964a(parcel, 4, fullWalletRequest.auV, i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dO(parcel);
    }

    public FullWalletRequest dO(Parcel parcel) {
        Cart cart = null;
        int G = C0541a.m1920G(parcel);
        String str = null;
        int i = 0;
        String str2 = null;
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
                    cart = (Cart) C0541a.m1922a(parcel, F, Cart.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new FullWalletRequest(i, str, str2, cart);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public FullWalletRequest[] fV(int i) {
        return new FullWalletRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fV(i);
    }
}
