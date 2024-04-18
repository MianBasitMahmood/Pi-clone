package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class GameSearchSuggestionBuffer extends DataBuffer<GameSearchSuggestion> {
    public GameSearchSuggestionBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public final GameSearchSuggestion ef(int i) {
        return new GameSearchSuggestionRef(this.JG, i);
    }

    public final /* synthetic */ Object get(int i) {
        return ef(i);
    }
}
