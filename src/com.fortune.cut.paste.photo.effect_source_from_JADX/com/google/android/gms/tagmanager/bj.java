package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1022b;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

class bj extends aj {
    private static final String ID;
    private static final String arp;

    static {
        ID = C0997a.LOWERCASE_STRING.toString();
        arp = C1022b.ARG0.toString();
    }

    public bj() {
        super(ID, arp);
    }

    public C1070a m6471B(Map<String, C1070a> map) {
        return di.m6618u(di.m6607j((C1070a) map.get(arp)).toLowerCase());
    }

    public boolean pe() {
        return true;
    }
}
