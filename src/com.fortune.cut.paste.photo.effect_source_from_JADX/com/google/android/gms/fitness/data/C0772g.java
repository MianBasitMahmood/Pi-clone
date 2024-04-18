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

/* renamed from: com.google.android.gms.fitness.data.g */
public class C0772g implements Creator<DataSource> {
    static void m2658a(DataSource dataSource, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, dataSource.getDataType(), i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, dataSource.getVersionCode());
        C0542b.m1968a(parcel, 2, dataSource.getName(), false);
        C0542b.m1980c(parcel, 3, dataSource.getType());
        C0542b.m1964a(parcel, 4, dataSource.getDevice(), i, false);
        C0542b.m1964a(parcel, 5, dataSource.jx(), i, false);
        C0542b.m1968a(parcel, 6, dataSource.getStreamName(), false);
        C0542b.m1971a(parcel, 7, dataSource.jz());
        C0542b.m1956H(parcel, H);
    }

    public DataSource bv(Parcel parcel) {
        boolean z = false;
        String str = null;
        int G = C0541a.m1920G(parcel);
        C0766a c0766a = null;
        Device device = null;
        int i = 0;
        String str2 = null;
        DataType dataType = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    dataType = (DataType) C0541a.m1922a(parcel, F, DataType.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    device = (Device) C0541a.m1922a(parcel, F, Device.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    c0766a = (C0766a) C0541a.m1922a(parcel, F, C0766a.CREATOR);
                    break;
                case Error.OTHER /*6*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    z = C0541a.m1929c(parcel, F);
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
            return new DataSource(i2, dataType, str2, i, device, c0766a, str, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public DataSource[] cO(int i) {
        return new DataSource[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bv(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cO(i);
    }
}
