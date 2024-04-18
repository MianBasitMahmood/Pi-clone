package com.google.android.gms.internal;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.p */
class C1419p implements C1361n {
    private qp lb;
    private byte[] lc;
    private final int ld;

    public C1419p(int i) {
        this.ld = i;
        reset();
    }

    public byte[] m5745D() throws IOException {
        int rO = this.lb.rO();
        if (rO < 0) {
            throw new IOException();
        } else if (rO == 0) {
            return this.lc;
        } else {
            Object obj = new byte[(this.lc.length - rO)];
            System.arraycopy(this.lc, 0, obj, 0, obj.length);
            return obj;
        }
    }

    public void m5746b(int i, long j) throws IOException {
        this.lb.m5969b(i, j);
    }

    public void m5747b(int i, String str) throws IOException {
        this.lb.m5970b(i, str);
    }

    public void reset() {
        this.lc = new byte[this.ld];
        this.lb = qp.m5955q(this.lc);
    }
}
