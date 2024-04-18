package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.fitness.data.C0786q;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.result.f */
public class C0846f implements Creator<SessionReadResult> {
    static void m2803a(SessionReadResult sessionReadResult, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1981c(parcel, 1, sessionReadResult.getSessions(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, sessionReadResult.getVersionCode());
        C0542b.m1981c(parcel, 2, sessionReadResult.kv(), false);
        C0542b.m1964a(parcel, 3, sessionReadResult.getStatus(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public SessionReadResult ci(Parcel parcel) {
        Status status = null;
        int G = C0541a.m1920G(parcel);
        List list = null;
        int i = 0;
        List list2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    list = C0541a.m1928c(parcel, F, Session.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    list2 = C0541a.m1928c(parcel, F, C0786q.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    status = (Status) C0541a.m1922a(parcel, F, Status.CREATOR);
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
            return new SessionReadResult(i, list, list2, status);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ci(parcel);
    }

    public SessionReadResult[] dD(int i) {
        return new SessionReadResult[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dD(i);
    }
}
