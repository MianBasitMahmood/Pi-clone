package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.common.data.b */
public class C0523b implements Creator<C0522a> {
    static void m1874a(C0522a c0522a, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c0522a.CK);
        C0542b.m1964a(parcel, 2, c0522a.KS, i, false);
        C0542b.m1980c(parcel, 3, c0522a.Gt);
        C0542b.m1956H(parcel, H);
    }

    public C0522a m1875A(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0541a.m1922a(parcel, F, ParcelFileDescriptor.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C0522a(i, parcelFileDescriptor, i2);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C0522a[] ar(int i) {
        return new C0522a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1875A(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return ar(i);
    }
}
