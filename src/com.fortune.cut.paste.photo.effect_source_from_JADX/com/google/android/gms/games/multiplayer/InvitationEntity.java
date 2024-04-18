package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;

public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
    public static final Creator<InvitationEntity> CREATOR;
    private final int CK;
    private final String YG;
    private final GameEntity acs;
    private final long adS;
    private final int adT;
    private final ParticipantEntity adU;
    private final ArrayList<ParticipantEntity> adV;
    private final int adW;
    private final int adX;

    static final class InvitationEntityCreatorCompat extends InvitationEntityCreator {
        InvitationEntityCreatorCompat() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return cz(parcel);
        }

        public final InvitationEntity cz(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.m2815c(ji.ht()) || ji.aW(InvitationEntity.class.getCanonicalName())) {
                return super.cz(parcel);
            }
            GameEntity gameEntity = (GameEntity) GameEntity.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            ParticipantEntity participantEntity = (ParticipantEntity) ParticipantEntity.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i < readInt2; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new InvitationEntity(2, gameEntity, readString, readLong, readInt, participantEntity, arrayList, -1, 0);
        }
    }

    static {
        CREATOR = new InvitationEntityCreatorCompat();
    }

    InvitationEntity(int i, GameEntity gameEntity, String str, long j, int i2, ParticipantEntity participantEntity, ArrayList<ParticipantEntity> arrayList, int i3, int i4) {
        this.CK = i;
        this.acs = gameEntity;
        this.YG = str;
        this.adS = j;
        this.adT = i2;
        this.adU = participantEntity;
        this.adV = arrayList;
        this.adW = i3;
        this.adX = i4;
    }

    InvitationEntity(Invitation invitation) {
        this.CK = 2;
        this.acs = new GameEntity(invitation.getGame());
        this.YG = invitation.getInvitationId();
        this.adS = invitation.getCreationTimestamp();
        this.adT = invitation.getInvitationType();
        this.adW = invitation.getVariant();
        this.adX = invitation.getAvailableAutoMatchSlots();
        String participantId = invitation.getInviter().getParticipantId();
        Object obj = null;
        ArrayList participants = invitation.getParticipants();
        int size = participants.size();
        this.adV = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(participantId)) {
                obj = participant;
            }
            this.adV.add((ParticipantEntity) participant.freeze());
        }
        jx.m5219b(obj, (Object) "Must have a valid inviter!");
        this.adU = (ParticipantEntity) obj.freeze();
    }

    static int m4035a(Invitation invitation) {
        return jv.hashCode(invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.getInvitationType()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static boolean m4036a(Invitation invitation, Object obj) {
        if (!(obj instanceof Invitation)) {
            return false;
        }
        if (invitation == obj) {
            return true;
        }
        Invitation invitation2 = (Invitation) obj;
        return jv.equal(invitation2.getGame(), invitation.getGame()) && jv.equal(invitation2.getInvitationId(), invitation.getInvitationId()) && jv.equal(Long.valueOf(invitation2.getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) && jv.equal(Integer.valueOf(invitation2.getInvitationType()), Integer.valueOf(invitation.getInvitationType())) && jv.equal(invitation2.getInviter(), invitation.getInviter()) && jv.equal(invitation2.getParticipants(), invitation.getParticipants()) && jv.equal(Integer.valueOf(invitation2.getVariant()), Integer.valueOf(invitation.getVariant())) && jv.equal(Integer.valueOf(invitation2.getAvailableAutoMatchSlots()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static String m4037b(Invitation invitation) {
        return jv.m5212h(invitation).m5211a("Game", invitation.getGame()).m5211a("InvitationId", invitation.getInvitationId()).m5211a("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).m5211a("InvitationType", Integer.valueOf(invitation.getInvitationType())).m5211a("Inviter", invitation.getInviter()).m5211a("Participants", invitation.getParticipants()).m5211a("Variant", Integer.valueOf(invitation.getVariant())).m5211a("AvailableAutoMatchSlots", Integer.valueOf(invitation.getAvailableAutoMatchSlots())).toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m4036a(this, obj);
    }

    public final Invitation freeze() {
        return this;
    }

    public final int getAvailableAutoMatchSlots() {
        return this.adX;
    }

    public final long getCreationTimestamp() {
        return this.adS;
    }

    public final Game getGame() {
        return this.acs;
    }

    public final String getInvitationId() {
        return this.YG;
    }

    public final int getInvitationType() {
        return this.adT;
    }

    public final Participant getInviter() {
        return this.adU;
    }

    public final ArrayList<Participant> getParticipants() {
        return new ArrayList(this.adV);
    }

    public final int getVariant() {
        return this.adW;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return m4035a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return m4037b((Invitation) this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (hu()) {
            this.acs.writeToParcel(parcel, i);
            parcel.writeString(this.YG);
            parcel.writeLong(this.adS);
            parcel.writeInt(this.adT);
            this.adU.writeToParcel(parcel, i);
            int size = this.adV.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                ((ParticipantEntity) this.adV.get(i2)).writeToParcel(parcel, i);
            }
            return;
        }
        InvitationEntityCreator.m4034a(this, parcel, i);
    }
}
