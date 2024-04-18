package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

class cv extends aj {
    private static final String ID;

    static {
        ID = C0997a.SDK_VERSION.toString();
    }

    public cv() {
        super(ID, new String[0]);
    }

    public C1070a m6579B(Map<String, C1070a> map) {
        return di.m6618u(Integer.valueOf(VERSION.SDK_INT));
    }

    public boolean pe() {
        return true;
    }
}
