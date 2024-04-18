package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.m */
public final class C0588m extends Metadata {
    private final MetadataBundle PD;

    public C0588m(MetadataBundle metadataBundle) {
        this.PD = metadataBundle;
    }

    protected final <T> T m2209a(MetadataField<T> metadataField) {
        return this.PD.m2343a((MetadataField) metadataField);
    }

    public final /* synthetic */ Object freeze() {
        return iy();
    }

    public final boolean isDataValid() {
        return this.PD != null;
    }

    public final Metadata iy() {
        return new C0588m(MetadataBundle.m2342a(this.PD));
    }

    public final String toString() {
        return "Metadata [mImpl=" + this.PD + "]";
    }
}
