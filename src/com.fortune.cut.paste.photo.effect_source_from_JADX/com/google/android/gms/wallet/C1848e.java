package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.e */
public class C1848e implements Creator<C1847d> {
    static void m6713a(C1847d c1847d, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1847d.getVersionCode());
        C0542b.m1964a(parcel, 2, c1847d.auJ, i, false);
        C0542b.m1964a(parcel, 3, c1847d.auK, i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dM(parcel);
    }

    public C1847d dM(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        LoyaltyWalletObject loyaltyWalletObject = null;
        int i = 0;
        OfferWalletObject offerWalletObject = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    loyaltyWalletObject = (LoyaltyWalletObject) C0541a.m1922a(parcel, F, LoyaltyWalletObject.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    offerWalletObject = (OfferWalletObject) C0541a.m1922a(parcel, F, OfferWalletObject.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1847d(i, loyaltyWalletObject, offerWalletObject);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1847d[] fT(int i) {
        return new C1847d[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fT(i);
    }
}
