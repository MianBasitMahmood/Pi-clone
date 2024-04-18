package com.chartboost.sdk.Libraries;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Libraries.e */
public class C0113e {
    private static Map<Integer, C0111a> f103a;
    private static Runnable f104b;

    /* renamed from: com.chartboost.sdk.Libraries.e.1 */
    static class C01101 implements Runnable {
        C01101() {
        }

        public final void run() {
            C0113e.f103a.clear();
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.e.a */
    public static class C0111a {
        public static C0111a f95a;
        private static JSONObject f96c;
        private static Map<String, Object> f97d;
        private static JSONArray f98e;
        private static List<?> f99f;
        private Object f100b;

        static {
            f95a = new C0111a(null);
            f96c = null;
            f97d = null;
            f98e = null;
            f99f = null;
        }

        private C0111a(Object obj) {
            this.f100b = obj;
        }

        public static C0111a m145a() {
            return C0111a.m146a(new JSONObject());
        }

        public C0111a m151a(String str) {
            if (this.f100b instanceof JSONObject) {
                return C0111a.m146a(((JSONObject) this.f100b).opt(str));
            }
            if (this.f100b instanceof Map) {
                return C0111a.m146a(((Map) this.f100b).get(str));
            }
            return f95a;
        }

        public boolean m155b() {
            return this.f100b == null || this.f100b == JSONObject.NULL;
        }

        public boolean m158c() {
            return !m155b();
        }

        public boolean m161d() {
            return !TextUtils.isEmpty(m169h());
        }

        public boolean m156b(String str) {
            return m151a(str).m155b();
        }

        public boolean m159c(String str) {
            return m151a(str).m158c();
        }

        public JSONObject m163e() {
            if (this.f100b instanceof JSONObject) {
                return (JSONObject) this.f100b;
            }
            if (!(this.f100b instanceof Map)) {
                return null;
            }
            if (f96c == null) {
                f96c = C0113e.m186a((Map) this.f100b);
            }
            return f96c;
        }

        public Map<String, Object> m165f() {
            if (this.f100b instanceof JSONObject) {
                if (f97d == null) {
                    f97d = C0113e.m184a((JSONObject) this.f100b);
                }
                return f97d;
            } else if (this.f100b instanceof Map) {
                return (Map) this.f100b;
            } else {
                return null;
            }
        }

        public JSONArray m167g() {
            if (this.f100b instanceof JSONArray) {
                return (JSONArray) this.f100b;
            }
            if (!(this.f100b instanceof List)) {
                return null;
            }
            if (f98e == null) {
                f98e = C0113e.m185a((List) this.f100b);
            }
            return f98e;
        }

        public String m169h() {
            if (m155b()) {
                return null;
            }
            return this.f100b instanceof String ? (String) this.f100b : this.f100b.toString();
        }

        public String m160d(String str) {
            return this.f100b instanceof String ? (String) this.f100b : str;
        }

        public double m170i() {
            return m148a(0.0d);
        }

        public double m148a(double d) {
            if (!(this.f100b instanceof String)) {
                return this.f100b instanceof Number ? ((Number) this.f100b).doubleValue() : d;
            } else {
                try {
                    return Double.parseDouble((String) this.f100b);
                } catch (NumberFormatException e) {
                    return d;
                }
            }
        }

        public float m172j() {
            return m149a(0.0f);
        }

        public float m149a(float f) {
            if (!(this.f100b instanceof String)) {
                return this.f100b instanceof Number ? ((Number) this.f100b).floatValue() : f;
            } else {
                try {
                    return Float.parseFloat((String) this.f100b);
                } catch (NumberFormatException e) {
                    return f;
                }
            }
        }

        public int m173k() {
            return m150a(0);
        }

        public int m150a(int i) {
            if (!(this.f100b instanceof String)) {
                return this.f100b instanceof Number ? ((Number) this.f100b).intValue() : i;
            } else {
                try {
                    return Integer.parseInt((String) this.f100b);
                } catch (NumberFormatException e) {
                    return i;
                }
            }
        }

        public long m174l() {
            return m154b(0);
        }

        public long m154b(int i) {
            if (!(this.f100b instanceof String)) {
                return this.f100b instanceof Number ? ((Number) this.f100b).longValue() : (long) i;
            } else {
                try {
                    return Long.parseLong((String) this.f100b);
                } catch (NumberFormatException e) {
                    return (long) i;
                }
            }
        }

        public boolean m175m() {
            return m153a(false);
        }

        public boolean m153a(boolean z) {
            return this.f100b instanceof Boolean ? ((Boolean) this.f100b).booleanValue() : z;
        }

        public boolean equals(Object obj) {
            C0111a a = C0111a.m146a(obj);
            if (m155b()) {
                return a.m155b();
            }
            if (m163e() != null && a.m163e() != null) {
                return C0133i.m249a(m163e(), a.m163e());
            }
            if (m167g() != null && a.m167g() != null) {
                return C0133i.m248a(m167g(), a.m167g());
            }
            if (this.f100b instanceof String) {
                return this.f100b.equals(a.m169h());
            }
            if (a.f100b instanceof String) {
                return a.f100b.equals(m169h());
            }
            return m176n().equals(a.m176n());
        }

        public Object m176n() {
            return this.f100b;
        }

        public static C0111a m146a(Object obj) {
            if (obj instanceof C0111a) {
                return (C0111a) obj;
            }
            if (obj == null || obj == JSONObject.NULL) {
                return f95a;
            }
            C0111a c0111a = (C0111a) C0113e.f103a.get(Integer.valueOf(obj.hashCode()));
            if (c0111a != null) {
                return c0111a;
            }
            CBUtility.m120e().removeCallbacks(C0113e.f104b);
            CBUtility.m120e().postDelayed(C0113e.f104b, 1000);
            c0111a = new C0111a(obj);
            C0113e.f103a.put(Integer.valueOf(obj.hashCode()), c0111a);
            return c0111a;
        }

        public int m177o() {
            if (this.f100b instanceof JSONArray) {
                return ((JSONArray) this.f100b).length();
            }
            if (this.f100b instanceof List) {
                return ((List) this.f100b).size();
            }
            return 1;
        }

        public C0111a m157c(int i) {
            if (this.f100b instanceof JSONArray) {
                return C0111a.m146a(((JSONArray) this.f100b).opt(i));
            }
            if (!(this.f100b instanceof List)) {
                return i != 0 ? f95a : this;
            } else {
                try {
                    return C0111a.m146a(((List) this.f100b).get(i));
                } catch (IndexOutOfBoundsException e) {
                    return f95a;
                }
            }
        }

        public String m162e(String str) {
            return m151a(str).m169h();
        }

        public int m164f(String str) {
            return m151a(str).m173k();
        }

        public double m166g(String str) {
            return m151a(str).m170i();
        }

        public long m168h(String str) {
            return m151a(str).m174l();
        }

        public boolean m171i(String str) {
            return m151a(str).m175m();
        }

        public void m152a(String str, Object obj) {
            f96c = null;
            f98e = null;
            f97d = null;
            f99f = null;
            if (obj instanceof C0111a) {
                obj = ((C0111a) obj).m176n();
            }
            if (this.f100b instanceof JSONObject) {
                try {
                    ((JSONObject) this.f100b).put(str, obj);
                } catch (Throwable e) {
                    CBLogging.m102b(this, "Error updating balances dictionary.", e);
                }
            } else if (this.f100b instanceof Map) {
                try {
                    ((Map) this.f100b).put(str, obj);
                } catch (Throwable e2) {
                    CBLogging.m102b(this, "Error updating balances dictionary.", e2);
                }
            }
        }

        public static C0111a m147j(String str) {
            if (str == null) {
                CBLogging.m105d("CBJSON", "null passed when creating new JSON object");
                return f95a;
            }
            if (str != null) {
                try {
                    if (str.trim().startsWith("[")) {
                        return C0111a.m146a(new JSONArray(str));
                    }
                } catch (Throwable e) {
                    CBLogging.m102b("CBJSON", "error creating new json object", e);
                    return f95a;
                }
            }
            return C0111a.m146a(new JSONObject(str));
        }

        public String toString() {
            if (m163e() != null) {
                return m163e().toString();
            }
            if (m167g() != null) {
                return m167g().toString();
            }
            if (this.f100b != null) {
                return this.f100b.toString();
            }
            return "null";
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.e.b */
    public static class C0112b {
        private String f101a;
        private Object f102b;

        public C0112b(String str, Object obj) {
            this.f101a = str;
            if (obj instanceof C0111a) {
                this.f102b = ((C0111a) obj).m176n();
            } else {
                this.f102b = obj;
            }
        }
    }

    static {
        f103a = Collections.synchronizedMap(new HashMap());
        f104b = new C01101();
    }

    public static C0111a m180a(C0112b... c0112bArr) {
        C0111a a = C0111a.m145a();
        for (int i = 0; i < c0112bArr.length; i++) {
            a.m152a(c0112bArr[i].f101a, c0112bArr[i].f102b);
        }
        return a;
    }

    public static C0112b m181a(String str, Object obj) {
        return new C0112b(str, obj);
    }

    public static List<?> m182a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        List<?> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Object obj = jSONArray.get(i);
                if (obj instanceof JSONObject) {
                    obj = C0113e.m184a((JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    obj = C0113e.m182a((JSONArray) obj);
                } else if (obj.equals(JSONObject.NULL)) {
                    obj = null;
                }
                arrayList.add(obj);
            } catch (Throwable e) {
                CBLogging.m102b("CBJSON", "error converting json", e);
            }
        }
        return arrayList;
    }

    public static Map<String, Object> m184a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Map<String, Object> hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String str = (String) keys.next();
                Object obj = jSONObject.get(str);
                if (obj instanceof JSONObject) {
                    obj = C0113e.m184a((JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    obj = C0113e.m182a((JSONArray) obj);
                } else if (obj.equals(JSONObject.NULL)) {
                    obj = null;
                }
                hashMap.put(str, obj);
            } catch (Throwable e) {
                CBLogging.m102b("CBJSON", "error converting json", e);
            }
        }
        return hashMap;
    }

    public static JSONArray m185a(List<?> list) {
        if (list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            try {
                Object obj = list.get(i);
                if (obj instanceof Map) {
                    obj = C0113e.m186a((Map) obj);
                } else if (obj instanceof List) {
                    obj = C0113e.m185a((List) obj);
                } else if (obj == null) {
                    obj = JSONObject.NULL;
                }
                jSONArray.put(obj);
            } catch (Throwable e) {
                CBLogging.m102b("CBJSON", "error converting json", e);
            }
        }
        return jSONArray;
    }

    public static JSONObject m186a(Map<?, ?> map) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : map.entrySet()) {
            String obj = entry.getKey().toString();
            Object value = entry.getValue();
            try {
                if (value instanceof Map) {
                    value = C0113e.m186a((Map) value);
                } else if (value instanceof List) {
                    value = C0113e.m185a((List) value);
                } else if (value == null) {
                    value = JSONObject.NULL;
                }
                jSONObject.put(obj, value);
            } catch (Throwable e) {
                CBLogging.m102b("CBJSON", "error converting json", e);
            }
        }
        return jSONObject;
    }
}
