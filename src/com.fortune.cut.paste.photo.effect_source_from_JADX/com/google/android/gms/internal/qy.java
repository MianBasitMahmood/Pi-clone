package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class qy {
    final byte[] azi;
    final int tag;

    qy(int i, byte[] bArr) {
        this.tag = i;
        this.azi = bArr;
    }

    final void m6005a(qp qpVar) throws IOException {
        qpVar.hd(this.tag);
        qpVar.m5980t(this.azi);
    }

    final int m6006c() {
        return (qp.he(this.tag) + 0) + this.azi.length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof qy)) {
            return false;
        }
        qy qyVar = (qy) obj;
        return this.tag == qyVar.tag && Arrays.equals(this.azi, qyVar.azi);
    }

    public final int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.azi);
    }
}
