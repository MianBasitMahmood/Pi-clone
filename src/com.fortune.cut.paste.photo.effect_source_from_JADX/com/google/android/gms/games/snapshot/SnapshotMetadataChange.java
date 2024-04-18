package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.C0522a;

public abstract class SnapshotMetadataChange {
    public static final SnapshotMetadataChange EMPTY_CHANGE;

    public static final class Builder {
        private String UO;
        private Long afb;
        private C0522a afc;
        private Uri afd;

        public final SnapshotMetadataChange build() {
            return new SnapshotMetadataChangeEntity(this.UO, this.afb, this.afc, this.afd);
        }

        public final Builder fromMetadata(SnapshotMetadata snapshotMetadata) {
            this.UO = snapshotMetadata.getDescription();
            this.afb = Long.valueOf(snapshotMetadata.getPlayedTime());
            if (this.afb.longValue() == -1) {
                this.afb = null;
            }
            this.afd = snapshotMetadata.getCoverImageUri();
            if (this.afd != null) {
                this.afc = null;
            }
            return this;
        }

        public final Builder setCoverImage(Bitmap bitmap) {
            this.afc = new C0522a(bitmap);
            this.afd = null;
            return this;
        }

        public final Builder setDescription(String str) {
            this.UO = str;
            return this;
        }

        public final Builder setPlayedTimeMillis(long j) {
            this.afb = Long.valueOf(j);
            return this;
        }
    }

    static {
        EMPTY_CHANGE = new SnapshotMetadataChangeEntity();
    }

    protected SnapshotMetadataChange() {
    }

    public abstract Bitmap getCoverImage();

    public abstract String getDescription();

    public abstract Long getPlayedTimeMillis();

    public abstract C0522a mT();
}
