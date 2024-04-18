package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0527g;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardBuffer extends C0527g<Leaderboard> {
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected final /* synthetic */ Object m4020f(int i, int i2) {
        return m4021j(i, i2);
    }

    protected final String ha() {
        return "external_leaderboard_id";
    }

    protected final Leaderboard m4021j(int i, int i2) {
        return new LeaderboardRef(this.JG, i, i2);
    }
}
