package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class ar implements Creator<OnListEntriesResponse> {
    static void m2165a(OnListEntriesResponse onListEntriesResponse, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, onListEntriesResponse.CK);
        C0542b.m1964a(parcel, 2, onListEntriesResponse.QQ, i, false);
        C0542b.m1971a(parcel, 3, onListEntriesResponse.PJ);
        C0542b.m1956H(parcel, H);
    }

    public OnListEntriesResponse aw(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        DataHolder dataHolder = null;
        int i = 0;
        boolean z = false;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    dataHolder = (DataHolder) C0541a.m1922a(parcel, F, DataHolder.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OnListEntriesResponse(i, dataHolder, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public OnListEntriesResponse[] bL(int i) {
        return new OnListEntriesResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return aw(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bL(i);
    }
}
