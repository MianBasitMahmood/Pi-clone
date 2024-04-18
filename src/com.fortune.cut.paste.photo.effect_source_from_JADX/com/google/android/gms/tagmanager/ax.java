package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1022b;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

class ax extends aj {
    private static final String ID;
    private static final String aqd;
    private final Context lM;

    static {
        ID = C0997a.INSTALL_REFERRER.toString();
        aqd = C1022b.COMPONENT.toString();
    }

    public ax(Context context) {
        super(ID, new String[0]);
        this.lM = context;
    }

    public C1070a m6437B(Map<String, C1070a> map) {
        String e = ay.m6439e(this.lM, ((C1070a) map.get(aqd)) != null ? di.m6607j((C1070a) map.get(aqd)) : null);
        return e != null ? di.m6618u(e) : di.rb();
    }

    public boolean pe() {
        return true;
    }
}
