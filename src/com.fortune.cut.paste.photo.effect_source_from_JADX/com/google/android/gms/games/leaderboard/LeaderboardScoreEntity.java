package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.le;

public final class LeaderboardScoreEntity implements LeaderboardScore {
    private final PlayerEntity adA;
    private final String adB;
    private final String adC;
    private final String adD;
    private final long ads;
    private final String adt;
    private final String adu;
    private final long adv;
    private final long adw;
    private final String adx;
    private final Uri ady;
    private final Uri adz;

    public LeaderboardScoreEntity(LeaderboardScore leaderboardScore) {
        this.ads = leaderboardScore.getRank();
        this.adt = (String) jx.m5223i(leaderboardScore.getDisplayRank());
        this.adu = (String) jx.m5223i(leaderboardScore.getDisplayScore());
        this.adv = leaderboardScore.getRawScore();
        this.adw = leaderboardScore.getTimestampMillis();
        this.adx = leaderboardScore.getScoreHolderDisplayName();
        this.ady = leaderboardScore.getScoreHolderIconImageUri();
        this.adz = leaderboardScore.getScoreHolderHiResImageUri();
        Player scoreHolder = leaderboardScore.getScoreHolder();
        this.adA = scoreHolder == null ? null : (PlayerEntity) scoreHolder.freeze();
        this.adB = leaderboardScore.getScoreTag();
        this.adC = leaderboardScore.getScoreHolderIconImageUrl();
        this.adD = leaderboardScore.getScoreHolderHiResImageUrl();
    }

    static int m4025a(LeaderboardScore leaderboardScore) {
        return jv.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    static boolean m4026a(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return jv.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && jv.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && jv.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && jv.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && jv.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && jv.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && jv.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && jv.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && jv.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) && jv.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag());
    }

    static String m4027b(LeaderboardScore leaderboardScore) {
        return jv.m5212h(leaderboardScore).m5211a("Rank", Long.valueOf(leaderboardScore.getRank())).m5211a("DisplayRank", leaderboardScore.getDisplayRank()).m5211a("Score", Long.valueOf(leaderboardScore.getRawScore())).m5211a("DisplayScore", leaderboardScore.getDisplayScore()).m5211a("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).m5211a("DisplayName", leaderboardScore.getScoreHolderDisplayName()).m5211a("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).m5211a("IconImageUrl", leaderboardScore.getScoreHolderIconImageUrl()).m5211a("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).m5211a("HiResImageUrl", leaderboardScore.getScoreHolderHiResImageUrl()).m5211a("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).m5211a("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }

    public final boolean equals(Object obj) {
        return m4026a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return mJ();
    }

    public final String getDisplayRank() {
        return this.adt;
    }

    public final void getDisplayRank(CharArrayBuffer charArrayBuffer) {
        le.m5324b(this.adt, charArrayBuffer);
    }

    public final String getDisplayScore() {
        return this.adu;
    }

    public final void getDisplayScore(CharArrayBuffer charArrayBuffer) {
        le.m5324b(this.adu, charArrayBuffer);
    }

    public final long getRank() {
        return this.ads;
    }

    public final long getRawScore() {
        return this.adv;
    }

    public final Player getScoreHolder() {
        return this.adA;
    }

    public final String getScoreHolderDisplayName() {
        return this.adA == null ? this.adx : this.adA.getDisplayName();
    }

    public final void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer) {
        if (this.adA == null) {
            le.m5324b(this.adx, charArrayBuffer);
        } else {
            this.adA.getDisplayName(charArrayBuffer);
        }
    }

    public final Uri getScoreHolderHiResImageUri() {
        return this.adA == null ? this.adz : this.adA.getHiResImageUri();
    }

    public final String getScoreHolderHiResImageUrl() {
        return this.adA == null ? this.adD : this.adA.getHiResImageUrl();
    }

    public final Uri getScoreHolderIconImageUri() {
        return this.adA == null ? this.ady : this.adA.getIconImageUri();
    }

    public final String getScoreHolderIconImageUrl() {
        return this.adA == null ? this.adC : this.adA.getIconImageUrl();
    }

    public final String getScoreTag() {
        return this.adB;
    }

    public final long getTimestampMillis() {
        return this.adw;
    }

    public final int hashCode() {
        return m4025a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final LeaderboardScore mJ() {
        return this;
    }

    public final String toString() {
        return m4027b(this);
    }
}
