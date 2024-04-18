package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class PlayerEntityCreator implements Creator<PlayerEntity> {
    static void m2829a(PlayerEntity playerEntity, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, playerEntity.getPlayerId(), false);
        C0542b.m1968a(parcel, 2, playerEntity.getDisplayName(), false);
        C0542b.m1964a(parcel, 3, playerEntity.getIconImageUri(), i, false);
        C0542b.m1964a(parcel, 4, playerEntity.getHiResImageUri(), i, false);
        C0542b.m1960a(parcel, 5, playerEntity.getRetrievedTimestamp());
        C0542b.m1980c(parcel, 6, playerEntity.kE());
        C0542b.m1960a(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        C0542b.m1968a(parcel, 8, playerEntity.getIconImageUrl(), false);
        C0542b.m1968a(parcel, 9, playerEntity.getHiResImageUrl(), false);
        C0542b.m1968a(parcel, 14, playerEntity.getTitle(), false);
        C0542b.m1964a(parcel, 15, playerEntity.kF(), i, false);
        C0542b.m1964a(parcel, 16, playerEntity.getLevelInfo(), i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, playerEntity.getVersionCode());
        C0542b.m1971a(parcel, 18, playerEntity.isProfileVisible());
        C0542b.m1956H(parcel, H);
    }

    public PlayerEntity cm(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        PlayerLevelInfo playerLevelInfo = null;
        boolean z = false;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    uri = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    uri2 = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    str5 = C0541a.m1941o(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    mostRecentGameInfoEntity = (MostRecentGameInfoEntity) C0541a.m1922a(parcel, F, MostRecentGameInfoEntity.CREATOR);
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    playerLevelInfo = (PlayerLevelInfo) C0541a.m1922a(parcel, F, PlayerLevelInfo.CREATOR);
                    break;
                case 18:
                    z = C0541a.m1929c(parcel, F);
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
            return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4, str5, mostRecentGameInfoEntity, playerLevelInfo, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cm(parcel);
    }

    public PlayerEntity[] dH(int i) {
        return new PlayerEntity[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dH(i);
    }
}
