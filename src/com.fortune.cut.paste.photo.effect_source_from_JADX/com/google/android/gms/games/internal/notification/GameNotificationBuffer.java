package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataBuffer;

public final class GameNotificationBuffer extends DataBuffer<GameNotification> {
    public final GameNotification eh(int i) {
        return new GameNotificationRef(this.JG, i);
    }

    public final /* synthetic */ Object get(int i) {
        return eh(i);
    }
}
