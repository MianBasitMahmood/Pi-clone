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

/* renamed from: com.google.android.gms.fitness.data.o */
public class C0784o implements Creator<RawDataSet> {
    static void m2670a(RawDataSet rawDataSet, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, rawDataSet.UJ);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, rawDataSet.CK);
        C0542b.m1980c(parcel, 2, rawDataSet.UL);
        C0542b.m1981c(parcel, 3, rawDataSet.UM, false);
        C0542b.m1971a(parcel, 4, rawDataSet.Uc);
        C0542b.m1956H(parcel, H);
    }

    public RawDataSet bB(Parcel parcel) {
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        List list = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    list = C0541a.m1928c(parcel, F, RawDataPoint.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    z = C0541a.m1929c(parcel, F);
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
            return new RawDataSet(i3, i2, i, list, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public RawDataSet[] cU(int i) {
        return new RawDataSet[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bB(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cU(i);
    }
}
