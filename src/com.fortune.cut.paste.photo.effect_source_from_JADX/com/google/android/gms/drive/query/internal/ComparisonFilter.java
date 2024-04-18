package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ComparisonFilter<T> extends AbstractFilter {
    public static final C0674a CREATOR;
    final int CK;
    final Operator Sh;
    final MetadataBundle Si;
    final MetadataField<T> Sj;

    static {
        CREATOR = new C0674a();
    }

    ComparisonFilter(int i, Operator operator, MetadataBundle metadataBundle) {
        this.CK = i;
        this.Sh = operator;
        this.Si = metadataBundle;
        this.Sj = C0678e.m2428b(metadataBundle);
    }

    public ComparisonFilter(Operator operator, SearchableMetadataField<T> searchableMetadataField, T t) {
        this(1, operator, MetadataBundle.m2341a(searchableMetadataField, t));
    }

    public <F> F m2417a(C0672f<F> c0672f) {
        return c0672f.m2401b(this.Sh, this.Sj, getValue());
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return this.Si.m2343a(this.Sj);
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0674a.m2424a(this, parcel, i);
    }
}
