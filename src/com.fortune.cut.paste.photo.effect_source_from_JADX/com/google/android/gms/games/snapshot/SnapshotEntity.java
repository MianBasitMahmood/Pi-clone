package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public final class SnapshotEntity implements SafeParcelable, Snapshot {
    public static final SnapshotEntityCreator CREATOR;
    private final int CK;
    private final SnapshotMetadataEntity aeZ;
    private final SnapshotContentsEntity afa;

    static {
        CREATOR = new SnapshotEntityCreator();
    }

    SnapshotEntity(int i, SnapshotMetadata snapshotMetadata, SnapshotContentsEntity snapshotContentsEntity) {
        this.CK = i;
        this.aeZ = new SnapshotMetadataEntity(snapshotMetadata);
        this.afa = snapshotContentsEntity;
    }

    public SnapshotEntity(SnapshotMetadata snapshotMetadata, SnapshotContentsEntity snapshotContentsEntity) {
        this(2, snapshotMetadata, snapshotContentsEntity);
    }

    static boolean m4086a(Snapshot snapshot, Object obj) {
        if (!(obj instanceof Snapshot)) {
            return false;
        }
        if (snapshot == obj) {
            return true;
        }
        Snapshot snapshot2 = (Snapshot) obj;
        return jv.equal(snapshot2.getMetadata(), snapshot.getMetadata()) && jv.equal(snapshot2.getSnapshotContents(), snapshot.getSnapshotContents());
    }

    static int m4087b(Snapshot snapshot) {
        return jv.hashCode(snapshot.getMetadata(), snapshot.getSnapshotContents());
    }

    static String m4088c(Snapshot snapshot) {
        return jv.m5212h(snapshot).m5211a("Metadata", snapshot.getMetadata()).m5211a("HasContents", Boolean.valueOf(snapshot.getSnapshotContents() != null)).toString();
    }

    private boolean isClosed() {
        return this.afa.isClosed();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m4086a(this, obj);
    }

    public final Snapshot freeze() {
        return this;
    }

    public final SnapshotMetadata getMetadata() {
        return this.aeZ;
    }

    public final SnapshotContents getSnapshotContents() {
        return isClosed() ? null : this.afa;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return m4087b(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return m4088c(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        SnapshotEntityCreator.m4089a(this, parcel, i);
    }
}
