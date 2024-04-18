package com.google.android.gms.drive.metadata;

import com.google.android.gms.common.data.DataHolder;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.b */
public abstract class C0651b<T> extends C0650a<Collection<T>> {
    protected C0651b(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    protected /* synthetic */ Object m2337c(DataHolder dataHolder, int i, int i2) {
        return m2338d(dataHolder, i, i2);
    }

    protected Collection<T> m2338d(DataHolder dataHolder, int i, int i2) {
        throw new UnsupportedOperationException("Cannot read collections from a dataHolder.");
    }
}
