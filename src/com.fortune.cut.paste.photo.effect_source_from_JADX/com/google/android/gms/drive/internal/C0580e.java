package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.drive.internal.e */
public class C0580e implements Creator<CheckResourceIdsExistRequest> {
    static void m2200a(CheckResourceIdsExistRequest checkResourceIdsExistRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, checkResourceIdsExistRequest.getVersionCode());
        C0542b.m1979b(parcel, 2, checkResourceIdsExistRequest.iF(), false);
        C0542b.m1956H(parcel, H);
    }

    public CheckResourceIdsExistRequest ac(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    list = C0541a.m1916C(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CheckResourceIdsExistRequest(i, list);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public CheckResourceIdsExistRequest[] bm(int i) {
        return new CheckResourceIdsExistRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ac(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bm(i);
    }
}
