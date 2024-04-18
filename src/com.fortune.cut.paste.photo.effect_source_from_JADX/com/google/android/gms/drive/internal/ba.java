package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class ba implements Creator<OpenFileIntentSenderRequest> {
    static void m2190a(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, openFileIntentSenderRequest.CK);
        C0542b.m1968a(parcel, 2, openFileIntentSenderRequest.OH, false);
        C0542b.m1975a(parcel, 3, openFileIntentSenderRequest.OI, false);
        C0542b.m1964a(parcel, 4, openFileIntentSenderRequest.OJ, i, false);
        C0542b.m1956H(parcel, H);
    }

    public OpenFileIntentSenderRequest aE(Parcel parcel) {
        DriveId driveId = null;
        int G = C0541a.m1920G(parcel);
        String str = null;
        int i = 0;
        String[] strArr = null;
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
                    strArr = C0541a.m1914A(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    driveId = (DriveId) C0541a.m1922a(parcel, F, DriveId.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OpenFileIntentSenderRequest(i, str, strArr, driveId);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public OpenFileIntentSenderRequest[] bT(int i) {
        return new OpenFileIntentSenderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return aE(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bT(i);
    }
}
