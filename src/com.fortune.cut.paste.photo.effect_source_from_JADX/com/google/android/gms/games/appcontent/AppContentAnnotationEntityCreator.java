package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class AppContentAnnotationEntityCreator implements Creator<AppContentAnnotationEntity> {
    static void m2847a(AppContentAnnotationEntity appContentAnnotationEntity, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, appContentAnnotationEntity.getDescription(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, appContentAnnotationEntity.getVersionCode());
        C0542b.m1964a(parcel, 2, appContentAnnotationEntity.kL(), i, false);
        C0542b.m1968a(parcel, 3, appContentAnnotationEntity.getTitle(), false);
        C0542b.m1968a(parcel, 4, appContentAnnotationEntity.getType(), false);
        C0542b.m1956H(parcel, H);
    }

    public AppContentAnnotationEntity co(Parcel parcel) {
        String str = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str2 = null;
        Uri uri = null;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    uri = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
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
            return new AppContentAnnotationEntity(i, str3, uri, str2, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return co(parcel);
    }

    public AppContentAnnotationEntity[] dJ(int i) {
        return new AppContentAnnotationEntity[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dJ(i);
    }
}
