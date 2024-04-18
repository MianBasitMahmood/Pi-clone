package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class pz implements Creator<py> {
    static void m5815a(py pyVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, pyVar.getVersionCode());
        C0542b.m1975a(parcel, 2, pyVar.avY, false);
        C0542b.m1976a(parcel, 3, pyVar.avZ, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dY(parcel);
    }

    public py dY(Parcel parcel) {
        byte[][] bArr = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String[] strArr = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    strArr = C0541a.m1914A(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    bArr = C0541a.m1945s(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new py(i, strArr, bArr);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public py[] gf(int i) {
        return new py[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gf(i);
    }
}
