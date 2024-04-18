package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.drive.f */
public class C0563f implements Creator<RealtimeDocumentSyncRequest> {
    static void m2023a(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, realtimeDocumentSyncRequest.CK);
        C0542b.m1979b(parcel, 2, realtimeDocumentSyncRequest.OK, false);
        C0542b.m1979b(parcel, 3, realtimeDocumentSyncRequest.OL, false);
        C0542b.m1956H(parcel, H);
    }

    public RealtimeDocumentSyncRequest m2024U(Parcel parcel) {
        List list = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        List list2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    list2 = C0541a.m1916C(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    list = C0541a.m1916C(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new RealtimeDocumentSyncRequest(i, list2, list);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public RealtimeDocumentSyncRequest[] bc(int i) {
        return new RealtimeDocumentSyncRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2024U(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bc(i);
    }
}
