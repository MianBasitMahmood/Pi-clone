package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class LeaderboardScoreRef extends C0451d implements LeaderboardScore {
    private final PlayerRef adE;

    LeaderboardScoreRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.adE = new PlayerRef(dataHolder, i);
    }

    public final boolean equals(Object obj) {
        return LeaderboardScoreEntity.m4026a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return mJ();
    }

    public final String getDisplayRank() {
        return getString("display_rank");
    }

    public final void getDisplayRank(CharArrayBuffer charArrayBuffer) {
        m1654a("display_rank", charArrayBuffer);
    }

    public final String getDisplayScore() {
        return getString("display_score");
    }

    public final void getDisplayScore(CharArrayBuffer charArrayBuffer) {
        m1654a("display_score", charArrayBuffer);
    }

    public final long getRank() {
        return getLong("rank");
    }

    public final long getRawScore() {
        return getLong("raw_score");
    }

    public final Player getScoreHolder() {
        return aS("external_player_id") ? null : this.adE;
    }

    public final String getScoreHolderDisplayName() {
        return aS("external_player_id") ? getString("default_display_name") : this.adE.getDisplayName();
    }

    public final void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer) {
        if (aS("external_player_id")) {
            m1654a("default_display_name", charArrayBuffer);
        } else {
            this.adE.getDisplayName(charArrayBuffer);
        }
    }

    public final Uri getScoreHolderHiResImageUri() {
        return aS("external_player_id") ? null : this.adE.getHiResImageUri();
    }

    public final String getScoreHolderHiResImageUrl() {
        return aS("external_player_id") ? null : this.adE.getHiResImageUrl();
    }

    public final Uri getScoreHolderIconImageUri() {
        return aS("external_player_id") ? aR("default_display_image_uri") : this.adE.getIconImageUri();
    }

    public final String getScoreHolderIconImageUrl() {
        return aS("external_player_id") ? getString("default_display_image_url") : this.adE.getIconImageUrl();
    }

    public final String getScoreTag() {
        return getString("score_tag");
    }

    public final long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public final int hashCode() {
        return LeaderboardScoreEntity.m4025a(this);
    }

    public final LeaderboardScore mJ() {
        return new LeaderboardScoreEntity(this);
    }

    public final String toString() {
        return LeaderboardScoreEntity.m4027b(this);
    }
}
