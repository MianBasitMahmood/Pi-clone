package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.realtime.internal.b */
public class C0686b implements Creator<EndCompoundOperationRequest> {
    static void m2436a(EndCompoundOperationRequest endCompoundOperationRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, endCompoundOperationRequest.CK);
        C0542b.m1956H(parcel, H);
    }

    public EndCompoundOperationRequest bd(Parcel parcel) {
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
            return new EndCompoundOperationRequest(i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bd(parcel);
    }

    public EndCompoundOperationRequest[] cs(int i) {
        return new EndCompoundOperationRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cs(i);
    }
}
