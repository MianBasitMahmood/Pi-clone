package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0650a;

/* renamed from: com.google.android.gms.drive.metadata.internal.l */
public class C0667l extends C0650a<String> {
    public C0667l(String str, int i) {
        super(str, i);
    }

    protected void m2388a(Bundle bundle, String str) {
        bundle.putString(getName(), str);
    }

    protected /* synthetic */ Object m2389c(DataHolder dataHolder, int i, int i2) {
        return m2391i(dataHolder, i, i2);
    }

    protected /* synthetic */ Object m2390i(Bundle bundle) {
        return m2392p(bundle);
    }

    protected String m2391i(DataHolder dataHolder, int i, int i2) {
        return dataHolder.m1865c(getName(), i, i2);
    }

    protected String m2392p(Bundle bundle) {
        return bundle.getString(getName());
    }
}
