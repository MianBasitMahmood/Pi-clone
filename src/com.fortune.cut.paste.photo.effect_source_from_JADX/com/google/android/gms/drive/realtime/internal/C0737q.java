package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.realtime.internal.q */
public class C0737q implements Creator<ParcelableIndexReference> {
    static void m2568a(ParcelableIndexReference parcelableIndexReference, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, parcelableIndexReference.CK);
        C0542b.m1968a(parcel, 2, parcelableIndexReference.SM, false);
        C0542b.m1980c(parcel, 3, parcelableIndexReference.mIndex);
        C0542b.m1971a(parcel, 4, parcelableIndexReference.SN);
        C0542b.m1956H(parcel, H);
    }

    public ParcelableIndexReference bf(Parcel parcel) {
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ParcelableIndexReference(i, str, i2, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bf(parcel);
    }

    public ParcelableIndexReference[] cv(int i) {
        return new ParcelableIndexReference[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cv(i);
    }
}
