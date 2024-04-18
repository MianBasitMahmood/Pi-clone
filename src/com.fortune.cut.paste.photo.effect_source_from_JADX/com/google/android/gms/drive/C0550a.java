package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.a */
public class C0550a implements Creator<Contents> {
    static void m2001a(Contents contents, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, contents.CK);
        C0542b.m1964a(parcel, 2, contents.LG, i, false);
        C0542b.m1980c(parcel, 3, contents.ve);
        C0542b.m1980c(parcel, 4, contents.Oi);
        C0542b.m1964a(parcel, 5, contents.Oj, i, false);
        C0542b.m1971a(parcel, 7, contents.Ok);
        C0542b.m1956H(parcel, H);
    }

    public Contents m2002R(Parcel parcel) {
        DriveId driveId = null;
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0541a.m1922a(parcel, F, ParcelFileDescriptor.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    driveId = (DriveId) C0541a.m1922a(parcel, F, DriveId.CREATOR);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Contents(i3, parcelFileDescriptor, i2, i, driveId, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public Contents[] aX(int i) {
        return new Contents[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2002R(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return aX(i);
    }
}
