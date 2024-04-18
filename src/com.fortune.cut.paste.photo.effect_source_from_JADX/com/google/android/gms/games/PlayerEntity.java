package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;

public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Creator<PlayerEntity> CREATOR;
    private final int CK;
    private final String OH;
    private final String OS;
    private final Uri WD;
    private final Uri WE;
    private final String WO;
    private final String WP;
    private final String Xh;
    private final long Xi;
    private final int Xj;
    private final long Xk;
    private final MostRecentGameInfoEntity Xl;
    private final PlayerLevelInfo Xm;
    private final boolean Xn;

    static final class PlayerEntityCreatorCompat extends PlayerEntityCreator {
        PlayerEntityCreatorCompat() {
        }

        public final PlayerEntity cm(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.m2815c(ji.ht()) || ji.aW(PlayerEntity.class.getCanonicalName())) {
                return super.cm(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            return new PlayerEntity(11, readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), parcel.readLong(), -1, -1, null, null, null, null, null, true);
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return cm(parcel);
        }
    }

    static {
        CREATOR = new PlayerEntityCreatorCompat();
    }

    PlayerEntity(int i, String str, String str2, Uri uri, Uri uri2, long j, int i2, long j2, String str3, String str4, String str5, MostRecentGameInfoEntity mostRecentGameInfoEntity, PlayerLevelInfo playerLevelInfo, boolean z) {
        this.CK = i;
        this.Xh = str;
        this.OS = str2;
        this.WD = uri;
        this.WO = str3;
        this.WE = uri2;
        this.WP = str4;
        this.Xi = j;
        this.Xj = i2;
        this.Xk = j2;
        this.OH = str5;
        this.Xn = z;
        this.Xl = mostRecentGameInfoEntity;
        this.Xm = playerLevelInfo;
    }

    public PlayerEntity(Player player) {
        this.CK = 11;
        this.Xh = player.getPlayerId();
        this.OS = player.getDisplayName();
        this.WD = player.getIconImageUri();
        this.WO = player.getIconImageUrl();
        this.WE = player.getHiResImageUri();
        this.WP = player.getHiResImageUrl();
        this.Xi = player.getRetrievedTimestamp();
        this.Xj = player.kE();
        this.Xk = player.getLastPlayedWithTimestamp();
        this.OH = player.getTitle();
        this.Xn = player.isProfileVisible();
        MostRecentGameInfo kF = player.kF();
        this.Xl = kF == null ? null : new MostRecentGameInfoEntity(kF);
        this.Xm = player.getLevelInfo();
        je.m5081f(this.Xh);
        je.m5081f(this.OS);
        je.m5079K(this.Xi > 0);
    }

    static boolean m2830a(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return jv.equal(player2.getPlayerId(), player.getPlayerId()) && jv.equal(player2.getDisplayName(), player.getDisplayName()) && jv.equal(player2.getIconImageUri(), player.getIconImageUri()) && jv.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && jv.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && jv.equal(player2.getTitle(), player.getTitle()) && jv.equal(player2.getLevelInfo(), player.getLevelInfo());
    }

    static int m2831b(Player player) {
        return jv.hashCode(player.getPlayerId(), player.getDisplayName(), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo());
    }

    static String m2833c(Player player) {
        return jv.m5212h(player).m5211a("PlayerId", player.getPlayerId()).m5211a("DisplayName", player.getDisplayName()).m5211a("IconImageUri", player.getIconImageUri()).m5211a("IconImageUrl", player.getIconImageUrl()).m5211a("HiResImageUri", player.getHiResImageUri()).m5211a("HiResImageUrl", player.getHiResImageUrl()).m5211a("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).m5211a("Title", player.getTitle()).m5211a("LevelInfo", player.getLevelInfo()).toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m2830a(this, obj);
    }

    public final Player freeze() {
        return this;
    }

    public final String getDisplayName() {
        return this.OS;
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        le.m5324b(this.OS, charArrayBuffer);
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

    public final long getLastPlayedWithTimestamp() {
        return this.Xk;
    }

    public final PlayerLevelInfo getLevelInfo() {
        return this.Xm;
    }

    public final String getPlayerId() {
        return this.Xh;
    }

    public final long getRetrievedTimestamp() {
        return this.Xi;
    }

    public final String getTitle() {
        return this.OH;
    }

    public final void getTitle(CharArrayBuffer charArrayBuffer) {
        le.m5324b(this.OH, charArrayBuffer);
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public final boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public final int hashCode() {
        return m2831b((Player) this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final boolean isProfileVisible() {
        return this.Xn;
    }

    public final int kE() {
        return this.Xj;
    }

    public final MostRecentGameInfo kF() {
        return this.Xl;
    }

    public final String toString() {
        return m2833c(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        String str = null;
        if (hu()) {
            parcel.writeString(this.Xh);
            parcel.writeString(this.OS);
            parcel.writeString(this.WD == null ? null : this.WD.toString());
            if (this.WE != null) {
                str = this.WE.toString();
            }
            parcel.writeString(str);
            parcel.writeLong(this.Xi);
            return;
        }
        PlayerEntityCreator.m2829a(this, parcel, i);
    }
}
