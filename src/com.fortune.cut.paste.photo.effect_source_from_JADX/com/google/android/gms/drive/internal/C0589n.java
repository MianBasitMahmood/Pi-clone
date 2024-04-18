package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.internal.n */
public class C0589n implements Creator<DeleteResourceRequest> {
    static void m2210a(DeleteResourceRequest deleteResourceRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, deleteResourceRequest.CK);
        C0542b.m1964a(parcel, 2, deleteResourceRequest.Pp, i, false);
        C0542b.m1956H(parcel, H);
    }

    public DeleteResourceRequest aj(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    driveId = (DriveId) C0541a.m1922a(parcel, F, DriveId.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new DeleteResourceRequest(i, driveId);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public DeleteResourceRequest[] bu(int i) {
        return new DeleteResourceRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return aj(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bu(i);
    }
}
