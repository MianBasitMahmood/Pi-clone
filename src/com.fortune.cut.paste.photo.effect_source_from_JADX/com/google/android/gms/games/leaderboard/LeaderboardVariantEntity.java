package com.google.android.gms.games.leaderboard;

import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.jv;

public final class LeaderboardVariantEntity implements LeaderboardVariant {
    private final int adF;
    private final int adG;
    private final boolean adH;
    private final long adI;
    private final String adJ;
    private final long adK;
    private final String adL;
    private final String adM;
    private final long adN;
    private final String adO;
    private final String adP;
    private final String adQ;

    public LeaderboardVariantEntity(LeaderboardVariant leaderboardVariant) {
        this.adF = leaderboardVariant.getTimeSpan();
        this.adG = leaderboardVariant.getCollection();
        this.adH = leaderboardVariant.hasPlayerInfo();
        this.adI = leaderboardVariant.getRawPlayerScore();
        this.adJ = leaderboardVariant.getDisplayPlayerScore();
        this.adK = leaderboardVariant.getPlayerRank();
        this.adL = leaderboardVariant.getDisplayPlayerRank();
        this.adM = leaderboardVariant.getPlayerScoreTag();
        this.adN = leaderboardVariant.getNumScores();
        this.adO = leaderboardVariant.mK();
        this.adP = leaderboardVariant.mL();
        this.adQ = leaderboardVariant.mM();
    }

    static int m4028a(LeaderboardVariant leaderboardVariant) {
        return jv.hashCode(Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.mK(), leaderboardVariant.mM(), leaderboardVariant.mL());
    }

    static boolean m4029a(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return jv.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && jv.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && jv.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && jv.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && jv.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && jv.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && jv.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && jv.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && jv.equal(leaderboardVariant2.mK(), leaderboardVariant.mK()) && jv.equal(leaderboardVariant2.mM(), leaderboardVariant.mM()) && jv.equal(leaderboardVariant2.mL(), leaderboardVariant.mL());
    }

    static String m4030b(LeaderboardVariant leaderboardVariant) {
        return jv.m5212h(leaderboardVariant).m5211a("TimeSpan", TimeSpan.dZ(leaderboardVariant.getTimeSpan())).m5211a("Collection", LeaderboardCollection.dZ(leaderboardVariant.getCollection())).m5211a("RawPlayerScore", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : "none").m5211a("DisplayPlayerScore", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : "none").m5211a("PlayerRank", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : "none").m5211a("DisplayPlayerRank", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerRank() : "none").m5211a("NumScores", Long.valueOf(leaderboardVariant.getNumScores())).m5211a("TopPageNextToken", leaderboardVariant.mK()).m5211a("WindowPageNextToken", leaderboardVariant.mM()).m5211a("WindowPagePrevToken", leaderboardVariant.mL()).toString();
    }

    public final boolean equals(Object obj) {
        return m4029a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return mN();
    }

    public final int getCollection() {
        return this.adG;
    }

    public final String getDisplayPlayerRank() {
        return this.adL;
    }

    public final String getDisplayPlayerScore() {
        return this.adJ;
    }

    public final long getNumScores() {
        return this.adN;
    }

    public final long getPlayerRank() {
        return this.adK;
    }

    public final String getPlayerScoreTag() {
        return this.adM;
    }

    public final long getRawPlayerScore() {
        return this.adI;
    }

    public final int getTimeSpan() {
        return this.adF;
    }

    public final boolean hasPlayerInfo() {
        return this.adH;
    }

    public final int hashCode() {
        return m4028a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String mK() {
        return this.adO;
    }

    public final String mL() {
        return this.adP;
    }

    public final String mM() {
        return this.adQ;
    }

    public final LeaderboardVariant mN() {
        return this;
    }

    public final String toString() {
        return m4030b(this);
    }
}
