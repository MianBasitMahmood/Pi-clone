package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

public class ExtendedGameEntityCreator implements Creator<ExtendedGameEntity> {
    static void m4002a(ExtendedGameEntity extendedGameEntity, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, extendedGameEntity.mi(), i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, extendedGameEntity.getVersionCode());
        C0542b.m1980c(parcel, 2, extendedGameEntity.lZ());
        C0542b.m1971a(parcel, 3, extendedGameEntity.ma());
        C0542b.m1980c(parcel, 4, extendedGameEntity.mb());
        C0542b.m1960a(parcel, 5, extendedGameEntity.mc());
        C0542b.m1960a(parcel, 6, extendedGameEntity.md());
        C0542b.m1968a(parcel, 7, extendedGameEntity.me(), false);
        C0542b.m1960a(parcel, 8, extendedGameEntity.mf());
        C0542b.m1968a(parcel, 9, extendedGameEntity.mg(), false);
        C0542b.m1981c(parcel, 10, extendedGameEntity.lY(), false);
        C0542b.m1964a(parcel, 11, extendedGameEntity.mh(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cu(parcel);
    }

    public ExtendedGameEntity cu(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        String str = null;
        long j3 = 0;
        String str2 = null;
        ArrayList arrayList = null;
        SnapshotMetadataEntity snapshotMetadataEntity = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    gameEntity = (GameEntity) C0541a.m1922a(parcel, F, GameEntity.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    j3 = C0541a.m1935i(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    arrayList = C0541a.m1928c(parcel, F, GameBadgeEntity.CREATOR);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    snapshotMetadataEntity = (SnapshotMetadataEntity) C0541a.m1922a(parcel, F, SnapshotMetadataEntity.CREATOR);
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
            return new ExtendedGameEntity(i, gameEntity, i2, z, i3, j, j2, str, j3, str2, arrayList, snapshotMetadataEntity);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public ExtendedGameEntity[] eb(int i) {
        return new ExtendedGameEntity[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eb(i);
    }
}
