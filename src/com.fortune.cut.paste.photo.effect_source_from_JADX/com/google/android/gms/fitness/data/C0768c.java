package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.data.c */
public class C0768c implements Creator<BleDevice> {
    static void m2654a(BleDevice bleDevice, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, bleDevice.getAddress(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, bleDevice.getVersionCode());
        C0542b.m1968a(parcel, 2, bleDevice.getName(), false);
        C0542b.m1979b(parcel, 3, bleDevice.getSupportedProfiles(), false);
        C0542b.m1981c(parcel, 4, bleDevice.getDataTypes(), false);
        C0542b.m1956H(parcel, H);
    }

    public BleDevice br(Parcel parcel) {
        List list = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        List list2 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    list2 = C0541a.m1916C(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    list = C0541a.m1928c(parcel, F, DataType.CREATOR);
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
            return new BleDevice(i, str2, str, list2, list);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public BleDevice[] cI(int i) {
        return new BleDevice[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return br(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cI(i);
    }
}
