package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.fitness.service.a */
public class C0851a implements Creator<FitnessSensorServiceRequest> {
    static void m2812a(FitnessSensorServiceRequest fitnessSensorServiceRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, fitnessSensorServiceRequest.getDataSource(), i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, fitnessSensorServiceRequest.getVersionCode());
        C0542b.m1962a(parcel, 2, fitnessSensorServiceRequest.kg(), false);
        C0542b.m1960a(parcel, 3, fitnessSensorServiceRequest.jI());
        C0542b.m1960a(parcel, 4, fitnessSensorServiceRequest.kx());
        C0542b.m1956H(parcel, H);
    }

    public FitnessSensorServiceRequest ck(Parcel parcel) {
        long j = 0;
        IBinder iBinder = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        long j2 = 0;
        DataSource dataSource = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    dataSource = (DataSource) C0541a.m1922a(parcel, F, DataSource.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    iBinder = C0541a.m1942p(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    j = C0541a.m1935i(parcel, F);
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
            return new FitnessSensorServiceRequest(i, dataSource, iBinder, j2, j);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ck(parcel);
    }

    public FitnessSensorServiceRequest[] dF(int i) {
        return new FitnessSensorServiceRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dF(i);
    }
}
