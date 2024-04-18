package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.g */
public class C0564g implements Creator<StorageStats> {
    static void m2025a(StorageStats storageStats, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, storageStats.CK);
        C0542b.m1960a(parcel, 2, storageStats.OM);
        C0542b.m1960a(parcel, 3, storageStats.ON);
        C0542b.m1960a(parcel, 4, storageStats.OO);
        C0542b.m1960a(parcel, 5, storageStats.OP);
        C0542b.m1980c(parcel, 6, storageStats.OQ);
        C0542b.m1956H(parcel, H);
    }

    public StorageStats m2026V(Parcel parcel) {
        int i = 0;
        long j = 0;
        int G = C0541a.m1920G(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j4 = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    j3 = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new StorageStats(i2, j4, j3, j2, j, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public StorageStats[] bd(int i) {
        return new StorageStats[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2026V(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bd(i);
    }
}
