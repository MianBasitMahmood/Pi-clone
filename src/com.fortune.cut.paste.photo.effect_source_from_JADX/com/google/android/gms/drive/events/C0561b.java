package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.drive.events.b */
public class C0561b implements Creator<CompletionEvent> {
    static void m2020a(CompletionEvent completionEvent, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, completionEvent.CK);
        C0542b.m1964a(parcel, 2, completionEvent.Oj, i, false);
        C0542b.m1968a(parcel, 3, completionEvent.DZ, false);
        C0542b.m1964a(parcel, 4, completionEvent.OY, i, false);
        C0542b.m1964a(parcel, 5, completionEvent.OZ, i, false);
        C0542b.m1964a(parcel, 6, completionEvent.Pa, i, false);
        C0542b.m1979b(parcel, 7, completionEvent.Pb, false);
        C0542b.m1980c(parcel, 8, completionEvent.FP);
        C0542b.m1962a(parcel, 9, completionEvent.Pc, false);
        C0542b.m1956H(parcel, H);
    }

    public CompletionEvent m2021Y(Parcel parcel) {
        int i = 0;
        IBinder iBinder = null;
        int G = C0541a.m1920G(parcel);
        List list = null;
        MetadataBundle metadataBundle = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        String str = null;
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
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) C0541a.m1922a(parcel, F, ParcelFileDescriptor.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0541a.m1922a(parcel, F, ParcelFileDescriptor.CREATOR);
                    break;
                case Error.OTHER /*6*/:
                    metadataBundle = (MetadataBundle) C0541a.m1922a(parcel, F, MetadataBundle.CREATOR);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    list = C0541a.m1916C(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    iBinder = C0541a.m1942p(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CompletionEvent(i2, driveId, str, parcelFileDescriptor2, parcelFileDescriptor, metadataBundle, list, i, iBinder);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public CompletionEvent[] bg(int i) {
        return new CompletionEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2021Y(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bg(i);
    }
}
