package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.cast.c */
public class C0486c implements Creator<LaunchOptions> {
    static void m1765a(LaunchOptions launchOptions, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, launchOptions.getVersionCode());
        C0542b.m1971a(parcel, 2, launchOptions.getRelaunchIfRunning());
        C0542b.m1968a(parcel, 3, launchOptions.getLanguage(), false);
        C0542b.m1956H(parcel, H);
    }

    public LaunchOptions[] aa(int i) {
        return new LaunchOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1766w(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return aa(i);
    }

    public LaunchOptions m1766w(Parcel parcel) {
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new LaunchOptions(i, z, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }
}
