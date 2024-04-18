package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class HasFilter<T> extends AbstractFilter {
    public static final C0679g CREATOR;
    final int CK;
    final MetadataBundle Si;
    final MetadataField<T> Sj;

    static {
        CREATOR = new C0679g();
    }

    HasFilter(int i, MetadataBundle metadataBundle) {
        this.CK = i;
        this.Si = metadataBundle;
        this.Sj = C0678e.m2428b(metadataBundle);
    }

    public HasFilter(SearchableMetadataField<T> searchableMetadataField, T t) {
        this(1, MetadataBundle.m2341a(searchableMetadataField, t));
    }

    public <F> F m2419a(C0672f<F> c0672f) {
        return c0672f.m2404d(this.Sj, getValue());
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return this.Si.m2343a(this.Sj);
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0679g.m2429a(this, parcel, i);
    }
}
