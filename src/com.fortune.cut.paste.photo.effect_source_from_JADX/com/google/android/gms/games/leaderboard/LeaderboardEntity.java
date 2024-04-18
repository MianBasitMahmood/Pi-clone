package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;
import java.util.ArrayList;

public final class LeaderboardEntity implements Leaderboard {
    private final String OS;
    private final Uri WD;
    private final String WO;
    private final String adn;
    private final int ado;
    private final ArrayList<LeaderboardVariantEntity> adp;
    private final Game adq;

    public LeaderboardEntity(Leaderboard leaderboard) {
        this.adn = leaderboard.getLeaderboardId();
        this.OS = leaderboard.getDisplayName();
        this.WD = leaderboard.getIconImageUri();
        this.WO = leaderboard.getIconImageUrl();
        this.ado = leaderboard.getScoreOrder();
        Game game = leaderboard.getGame();
        this.adq = game == null ? null : new GameEntity(game);
        ArrayList variants = leaderboard.getVariants();
        int size = variants.size();
        this.adp = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.adp.add((LeaderboardVariantEntity) ((LeaderboardVariant) variants.get(i)).freeze());
        }
    }

    static int m4022a(Leaderboard leaderboard) {
        return jv.hashCode(leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), Integer.valueOf(leaderboard.getScoreOrder()), leaderboard.getVariants());
    }

    static boolean m4023a(Leaderboard leaderboard, Object obj) {
        if (!(obj instanceof Leaderboard)) {
            return false;
        }
        if (leaderboard == obj) {
            return true;
        }
        Leaderboard leaderboard2 = (Leaderboard) obj;
        return jv.equal(leaderboard2.getLeaderboardId(), leaderboard.getLeaderboardId()) && jv.equal(leaderboard2.getDisplayName(), leaderboard.getDisplayName()) && jv.equal(leaderboard2.getIconImageUri(), leaderboard.getIconImageUri()) && jv.equal(Integer.valueOf(leaderboard2.getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())) && jv.equal(leaderboard2.getVariants(), leaderboard.getVariants());
    }

    static String m4024b(Leaderboard leaderboard) {
        return jv.m5212h(leaderboard).m5211a("LeaderboardId", leaderboard.getLeaderboardId()).m5211a("DisplayName", leaderboard.getDisplayName()).m5211a("IconImageUri", leaderboard.getIconImageUri()).m5211a("IconImageUrl", leaderboard.getIconImageUrl()).m5211a("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).m5211a("Variants", leaderboard.getVariants()).toString();
    }

    public final boolean equals(Object obj) {
        return m4023a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return mG();
    }

    public final String getDisplayName() {
        return this.OS;
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        le.m5324b(this.OS, charArrayBuffer);
    }

    public final Game getGame() {
        return this.adq;
    }

    public final Uri getIconImageUri() {
        return this.WD;
    }

    public final String getIconImageUrl() {
        return this.WO;
    }

    public final String getLeaderboardId() {
        return this.adn;
    }

    public final int getScoreOrder() {
        return this.ado;
    }

    public final ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList(this.adp);
    }

    public final int hashCode() {
        return m4022a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final Leaderboard mG() {
        return this;
    }

    public final String toString() {
        return m4024b(this);
    }
}
