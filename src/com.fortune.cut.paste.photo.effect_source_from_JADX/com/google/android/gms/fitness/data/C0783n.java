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

/* renamed from: com.google.android.gms.fitness.data.n */
public class C0783n implements Creator<RawDataPoint> {
    static void m2669a(RawDataPoint rawDataPoint, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1960a(parcel, 1, rawDataPoint.Ud);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, rawDataPoint.CK);
        C0542b.m1960a(parcel, 2, rawDataPoint.Ue);
        C0542b.m1974a(parcel, 3, rawDataPoint.Uf, i, false);
        C0542b.m1980c(parcel, 4, rawDataPoint.UJ);
        C0542b.m1980c(parcel, 5, rawDataPoint.UK);
        C0542b.m1960a(parcel, 6, rawDataPoint.Uh);
        C0542b.m1960a(parcel, 7, rawDataPoint.Ui);
        C0542b.m1956H(parcel, H);
    }

    public RawDataPoint bA(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        int i2 = 0;
        int i3 = 0;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    valueArr = (Value[]) C0541a.m1927b(parcel, F, Value.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    j3 = C0541a.m1935i(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
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
            return new RawDataPoint(i, j, j2, valueArr, i2, i3, j3, j4);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public RawDataPoint[] cT(int i) {
        return new RawDataPoint[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bA(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cT(i);
    }
}
