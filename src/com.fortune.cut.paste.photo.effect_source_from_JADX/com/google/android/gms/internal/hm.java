package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.internal.hl.C1188a;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class hm implements Creator<C1188a> {
    static void m4846a(C1188a c1188a, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, c1188a.Dc, i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, c1188a.CK);
        C0542b.m1956H(parcel, H);
    }

    public C1188a[] m4847N(int i) {
        return new C1188a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4848p(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4847N(i);
    }

    public C1188a m4848p(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        Account account = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    account = (Account) C0541a.m1922a(parcel, F, Account.CREATOR);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1188a(i, account);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }
}
