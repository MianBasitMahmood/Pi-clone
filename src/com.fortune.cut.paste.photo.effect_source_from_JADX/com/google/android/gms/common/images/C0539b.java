package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.common.images.b */
public class C0539b implements Creator<WebImage> {
    static void m1912a(WebImage webImage, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, webImage.getVersionCode());
        C0542b.m1964a(parcel, 2, webImage.getUrl(), i, false);
        C0542b.m1980c(parcel, 3, webImage.getWidth());
        C0542b.m1980c(parcel, 4, webImage.getHeight());
        C0542b.m1956H(parcel, H);
    }

    public WebImage m1913C(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    uri = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new WebImage(i2, uri, i, i3);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public WebImage[] aA(int i) {
        return new WebImage[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1913C(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return aA(i);
    }
}
