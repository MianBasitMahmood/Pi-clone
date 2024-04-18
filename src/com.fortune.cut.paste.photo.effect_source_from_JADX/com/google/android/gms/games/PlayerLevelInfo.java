package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public final class PlayerLevelInfo implements SafeParcelable {
    public static final PlayerLevelInfoCreator CREATOR;
    private final int CK;
    private final long Xr;
    private final long Xs;
    private final PlayerLevel Xt;
    private final PlayerLevel Xu;

    static {
        CREATOR = new PlayerLevelInfoCreator();
    }

    PlayerLevelInfo(int i, long j, long j2, PlayerLevel playerLevel, PlayerLevel playerLevel2) {
        jx.m5215K(j != -1);
        jx.m5223i(playerLevel);
        jx.m5223i(playerLevel2);
        this.CK = i;
        this.Xr = j;
        this.Xs = j2;
        this.Xt = playerLevel;
        this.Xu = playerLevel2;
    }

    public PlayerLevelInfo(long j, long j2, PlayerLevel playerLevel, PlayerLevel playerLevel2) {
        this(1, j, j2, playerLevel, playerLevel2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return jv.equal(Long.valueOf(this.Xr), Long.valueOf(playerLevelInfo.Xr)) && jv.equal(Long.valueOf(this.Xs), Long.valueOf(playerLevelInfo.Xs)) && jv.equal(this.Xt, playerLevelInfo.Xt) && jv.equal(this.Xu, playerLevelInfo.Xu);
    }

    public final PlayerLevel getCurrentLevel() {
        return this.Xt;
    }

    public final long getCurrentXpTotal() {
        return this.Xr;
    }

    public final long getLastLevelUpTimestamp() {
        return this.Xs;
    }

    public final PlayerLevel getNextLevel() {
        return this.Xu;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return jv.hashCode(Long.valueOf(this.Xr), Long.valueOf(this.Xs), this.Xt, this.Xu);
    }

    public final boolean isMaxLevel() {
        return this.Xt.equals(this.Xu);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        PlayerLevelInfoCreator.m2835a(this, parcel, i);
    }
}
