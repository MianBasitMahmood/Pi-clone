package com.chartboost.sdk.impl;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SimpleTimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

public class bz {

    /* renamed from: com.chartboost.sdk.impl.bz.c */
    private static abstract class C0276c extends bw {
        protected final cb f794a;

        C0276c(cb cbVar) {
            this.f794a = cbVar;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bz.a */
    private static class C0277a extends C0276c {
        C0277a(cb cbVar) {
            super(cbVar);
        }

        public void m1163a(Object obj, StringBuilder stringBuilder) {
            cu cuVar = (cu) obj;
            bs bsVar = new bs();
            bsVar.m1150a("$code", cuVar.m1279a());
            this.a.m1157a(bsVar, stringBuilder);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bz.b */
    private static class C0278b extends C0276c {
        C0278b(cb cbVar) {
            super(cbVar);
        }

        public void m1164a(Object obj, StringBuilder stringBuilder) {
            cv cvVar = (cv) obj;
            bs bsVar = new bs();
            bsVar.m1150a("$code", cvVar.m1279a());
            bsVar.m1150a("$scope", cvVar.m1280b());
            this.a.m1157a(bsVar, stringBuilder);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bz.d */
    private static class C0279d extends C0276c {
        C0279d(cb cbVar) {
            super(cbVar);
        }

        public void m1165a(Object obj, StringBuilder stringBuilder) {
            stringBuilder.append("{ ");
            bu buVar = (bu) obj;
            Object obj2 = 1;
            for (String str : buVar.keySet()) {
                if (obj2 != null) {
                    obj2 = null;
                } else {
                    stringBuilder.append(" , ");
                }
                by.m1162a(stringBuilder, str);
                stringBuilder.append(" : ");
                this.a.m1157a(buVar.m1146a(str), stringBuilder);
            }
            stringBuilder.append("}");
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bz.e */
    private static class C0280e extends C0276c {
        C0280e(cb cbVar) {
            super(cbVar);
        }

        public void m1166a(Object obj, StringBuilder stringBuilder) {
            bv bvVar = (bv) obj;
            bs bsVar = new bs();
            bsVar.m1150a("$ref", bvVar.m1156b());
            bsVar.m1150a("$id", bvVar.m1155a());
            this.a.m1157a(bsVar, stringBuilder);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bz.f */
    private static class C0281f extends C0276c {
        C0281f(cb cbVar) {
            super(cbVar);
        }

        public void m1167a(Object obj, StringBuilder stringBuilder) {
            Object obj2 = 1;
            stringBuilder.append("[ ");
            for (Object next : (Iterable) obj) {
                if (obj2 != null) {
                    obj2 = null;
                } else {
                    stringBuilder.append(" , ");
                }
                this.a.m1157a(next, stringBuilder);
            }
            stringBuilder.append("]");
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bz.g */
    private static class C0282g extends C0276c {
        C0282g(cb cbVar) {
            super(cbVar);
        }

        public void m1168a(Object obj, StringBuilder stringBuilder) {
            cs csVar = (cs) obj;
            bs bsVar = new bs();
            bsVar.m1150a("$ts", Integer.valueOf(csVar.m1274a()));
            bsVar.m1150a("$inc", Integer.valueOf(csVar.m1276b()));
            this.a.m1157a(bsVar, stringBuilder);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bz.h */
    private static class C0283h extends bw {
        private C0283h() {
        }

        public void m1169a(Object obj, StringBuilder stringBuilder) {
            stringBuilder.append("<Binary Data>");
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bz.i */
    private static class C0284i extends C0276c {
        C0284i(cb cbVar) {
            super(cbVar);
        }

        public void m1170a(Object obj, StringBuilder stringBuilder) {
            Date date = (Date) obj;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            simpleDateFormat.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
            this.a.m1157a(new bs("$date", simpleDateFormat.format(date)), stringBuilder);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bz.j */
    private static class C0285j extends C0276c {
        C0285j(cb cbVar) {
            super(cbVar);
        }

        public void m1171a(Object obj, StringBuilder stringBuilder) {
            Object obj2 = 1;
            stringBuilder.append("{ ");
            for (Entry entry : ((Map) obj).entrySet()) {
                if (obj2 != null) {
                    obj2 = null;
                } else {
                    stringBuilder.append(" , ");
                }
                by.m1162a(stringBuilder, entry.getKey().toString());
                stringBuilder.append(" : ");
                this.a.m1157a(entry.getValue(), stringBuilder);
            }
            stringBuilder.append("}");
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bz.k */
    private static class C0286k extends C0276c {
        C0286k(cb cbVar) {
            super(cbVar);
        }

        public void m1172a(Object obj, StringBuilder stringBuilder) {
            this.a.m1157a(new bs("$maxKey", Integer.valueOf(1)), stringBuilder);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bz.l */
    private static class C0287l extends C0276c {
        C0287l(cb cbVar) {
            super(cbVar);
        }

        public void m1173a(Object obj, StringBuilder stringBuilder) {
            this.a.m1157a(new bs("$minKey", Integer.valueOf(1)), stringBuilder);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bz.m */
    private static class C0288m extends C0276c {
        C0288m(cb cbVar) {
            super(cbVar);
        }

        public void m1174a(Object obj, StringBuilder stringBuilder) {
            stringBuilder.append("[ ");
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) {
                    stringBuilder.append(" , ");
                }
                this.a.m1157a(Array.get(obj, i), stringBuilder);
            }
            stringBuilder.append("]");
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bz.n */
    private static class C0289n extends C0276c {
        C0289n(cb cbVar) {
            super(cbVar);
        }

        public void m1175a(Object obj, StringBuilder stringBuilder) {
            this.a.m1157a(new bs("$oid", obj.toString()), stringBuilder);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bz.o */
    private static class C0290o extends C0276c {
        C0290o(cb cbVar) {
            super(cbVar);
        }

        public void m1176a(Object obj, StringBuilder stringBuilder) {
            bu bsVar = new bs();
            bsVar.m1147a("$regex", obj.toString());
            if (((Pattern) obj).flags() != 0) {
                bsVar.m1147a("$options", cg.m1153a(((Pattern) obj).flags()));
            }
            this.a.m1157a(bsVar, stringBuilder);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bz.p */
    private static class C0291p extends bw {
        private C0291p() {
        }

        public void m1177a(Object obj, StringBuilder stringBuilder) {
            by.m1162a(stringBuilder, (String) obj);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bz.q */
    private static class C0292q extends bw {
        private C0292q() {
        }

        public void m1178a(Object obj, StringBuilder stringBuilder) {
            stringBuilder.append(obj.toString());
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bz.r */
    private static class C0293r extends C0276c {
        C0293r(cb cbVar) {
            super(cbVar);
        }

        public void m1179a(Object obj, StringBuilder stringBuilder) {
            UUID uuid = (UUID) obj;
            bs bsVar = new bs();
            bsVar.m1150a("$uuid", uuid.toString());
            this.a.m1157a(bsVar, stringBuilder);
        }
    }

    public static cb m1180a() {
        cb b = m1181b();
        b.m1158a(Date.class, new C0284i(b));
        b.m1158a(cs.class, new C0282g(b));
        b.m1158a(ct.class, new C0283h());
        b.m1158a(byte[].class, new C0283h());
        return b;
    }

    static bx m1181b() {
        bx bxVar = new bx();
        bxVar.m1158a(Object[].class, new C0288m(bxVar));
        bxVar.m1158a(Boolean.class, new C0292q());
        bxVar.m1158a(cu.class, new C0277a(bxVar));
        bxVar.m1158a(cv.class, new C0278b(bxVar));
        bxVar.m1158a(bu.class, new C0279d(bxVar));
        bxVar.m1158a(bv.class, new C0280e(bxVar));
        bxVar.m1158a(Iterable.class, new C0281f(bxVar));
        bxVar.m1158a(Map.class, new C0285j(bxVar));
        bxVar.m1158a(cw.class, new C0286k(bxVar));
        bxVar.m1158a(cx.class, new C0287l(bxVar));
        bxVar.m1158a(Number.class, new C0292q());
        bxVar.m1158a(cy.class, new C0289n(bxVar));
        bxVar.m1158a(Pattern.class, new C0290o(bxVar));
        bxVar.m1158a(String.class, new C0291p());
        bxVar.m1158a(UUID.class, new C0293r(bxVar));
        return bxVar;
    }
}
