package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.identity.intents.a */
public class C0994a implements Creator<UserAddressRequest> {
    static void m4105a(UserAddressRequest userAddressRequest, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, userAddressRequest.getVersionCode());
        C0542b.m1981c(parcel, 2, userAddressRequest.afH, false);
        C0542b.m1956H(parcel, H);
    }

    public UserAddressRequest cF(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    list = C0541a.m1928c(parcel, F, CountrySpecification.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new UserAddressRequest(i, list);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cF(parcel);
    }

    public UserAddressRequest[] es(int i) {
        return new UserAddressRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return es(i);
    }
}
