package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class ac implements Creator<ab> {
    static void m6860a(ab abVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, abVar.versionCode);
        C0542b.m1980c(parcel, 2, abVar.statusCode);
        C0542b.m1964a(parcel, 3, abVar.axO, i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ex(parcel);
    }

    public ab ex(Parcel parcel) {
        int i = 0;
        int G = C0541a.m1920G(parcel);
        al alVar = null;
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
                    alVar = (al) C0541a.m1922a(parcel, F, al.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ab(i2, i, alVar);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public ab[] gG(int i) {
        return new ab[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gG(i);
    }
}
