package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.internal.je;
import com.google.android.gms.plus.PlusShare;

public final class AchievementRef extends C0451d implements Achievement {
    AchievementRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final Achievement freeze() {
        return new AchievementEntity(this);
    }

    public final String getAchievementId() {
        return getString("external_achievement_id");
    }

    public final int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        je.m5079K(z);
        return getInteger("current_steps");
    }

    public final String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        m1654a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, charArrayBuffer);
    }

    public final String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        je.m5079K(z);
        return getString("formatted_current_steps");
    }

    public final void getFormattedCurrentSteps(CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        je.m5079K(z);
        m1654a("formatted_current_steps", charArrayBuffer);
    }

    public final String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        je.m5079K(z);
        return getString("formatted_total_steps");
    }

    public final void getFormattedTotalSteps(CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        je.m5079K(z);
        m1654a("formatted_total_steps", charArrayBuffer);
    }

    public final long getLastUpdatedTimestamp() {
        return getLong("last_updated_timestamp");
    }

    public final String getName() {
        return getString("name");
    }

    public final void getName(CharArrayBuffer charArrayBuffer) {
        m1654a("name", charArrayBuffer);
    }

    public final Player getPlayer() {
        return new PlayerRef(this.JG, this.KZ);
    }

    public final Uri getRevealedImageUri() {
        return aR("revealed_icon_image_uri");
    }

    public final String getRevealedImageUrl() {
        return getString("revealed_icon_image_url");
    }

    public final int getState() {
        return getInteger("state");
    }

    public final int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        je.m5079K(z);
        return getInteger("total_steps");
    }

    public final int getType() {
        return getInteger("type");
    }

    public final Uri getUnlockedImageUri() {
        return aR("unlocked_icon_image_uri");
    }

    public final String getUnlockedImageUrl() {
        return getString("unlocked_icon_image_url");
    }

    public final long getXpValue() {
        return (!aQ("instance_xp_value") || aS("instance_xp_value")) ? getLong("definition_xp_value") : getLong("instance_xp_value");
    }

    public final String toString() {
        return AchievementEntity.m2838b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((AchievementEntity) freeze()).writeToParcel(parcel, i);
    }
}
