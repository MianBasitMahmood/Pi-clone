package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class jv {

    /* renamed from: com.google.android.gms.internal.jv.a */
    public static final class C1265a {
        private final List<String> Nr;
        private final Object Ns;

        private C1265a(Object obj) {
            this.Ns = jx.m5223i(obj);
            this.Nr = new ArrayList();
        }

        public final C1265a m5211a(String str, Object obj) {
            this.Nr.add(((String) jx.m5223i(str)) + "=" + String.valueOf(obj));
            return this;
        }

        public final String toString() {
            StringBuilder append = new StringBuilder(100).append(this.Ns.getClass().getSimpleName()).append('{');
            int size = this.Nr.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.Nr.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static C1265a m5212h(Object obj) {
        return new C1265a(null);
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
