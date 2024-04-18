package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;

public final class GameRef extends C0451d implements Game {
    public GameRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final boolean areSnapshotsEnabled() {
        return getInteger("snapshots_enabled") > 0;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return GameEntity.m2817a(this, obj);
    }

    public final Game freeze() {
        return new GameEntity(this);
    }

    public final int getAchievementTotalCount() {
        return getInteger("achievement_total_count");
    }

    public final String getApplicationId() {
        return getString("external_game_id");
    }

    public final String getDescription() {
        return getString("game_description");
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        m1654a("game_description", charArrayBuffer);
    }

    public final String getDeveloperName() {
        return getString("developer_name");
    }

    public final void getDeveloperName(CharArrayBuffer charArrayBuffer) {
        m1654a("developer_name", charArrayBuffer);
    }

    public final String getDisplayName() {
        return getString("display_name");
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        m1654a("display_name", charArrayBuffer);
    }

    public final Uri getFeaturedImageUri() {
        return aR("featured_image_uri");
    }

    public final String getFeaturedImageUrl() {
        return getString("featured_image_url");
    }

    public final Uri getHiResImageUri() {
        return aR("game_hi_res_image_uri");
    }

    public final String getHiResImageUrl() {
        return getString("game_hi_res_image_url");
    }

    public final Uri getIconImageUri() {
        return aR("game_icon_image_uri");
    }

    public final String getIconImageUrl() {
        return getString("game_icon_image_url");
    }

    public final int getLeaderboardCount() {
        return getInteger("leaderboard_count");
    }

    public final String getPrimaryCategory() {
        return getString("primary_category");
    }

    public final String getSecondaryCategory() {
        return getString("secondary_category");
    }

    public final String getThemeColor() {
        return getString("theme_color");
    }

    public final int hashCode() {
        return GameEntity.m2816a(this);
    }

    public final boolean isMuted() {
        return getBoolean("muted");
    }

    public final boolean isRealTimeMultiplayerEnabled() {
        return getInteger("real_time_support") > 0;
    }

    public final boolean isTurnBasedMultiplayerEnabled() {
        return getInteger("turn_based_support") > 0;
    }

    public final boolean kA() {
        return getInteger("installed") > 0;
    }

    public final String kB() {
        return getString("package_name");
    }

    public final int kC() {
        return getInteger("gameplay_acl_status");
    }

    public final boolean ky() {
        return getBoolean("play_enabled_game");
    }

    public final boolean kz() {
        return getBoolean("identity_sharing_confirmed");
    }

    public final String toString() {
        return GameEntity.m2818b((Game) this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((GameEntity) freeze()).writeToParcel(parcel, i);
    }
}
