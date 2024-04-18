package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

/* renamed from: com.google.android.gms.common.data.d */
public abstract class C0451d {
    protected final DataHolder JG;
    protected int KZ;
    private int La;

    public C0451d(DataHolder dataHolder, int i) {
        this.JG = (DataHolder) jx.m5223i(dataHolder);
        as(i);
    }

    protected void m1654a(String str, CharArrayBuffer charArrayBuffer) {
        this.JG.m1863a(str, this.KZ, this.La, charArrayBuffer);
    }

    public boolean aQ(String str) {
        return this.JG.aQ(str);
    }

    protected Uri aR(String str) {
        return this.JG.m1870g(str, this.KZ, this.La);
    }

    protected boolean aS(String str) {
        return this.JG.m1871h(str, this.KZ, this.La);
    }

    protected void as(int i) {
        boolean z = i >= 0 && i < this.JG.getCount();
        jx.m5215K(z);
        this.KZ = i;
        this.La = this.JG.au(this.KZ);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0451d)) {
            return false;
        }
        C0451d c0451d = (C0451d) obj;
        return jv.equal(Integer.valueOf(c0451d.KZ), Integer.valueOf(this.KZ)) && jv.equal(Integer.valueOf(c0451d.La), Integer.valueOf(this.La)) && c0451d.JG == this.JG;
    }

    protected int gW() {
        return this.KZ;
    }

    protected boolean getBoolean(String str) {
        return this.JG.m1866d(str, this.KZ, this.La);
    }

    protected byte[] getByteArray(String str) {
        return this.JG.m1869f(str, this.KZ, this.La);
    }

    protected float getFloat(String str) {
        return this.JG.m1867e(str, this.KZ, this.La);
    }

    protected int getInteger(String str) {
        return this.JG.m1864b(str, this.KZ, this.La);
    }

    protected long getLong(String str) {
        return this.JG.m1862a(str, this.KZ, this.La);
    }

    protected String getString(String str) {
        return this.JG.m1865c(str, this.KZ, this.La);
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.KZ), Integer.valueOf(this.La), this.JG);
    }

    public boolean isDataValid() {
        return !this.JG.isClosed();
    }
}
