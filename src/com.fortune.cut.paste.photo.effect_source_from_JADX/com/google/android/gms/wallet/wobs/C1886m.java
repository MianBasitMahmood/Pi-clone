package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.wobs.m */
public class C1886m implements Creator<C1885l> {
    static void m6805a(C1885l c1885l, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1885l.getVersionCode());
        C0542b.m1960a(parcel, 2, c1885l.awU);
        C0542b.m1960a(parcel, 3, c1885l.awV);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ei(parcel);
    }

    public C1885l ei(Parcel parcel) {
        long j = 0;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1885l(i, j2, j);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1885l[] gr(int i) {
        return new C1885l[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gr(i);
    }
}
