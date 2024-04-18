package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0650a;

/* renamed from: com.google.android.gms.drive.metadata.internal.g */
public class C0662g extends C0650a<Long> {
    public C0662g(String str, int i) {
        super(str, i);
    }

    protected void m2366a(Bundle bundle, Long l) {
        bundle.putLong(getName(), l.longValue());
    }

    protected /* synthetic */ Object m2368c(DataHolder dataHolder, int i, int i2) {
        return m2369h(dataHolder, i, i2);
    }

    protected Long m2369h(DataHolder dataHolder, int i, int i2) {
        return Long.valueOf(dataHolder.m1862a(getName(), i, i2));
    }

    protected /* synthetic */ Object m2370i(Bundle bundle) {
        return m2371m(bundle);
    }

    protected Long m2371m(Bundle bundle) {
        return Long.valueOf(bundle.getLong(getName()));
    }
}
