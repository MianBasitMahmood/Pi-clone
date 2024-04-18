package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;
import java.util.ArrayList;

public final class RoomEntity extends GamesDowngradeableSafeParcel implements Room {
    public static final Creator<RoomEntity> CREATOR;
    private final int CK;
    private final String UO;
    private final String YI;
    private final long adS;
    private final ArrayList<ParticipantEntity> adV;
    private final int adW;
    private final Bundle aem;
    private final String aep;
    private final int aeq;
    private final int aer;

    static final class RoomEntityCreatorCompat extends RoomEntityCreator {
        RoomEntityCreatorCompat() {
        }

        public final RoomEntity cC(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.m2815c(ji.ht()) || ji.aW(RoomEntity.class.getCanonicalName())) {
                return super.cC(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            String readString3 = parcel.readString();
            int readInt2 = parcel.readInt();
            Bundle readBundle = parcel.readBundle();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new RoomEntity(2, readString, readString2, readLong, readInt, readString3, readInt2, readBundle, arrayList, -1);
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return cC(parcel);
        }
    }

    static {
        CREATOR = new RoomEntityCreatorCompat();
    }

    RoomEntity(int i, String str, String str2, long j, int i2, String str3, int i3, Bundle bundle, ArrayList<ParticipantEntity> arrayList, int i4) {
        this.CK = i;
        this.YI = str;
        this.aep = str2;
        this.adS = j;
        this.aeq = i2;
        this.UO = str3;
        this.adW = i3;
        this.aem = bundle;
        this.adV = arrayList;
        this.aer = i4;
    }

    public RoomEntity(Room room) {
        this.CK = 2;
        this.YI = room.getRoomId();
        this.aep = room.getCreatorId();
        this.adS = room.getCreationTimestamp();
        this.aeq = room.getStatus();
        this.UO = room.getDescription();
        this.adW = room.getVariant();
        this.aem = room.getAutoMatchCriteria();
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        this.adV = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.adV.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
        this.aer = room.getAutoMatchWaitEstimateSeconds();
    }

    static int m4048a(Room room) {
        return jv.hashCode(room.getRoomId(), room.getCreatorId(), Long.valueOf(room.getCreationTimestamp()), Integer.valueOf(room.getStatus()), room.getDescription(), Integer.valueOf(room.getVariant()), room.getAutoMatchCriteria(), room.getParticipants(), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    static int m4049a(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in room " + room.getRoomId());
    }

    static boolean m4050a(Room room, Object obj) {
        if (!(obj instanceof Room)) {
            return false;
        }
        if (room == obj) {
            return true;
        }
        Room room2 = (Room) obj;
        return jv.equal(room2.getRoomId(), room.getRoomId()) && jv.equal(room2.getCreatorId(), room.getCreatorId()) && jv.equal(Long.valueOf(room2.getCreationTimestamp()), Long.valueOf(room.getCreationTimestamp())) && jv.equal(Integer.valueOf(room2.getStatus()), Integer.valueOf(room.getStatus())) && jv.equal(room2.getDescription(), room.getDescription()) && jv.equal(Integer.valueOf(room2.getVariant()), Integer.valueOf(room.getVariant())) && jv.equal(room2.getAutoMatchCriteria(), room.getAutoMatchCriteria()) && jv.equal(room2.getParticipants(), room.getParticipants()) && jv.equal(Integer.valueOf(room2.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    static String m4051b(Room room) {
        return jv.m5212h(room).m5211a("RoomId", room.getRoomId()).m5211a("CreatorId", room.getCreatorId()).m5211a("CreationTimestamp", Long.valueOf(room.getCreationTimestamp())).m5211a("RoomStatus", Integer.valueOf(room.getStatus())).m5211a("Description", room.getDescription()).m5211a("Variant", Integer.valueOf(room.getVariant())).m5211a("AutoMatchCriteria", room.getAutoMatchCriteria()).m5211a("Participants", room.getParticipants()).m5211a("AutoMatchWaitEstimateSeconds", Integer.valueOf(room.getAutoMatchWaitEstimateSeconds())).toString();
    }

    static String m4052b(Room room, String str) {
        ArrayList participants = room.getParticipants();
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

    static Participant m4054c(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + room.getRoomId());
    }

    static ArrayList<String> m4055c(Room room) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m4050a((Room) this, obj);
    }

    public final Room freeze() {
        return this;
    }

    public final Bundle getAutoMatchCriteria() {
        return this.aem;
    }

    public final int getAutoMatchWaitEstimateSeconds() {
        return this.aer;
    }

    public final long getCreationTimestamp() {
        return this.adS;
    }

    public final String getCreatorId() {
        return this.aep;
    }

    public final String getDescription() {
        return this.UO;
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        le.m5324b(this.UO, charArrayBuffer);
    }

    public final Participant getParticipant(String str) {
        return m4054c(this, str);
    }

    public final String getParticipantId(String str) {
        return m4052b(this, str);
    }

    public final ArrayList<String> getParticipantIds() {
        return m4055c(this);
    }

    public final int getParticipantStatus(String str) {
        return m4049a((Room) this, str);
    }

    public final ArrayList<Participant> getParticipants() {
        return new ArrayList(this.adV);
    }

    public final String getRoomId() {
        return this.YI;
    }

    public final int getStatus() {
        return this.aeq;
    }

    public final int getVariant() {
        return this.adW;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return m4048a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return m4051b((Room) this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (hu()) {
            parcel.writeString(this.YI);
            parcel.writeString(this.aep);
            parcel.writeLong(this.adS);
            parcel.writeInt(this.aeq);
            parcel.writeString(this.UO);
            parcel.writeInt(this.adW);
            parcel.writeBundle(this.aem);
            int size = this.adV.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                ((ParticipantEntity) this.adV.get(i2)).writeToParcel(parcel, i);
            }
            return;
        }
        RoomEntityCreator.m4047a(this, parcel, i);
    }
}
