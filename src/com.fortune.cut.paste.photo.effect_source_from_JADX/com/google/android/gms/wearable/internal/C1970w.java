package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.wearable.internal.w */
public class C1970w implements Creator<C1969v> {
    static void m7041a(C1969v c1969v, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1969v.versionCode);
        C0542b.m1980c(parcel, 2, c1969v.statusCode);
        C0542b.m1981c(parcel, 3, c1969v.axL, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return eu(parcel);
    }

    public C1969v eu(Parcel parcel) {
        int i = 0;
        int G = C0541a.m1920G(parcel);
        List list = null;
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
                    list = C0541a.m1928c(parcel, F, al.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1969v(i2, i, list);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1969v[] gD(int i) {
        return new C1969v[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gD(i);
    }
}
