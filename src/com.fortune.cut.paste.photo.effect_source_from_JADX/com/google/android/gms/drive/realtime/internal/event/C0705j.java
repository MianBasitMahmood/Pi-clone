package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.j */
public class C0705j implements Creator<ValuesSetDetails> {
    static void m2458a(ValuesSetDetails valuesSetDetails, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, valuesSetDetails.CK);
        C0542b.m1980c(parcel, 2, valuesSetDetails.mIndex);
        C0542b.m1980c(parcel, 3, valuesSetDetails.SO);
        C0542b.m1980c(parcel, 4, valuesSetDetails.SP);
        C0542b.m1956H(parcel, H);
    }

    public ValuesSetDetails bp(Parcel parcel) {
        int i = 0;
        int G = C0541a.m1920G(parcel);
        int i2 = 0;
        int i3 = 0;
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
                    i = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ValuesSetDetails(i4, i3, i2, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public ValuesSetDetails[] cF(int i) {
        return new ValuesSetDetails[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bp(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cF(i);
    }
}
