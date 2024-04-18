package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.realtime.internal.a */
public class C0685a implements Creator<BeginCompoundOperationRequest> {
    static void m2435a(BeginCompoundOperationRequest beginCompoundOperationRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, beginCompoundOperationRequest.CK);
        C0542b.m1971a(parcel, 2, beginCompoundOperationRequest.SF);
        C0542b.m1968a(parcel, 3, beginCompoundOperationRequest.mName, false);
        C0542b.m1971a(parcel, 4, beginCompoundOperationRequest.SG);
        C0542b.m1956H(parcel, H);
    }

    public BeginCompoundOperationRequest bc(Parcel parcel) {
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        String str = null;
        boolean z2 = true;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    z2 = C0541a.m1929c(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new BeginCompoundOperationRequest(i, z, str, z2);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public BeginCompoundOperationRequest[] cr(int i) {
        return new BeginCompoundOperationRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bc(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cr(i);
    }
}
