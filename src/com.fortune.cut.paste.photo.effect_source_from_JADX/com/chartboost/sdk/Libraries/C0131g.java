package com.chartboost.sdk.Libraries;

import com.chartboost.sdk.Libraries.C0113e.C0111a;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Libraries.g */
public final class C0131g {
    private static C0129o f128a;
    private static C0128n f129b;
    private static C0124j f130c;
    private static C0119d f131d;
    private static C0126l f132e;

    /* renamed from: com.chartboost.sdk.Libraries.g.a */
    public static abstract class C0101a {
        private String f82a;

        public abstract String m121a();

        public abstract boolean m122a(Object obj);

        public C0101a() {
            this.f82a = null;
        }

        public boolean m123a(Object obj, StringBuilder stringBuilder) {
            if (obj instanceof C0111a) {
                obj = ((C0111a) obj).m176n();
            }
            boolean a = m122a(obj);
            if (!a) {
                stringBuilder.append(this.f82a != null ? this.f82a : m121a());
            }
            return a;
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.e */
    public static abstract class C0102e extends C0101a {
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.b */
    private static class C0117b extends C0101a {
        private C0117b() {
        }

        public boolean m192a(Object obj) {
            return (obj instanceof List) || (obj instanceof JSONArray);
        }

        public String m191a() {
            return "object must be an array.";
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.c */
    private static class C0118c extends C0117b {
        private C0101a f115a;

        public C0118c(C0101a c0101a) {
            super();
            this.f115a = c0101a;
        }

        public boolean m194a(Object obj) {
            int i;
            if (obj instanceof List) {
                List list = (List) obj;
                for (i = 0; i < list.size(); i++) {
                    if (!this.f115a.m122a(list.get(i))) {
                        return false;
                    }
                }
                return true;
            } else if (!(obj instanceof JSONArray)) {
                return false;
            } else {
                JSONArray jSONArray = (JSONArray) obj;
                for (i = 0; i < jSONArray.length(); i++) {
                    if (!this.f115a.m122a(jSONArray.opt(i))) {
                        return false;
                    }
                }
                return true;
            }
        }

        public String m193a() {
            return "object must be an array of objects matching: <" + this.f115a.m121a() + ">";
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.d */
    private static class C0119d extends C0101a {
        private C0119d() {
        }

        public boolean m196a(Object obj) {
            return Boolean.class.isInstance(obj) || Boolean.TYPE.isInstance(obj);
        }

        public String m195a() {
            return "object must be a boolean.";
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.f */
    private static class C0120f extends C0101a {
        protected C0125k[] f116a;
        protected String f117b;

        public C0120f(C0125k[] c0125kArr) {
            this.f117b = null;
            this.f116a = c0125kArr;
        }

        public boolean m198a(Object obj) {
            int i;
            String a;
            C0101a b;
            if (obj instanceof Map) {
                Map map = (Map) obj;
                for (Entry entry : map.entrySet()) {
                    if (!(entry.getKey() instanceof String)) {
                        this.f117b = "key '" + entry.getKey().toString() + "' is not a string";
                        return false;
                    }
                }
                if (this.f116a != null && this.f116a.length > 0) {
                    for (i = 0; i < this.f116a.length; i++) {
                        a = this.f116a[i].f123a;
                        b = this.f116a[i].f124b;
                        if (map.containsKey(a)) {
                            if (!b.m122a(map.get(a))) {
                                this.f117b = "key '" + a + "' fails to match: <" + b.m121a() + ">";
                                return false;
                            }
                        } else if (!b.m122a(null)) {
                            this.f117b = "no key for required mapping '" + a + "' : <" + b.m121a() + ">";
                            return false;
                        }
                    }
                }
                return true;
            } else if (!(obj instanceof JSONObject)) {
                return false;
            } else {
                JSONObject jSONObject = (JSONObject) obj;
                if (this.f116a != null && this.f116a.length > 0) {
                    i = 0;
                    while (i < this.f116a.length) {
                        a = this.f116a[i].f123a;
                        b = this.f116a[i].f124b;
                        try {
                            if (b.m122a(jSONObject.get(a))) {
                                i++;
                            } else {
                                this.f117b = "key '" + a + "' fails to match: <" + b.m121a() + ">";
                                return false;
                            }
                        } catch (JSONException e) {
                            if (!b.m122a(null)) {
                                this.f117b = "no key for required mapping '" + a + "' : <" + b.m121a() + ">";
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
        }

        public String m197a() {
            if (this.f117b != null) {
                return this.f117b;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("object must contain the following key-value schema: {\n");
            for (int i = 0; i < this.f116a.length; i++) {
                stringBuilder.append("<");
                stringBuilder.append(this.f116a[i].f123a);
                stringBuilder.append(": [");
                stringBuilder.append(this.f116a[i].f124b.m121a());
                stringBuilder.append("]>");
                if (i < this.f116a.length - 1) {
                    stringBuilder.append(",\n");
                }
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.g */
    private static class C0121g extends C0101a {
        private Set<String> f118a;
        private C0120f f119b;
        private String f120c;

        public C0121g(C0120f c0120f) {
            this.f120c = null;
            this.f119b = c0120f;
            this.f118a = new HashSet();
            for (C0125k a : this.f119b.f116a) {
                this.f118a.add(a.f123a);
            }
        }

        public boolean m200a(Object obj) {
            if (!this.f119b.m198a(obj)) {
                this.f120c = this.f119b.f117b;
                return false;
            } else if (obj instanceof Map) {
                for (Object next : ((Map) obj).keySet()) {
                    if (!this.f118a.contains(next)) {
                        this.f120c = "key '" + next + "' is not allowed in this dictionary";
                        return false;
                    }
                }
                return true;
            } else if (obj instanceof JSONObject) {
                Iterator keys = ((JSONObject) obj).keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    if (!this.f118a.contains(str)) {
                        this.f120c = "key '" + str + "' is not allowed in this dictionary";
                        return false;
                    }
                }
                return true;
            } else {
                this.f120c = "object must be a dictionary";
                return false;
            }
        }

        public String m199a() {
            if (this.f120c != null) {
                return this.f120c;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("object must EXACTLY MATCH the following key-value schema: {\n");
            for (int i = 0; i < this.f119b.f116a.length; i++) {
                stringBuilder.append("<");
                stringBuilder.append(this.f119b.f116a[i].f123a);
                stringBuilder.append(": [");
                stringBuilder.append(this.f119b.f116a[i].f124b.m121a());
                stringBuilder.append("]>");
                if (i < this.f119b.f116a.length - 1) {
                    stringBuilder.append(",\n");
                }
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.h */
    private static class C0122h extends C0101a {
        private Object[] f121a;

        public C0122h(Object[] objArr) {
            this.f121a = objArr;
        }

        public boolean m202a(Object obj) {
            for (Object obj2 : this.f121a) {
                if (obj == null) {
                    if (obj2 == null) {
                        return true;
                    }
                } else if (obj.equals(obj2)) {
                    return true;
                }
            }
            return false;
        }

        public String m201a() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("object must equal one of the following: ");
            for (int i = 0; i < this.f121a.length; i++) {
                stringBuilder.append("<");
                stringBuilder.append(this.f121a[i].toString());
                stringBuilder.append(">");
                if (i < this.f121a.length - 1) {
                    stringBuilder.append(", ");
                }
            }
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.i */
    private static class C0123i extends C0101a {
        private Class<?> f122a;

        public C0123i(Class<?> cls) {
            this.f122a = cls;
        }

        public boolean m204a(Object obj) {
            return this.f122a.isInstance(obj);
        }

        public String m203a() {
            return "object must be an instance of " + this.f122a.getName() + ".";
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.j */
    private static class C0124j extends C0101a {
        private C0124j() {
        }

        public boolean m206a(Object obj) {
            return Integer.class.isInstance(obj) || Long.class.isInstance(obj) || Short.class.isInstance(obj) || Byte.class.isInstance(obj) || BigInteger.class.isInstance(obj) || Integer.TYPE.isInstance(obj) || Long.TYPE.isInstance(obj) || Short.TYPE.isInstance(obj) || Byte.TYPE.isInstance(obj);
        }

        public String m205a() {
            return "object must be a number w/o decimals (int, long, short, or byte).";
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.k */
    public static class C0125k {
        private String f123a;
        private C0101a f124b;

        public C0125k(String str, C0101a c0101a) {
            this.f123a = str;
            this.f124b = c0101a;
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.l */
    private static class C0126l extends C0101a {
        private C0126l() {
        }

        public boolean m210a(Object obj) {
            return obj == null || obj == JSONObject.NULL;
        }

        public String m209a() {
            return "object must be null.";
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.m */
    private static class C0127m extends C0126l {
        private C0101a f125a;

        public C0127m(C0101a c0101a) {
            super();
            this.f125a = c0101a;
        }

        public boolean m212a(Object obj) {
            if (super.m210a(obj)) {
                return true;
            }
            return this.f125a.m122a(obj);
        }

        public String m211a() {
            return "object must be either null or " + this.f125a.m121a();
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.n */
    private static class C0128n extends C0101a {
        private C0128n() {
        }

        public boolean m214a(Object obj) {
            return (obj instanceof Number) || Integer.TYPE.isInstance(obj) || Long.TYPE.isInstance(obj) || Short.TYPE.isInstance(obj) || Float.TYPE.isInstance(obj) || Double.TYPE.isInstance(obj) || Byte.TYPE.isInstance(obj);
        }

        public String m213a() {
            return "object must be a number (primitive type or derived from Number).";
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.o */
    private static class C0129o extends C0123i {
        public C0129o() {
            super(String.class);
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.p */
    private static class C0130p extends C0101a {
        protected String f126a;
        private C0101a[] f127b;

        public C0130p(C0101a[] c0101aArr) {
            this.f126a = null;
            this.f127b = c0101aArr;
        }

        public boolean m216a(Object obj) {
            int i = 0;
            while (i < this.f127b.length) {
                if (this.f127b[i].m122a(obj)) {
                    i++;
                } else {
                    this.f126a = "object failed to match: <" + this.f127b[i].m121a() + ">";
                    return false;
                }
            }
            return true;
        }

        public String m215a() {
            if (this.f126a != null) {
                return this.f126a;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("object must match ALL of the following: ");
            for (int i = 0; i < this.f127b.length; i++) {
                stringBuilder.append("<");
                stringBuilder.append(this.f127b[i].m121a());
                stringBuilder.append(">");
                if (i < this.f127b.length - 1) {
                    stringBuilder.append(", ");
                }
            }
            return stringBuilder.toString();
        }
    }

    public static C0101a m219a(Class<?> cls) {
        return new C0123i(cls);
    }

    static {
        f128a = new C0129o();
        f129b = new C0128n();
        f130c = new C0124j();
        f131d = new C0119d();
        f132e = new C0126l();
    }

    public static C0101a m217a() {
        return f128a;
    }

    public static C0101a m224b() {
        return f129b;
    }

    public static C0101a m227c() {
        return f131d;
    }

    public static C0101a m218a(C0101a c0101a) {
        return new C0127m(c0101a);
    }

    public static C0101a m225b(C0101a c0101a) {
        return new C0118c(c0101a);
    }

    public static C0101a m220a(C0101a... c0101aArr) {
        return new C0130p(c0101aArr);
    }

    public static C0101a m222a(Object... objArr) {
        return new C0122h(objArr);
    }

    public static C0125k m223a(String str, C0101a c0101a) {
        return new C0125k(str, c0101a);
    }

    public static C0101a m221a(C0125k... c0125kArr) {
        return new C0120f(c0125kArr);
    }

    public static C0101a m226b(C0125k... c0125kArr) {
        return new C0121g(new C0120f(c0125kArr));
    }

    public static boolean m228c(C0101a c0101a) {
        return (c0101a instanceof C0120f) || (c0101a instanceof C0121g);
    }
}
