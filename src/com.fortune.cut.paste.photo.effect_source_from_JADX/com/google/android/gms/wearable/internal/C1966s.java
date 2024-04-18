package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.C1901c;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wearable.internal.s */
public class C1966s implements Creator<C1965r> {
    static void m7039a(C1965r c1965r, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1965r.versionCode);
        C0542b.m1980c(parcel, 2, c1965r.statusCode);
        C0542b.m1964a(parcel, 3, c1965r.axJ, i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return es(parcel);
    }

    public C1965r es(Parcel parcel) {
        int i = 0;
        int G = C0541a.m1920G(parcel);
        C1901c c1901c = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    c1901c = (C1901c) C0541a.m1922a(parcel, F, C1901c.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1965r(i2, i, c1901c);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1965r[] gB(int i) {
        return new C1965r[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gB(i);
    }
}
