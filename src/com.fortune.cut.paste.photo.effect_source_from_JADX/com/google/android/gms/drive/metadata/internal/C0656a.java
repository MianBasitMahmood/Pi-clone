package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wearable.DataEvent;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.internal.a */
public class C0656a implements Creator<AppVisibleCustomProperties> {
    static void m2345a(AppVisibleCustomProperties appVisibleCustomProperties, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, appVisibleCustomProperties.CK);
        C0542b.m1981c(parcel, 2, appVisibleCustomProperties.Re, false);
        C0542b.m1956H(parcel, H);
    }

    public AppVisibleCustomProperties aN(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        Collection collection = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    collection = C0541a.m1928c(parcel, F, CustomProperty.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new AppVisibleCustomProperties(i, collection);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public AppVisibleCustomProperties[] cc(int i) {
        return new AppVisibleCustomProperties[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return aN(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cc(i);
    }
}
