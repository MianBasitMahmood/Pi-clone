package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.realtime.internal.p */
public class C0736p implements Creator<ParcelableCollaborator> {
    static void m2567a(ParcelableCollaborator parcelableCollaborator, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, parcelableCollaborator.CK);
        C0542b.m1971a(parcel, 2, parcelableCollaborator.SH);
        C0542b.m1971a(parcel, 3, parcelableCollaborator.SI);
        C0542b.m1968a(parcel, 4, parcelableCollaborator.vZ, false);
        C0542b.m1968a(parcel, 5, parcelableCollaborator.SJ, false);
        C0542b.m1968a(parcel, 6, parcelableCollaborator.OS, false);
        C0542b.m1968a(parcel, 7, parcelableCollaborator.SK, false);
        C0542b.m1968a(parcel, 8, parcelableCollaborator.SL, false);
        C0542b.m1956H(parcel, H);
    }

    public ParcelableCollaborator be(Parcel parcel) {
        boolean z = false;
        String str = null;
        int G = C0541a.m1920G(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    z2 = C0541a.m1929c(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str5 = C0541a.m1941o(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ParcelableCollaborator(i, z2, z, str5, str4, str3, str2, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return be(parcel);
    }

    public ParcelableCollaborator[] cu(int i) {
        return new ParcelableCollaborator[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cu(i);
    }
}
