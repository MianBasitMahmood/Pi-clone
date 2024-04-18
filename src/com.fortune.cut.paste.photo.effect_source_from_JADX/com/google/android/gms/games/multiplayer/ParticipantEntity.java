package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;

public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
    public static final Creator<ParticipantEntity> CREATOR;
    private final int CK;
    private final int FO;
    private final int FP;
    private final String OS;
    private final Uri WD;
    private final Uri WE;
    private final String WO;
    private final String WP;
    private final PlayerEntity XE;
    private final String Yi;
    private final String Zk;
    private final boolean adZ;
    private final ParticipantResult aea;

    static final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator {
        ParticipantEntityCreatorCompat() {
        }

        public final ParticipantEntity cA(Parcel parcel) {
            Object obj = 1;
            if (GamesDowngradeableSafeParcel.m2815c(ji.ht()) || ji.aW(ParticipantEntity.class.getCanonicalName())) {
                return super.cA(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Uri parse = readString3 == null ? null : Uri.parse(readString3);
            String readString4 = parcel.readString();
            Uri parse2 = readString4 == null ? null : Uri.parse(readString4);
            int readInt = parcel.readInt();
            String readString5 = parcel.readString();
            boolean z = parcel.readInt() > 0;
            if (parcel.readInt() <= 0) {
                obj = null;
            }
            return new ParticipantEntity(3, readString, readString2, parse, parse2, readInt, readString5, z, obj != null ? (PlayerEntity) PlayerEntity.CREATOR.createFromParcel(parcel) : null, 7, null, null, null);
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return cA(parcel);
        }
    }

    static {
        CREATOR = new ParticipantEntityCreatorCompat();
    }

    ParticipantEntity(int i, String str, String str2, Uri uri, Uri uri2, int i2, String str3, boolean z, PlayerEntity playerEntity, int i3, ParticipantResult participantResult, String str4, String str5) {
        this.CK = i;
        this.Zk = str;
        this.OS = str2;
        this.WD = uri;
        this.WE = uri2;
        this.FP = i2;
        this.Yi = str3;
        this.adZ = z;
        this.XE = playerEntity;
        this.FO = i3;
        this.aea = participantResult;
        this.WO = str4;
        this.WP = str5;
    }

    public ParticipantEntity(Participant participant) {
        this.CK = 3;
        this.Zk = participant.getParticipantId();
        this.OS = participant.getDisplayName();
        this.WD = participant.getIconImageUri();
        this.WE = participant.getHiResImageUri();
        this.FP = participant.getStatus();
        this.Yi = participant.le();
        this.adZ = participant.isConnectedToRoom();
        Player player = participant.getPlayer();
        this.XE = player == null ? null : new PlayerEntity(player);
        this.FO = participant.getCapabilities();
        this.aea = participant.getResult();
        this.WO = participant.getIconImageUrl();
        this.WP = participant.getHiResImageUrl();
    }

    static int m4040a(Participant participant) {
        return jv.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.le(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult(), participant.getParticipantId());
    }

    static boolean m4041a(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return jv.equal(participant2.getPlayer(), participant.getPlayer()) && jv.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && jv.equal(participant2.le(), participant.le()) && jv.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && jv.equal(participant2.getDisplayName(), participant.getDisplayName()) && jv.equal(participant2.getIconImageUri(), participant.getIconImageUri()) && jv.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) && jv.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities())) && jv.equal(participant2.getResult(), participant.getResult()) && jv.equal(participant2.getParticipantId(), participant.getParticipantId());
    }

    static String m4042b(Participant participant) {
        return jv.m5212h(participant).m5211a("ParticipantId", participant.getParticipantId()).m5211a("Player", participant.getPlayer()).m5211a("Status", Integer.valueOf(participant.getStatus())).m5211a("ClientAddress", participant.le()).m5211a("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).m5211a("DisplayName", participant.getDisplayName()).m5211a("IconImage", participant.getIconImageUri()).m5211a("IconImageUrl", participant.getIconImageUrl()).m5211a("HiResImage", participant.getHiResImageUri()).m5211a("HiResImageUrl", participant.getHiResImageUrl()).m5211a("Capabilities", Integer.valueOf(participant.getCapabilities())).m5211a("Result", participant.getResult()).toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m4041a(this, obj);
    }

    public final Participant freeze() {
        return this;
    }

    public final int getCapabilities() {
        return this.FO;
    }

    public final String getDisplayName() {
        return this.XE == null ? this.OS : this.XE.getDisplayName();
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        if (this.XE == null) {
            le.m5324b(this.OS, charArrayBuffer);
        } else {
            this.XE.getDisplayName(charArrayBuffer);
        }
    }

    public final Uri getHiResImageUri() {
        return this.XE == null ? this.WE : this.XE.getHiResImageUri();
    }

    public final String getHiResImageUrl() {
        return this.XE == null ? this.WP : this.XE.getHiResImageUrl();
    }

    public final Uri getIconImageUri() {
        return this.XE == null ? this.WD : this.XE.getIconImageUri();
    }

    public final String getIconImageUrl() {
        return this.XE == null ? this.WO : this.XE.getIconImageUrl();
    }

    public final String getParticipantId() {
        return this.Zk;
    }

    public final Player getPlayer() {
        return this.XE;
    }

    public final ParticipantResult getResult() {
        return this.aea;
    }

    public final int getStatus() {
        return this.FP;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return m4040a(this);
    }

    public final boolean isConnectedToRoom() {
        return this.adZ;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String le() {
        return this.Yi;
    }

    public final String toString() {
        return m4042b((Participant) this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        String str = null;
        int i2 = 0;
        if (hu()) {
            parcel.writeString(this.Zk);
            parcel.writeString(this.OS);
            parcel.writeString(this.WD == null ? null : this.WD.toString());
            if (this.WE != null) {
                str = this.WE.toString();
            }
            parcel.writeString(str);
            parcel.writeInt(this.FP);
            parcel.writeString(this.Yi);
            parcel.writeInt(this.adZ ? 1 : 0);
            if (this.XE != null) {
                i2 = 1;
            }
            parcel.writeInt(i2);
            if (this.XE != null) {
                this.XE.writeToParcel(parcel, i);
                return;
            }
            return;
        }
        ParticipantEntityCreator.m4039a(this, parcel, i);
    }
}
