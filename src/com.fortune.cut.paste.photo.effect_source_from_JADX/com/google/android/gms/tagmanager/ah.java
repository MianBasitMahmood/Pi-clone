package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

class ah extends aj {
    private static final String ID;
    private final ct aqo;

    static {
        ID = C0997a.EVENT.toString();
    }

    public ah(ct ctVar) {
        super(ID, new String[0]);
        this.aqo = ctVar;
    }

    public C1070a m6410B(Map<String, C1070a> map) {
        String qE = this.aqo.qE();
        return qE == null ? di.rb() : di.m6618u(qE);
    }

    public boolean pe() {
        return false;
    }
}
