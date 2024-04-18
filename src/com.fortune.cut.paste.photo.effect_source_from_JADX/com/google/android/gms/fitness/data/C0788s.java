package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.fitness.data.s */
public class C0788s implements Creator<Subscription> {
    static void m2674a(Subscription subscription, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, subscription.getDataSource(), i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, subscription.getVersionCode());
        C0542b.m1964a(parcel, 2, subscription.getDataType(), i, false);
        C0542b.m1960a(parcel, 3, subscription.jI());
        C0542b.m1980c(parcel, 4, subscription.getAccuracyMode());
        C0542b.m1956H(parcel, H);
    }

    public Subscription bE(Parcel parcel) {
        DataType dataType = null;
        int i = 0;
        int G = C0541a.m1920G(parcel);
        long j = 0;
        DataSource dataSource = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    dataSource = (DataSource) C0541a.m1922a(parcel, F, DataSource.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    dataType = (DataType) C0541a.m1922a(parcel, F, DataType.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
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
            return new Subscription(i2, dataSource, dataType, j, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public Subscription[] cY(int i) {
        return new Subscription[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bE(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cY(i);
    }
}
