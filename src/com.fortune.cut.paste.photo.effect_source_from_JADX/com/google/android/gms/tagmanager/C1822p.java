package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.p */
class C1822p extends aj {
    private static final String ID;
    private final String TU;

    static {
        ID = C0997a.CONTAINER_VERSION.toString();
    }

    public C1822p(String str) {
        super(ID, new String[0]);
        this.TU = str;
    }

    public C1070a m6673B(Map<String, C1070a> map) {
        return this.TU == null ? di.rb() : di.m6618u(this.TU);
    }

    public boolean pe() {
        return true;
    }
}
