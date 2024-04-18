package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class GameInstanceBuffer extends DataBuffer<GameInstance> {
    public GameInstanceBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public final GameInstance ee(int i) {
        return new GameInstanceRef(this.JG, i);
    }

    public final /* synthetic */ Object get(int i) {
        return ee(i);
    }
}
