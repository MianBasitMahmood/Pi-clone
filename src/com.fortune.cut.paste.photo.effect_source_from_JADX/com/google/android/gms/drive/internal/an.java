package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class an implements Creator<OnDownloadProgressResponse> {
    static void m2161a(OnDownloadProgressResponse onDownloadProgressResponse, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, onDownloadProgressResponse.CK);
        C0542b.m1960a(parcel, 2, onDownloadProgressResponse.QL);
        C0542b.m1960a(parcel, 3, onDownloadProgressResponse.QM);
        C0542b.m1956H(parcel, H);
    }

    public OnDownloadProgressResponse as(Parcel parcel) {
        long j = 0;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OnDownloadProgressResponse(i, j2, j);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public OnDownloadProgressResponse[] bH(int i) {
        return new OnDownloadProgressResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return as(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bH(i);
    }
}
