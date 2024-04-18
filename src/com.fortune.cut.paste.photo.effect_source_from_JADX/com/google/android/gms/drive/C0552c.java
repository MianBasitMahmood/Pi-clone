package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.c */
public class C0552c implements Creator<DriveId> {
    static void m2003a(DriveId driveId, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, driveId.CK);
        C0542b.m1968a(parcel, 2, driveId.Ot, false);
        C0542b.m1960a(parcel, 3, driveId.Ou);
        C0542b.m1960a(parcel, 4, driveId.Ov);
        C0542b.m1956H(parcel, H);
    }

    public DriveId m2004S(Parcel parcel) {
        long j = 0;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        long j2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new DriveId(i, str, j2, j);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public DriveId[] aY(int i) {
        return new DriveId[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2004S(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return aY(i);
    }
}
