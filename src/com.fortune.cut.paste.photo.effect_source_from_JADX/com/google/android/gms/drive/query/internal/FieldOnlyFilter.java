package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class FieldOnlyFilter extends AbstractFilter {
    public static final Creator<FieldOnlyFilter> CREATOR;
    final int CK;
    final MetadataBundle Si;
    private final MetadataField<?> Sj;

    static {
        CREATOR = new C0675b();
    }

    FieldOnlyFilter(int i, MetadataBundle metadataBundle) {
        this.CK = i;
        this.Si = metadataBundle;
        this.Sj = C0678e.m2428b(metadataBundle);
    }

    public FieldOnlyFilter(SearchableMetadataField<?> searchableMetadataField) {
        this(1, MetadataBundle.m2341a(searchableMetadataField, null));
    }

    public <T> T m2418a(C0672f<T> c0672f) {
        return c0672f.m2403d(this.Sj);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0675b.m2425a(this, parcel, i);
    }
}
