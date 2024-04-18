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

/* renamed from: com.google.android.gms.drive.h */
public class C0565h implements Creator<UserMetadata> {
    static void m2027a(UserMetadata userMetadata, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, userMetadata.CK);
        C0542b.m1968a(parcel, 2, userMetadata.OR, false);
        C0542b.m1968a(parcel, 3, userMetadata.OS, false);
        C0542b.m1968a(parcel, 4, userMetadata.OT, false);
        C0542b.m1971a(parcel, 5, userMetadata.OU);
        C0542b.m1968a(parcel, 6, userMetadata.OV, false);
        C0542b.m1956H(parcel, H);
    }

    public UserMetadata m2028W(Parcel parcel) {
        boolean z = false;
        String str = null;
        int G = C0541a.m1920G(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new UserMetadata(i, str4, str3, str2, z, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public UserMetadata[] be(int i) {
        return new UserMetadata[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2028W(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return be(i);
    }
}
