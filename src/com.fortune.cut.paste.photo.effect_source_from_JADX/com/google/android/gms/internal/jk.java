package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class jk implements Creator<jj> {
    static void m5085a(jj jjVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, jjVar.version);
        C0542b.m1980c(parcel, 2, jjVar.MD);
        C0542b.m1980c(parcel, 3, jjVar.ME);
        C0542b.m1968a(parcel, 4, jjVar.MF, false);
        C0542b.m1962a(parcel, 5, jjVar.MG, false);
        C0542b.m1974a(parcel, 6, jjVar.MH, i, false);
        C0542b.m1961a(parcel, 7, jjVar.MI, false);
        C0542b.m1956H(parcel, H);
    }

    public jj m5086D(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int G = C0541a.m1920G(parcel);
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    iBinder = C0541a.m1942p(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    scopeArr = (Scope[]) C0541a.m1927b(parcel, F, Scope.CREATOR);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    bundle = C0541a.m1943q(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new jj(i3, i2, i, str, iBinder, scopeArr, bundle);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public jj[] aC(int i) {
        return new jj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5086D(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return aC(i);
    }
}
