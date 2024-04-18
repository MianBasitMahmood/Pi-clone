package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

class ad extends dd {
    private static final String ID;

    static {
        ID = C0997a.ENDS_WITH.toString();
    }

    public ad() {
        super(ID);
    }

    protected boolean m6408a(String str, String str2, Map<String, C1070a> map) {
        return str.endsWith(str2);
    }
}
