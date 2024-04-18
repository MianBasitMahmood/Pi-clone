package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.i */
public class C1865i implements Creator<LineItem> {
    static void m6792a(LineItem lineItem, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, lineItem.getVersionCode());
        C0542b.m1968a(parcel, 2, lineItem.description, false);
        C0542b.m1968a(parcel, 3, lineItem.auZ, false);
        C0542b.m1968a(parcel, 4, lineItem.ava, false);
        C0542b.m1968a(parcel, 5, lineItem.auF, false);
        C0542b.m1980c(parcel, 6, lineItem.avb);
        C0542b.m1968a(parcel, 7, lineItem.auG, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dQ(parcel);
    }

    public LineItem dQ(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = C0541a.m1920G(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str5 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new LineItem(i2, str5, str4, str3, str2, i, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public LineItem[] fX(int i) {
        return new LineItem[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fX(i);
    }
}
