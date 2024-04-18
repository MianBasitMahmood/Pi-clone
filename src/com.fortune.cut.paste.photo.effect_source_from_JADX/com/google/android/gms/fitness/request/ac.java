package com.google.android.gms.fitness.request;

import android.os.IBinder;
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

public class ac implements Creator<StartBleScanRequest> {
    static void m2738a(StartBleScanRequest startBleScanRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1981c(parcel, 1, startBleScanRequest.getDataTypes(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, startBleScanRequest.getVersionCode());
        C0542b.m1962a(parcel, 2, startBleScanRequest.km(), false);
        C0542b.m1980c(parcel, 3, startBleScanRequest.getTimeoutSecs());
        C0542b.m1956H(parcel, H);
    }

    public StartBleScanRequest bY(Parcel parcel) {
        IBinder iBinder = null;
        int i = 0;
        int G = C0541a.m1920G(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    list = C0541a.m1928c(parcel, F, DataType.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    iBinder = C0541a.m1942p(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i = C0541a.m1933g(parcel, F);
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
            return new StartBleScanRequest(i2, list, iBinder, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bY(parcel);
    }

    public StartBleScanRequest[] dt(int i) {
        return new StartBleScanRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dt(i);
    }
}
