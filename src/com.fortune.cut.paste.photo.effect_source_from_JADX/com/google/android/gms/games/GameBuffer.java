package com.google.android.gms.games;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class GameBuffer extends DataBuffer<Game> {
    public GameBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public final Game get(int i) {
        return new GameRef(this.JG, i);
    }
}
