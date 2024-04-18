package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

class dc extends dd {
    private static final String ID;

    static {
        ID = C0997a.STARTS_WITH.toString();
    }

    public dc() {
        super(ID);
    }

    protected boolean m6600a(String str, String str2, Map<String, C1070a> map) {
        return str.startsWith(str2);
    }
}
