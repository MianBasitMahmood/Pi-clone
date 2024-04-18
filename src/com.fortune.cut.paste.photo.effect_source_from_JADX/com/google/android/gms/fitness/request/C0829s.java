package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.request.s */
public class C0829s implements Creator<SessionInsertRequest> {
    static void m2768a(SessionInsertRequest sessionInsertRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, sessionInsertRequest.getSession(), i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, sessionInsertRequest.getVersionCode());
        C0542b.m1981c(parcel, 2, sessionInsertRequest.getDataSets(), false);
        C0542b.m1981c(parcel, 3, sessionInsertRequest.getAggregateDataPoints(), false);
        C0542b.m1956H(parcel, H);
    }

    public SessionInsertRequest bS(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        List list = null;
        Session session = null;
        int i = 0;
        List list2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    session = (Session) C0541a.m1922a(parcel, F, Session.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    list = C0541a.m1928c(parcel, F, DataSet.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    list2 = C0541a.m1928c(parcel, F, DataPoint.CREATOR);
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
            return new SessionInsertRequest(i, session, list, list2);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bS(parcel);
    }

    public SessionInsertRequest[] dn(int i) {
        return new SessionInsertRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dn(i);
    }
}
