package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

class cc extends aj {
    private static final String ID;
    private static final C1070a asj;

    static {
        ID = C0997a.PLATFORM.toString();
        asj = di.m6618u("Android");
    }

    public cc() {
        super(ID, new String[0]);
    }

    public C1070a m6507B(Map<String, C1070a> map) {
        return asj;
    }

    public boolean pe() {
        return true;
    }
}
