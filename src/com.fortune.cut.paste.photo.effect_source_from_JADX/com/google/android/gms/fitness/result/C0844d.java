package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.fitness.result.d */
public class C0844d implements Creator<DataTypeResult> {
    static void m2801a(DataTypeResult dataTypeResult, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, dataTypeResult.getStatus(), i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, dataTypeResult.getVersionCode());
        C0542b.m1964a(parcel, 3, dataTypeResult.getDataType(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public DataTypeResult cg(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        Status status = null;
        int i = 0;
        DataType dataType = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    status = (Status) C0541a.m1922a(parcel, F, Status.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    dataType = (DataType) C0541a.m1922a(parcel, F, DataType.CREATOR);
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
            return new DataTypeResult(i, status, dataType);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cg(parcel);
    }

    public DataTypeResult[] dB(int i) {
        return new DataTypeResult[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dB(i);
    }
}
