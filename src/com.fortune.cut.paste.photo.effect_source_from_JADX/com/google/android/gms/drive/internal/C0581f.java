package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.internal.f */
public class C0581f implements Creator<CloseContentsAndUpdateMetadataRequest> {
    static void m2201a(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, closeContentsAndUpdateMetadataRequest.CK);
        C0542b.m1964a(parcel, 2, closeContentsAndUpdateMetadataRequest.Pp, i, false);
        C0542b.m1964a(parcel, 3, closeContentsAndUpdateMetadataRequest.Pq, i, false);
        C0542b.m1964a(parcel, 4, closeContentsAndUpdateMetadataRequest.Pr, i, false);
        C0542b.m1971a(parcel, 5, closeContentsAndUpdateMetadataRequest.Oz);
        C0542b.m1968a(parcel, 6, closeContentsAndUpdateMetadataRequest.Oy, false);
        C0542b.m1980c(parcel, 7, closeContentsAndUpdateMetadataRequest.Ps);
        C0542b.m1956H(parcel, H);
    }

    public CloseContentsAndUpdateMetadataRequest ad(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = C0541a.m1920G(parcel);
        boolean z = false;
        Contents contents = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    driveId = (DriveId) C0541a.m1922a(parcel, F, DriveId.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    metadataBundle = (MetadataBundle) C0541a.m1922a(parcel, F, MetadataBundle.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    contents = (Contents) C0541a.m1922a(parcel, F, Contents.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CloseContentsAndUpdateMetadataRequest(i2, driveId, metadataBundle, contents, z, str, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public CloseContentsAndUpdateMetadataRequest[] bn(int i) {
        return new CloseContentsAndUpdateMetadataRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ad(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bn(i);
    }
}
