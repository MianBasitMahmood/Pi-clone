package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.metadata.internal.c */
public class C0658c implements Creator<CustomProperty> {
    static void m2352a(CustomProperty customProperty, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, customProperty.CK);
        C0542b.m1964a(parcel, 2, customProperty.Rg, i, false);
        C0542b.m1968a(parcel, 3, customProperty.mValue, false);
        C0542b.m1956H(parcel, H);
    }

    public CustomProperty aO(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        CustomPropertyKey customPropertyKey = null;
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    customPropertyKey = (CustomPropertyKey) C0541a.m1922a(parcel, F, CustomPropertyKey.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CustomProperty(i, customPropertyKey, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public CustomProperty[] cd(int i) {
        return new CustomProperty[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return aO(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cd(i);
    }
}
