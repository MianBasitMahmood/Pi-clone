package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.fitness.data.e */
public class C0770e implements Creator<DataPoint> {
    static void m2656a(DataPoint dataPoint, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, dataPoint.getDataSource(), i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, dataPoint.getVersionCode());
        C0542b.m1960a(parcel, 3, dataPoint.getTimestampNanos());
        C0542b.m1960a(parcel, 4, dataPoint.ju());
        C0542b.m1974a(parcel, 5, dataPoint.jr(), i, false);
        C0542b.m1964a(parcel, 6, dataPoint.getOriginalDataSource(), i, false);
        C0542b.m1960a(parcel, 7, dataPoint.js());
        C0542b.m1960a(parcel, 8, dataPoint.jt());
        C0542b.m1956H(parcel, H);
    }

    public DataPoint bt(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        DataSource dataSource = null;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        DataSource dataSource2 = null;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    dataSource = (DataSource) C0541a.m1922a(parcel, F, DataSource.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    valueArr = (Value[]) C0541a.m1927b(parcel, F, Value.CREATOR);
                    break;
                case Error.OTHER /*6*/:
                    dataSource2 = (DataSource) C0541a.m1922a(parcel, F, DataSource.CREATOR);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    j3 = C0541a.m1935i(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    j4 = C0541a.m1935i(parcel, F);
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
            return new DataPoint(i, dataSource, j, j2, valueArr, dataSource2, j3, j4);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public DataPoint[] cM(int i) {
        return new DataPoint[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bt(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cM(i);
    }
}
