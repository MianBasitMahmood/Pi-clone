package com.google.android.gms.appstate;

import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.appstate.b */
public final class C0452b extends C0451d implements AppState {
    C0452b(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final boolean equals(Object obj) {
        return C0450a.m1652a(this, obj);
    }

    public final AppState fJ() {
        return new C0450a(this);
    }

    public final /* synthetic */ Object freeze() {
        return fJ();
    }

    public final byte[] getConflictData() {
        return getByteArray("conflict_data");
    }

    public final String getConflictVersion() {
        return getString("conflict_version");
    }

    public final int getKey() {
        return getInteger("key");
    }

    public final byte[] getLocalData() {
        return getByteArray("local_data");
    }

    public final String getLocalVersion() {
        return getString("local_version");
    }

    public final boolean hasConflict() {
        return !aS("conflict_version");
    }

    public final int hashCode() {
        return C0450a.m1651a(this);
    }

    public final String toString() {
        return C0450a.m1653b(this);
    }
}
