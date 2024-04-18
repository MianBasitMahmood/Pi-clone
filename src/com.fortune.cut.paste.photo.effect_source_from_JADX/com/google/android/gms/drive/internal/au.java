package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wearable.DataEvent;

public class au implements Creator<OnLoadRealtimeResponse> {
    static void m2168a(OnLoadRealtimeResponse onLoadRealtimeResponse, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, onLoadRealtimeResponse.CK);
        C0542b.m1971a(parcel, 2, onLoadRealtimeResponse.wg);
        C0542b.m1956H(parcel, H);
    }

    public OnLoadRealtimeResponse az(Parcel parcel) {
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OnLoadRealtimeResponse(i, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public OnLoadRealtimeResponse[] bO(int i) {
        return new OnLoadRealtimeResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return az(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bO(i);
    }
}
