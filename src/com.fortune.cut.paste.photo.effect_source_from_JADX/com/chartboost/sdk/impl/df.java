package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.da.C0307h.C0313a;
import java.util.HashMap;
import java.util.Map;

abstract class df<K, V> extends da<K, V, Map<K, V>> {

    /* renamed from: com.chartboost.sdk.impl.df.a */
    public static class C0319a<K, V> {
        private C0313a f898a;
        private final Map<K, V> f899b;

        C0319a() {
            this.f898a = C0313a.STABLE;
            this.f899b = new HashMap();
        }

        public df<K, V> m1337a() {
            return new C0320b(this.f899b, this.f898a);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.df.b */
    static class C0320b<K, V> extends df<K, V> {
        C0320b(Map<? extends K, ? extends V> map, C0313a c0313a) {
            super(map, c0313a);
        }

        public <N extends Map<? extends K, ? extends V>> Map<K, V> m1340a(N n) {
            return new HashMap(n);
        }
    }

    public static <K, V> C0319a<K, V> m1338b() {
        return new C0319a();
    }

    public static <K, V> df<K, V> m1339c() {
        return m1338b().m1337a();
    }

    protected df(Map<? extends K, ? extends V> map, C0313a c0313a) {
        super(map, c0313a);
    }
}
