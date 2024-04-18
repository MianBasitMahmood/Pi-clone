package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;

public final class ExtendedGameEntity extends GamesDowngradeableSafeParcel implements ExtendedGame {
    public static final ExtendedGameEntityCreator CREATOR;
    private final int CK;
    private final String acA;
    private final ArrayList<GameBadgeEntity> acB;
    private final SnapshotMetadataEntity acC;
    private final GameEntity acs;
    private final int act;
    private final boolean acu;
    private final int acv;
    private final long acw;
    private final long acx;
    private final String acy;
    private final long acz;

    static final class ExtendedGameEntityCreatorCompat extends ExtendedGameEntityCreator {
        ExtendedGameEntityCreatorCompat() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return cu(parcel);
        }

        public final ExtendedGameEntity cu(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.m2815c(ji.ht()) || ji.aW(ExtendedGameEntity.class.getCanonicalName())) {
                return super.cu(parcel);
            }
            GameEntity gameEntity = (GameEntity) GameEntity.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            boolean z = parcel.readInt() == 1;
            int readInt2 = parcel.readInt();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            String readString = parcel.readString();
            long readLong3 = parcel.readLong();
            String readString2 = parcel.readString();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(GameBadgeEntity.CREATOR.cv(parcel));
            }
            return new ExtendedGameEntity(2, gameEntity, readInt, z, readInt2, readLong, readLong2, readString, readLong3, readString2, arrayList, null);
        }
    }

    static {
        CREATOR = new ExtendedGameEntityCreatorCompat();
    }

    ExtendedGameEntity(int i, GameEntity gameEntity, int i2, boolean z, int i3, long j, long j2, String str, long j3, String str2, ArrayList<GameBadgeEntity> arrayList, SnapshotMetadataEntity snapshotMetadataEntity) {
        this.CK = i;
        this.acs = gameEntity;
        this.act = i2;
        this.acu = z;
        this.acv = i3;
        this.acw = j;
        this.acx = j2;
        this.acy = str;
        this.acz = j3;
        this.acA = str2;
        this.acB = arrayList;
        this.acC = snapshotMetadataEntity;
    }

    public ExtendedGameEntity(ExtendedGame extendedGame) {
        SnapshotMetadataEntity snapshotMetadataEntity = null;
        this.CK = 2;
        Game game = extendedGame.getGame();
        this.acs = game == null ? null : new GameEntity(game);
        this.act = extendedGame.lZ();
        this.acu = extendedGame.ma();
        this.acv = extendedGame.mb();
        this.acw = extendedGame.mc();
        this.acx = extendedGame.md();
        this.acy = extendedGame.me();
        this.acz = extendedGame.mf();
        this.acA = extendedGame.mg();
        SnapshotMetadata mh = extendedGame.mh();
        if (mh != null) {
            snapshotMetadataEntity = new SnapshotMetadataEntity(mh);
        }
        this.acC = snapshotMetadataEntity;
        ArrayList lY = extendedGame.lY();
        int size = lY.size();
        this.acB = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.acB.add((GameBadgeEntity) ((GameBadge) lY.get(i)).freeze());
        }
    }

    static int m4003a(ExtendedGame extendedGame) {
        return jv.hashCode(extendedGame.getGame(), Integer.valueOf(extendedGame.lZ()), Boolean.valueOf(extendedGame.ma()), Integer.valueOf(extendedGame.mb()), Long.valueOf(extendedGame.mc()), Long.valueOf(extendedGame.md()), extendedGame.me(), Long.valueOf(extendedGame.mf()), extendedGame.mg());
    }

    static boolean m4004a(ExtendedGame extendedGame, Object obj) {
        if (!(obj instanceof ExtendedGame)) {
            return false;
        }
        if (extendedGame == obj) {
            return true;
        }
        ExtendedGame extendedGame2 = (ExtendedGame) obj;
        return jv.equal(extendedGame2.getGame(), extendedGame.getGame()) && jv.equal(Integer.valueOf(extendedGame2.lZ()), Integer.valueOf(extendedGame.lZ())) && jv.equal(Boolean.valueOf(extendedGame2.ma()), Boolean.valueOf(extendedGame.ma())) && jv.equal(Integer.valueOf(extendedGame2.mb()), Integer.valueOf(extendedGame.mb())) && jv.equal(Long.valueOf(extendedGame2.mc()), Long.valueOf(extendedGame.mc())) && jv.equal(Long.valueOf(extendedGame2.md()), Long.valueOf(extendedGame.md())) && jv.equal(extendedGame2.me(), extendedGame.me()) && jv.equal(Long.valueOf(extendedGame2.mf()), Long.valueOf(extendedGame.mf())) && jv.equal(extendedGame2.mg(), extendedGame.mg());
    }

    static String m4005b(ExtendedGame extendedGame) {
        return jv.m5212h(extendedGame).m5211a("Game", extendedGame.getGame()).m5211a("Availability", Integer.valueOf(extendedGame.lZ())).m5211a("Owned", Boolean.valueOf(extendedGame.ma())).m5211a("AchievementUnlockedCount", Integer.valueOf(extendedGame.mb())).m5211a("LastPlayedServerTimestamp", Long.valueOf(extendedGame.mc())).m5211a("PriceMicros", Long.valueOf(extendedGame.md())).m5211a("FormattedPrice", extendedGame.me()).m5211a("FullPriceMicros", Long.valueOf(extendedGame.mf())).m5211a("FormattedFullPrice", extendedGame.mg()).m5211a("Snapshot", extendedGame.mh()).toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m4004a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return mj();
    }

    public final /* synthetic */ Game getGame() {
        return mi();
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return m4003a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final ArrayList<GameBadge> lY() {
        return new ArrayList(this.acB);
    }

    public final int lZ() {
        return this.act;
    }

    public final boolean ma() {
        return this.acu;
    }

    public final int mb() {
        return this.acv;
    }

    public final long mc() {
        return this.acw;
    }

    public final long md() {
        return this.acx;
    }

    public final String me() {
        return this.acy;
    }

    public final long mf() {
        return this.acz;
    }

    public final String mg() {
        return this.acA;
    }

    public final SnapshotMetadata mh() {
        return this.acC;
    }

    public final GameEntity mi() {
        return this.acs;
    }

    public final ExtendedGame mj() {
        return this;
    }

    public final String toString() {
        return m4005b((ExtendedGame) this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        if (hu()) {
            this.acs.writeToParcel(parcel, i);
            parcel.writeInt(this.act);
            parcel.writeInt(this.acu ? 1 : 0);
            parcel.writeInt(this.acv);
            parcel.writeLong(this.acw);
            parcel.writeLong(this.acx);
            parcel.writeString(this.acy);
            parcel.writeLong(this.acz);
            parcel.writeString(this.acA);
            int size = this.acB.size();
            parcel.writeInt(size);
            while (i2 < size) {
                ((GameBadgeEntity) this.acB.get(i2)).writeToParcel(parcel, i);
                i2++;
            }
            return;
        }
        ExtendedGameEntityCreator.m4002a(this, parcel, i);
    }
}
