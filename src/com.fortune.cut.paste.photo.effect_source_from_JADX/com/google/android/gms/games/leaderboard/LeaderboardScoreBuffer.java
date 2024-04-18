package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardScoreBuffer extends DataBuffer<LeaderboardScore> {
    private final LeaderboardScoreBufferHeader adr;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.adr = new LeaderboardScoreBufferHeader(dataHolder.gV());
    }

    public final LeaderboardScore get(int i) {
        return new LeaderboardScoreRef(this.JG, i);
    }

    public final LeaderboardScoreBufferHeader mH() {
        return this.adr;
    }
}
