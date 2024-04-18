package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class hq implements Creator<hp> {
    static void m4856a(hp hpVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, hpVar.name, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, hpVar.CK);
        C0542b.m1968a(parcel, 2, hpVar.Dh, false);
        C0542b.m1971a(parcel, 3, hpVar.Di);
        C0542b.m1980c(parcel, 4, hpVar.weight);
        C0542b.m1971a(parcel, 5, hpVar.Dj);
        C0542b.m1968a(parcel, 6, hpVar.Dk, false);
        C0542b.m1974a(parcel, 7, hpVar.Dl, i, false);
        C0542b.m1973a(parcel, 8, hpVar.Dm, false);
        C0542b.m1968a(parcel, 11, hpVar.Dn, false);
        C0542b.m1956H(parcel, H);
    }

    public hp[] m4857R(int i) {
        return new hp[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4858r(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4857R(i);
    }

    public hp m4858r(Parcel parcel) {
        boolean z = false;
        String str = null;
        int G = C0541a.m1920G(parcel);
        int i = 1;
        int[] iArr = null;
        hj[] hjVarArr = null;
        String str2 = null;
        boolean z2 = false;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    z2 = C0541a.m1929c(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    hjVarArr = (hj[]) C0541a.m1927b(parcel, F, hj.CREATOR);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    iArr = C0541a.m1947u(parcel, F);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new hp(i2, str4, str3, z2, i, z, str2, hjVarArr, iArr, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }
}
