package com.google.android.gms.appstate;

import com.google.android.gms.internal.jv;

/* renamed from: com.google.android.gms.appstate.a */
public final class C0450a implements AppState {
    private final int DK;
    private final String DL;
    private final byte[] DM;
    private final boolean DN;
    private final String DO;
    private final byte[] DP;

    public C0450a(AppState appState) {
        this.DK = appState.getKey();
        this.DL = appState.getLocalVersion();
        this.DM = appState.getLocalData();
        this.DN = appState.hasConflict();
        this.DO = appState.getConflictVersion();
        this.DP = appState.getConflictData();
    }

    static int m1651a(AppState appState) {
        return jv.hashCode(Integer.valueOf(appState.getKey()), appState.getLocalVersion(), appState.getLocalData(), Boolean.valueOf(appState.hasConflict()), appState.getConflictVersion(), appState.getConflictData());
    }

    static boolean m1652a(AppState appState, Object obj) {
        if (!(obj instanceof AppState)) {
            return false;
        }
        if (appState == obj) {
            return true;
        }
        AppState appState2 = (AppState) obj;
        return jv.equal(Integer.valueOf(appState2.getKey()), Integer.valueOf(appState.getKey())) && jv.equal(appState2.getLocalVersion(), appState.getLocalVersion()) && jv.equal(appState2.getLocalData(), appState.getLocalData()) && jv.equal(Boolean.valueOf(appState2.hasConflict()), Boolean.valueOf(appState.hasConflict())) && jv.equal(appState2.getConflictVersion(), appState.getConflictVersion()) && jv.equal(appState2.getConflictData(), appState.getConflictData());
    }

    static String m1653b(AppState appState) {
        return jv.m5212h(appState).m5211a("Key", Integer.valueOf(appState.getKey())).m5211a("LocalVersion", appState.getLocalVersion()).m5211a("LocalData", appState.getLocalData()).m5211a("HasConflict", Boolean.valueOf(appState.hasConflict())).m5211a("ConflictVersion", appState.getConflictVersion()).m5211a("ConflictData", appState.getConflictData()).toString();
    }

    public final boolean equals(Object obj) {
        return C0450a.m1652a(this, obj);
    }

    public final AppState fJ() {
        return this;
    }

    public final /* synthetic */ Object freeze() {
        return fJ();
    }

    public final byte[] getConflictData() {
        return this.DP;
    }

    public final String getConflictVersion() {
        return this.DO;
    }

    public final int getKey() {
        return this.DK;
    }

    public final byte[] getLocalData() {
        return this.DM;
    }

    public final String getLocalVersion() {
        return this.DL;
    }

    public final boolean hasConflict() {
        return this.DN;
    }

    public final int hashCode() {
        return C0450a.m1651a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return C0450a.m1653b(this);
    }
}
