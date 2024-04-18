package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.result.g */
public class C0847g implements Creator<SessionStopResult> {
    static void m2804a(SessionStopResult sessionStopResult, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, sessionStopResult.getVersionCode());
        C0542b.m1964a(parcel, 2, sessionStopResult.getStatus(), i, false);
        C0542b.m1981c(parcel, 3, sessionStopResult.getSessions(), false);
        C0542b.m1956H(parcel, H);
    }

    public SessionStopResult cj(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        Status status = null;
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_DELETED /*2*/:
                    status = (Status) C0541a.m1922a(parcel, F, Status.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    list = C0541a.m1928c(parcel, F, Session.CREATOR);
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
            return new SessionStopResult(i, status, list);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cj(parcel);
    }

    public SessionStopResult[] dE(int i) {
        return new SessionStopResult[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dE(i);
    }
}
