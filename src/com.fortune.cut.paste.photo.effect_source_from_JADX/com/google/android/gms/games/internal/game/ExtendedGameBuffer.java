package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.C0527g;
import com.google.android.gms.common.data.DataHolder;

public final class ExtendedGameBuffer extends C0527g<ExtendedGame> {
    public ExtendedGameBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected final /* synthetic */ Object m4000f(int i, int i2) {
        return m4001i(i, i2);
    }

    protected final String ha() {
        return "external_game_id";
    }

    protected final ExtendedGame m4001i(int i, int i2) {
        return new ExtendedGameRef(this.JG, i, i2);
    }
}
