package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.data.f */
public class C0771f implements Creator<DataSet> {
    static void m2657a(DataSet dataSet, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, dataSet.getDataSource(), i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, dataSet.getVersionCode());
        C0542b.m1964a(parcel, 2, dataSet.getDataType(), i, false);
        C0542b.m1982d(parcel, 3, dataSet.jv(), false);
        C0542b.m1981c(parcel, 4, dataSet.jw(), false);
        C0542b.m1971a(parcel, 5, dataSet.jn());
        C0542b.m1956H(parcel, H);
    }

    public DataSet bu(Parcel parcel) {
        boolean z = false;
        List list = null;
        int G = C0541a.m1920G(parcel);
        List arrayList = new ArrayList();
        DataType dataType = null;
        DataSource dataSource = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    dataSource = (DataSource) C0541a.m1922a(parcel, F, DataSource.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    dataType = (DataType) C0541a.m1922a(parcel, F, DataType.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    C0541a.m1925a(parcel, F, arrayList, getClass().getClassLoader());
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    list = C0541a.m1928c(parcel, F, DataSource.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
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
            return new DataSet(i, dataSource, dataType, arrayList, list, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public DataSet[] cN(int i) {
        return new DataSet[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bu(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cN(i);
    }
}
