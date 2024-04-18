package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1022b;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.m */
class C1811m extends aj {
    private static final String ID;
    private static final String VALUE;

    static {
        ID = C0997a.CONSTANT.toString();
        VALUE = C1022b.VALUE.toString();
    }

    public C1811m() {
        super(ID, VALUE);
    }

    public static String ph() {
        return ID;
    }

    public static String pi() {
        return VALUE;
    }

    public C1070a m6648B(Map<String, C1070a> map) {
        return (C1070a) map.get(VALUE);
    }

    public boolean pe() {
        return true;
    }
}
