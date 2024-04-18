package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class bi implements Creator<UpdateMetadataRequest> {
    static void m2198a(UpdateMetadataRequest updateMetadataRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, updateMetadataRequest.CK);
        C0542b.m1964a(parcel, 2, updateMetadataRequest.Pp, i, false);
        C0542b.m1964a(parcel, 3, updateMetadataRequest.Pq, i, false);
        C0542b.m1956H(parcel, H);
    }

    public UpdateMetadataRequest aL(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        DriveId driveId = null;
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    driveId = (DriveId) C0541a.m1922a(parcel, F, DriveId.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    metadataBundle = (MetadataBundle) C0541a.m1922a(parcel, F, MetadataBundle.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new UpdateMetadataRequest(i, driveId, metadataBundle);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public UpdateMetadataRequest[] ca(int i) {
        return new UpdateMetadataRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return aL(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return ca(i);
    }
}
