package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.jx;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.drive.metadata.a */
public abstract class C0650a<T> implements MetadataField<T> {
    private final String QY;
    private final Set<String> QZ;
    private final Set<String> Ra;
    private final int Rb;

    protected C0650a(String str, int i) {
        this.QY = (String) jx.m5219b((Object) str, (Object) "fieldName");
        this.QZ = Collections.singleton(str);
        this.Ra = Collections.emptySet();
        this.Rb = i;
    }

    protected C0650a(String str, Collection<String> collection, Collection<String> collection2, int i) {
        this.QY = (String) jx.m5219b((Object) str, (Object) "fieldName");
        this.QZ = Collections.unmodifiableSet(new HashSet(collection));
        this.Ra = Collections.unmodifiableSet(new HashSet(collection2));
        this.Rb = i;
    }

    public final T m2329a(DataHolder dataHolder, int i, int i2) {
        return m2333b(dataHolder, i, i2) ? m2334c(dataHolder, i, i2) : null;
    }

    protected abstract void m2330a(Bundle bundle, T t);

    public final void m2331a(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2) {
        jx.m5219b((Object) dataHolder, (Object) "dataHolder");
        jx.m5219b((Object) metadataBundle, (Object) "bundle");
        metadataBundle.m2344b(this, m2329a(dataHolder, i, i2));
    }

    public final void m2332a(T t, Bundle bundle) {
        jx.m5219b((Object) bundle, (Object) "bundle");
        if (t == null) {
            bundle.putString(getName(), null);
        } else {
            m2330a(bundle, (Object) t);
        }
    }

    protected boolean m2333b(DataHolder dataHolder, int i, int i2) {
        for (String h : this.QZ) {
            if (dataHolder.m1871h(h, i, i2)) {
                return false;
            }
        }
        return true;
    }

    protected abstract T m2334c(DataHolder dataHolder, int i, int i2);

    public final String getName() {
        return this.QY;
    }

    public final T m2335h(Bundle bundle) {
        jx.m5219b((Object) bundle, (Object) "bundle");
        return bundle.get(getName()) != null ? m2336i(bundle) : null;
    }

    protected abstract T m2336i(Bundle bundle);

    public String toString() {
        return this.QY;
    }
}
