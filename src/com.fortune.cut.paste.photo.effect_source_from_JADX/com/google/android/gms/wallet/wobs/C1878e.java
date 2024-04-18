package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.internal.la;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.wobs.e */
public class C1878e implements Creator<C1877d> {
    static void m6801a(C1877d c1877d, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1877d.getVersionCode());
        C0542b.m1968a(parcel, 2, c1877d.awJ, false);
        C0542b.m1968a(parcel, 3, c1877d.awK, false);
        C0542b.m1981c(parcel, 4, c1877d.awL, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ee(parcel);
    }

    public C1877d ee(Parcel parcel) {
        String str = null;
        int G = C0541a.m1920G(parcel);
        ArrayList ie = la.ie();
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
                    ie = C0541a.m1928c(parcel, F, C1875b.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1877d(i, str2, str, ie);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1877d[] gn(int i) {
        return new C1877d[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gn(i);
    }
}
