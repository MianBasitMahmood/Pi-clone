package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Creator<GameRequestEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m4083a(GameRequestEntity gameRequestEntity, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, gameRequestEntity.getGame(), i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, gameRequestEntity.getVersionCode());
        C0542b.m1964a(parcel, 2, gameRequestEntity.getSender(), i, false);
        C0542b.m1972a(parcel, 3, gameRequestEntity.getData(), false);
        C0542b.m1968a(parcel, 4, gameRequestEntity.getRequestId(), false);
        C0542b.m1981c(parcel, 5, gameRequestEntity.getRecipients(), false);
        C0542b.m1980c(parcel, 7, gameRequestEntity.getType());
        C0542b.m1960a(parcel, 9, gameRequestEntity.getCreationTimestamp());
        C0542b.m1960a(parcel, 10, gameRequestEntity.getExpirationTimestamp());
        C0542b.m1961a(parcel, 11, gameRequestEntity.mS(), false);
        C0542b.m1980c(parcel, 12, gameRequestEntity.getStatus());
        C0542b.m1956H(parcel, H);
    }

    public GameRequestEntity createFromParcel(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        byte[] bArr = null;
        String str = null;
        ArrayList arrayList = null;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    gameEntity = (GameEntity) C0541a.m1922a(parcel, F, GameEntity.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    playerEntity = (PlayerEntity) C0541a.m1922a(parcel, F, PlayerEntity.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    bArr = C0541a.m1944r(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    arrayList = C0541a.m1928c(parcel, F, PlayerEntity.CREATOR);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    bundle = C0541a.m1943q(parcel, F);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    i3 = C0541a.m1933g(parcel, F);
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
            return new GameRequestEntity(i, gameEntity, playerEntity, bArr, str, arrayList, i2, j, j2, bundle, i3);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public GameRequestEntity[] newArray(int i) {
        return new GameRequestEntity[i];
    }
}
