package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.internal.z */
public class C1500z implements Creator<C1499y> {
    static void m6077a(C1499y c1499y, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1499y.versionCode);
        C0542b.m1971a(parcel, 2, c1499y.mi);
        C0542b.m1971a(parcel, 3, c1499y.ms);
        C0542b.m1956H(parcel, H);
    }

    public C1499y m6078a(Parcel parcel) {
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    z2 = C0541a.m1929c(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1499y(i, z2, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1499y[] m6079b(int i) {
        return new C1499y[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6078a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6079b(i);
    }
}
