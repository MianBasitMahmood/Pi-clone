package com.google.android.gms.internal;

import java.io.IOException;

public abstract class qw {
    protected volatile int azh;

    public qw() {
        this.azh = -1;
    }

    public static final <T extends qw> T m2142a(T t, byte[] bArr) throws qv {
        return m2144b(t, bArr, 0, bArr.length);
    }

    public static final void m2143a(qw qwVar, byte[] bArr, int i, int i2) {
        try {
            qp b = qp.m5944b(bArr, i, i2);
            qwVar.m2146a(b);
            b.rP();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final <T extends qw> T m2144b(T t, byte[] bArr, int i, int i2) throws qv {
        try {
            qo a = qo.m5931a(bArr, i, i2);
            t.m2147b(a);
            a.gP(0);
            return t;
        } catch (qv e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] m2145f(qw qwVar) {
        byte[] bArr = new byte[qwVar.rZ()];
        m2143a(qwVar, bArr, 0, bArr.length);
        return bArr;
    }

    public void m2146a(qp qpVar) throws IOException {
    }

    public abstract qw m2147b(qo qoVar) throws IOException;

    protected int m2148c() {
        return 0;
    }

    public int rY() {
        if (this.azh < 0) {
            rZ();
        }
        return this.azh;
    }

    public int rZ() {
        int c = m2148c();
        this.azh = c;
        return c;
    }

    public String toString() {
        return qx.m6004g(this);
    }
}
