package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.f */
class C1802f extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C0997a.APP_ID.toString();
    }

    public C1802f(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public C1070a m6642B(Map<String, C1070a> map) {
        return di.m6618u(this.mContext.getPackageName());
    }

    public boolean pe() {
        return true;
    }
}
