package com.chartboost.sdk.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class cp extends OutputStream {
    public abstract int m1237a();

    public abstract int m1238a(OutputStream outputStream) throws IOException;

    public abstract void m1240a(int i);

    public abstract int m1243b();

    public abstract void write(int i);

    public abstract void write(byte[] bArr);

    public byte[] m1245c() {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream(m1243b());
            m1238a(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable e) {
            throw new RuntimeException("should be impossible", e);
        }
    }

    public void m1244c(int i) {
        write(i >> 0);
        write(i >> 8);
        write(i >> 16);
        write(i >> 24);
    }

    public void m1246d(int i) {
        write(i >> 24);
        write(i >> 16);
        write(i >> 8);
        write(i);
    }

    public void m1241a(int i, int i2) {
        int a = m1237a();
        m1240a(i);
        m1244c(i2);
        m1240a(a);
    }

    public void m1242a(long j) {
        write((byte) ((int) ((j >> null) & 255)));
        write((byte) ((int) ((j >> 8) & 255)));
        write((byte) ((int) ((j >> 16) & 255)));
        write((byte) ((int) ((j >> 24) & 255)));
        write((byte) ((int) ((j >> 32) & 255)));
        write((byte) ((int) ((j >> 40) & 255)));
        write((byte) ((int) ((j >> 48) & 255)));
        write((byte) ((int) ((j >> 56) & 255)));
    }

    public void m1239a(double d) {
        m1242a(Double.doubleToRawLongBits(d));
    }

    public String toString() {
        return getClass().getName() + " size: " + m1243b() + " pos: " + m1237a();
    }
}
