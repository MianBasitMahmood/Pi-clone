package com.chartboost.sdk.impl;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.drive.ExecutionOptions;
import java.lang.reflect.Array;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

public class cl implements ci {
    protected cp f842a;

    public byte[] m1230a(cj cjVar) {
        cp coVar = new co();
        m1214a(coVar);
        m1231b(cjVar);
        m1212a();
        return coVar.m1245c();
    }

    public void m1214a(cp cpVar) {
        if (this.f842a != null) {
            throw new IllegalStateException("in the middle of something");
        }
        this.f842a = cpVar;
    }

    public void m1212a() {
        this.f842a = null;
    }

    protected boolean m1228a(String str, cj cjVar) {
        return false;
    }

    protected boolean m1229a(String str, Object obj) {
        return false;
    }

    public int m1231b(cj cjVar) {
        return m1232b(null, cjVar);
    }

    protected int m1232b(String str, cj cjVar) {
        if (cjVar == null) {
            throw new NullPointerException("can't save a null object");
        }
        byte b;
        int a = this.f842a.m1237a();
        if (cjVar instanceof List) {
            b = (byte) 4;
        } else {
            b = (byte) 3;
        }
        if (m1228a(str, cjVar)) {
            return this.f842a.m1237a() - a;
        }
        if (str != null) {
            m1213a(b, str);
        }
        int a2 = this.f842a.m1237a();
        this.f842a.m1244c(0);
        List list = null;
        int i = (b == (byte) 3 && str == null) ? 1 : 0;
        if (b == (byte) 3) {
            if (i != 0 && cjVar.m1148b("_id")) {
                m1234b("_id", cjVar.m1146a("_id"));
            }
            Object a3 = cjVar.m1146a("_transientFields");
            if (a3 instanceof List) {
                list = (List) a3;
            }
        }
        if (cjVar instanceof Map) {
            for (Entry entry : ((Map) cjVar).entrySet()) {
                if ((i == 0 || !((String) entry.getKey()).equals("_id")) && (r2 == null || !r2.contains(entry.getKey()))) {
                    m1234b((String) entry.getKey(), entry.getValue());
                }
            }
        } else {
            for (String str2 : cjVar.keySet()) {
                if ((i == 0 || !str2.equals("_id")) && (r2 == null || !r2.contains(str2))) {
                    m1234b(str2, cjVar.m1146a(str2));
                }
            }
        }
        this.f842a.write(0);
        this.f842a.m1241a(a2, this.f842a.m1237a() - a2);
        return this.f842a.m1237a() - a;
    }

    protected void m1234b(String str, Object obj) {
        if (!str.equals("_transientFields")) {
            if (str.equals("$where") && (obj instanceof String)) {
                m1213a((byte) 13, str);
                m1233b(obj.toString());
                return;
            }
            Object a = cg.m1152a(obj);
            if (a == null) {
                m1215a(str);
            } else if (a instanceof Date) {
                m1225a(str, (Date) a);
            } else if (a instanceof Number) {
                m1223a(str, (Number) a);
            } else if (a instanceof Character) {
                m1224a(str, a.toString());
            } else if (a instanceof String) {
                m1224a(str, a.toString());
            } else if (a instanceof cy) {
                m1220a(str, (cy) a);
            } else if (a instanceof cj) {
                m1232b(str, (cj) a);
            } else if (a instanceof Boolean) {
                m1222a(str, (Boolean) a);
            } else if (a instanceof Pattern) {
                m1208a(str, (Pattern) a);
            } else if (a instanceof Map) {
                m1207a(str, (Map) a);
            } else if (a instanceof Iterable) {
                m1205a(str, (Iterable) a);
            } else if (a instanceof byte[]) {
                m1227a(str, (byte[]) a);
            } else if (a instanceof ct) {
                m1217a(str, (ct) a);
            } else if (a instanceof UUID) {
                m1226a(str, (UUID) a);
            } else if (a.getClass().isArray()) {
                m1209c(str, a);
            } else if (a instanceof cz) {
                m1221a(str, (cz) a);
            } else if (a instanceof cs) {
                m1216a(str, (cs) a);
            } else if (a instanceof cv) {
                m1219a(str, (cv) a);
            } else if (a instanceof cu) {
                m1218a(str, (cu) a);
            } else if (a instanceof bv) {
                cj cmVar = new cm();
                cmVar.m1147a("$ref", ((bv) a).m1156b());
                cmVar.m1147a("$id", ((bv) a).m1155a());
                m1232b(str, cmVar);
            } else if (a instanceof cx) {
                m1213a((byte) -1, str);
            } else if (a instanceof cw) {
                m1213a(Byte.MAX_VALUE, str);
            } else if (!m1229a(str, a)) {
                throw new IllegalArgumentException("can't serialize " + a.getClass());
            }
        }
    }

