package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;
import java.util.List;

public final class QuestRef extends C0451d implements Quest {
    private final int Ya;
    private final Game adq;

    QuestRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.adq = new GameRef(dataHolder, i);
        this.Ya = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return QuestEntity.m4074a(this, obj);
    }

    public final Quest freeze() {
        return new QuestEntity(this);
    }

    public final long getAcceptedTimestamp() {
        return getLong("accepted_ts");
    }

    public final Uri getBannerImageUri() {
        return aR("quest_banner_image_uri");
    }

    public final String getBannerImageUrl() {
        return getString("quest_banner_image_url");
    }

    public final Milestone getCurrentMilestone() {
        return (Milestone) mQ().get(0);
    }

    public final String getDescription() {
        return getString("quest_description");
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        m1654a("quest_description", charArrayBuffer);
    }

    public final long getEndTimestamp() {
        return getLong("quest_end_ts");
    }

    public final Game getGame() {
        return this.adq;
    }

    public final Uri getIconImageUri() {
        return aR("quest_icon_image_uri");
    }

    public final String getIconImageUrl() {
        return getString("quest_icon_image_url");
    }

    public final long getLastUpdatedTimestamp() {
        return getLong("quest_last_updated_ts");
    }

    public final String getName() {
        return getString("quest_name");
    }

    public final void getName(CharArrayBuffer charArrayBuffer) {
        m1654a("quest_name", charArrayBuffer);
    }

    public final String getQuestId() {
        return getString("external_quest_id");
    }

    public final long getStartTimestamp() {
        return getLong("quest_start_ts");
    }

    public final int getState() {
        return getInteger("quest_state");
    }

    public final int getType() {
        return getInteger("quest_type");
    }

    public final int hashCode() {
        return QuestEntity.m4073a(this);
    }

    public final boolean isEndingSoon() {
        return mR() <= System.currentTimeMillis() + 1800000;
    }

    public final List<Milestone> mQ() {
        List arrayList = new ArrayList(this.Ya);
        for (int i = 0; i < this.Ya; i++) {
            arrayList.add(new MilestoneRef(this.JG, this.KZ + i));
        }
        return arrayList;
    }

    public final long mR() {
        return getLong("notification_ts");
    }

    public final String toString() {
        return QuestEntity.m4075b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((QuestEntity) freeze()).writeToParcel(parcel, i);
    }
}
