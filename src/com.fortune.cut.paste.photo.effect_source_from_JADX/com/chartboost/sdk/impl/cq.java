package com.chartboost.sdk.impl;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class cq extends cp {
    private static dh<byte[]> f850g;
    final byte[] f851a;
    final char[] f852b;
    final List<byte[]> f853c;
    final cr f854d;
    private final C0301a f855e;
    private final C0301a f856f;

    /* renamed from: com.chartboost.sdk.impl.cq.1 */
    static class C03001 extends dh<byte[]> {
        C03001(int i) {
            super(i);
        }

        protected final /* synthetic */ Object m1257b() {
            return m1256a();
        }

        protected final byte[] m1256a() {
            return new byte[AccessibilityNodeInfoCompat.ACTION_COPY];
        }
    }

    /* renamed from: com.chartboost.sdk.impl.cq.a */
    static class C0301a {
        int f848a;
        int f849b;

        C0301a() {
            m1258a();
        }

        void m1258a() {
            this.f848a = -1;
            this.f849b = 0;
        }

        void m1260a(C0301a c0301a) {
            this.f848a = c0301a.f848a;
            this.f849b = c0301a.f849b;
        }

        void m1259a(int i) {
            this.f848a = (i / AccessibilityNodeInfoCompat.ACTION_COPY) - 1;
            this.f849b = i % AccessibilityNodeInfoCompat.ACTION_COPY;
        }

        int m1261b() {
            return ((this.f848a + 1) * AccessibilityNodeInfoCompat.ACTION_COPY) + this.f849b;
        }

        int m1263c() {
            int i = this.f849b;
            this.f849b = i + 1;
            return i;
        }

        void m1262b(int i) {
            this.f849b += i;
            if (this.f849b > AccessibilityNodeInfoCompat.ACTION_COPY) {
                throw new IllegalArgumentException("something is wrong");
            }
        }

        void m1265d() {
            if (this.f849b != AccessibilityNodeInfoCompat.ACTION_COPY) {
                throw new IllegalArgumentException("broken");
            }
            this.f848a++;
            this.f849b = 0;
        }

        int m1264c(int i) {
            if (i < this.f848a) {
                return AccessibilityNodeInfoCompat.ACTION_COPY;
            }
            return this.f849b;
        }

        public String toString() {
            return this.f848a + "," + this.f849b;
        }
    }

    public cq() {
        this.f851a = new byte[AccessibilityNodeInfoCompat.ACTION_COPY];
        this.f852b = new char[AccessibilityNodeInfoCompat.ACTION_COPY];
        this.f853c = new ArrayList();
        this.f854d = new cr();
        this.f855e = new C0301a();
        this.f856f = new C0301a();
        m1271d();
    }

    public void m1271d() {
        this.f855e.m1258a();
        this.f856f.m1258a();
        for (int i = 0; i < this.f853c.size(); i++) {
            f850g.m1254b(this.f853c.get(i));
        }
        this.f853c.clear();
    }

    public int m1266a() {
        return this.f855e.m1261b();
    }

    public void m1268a(int i) {
        this.f855e.m1259a(i);
    }

    public int m1269b() {
        return this.f856f.m1261b();
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            Object f = m1273f();
            int min = Math.min(f.length - this.f855e.f849b, i2);
            System.arraycopy(bArr, i, f, this.f855e.f849b, min);
            this.f855e.m1262b(min);
            i2 -= min;
            i += min;
            m1272e();
        }
    }

    public void write(int i) {
        m1273f()[this.f855e.m1263c()] = (byte) (i & MotionEventCompat.ACTION_MASK);
        m1272e();
    }

    void m1272e() {
        if (this.f855e.m1261b() >= this.f856f.m1261b()) {
            this.f856f.m1260a(this.f855e);
            if (this.f856f.f849b >= AccessibilityNodeInfoCompat.ACTION_COPY) {
                this.f853c.add(f850g.m1255c());
                this.f856f.m1265d();
                this.f855e.m1260a(this.f856f);
            }
        } else if (this.f855e.f849b == AccessibilityNodeInfoCompat.ACTION_COPY) {
            this.f855e.m1265d();
        }
    }

    byte[] m1273f() {
        return m1270b(this.f855e.f848a);
    }

    byte[] m1270b(int i) {
        if (i < 0) {
            return this.f851a;
        }
        return (byte[]) this.f853c.get(i);
    }

    public int m1267a(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new NullPointerException("out is null");
        }
        int i = 0;
        for (int i2 = -1; i2 < this.f853c.size(); i2++) {
            byte[] b = m1270b(i2);
            int c = this.f856f.m1264c(i2);
            outputStream.write(b, 0, c);
            i += c;
        }
        return i;
    }

    static {
        f850g = new C03001(640);
    }
}
