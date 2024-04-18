package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class aq implements Creator<ap> {
    static void m6965a(ap apVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, apVar.versionCode);
        C0542b.m1980c(parcel, 2, apVar.statusCode);
        C0542b.m1964a(parcel, 3, apVar.axM, i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return eB(parcel);
    }

    public ap eB(Parcel parcel) {
        int i = 0;
        int G = C0541a.m1920G(parcel);
        C1960m c1960m = null;
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
                    c1960m = (C1960m) C0541a.m1922a(parcel, F, C1960m.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ap(i2, i, c1960m);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public ap[] gK(int i) {
        return new ap[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gK(i);
    }
}
