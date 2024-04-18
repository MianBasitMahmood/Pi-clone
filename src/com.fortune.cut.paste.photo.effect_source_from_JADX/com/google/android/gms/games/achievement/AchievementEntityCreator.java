package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class AchievementEntityCreator implements Creator<AchievementEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m2839a(AchievementEntity achievementEntity, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, achievementEntity.getAchievementId(), false);
        C0542b.m1980c(parcel, 2, achievementEntity.getType());
        C0542b.m1968a(parcel, 3, achievementEntity.getName(), false);
        C0542b.m1968a(parcel, 4, achievementEntity.getDescription(), false);
        C0542b.m1964a(parcel, 5, achievementEntity.getUnlockedImageUri(), i, false);
        C0542b.m1968a(parcel, 6, achievementEntity.getUnlockedImageUrl(), false);
        C0542b.m1964a(parcel, 7, achievementEntity.getRevealedImageUri(), i, false);
        C0542b.m1968a(parcel, 8, achievementEntity.getRevealedImageUrl(), false);
        C0542b.m1980c(parcel, 9, achievementEntity.getTotalSteps());
        C0542b.m1968a(parcel, 10, achievementEntity.getFormattedTotalSteps(), false);
        C0542b.m1964a(parcel, 11, achievementEntity.getPlayer(), i, false);
        C0542b.m1980c(parcel, 12, achievementEntity.getState());
        C0542b.m1980c(parcel, 13, achievementEntity.getCurrentSteps());
        C0542b.m1968a(parcel, 14, achievementEntity.getFormattedCurrentSteps(), false);
        C0542b.m1960a(parcel, 15, achievementEntity.getLastUpdatedTimestamp());
        C0542b.m1960a(parcel, 16, achievementEntity.getXpValue());
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, achievementEntity.getVersionCode());
        C0542b.m1956H(parcel, H);
    }

    public AchievementEntity createFromParcel(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        Uri uri = null;
        String str4 = null;
        Uri uri2 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        PlayerEntity playerEntity = null;
        int i4 = 0;
        int i5 = 0;
        String str7 = null;
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    uri = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case Error.OTHER /*6*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    uri2 = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    str5 = C0541a.m1941o(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    str6 = C0541a.m1941o(parcel, F);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    playerEntity = (PlayerEntity) C0541a.m1922a(parcel, F, PlayerEntity.CREATOR);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    i4 = C0541a.m1933g(parcel, F);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    i5 = C0541a.m1933g(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    str7 = C0541a.m1941o(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    j2 = C0541a.m1935i(parcel, F);
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
            return new AchievementEntity(i, str, i2, str2, str3, uri, str4, uri2, str5, i3, str6, playerEntity, i4, i5, str7, j, j2);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public AchievementEntity[] newArray(int i) {
        return new AchievementEntity[i];
    }
}
