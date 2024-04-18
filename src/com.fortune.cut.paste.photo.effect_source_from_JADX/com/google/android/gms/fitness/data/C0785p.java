package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.fitness.data.p */
public class C0785p implements Creator<Session> {
    static void m2671a(Session session, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1960a(parcel, 1, session.jo());
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, session.getVersionCode());
        C0542b.m1960a(parcel, 2, session.jp());
        C0542b.m1968a(parcel, 3, session.getName(), false);
        C0542b.m1968a(parcel, 4, session.getIdentifier(), false);
        C0542b.m1968a(parcel, 5, session.getDescription(), false);
        C0542b.m1980c(parcel, 7, session.jm());
        C0542b.m1964a(parcel, 8, session.jx(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public Session bC(Parcel parcel) {
        long j = 0;
        int i = 0;
        C0766a c0766a = null;
        int G = C0541a.m1920G(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    c0766a = (C0766a) C0541a.m1922a(parcel, F, C0766a.CREATOR);
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
            return new Session(i2, j2, j, str3, str2, str, i, c0766a);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public Session[] cW(int i) {
        return new Session[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bC(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cW(i);
    }
}
