package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.request.d */
public class C0810d implements Creator<DataDeleteRequest> {
    static void m2752a(DataDeleteRequest dataDeleteRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1960a(parcel, 1, dataDeleteRequest.jo());
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, dataDeleteRequest.getVersionCode());
        C0542b.m1960a(parcel, 2, dataDeleteRequest.jp());
        C0542b.m1981c(parcel, 3, dataDeleteRequest.getDataSources(), false);
        C0542b.m1981c(parcel, 4, dataDeleteRequest.getDataTypes(), false);
        C0542b.m1981c(parcel, 5, dataDeleteRequest.getSessions(), false);
        C0542b.m1971a(parcel, 6, dataDeleteRequest.jR());
        C0542b.m1971a(parcel, 7, dataDeleteRequest.jS());
        C0542b.m1956H(parcel, H);
    }

    public DataDeleteRequest bJ(Parcel parcel) {
        long j = 0;
        List list = null;
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        boolean z2 = false;
        List list2 = null;
        List list3 = null;
        long j2 = 0;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    list3 = C0541a.m1928c(parcel, F, DataSource.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    list2 = C0541a.m1928c(parcel, F, DataType.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    list = C0541a.m1928c(parcel, F, Session.CREATOR);
                    break;
                case Error.OTHER /*6*/:
                    z2 = C0541a.m1929c(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
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
            return new DataDeleteRequest(i, j2, j, list3, list2, list, z2, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bJ(parcel);
    }

    public DataDeleteRequest[] dd(int i) {
        return new DataDeleteRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dd(i);
    }
}
