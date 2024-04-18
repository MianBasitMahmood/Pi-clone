package com.google.android.gms.internal;

import com.google.android.gms.internal.ra.C1481c;
import java.util.ArrayList;

public class os {
    private final ArrayList<C1414a> amZ;
    private int ana;

    /* renamed from: com.google.android.gms.internal.os.a */
    public static class C1414a {
        public final ov anb;
        public final or anc;
        public final C1481c and;

        private C1414a(ov ovVar, or orVar) {
            this.anb = (ov) jx.m5223i(ovVar);
            this.anc = (or) jx.m5223i(orVar);
            this.and = null;
        }
    }

    public os() {
        this(100);
    }

    public os(int i) {
        this.amZ = new ArrayList();
        this.ana = i;
    }

    private void oq() {
        while (getSize() > getCapacity()) {
            this.amZ.remove(0);
        }
    }

    public void m5729a(ov ovVar, or orVar) {
        this.amZ.add(new C1414a(orVar, null));
        oq();
    }

    public void clear() {
        this.amZ.clear();
    }

    public int getCapacity() {
        return this.ana;
    }

    public int getSize() {
        return this.amZ.size();
    }

    public boolean isEmpty() {
        return this.amZ.isEmpty();
    }

    public ArrayList<C1414a> op() {
        return this.amZ;
    }
}
