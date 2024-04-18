package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.C1810l.C1787a;

class bb<K, V> implements C1762k<K, V> {
    private LruCache<K, V> arR;

    /* renamed from: com.google.android.gms.tagmanager.bb.1 */
    class C17611 extends LruCache<K, V> {
        final /* synthetic */ C1787a arS;
        final /* synthetic */ bb arT;

        C17611(bb bbVar, int i, C1787a c1787a) {
            this.arT = bbVar;
            this.arS = c1787a;
            super(i);
        }

        protected int sizeOf(K k, V v) {
            return this.arS.sizeOf(k, v);
        }
    }

    bb(int i, C1787a<K, V> c1787a) {
        this.arR = new C17611(this, i, c1787a);
    }

    public void m6451e(K k, V v) {
        this.arR.put(k, v);
    }

    public V get(K k) {
        return this.arR.get(k);
    }
}
