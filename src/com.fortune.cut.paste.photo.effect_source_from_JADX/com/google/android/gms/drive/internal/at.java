package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.wearable.DataEvent;

public class at implements Creator<OnMetadataResponse> {
    static void m2167a(OnMetadataResponse onMetadataResponse, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, onMetadataResponse.CK);
        C0542b.m1964a(parcel, 2, onMetadataResponse.Px, i, false);
        C0542b.m1956H(parcel, H);
    }

    public OnMetadataResponse ay(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    metadataBundle = (MetadataBundle) C0541a.m1922a(parcel, F, MetadataBundle.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OnMetadataResponse(i, metadataBundle);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public OnMetadataResponse[] bN(int i) {
        return new OnMetadataResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ay(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bN(i);
    }
}
