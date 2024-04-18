package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.fitness.data.u */
public class C0790u implements Creator<Value> {
    static void m2676a(Value value, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, value.getFormat());
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, value.getVersionCode());
        C0542b.m1971a(parcel, 2, value.isSet());
        C0542b.m1959a(parcel, 3, value.jL());
        C0542b.m1956H(parcel, H);
    }

    public Value bF(Parcel parcel) {
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    f = C0541a.m1938l(parcel, F);
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
            return new Value(i2, i, z, f);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public Value[] cZ(int i) {
        return new Value[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bF(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cZ(i);
    }
}
