package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;

/* renamed from: com.google.android.gms.wearable.e */
public class C1903e implements Creator<PutDataRequest> {
    static void m6836a(PutDataRequest putDataRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, putDataRequest.CK);
        C0542b.m1964a(parcel, 2, putDataRequest.getUri(), i, false);
        C0542b.m1961a(parcel, 4, putDataRequest.rk(), false);
        C0542b.m1972a(parcel, 5, putDataRequest.getData(), false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return en(parcel);
    }

    public PutDataRequest en(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        Bundle bundle = null;
        Uri uri = null;
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    uri = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    bundle = C0541a.m1943q(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    bArr = C0541a.m1944r(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new PutDataRequest(i, uri, bundle, bArr);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public PutDataRequest[] gw(int i) {
        return new PutDataRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gw(i);
    }
}
