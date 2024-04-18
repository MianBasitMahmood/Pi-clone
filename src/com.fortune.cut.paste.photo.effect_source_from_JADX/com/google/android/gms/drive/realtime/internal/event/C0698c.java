package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.c */
public class C0698c implements Creator<ParcelableEventList> {
    static void m2451a(ParcelableEventList parcelableEventList, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, parcelableEventList.CK);
        C0542b.m1981c(parcel, 2, parcelableEventList.mp, false);
        C0542b.m1964a(parcel, 3, parcelableEventList.Tb, i, false);
        C0542b.m1971a(parcel, 4, parcelableEventList.Tc);
        C0542b.m1979b(parcel, 5, parcelableEventList.Td, false);
        C0542b.m1956H(parcel, H);
    }

    public ParcelableEventList bi(Parcel parcel) {
        boolean z = false;
        List list = null;
        int G = C0541a.m1920G(parcel);
        DataHolder dataHolder = null;
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    list2 = C0541a.m1928c(parcel, F, ParcelableEvent.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    dataHolder = (DataHolder) C0541a.m1922a(parcel, F, DataHolder.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    list = C0541a.m1916C(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ParcelableEventList(i, list2, dataHolder, z, list);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bi(parcel);
    }

    public ParcelableEventList[] cy(int i) {
        return new ParcelableEventList[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cy(i);
    }
}
