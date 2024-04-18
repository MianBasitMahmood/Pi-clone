package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

/* renamed from: com.google.android.gms.tagmanager.l */
class C1810l<K, V> {
    final C1787a<K, V> aqk;

    /* renamed from: com.google.android.gms.tagmanager.l.a */
    public interface C1787a<K, V> {
        int sizeOf(K k, V v);
    }

    /* renamed from: com.google.android.gms.tagmanager.l.1 */
    class C18091 implements C1787a<K, V> {
        final /* synthetic */ C1810l aql;

        C18091(C1810l c1810l) {
            this.aql = c1810l;
        }

        public int sizeOf(K k, V v) {
            return 1;
        }
    }

    public C1810l() {
        this.aqk = new C18091(this);
    }

    public C1762k<K, V> m6647a(int i, C1787a<K, V> c1787a) {
        if (i > 0) {
            return pg() < 12 ? new da(i, c1787a) : new bb(i, c1787a);
        } else {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    int pg() {
        return VERSION.SDK_INT;
    }
}
