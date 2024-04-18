package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1022b;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.u */
class C1826u extends aj {
    private static final String ID;
    private static final String NAME;
    private static final String aqZ;
    private final DataLayer aqn;

    static {
        ID = C0997a.CUSTOM_VAR.toString();
        NAME = C1022b.NAME.toString();
        aqZ = C1022b.DEFAULT_VALUE.toString();
    }

    public C1826u(DataLayer dataLayer) {
        super(ID, NAME);
        this.aqn = dataLayer;
    }

    public C1070a m6676B(Map<String, C1070a> map) {
        Object obj = this.aqn.get(di.m6607j((C1070a) map.get(NAME)));
        if (obj != null) {
            return di.m6618u(obj);
        }
        C1070a c1070a = (C1070a) map.get(aqZ);
        return c1070a != null ? c1070a : di.rb();
    }

    public boolean pe() {
        return false;
    }
}
