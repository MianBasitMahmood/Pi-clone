package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.model.u */
public class C1693u implements Creator<Tile> {
    static void m6244a(Tile tile, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, tile.getVersionCode());
        C0542b.m1980c(parcel, 2, tile.width);
        C0542b.m1980c(parcel, 3, tile.height);
        C0542b.m1972a(parcel, 4, tile.data, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dm(parcel);
    }

    public Tile dm(Parcel parcel) {
        int i = 0;
        int G = C0541a.m1920G(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    bArr = C0541a.m1944r(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Tile(i3, i2, i, bArr);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public Tile[] fi(int i) {
        return new Tile[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fi(i);
    }
}
