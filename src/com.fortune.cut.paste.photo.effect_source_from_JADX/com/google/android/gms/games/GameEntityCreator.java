package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class GameEntityCreator implements Creator<GameEntity> {
    static void m2813a(GameEntity gameEntity, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, gameEntity.getApplicationId(), false);
        C0542b.m1968a(parcel, 2, gameEntity.getDisplayName(), false);
        C0542b.m1968a(parcel, 3, gameEntity.getPrimaryCategory(), false);
        C0542b.m1968a(parcel, 4, gameEntity.getSecondaryCategory(), false);
        C0542b.m1968a(parcel, 5, gameEntity.getDescription(), false);
        C0542b.m1968a(parcel, 6, gameEntity.getDeveloperName(), false);
        C0542b.m1964a(parcel, 7, gameEntity.getIconImageUri(), i, false);
        C0542b.m1964a(parcel, 8, gameEntity.getHiResImageUri(), i, false);
        C0542b.m1964a(parcel, 9, gameEntity.getFeaturedImageUri(), i, false);
        C0542b.m1971a(parcel, 10, gameEntity.ky());
        C0542b.m1971a(parcel, 11, gameEntity.kA());
        C0542b.m1968a(parcel, 12, gameEntity.kB(), false);
        C0542b.m1980c(parcel, 13, gameEntity.kC());
        C0542b.m1980c(parcel, 14, gameEntity.getAchievementTotalCount());
        C0542b.m1980c(parcel, 15, gameEntity.getLeaderboardCount());
        C0542b.m1971a(parcel, 17, gameEntity.isTurnBasedMultiplayerEnabled());
        C0542b.m1971a(parcel, 16, gameEntity.isRealTimeMultiplayerEnabled());
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, gameEntity.getVersionCode());
        C0542b.m1968a(parcel, 19, gameEntity.getHiResImageUrl(), false);
        C0542b.m1968a(parcel, 18, gameEntity.getIconImageUrl(), false);
        C0542b.m1971a(parcel, 21, gameEntity.isMuted());
        C0542b.m1968a(parcel, 20, gameEntity.getFeaturedImageUrl(), false);
        C0542b.m1971a(parcel, 23, gameEntity.areSnapshotsEnabled());
        C0542b.m1971a(parcel, 22, gameEntity.kz());
        C0542b.m1968a(parcel, 24, gameEntity.getThemeColor(), false);
        C0542b.m1956H(parcel, H);
    }

    public GameEntity cl(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean z = false;
        boolean z2 = false;
        String str7 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        String str11 = null;
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
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str5 = C0541a.m1941o(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    str6 = C0541a.m1941o(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    uri = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    uri2 = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    uri3 = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    z2 = C0541a.m1929c(parcel, F);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    str7 = C0541a.m1941o(parcel, F);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    i4 = C0541a.m1933g(parcel, F);
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    z3 = C0541a.m1929c(parcel, F);
                    break;
                case 17:
                    z4 = C0541a.m1929c(parcel, F);
                    break;
                case 18:
                    str8 = C0541a.m1941o(parcel, F);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    str9 = C0541a.m1941o(parcel, F);
                    break;
                case 20:
                    str10 = C0541a.m1941o(parcel, F);
                    break;
                case 21:
                    z5 = C0541a.m1929c(parcel, F);
                    break;
                case 22:
                    z6 = C0541a.m1929c(parcel, F);
                    break;
                case 23:
                    z7 = C0541a.m1929c(parcel, F);
                    break;
                case 24:
                    str11 = C0541a.m1941o(parcel, F);
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
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4, z3, z4, str8, str9, str10, z5, z6, z7, str11);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cl(parcel);
    }

    public GameEntity[] dG(int i) {
        return new GameEntity[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dG(i);
    }
}
