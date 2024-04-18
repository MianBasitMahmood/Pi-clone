package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.location.d */
public class C1508d implements Creator<LocationRequest> {
    static void m6093a(LocationRequest locationRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, locationRequest.mPriority);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, locationRequest.getVersionCode());
        C0542b.m1960a(parcel, 2, locationRequest.agr);
        C0542b.m1960a(parcel, 3, locationRequest.ags);
        C0542b.m1971a(parcel, 4, locationRequest.Wg);
        C0542b.m1960a(parcel, 5, locationRequest.age);
        C0542b.m1980c(parcel, 6, locationRequest.agt);
        C0542b.m1959a(parcel, 7, locationRequest.agu);
        C0542b.m1960a(parcel, 8, locationRequest.agv);
        C0542b.m1956H(parcel, H);
    }

    public LocationRequest cJ(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        int i2 = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY;
        long j = 3600000;
        long j2 = 600000;
        boolean z = false;
        long j3 = Long.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        float f = 0.0f;
        long j4 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    j3 = C0541a.m1935i(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    f = C0541a.m1938l(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    j4 = C0541a.m1935i(parcel, F);
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
            return new LocationRequest(i, i2, j, j2, z, j3, i3, f, j4);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cJ(parcel);
    }

    public LocationRequest[] eA(int i) {
        return new LocationRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eA(i);
    }
}
