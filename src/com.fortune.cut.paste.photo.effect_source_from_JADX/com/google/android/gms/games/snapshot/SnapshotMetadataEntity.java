package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;

public final class SnapshotMetadataEntity implements SafeParcelable, SnapshotMetadata {
    public static final SnapshotMetadataEntityCreator CREATOR;
    private final int CK;
    private final String OH;
    private final String UO;
    private final String YB;
    private final GameEntity acs;
    private final Uri afd;
    private final PlayerEntity afg;
    private final String afh;
    private final long afi;
    private final long afj;
    private final float afk;
    private final String afl;
    private final boolean afm;

    static {
        CREATOR = new SnapshotMetadataEntityCreator();
    }

    SnapshotMetadataEntity(int i, GameEntity gameEntity, PlayerEntity playerEntity, String str, Uri uri, String str2, String str3, String str4, long j, long j2, float f, String str5, boolean z) {
        this.CK = i;
        this.acs = gameEntity;
        this.afg = playerEntity;
        this.YB = str;
        this.afd = uri;
        this.afh = str2;
        this.afk = f;
        this.OH = str3;
        this.UO = str4;
        this.afi = j;
        this.afj = j2;
        this.afl = str5;
        this.afm = z;
    }

    public SnapshotMetadataEntity(SnapshotMetadata snapshotMetadata) {
        this.CK = 4;
        this.acs = new GameEntity(snapshotMetadata.getGame());
        this.afg = new PlayerEntity(snapshotMetadata.getOwner());
        this.YB = snapshotMetadata.getSnapshotId();
        this.afd = snapshotMetadata.getCoverImageUri();
        this.afh = snapshotMetadata.getCoverImageUrl();
        this.afk = snapshotMetadata.getCoverImageAspectRatio();
        this.OH = snapshotMetadata.getTitle();
        this.UO = snapshotMetadata.getDescription();
        this.afi = snapshotMetadata.getLastModifiedTimestamp();
        this.afj = snapshotMetadata.getPlayedTime();
        this.afl = snapshotMetadata.getUniqueName();
        this.afm = snapshotMetadata.hasChangePending();
    }

    static int m4091a(SnapshotMetadata snapshotMetadata) {
        return jv.hashCode(snapshotMetadata.getGame(), snapshotMetadata.getOwner(), snapshotMetadata.getSnapshotId(), snapshotMetadata.getCoverImageUri(), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio()), snapshotMetadata.getTitle(), snapshotMetadata.getDescription(), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getPlayedTime()), snapshotMetadata.getUniqueName(), Boolean.valueOf(snapshotMetadata.hasChangePending()));
    }

    static boolean m4092a(SnapshotMetadata snapshotMetadata, Object obj) {
        if (!(obj instanceof SnapshotMetadata)) {
            return false;
        }
        if (snapshotMetadata == obj) {
            return true;
        }
        SnapshotMetadata snapshotMetadata2 = (SnapshotMetadata) obj;
        return jv.equal(snapshotMetadata2.getGame(), snapshotMetadata.getGame()) && jv.equal(snapshotMetadata2.getOwner(), snapshotMetadata.getOwner()) && jv.equal(snapshotMetadata2.getSnapshotId(), snapshotMetadata.getSnapshotId()) && jv.equal(snapshotMetadata2.getCoverImageUri(), snapshotMetadata.getCoverImageUri()) && jv.equal(Float.valueOf(snapshotMetadata2.getCoverImageAspectRatio()), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())) && jv.equal(snapshotMetadata2.getTitle(), snapshotMetadata.getTitle()) && jv.equal(snapshotMetadata2.getDescription(), snapshotMetadata.getDescription()) && jv.equal(Long.valueOf(snapshotMetadata2.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())) && jv.equal(Long.valueOf(snapshotMetadata2.getPlayedTime()), Long.valueOf(snapshotMetadata.getPlayedTime())) && jv.equal(snapshotMetadata2.getUniqueName(), snapshotMetadata.getUniqueName()) && jv.equal(Boolean.valueOf(snapshotMetadata2.hasChangePending()), Boolean.valueOf(snapshotMetadata.hasChangePending()));
    }

    static String m4093b(SnapshotMetadata snapshotMetadata) {
        return jv.m5212h(snapshotMetadata).m5211a("Game", snapshotMetadata.getGame()).m5211a("Owner", snapshotMetadata.getOwner()).m5211a("SnapshotId", snapshotMetadata.getSnapshotId()).m5211a("CoverImageUri", snapshotMetadata.getCoverImageUri()).m5211a("CoverImageUrl", snapshotMetadata.getCoverImageUrl()).m5211a("CoverImageAspectRatio", Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())).m5211a("Description", snapshotMetadata.getDescription()).m5211a("LastModifiedTimestamp", Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())).m5211a("PlayedTime", Long.valueOf(snapshotMetadata.getPlayedTime())).m5211a("UniqueName", snapshotMetadata.getUniqueName()).m5211a("ChangePending", Boolean.valueOf(snapshotMetadata.hasChangePending())).toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m4092a(this, obj);
    }

    public final SnapshotMetadata freeze() {
        return this;
    }

    public final float getCoverImageAspectRatio() {
        return this.afk;
    }

    public final Uri getCoverImageUri() {
        return this.afd;
    }

    public final String getCoverImageUrl() {
        return this.afh;
    }

    public final String getDescription() {
        return this.UO;
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        le.m5324b(this.UO, charArrayBuffer);
    }

    public final Game getGame() {
        return this.acs;
    }

    public final long getLastModifiedTimestamp() {
        return this.afi;
    }

    public final Player getOwner() {
        return this.afg;
    }

    public final long getPlayedTime() {
        return this.afj;
    }

    public final String getSnapshotId() {
        return this.YB;
    }

    public final String getTitle() {
        return this.OH;
    }

    public final String getUniqueName() {
        return this.afl;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final boolean hasChangePending() {
        return this.afm;
    }

    public final int hashCode() {
        return m4091a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return m4093b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        SnapshotMetadataEntityCreator.m4094a(this, parcel, i);
    }
}
