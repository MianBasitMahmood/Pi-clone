package com.chartboost.sdk.impl;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ce extends OutputStream {
    private static final byte[] f817a;
    private final List<byte[]> f818b;
    private int f819c;
    private int f820d;
    private byte[] f821e;
    private int f822f;

    static {
        f817a = new byte[0];
    }

    public ce() {
        this(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
    }

    public ce(int i) {
        this.f818b = new ArrayList();
        if (i < 0) {
            throw new IllegalArgumentException("Negative initial size: " + i);
        }
        synchronized (this) {
            m1199a(i);
        }
    }

    private void m1199a(int i) {
        if (this.f819c < this.f818b.size() - 1) {
            this.f820d += this.f821e.length;
            this.f819c++;
            this.f821e = (byte[]) this.f818b.get(this.f819c);
            return;
        }
        if (this.f821e == null) {
            this.f820d = 0;
        } else {
            i = Math.max(this.f821e.length << 1, i - this.f820d);
            this.f820d += this.f821e.length;
        }
        this.f819c++;
        this.f821e = new byte[i];
        this.f818b.add(this.f821e);
    }

    public void write(byte[] bArr, int i, int i2) {
        if (i < 0 || i > bArr.length || i2 < 0 || i + i2 > bArr.length || i + i2 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            synchronized (this) {
                int i3 = this.f822f + i2;
                int i4 = this.f822f - this.f820d;
                int i5 = i2;
                while (i5 > 0) {
                    int min = Math.min(i5, this.f821e.length - i4);
                    System.arraycopy(bArr, (i + i2) - i5, this.f821e, i4, min);
                    i5 -= min;
                    if (i5 > 0) {
                        m1199a(i3);
                        i4 = 0;
                    }
                }
                this.f822f = i3;
            }
        }
    }

    public synchronized void write(int i) {
        int i2 = this.f822f - this.f820d;
        if (i2 == this.f821e.length) {
            m1199a(this.f822f + 1);
            i2 = 0;
        }
        this.f821e[i2] = (byte) i;
        this.f822f++;
    }

    public void close() throws IOException {
    }

    public synchronized byte[] m1200a() {
        byte[] bArr;
        int i = this.f822f;
        if (i == 0) {
            bArr = f817a;
        } else {
            Object obj = new byte[i];
            int i2 = i;
            i = 0;
            for (byte[] bArr2 : this.f818b) {
                int min = Math.min(bArr2.length, i2);
                System.arraycopy(bArr2, 0, obj, i, min);
                int i3 = i + min;
                i = i2 - min;
                if (i == 0) {
                    break;
                }
                i2 = i;
                i = i3;
            }
            Object obj2 = obj;
        }
        return bArr2;
    }

    public String toString() {
        return new String(m1200a());
    }
}
