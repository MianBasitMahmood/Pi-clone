package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.internal.g */
public class C0582g implements Creator<CloseContentsRequest> {
    static void m2202a(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, closeContentsRequest.CK);
        C0542b.m1964a(parcel, 2, closeContentsRequest.Pr, i, false);
        C0542b.m1965a(parcel, 3, closeContentsRequest.Pt, false);
        C0542b.m1956H(parcel, H);
    }

    public CloseContentsRequest ae(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        Contents contents = null;
        int i = 0;
        Boolean bool = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    contents = (Contents) C0541a.m1922a(parcel, F, Contents.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    bool = C0541a.m1930d(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CloseContentsRequest(i, contents, bool);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public CloseContentsRequest[] bo(int i) {
        return new CloseContentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ae(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bo(i);
    }
}
