package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

class ca extends aj {
    private static final String ID;

    static {
        ID = C0997a.OS_VERSION.toString();
    }

    public ca() {
        super(ID, new String[0]);
    }

    public C1070a m6486B(Map<String, C1070a> map) {
        return di.m6618u(VERSION.RELEASE);
    }

    public boolean pe() {
        return true;
    }
}
