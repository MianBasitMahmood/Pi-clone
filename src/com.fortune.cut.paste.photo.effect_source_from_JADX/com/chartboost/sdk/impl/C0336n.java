package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.C0230b.C0229a;

/* renamed from: com.chartboost.sdk.impl.n */
public class C0336n<T> {
    public final T f937a;
    public final C0229a f938b;
    public final C0178s f939c;
    public boolean f940d;

    /* renamed from: com.chartboost.sdk.impl.n.a */
    public interface C0096a {
        void m77a(C0178s c0178s);
    }

    /* renamed from: com.chartboost.sdk.impl.n.b */
    public interface C0098b<T> {
        void m79a(T t);
    }

    public static <T> C0336n<T> m1362a(T t, C0229a c0229a) {
        return new C0336n(t, c0229a);
    }

    public static <T> C0336n<T> m1361a(C0178s c0178s) {
        return new C0336n(c0178s);
    }

    public boolean m1363a() {
        return this.f939c == null;
    }

    private C0336n(T t, C0229a c0229a) {
        this.f940d = false;
        this.f937a = t;
        this.f938b = c0229a;
        this.f939c = null;
    }

    private C0336n(C0178s c0178s) {
        this.f940d = false;
        this.f937a = null;
        this.f938b = null;
        this.f939c = c0178s;
    }
}
