package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wearable.internal.j */
public class C1957j implements Creator<DataItemAssetParcelable> {
    static void m7035a(DataItemAssetParcelable dataItemAssetParcelable, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, dataItemAssetParcelable.CK);
        C0542b.m1968a(parcel, 2, dataItemAssetParcelable.getId(), false);
        C0542b.m1968a(parcel, 3, dataItemAssetParcelable.getDataItemKey(), false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ep(parcel);
    }

    public DataItemAssetParcelable ep(Parcel parcel) {
        String str = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new DataItemAssetParcelable(i, str2, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public DataItemAssetParcelable[] gy(int i) {
        return new DataItemAssetParcelable[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gy(i);
    }
}
