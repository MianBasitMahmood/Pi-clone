package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.result.e */
public class C0845e implements Creator<ListSubscriptionsResult> {
    static void m2802a(ListSubscriptionsResult listSubscriptionsResult, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1981c(parcel, 1, listSubscriptionsResult.getSubscriptions(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, listSubscriptionsResult.getVersionCode());
        C0542b.m1964a(parcel, 2, listSubscriptionsResult.getStatus(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public ListSubscriptionsResult ch(Parcel parcel) {
        Status status = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    list = C0541a.m1928c(parcel, F, Subscription.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
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
            return new ListSubscriptionsResult(i, list, status);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ch(parcel);
    }

    public ListSubscriptionsResult[] dC(int i) {
        return new ListSubscriptionsResult[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dC(i);
    }
}
