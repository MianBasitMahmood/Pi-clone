package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1022b;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

class cf extends aj {
    private static final String ID;
    private static final String asu;
    private static final String asv;

    static {
        ID = C0997a.RANDOM.toString();
        asu = C1022b.MIN.toString();
        asv = C1022b.MAX.toString();
    }

    public cf() {
        super(ID, new String[0]);
    }

    public C1070a m6510B(Map<String, C1070a> map) {
        double doubleValue;
        double d;
        C1070a c1070a = (C1070a) map.get(asu);
        C1070a c1070a2 = (C1070a) map.get(asv);
        if (!(c1070a == null || c1070a == di.rb() || c1070a2 == null || c1070a2 == di.rb())) {
            dh k = di.m6608k(c1070a);
            dh k2 = di.m6608k(c1070a2);
            if (!(k == di.qZ() || k2 == di.qZ())) {
                double doubleValue2 = k.doubleValue();
                doubleValue = k2.doubleValue();
                if (doubleValue2 <= doubleValue) {
                    d = doubleValue2;
                    return di.m6618u(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
                }
            }
        }
        doubleValue = 2.147483647E9d;
        d = 0.0d;
        return di.m6618u(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
    }

    public boolean pe() {
        return false;
    }
}
