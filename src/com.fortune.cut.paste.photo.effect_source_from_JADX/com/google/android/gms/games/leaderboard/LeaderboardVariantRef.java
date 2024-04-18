package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardVariantRef extends C0451d implements LeaderboardVariant {
    LeaderboardVariantRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final boolean equals(Object obj) {
        return LeaderboardVariantEntity.m4029a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return mN();
    }

    public final int getCollection() {
        return getInteger("collection");
    }

    public final String getDisplayPlayerRank() {
        return getString("player_display_rank");
    }

    public final String getDisplayPlayerScore() {
        return getString("player_display_score");
    }

    public final long getNumScores() {
        return aS("total_scores") ? -1 : getLong("total_scores");
    }

    public final long getPlayerRank() {
        return aS("player_rank") ? -1 : getLong("player_rank");
    }

    public final String getPlayerScoreTag() {
        return getString("player_score_tag");
    }

    public final long getRawPlayerScore() {
        return aS("player_raw_score") ? -1 : getLong("player_raw_score");
    }

    public final int getTimeSpan() {
        return getInteger("timespan");
    }

    public final boolean hasPlayerInfo() {
        return !aS("player_raw_score");
    }

    public final int hashCode() {
        return LeaderboardVariantEntity.m4028a(this);
    }

    public final String mK() {
        return getString("top_page_token_next");
    }

    public final String mL() {
        return getString("window_page_token_prev");
    }

    public final String mM() {
        return getString("window_page_token_next");
    }

    public final LeaderboardVariant mN() {
        return new LeaderboardVariantEntity(this);
    }

    public final String toString() {
        return LeaderboardVariantEntity.m4030b(this);
    }
}
