package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataBuffer;

public final class GameBadgeBuffer extends DataBuffer<GameBadge> {
    public final GameBadge ec(int i) {
        return new GameBadgeRef(this.JG, i);
    }

    public final /* synthetic */ Object get(int i) {
        return ec(i);
    }
}
