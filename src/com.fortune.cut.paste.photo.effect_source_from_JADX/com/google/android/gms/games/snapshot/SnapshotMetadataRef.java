package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.plus.PlusShare;

public final class SnapshotMetadataRef extends C0451d implements SnapshotMetadata {
    private final Game adq;
    private final Player afn;

    public SnapshotMetadataRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.adq = new GameRef(dataHolder, i);
        this.afn = new PlayerRef(dataHolder, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return SnapshotMetadataEntity.m4092a(this, obj);
    }

    public final SnapshotMetadata freeze() {
        return new SnapshotMetadataEntity(this);
    }

    public final float getCoverImageAspectRatio() {
        float f = getFloat("cover_icon_image_height");
        return f == 0.0f ? 0.0f : getFloat("cover_icon_image_width") / f;
    }

    public final Uri getCoverImageUri() {
        return aR("cover_icon_image_uri");
    }

    public final String getCoverImageUrl() {
        return getString("cover_icon_image_url");
    }

    public final String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        m1654a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, charArrayBuffer);
    }

    public final Game getGame() {
        return this.adq;
    }

    public final long getLastModifiedTimestamp() {
        return getLong("last_modified_timestamp");
    }

    public final Player getOwner() {
        return this.afn;
    }

    public final long getPlayedTime() {
        return getLong("duration");
    }

    public final String getSnapshotId() {
        return getString("external_snapshot_id");
    }

    public final String getTitle() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
    }

    public final String getUniqueName() {
        return getString("unique_name");
    }

    public final boolean hasChangePending() {
        return getInteger("pending_change_count") > 0;
    }

    public final int hashCode() {
        return SnapshotMetadataEntity.m4091a(this);
    }

    public final String toString() {
        return SnapshotMetadataEntity.m4093b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((SnapshotMetadataEntity) freeze()).writeToParcel(parcel, i);
    }
}
