package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.C0527g;
import com.google.android.gms.common.data.DataHolder;

public final class TurnBasedMatchBuffer extends C0527g<TurnBasedMatch> {
    public TurnBasedMatchBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected final /* synthetic */ Object m4057f(int i, int i2) {
        return m4058m(i, i2);
    }

    protected final String ha() {
        return "external_match_id";
    }

    protected final TurnBasedMatch m4058m(int i, int i2) {
        return new TurnBasedMatchRef(this.JG, i, i2);
    }
}
