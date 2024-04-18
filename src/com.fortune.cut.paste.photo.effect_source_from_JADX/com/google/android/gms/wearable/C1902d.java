package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;

/* renamed from: com.google.android.gms.wearable.d */
public class C1902d implements Creator<C1901c> {
    static void m6835a(C1901c c1901c, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1901c.CK);
        C0542b.m1968a(parcel, 2, c1901c.getName(), false);
        C0542b.m1968a(parcel, 3, c1901c.getAddress(), false);
        C0542b.m1980c(parcel, 4, c1901c.getType());
        C0542b.m1980c(parcel, 5, c1901c.getRole());
        C0542b.m1971a(parcel, 6, c1901c.isEnabled());
        C0542b.m1971a(parcel, 7, c1901c.isConnected());
        C0542b.m1968a(parcel, 8, c1901c.rj(), false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return em(parcel);
    }

    public C1901c em(Parcel parcel) {
        String str = null;
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    z2 = C0541a.m1929c(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1901c(i3, str3, str2, i2, i, z2, z, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1901c[] gv(int i) {
        return new C1901c[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gv(i);
    }
}
