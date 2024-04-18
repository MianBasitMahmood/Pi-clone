package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

abstract class dd extends cd {
    public dd(String str) {
        super(str);
    }

    protected boolean m6406a(C1070a c1070a, C1070a c1070a2, Map<String, C1070a> map) {
        String j = di.m6607j(c1070a);
        String j2 = di.m6607j(c1070a2);
        return (j == di.ra() || j2 == di.ra()) ? false : m6407a(j, j2, (Map) map);
    }

    protected abstract boolean m6407a(String str, String str2, Map<String, C1070a> map);
}
