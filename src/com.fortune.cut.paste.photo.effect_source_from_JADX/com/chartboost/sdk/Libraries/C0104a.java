package com.chartboost.sdk.Libraries;

import com.chartboost.sdk.Libraries.C0131g.C0101a;
import com.chartboost.sdk.Libraries.C0131g.C0102e;

/* renamed from: com.chartboost.sdk.Libraries.a */
public interface C0104a {
    public static final C0101a f83a;

    /* renamed from: com.chartboost.sdk.Libraries.a.1 */
    static class C01031 extends C0102e {
        C01031() {
        }

        public final boolean m125a(Object obj) {
            int intValue = ((Number) obj).intValue();
            return intValue >= 200 && intValue < 300;
        }

        public final String m124a() {
            return "Must be a valid status code (>=200 && <300)";
        }
    }

    static {
        f83a = C0131g.m220a(C0131g.m224b(), new C01031());
    }
}
