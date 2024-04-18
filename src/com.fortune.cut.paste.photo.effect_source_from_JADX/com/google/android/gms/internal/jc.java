package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;

public final class jc extends kj<C1242a, Drawable> {

    /* renamed from: com.google.android.gms.internal.jc.a */
    public static final class C1242a {
        public final int Mt;
        public final int Mu;

        public C1242a(int i, int i2) {
            this.Mt = i;
            this.Mu = i2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C1242a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1242a c1242a = (C1242a) obj;
            return c1242a.Mt == this.Mt && c1242a.Mu == this.Mu;
        }

        public final int hashCode() {
            return jv.hashCode(Integer.valueOf(this.Mt), Integer.valueOf(this.Mu));
        }
    }

    public jc() {
        super(10);
    }
}
