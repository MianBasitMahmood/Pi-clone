package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

@ey
public final class gg {
    public static void m4711a(Context context, boolean z) {
        Editor edit = m4712n(context).edit();
        edit.putBoolean("use_https", z);
        edit.commit();
    }

    private static SharedPreferences m4712n(Context context) {
        return context.getSharedPreferences("admob", 0);
    }

    public static boolean m4713o(Context context) {
        return m4712n(context).getBoolean("use_https", true);
    }
}
