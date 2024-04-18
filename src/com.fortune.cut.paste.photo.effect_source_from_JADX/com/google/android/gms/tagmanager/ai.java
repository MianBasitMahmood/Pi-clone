package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1048c.C1040c;
import com.google.android.gms.internal.C1048c.C1041d;
import com.google.android.gms.internal.C1048c.C1046i;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

class ai {
    private static void m6411a(DataLayer dataLayer, C1041d c1041d) {
        for (C1070a j : c1041d.fB) {
            dataLayer.cx(di.m6607j(j));
        }
    }

    public static void m6412a(DataLayer dataLayer, C1046i c1046i) {
        if (c1046i.gq == null) {
            bh.m6461W("supplemental missing experimentSupplemental");
            return;
        }
        m6411a(dataLayer, c1046i.gq);
        m6413b(dataLayer, c1046i.gq);
        m6415c(dataLayer, c1046i.gq);
    }

    private static void m6413b(DataLayer dataLayer, C1041d c1041d) {
        for (C1070a c : c1041d.fA) {
            Map c2 = m6414c(c);
            if (c2 != null) {
                dataLayer.push(c2);
            }
        }
    }

    private static Map<String, Object> m6414c(C1070a c1070a) {
        Object o = di.m6612o(c1070a);
        if (o instanceof Map) {
            return (Map) o;
        }
        bh.m6461W("value: " + o + " is not a map value, ignored.");
        return null;
    }

    private static void m6415c(DataLayer dataLayer, C1041d c1041d) {
        for (C1040c c1040c : c1041d.fC) {
            if (c1040c.fv == null) {
                bh.m6461W("GaExperimentRandom: No key");
            } else {
                Object obj = dataLayer.get(c1040c.fv);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = c1040c.fw;
                long j2 = c1040c.fx;
                if (!c1040c.fy || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        bh.m6461W("GaExperimentRandom: random range invalid");
                    }
                }
                dataLayer.cx(c1040c.fv);
                Map c = dataLayer.m6386c(c1040c.fv, obj);
                if (c1040c.fz > 0) {
                    if (c.containsKey("gtm")) {
                        Object obj2 = c.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(c1040c.fz));
                        } else {
                            bh.m6461W("GaExperimentRandom: gtm not a map");
                        }
                    } else {
                        c.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(c1040c.fz)));
                    }
                }
                dataLayer.push(c);
            }
        }
    }
}
