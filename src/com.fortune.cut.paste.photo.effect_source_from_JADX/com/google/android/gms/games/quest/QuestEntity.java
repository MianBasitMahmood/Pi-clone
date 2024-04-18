package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity implements SafeParcelable, Quest {
    public static final QuestEntityCreator CREATOR;
    private final int CK;
    private final int Gt;
    private final String UO;
    private final long XH;
    private final GameEntity acs;
    private final String aeK;
    private final long aeL;
    private final Uri aeM;
    private final String aeN;
    private final long aeO;
    private final Uri aeP;
    private final String aeQ;
    private final long aeR;
    private final long aeS;
    private final ArrayList<MilestoneEntity> aeT;
    private final String mName;
    private final int mState;

    static {
        CREATOR = new QuestEntityCreator();
    }

    QuestEntity(int i, GameEntity gameEntity, String str, long j, Uri uri, String str2, String str3, long j2, long j3, Uri uri2, String str4, String str5, long j4, long j5, int i2, int i3, ArrayList<MilestoneEntity> arrayList) {
        this.CK = i;
        this.acs = gameEntity;
        this.aeK = str;
        this.aeL = j;
        this.aeM = uri;
        this.aeN = str2;
        this.UO = str3;
        this.aeO = j2;
        this.XH = j3;
        this.aeP = uri2;
        this.aeQ = str4;
        this.mName = str5;
        this.aeR = j4;
        this.aeS = j5;
        this.mState = i2;
        this.Gt = i3;
        this.aeT = arrayList;
    }

    public QuestEntity(Quest quest) {
        this.CK = 2;
        this.acs = new GameEntity(quest.getGame());
        this.aeK = quest.getQuestId();
        this.aeL = quest.getAcceptedTimestamp();
        this.UO = quest.getDescription();
        this.aeM = quest.getBannerImageUri();
        this.aeN = quest.getBannerImageUrl();
        this.aeO = quest.getEndTimestamp();
        this.aeP = quest.getIconImageUri();
        this.aeQ = quest.getIconImageUrl();
        this.XH = quest.getLastUpdatedTimestamp();
        this.mName = quest.getName();
        this.aeR = quest.mR();
        this.aeS = quest.getStartTimestamp();
        this.mState = quest.getState();
        this.Gt = quest.getType();
        List mQ = quest.mQ();
        int size = mQ.size();
        this.aeT = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.aeT.add((MilestoneEntity) ((Milestone) mQ.get(i)).freeze());
        }
    }

    static int m4073a(Quest quest) {
        return jv.hashCode(quest.getGame(), quest.getQuestId(), Long.valueOf(quest.getAcceptedTimestamp()), quest.getBannerImageUri(), quest.getDescription(), Long.valueOf(quest.getEndTimestamp()), quest.getIconImageUri(), Long.valueOf(quest.getLastUpdatedTimestamp()), quest.mQ(), quest.getName(), Long.valueOf(quest.mR()), Long.valueOf(quest.getStartTimestamp()), Integer.valueOf(quest.getState()));
    }

    static boolean m4074a(Quest quest, Object obj) {
        if (!(obj instanceof Quest)) {
            return false;
        }
        if (quest == obj) {
            return true;
        }
        Quest quest2 = (Quest) obj;
        return jv.equal(quest2.getGame(), quest.getGame()) && jv.equal(quest2.getQuestId(), quest.getQuestId()) && jv.equal(Long.valueOf(quest2.getAcceptedTimestamp()), Long.valueOf(quest.getAcceptedTimestamp())) && jv.equal(quest2.getBannerImageUri(), quest.getBannerImageUri()) && jv.equal(quest2.getDescription(), quest.getDescription()) && jv.equal(Long.valueOf(quest2.getEndTimestamp()), Long.valueOf(quest.getEndTimestamp())) && jv.equal(quest2.getIconImageUri(), quest.getIconImageUri()) && jv.equal(Long.valueOf(quest2.getLastUpdatedTimestamp()), Long.valueOf(quest.getLastUpdatedTimestamp())) && jv.equal(quest2.mQ(), quest.mQ()) && jv.equal(quest2.getName(), quest.getName()) && jv.equal(Long.valueOf(quest2.mR()), Long.valueOf(quest.mR())) && jv.equal(Long.valueOf(quest2.getStartTimestamp()), Long.valueOf(quest.getStartTimestamp())) && jv.equal(Integer.valueOf(quest2.getState()), Integer.valueOf(quest.getState()));
    }

    static String m4075b(Quest quest) {
        return jv.m5212h(quest).m5211a("Game", quest.getGame()).m5211a("QuestId", quest.getQuestId()).m5211a("AcceptedTimestamp", Long.valueOf(quest.getAcceptedTimestamp())).m5211a("BannerImageUri", quest.getBannerImageUri()).m5211a("BannerImageUrl", quest.getBannerImageUrl()).m5211a("Description", quest.getDescription()).m5211a("EndTimestamp", Long.valueOf(quest.getEndTimestamp())).m5211a("IconImageUri", quest.getIconImageUri()).m5211a("IconImageUrl", quest.getIconImageUrl()).m5211a("LastUpdatedTimestamp", Long.valueOf(quest.getLastUpdatedTimestamp())).m5211a("Milestones", quest.mQ()).m5211a("Name", quest.getName()).m5211a("NotifyTimestamp", Long.valueOf(quest.mR())).m5211a("StartTimestamp", Long.valueOf(quest.getStartTimestamp())).m5211a("State", Integer.valueOf(quest.getState())).toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m4074a(this, obj);
    }

    public final Quest freeze() {
        return this;
    }

    public final long getAcceptedTimestamp() {
        return this.aeL;
    }

    public final Uri getBannerImageUri() {
        return this.aeM;
    }

    public final String getBannerImageUrl() {
        return this.aeN;
    }

    public final Milestone getCurrentMilestone() {
        return (Milestone) mQ().get(0);
    }

    public final String getDescription() {
        return this.UO;
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        le.m5324b(this.UO, charArrayBuffer);
    }

    public final long getEndTimestamp() {
        return this.aeO;
    }

    public final Game getGame() {
        return this.acs;
    }

    public final Uri getIconImageUri() {
        return this.aeP;
    }

    public final String getIconImageUrl() {
        return this.aeQ;
    }

    public final long getLastUpdatedTimestamp() {
        return this.XH;
    }

    public final String getName() {
        return this.mName;
    }

    public final void getName(CharArrayBuffer charArrayBuffer) {
        le.m5324b(this.mName, charArrayBuffer);
    }

    public final String getQuestId() {
        return this.aeK;
    }

    public final long getStartTimestamp() {
        return this.aeS;
    }

    public final int getState() {
        return this.mState;
    }

    public final int getType() {
        return this.Gt;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return m4073a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final boolean isEndingSoon() {
        return this.aeR <= System.currentTimeMillis() + 1800000;
    }

    public final List<Milestone> mQ() {
        return new ArrayList(this.aeT);
    }

    public final long mR() {
        return this.aeR;
    }

    public final String toString() {
        return m4075b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        QuestEntityCreator.m4076a(this, parcel, i);
    }
}
