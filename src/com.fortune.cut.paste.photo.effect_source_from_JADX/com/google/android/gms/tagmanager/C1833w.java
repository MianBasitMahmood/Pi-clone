package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1022b;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.w */
class C1833w extends dg {
    private static final String ID;
    private static final String VALUE;
    private static final String ark;
    private final DataLayer aqn;

    static {
        ID = C0997a.DATA_LAYER_WRITE.toString();
        VALUE = C1022b.VALUE.toString();
        ark = C1022b.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    }

    public C1833w(DataLayer dataLayer) {
        super(ID, VALUE);
        this.aqn = dataLayer;
    }

    private void m6693a(C1070a c1070a) {
        if (c1070a != null && c1070a != di.qV()) {
            String j = di.m6607j(c1070a);
            if (j != di.ra()) {
                this.aqn.cx(j);
            }
        }
    }

    private void m6694b(C1070a c1070a) {
        if (c1070a != null && c1070a != di.qV()) {
            Object o = di.m6612o(c1070a);
            if (o instanceof List) {
                for (Object o2 : (List) o2) {
                    if (o2 instanceof Map) {
                        this.aqn.push((Map) o2);
                    }
                }
            }
        }
    }

    public void m6695D(Map<String, C1070a> map) {
        m6694b((C1070a) map.get(VALUE));
        m6693a((C1070a) map.get(ark));
    }
}
