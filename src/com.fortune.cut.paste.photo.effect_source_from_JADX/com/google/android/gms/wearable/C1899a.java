package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;

/* renamed from: com.google.android.gms.wearable.a */
public class C1899a implements Creator<Asset> {
    static void m6834a(Asset asset, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, asset.CK);
        C0542b.m1972a(parcel, 2, asset.getData(), false);
        C0542b.m1968a(parcel, 3, asset.getDigest(), false);
        C0542b.m1964a(parcel, 4, asset.axb, i, false);
        C0542b.m1964a(parcel, 5, asset.uri, i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return el(parcel);
    }

    public Asset el(Parcel parcel) {
        Uri uri = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String str = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    bArr = C0541a.m1944r(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0541a.m1922a(parcel, F, ParcelFileDescriptor.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    uri = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Asset(i, bArr, str, parcelFileDescriptor, uri);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public Asset[] gu(int i) {
        return new Asset[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gu(i);
    }
}
