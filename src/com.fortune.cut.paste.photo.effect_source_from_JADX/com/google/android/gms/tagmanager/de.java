package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

class de extends aj {
    private static final String ID;

    static {
        ID = C0997a.TIME.toString();
    }

    public de() {
        super(ID, new String[0]);
    }

    public C1070a m6601B(Map<String, C1070a> map) {
        return di.m6618u(Long.valueOf(System.currentTimeMillis()));
    }

    public boolean pe() {
        return false;
    }
}
