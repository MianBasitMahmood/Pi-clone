package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;

public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Creator<GameEntity> CREATOR;
    private final int CK;
    private final String Fo;
    private final String OS;
    private final String UO;
    private final String WA;
    private final String WB;
    private final String WC;
    private final Uri WD;
    private final Uri WE;
    private final Uri WF;
    private final boolean WG;
    private final boolean WH;
    private final String WI;
    private final int WJ;
    private final int WK;
    private final int WL;
    private final boolean WM;
    private final boolean WN;
    private final String WO;
    private final String WP;
    private final String WQ;
    private final boolean WR;
    private final boolean WS;
    private final boolean WT;
    private final String WU;

    static final class GameEntityCreatorCompat extends GameEntityCreator {
        GameEntityCreatorCompat() {
        }

        public final GameEntity cl(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.m2815c(ji.ht()) || ji.aW(GameEntity.class.getCanonicalName())) {
                return super.cl(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Uri parse = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            Uri parse2 = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            return new GameEntity(5, readString, readString2, readString3, readString4, readString5, readString6, parse, parse2, readString7 == null ? null : Uri.parse(readString7), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, null, null, null, false, false, false, null);
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return cl(parcel);
        }
    }

    static {
        CREATOR = new GameEntityCreatorCompat();
    }

    GameEntity(int i, String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Uri uri2, Uri uri3, boolean z, boolean z2, String str7, int i2, int i3, int i4, boolean z3, boolean z4, String str8, String str9, String str10, boolean z5, boolean z6, boolean z7, String str11) {
        this.CK = i;
        this.Fo = str;
        this.OS = str2;
        this.WA = str3;
        this.WB = str4;
        this.UO = str5;
        this.WC = str6;
        this.WD = uri;
        this.WO = str8;
        this.WE = uri2;
        this.WP = str9;
        this.WF = uri3;
        this.WQ = str10;
        this.WG = z;
        this.WH = z2;
        this.WI = str7;
        this.WJ = i2;
        this.WK = i3;
        this.WL = i4;
        this.WM = z3;
        this.WN = z4;
        this.WR = z5;
        this.WS = z6;
        this.WT = z7;
        this.WU = str11;
    }

    public GameEntity(Game game) {
        this.CK = 5;
        this.Fo = game.getApplicationId();
        this.WA = game.getPrimaryCategory();
        this.WB = game.getSecondaryCategory();
        this.UO = game.getDescription();
        this.WC = game.getDeveloperName();
        this.OS = game.getDisplayName();
        this.WD = game.getIconImageUri();
        this.WO = game.getIconImageUrl();
        this.WE = game.getHiResImageUri();
        this.WP = game.getHiResImageUrl();
        this.WF = game.getFeaturedImageUri();
        this.WQ = game.getFeaturedImageUrl();
        this.WG = game.ky();
        this.WH = game.kA();
        this.WI = game.kB();
        this.WJ = game.kC();
        this.WK = game.getAchievementTotalCount();
        this.WL = game.getLeaderboardCount();
        this.WM = game.isRealTimeMultiplayerEnabled();
        this.WN = game.isTurnBasedMultiplayerEnabled();
        this.WR = game.isMuted();
        this.WS = game.kz();
        this.WT = game.areSnapshotsEnabled();
        this.WU = game.getThemeColor();
    }

    static int m2816a(Game game) {
        return jv.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.ky()), Boolean.valueOf(game.kA()), game.kB(), Integer.valueOf(game.kC()), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isMuted()), Boolean.valueOf(game.kz()), Boolean.valueOf(game.areSnapshotsEnabled()), game.getThemeColor());
    }

    static boolean m2817a(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        if (!jv.equal(game2.getApplicationId(), game.getApplicationId()) || !jv.equal(game2.getDisplayName(), game.getDisplayName()) || !jv.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) || !jv.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) || !jv.equal(game2.getDescription(), game.getDescription()) || !jv.equal(game2.getDeveloperName(), game.getDeveloperName()) || !jv.equal(game2.getIconImageUri(), game.getIconImageUri()) || !jv.equal(game2.getHiResImageUri(), game.getHiResImageUri()) || !jv.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) || !jv.equal(Boolean.valueOf(game2.ky()), Boolean.valueOf(game.ky())) || !jv.equal(Boolean.valueOf(game2.kA()), Boolean.valueOf(game.kA())) || !jv.equal(game2.kB(), game.kB()) || !jv.equal(Integer.valueOf(game2.kC()), Integer.valueOf(game.kC())) || !jv.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) || !jv.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) || !jv.equal(Boolean.valueOf(game2.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()))) {
            return false;
        }
        Boolean valueOf = Boolean.valueOf(game2.isTurnBasedMultiplayerEnabled());
        boolean z = game.isTurnBasedMultiplayerEnabled() && jv.equal(Boolean.valueOf(game2.isMuted()), Boolean.valueOf(game.isMuted())) && jv.equal(Boolean.valueOf(game2.kz()), Boolean.valueOf(game.kz()));
        return jv.equal(valueOf, Boolean.valueOf(z)) && jv.equal(Boolean.valueOf(game2.areSnapshotsEnabled()), Boolean.valueOf(game.areSnapshotsEnabled())) && jv.equal(game2.getThemeColor(), game.getThemeColor());
    }

    static String m2818b(Game game) {
        return jv.m5212h(game).m5211a("ApplicationId", game.getApplicationId()).m5211a("DisplayName", game.getDisplayName()).m5211a("PrimaryCategory", game.getPrimaryCategory()).m5211a("SecondaryCategory", game.getSecondaryCategory()).m5211a("Description", game.getDescription()).m5211a("DeveloperName", game.getDeveloperName()).m5211a("IconImageUri", game.getIconImageUri()).m5211a("IconImageUrl", game.getIconImageUrl()).m5211a("HiResImageUri", game.getHiResImageUri()).m5211a("HiResImageUrl", game.getHiResImageUrl()).m5211a("FeaturedImageUri", game.getFeaturedImageUri()).m5211a("FeaturedImageUrl", game.getFeaturedImageUrl()).m5211a("PlayEnabledGame", Boolean.valueOf(game.ky())).m5211a("InstanceInstalled", Boolean.valueOf(game.kA())).m5211a("InstancePackageName", game.kB()).m5211a("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).m5211a("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).m5211a("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).m5211a("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).m5211a("AreSnapshotsEnabled", Boolean.valueOf(game.areSnapshotsEnabled())).m5211a("ThemeColor", game.getThemeColor()).toString();
    }

    public final boolean areSnapshotsEnabled() {
        return this.WT;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m2817a(this, obj);
    }

    public final Game freeze() {
        return this;
    }

    public final int getAchievementTotalCount() {
        return this.WK;
    }

    public final String getApplicationId() {
        return this.Fo;
    }

    public final String getDescription() {
        return this.UO;
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        le.m5324b(this.UO, charArrayBuffer);
    }

    public final String getDeveloperName() {
        return this.WC;
    }

    public final void getDeveloperName(CharArrayBuffer charArrayBuffer) {
        le.m5324b(this.WC, charArrayBuffer);
    }

    public final String getDisplayName() {
        return this.OS;
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        le.m5324b(this.OS, charArrayBuffer);
    }

    public final Uri getFeaturedImageUri() {
        return this.WF;
    }

    public final String getFeaturedImageUrl() {
        return this.WQ;
    }

    public final Uri getHiResImageUri() {
        return this.WE;
    }

    public final String getHiResImageUrl() {
        return this.WP;
    }

    public final Uri getIconImageUri() {
        return this.WD;
    }

    public final String getIconImageUrl() {
        return this.WO;
    }

    public final int getLeaderboardCount() {
        return this.WL;
    }

    public final String getPrimaryCategory() {
        return this.WA;
    }

    public final String getSecondaryCategory() {
        return this.WB;
    }

    public final String getThemeColor() {
        return this.WU;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return m2816a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final boolean isMuted() {
        return this.WR;
    }

    public final boolean isRealTimeMultiplayerEnabled() {
        return this.WM;
    }

    public final boolean isTurnBasedMultiplayerEnabled() {
        return this.WN;
    }

    public final boolean kA() {
        return this.WH;
    }

    public final String kB() {
        return this.WI;
    }

    public final int kC() {
        return this.WJ;
    }

    public final boolean ky() {
        return this.WG;
    }

    public final boolean kz() {
        return this.WS;
    }

    public final String toString() {
        return m2818b((Game) this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        String str = null;
        if (hu()) {
            parcel.writeString(this.Fo);
            parcel.writeString(this.OS);
            parcel.writeString(this.WA);
            parcel.writeString(this.WB);
            parcel.writeString(this.UO);
            parcel.writeString(this.WC);
            parcel.writeString(this.WD == null ? null : this.WD.toString());
            parcel.writeString(this.WE == null ? null : this.WE.toString());
            if (this.WF != null) {
                str = this.WF.toString();
            }
            parcel.writeString(str);
            parcel.writeInt(this.WG ? 1 : 0);
            if (!this.WH) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeString(this.WI);
            parcel.writeInt(this.WJ);
            parcel.writeInt(this.WK);
            parcel.writeInt(this.WL);
            return;
        }
        GameEntityCreator.m2813a(this, parcel, i);
    }
}
