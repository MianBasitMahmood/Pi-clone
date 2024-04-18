package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class AppContentConditionEntityCreator implements Creator<AppContentConditionEntity> {
    static void m2855a(AppContentConditionEntity appContentConditionEntity, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, appContentConditionEntity.kT(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, appContentConditionEntity.getVersionCode());
        C0542b.m1968a(parcel, 2, appContentConditionEntity.kU(), false);
        C0542b.m1968a(parcel, 3, appContentConditionEntity.kV(), false);
        C0542b.m1961a(parcel, 4, appContentConditionEntity.kW(), false);
        C0542b.m1956H(parcel, H);
    }

    public AppContentConditionEntity cq(Parcel parcel) {
        Bundle bundle = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    bundle = C0541a.m1943q(parcel, F);
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
            return new AppContentConditionEntity(i, str3, str2, str, bundle);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cq(parcel);
    }

    public AppContentConditionEntity[] dL(int i) {
        return new AppContentConditionEntity[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dL(i);
    }
}
