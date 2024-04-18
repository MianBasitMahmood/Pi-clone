package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.q */
class C1823q extends dd {
    private static final String ID;

    static {
        ID = C0997a.CONTAINS.toString();
    }

    public C1823q() {
        super(ID);
    }

    protected boolean m6674a(String str, String str2, Map<String, C1070a> map) {
        return str.contains(str2);
    }
}
