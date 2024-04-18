package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.result.a */
public class C0841a implements Creator<BleDevicesResult> {
    static void m2798a(BleDevicesResult bleDevicesResult, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1981c(parcel, 1, bleDevicesResult.getClaimedBleDevices(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, bleDevicesResult.getVersionCode());
        C0542b.m1964a(parcel, 2, bleDevicesResult.getStatus(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public BleDevicesResult cd(Parcel parcel) {
        Status status = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    list = C0541a.m1928c(parcel, F, BleDevice.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    status = (Status) C0541a.m1922a(parcel, F, Status.CREATOR);
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
            return new BleDevicesResult(i, list, status);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cd(parcel);
    }

    public BleDevicesResult[] dy(int i) {
        return new BleDevicesResult[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dy(i);
    }
}
