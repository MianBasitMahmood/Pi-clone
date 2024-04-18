package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.internal.o */
public class C0590o implements Creator<DisconnectRequest> {
    static void m2211a(DisconnectRequest disconnectRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, disconnectRequest.CK);
        C0542b.m1956H(parcel, H);
    }

    public DisconnectRequest ak(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new DisconnectRequest(i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public DisconnectRequest[] bv(int i) {
        return new DisconnectRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ak(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bv(i);
    }
}
