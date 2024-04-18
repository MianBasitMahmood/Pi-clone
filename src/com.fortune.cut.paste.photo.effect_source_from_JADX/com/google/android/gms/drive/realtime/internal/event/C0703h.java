package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.h */
public class C0703h implements Creator<ValuesAddedDetails> {
    static void m2456a(ValuesAddedDetails valuesAddedDetails, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, valuesAddedDetails.CK);
        C0542b.m1980c(parcel, 2, valuesAddedDetails.mIndex);
        C0542b.m1980c(parcel, 3, valuesAddedDetails.SO);
        C0542b.m1980c(parcel, 4, valuesAddedDetails.SP);
        C0542b.m1968a(parcel, 5, valuesAddedDetails.Tk, false);
        C0542b.m1980c(parcel, 6, valuesAddedDetails.Tl);
        C0542b.m1956H(parcel, H);
    }

    public ValuesAddedDetails bn(Parcel parcel) {
        int i = 0;
        int G = C0541a.m1920G(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i5 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i4 = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str = C0541a.m1941o(parcel, F);
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
            return new ValuesAddedDetails(i5, i4, i3, i2, str, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public ValuesAddedDetails[] cD(int i) {
        return new ValuesAddedDetails[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bn(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cD(i);
    }
}
