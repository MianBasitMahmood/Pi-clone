package com.google.android.gms.common.api;

import com.google.android.gms.common.api.C0509d.C0493b;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.common.api.a */
public abstract class C0494a<L> implements C0493b<L> {
    private final DataHolder JG;

    protected C0494a(DataHolder dataHolder) {
        this.JG = dataHolder;
    }

    protected abstract void m1810a(L l, DataHolder dataHolder);

    public final void m1811c(L l) {
        m1810a(l, this.JG);
    }

    public void gG() {
        if (this.JG != null) {
            this.JG.close();
        }
    }
}
