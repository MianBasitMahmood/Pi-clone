package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.request.g */
public class C0815g implements Creator<DataReadRequest> {
    static void m2757a(DataReadRequest dataReadRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1981c(parcel, 1, dataReadRequest.getDataTypes(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, dataReadRequest.getVersionCode());
        C0542b.m1981c(parcel, 2, dataReadRequest.getDataSources(), false);
        C0542b.m1960a(parcel, 3, dataReadRequest.jo());
        C0542b.m1960a(parcel, 4, dataReadRequest.jp());
        C0542b.m1981c(parcel, 5, dataReadRequest.getAggregatedDataTypes(), false);
        C0542b.m1981c(parcel, 6, dataReadRequest.getAggregatedDataSources(), false);
        C0542b.m1980c(parcel, 7, dataReadRequest.getBucketType());
        C0542b.m1960a(parcel, 8, dataReadRequest.jX());
        C0542b.m1964a(parcel, 9, dataReadRequest.getActivityDataSource(), i, false);
        C0542b.m1980c(parcel, 10, dataReadRequest.getLimit());
        C0542b.m1971a(parcel, 12, dataReadRequest.jW());
        C0542b.m1971a(parcel, 13, dataReadRequest.jV());
        C0542b.m1956H(parcel, H);
    }

    public DataReadRequest bL(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        long j = 0;
        long j2 = 0;
        List list3 = null;
        List list4 = null;
        int i2 = 0;
        long j3 = 0;
        DataSource dataSource = null;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    list = C0541a.m1928c(parcel, F, DataType.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    list2 = C0541a.m1928c(parcel, F, DataSource.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    list3 = C0541a.m1928c(parcel, F, DataType.CREATOR);
                    break;
                case Error.OTHER /*6*/:
                    list4 = C0541a.m1928c(parcel, F, DataSource.CREATOR);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    j3 = C0541a.m1935i(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    dataSource = (DataSource) C0541a.m1922a(parcel, F, DataSource.CREATOR);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    z2 = C0541a.m1929c(parcel, F);
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
            return new DataReadRequest(i, list, list2, j, j2, list3, list4, i2, j3, dataSource, i3, z, z2);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bL(parcel);
    }

    public DataReadRequest[] df(int i) {
        return new DataReadRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return df(i);
    }
}
