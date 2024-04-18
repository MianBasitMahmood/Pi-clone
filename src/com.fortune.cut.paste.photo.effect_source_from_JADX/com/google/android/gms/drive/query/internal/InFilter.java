package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.C0651b;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;

public class InFilter<T> extends AbstractFilter {
    public static final C0680h CREATOR;
    final int CK;
    final MetadataBundle Si;
    private final C0651b<T> St;

    static {
        CREATOR = new C0680h();
    }

    InFilter(int i, MetadataBundle metadataBundle) {
        this.CK = i;
        this.Si = metadataBundle;
        this.St = (C0651b) C0678e.m2428b(metadataBundle);
    }

    public InFilter(SearchableCollectionMetadataField<T> searchableCollectionMetadataField, T t) {
        this(1, MetadataBundle.m2341a(searchableCollectionMetadataField, Collections.singleton(t)));
    }

    public <F> F m2420a(C0672f<F> c0672f) {
        return c0672f.m2400b(this.St, getValue());
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return ((Collection) this.Si.m2343a(this.St)).iterator().next();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0680h.m2430a(this, parcel, i);
    }
}
