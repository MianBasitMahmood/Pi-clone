package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;
import java.util.ArrayList;

public final class TurnBasedMatchEntity implements SafeParcelable, TurnBasedMatch {
    public static final TurnBasedMatchEntityCreator CREATOR;
    private final int CK;
    private final int Ef;
    private final String UO;
    private final long XH;
    private final String Zb;
    private final GameEntity acs;
    private final long adS;
    private final ArrayList<ParticipantEntity> adV;
    private final int adW;
    private final byte[] aeA;
    private final String aeB;
    private final byte[] aeC;
    private final int aeD;
    private final int aeE;
    private final boolean aeF;
    private final String aeG;
    private final Bundle aem;
    private final String aep;
    private final String aex;
    private final String aey;
    private final int aez;

    static {
        CREATOR = new TurnBasedMatchEntityCreator();
    }

    TurnBasedMatchEntity(int i, GameEntity gameEntity, String str, String str2, long j, String str3, long j2, String str4, int i2, int i3, int i4, byte[] bArr, ArrayList<ParticipantEntity> arrayList, String str5, byte[] bArr2, int i5, Bundle bundle, int i6, boolean z, String str6, String str7) {
        this.CK = i;
        this.acs = gameEntity;
        this.Zb = str;
        this.aep = str2;
        this.adS = j;
        this.aex = str3;
        this.XH = j2;
        this.aey = str4;
        this.aez = i2;
        this.aeE = i6;
        this.adW = i3;
        this.Ef = i4;
        this.aeA = bArr;
        this.adV = arrayList;
        this.aeB = str5;
        this.aeC = bArr2;
        this.aeD = i5;
        this.aem = bundle;
        this.aeF = z;
        this.UO = str6;
        this.aeG = str7;
    }

    public TurnBasedMatchEntity(TurnBasedMatch turnBasedMatch) {
        this.CK = 2;
        this.acs = new GameEntity(turnBasedMatch.getGame());
        this.Zb = turnBasedMatch.getMatchId();
        this.aep = turnBasedMatch.getCreatorId();
        this.adS = turnBasedMatch.getCreationTimestamp();
        this.aex = turnBasedMatch.getLastUpdaterId();
        this.XH = turnBasedMatch.getLastUpdatedTimestamp();
        this.aey = turnBasedMatch.getPendingParticipantId();
        this.aez = turnBasedMatch.getStatus();
        this.aeE = turnBasedMatch.getTurnStatus();
        this.adW = turnBasedMatch.getVariant();
        this.Ef = turnBasedMatch.getVersion();
        this.aeB = turnBasedMatch.getRematchId();
        this.aeD = turnBasedMatch.getMatchNumber();
        this.aem = turnBasedMatch.getAutoMatchCriteria();
        this.aeF = turnBasedMatch.isLocallyModified();
        this.UO = turnBasedMatch.getDescription();
        this.aeG = turnBasedMatch.getDescriptionParticipantId();
        Object data = turnBasedMatch.getData();
        if (data == null) {
            this.aeA = null;
        } else {
            this.aeA = new byte[data.length];
            System.arraycopy(data, 0, this.aeA, 0, data.length);
        }
        data = turnBasedMatch.getPreviousMatchData();
        if (data == null) {
            this.aeC = null;
        } else {
            this.aeC = new byte[data.length];
            System.arraycopy(data, 0, this.aeC, 0, data.length);
        }
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        this.adV = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.adV.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
    }

