package com.chartboost.sdk.impl;

import java.util.Collections;
import java.util.Map;

/* renamed from: com.chartboost.sdk.impl.b */
public interface C0230b {

    /* renamed from: com.chartboost.sdk.impl.b.a */
    public static class C0229a {
        public byte[] f594a;
        public String f595b;
        public long f596c;
        public long f597d;
        public long f598e;
        public Map<String, String> f599f;

        public C0229a() {
            this.f599f = Collections.emptyMap();
        }

        public boolean m920a() {
            return this.f597d < System.currentTimeMillis();
        }

        public boolean m921b() {
            return this.f598e < System.currentTimeMillis();
        }
    }

    C0229a m922a(String str);

    void m923a();

    void m924a(String str, C0229a c0229a);
}
