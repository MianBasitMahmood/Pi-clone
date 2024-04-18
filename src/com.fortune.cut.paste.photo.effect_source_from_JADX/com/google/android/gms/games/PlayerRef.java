package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef extends C0451d implements Player {
    private final PlayerLevelInfo Xm;
    private final PlayerColumnNames Xv;
    private final MostRecentGameInfoRef Xw;

    public PlayerRef(DataHolder dataHolder, int i) {
        this(dataHolder, i, null);
    }

    public PlayerRef(DataHolder dataHolder, int i, String str) {
        super(dataHolder, i);
        this.Xv = new PlayerColumnNames(str);
        this.Xw = new MostRecentGameInfoRef(dataHolder, i, this.Xv);
        if (kG()) {
            PlayerLevel playerLevel;
            int integer = getInteger(this.Xv.acV);
            int integer2 = getInteger(this.Xv.acY);
            PlayerLevel playerLevel2 = new PlayerLevel(integer, getLong(this.Xv.acW), getLong(this.Xv.acX));
            if (integer != integer2) {
                playerLevel = new PlayerLevel(integer2, getLong(this.Xv.acX), getLong(this.Xv.acZ));
            } else {
                playerLevel = playerLevel2;
            }
            this.Xm = new PlayerLevelInfo(getLong(this.Xv.acU), getLong(this.Xv.ada), playerLevel2, playerLevel);
            return;
        }
        this.Xm = null;
    }

    private boolean kG() {
        return (aS(this.Xv.acU) || getLong(this.Xv.acU) == -1) ? false : true;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return PlayerEntity.m2830a(this, obj);
    }

    public final Player freeze() {
        return new PlayerEntity(this);
    }

    public final String getDisplayName() {
        return getString(this.Xv.acM);
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        m1654a(this.Xv.acM, charArrayBuffer);
    }

    public final Uri getHiResImageUri() {
        return aR(this.Xv.acP);
    }

    public final String getHiResImageUrl() {
        return getString(this.Xv.acQ);
    }

    public final Uri getIconImageUri() {
        return aR(this.Xv.acN);
    }

    public final String getIconImageUrl() {
        return getString(this.Xv.acO);
    }

    public final long getLastPlayedWithTimestamp() {
        return (!aQ(this.Xv.acT) || aS(this.Xv.acT)) ? -1 : getLong(this.Xv.acT);
    }

    public final PlayerLevelInfo getLevelInfo() {
        return this.Xm;
    }

    public final String getPlayerId() {
        return getString(this.Xv.acL);
    }

    public final long getRetrievedTimestamp() {
        return getLong(this.Xv.acR);
    }

    public final String getTitle() {
        return getString(this.Xv.adb);
    }

    public final void getTitle(CharArrayBuffer charArrayBuffer) {
        m1654a(this.Xv.adb, charArrayBuffer);
    }

    public final boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public final boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public final int hashCode() {
        return PlayerEntity.m2831b((Player) this);
    }

    public final boolean isProfileVisible() {
        return getBoolean(this.Xv.add);
    }

    public final int kE() {
        return getInteger(this.Xv.acS);
    }

    public final MostRecentGameInfo kF() {
        return aS(this.Xv.ade) ? null : this.Xw;
    }

    public final String toString() {
        return PlayerEntity.m2833c(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((PlayerEntity) freeze()).writeToParcel(parcel, i);
    }
}
