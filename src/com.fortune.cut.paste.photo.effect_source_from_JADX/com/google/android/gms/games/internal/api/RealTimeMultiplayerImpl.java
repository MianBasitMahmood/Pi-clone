package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.C0509d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import java.util.List;

public final class RealTimeMultiplayerImpl implements RealTimeMultiplayer {
    private static <L> C0509d<L> m3930a(GoogleApiClient googleApiClient, L l) {
        return l == null ? null : googleApiClient.m1807d(l);
    }

    public final void create(GoogleApiClient googleApiClient, RoomConfig roomConfig) {
        Games.m2826d(googleApiClient).m3163a(googleApiClient.m1807d(roomConfig.getRoomUpdateListener()), m3930a(googleApiClient, roomConfig.getRoomStatusUpdateListener()), m3930a(googleApiClient, roomConfig.getMessageReceivedListener()), roomConfig);
    }

    public final void declineInvitation(GoogleApiClient googleApiClient, String str) {
        Games.m2826d(googleApiClient).m3236q(str, 0);
    }

    public final void dismissInvitation(GoogleApiClient googleApiClient, String str) {
        Games.m2826d(googleApiClient).m3235p(str, 0);
    }

    public final Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2) {
        return Games.m2826d(googleApiClient).m3167b(i, i2, true);
    }

    public final Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2, boolean z) {
        return Games.m2826d(googleApiClient).m3167b(i, i2, z);
    }

    public final RealTimeSocket getSocketForParticipant(GoogleApiClient googleApiClient, String str, String str2) {
        return Games.m2826d(googleApiClient).m3237s(str, str2);
    }

    public final Intent getWaitingRoomIntent(GoogleApiClient googleApiClient, Room room, int i) {
        return Games.m2826d(googleApiClient).m3124a(room, i);
    }

    public final void join(GoogleApiClient googleApiClient, RoomConfig roomConfig) {
        Games.m2826d(googleApiClient).m3184b(googleApiClient.m1807d(roomConfig.getRoomUpdateListener()), m3930a(googleApiClient, roomConfig.getRoomStatusUpdateListener()), m3930a(googleApiClient, roomConfig.getMessageReceivedListener()), roomConfig);
    }

    public final void leave(GoogleApiClient googleApiClient, RoomUpdateListener roomUpdateListener, String str) {
        Games.m2826d(googleApiClient).m3164a(googleApiClient.m1807d(roomUpdateListener), str);
    }

    public final int sendReliableMessage(GoogleApiClient googleApiClient, ReliableMessageSentCallback reliableMessageSentCallback, byte[] bArr, String str, String str2) {
        return Games.m2826d(googleApiClient).m3120a(m3930a(googleApiClient, reliableMessageSentCallback), bArr, str, str2);
    }

    public final int sendUnreliableMessage(GoogleApiClient googleApiClient, byte[] bArr, String str, String str2) {
        return Games.m2826d(googleApiClient).m3121a(bArr, str, new String[]{str2});
    }

    public final int sendUnreliableMessage(GoogleApiClient googleApiClient, byte[] bArr, String str, List<String> list) {
        return Games.m2826d(googleApiClient).m3121a(bArr, str, (String[]) list.toArray(new String[list.size()]));
    }

    public final int sendUnreliableMessageToOthers(GoogleApiClient googleApiClient, byte[] bArr, String str) {
        return Games.m2826d(googleApiClient).m3197d(bArr, str);
    }
}
