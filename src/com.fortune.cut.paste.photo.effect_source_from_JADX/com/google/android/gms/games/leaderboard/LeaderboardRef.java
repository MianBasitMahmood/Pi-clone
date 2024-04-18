package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

public final class LeaderboardRef extends C0451d implements Leaderboard {
    private final int Ya;
    private final Game adq;

    LeaderboardRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.Ya = i2;
        this.adq = new GameRef(dataHolder, i);
    }

    public final boolean equals(Object obj) {
        return LeaderboardEntity.m4023a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return mG();
    }

    public final String getDisplayName() {
        return getString("name");
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        m1654a("name", charArrayBuffer);
    }

    public final Game getGame() {
        return this.adq;
    }

    public final Uri getIconImageUri() {
        return aR("board_icon_image_uri");
    }

    public final String getIconImageUrl() {
        return getString("board_icon_image_url");
    }

    public final String getLeaderboardId() {
        return getString("external_leaderboard_id");
    }

    public final int getScoreOrder() {
        return getInteger("score_order");
    }

    public final ArrayList<LeaderboardVariant> getVariants() {
        ArrayList<LeaderboardVariant> arrayList = new ArrayList(this.Ya);
        for (int i = 0; i < this.Ya; i++) {
            arrayList.add(new LeaderboardVariantRef(this.JG, this.KZ + i));
        }
        return arrayList;
    }

    public final int hashCode() {
        return LeaderboardEntity.m4022a(this);
    }

    public final Leaderboard mG() {
        return new LeaderboardEntity(this);
    }

    public final String toString() {
        return LeaderboardEntity.m4024b(this);
    }
}
