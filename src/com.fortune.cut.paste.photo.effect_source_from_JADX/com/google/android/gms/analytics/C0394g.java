package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

/* renamed from: com.google.android.gms.analytics.g */
class C0394g implements C0379q {
    private static Object xO;
    private static C0394g ye;
    protected String ya;
    protected String yb;
    protected String yc;
    protected String yd;

    static {
        xO = new Object();
    }

    protected C0394g() {
    }

    private C0394g(Context context) {
        PackageManager packageManager = context.getPackageManager();
        this.yc = context.getPackageName();
        this.yd = packageManager.getInstallerPackageName(this.yc);
        String str = this.yc;
        String str2 = null;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                str = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
                str2 = packageInfo.versionName;
            }
        } catch (NameNotFoundException e) {
            ae.m1485T("Error retrieving package info: appName set to " + str);
        }
        this.ya = str;
        this.yb = str2;
    }

    public static C0394g dZ() {
        return ye;
    }

    public static void m1538y(Context context) {
        synchronized (xO) {
            if (ye == null) {
                ye = new C0394g(context);
            }
        }
    }

    public boolean ac(String str) {
        return "&an".equals(str) || "&av".equals(str) || "&aid".equals(str) || "&aiid".equals(str);
    }

    public String getValue(String str) {
        return str == null ? null : str.equals("&an") ? this.ya : str.equals("&av") ? this.yb : str.equals("&aid") ? this.yc : str.equals("&aiid") ? this.yd : null;
    }
}
