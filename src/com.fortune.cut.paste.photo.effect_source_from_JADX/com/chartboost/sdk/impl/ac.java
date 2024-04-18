package com.chartboost.sdk.impl;

import com.google.android.gms.drive.FileUploadPreferences;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ac extends ByteArrayOutputStream {
    private final C0344v f338a;

    public ac(C0344v c0344v, int i) {
        this.f338a = c0344v;
        this.buf = this.f338a.m1381a(Math.max(i, FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED));
    }

    public void close() throws IOException {
        this.f338a.m1380a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f338a.m1380a(this.buf);
    }

    private void m578a(int i) {
        if (this.count + i > this.buf.length) {
            Object a = this.f338a.m1381a((this.count + i) * 2);
            System.arraycopy(this.buf, 0, a, 0, this.count);
            this.f338a.m1380a(this.buf);
            this.buf = a;
        }
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        m578a(i2);
        super.write(bArr, i, i2);
    }

    public synchronized void write(int i) {
        m578a(1);
        super.write(i);
    }
}
