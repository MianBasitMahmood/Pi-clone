package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.C0650a;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.internal.j */
public abstract class C0665j<T extends Parcelable> extends C0650a<T> {
    public C0665j(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    protected void m2377a(Bundle bundle, T t) {
        bundle.putParcelable(getName(), t);
    }

    protected /* synthetic */ Object m2379i(Bundle bundle) {
        return m2380o(bundle);
    }

    protected T m2380o(Bundle bundle) {
        return bundle.getParcelable(getName());
    }
}
