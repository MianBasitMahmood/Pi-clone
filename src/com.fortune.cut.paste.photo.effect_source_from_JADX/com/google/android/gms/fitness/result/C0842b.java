package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.result.b */
public class C0842b implements Creator<DataReadResult> {
    static void m2799a(DataReadResult dataReadResult, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1982d(parcel, 1, dataReadResult.kt(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, dataReadResult.getVersionCode());
        C0542b.m1964a(parcel, 2, dataReadResult.getStatus(), i, false);
        C0542b.m1982d(parcel, 3, dataReadResult.ks(), false);
        C0542b.m1980c(parcel, 5, dataReadResult.kr());
        C0542b.m1981c(parcel, 6, dataReadResult.jw(), false);
        C0542b.m1981c(parcel, 7, dataReadResult.ku(), false);
        C0542b.m1956H(parcel, H);
    }

    public DataReadResult ce(Parcel parcel) {
        int i = 0;
        List list = null;
        int G = C0541a.m1920G(parcel);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List list2 = null;
        Status status = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    C0541a.m1925a(parcel, F, arrayList, getClass().getClassLoader());
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    status = (Status) C0541a.m1922a(parcel, F, Status.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    C0541a.m1925a(parcel, F, arrayList2, getClass().getClassLoader());
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    list2 = C0541a.m1928c(parcel, F, DataSource.CREATOR);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    list = C0541a.m1928c(parcel, F, DataType.CREATOR);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new DataReadResult(i2, arrayList, status, arrayList2, i, list2, list);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ce(parcel);
    }

    public DataReadResult[] dz(int i) {
        return new DataReadResult[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dz(i);
    }
}
