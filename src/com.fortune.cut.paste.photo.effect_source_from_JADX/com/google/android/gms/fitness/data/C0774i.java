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

/* renamed from: com.google.android.gms.fitness.data.i */
public class C0774i implements Creator<Device> {
    static void m2660a(Device device, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, device.getManufacturer(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, device.getVersionCode());
        C0542b.m1968a(parcel, 2, device.getModel(), false);
        C0542b.m1968a(parcel, 3, device.getVersion(), false);
        C0542b.m1968a(parcel, 4, device.jF(), false);
        C0542b.m1980c(parcel, 5, device.getType());
        C0542b.m1980c(parcel, 6, device.jC());
        C0542b.m1956H(parcel, H);
    }

    public Device bx(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = C0541a.m1920G(parcel);
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Device(i3, str4, str3, str2, str, i2, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public Device[] cQ(int i) {
        return new Device[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bx(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cQ(i);
    }
}
