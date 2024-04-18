package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class ip implements Creator<io> {
    static void m5031a(io ioVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, ioVar.getVersionCode());
        C0542b.m1958a(parcel, 2, ioVar.fZ());
        C0542b.m1971a(parcel, 3, ioVar.gi());
        C0542b.m1980c(parcel, 4, ioVar.gj());
        C0542b.m1964a(parcel, 5, ioVar.getApplicationMetadata(), i, false);
        C0542b.m1980c(parcel, 6, ioVar.gk());
        C0542b.m1956H(parcel, H);
    }

    public io[] ai(int i) {
        return new io[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5032y(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return ai(i);
    }

    public io m5032y(Parcel parcel) {
        int i = 0;
        int G = C0541a.m1920G(parcel);
        double d = 0.0d;
        ApplicationMetadata applicationMetadata = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    d = C0541a.m1939m(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    applicationMetadata = (ApplicationMetadata) C0541a.m1922a(parcel, F, ApplicationMetadata.CREATOR);
                    break;
                case Error.OTHER /*6*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new io(i3, d, z, i2, applicationMetadata, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }
}
