package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;

public final class InvitationRef extends C0451d implements Invitation {
    private final ArrayList<Participant> adV;
    private final ParticipantRef adY;
    private final Game adq;

    InvitationRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.adq = new GameRef(dataHolder, i);
        this.adV = new ArrayList(i2);
        String string = getString("external_inviter_id");
        Object obj = null;
        for (int i3 = 0; i3 < i2; i3++) {
            ParticipantRef participantRef = new ParticipantRef(this.JG, this.KZ + i3);
            if (participantRef.getParticipantId().equals(string)) {
                obj = participantRef;
            }
            this.adV.add(participantRef);
        }
        this.adY = (ParticipantRef) jx.m5219b(obj, (Object) "Must have a valid inviter!");
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return InvitationEntity.m4036a(this, obj);
    }

    public final Invitation freeze() {
        return new InvitationEntity(this);
    }

    public final int getAvailableAutoMatchSlots() {
        return !getBoolean("has_automatch_criteria") ? 0 : getInteger("automatch_max_players");
    }

    public final long getCreationTimestamp() {
        return Math.max(getLong("creation_timestamp"), getLong("last_modified_timestamp"));
    }

    public final Game getGame() {
        return this.adq;
    }

    public final String getInvitationId() {
        return getString("external_invitation_id");
    }

    public final int getInvitationType() {
        return getInteger("type");
    }

    public final Participant getInviter() {
        return this.adY;
    }

    public final ArrayList<Participant> getParticipants() {
        return this.adV;
    }

    public final int getVariant() {
        return getInteger("variant");
    }

    public final int hashCode() {
        return InvitationEntity.m4035a(this);
    }

    public final String toString() {
        return InvitationEntity.m4037b((Invitation) this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((InvitationEntity) freeze()).writeToParcel(parcel, i);
    }
}
