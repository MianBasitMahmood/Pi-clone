package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

public class InvitationEntityCreator implements Creator<InvitationEntity> {
    static void m4034a(InvitationEntity invitationEntity, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, invitationEntity.getGame(), i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, invitationEntity.getVersionCode());
        C0542b.m1968a(parcel, 2, invitationEntity.getInvitationId(), false);
        C0542b.m1960a(parcel, 3, invitationEntity.getCreationTimestamp());
        C0542b.m1980c(parcel, 4, invitationEntity.getInvitationType());
        C0542b.m1964a(parcel, 5, invitationEntity.getInviter(), i, false);
        C0542b.m1981c(parcel, 6, invitationEntity.getParticipants(), false);
        C0542b.m1980c(parcel, 7, invitationEntity.getVariant());
        C0542b.m1980c(parcel, 8, invitationEntity.getAvailableAutoMatchSlots());
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cz(parcel);
    }

    public InvitationEntity cz(Parcel parcel) {
        ArrayList arrayList = null;
        int i = 0;
        int G = C0541a.m1920G(parcel);
        long j = 0;
        int i2 = 0;
        ParticipantEntity participantEntity = null;
        int i3 = 0;
        String str = null;
        GameEntity gameEntity = null;
        int i4 = 0;
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
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    participantEntity = (ParticipantEntity) C0541a.m1922a(parcel, F, ParticipantEntity.CREATOR);
                    break;
                case Error.OTHER /*6*/:
                    arrayList = C0541a.m1928c(parcel, F, ParticipantEntity.CREATOR);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
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
            return new InvitationEntity(i4, gameEntity, str, j, i3, participantEntity, arrayList, i2, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public InvitationEntity[] el(int i) {
        return new InvitationEntity[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return el(i);
    }
}
