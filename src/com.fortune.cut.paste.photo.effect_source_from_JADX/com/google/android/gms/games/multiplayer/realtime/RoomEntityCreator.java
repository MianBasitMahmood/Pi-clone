package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

public class RoomEntityCreator implements Creator<RoomEntity> {
    static void m4047a(RoomEntity roomEntity, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, roomEntity.getRoomId(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, roomEntity.getVersionCode());
        C0542b.m1968a(parcel, 2, roomEntity.getCreatorId(), false);
        C0542b.m1960a(parcel, 3, roomEntity.getCreationTimestamp());
        C0542b.m1980c(parcel, 4, roomEntity.getStatus());
        C0542b.m1968a(parcel, 5, roomEntity.getDescription(), false);
        C0542b.m1980c(parcel, 6, roomEntity.getVariant());
        C0542b.m1961a(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        C0542b.m1981c(parcel, 8, roomEntity.getParticipants(), false);
        C0542b.m1980c(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        C0542b.m1956H(parcel, H);
    }

    public RoomEntity cC(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int G = C0541a.m1920G(parcel);
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    bundle = C0541a.m1943q(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    arrayList = C0541a.m1928c(parcel, F, ParticipantEntity.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i4 = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new RoomEntity(i4, str3, str2, j, i3, str, i2, bundle, arrayList, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cC(parcel);
    }

    public RoomEntity[] eo(int i) {
        return new RoomEntity[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eo(i);
    }
}
