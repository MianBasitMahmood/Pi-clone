package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jv;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge {
    public static final GameBadgeEntityCreator CREATOR;
    private final int CK;
    private int Gt;
    private String OH;
    private String UO;
    private Uri WD;

    static final class GameBadgeEntityCreatorCompat extends GameBadgeEntityCreator {
        GameBadgeEntityCreatorCompat() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return cv(parcel);
        }

        public final GameBadgeEntity cv(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.m2815c(ji.ht()) || ji.aW(GameBadgeEntity.class.getCanonicalName())) {
                return super.cv(parcel);
            }
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            return new GameBadgeEntity(1, readInt, readString, readString2, readString3 == null ? null : Uri.parse(readString3));
        }
    }

    static {
        CREATOR = new GameBadgeEntityCreatorCompat();
    }

    GameBadgeEntity(int i, int i2, String str, String str2, Uri uri) {
        this.CK = i;
        this.Gt = i2;
        this.OH = str;
        this.UO = str2;
        this.WD = uri;
    }

    public GameBadgeEntity(GameBadge gameBadge) {
        this.CK = 1;
        this.Gt = gameBadge.getType();
        this.OH = gameBadge.getTitle();
        this.UO = gameBadge.getDescription();
        this.WD = gameBadge.getIconImageUri();
    }

    static int m4008a(GameBadge gameBadge) {
        return jv.hashCode(Integer.valueOf(gameBadge.getType()), gameBadge.getTitle(), gameBadge.getDescription(), gameBadge.getIconImageUri());
    }

    static boolean m4009a(GameBadge gameBadge, Object obj) {
        if (!(obj instanceof GameBadge)) {
            return false;
        }
        if (gameBadge == obj) {
            return true;
        }
        GameBadge gameBadge2 = (GameBadge) obj;
        return jv.equal(Integer.valueOf(gameBadge2.getType()), gameBadge.getTitle()) && jv.equal(gameBadge2.getDescription(), gameBadge.getIconImageUri());
    }

    static String m4010b(GameBadge gameBadge) {
        return jv.m5212h(gameBadge).m5211a("Type", Integer.valueOf(gameBadge.getType())).m5211a("Title", gameBadge.getTitle()).m5211a("Description", gameBadge.getDescription()).m5211a("IconImageUri", gameBadge.getIconImageUri()).toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m4009a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return mk();
    }

    public final String getDescription() {
        return this.UO;
    }

    public final Uri getIconImageUri() {
        return this.WD;
    }

    public final String getTitle() {
        return this.OH;
    }

    public final int getType() {
        return this.Gt;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return m4008a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final GameBadge mk() {
        return this;
    }

    public final String toString() {
        return m4010b((GameBadge) this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (hu()) {
            parcel.writeInt(this.Gt);
            parcel.writeString(this.OH);
            parcel.writeString(this.UO);
            parcel.writeString(this.WD == null ? null : this.WD.toString());
            return;
        }
        GameBadgeEntityCreator.m4007a(this, parcel, i);
    }
}
