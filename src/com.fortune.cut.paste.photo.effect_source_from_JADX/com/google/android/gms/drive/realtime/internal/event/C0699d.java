package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.d */
public class C0699d implements Creator<ReferenceShiftedDetails> {
    static void m2452a(ReferenceShiftedDetails referenceShiftedDetails, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, referenceShiftedDetails.CK);
        C0542b.m1968a(parcel, 2, referenceShiftedDetails.Te, false);
        C0542b.m1968a(parcel, 3, referenceShiftedDetails.Tf, false);
        C0542b.m1980c(parcel, 4, referenceShiftedDetails.Tg);
        C0542b.m1980c(parcel, 5, referenceShiftedDetails.Th);
        C0542b.m1956H(parcel, H);
    }

    public ReferenceShiftedDetails bj(Parcel parcel) {
        String str = null;
        int i = 0;
        int G = C0541a.m1920G(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i2 = C0541a.m1933g(parcel, F);
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
            return new ReferenceShiftedDetails(i3, str2, str, i2, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bj(parcel);
    }

    public ReferenceShiftedDetails[] cz(int i) {
        return new ReferenceShiftedDetails[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cz(i);
    }
}
