package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.a */
public class C0670a implements Creator<Query> {
    static void m2398a(Query query, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, query.CK);
        C0542b.m1964a(parcel, 1, query.RY, i, false);
        C0542b.m1968a(parcel, 3, query.RZ, false);
        C0542b.m1964a(parcel, 4, query.Sa, i, false);
        C0542b.m1979b(parcel, 5, query.Sb, false);
        C0542b.m1956H(parcel, H);
    }

    public Query aQ(Parcel parcel) {
        List list = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        SortOrder sortOrder = null;
        String str = null;
        LogicalFilter logicalFilter = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    logicalFilter = (LogicalFilter) C0541a.m1922a(parcel, F, LogicalFilter.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    sortOrder = (SortOrder) C0541a.m1922a(parcel, F, SortOrder.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    list = C0541a.m1916C(parcel, F);
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
            return new Query(i, logicalFilter, str, sortOrder, list);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public Query[] cf(int i) {
        return new Query[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return aQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cf(i);
    }
}
