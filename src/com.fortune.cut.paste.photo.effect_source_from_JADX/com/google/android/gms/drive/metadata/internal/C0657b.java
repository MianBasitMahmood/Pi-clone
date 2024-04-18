package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0650a;

/* renamed from: com.google.android.gms.drive.metadata.internal.b */
public class C0657b extends C0650a<Boolean> {
    public C0657b(String str, int i) {
        super(str, i);
    }

    protected void m2346a(Bundle bundle, Boolean bool) {
        bundle.putBoolean(getName(), bool.booleanValue());
    }

    protected /* synthetic */ Object m2348c(DataHolder dataHolder, int i, int i2) {
        return m2349e(dataHolder, i, i2);
    }

    protected Boolean m2349e(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.m1866d(getName(), i, i2));
    }

    protected /* synthetic */ Object m2350i(Bundle bundle) {
        return m2351j(bundle);
    }

    protected Boolean m2351j(Bundle bundle) {
        return Boolean.valueOf(bundle.getBoolean(getName()));
    }
}
