package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public final class MostRecentGameInfoEntity implements SafeParcelable, MostRecentGameInfo {
    public static final MostRecentGameInfoEntityCreator CREATOR;
    private final int CK;
    private final String acF;
    private final String acG;
    private final long acH;
    private final Uri acI;
    private final Uri acJ;
    private final Uri acK;

    static {
        CREATOR = new MostRecentGameInfoEntityCreator();
    }

    MostRecentGameInfoEntity(int i, String str, String str2, long j, Uri uri, Uri uri2, Uri uri3) {
        this.CK = i;
        this.acF = str;
        this.acG = str2;
        this.acH = j;
        this.acI = uri;
        this.acJ = uri2;
        this.acK = uri3;
    }

    public MostRecentGameInfoEntity(MostRecentGameInfo mostRecentGameInfo) {
        this.CK = 2;
        this.acF = mostRecentGameInfo.mw();
        this.acG = mostRecentGameInfo.mx();
        this.acH = mostRecentGameInfo.my();
        this.acI = mostRecentGameInfo.mz();
        this.acJ = mostRecentGameInfo.mA();
        this.acK = mostRecentGameInfo.mB();
    }

    static int m4013a(MostRecentGameInfo mostRecentGameInfo) {
        return jv.hashCode(mostRecentGameInfo.mw(), mostRecentGameInfo.mx(), Long.valueOf(mostRecentGameInfo.my()), mostRecentGameInfo.mz(), mostRecentGameInfo.mA(), mostRecentGameInfo.mB());
    }

    static boolean m4014a(MostRecentGameInfo mostRecentGameInfo, Object obj) {
        if (!(obj instanceof MostRecentGameInfo)) {
            return false;
        }
        if (mostRecentGameInfo == obj) {
            return true;
        }
        MostRecentGameInfo mostRecentGameInfo2 = (MostRecentGameInfo) obj;
        return jv.equal(mostRecentGameInfo2.mw(), mostRecentGameInfo.mw()) && jv.equal(mostRecentGameInfo2.mx(), mostRecentGameInfo.mx()) && jv.equal(Long.valueOf(mostRecentGameInfo2.my()), Long.valueOf(mostRecentGameInfo.my())) && jv.equal(mostRecentGameInfo2.mz(), mostRecentGameInfo.mz()) && jv.equal(mostRecentGameInfo2.mA(), mostRecentGameInfo.mA()) && jv.equal(mostRecentGameInfo2.mB(), mostRecentGameInfo.mB());
    }

    static String m4015b(MostRecentGameInfo mostRecentGameInfo) {
        return jv.m5212h(mostRecentGameInfo).m5211a("GameId", mostRecentGameInfo.mw()).m5211a("GameName", mostRecentGameInfo.mx()).m5211a("ActivityTimestampMillis", Long.valueOf(mostRecentGameInfo.my())).m5211a("GameIconUri", mostRecentGameInfo.mz()).m5211a("GameHiResUri", mostRecentGameInfo.mA()).m5211a("GameFeaturedUri", mostRecentGameInfo.mB()).toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m4014a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return mC();
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return m4013a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final Uri mA() {
        return this.acJ;
    }

    public final Uri mB() {
        return this.acK;
    }

    public final MostRecentGameInfo mC() {
        return this;
    }

    public final String mw() {
        return this.acF;
    }

    public final String mx() {
        return this.acG;
    }

    public final long my() {
        return this.acH;
    }

    public final Uri mz() {
        return this.acI;
    }

    public final String toString() {
        return m4015b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        MostRecentGameInfoEntityCreator.m4016a(this, parcel, i);
    }
}
