package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wallet.wobs.CommonWalletObject;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.n */
public class C1870n implements Creator<OfferWalletObject> {
    static void m6797a(OfferWalletObject offerWalletObject, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, offerWalletObject.getVersionCode());
        C0542b.m1968a(parcel, 2, offerWalletObject.fl, false);
        C0542b.m1968a(parcel, 3, offerWalletObject.avN, false);
        C0542b.m1964a(parcel, 4, offerWalletObject.avO, i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dV(parcel);
    }

    public OfferWalletObject dV(Parcel parcel) {
        CommonWalletObject commonWalletObject = null;
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
                    commonWalletObject = (CommonWalletObject) C0541a.m1922a(parcel, F, CommonWalletObject.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OfferWalletObject(i, str, str2, commonWalletObject);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public OfferWalletObject[] gc(int i) {
        return new OfferWalletObject[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gc(i);
    }
}
