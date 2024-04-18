package com.google.android.gms.games.internal.player;

import android.net.Uri;
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

public class MostRecentGameInfoEntityCreator implements Creator<MostRecentGameInfoEntity> {
    static void m4016a(MostRecentGameInfoEntity mostRecentGameInfoEntity, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, mostRecentGameInfoEntity.mw(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, mostRecentGameInfoEntity.getVersionCode());
        C0542b.m1968a(parcel, 2, mostRecentGameInfoEntity.mx(), false);
        C0542b.m1960a(parcel, 3, mostRecentGameInfoEntity.my());
        C0542b.m1964a(parcel, 4, mostRecentGameInfoEntity.mz(), i, false);
        C0542b.m1964a(parcel, 5, mostRecentGameInfoEntity.mA(), i, false);
        C0542b.m1964a(parcel, 6, mostRecentGameInfoEntity.mB(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cx(parcel);
    }

    public MostRecentGameInfoEntity cx(Parcel parcel) {
        Uri uri = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        long j = 0;
        Uri uri2 = null;
        Uri uri3 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    uri3 = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    uri2 = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case Error.OTHER /*6*/:
                    uri = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
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
            return new MostRecentGameInfoEntity(i, str2, str, j, uri3, uri2, uri);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public MostRecentGameInfoEntity[] ei(int i) {
        return new MostRecentGameInfoEntity[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return ei(i);
    }
}
