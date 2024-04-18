package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.common.api.e */
public class C0510e implements Creator<Scope> {
    static void m1842a(Scope scope, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, scope.CK);
        C0542b.m1968a(parcel, 2, scope.gO(), false);
        C0542b.m1956H(parcel, H);
    }

    public Scope[] am(int i) {
        return new Scope[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1843z(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return am(i);
    }

    public Scope m1843z(Parcel parcel) {
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
            return new Scope(i, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }
}
