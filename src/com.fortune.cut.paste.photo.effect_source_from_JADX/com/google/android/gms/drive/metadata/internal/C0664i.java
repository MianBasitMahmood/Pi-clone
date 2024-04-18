package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.C0651b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.google.android.gms.drive.metadata.internal.i */
public class C0664i<T extends Parcelable> extends C0651b<T> {
    public C0664i(String str, int i) {
        super(str, Collections.emptySet(), Collections.singleton(str), i);
    }

    protected void m2374a(Bundle bundle, Collection<T> collection) {
        bundle.putParcelableArrayList(getName(), new ArrayList(collection));
    }

    protected /* synthetic */ Object m2375i(Bundle bundle) {
        return m2376n(bundle);
    }

    protected Collection<T> m2376n(Bundle bundle) {
        return bundle.getParcelableArrayList(getName());
    }
}
