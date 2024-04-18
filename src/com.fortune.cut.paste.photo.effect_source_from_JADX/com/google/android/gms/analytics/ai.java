package com.google.android.gms.analytics;

import android.content.Context;
import android.util.DisplayMetrics;

class ai implements C0379q {
    private static ai Cc;
    private static Object xO;
    private final Context mContext;

    static {
        xO = new Object();
    }

    protected ai(Context context) {
        this.mContext = context;
    }

    public static ai fl() {
        ai aiVar;
        synchronized (xO) {
            aiVar = Cc;
        }
        return aiVar;
    }

    public static void m1507y(Context context) {
        synchronized (xO) {
            if (Cc == null) {
                Cc = new ai(context);
            }
        }
    }

    public boolean ac(String str) {
        return "&sr".equals(str);
    }

    protected String fm() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
    }

    public String getValue(String str) {
        return (str != null && str.equals("&sr")) ? fm() : null;
    }
}
