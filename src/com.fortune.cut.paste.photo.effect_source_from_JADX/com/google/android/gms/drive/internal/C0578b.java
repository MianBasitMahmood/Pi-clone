package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.internal.b */
public class C0578b implements Creator<AuthorizeAccessRequest> {
    static void m2189a(AuthorizeAccessRequest authorizeAccessRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, authorizeAccessRequest.CK);
        C0542b.m1960a(parcel, 2, authorizeAccessRequest.Pn);
        C0542b.m1964a(parcel, 3, authorizeAccessRequest.Oj, i, false);
        C0542b.m1956H(parcel, H);
    }

    public AuthorizeAccessRequest aa(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        long j = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    driveId = (DriveId) C0541a.m1922a(parcel, F, DriveId.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new AuthorizeAccessRequest(i, j, driveId);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public AuthorizeAccessRequest[] bk(int i) {
        return new AuthorizeAccessRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return aa(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bk(i);
    }
}
