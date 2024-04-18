package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.internal.k */
public class C0586k implements Creator<CreateFileRequest> {
    static void m2207a(CreateFileRequest createFileRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, createFileRequest.CK);
        C0542b.m1964a(parcel, 2, createFileRequest.Pz, i, false);
        C0542b.m1964a(parcel, 3, createFileRequest.Px, i, false);
        C0542b.m1964a(parcel, 4, createFileRequest.Pr, i, false);
        C0542b.m1966a(parcel, 5, createFileRequest.Py, false);
        C0542b.m1971a(parcel, 6, createFileRequest.PA);
        C0542b.m1968a(parcel, 7, createFileRequest.Oy, false);
        C0542b.m1980c(parcel, 8, createFileRequest.PB);
        C0542b.m1980c(parcel, 9, createFileRequest.PC);
        C0542b.m1956H(parcel, H);
    }

    public CreateFileRequest ah(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = C0541a.m1920G(parcel);
        int i2 = 0;
        boolean z = false;
        Integer num = null;
        Contents contents = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0541a.m1933g(parcel, F);
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
                    num = C0541a.m1934h(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CreateFileRequest(i3, driveId, metadataBundle, contents, num, z, str, i2, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public CreateFileRequest[] bs(int i) {
        return new CreateFileRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ah(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bs(i);
    }
}
