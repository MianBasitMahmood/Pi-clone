package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.request.h */
public class C0816h implements Creator<DataSourcesRequest> {
    static void m2758a(DataSourcesRequest dataSourcesRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1981c(parcel, 1, dataSourcesRequest.getDataTypes(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, dataSourcesRequest.getVersionCode());
        C0542b.m1969a(parcel, 2, dataSourcesRequest.jZ(), false);
        C0542b.m1971a(parcel, 3, dataSourcesRequest.jY());
        C0542b.m1956H(parcel, H);
    }

    public DataSourcesRequest bM(Parcel parcel) {
        List list = null;
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    list2 = C0541a.m1928c(parcel, F, DataType.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    list = C0541a.m1915B(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    z = C0541a.m1929c(parcel, F);
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
            return new DataSourcesRequest(i, list2, list, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bM(parcel);
    }

    public DataSourcesRequest[] dg(int i) {
        return new DataSourcesRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dg(i);
    }
}