    private void m1209c(String str, Object obj) {
        m1213a((byte) 4, str);
        int a = this.f842a.m1237a();
        this.f842a.m1244c(0);
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            m1234b(String.valueOf(i), Array.get(obj, i));
        }
        this.f842a.write(0);
        this.f842a.m1241a(a, this.f842a.m1237a() - a);
    }

    private void m1205a(String str, Iterable iterable) {
        m1213a((byte) 4, str);
        int a = this.f842a.m1237a();
        this.f842a.m1244c(0);
        int i = 0;
        for (Object b : iterable) {
            m1234b(String.valueOf(i), b);
            i++;
        }
        this.f842a.write(0);
        this.f842a.m1241a(a, this.f842a.m1237a() - a);
    }

    private void m1207a(String str, Map map) {
        m1213a((byte) 3, str);
        int a = this.f842a.m1237a();
        this.f842a.m1244c(0);
        for (Entry entry : map.entrySet()) {
            m1234b(entry.getKey().toString(), entry.getValue());
        }
        this.f842a.write(0);
        this.f842a.m1241a(a, this.f842a.m1237a() - a);
    }

    protected void m1215a(String str) {
        m1213a((byte) 10, str);
    }

    protected void m1216a(String str, cs csVar) {
        m1213a((byte) 17, str);
        this.f842a.m1244c(csVar.m1276b());
        this.f842a.m1244c(csVar.m1274a());
    }

    protected void m1219a(String str, cv cvVar) {
        m1213a((byte) 15, str);
        int a = this.f842a.m1237a();
        this.f842a.m1244c(0);
        m1233b(cvVar.m1279a());
        m1231b(cvVar.m1280b());
        this.f842a.m1241a(a, this.f842a.m1237a() - a);
    }

    protected void m1218a(String str, cu cuVar) {
        m1213a((byte) 13, str);
        this.f842a.m1237a();
        m1233b(cuVar.m1279a());
    }

    protected void m1222a(String str, Boolean bool) {
        m1213a((byte) 8, str);
        this.f842a.write(bool.booleanValue() ? 1 : 0);
    }

    protected void m1225a(String str, Date date) {
        m1213a((byte) 9, str);
        this.f842a.m1242a(date.getTime());
    }

    protected void m1223a(String str, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte) || (number instanceof AtomicInteger)) {
            m1213a((byte) 16, str);
            this.f842a.m1244c(number.intValue());
        } else if ((number instanceof Long) || (number instanceof AtomicLong)) {
            m1213a((byte) 18, str);
            this.f842a.m1242a(number.longValue());
        } else if ((number instanceof Float) || (number instanceof Double)) {
            m1213a((byte) 1, str);
            this.f842a.m1239a(number.doubleValue());
        } else {
            throw new IllegalArgumentException("can't serialize " + number.getClass());
        }
    }

    protected void m1227a(String str, byte[] bArr) {
        m1204a(str, 0, bArr);
    }

    protected void m1217a(String str, ct ctVar) {
        m1204a(str, ctVar.m1277a(), ctVar.m1278b());
    }

    private void m1204a(String str, int i, byte[] bArr) {
        m1213a((byte) 5, str);
        int length = bArr.length;
        if (i == 2) {
            length += 4;
        }
        this.f842a.m1244c(length);
        this.f842a.write(i);
        if (i == 2) {
            this.f842a.m1244c(length - 4);
        }
        length = this.f842a.m1237a();
        this.f842a.write(bArr);
        ca.m1184a(this.f842a.m1237a() - length, bArr.length);
    }

    protected void m1226a(String str, UUID uuid) {
        m1213a((byte) 5, str);
        this.f842a.m1244c(16);
        this.f842a.write(3);
        this.f842a.m1242a(uuid.getMostSignificantBits());
        this.f842a.m1242a(uuid.getLeastSignificantBits());
    }

    protected void m1221a(String str, cz czVar) {
        m1206a(str, czVar.m1292a(), (byte) 14);
    }

    protected void m1224a(String str, String str2) {
        m1206a(str, str2, (byte) 2);
    }

    private void m1206a(String str, String str2, byte b) {
        m1213a(b, str);
        m1233b(str2);
    }

    protected void m1220a(String str, cy cyVar) {
        m1213a((byte) 7, str);
        this.f842a.m1246d(cyVar.m1289c());
        this.f842a.m1246d(cyVar.m1290d());
        this.f842a.m1246d(cyVar.m1291e());
    }

    private void m1208a(String str, Pattern pattern) {
        m1213a((byte) 11, str);
        m1235c(pattern.pattern());
        m1235c(cg.m1153a(pattern.flags()));
    }

    private void m1210d(String str) {
        m1213a((byte) -1, str);
    }

    private void m1211e(String str) {
        m1213a(Byte.MAX_VALUE, str);
    }

    protected void m1213a(byte b, String str) {
        this.f842a.write((int) b);
        m1235c(str);
    }

    protected void m1233b(String str) {
        int a = this.f842a.m1237a();
        this.f842a.m1244c(0);
        this.f842a.m1241a(a, m1235c(str));
    }

    protected int m1235c(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int codePointAt = Character.codePointAt(str, i);
            if (codePointAt < Cast.MAX_NAMESPACE_LENGTH) {
                this.f842a.write((byte) codePointAt);
                i2++;
            } else if (codePointAt < AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT) {
                this.f842a.write((byte) ((codePointAt >> 6) + 192));
                this.f842a.write((byte) ((codePointAt & 63) + Cast.MAX_NAMESPACE_LENGTH));
                i2 += 2;
            } else if (codePointAt < ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH) {
                this.f842a.write((byte) ((codePointAt >> 12) + 224));
                this.f842a.write((byte) (((codePointAt >> 6) & 63) + Cast.MAX_NAMESPACE_LENGTH));
                this.f842a.write((byte) ((codePointAt & 63) + Cast.MAX_NAMESPACE_LENGTH));
                i2 += 3;
            } else {
                this.f842a.write((byte) ((codePointAt >> 18) + 240));
                this.f842a.write((byte) (((codePointAt >> 12) & 63) + Cast.MAX_NAMESPACE_LENGTH));
                this.f842a.write((byte) (((codePointAt >> 6) & 63) + Cast.MAX_NAMESPACE_LENGTH));
                this.f842a.write((byte) ((codePointAt & 63) + Cast.MAX_NAMESPACE_LENGTH));
                i2 += 4;
            }
            i += Character.charCount(codePointAt);
        }
        this.f842a.write(0);
        return i2 + 1;
    }
}
