package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class ParticipantEntityCreator implements Creator<ParticipantEntity> {
    static void m4039a(ParticipantEntity participantEntity, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, participantEntity.getParticipantId(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, participantEntity.getVersionCode());
        C0542b.m1968a(parcel, 2, participantEntity.getDisplayName(), false);
        C0542b.m1964a(parcel, 3, participantEntity.getIconImageUri(), i, false);
        C0542b.m1964a(parcel, 4, participantEntity.getHiResImageUri(), i, false);
        C0542b.m1980c(parcel, 5, participantEntity.getStatus());
        C0542b.m1968a(parcel, 6, participantEntity.le(), false);
        C0542b.m1971a(parcel, 7, participantEntity.isConnectedToRoom());
        C0542b.m1964a(parcel, 8, participantEntity.getPlayer(), i, false);
        C0542b.m1980c(parcel, 9, participantEntity.getCapabilities());
        C0542b.m1964a(parcel, 10, participantEntity.getResult(), i, false);
        C0542b.m1968a(parcel, 11, participantEntity.getIconImageUrl(), false);
        C0542b.m1968a(parcel, 12, participantEntity.getHiResImageUrl(), false);
        C0542b.m1956H(parcel, H);
    }

    public ParticipantEntity cA(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        int i2 = 0;
        String str3 = null;
        boolean z = false;
        PlayerEntity playerEntity = null;
        int i3 = 0;
        ParticipantResult participantResult = null;
        String str4 = null;
        String str5 = null;
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
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    playerEntity = (PlayerEntity) C0541a.m1922a(parcel, F, PlayerEntity.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    participantResult = (ParticipantResult) C0541a.m1922a(parcel, F, ParticipantResult.CREATOR);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    str5 = C0541a.m1941o(parcel, F);
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
            return new ParticipantEntity(i, str, str2, uri, uri2, i2, str3, z, playerEntity, i3, participantResult, str4, str5);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cA(parcel);
    }

    public ParticipantEntity[] em(int i) {
        return new ParticipantEntity[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return em(i);
    }
}
