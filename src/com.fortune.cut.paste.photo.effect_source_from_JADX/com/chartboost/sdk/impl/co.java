package com.chartboost.sdk.impl;

import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.cast.Cast;
import java.io.IOException;
import java.io.OutputStream;

public class co extends cp {
    private int f843a;
    private int f844b;
    private byte[] f845c;

    public co() {
        this.f845c = new byte[AdRequest.MAX_CONTENT_URL_LENGTH];
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        m1251b(i2);
        System.arraycopy(bArr, i, this.f845c, this.f843a, i2);
        this.f843a += i2;
        this.f844b = Math.max(this.f843a, this.f844b);
    }

    public void write(int i) {
        m1251b(1);
        byte[] bArr = this.f845c;
        int i2 = this.f843a;
        this.f843a = i2 + 1;
        bArr[i2] = (byte) (i & MotionEventCompat.ACTION_MASK);
        this.f844b = Math.max(this.f843a, this.f844b);
    }

    public int m1247a() {
        return this.f843a;
    }

    public void m1249a(int i) {
        this.f843a = i;
    }

    public int m1250b() {
        return this.f844b;
    }

    public int m1248a(OutputStream outputStream) throws IOException {
        outputStream.write(this.f845c, 0, this.f844b);
        return this.f844b;
    }

    void m1251b(int i) {
        int i2 = this.f843a + i;
        if (i2 >= this.f845c.length) {
            int length = this.f845c.length * 2;
            if (length <= i2) {
                length = i2 + Cast.MAX_NAMESPACE_LENGTH;
            }
            Object obj = new byte[length];
            System.arraycopy(this.f845c, 0, obj, 0, this.f844b);
            this.f845c = obj;
        }
    }
}
