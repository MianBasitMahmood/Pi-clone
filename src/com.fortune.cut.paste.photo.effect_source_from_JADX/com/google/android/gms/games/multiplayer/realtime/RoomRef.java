package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;

public final class RoomRef extends C0451d implements Room {
    private final int Ya;

    RoomRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.Ya = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return RoomEntity.m4050a((Room) this, obj);
    }

    public final Room freeze() {
        return new RoomEntity(this);
    }

    public final Bundle getAutoMatchCriteria() {
        return !getBoolean("has_automatch_criteria") ? null : RoomConfig.createAutoMatchCriteria(getInteger("automatch_min_players"), getInteger("automatch_max_players"), getLong("automatch_bit_mask"));
    }

    public final int getAutoMatchWaitEstimateSeconds() {
        return getInteger("automatch_wait_estimate_sec");
    }

    public final long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    public final String getCreatorId() {
        return getString("creator_external");
    }

    public final String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        m1654a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, charArrayBuffer);
    }

    public final Participant getParticipant(String str) {
        return RoomEntity.m4054c(this, str);
    }

    public final String getParticipantId(String str) {
        return RoomEntity.m4052b(this, str);
    }

    public final ArrayList<String> getParticipantIds() {
        return RoomEntity.m4055c(this);
    }

    public final int getParticipantStatus(String str) {
        return RoomEntity.m4049a((Room) this, str);
    }

    public final ArrayList<Participant> getParticipants() {
        ArrayList<Participant> arrayList = new ArrayList(this.Ya);
        for (int i = 0; i < this.Ya; i++) {
            arrayList.add(new ParticipantRef(this.JG, this.KZ + i));
        }
        return arrayList;
    }

    public final String getRoomId() {
        return getString("external_match_id");
    }

    public final int getStatus() {
        return getInteger("status");
    }

    public final int getVariant() {
        return getInteger("variant");
    }

    public final int hashCode() {
        return RoomEntity.m4048a(this);
    }

    public final String toString() {
        return RoomEntity.m4051b((Room) this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((RoomEntity) freeze()).writeToParcel(parcel, i);
    }
}
