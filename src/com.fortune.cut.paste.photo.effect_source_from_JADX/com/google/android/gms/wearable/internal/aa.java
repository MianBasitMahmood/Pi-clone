package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class aa implements Creator<C1973z> {
    static void m6859a(C1973z c1973z, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1973z.versionCode);
        C0542b.m1980c(parcel, 2, c1973z.statusCode);
        C0542b.m1964a(parcel, 3, c1973z.axN, i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ew(parcel);
    }

    public C1973z ew(Parcel parcel) {
        int i = 0;
        int G = C0541a.m1920G(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
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
                    parcelFileDescriptor = (ParcelFileDescriptor) C0541a.m1922a(parcel, F, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1973z(i2, i, parcelFileDescriptor);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1973z[] gF(int i) {
        return new C1973z[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gF(i);
    }
}
