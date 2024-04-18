package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0522a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;

public final class SnapshotMetadataChangeEntity extends SnapshotMetadataChange implements SafeParcelable {
    public static final SnapshotMetadataChangeCreator CREATOR;
    private final int CK;
    private final String UO;
    private final Uri afd;
    private final Long afe;
    private C0522a aff;

    static {
        CREATOR = new SnapshotMetadataChangeCreator();
    }

    SnapshotMetadataChangeEntity() {
        this(4, null, null, null, null);
    }

    SnapshotMetadataChangeEntity(int i, String str, Long l, C0522a c0522a, Uri uri) {
        boolean z = true;
        this.CK = i;
        this.UO = str;
        this.afe = l;
        this.aff = c0522a;
        this.afd = uri;
        if (this.aff != null) {
            if (this.afd != null) {
                z = false;
            }
            jx.m5217a(z, "Cannot set both a URI and an image");
        } else if (this.afd != null) {
            if (this.aff != null) {
                z = false;
            }
            jx.m5217a(z, "Cannot set both a URI and an image");
        }
    }

    SnapshotMetadataChangeEntity(String str, Long l, C0522a c0522a, Uri uri) {
        this(4, str, l, c0522a, uri);
    }

    public final int describeContents() {
        return 0;
    }

    public final Bitmap getCoverImage() {
        return this.aff == null ? null : this.aff.gT();
    }

    public final Uri getCoverImageUri() {
        return this.afd;
    }

    public final String getDescription() {
        return this.UO;
    }

    public final Long getPlayedTimeMillis() {
        return this.afe;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final C0522a mT() {
        return this.aff;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        SnapshotMetadataChangeCreator.m4090a(this, parcel, i);
    }
}
