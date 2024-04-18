package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class az implements Creator<ay> {
    static void m4202a(ay ayVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, ayVar.versionCode);
        C0542b.m1968a(parcel, 2, ayVar.op, false);
        C0542b.m1980c(parcel, 3, ayVar.height);
        C0542b.m1980c(parcel, 4, ayVar.heightPixels);
        C0542b.m1971a(parcel, 5, ayVar.oq);
        C0542b.m1980c(parcel, 6, ayVar.width);
        C0542b.m1980c(parcel, 7, ayVar.widthPixels);
        C0542b.m1974a(parcel, 8, ayVar.or, i, false);
        C0542b.m1956H(parcel, H);
    }

    public ay m4203c(Parcel parcel) {
        ay[] ayVarArr = null;
        int i = 0;
        int G = C0541a.m1920G(parcel);
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i5 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i4 = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    ayVarArr = (ay[]) C0541a.m1927b(parcel, F, ay.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ay(i5, str, i4, i3, z, i2, i, ayVarArr);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4203c(parcel);
    }

    public ay[] m4204g(int i) {
        return new ay[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4204g(i);
    }
}
