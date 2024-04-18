package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public final class PlayerLevel implements SafeParcelable {
    public static final PlayerLevelCreator CREATOR;
    private final int CK;
    private final int Xo;
    private final long Xp;
    private final long Xq;

    static {
        CREATOR = new PlayerLevelCreator();
    }

    PlayerLevel(int i, int i2, long j, long j2) {
        boolean z = true;
        jx.m5217a(j >= 0, "Min XP must be positive!");
        if (j2 <= j) {
            z = false;
        }
        jx.m5217a(z, "Max XP must be more than min XP!");
        this.CK = i;
        this.Xo = i2;
        this.Xp = j;
        this.Xq = j2;
    }

    public PlayerLevel(int i, long j, long j2) {
        this(1, i, j, j2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PlayerLevel playerLevel = (PlayerLevel) obj;
        return jv.equal(Integer.valueOf(playerLevel.getLevelNumber()), Integer.valueOf(getLevelNumber())) && jv.equal(Long.valueOf(playerLevel.getMinXp()), Long.valueOf(getMinXp())) && jv.equal(Long.valueOf(playerLevel.getMaxXp()), Long.valueOf(getMaxXp()));
    }

    public final int getLevelNumber() {
        return this.Xo;
    }

    public final long getMaxXp() {
        return this.Xq;
    }

    public final long getMinXp() {
        return this.Xp;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return jv.hashCode(Integer.valueOf(this.Xo), Long.valueOf(this.Xp), Long.valueOf(this.Xq));
    }

    public final String toString() {
        return jv.m5212h(this).m5211a("LevelNumber", Integer.valueOf(getLevelNumber())).m5211a("MinXp", Long.valueOf(getMinXp())).m5211a("MaxXp", Long.valueOf(getMaxXp())).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        PlayerLevelCreator.m2834a(this, parcel, i);
    }
}
