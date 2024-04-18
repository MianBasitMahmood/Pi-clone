package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.request.t */
public class C0830t implements Creator<SessionReadRequest> {
    static void m2769a(SessionReadRequest sessionReadRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, sessionReadRequest.getSessionName(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, sessionReadRequest.getVersionCode());
        C0542b.m1968a(parcel, 2, sessionReadRequest.getSessionId(), false);
        C0542b.m1960a(parcel, 3, sessionReadRequest.jo());
        C0542b.m1960a(parcel, 4, sessionReadRequest.jp());
        C0542b.m1981c(parcel, 5, sessionReadRequest.getDataTypes(), false);
        C0542b.m1981c(parcel, 6, sessionReadRequest.getDataSources(), false);
        C0542b.m1971a(parcel, 7, sessionReadRequest.kj());
        C0542b.m1971a(parcel, 8, sessionReadRequest.jV());
        C0542b.m1979b(parcel, 9, sessionReadRequest.getExcludedPackages(), false);
        C0542b.m1956H(parcel, H);
    }

    public SessionReadRequest bT(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        long j = 0;
        long j2 = 0;
        List list = null;
        List list2 = null;
        boolean z = false;
        boolean z2 = false;
        List list3 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    list = C0541a.m1928c(parcel, F, DataType.CREATOR);
                    break;
                case Error.OTHER /*6*/:
                    list2 = C0541a.m1928c(parcel, F, DataSource.CREATOR);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    z2 = C0541a.m1929c(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    list3 = C0541a.m1916C(parcel, F);
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
            return new SessionReadRequest(i, str, str2, j, j2, list, list2, z, z2, list3);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bT(parcel);
    }

    public SessionReadRequest[] m2770do(int i) {
        return new SessionReadRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2770do(i);
    }
}
