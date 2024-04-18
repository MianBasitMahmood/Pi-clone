package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

public class QuestEntityCreator implements Creator<QuestEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m4076a(QuestEntity questEntity, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, questEntity.getGame(), i, false);
        C0542b.m1968a(parcel, 2, questEntity.getQuestId(), false);
        C0542b.m1960a(parcel, 3, questEntity.getAcceptedTimestamp());
        C0542b.m1964a(parcel, 4, questEntity.getBannerImageUri(), i, false);
        C0542b.m1968a(parcel, 5, questEntity.getBannerImageUrl(), false);
        C0542b.m1968a(parcel, 6, questEntity.getDescription(), false);
        C0542b.m1960a(parcel, 7, questEntity.getEndTimestamp());
        C0542b.m1960a(parcel, 8, questEntity.getLastUpdatedTimestamp());
        C0542b.m1964a(parcel, 9, questEntity.getIconImageUri(), i, false);
        C0542b.m1968a(parcel, 10, questEntity.getIconImageUrl(), false);
        C0542b.m1968a(parcel, 12, questEntity.getName(), false);
        C0542b.m1960a(parcel, 13, questEntity.mR());
        C0542b.m1960a(parcel, 14, questEntity.getStartTimestamp());
        C0542b.m1980c(parcel, 15, questEntity.getState());
        C0542b.m1981c(parcel, 17, questEntity.mQ(), false);
        C0542b.m1980c(parcel, 16, questEntity.getType());
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, questEntity.getVersionCode());
        C0542b.m1956H(parcel, H);
    }

    public QuestEntity createFromParcel(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        long j = 0;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        long j3 = 0;
        Uri uri2 = null;
        String str4 = null;
        String str5 = null;
        long j4 = 0;
        long j5 = 0;
        int i2 = 0;
        int i3 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    gameEntity = (GameEntity) C0541a.m1922a(parcel, F, GameEntity.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    uri = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    j3 = C0541a.m1935i(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    uri2 = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    str5 = C0541a.m1941o(parcel, F);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    j4 = C0541a.m1935i(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    j5 = C0541a.m1935i(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case 17:
                    arrayList = C0541a.m1928c(parcel, F, MilestoneEntity.CREATOR);
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
            return new QuestEntity(i, gameEntity, str, j, uri, str2, str3, j2, j3, uri2, str4, str5, j4, j5, i2, i3, arrayList);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public QuestEntity[] newArray(int i) {
        return new QuestEntity[i];
    }
}
