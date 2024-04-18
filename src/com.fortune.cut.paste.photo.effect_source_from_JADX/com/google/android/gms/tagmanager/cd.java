package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1022b;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

abstract class cd extends aj {
    private static final String arp;
    private static final String ask;

    static {
        arp = C1022b.ARG0.toString();
        ask = C1022b.ARG1.toString();
    }

    public cd(String str) {
        super(str, arp, ask);
    }

    public C1070a m6404B(Map<String, C1070a> map) {
        for (C1070a c1070a : map.values()) {
            if (c1070a == di.rb()) {
                return di.m6618u(Boolean.valueOf(false));
            }
        }
        C1070a c1070a2 = (C1070a) map.get(arp);
        C1070a c1070a3 = (C1070a) map.get(ask);
        boolean a = (c1070a2 == null || c1070a3 == null) ? false : m6405a(c1070a2, c1070a3, map);
        return di.m6618u(Boolean.valueOf(a));
    }

    protected abstract boolean m6405a(C1070a c1070a, C1070a c1070a2, Map<String, C1070a> map);

    public boolean pe() {
        return true;
    }
}
