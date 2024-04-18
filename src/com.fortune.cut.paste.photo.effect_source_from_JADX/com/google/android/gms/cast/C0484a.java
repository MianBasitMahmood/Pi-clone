package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.cast.a */
public class C0484a implements Creator<ApplicationMetadata> {
    static void m1759a(ApplicationMetadata applicationMetadata, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, applicationMetadata.getVersionCode());
        C0542b.m1968a(parcel, 2, applicationMetadata.getApplicationId(), false);
        C0542b.m1968a(parcel, 3, applicationMetadata.getName(), false);
        C0542b.m1981c(parcel, 4, applicationMetadata.getImages(), false);
        C0542b.m1979b(parcel, 5, applicationMetadata.Fq, false);
        C0542b.m1968a(parcel, 6, applicationMetadata.getSenderAppIdentifier(), false);
        C0542b.m1964a(parcel, 7, applicationMetadata.fP(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public ApplicationMetadata[] m1760V(int i) {
        return new ApplicationMetadata[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1761u(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1760V(i);
    }

    public ApplicationMetadata m1761u(Parcel parcel) {
        Uri uri = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        List list = null;
        List list2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    list2 = C0541a.m1928c(parcel, F, WebImage.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    list = C0541a.m1916C(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    uri = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ApplicationMetadata(i, str3, str2, list2, list, str, uri);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }
}
