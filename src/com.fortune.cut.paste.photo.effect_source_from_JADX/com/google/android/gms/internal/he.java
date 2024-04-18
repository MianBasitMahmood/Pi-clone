package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class he implements Creator<hd> {
    static void m4834a(hd hdVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1974a(parcel, 1, hdVar.CL, i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, hdVar.CK);
        C0542b.m1968a(parcel, 2, hdVar.CM, false);
        C0542b.m1971a(parcel, 3, hdVar.CN);
        C0542b.m1964a(parcel, 4, hdVar.account, i, false);
        C0542b.m1956H(parcel, H);
    }

    public hd[] m4835J(int i) {
        return new hd[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4836l(parcel);
    }

    public hd m4836l(Parcel parcel) {
        boolean z = false;
        Account account = null;
        int G = C0541a.m1920G(parcel);
        String str = null;
        hh[] hhVarArr = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    hhVarArr = (hh[]) C0541a.m1927b(parcel, F, hh.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    account = (Account) C0541a.m1922a(parcel, F, Account.CREATOR);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new hd(i, hhVarArr, str, z, account);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4835J(i);
    }
}
