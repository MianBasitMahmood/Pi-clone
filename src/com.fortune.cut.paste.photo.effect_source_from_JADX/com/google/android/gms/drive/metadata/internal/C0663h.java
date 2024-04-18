package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.metadata.internal.h */
public class C0663h implements Creator<MetadataBundle> {
    static void m2372a(MetadataBundle metadataBundle, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, metadataBundle.CK);
        C0542b.m1961a(parcel, 2, metadataBundle.Ri, false);
        C0542b.m1956H(parcel, H);
    }

    public MetadataBundle aP(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    bundle = C0541a.m1943q(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new MetadataBundle(i, bundle);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public MetadataBundle[] ce(int i) {
        return new MetadataBundle[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return aP(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return ce(i);
    }
}
