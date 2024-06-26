package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

class ay {
    private static String arH;
    static Map<String, String> arI;

    static {
        arI = new HashMap();
    }

    ay() {
    }

    static void cH(String str) {
        synchronized (ay.class) {
            arH = str;
        }
    }

    static void m6438d(Context context, String str) {
        cz.m6590a(context, "gtm_install_referrer", "referrer", str);
        m6441f(context, str);
    }

    static String m6439e(Context context, String str) {
        if (arH == null) {
            synchronized (ay.class) {
                if (arH == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    if (sharedPreferences != null) {
                        arH = sharedPreferences.getString("referrer", "");
                    } else {
                        arH = "";
                    }
                }
            }
        }
        return m6442w(arH, str);
    }

    static String m6440f(Context context, String str, String str2) {
        String str3 = (String) arI.get(str);
        if (str3 == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            str3 = sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
            arI.put(str, str3);
        }
        return m6442w(str3, str2);
    }

    static void m6441f(Context context, String str) {
        String w = m6442w(str, "conv");
        if (w != null && w.length() > 0) {
            arI.put(w, str);
            cz.m6590a(context, "gtm_click_referrers", w, str);
        }
    }

    static String m6442w(String str, String str2) {
        return str2 == null ? str.length() > 0 ? str : null : Uri.parse("http://hostname/?" + str).getQueryParameter(str2);
    }
}
