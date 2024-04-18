package com.google.android.gms.internal;

import java.io.IOException;

public abstract class qq<M extends qq<M>> extends qw {
    protected qs ayW;

    public final <T> T m2149a(qr<M, T> qrVar) {
        if (this.ayW == null) {
            return null;
        }
        qt hh = this.ayW.hh(qz.hl(qrVar.tag));
        return hh != null ? hh.m6000b(qrVar) : null;
    }

    public void m2150a(qp qpVar) throws IOException {
        if (this.ayW != null) {
            for (int i = 0; i < this.ayW.size(); i++) {
                this.ayW.hi(i).m5998a(qpVar);
            }
        }
    }

    protected final boolean m2151a(qo qoVar, int i) throws IOException {
        int position = qoVar.getPosition();
        if (!qoVar.gQ(i)) {
            return false;
        }
        int hl = qz.hl(i);
        qy qyVar = new qy(i, qoVar.m5935s(position, qoVar.getPosition() - position));
        qt qtVar = null;
        if (this.ayW == null) {
            this.ayW = new qs();
        } else {
            qtVar = this.ayW.hh(hl);
        }
        if (qtVar == null) {
            qtVar = new qt();
            this.ayW.m5997a(hl, qtVar);
        }
        qtVar.m5999a(qyVar);
        return true;
    }

    protected final boolean m2152a(M m) {
        return (this.ayW == null || this.ayW.isEmpty()) ? m.ayW == null || m.ayW.isEmpty() : this.ayW.equals(m.ayW);
    }

    protected int m2153c() {
        int i = 0;
        if (this.ayW == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.ayW.size()) {
            i2 += this.ayW.hi(i).m6001c();
            i++;
        }
        return i2;
    }

    protected final int rQ() {
        return (this.ayW == null || this.ayW.isEmpty()) ? 0 : this.ayW.hashCode();
    }
}
