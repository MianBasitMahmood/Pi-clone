package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0650a;

/* renamed from: com.google.android.gms.drive.metadata.internal.f */
public class C0661f extends C0650a<Integer> {
    public C0661f(String str, int i) {
        super(str, i);
    }

    protected void m2360a(Bundle bundle, Integer num) {
        bundle.putInt(getName(), num.intValue());
    }

    protected /* synthetic */ Object m2362c(DataHolder dataHolder, int i, int i2) {
        return m2363g(dataHolder, i, i2);
    }

    protected Integer m2363g(DataHolder dataHolder, int i, int i2) {
        return Integer.valueOf(dataHolder.m1864b(getName(), i, i2));
    }

    protected /* synthetic */ Object m2364i(Bundle bundle) {
        return m2365l(bundle);
    }

    protected Integer m2365l(Bundle bundle) {
        return Integer.valueOf(bundle.getInt(getName()));
    }
}
