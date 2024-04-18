package com.chartboost.sdk.impl;

import java.util.List;
import java.util.Map;

public class dd<T> {
    private final Map<Class<?>, T> f894a;
    private final Map<Class<?>, T> f895b;

    /* renamed from: com.chartboost.sdk.impl.dd.a */
    private final class C0318a implements dg<Class<?>, T> {
        final /* synthetic */ dd f893a;

        private C0318a(dd ddVar) {
            this.f893a = ddVar;
        }

        public final T m1328a(Class<?> cls) {
            for (Class cls2 : dd.m1330a((Class) cls)) {
                T t = this.f893a.f894a.get(cls2);
                if (t != null) {
                    return t;
                }
            }
            return null;
        }
    }

    public dd() {
        this.f894a = df.m1339c();
        this.f895b = de.m1335a(new C0318a());
    }

    public static <T> List<Class<?>> m1330a(Class<T> cls) {
        return dc.m1323a(cls);
    }

    public T m1334a(Object obj) {
        return this.f895b.get(obj);
    }

    public T m1333a(Class<?> cls, T t) {
        try {
            T put = this.f894a.put(cls, t);
            return put;
        } finally {
            this.f895b.clear();
        }
    }

    public int m1332a() {
        return this.f894a.size();
    }
}
