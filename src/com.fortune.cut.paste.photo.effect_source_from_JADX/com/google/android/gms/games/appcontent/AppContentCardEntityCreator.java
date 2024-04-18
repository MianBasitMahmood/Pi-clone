package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

public class AppContentCardEntityCreator implements Creator<AppContentCardEntity> {
    static void m2851a(AppContentCardEntity appContentCardEntity, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1981c(parcel, 1, appContentCardEntity.getActions(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, appContentCardEntity.getVersionCode());
        C0542b.m1981c(parcel, 2, appContentCardEntity.kN(), false);
        C0542b.m1981c(parcel, 3, appContentCardEntity.kH(), false);
        C0542b.m1968a(parcel, 4, appContentCardEntity.kI(), false);
        C0542b.m1980c(parcel, 5, appContentCardEntity.kO());
        C0542b.m1968a(parcel, 6, appContentCardEntity.getDescription(), false);
        C0542b.m1961a(parcel, 7, appContentCardEntity.kP(), false);
        C0542b.m1964a(parcel, 8, appContentCardEntity.getIconImageUri(), i, false);
        C0542b.m1964a(parcel, 9, appContentCardEntity.kL(), i, false);
        C0542b.m1968a(parcel, 10, appContentCardEntity.kQ(), false);
        C0542b.m1968a(parcel, 11, appContentCardEntity.getTitle(), false);
        C0542b.m1980c(parcel, 12, appContentCardEntity.kR());
        C0542b.m1968a(parcel, 13, appContentCardEntity.getType(), false);
        C0542b.m1956H(parcel, H);
    }

    public AppContentCardEntity cp(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        String str = null;
        int i2 = 0;
        String str2 = null;
        Bundle bundle = null;
        Uri uri = null;
        Uri uri2 = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        String str5 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    arrayList = C0541a.m1928c(parcel, F, AppContentActionEntity.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    arrayList2 = C0541a.m1928c(parcel, F, AppContentAnnotationEntity.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    arrayList3 = C0541a.m1928c(parcel, F, AppContentConditionEntity.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    bundle = C0541a.m1943q(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    uri = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    uri2 = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    str5 = C0541a.m1941o(parcel, F);
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
            return new AppContentCardEntity(i, arrayList, arrayList2, arrayList3, str, i2, str2, bundle, uri, uri2, str3, str4, i3, str5);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cp(parcel);
    }

    public AppContentCardEntity[] dK(int i) {
        return new AppContentCardEntity[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dK(i);
    }
}
