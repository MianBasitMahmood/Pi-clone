package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

public class TurnBasedMatchEntityCreator implements Creator<TurnBasedMatchEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m4066a(TurnBasedMatchEntity turnBasedMatchEntity, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, turnBasedMatchEntity.getGame(), i, false);
        C0542b.m1968a(parcel, 2, turnBasedMatchEntity.getMatchId(), false);
        C0542b.m1968a(parcel, 3, turnBasedMatchEntity.getCreatorId(), false);
        C0542b.m1960a(parcel, 4, turnBasedMatchEntity.getCreationTimestamp());
        C0542b.m1968a(parcel, 5, turnBasedMatchEntity.getLastUpdaterId(), false);
        C0542b.m1960a(parcel, 6, turnBasedMatchEntity.getLastUpdatedTimestamp());
        C0542b.m1968a(parcel, 7, turnBasedMatchEntity.getPendingParticipantId(), false);
        C0542b.m1980c(parcel, 8, turnBasedMatchEntity.getStatus());
        C0542b.m1980c(parcel, 10, turnBasedMatchEntity.getVariant());
        C0542b.m1980c(parcel, 11, turnBasedMatchEntity.getVersion());
        C0542b.m1972a(parcel, 12, turnBasedMatchEntity.getData(), false);
        C0542b.m1981c(parcel, 13, turnBasedMatchEntity.getParticipants(), false);
        C0542b.m1968a(parcel, 14, turnBasedMatchEntity.getRematchId(), false);
        C0542b.m1972a(parcel, 15, turnBasedMatchEntity.getPreviousMatchData(), false);
        C0542b.m1961a(parcel, 17, turnBasedMatchEntity.getAutoMatchCriteria(), false);
        C0542b.m1980c(parcel, 16, turnBasedMatchEntity.getMatchNumber());
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, turnBasedMatchEntity.getVersionCode());
        C0542b.m1971a(parcel, 19, turnBasedMatchEntity.isLocallyModified());
        C0542b.m1980c(parcel, 18, turnBasedMatchEntity.getTurnStatus());
        C0542b.m1968a(parcel, 21, turnBasedMatchEntity.getDescriptionParticipantId(), false);
        C0542b.m1968a(parcel, 20, turnBasedMatchEntity.getDescription(), false);
        C0542b.m1956H(parcel, H);
    }

    public TurnBasedMatchEntity createFromParcel(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        String str2 = null;
        long j = 0;
        String str3 = null;
        long j2 = 0;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        byte[] bArr = null;
        ArrayList arrayList = null;
        String str5 = null;
        byte[] bArr2 = null;
        int i5 = 0;
        Bundle bundle = null;
        int i6 = 0;
        boolean z = false;
        String str6 = null;
        String str7 = null;
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
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    i4 = C0541a.m1933g(parcel, F);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    bArr = C0541a.m1944r(parcel, F);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    arrayList = C0541a.m1928c(parcel, F, ParticipantEntity.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    str5 = C0541a.m1941o(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    bArr2 = C0541a.m1944r(parcel, F);
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    i5 = C0541a.m1933g(parcel, F);
                    break;
                case 17:
                    bundle = C0541a.m1943q(parcel, F);
                    break;
                case 18:
                    i6 = C0541a.m1933g(parcel, F);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case 20:
                    str6 = C0541a.m1941o(parcel, F);
                    break;
                case 21:
                    str7 = C0541a.m1941o(parcel, F);
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
            return new TurnBasedMatchEntity(i, gameEntity, str, str2, j, str3, j2, str4, i2, i3, i4, bArr, arrayList, str5, bArr2, i5, bundle, i6, z, str6, str7);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public TurnBasedMatchEntity[] newArray(int i) {
        return new TurnBasedMatchEntity[i];
    }
}
