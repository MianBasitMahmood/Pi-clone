package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.internal.j */
public class C0585j implements Creator<CreateFileIntentSenderRequest> {
    static void m2206a(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, createFileIntentSenderRequest.CK);
        C0542b.m1964a(parcel, 2, createFileIntentSenderRequest.Px, i, false);
        C0542b.m1980c(parcel, 3, createFileIntentSenderRequest.ve);
        C0542b.m1968a(parcel, 4, createFileIntentSenderRequest.OH, false);
        C0542b.m1964a(parcel, 5, createFileIntentSenderRequest.OJ, i, false);
        C0542b.m1966a(parcel, 6, createFileIntentSenderRequest.Py, false);
        C0542b.m1956H(parcel, H);
    }

    public CreateFileIntentSenderRequest ag(Parcel parcel) {
        int i = 0;
        Integer num = null;
        int G = C0541a.m1920G(parcel);
        DriveId driveId = null;
        String str = null;
        MetadataBundle metadataBundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    metadataBundle = (MetadataBundle) C0541a.m1922a(parcel, F, MetadataBundle.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    driveId = (DriveId) C0541a.m1922a(parcel, F, DriveId.CREATOR);
                    break;
                case Error.OTHER /*6*/:
                    num = C0541a.m1934h(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CreateFileIntentSenderRequest(i2, metadataBundle, i, str, driveId, num);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public CreateFileIntentSenderRequest[] br(int i) {
        return new CreateFileIntentSenderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ag(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return br(i);
    }
}
