package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1022b;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.e */
class C1801e extends aj {
    private static final String ID;
    private static final String aqd;
    private static final String aqe;
    private final Context lM;

    static {
        ID = C0997a.ADWORDS_CLICK_REFERRER.toString();
        aqd = C1022b.COMPONENT.toString();
        aqe = C1022b.CONVERSION_ID.toString();
    }

    public C1801e(Context context) {
        super(ID, aqe);
        this.lM = context;
    }

    public C1070a m6641B(Map<String, C1070a> map) {
        C1070a c1070a = (C1070a) map.get(aqe);
        if (c1070a == null) {
            return di.rb();
        }
        String j = di.m6607j(c1070a);
        c1070a = (C1070a) map.get(aqd);
        String f = ay.m6440f(this.lM, j, c1070a != null ? di.m6607j(c1070a) : null);
        return f != null ? di.m6618u(f) : di.rb();
    }

    public boolean pe() {
        return true;
    }
}
