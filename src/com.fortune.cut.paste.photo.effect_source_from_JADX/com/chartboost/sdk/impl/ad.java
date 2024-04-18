package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import java.io.File;

public class ad {
    public static C0335m m580a(Context context, C0181z c0181z) {
        File file = new File(context.getCacheDir(), "volley");
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            str = new StringBuilder(String.valueOf(packageName)).append("/").append(context.getPackageManager().getPackageInfo(packageName, 0).versionCode).toString();
        } catch (NameNotFoundException e) {
        }
        if (c0181z == null) {
            if (VERSION.SDK_INT >= 9) {
                c0181z = new aa();
            } else {
                c0181z = new C0349x(AndroidHttpClient.newInstance(str));
            }
        }
        C0335m c0335m = new C0335m(new C0347w(file), new C0342u(c0181z));
        c0335m.m1354a();
        return c0335m;
    }

    public static C0335m m579a(Context context) {
        return m580a(context, null);
    }
}
