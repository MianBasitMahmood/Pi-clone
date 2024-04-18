package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.fragment.b */
public class C1861b implements Creator<WalletFragmentOptions> {
    static void m6788a(WalletFragmentOptions walletFragmentOptions, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, walletFragmentOptions.CK);
        C0542b.m1980c(parcel, 2, walletFragmentOptions.getEnvironment());
        C0542b.m1980c(parcel, 3, walletFragmentOptions.getTheme());
        C0542b.m1964a(parcel, 4, walletFragmentOptions.getFragmentStyle(), i, false);
        C0542b.m1980c(parcel, 5, walletFragmentOptions.getMode());
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ea(parcel);
    }

    public WalletFragmentOptions ea(Parcel parcel) {
        int i = 1;
        int i2 = 0;
        int G = C0541a.m1920G(parcel);
        WalletFragmentStyle walletFragmentStyle = null;
        int i3 = 1;
        int i4 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i4 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    walletFragmentStyle = (WalletFragmentStyle) C0541a.m1922a(parcel, F, WalletFragmentStyle.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new WalletFragmentOptions(i4, i3, i2, walletFragmentStyle, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public WalletFragmentOptions[] gi(int i) {
        return new WalletFragmentOptions[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gi(i);
    }
}
