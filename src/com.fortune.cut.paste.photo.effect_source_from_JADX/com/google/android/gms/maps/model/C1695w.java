package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.model.w */
public class C1695w implements Creator<TileOverlayOptions> {
    static void m6246a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0542b.m1962a(parcel, 2, tileOverlayOptions.og(), false);
        C0542b.m1971a(parcel, 3, tileOverlayOptions.isVisible());
        C0542b.m1959a(parcel, 4, tileOverlayOptions.getZIndex());
        C0542b.m1971a(parcel, 5, tileOverlayOptions.getFadeIn());
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dn(parcel);
    }

    public TileOverlayOptions dn(Parcel parcel) {
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        IBinder iBinder = null;
        float f = 0.0f;
        boolean z2 = true;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    iBinder = C0541a.m1942p(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    f = C0541a.m1938l(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    z2 = C0541a.m1929c(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new TileOverlayOptions(i, iBinder, z, f, z2);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public TileOverlayOptions[] fj(int i) {
        return new TileOverlayOptions[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fj(i);
    }
}
