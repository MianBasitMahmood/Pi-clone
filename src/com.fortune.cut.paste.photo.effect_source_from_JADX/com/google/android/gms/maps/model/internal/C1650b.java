package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.model.internal.b */
public class C1650b implements Creator<C1649a> {
    static void m6201a(C1649a c1649a, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1649a.getVersionCode());
        C0542b.m1957a(parcel, 2, c1649a.oh());
        C0542b.m1961a(parcel, 3, c1649a.oi(), false);
        C0542b.m1964a(parcel, 4, c1649a.getBitmap(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dp(parcel);
    }

    public C1649a dp(Parcel parcel) {
        Bitmap bitmap = null;
        int G = C0541a.m1920G(parcel);
        byte b = (byte) 0;
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    b = C0541a.m1931e(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    bundle = C0541a.m1943q(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    bitmap = (Bitmap) C0541a.m1922a(parcel, F, Bitmap.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1649a(i, b, bundle, bitmap);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1649a[] fl(int i) {
        return new C1649a[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fl(i);
    }
}