    static int m4059a(TurnBasedMatch turnBasedMatch) {
        return jv.hashCode(turnBasedMatch.getGame(), turnBasedMatch.getMatchId(), turnBasedMatch.getCreatorId(), Long.valueOf(turnBasedMatch.getCreationTimestamp()), turnBasedMatch.getLastUpdaterId(), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp()), turnBasedMatch.getPendingParticipantId(), Integer.valueOf(turnBasedMatch.getStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus()), turnBasedMatch.getDescription(), Integer.valueOf(turnBasedMatch.getVariant()), Integer.valueOf(turnBasedMatch.getVersion()), turnBasedMatch.getParticipants(), turnBasedMatch.getRematchId(), Integer.valueOf(turnBasedMatch.getMatchNumber()), turnBasedMatch.getAutoMatchCriteria(), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static int m4060a(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    static boolean m4061a(TurnBasedMatch turnBasedMatch, Object obj) {
        if (!(obj instanceof TurnBasedMatch)) {
            return false;
        }
        if (turnBasedMatch == obj) {
            return true;
        }
        TurnBasedMatch turnBasedMatch2 = (TurnBasedMatch) obj;
        return jv.equal(turnBasedMatch2.getGame(), turnBasedMatch.getGame()) && jv.equal(turnBasedMatch2.getMatchId(), turnBasedMatch.getMatchId()) && jv.equal(turnBasedMatch2.getCreatorId(), turnBasedMatch.getCreatorId()) && jv.equal(Long.valueOf(turnBasedMatch2.getCreationTimestamp()), Long.valueOf(turnBasedMatch.getCreationTimestamp())) && jv.equal(turnBasedMatch2.getLastUpdaterId(), turnBasedMatch.getLastUpdaterId()) && jv.equal(Long.valueOf(turnBasedMatch2.getLastUpdatedTimestamp()), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())) && jv.equal(turnBasedMatch2.getPendingParticipantId(), turnBasedMatch.getPendingParticipantId()) && jv.equal(Integer.valueOf(turnBasedMatch2.getStatus()), Integer.valueOf(turnBasedMatch.getStatus())) && jv.equal(Integer.valueOf(turnBasedMatch2.getTurnStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus())) && jv.equal(turnBasedMatch2.getDescription(), turnBasedMatch.getDescription()) && jv.equal(Integer.valueOf(turnBasedMatch2.getVariant()), Integer.valueOf(turnBasedMatch.getVariant())) && jv.equal(Integer.valueOf(turnBasedMatch2.getVersion()), Integer.valueOf(turnBasedMatch.getVersion())) && jv.equal(turnBasedMatch2.getParticipants(), turnBasedMatch.getParticipants()) && jv.equal(turnBasedMatch2.getRematchId(), turnBasedMatch.getRematchId()) && jv.equal(Integer.valueOf(turnBasedMatch2.getMatchNumber()), Integer.valueOf(turnBasedMatch.getMatchNumber())) && jv.equal(turnBasedMatch2.getAutoMatchCriteria(), turnBasedMatch.getAutoMatchCriteria()) && jv.equal(Integer.valueOf(turnBasedMatch2.getAvailableAutoMatchSlots()), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())) && jv.equal(Boolean.valueOf(turnBasedMatch2.isLocallyModified()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static String m4062b(TurnBasedMatch turnBasedMatch) {
        return jv.m5212h(turnBasedMatch).m5211a("Game", turnBasedMatch.getGame()).m5211a("MatchId", turnBasedMatch.getMatchId()).m5211a("CreatorId", turnBasedMatch.getCreatorId()).m5211a("CreationTimestamp", Long.valueOf(turnBasedMatch.getCreationTimestamp())).m5211a("LastUpdaterId", turnBasedMatch.getLastUpdaterId()).m5211a("LastUpdatedTimestamp", Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())).m5211a("PendingParticipantId", turnBasedMatch.getPendingParticipantId()).m5211a("MatchStatus", Integer.valueOf(turnBasedMatch.getStatus())).m5211a("TurnStatus", Integer.valueOf(turnBasedMatch.getTurnStatus())).m5211a("Description", turnBasedMatch.getDescription()).m5211a("Variant", Integer.valueOf(turnBasedMatch.getVariant())).m5211a("Data", turnBasedMatch.getData()).m5211a("Version", Integer.valueOf(turnBasedMatch.getVersion())).m5211a("Participants", turnBasedMatch.getParticipants()).m5211a("RematchId", turnBasedMatch.getRematchId()).m5211a("PreviousData", turnBasedMatch.getPreviousMatchData()).m5211a("MatchNumber", Integer.valueOf(turnBasedMatch.getMatchNumber())).m5211a("AutoMatchCriteria", turnBasedMatch.getAutoMatchCriteria()).m5211a("AvailableAutoMatchSlots", Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())).m5211a("LocallyModified", Boolean.valueOf(turnBasedMatch.isLocallyModified())).m5211a("DescriptionParticipantId", turnBasedMatch.getDescriptionParticipantId()).toString();
    }

    static String m4063b(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(str)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }

    static Participant m4064c(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    static ArrayList<String> m4065c(TurnBasedMatch turnBasedMatch) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public final boolean canRematch() {
        return this.aez == 2 && this.aeB == null;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m4061a((TurnBasedMatch) this, obj);
    }

    public final TurnBasedMatch freeze() {
        return this;
    }

    public final Bundle getAutoMatchCriteria() {
        return this.aem;
    }

    public final int getAvailableAutoMatchSlots() {
        return this.aem == null ? 0 : this.aem.getInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS);
    }

    public final long getCreationTimestamp() {
        return this.adS;
    }

    public final String getCreatorId() {
        return this.aep;
    }

    public final byte[] getData() {
        return this.aeA;
    }

    public final String getDescription() {
        return this.UO;
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        le.m5324b(this.UO, charArrayBuffer);
    }

    public final Participant getDescriptionParticipant() {
        String descriptionParticipantId = getDescriptionParticipantId();
        return descriptionParticipantId == null ? null : getParticipant(descriptionParticipantId);
    }

    public final String getDescriptionParticipantId() {
        return this.aeG;
    }

    public final Game getGame() {
        return this.acs;
    }

    public final long getLastUpdatedTimestamp() {
        return this.XH;
    }

    public final String getLastUpdaterId() {
        return this.aex;
    }

    public final String getMatchId() {
        return this.Zb;
    }

    public final int getMatchNumber() {
        return this.aeD;
    }

    public final Participant getParticipant(String str) {
        return m4064c(this, str);
    }

    public final String getParticipantId(String str) {
        return m4063b(this, str);
    }

    public final ArrayList<String> getParticipantIds() {
        return m4065c(this);
    }

    public final int getParticipantStatus(String str) {
        return m4060a((TurnBasedMatch) this, str);
    }

    public final ArrayList<Participant> getParticipants() {
        return new ArrayList(this.adV);
    }

    public final String getPendingParticipantId() {
        return this.aey;
    }

    public final byte[] getPreviousMatchData() {
        return this.aeC;
    }

    public final String getRematchId() {
        return this.aeB;
    }

    public final int getStatus() {
        return this.aez;
    }

    public final int getTurnStatus() {
        return this.aeE;
    }

    public final int getVariant() {
        return this.adW;
    }

    public final int getVersion() {
        return this.Ef;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return m4059a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final boolean isLocallyModified() {
        return this.aeF;
    }

    public final String toString() {
        return m4062b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        TurnBasedMatchEntityCreator.m4066a(this, parcel, i);
    }
}
