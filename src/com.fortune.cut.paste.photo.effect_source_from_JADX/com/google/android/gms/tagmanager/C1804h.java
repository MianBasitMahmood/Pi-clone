package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.h */
class C1804h extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C0997a.APP_VERSION.toString();
    }

    public C1804h(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public C1070a m6644B(Map<String, C1070a> map) {
        try {
            return di.m6618u(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
        } catch (NameNotFoundException e) {
            bh.m6458T("Package name " + this.mContext.getPackageName() + " not found. " + e.getMessage());
            return di.rb();
        }
    }

    public boolean pe() {
        return true;
    }
}
