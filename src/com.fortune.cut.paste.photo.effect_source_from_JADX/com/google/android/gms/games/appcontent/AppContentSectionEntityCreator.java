package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
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
import java.util.ArrayList;

public class AppContentSectionEntityCreator implements Creator<AppContentSectionEntity> {
    static void m2861a(AppContentSectionEntity appContentSectionEntity, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1981c(parcel, 1, appContentSectionEntity.getActions(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, appContentSectionEntity.getVersionCode());
        C0542b.m1964a(parcel, 2, appContentSectionEntity.kY(), i, false);
        C0542b.m1981c(parcel, 3, appContentSectionEntity.kZ(), false);
        C0542b.m1968a(parcel, 4, appContentSectionEntity.kI(), false);
        C0542b.m1961a(parcel, 5, appContentSectionEntity.kP(), false);
        C0542b.m1968a(parcel, 6, appContentSectionEntity.kQ(), false);
        C0542b.m1968a(parcel, 7, appContentSectionEntity.getTitle(), false);
        C0542b.m1968a(parcel, 8, appContentSectionEntity.getType(), false);
        C0542b.m1956H(parcel, H);
    }

    public AppContentSectionEntity cr(Parcel parcel) {
        String str = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        String str4 = null;
        ArrayList arrayList = null;
        Uri uri = null;
        ArrayList arrayList2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    arrayList2 = C0541a.m1928c(parcel, F, AppContentActionEntity.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    uri = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    arrayList = C0541a.m1928c(parcel, F, AppContentCardEntity.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    bundle = C0541a.m1943q(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    str = C0541a.m1941o(parcel, F);
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
            return new AppContentSectionEntity(i, arrayList2, uri, arrayList, str4, bundle, str3, str2, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cr(parcel);
    }

    public AppContentSectionEntity[] dM(int i) {
        return new AppContentSectionEntity[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dM(i);
    }
}
