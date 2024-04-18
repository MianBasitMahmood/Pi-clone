package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.C1265a;
import com.google.android.gms.internal.le;

public final class AchievementEntity implements SafeParcelable, Achievement {
    public static final AchievementEntityCreator CREATOR;
    private final int CK;
    private final int Gt;
    private final String UO;
    private final Uri XA;
    private final String XB;
    private final int XC;
    private final String XD;
    private final PlayerEntity XE;
    private final int XF;
    private final String XG;
    private final long XH;
    private final long XI;
    private final String Xx;
    private final Uri Xy;
    private final String Xz;
    private final String mName;
    private final int mState;

    static {
        CREATOR = new AchievementEntityCreator();
    }

    AchievementEntity(int i, String str, int i2, String str2, String str3, Uri uri, String str4, Uri uri2, String str5, int i3, String str6, PlayerEntity playerEntity, int i4, int i5, String str7, long j, long j2) {
        this.CK = i;
        this.Xx = str;
        this.Gt = i2;
        this.mName = str2;
        this.UO = str3;
        this.Xy = uri;
        this.Xz = str4;
        this.XA = uri2;
        this.XB = str5;
        this.XC = i3;
        this.XD = str6;
        this.XE = playerEntity;
        this.mState = i4;
        this.XF = i5;
        this.XG = str7;
        this.XH = j;
        this.XI = j2;
    }

    public AchievementEntity(Achievement achievement) {
        this.CK = 1;
        this.Xx = achievement.getAchievementId();
        this.Gt = achievement.getType();
        this.mName = achievement.getName();
        this.UO = achievement.getDescription();
        this.Xy = achievement.getUnlockedImageUri();
        this.Xz = achievement.getUnlockedImageUrl();
        this.XA = achievement.getRevealedImageUri();
        this.XB = achievement.getRevealedImageUrl();
        this.XE = (PlayerEntity) achievement.getPlayer().freeze();
        this.mState = achievement.getState();
        this.XH = achievement.getLastUpdatedTimestamp();
        this.XI = achievement.getXpValue();
        if (achievement.getType() == 1) {
            this.XC = achievement.getTotalSteps();
            this.XD = achievement.getFormattedTotalSteps();
            this.XF = achievement.getCurrentSteps();
            this.XG = achievement.getFormattedCurrentSteps();
        } else {
            this.XC = 0;
            this.XD = null;
            this.XF = 0;
            this.XG = null;
        }
        je.m5081f(this.Xx);
        je.m5081f(this.UO);
    }

    static int m2836a(Achievement achievement) {
        int currentSteps;
        int totalSteps;
        if (achievement.getType() == 1) {
            currentSteps = achievement.getCurrentSteps();
            totalSteps = achievement.getTotalSteps();
        } else {
            totalSteps = 0;
            currentSteps = 0;
        }
        return jv.hashCode(achievement.getAchievementId(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.getPlayer(), Integer.valueOf(currentSteps), Integer.valueOf(totalSteps));
    }

    static boolean m2837a(Achievement achievement, Object obj) {
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        boolean equal;
        boolean equal2;
        Achievement achievement2 = (Achievement) obj;
        if (achievement.getType() == 1) {
            equal = jv.equal(Integer.valueOf(achievement2.getCurrentSteps()), Integer.valueOf(achievement.getCurrentSteps()));
            equal2 = jv.equal(Integer.valueOf(achievement2.getTotalSteps()), Integer.valueOf(achievement.getTotalSteps()));
        } else {
            equal2 = true;
            equal = true;
        }
        return jv.equal(achievement2.getAchievementId(), achievement.getAchievementId()) && jv.equal(achievement2.getName(), achievement.getName()) && jv.equal(Integer.valueOf(achievement2.getType()), Integer.valueOf(achievement.getType())) && jv.equal(achievement2.getDescription(), achievement.getDescription()) && jv.equal(Long.valueOf(achievement2.getXpValue()), Long.valueOf(achievement.getXpValue())) && jv.equal(Integer.valueOf(achievement2.getState()), Integer.valueOf(achievement.getState())) && jv.equal(Long.valueOf(achievement2.getLastUpdatedTimestamp()), Long.valueOf(achievement.getLastUpdatedTimestamp())) && jv.equal(achievement2.getPlayer(), achievement.getPlayer()) && equal && equal2;
    }

    static String m2838b(Achievement achievement) {
        C1265a a = jv.m5212h(achievement).m5211a("Id", achievement.getAchievementId()).m5211a("Type", Integer.valueOf(achievement.getType())).m5211a("Name", achievement.getName()).m5211a("Description", achievement.getDescription()).m5211a("Player", achievement.getPlayer()).m5211a("State", Integer.valueOf(achievement.getState()));
        if (achievement.getType() == 1) {
            a.m5211a("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            a.m5211a("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return a.toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m2837a(this, obj);
    }

    public final Achievement freeze() {
        return this;
    }

    public final String getAchievementId() {
        return this.Xx;
    }

    public final int getCurrentSteps() {
        return this.XF;
    }

    public final String getDescription() {
        return this.UO;
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        le.m5324b(this.UO, charArrayBuffer);
    }

    public final String getFormattedCurrentSteps() {
        return this.XG;
    }

    public final void getFormattedCurrentSteps(CharArrayBuffer charArrayBuffer) {
        le.m5324b(this.XG, charArrayBuffer);
    }

    public final String getFormattedTotalSteps() {
        return this.XD;
    }

    public final void getFormattedTotalSteps(CharArrayBuffer charArrayBuffer) {
        le.m5324b(this.XD, charArrayBuffer);
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

    public final Player getPlayer() {
        return this.XE;
    }

    public final Uri getRevealedImageUri() {
        return this.XA;
    }

    public final String getRevealedImageUrl() {
        return this.XB;
    }

    public final int getState() {
        return this.mState;
    }

    public final int getTotalSteps() {
        return this.XC;
    }

    public final int getType() {
        return this.Gt;
    }

    public final Uri getUnlockedImageUri() {
        return this.Xy;
    }

    public final String getUnlockedImageUrl() {
        return this.Xz;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final long getXpValue() {
        return this.XI;
    }

    public final int hashCode() {
        return m2836a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return m2838b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AchievementEntityCreator.m2839a(this, parcel, i);
    }
}
