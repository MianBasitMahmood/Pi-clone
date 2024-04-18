package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.g */
class C1803g extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C0997a.APP_NAME.toString();
    }

    public C1803g(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public C1070a m6643B(Map<String, C1070a> map) {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            return di.m6618u(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
        } catch (Throwable e) {
            bh.m6462b("App name is not found.", e);
            return di.rb();
        }
    }

    public boolean pe() {
        return true;
    }
}
