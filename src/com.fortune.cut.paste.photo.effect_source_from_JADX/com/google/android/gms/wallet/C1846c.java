package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.c */
public class C1846c implements Creator<CountrySpecification> {
    static void m6712a(CountrySpecification countrySpecification, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, countrySpecification.getVersionCode());
        C0542b.m1968a(parcel, 2, countrySpecification.vk, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return dL(parcel);
    }

    public CountrySpecification dL(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CountrySpecification(i, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public CountrySpecification[] fS(int i) {
        return new CountrySpecification[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return fS(i);
    }
}
