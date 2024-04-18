package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class EventEntityCreator implements Creator<EventEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m2879a(EventEntity eventEntity, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, eventEntity.getEventId(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, eventEntity.getVersionCode());
        C0542b.m1968a(parcel, 2, eventEntity.getName(), false);
        C0542b.m1968a(parcel, 3, eventEntity.getDescription(), false);
        C0542b.m1964a(parcel, 4, eventEntity.getIconImageUri(), i, false);
        C0542b.m1968a(parcel, 5, eventEntity.getIconImageUrl(), false);
        C0542b.m1964a(parcel, 6, eventEntity.getPlayer(), i, false);
        C0542b.m1960a(parcel, 7, eventEntity.getValue());
        C0542b.m1968a(parcel, 8, eventEntity.getFormattedValue(), false);
        C0542b.m1971a(parcel, 9, eventEntity.isVisible());
        C0542b.m1956H(parcel, H);
    }

    public EventEntity createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int G = C0541a.m1920G(parcel);
        long j = 0;
        Player player = null;
        String str2 = null;
        Uri uri = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str5 = C0541a.m1941o(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    uri = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    player = (PlayerEntity) C0541a.m1922a(parcel, F, PlayerEntity.CREATOR);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
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
            return new EventEntity(i, str5, str4, str3, uri, str2, player, j, str, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public EventEntity[] newArray(int i) {
        return new EventEntity[i];
    }
}
