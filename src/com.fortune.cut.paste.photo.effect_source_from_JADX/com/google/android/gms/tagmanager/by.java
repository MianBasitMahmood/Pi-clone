package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

abstract class by extends cd {
    public by(String str) {
        super(str);
    }

    protected boolean m6416a(C1070a c1070a, C1070a c1070a2, Map<String, C1070a> map) {
        dh k = di.m6608k(c1070a);
        dh k2 = di.m6608k(c1070a2);
        return (k == di.qZ() || k2 == di.qZ()) ? false : m6417a(k, k2, (Map) map);
    }

    protected abstract boolean m6417a(dh dhVar, dh dhVar2, Map<String, C1070a> map);
}
