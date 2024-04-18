package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;

public final class TurnBasedMatchRef extends C0451d implements TurnBasedMatch {
    private final int Ya;
    private final Game adq;

    TurnBasedMatchRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.adq = new GameRef(dataHolder, i);
        this.Ya = i2;
    }

    public final boolean canRematch() {
        return getTurnStatus() == 3 && getRematchId() == null && getParticipants().size() > 1;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return TurnBasedMatchEntity.m4061a((TurnBasedMatch) this, obj);
    }

    public final TurnBasedMatch freeze() {
        return new TurnBasedMatchEntity(this);
    }

    public final Bundle getAutoMatchCriteria() {
        return !getBoolean("has_automatch_criteria") ? null : TurnBasedMatchConfig.createAutoMatchCriteria(getInteger("automatch_min_players"), getInteger("automatch_max_players"), getLong("automatch_bit_mask"));
    }

    public final int getAvailableAutoMatchSlots() {
        return !getBoolean("has_automatch_criteria") ? 0 : getInteger("automatch_max_players");
    }

    public final long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    public final String getCreatorId() {
        return getString("creator_external");
    }

    public final byte[] getData() {
        return getByteArray("data");
    }

    public final String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        m1654a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, charArrayBuffer);
    }

    public final Participant getDescriptionParticipant() {
        String descriptionParticipantId = getDescriptionParticipantId();
        return descriptionParticipantId == null ? null : getParticipant(descriptionParticipantId);
    }

    public final String getDescriptionParticipantId() {
        return getString("description_participant_id");
    }

    public final Game getGame() {
        return this.adq;
    }

    public final long getLastUpdatedTimestamp() {
        return getLong("last_updated_timestamp");
    }

    public final String getLastUpdaterId() {
        return getString("last_updater_external");
    }

    public final String getMatchId() {
        return getString("external_match_id");
    }

    public final int getMatchNumber() {
        return getInteger("match_number");
    }

    public final Participant getParticipant(String str) {
        return TurnBasedMatchEntity.m4064c(this, str);
    }

    public final String getParticipantId(String str) {
        return TurnBasedMatchEntity.m4063b(this, str);
    }

    public final ArrayList<String> getParticipantIds() {
        return TurnBasedMatchEntity.m4065c(this);
    }

    public final int getParticipantStatus(String str) {
        return TurnBasedMatchEntity.m4060a((TurnBasedMatch) this, str);
    }

    public final ArrayList<Participant> getParticipants() {
        ArrayList<Participant> arrayList = new ArrayList(this.Ya);
        for (int i = 0; i < this.Ya; i++) {
            arrayList.add(new ParticipantRef(this.JG, this.KZ + i));
        }
        return arrayList;
    }

    public final String getPendingParticipantId() {
        return getString("pending_participant_external");
    }

    public final byte[] getPreviousMatchData() {
        return getByteArray("previous_match_data");
    }

    public final String getRematchId() {
        return getString("rematch_id");
    }

    public final int getStatus() {
        return getInteger("status");
    }

    public final int getTurnStatus() {
        return getInteger("user_match_status");
    }

    public final int getVariant() {
        return getInteger("variant");
    }

    public final int getVersion() {
        return getInteger("version");
    }

    public final int hashCode() {
        return TurnBasedMatchEntity.m4059a(this);
    }

    public final boolean isLocallyModified() {
        return getBoolean("upsync_required");
    }

    public final String toString() {
        return TurnBasedMatchEntity.m4062b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((TurnBasedMatchEntity) freeze()).writeToParcel(parcel, i);
    }
}
