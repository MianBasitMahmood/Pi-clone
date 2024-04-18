package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.metadata.c */
public class C0652c implements Creator<CustomPropertyKey> {
    static void m2339a(CustomPropertyKey customPropertyKey, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, customPropertyKey.CK);
        C0542b.m1968a(parcel, 2, customPropertyKey.KP, false);
        C0542b.m1980c(parcel, 3, customPropertyKey.mVisibility);
        C0542b.m1956H(parcel, H);
    }

    public CustomPropertyKey aM(Parcel parcel) {
        int i = 0;
        int G = C0541a.m1920G(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CustomPropertyKey(i2, str, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public CustomPropertyKey[] cb(int i) {
        return new CustomPropertyKey[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return aM(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cb(i);
    }
}
