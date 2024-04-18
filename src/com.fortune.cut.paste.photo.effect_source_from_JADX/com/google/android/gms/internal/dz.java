package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class dz implements Creator<ea> {
    static void m4479a(ea eaVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, eaVar.versionCode);
        C0542b.m1962a(parcel, 3, eaVar.cu(), false);
        C0542b.m1962a(parcel, 4, eaVar.cv(), false);
        C0542b.m1962a(parcel, 5, eaVar.cw(), false);
        C0542b.m1962a(parcel, 6, eaVar.ct(), false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4480g(parcel);
    }

    public ea m4480g(Parcel parcel) {
        IBinder iBinder = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    iBinder4 = C0541a.m1942p(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    iBinder3 = C0541a.m1942p(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    iBinder2 = C0541a.m1942p(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    iBinder = C0541a.m1942p(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ea(i, iBinder4, iBinder3, iBinder2, iBinder);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4481o(i);
    }

    public ea[] m4481o(int i) {
        return new ea[i];
    }
}
