package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.cast.Cast;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class qp {
    private final int ayV;
    private final byte[] buffer;
    private int position;

    /* renamed from: com.google.android.gms.internal.qp.a */
    public static class C1475a extends IOException {
        C1475a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private qp(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.position = i;
        this.ayV = i + i2;
    }

    public static int m5936D(long j) {
        return m5938G(j);
    }

    public static int m5937E(long j) {
        return m5938G(m5939I(j));
    }

    public static int m5938G(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static long m5939I(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int m5940X(boolean z) {
        return 1;
    }

    public static int m5941b(int i, double d) {
        return hc(i) + m5953f(d);
    }

    public static int m5942b(int i, qw qwVar) {
        return (hc(i) * 2) + m5949d(qwVar);
    }

    public static int m5943b(int i, byte[] bArr) {
        return hc(i) + m5956s(bArr);
    }

    public static qp m5944b(byte[] bArr, int i, int i2) {
        return new qp(bArr, i, i2);
    }

    public static int m5945c(int i, float f) {
        return hc(i) + m5950e(f);
    }

    public static int m5946c(int i, qw qwVar) {
        return hc(i) + m5952e(qwVar);
    }

    public static int m5947c(int i, boolean z) {
        return hc(i) + m5940X(z);
    }

    public static int m5948d(int i, long j) {
        return hc(i) + m5936D(j);
    }

    public static int m5949d(qw qwVar) {
        return qwVar.rZ();
    }

    public static int dk(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + he(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int m5950e(float f) {
        return 4;
    }

    public static int m5951e(int i, long j) {
        return hc(i) + m5937E(j);
    }

    public static int m5952e(qw qwVar) {
        int rZ = qwVar.rZ();
        return rZ + he(rZ);
    }

    public static int m5953f(double d) {
        return 8;
    }

    public static int gZ(int i) {
        return i >= 0 ? he(i) : 10;
    }

    public static int ha(int i) {
        return he(hg(i));
    }

    public static int hc(int i) {
        return he(qz.m6008y(i, 0));
    }

    public static int he(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int hg(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static int m5954j(int i, String str) {
        return hc(i) + dk(str);
    }

    public static qp m5955q(byte[] bArr) {
        return m5944b(bArr, 0, bArr.length);
    }

    public static int m5956s(byte[] bArr) {
        return he(bArr.length) + bArr.length;
    }

    public static int m5957v(int i, int i2) {
        return hc(i) + gZ(i2);
    }

    public static int m5958w(int i, int i2) {
        return hc(i) + ha(i2);
    }

    public final void m5959B(long j) throws IOException {
        m5961F(j);
    }

    public final void m5960C(long j) throws IOException {
        m5961F(m5939I(j));
    }

    public final void m5961F(long j) throws IOException {
        while ((-128 & j) != 0) {
            m5967b((byte) ((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | Cast.MAX_NAMESPACE_LENGTH));
            j >>>= 7;
        }
        m5967b((byte) ((int) j));
    }

    public final void m5962H(long j) throws IOException {
        m5967b((byte) (((int) j) & MotionEventCompat.ACTION_MASK));
        m5967b((byte) (((int) (j >> 8)) & MotionEventCompat.ACTION_MASK));
        m5967b((byte) (((int) (j >> 16)) & MotionEventCompat.ACTION_MASK));
        m5967b((byte) (((int) (j >> 24)) & MotionEventCompat.ACTION_MASK));
        m5967b((byte) (((int) (j >> 32)) & MotionEventCompat.ACTION_MASK));
        m5967b((byte) (((int) (j >> 40)) & MotionEventCompat.ACTION_MASK));
        m5967b((byte) (((int) (j >> 48)) & MotionEventCompat.ACTION_MASK));
        m5967b((byte) (((int) (j >> 56)) & MotionEventCompat.ACTION_MASK));
    }

    public final void m5963W(boolean z) throws IOException {
        m5967b((byte) (z ? 1 : 0));
    }

    public final void m5964a(int i, double d) throws IOException {
        m5982x(i, 1);
        m5977e(d);
    }

    public final void m5965a(int i, qw qwVar) throws IOException {
        m5982x(i, 2);
        m5974c(qwVar);
    }

    public final void m5966a(int i, byte[] bArr) throws IOException {
        m5982x(i, 2);
        m5978r(bArr);
    }

    public final void m5967b(byte b) throws IOException {
        if (this.position == this.ayV) {
            throw new C1475a(this.position, this.ayV);
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    public final void m5968b(int i, float f) throws IOException {
        m5982x(i, 5);
        m5976d(f);
    }

    public final void m5969b(int i, long j) throws IOException {
        m5982x(i, 0);
        m5961F(j);
    }

    public final void m5970b(int i, String str) throws IOException {
        m5982x(i, 2);
        dj(str);
    }

    public final void m5971b(int i, boolean z) throws IOException {
        m5982x(i, 0);
        m5963W(z);
    }

    public final void m5972b(qw qwVar) throws IOException {
        qwVar.m2146a(this);
    }

    public final void m5973c(int i, long j) throws IOException {
        m5982x(i, 0);
        m5960C(j);
    }

    public final void m5974c(qw qwVar) throws IOException {
        hd(qwVar.rY());
        qwVar.m2146a(this);
    }

    public final void m5975c(byte[] bArr, int i, int i2) throws IOException {
        if (this.ayV - this.position >= i2) {
            System.arraycopy(bArr, i, this.buffer, this.position, i2);
            this.position += i2;
            return;
        }
        throw new C1475a(this.position, this.ayV);
    }

    public final void m5976d(float f) throws IOException {
        hf(Float.floatToIntBits(f));
    }

    public final void dj(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        hd(bytes.length);
        m5980t(bytes);
    }

    public final void m5977e(double d) throws IOException {
        m5962H(Double.doubleToLongBits(d));
    }

    public final void gX(int i) throws IOException {
        if (i >= 0) {
            hd(i);
        } else {
            m5961F((long) i);
        }
    }

    public final void gY(int i) throws IOException {
        hd(hg(i));
    }

    public final void hb(int i) throws IOException {
        m5967b((byte) i);
    }

    public final void hd(int i) throws IOException {
        while ((i & -128) != 0) {
            m5967b((byte) ((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | Cast.MAX_NAMESPACE_LENGTH));
            i >>>= 7;
        }
        m5967b((byte) i);
    }

    public final void hf(int i) throws IOException {
        m5967b((byte) (i & MotionEventCompat.ACTION_MASK));
        m5967b((byte) ((i >> 8) & MotionEventCompat.ACTION_MASK));
        m5967b((byte) ((i >> 16) & MotionEventCompat.ACTION_MASK));
        m5967b((byte) ((i >> 24) & MotionEventCompat.ACTION_MASK));
    }

    public final void m5978r(byte[] bArr) throws IOException {
        hd(bArr.length);
        m5980t(bArr);
    }

    public final int rO() {
        return this.ayV - this.position;
    }

    public final void rP() {
        if (rO() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void m5979t(int i, int i2) throws IOException {
        m5982x(i, 0);
        gX(i2);
    }

    public final void m5980t(byte[] bArr) throws IOException {
        m5975c(bArr, 0, bArr.length);
    }

    public final void m5981u(int i, int i2) throws IOException {
        m5982x(i, 0);
        gY(i2);
    }

    public final void m5982x(int i, int i2) throws IOException {
        hd(qz.m6008y(i, i2));
    }
}
