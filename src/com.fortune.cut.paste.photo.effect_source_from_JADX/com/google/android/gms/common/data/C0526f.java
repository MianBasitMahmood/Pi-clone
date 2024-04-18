package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.common.data.f */
public class C0526f implements Creator<DataHolder> {
    static void m1876a(DataHolder dataHolder, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1975a(parcel, 1, dataHolder.gY(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, dataHolder.getVersionCode());
        C0542b.m1974a(parcel, 2, dataHolder.gZ(), i, false);
        C0542b.m1980c(parcel, 3, dataHolder.getStatusCode());
        C0542b.m1961a(parcel, 4, dataHolder.gV(), false);
        C0542b.m1956H(parcel, H);
    }

    public DataHolder m1877B(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int G = C0541a.m1920G(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    strArr = C0541a.m1914A(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    cursorWindowArr = (CursorWindow[]) C0541a.m1927b(parcel, F, CursorWindow.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    bundle = C0541a.m1943q(parcel, F);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() != G) {
            throw new C0540a("Overread allowed size end=" + G, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.gX();
        return dataHolder;
    }

    public DataHolder[] aw(int i) {
        return new DataHolder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1877B(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return aw(i);
    }
}
