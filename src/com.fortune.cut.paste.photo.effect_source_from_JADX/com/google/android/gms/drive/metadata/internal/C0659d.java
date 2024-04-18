package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0653d;
import java.util.Date;

/* renamed from: com.google.android.gms.drive.metadata.internal.d */
public class C0659d extends C0653d<Date> {
    public C0659d(String str, int i) {
        super(str, i);
    }

    protected void m2354a(Bundle bundle, Date date) {
        bundle.putLong(getName(), date.getTime());
    }

    protected /* synthetic */ Object m2355c(DataHolder dataHolder, int i, int i2) {
        return m2356f(dataHolder, i, i2);
    }

    protected Date m2356f(DataHolder dataHolder, int i, int i2) {
        return new Date(dataHolder.m1862a(getName(), i, i2));
    }

    protected /* synthetic */ Object m2357i(Bundle bundle) {
        return m2358k(bundle);
    }

    protected Date m2358k(Bundle bundle) {
        return new Date(bundle.getLong(getName()));
    }
}
