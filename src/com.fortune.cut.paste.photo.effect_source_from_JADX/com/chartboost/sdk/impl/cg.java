package com.chartboost.sdk.impl;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.drive.FileUploadPreferences;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class cg {
    private static boolean f778a;
    private static boolean f779b;
    static final Logger f780f;
    static dd<List<cn>> f781g;
    static dd<List<cn>> f782h;
    protected static Charset f783i;
    static ThreadLocal<ci> f784j;
    static ThreadLocal<ch> f785k;

    /* renamed from: com.chartboost.sdk.impl.cg.1 */
    static class C02971 extends ThreadLocal<ci> {
        C02971() {
        }

        protected final /* synthetic */ Object initialValue() {
            return m1201a();
        }

        protected final ci m1201a() {
            return new cl();
        }
    }

    /* renamed from: com.chartboost.sdk.impl.cg.2 */
    static class C02982 extends ThreadLocal<ch> {
        C02982() {
        }

        protected final /* synthetic */ Object initialValue() {
            return m1202a();
        }

        protected final ch m1202a() {
            return new ck();
        }
    }

    /* renamed from: com.chartboost.sdk.impl.cg.a */
    private enum C0299a {
        CANON_EQ(Cast.MAX_NAMESPACE_LENGTH, 'c', "Pattern.CANON_EQ"),
        UNIX_LINES(1, 'd', "Pattern.UNIX_LINES"),
        GLOBAL(FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED, 'g', null),
        CASE_INSENSITIVE(2, 'i', null),
        MULTILINE(8, 'm', null),
        DOTALL(32, 's', "Pattern.DOTALL"),
        LITERAL(16, 't', "Pattern.LITERAL"),
        UNICODE_CASE(64, 'u', "Pattern.UNICODE_CASE"),
        COMMENTS(4, 'x', null);
        
        private static final Map<Character, C0299a> f833m;
        public final int f835j;
        public final char f836k;
        public final String f837l;

        static {
            f833m = new HashMap();
            C0299a[] values = C0299a.values();
            int length = values.length;
            int i;
            while (i < length) {
                C0299a c0299a = values[i];
                f833m.put(Character.valueOf(c0299a.f836k), c0299a);
                i++;
            }
        }

        private C0299a(int i, char c, String str) {
            this.f835j = i;
            this.f836k = c;
            this.f837l = str;
        }
    }

    static {
        f780f = Logger.getLogger("org.bson.BSON");
        f778a = false;
        f779b = false;
        f781g = new dd();
        f782h = new dd();
        f783i = Charset.forName("UTF-8");
        f784j = new C02971();
        f785k = new C02982();
    }

    public static String m1153a(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = i;
        for (C0299a c0299a : C0299a.values()) {
            if ((c0299a.f835j & i2) > 0) {
                stringBuilder.append(c0299a.f836k);
                i2 -= c0299a.f835j;
            }
        }
        if (i2 <= 0) {
            return stringBuilder.toString();
        }
        throw new IllegalArgumentException("some flags could not be recognized.");
    }

    public static Object m1152a(Object obj) {
        if (!(!m1154a() || f781g.m1332a() == 0 || obj == null)) {
            List<cn> list = (List) f781g.m1334a(obj.getClass());
            if (list != null) {
                for (cn a : list) {
                    obj = a.m1236a(obj);
                }
            }
        }
        return obj;
    }

    private static boolean m1154a() {
        return f778a || f779b;
    }
}
