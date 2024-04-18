package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.b */
public class C1845b implements Creator<Cart> {
    static void m6711a(Cart cart, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, cart.getVersionCode());
        C0542b.m1968a(parcel, 2, cart.auF, false);
        C0542b.m1968a(parcel, 3, cart.auG, false);
        C0542b.m1981c(parcel, 4, cart.auH, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dK(parcel);
    }

    public Cart dK(Parcel parcel) {
        String str = null;
        int G = C0541a.m1920G(parcel);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    arrayList = C0541a.m1928c(parcel, F, LineItem.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Cart(i, str2, str, arrayList);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public Cart[] fR(int i) {
        return new Cart[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fR(i);
    }
}
