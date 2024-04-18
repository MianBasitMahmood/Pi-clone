package com.google.android.gms.analytics;

import android.util.Log;

/* renamed from: com.google.android.gms.analytics.p */
class C0404p implements Logger {
    private int yM;

    C0404p() {
        this.yM = 2;
    }

    private String af(String str) {
        return Thread.currentThread().toString() + ": " + str;
    }

    public void error(Exception exception) {
        if (this.yM <= 3) {
            Log.e("GAV4", null, exception);
        }
    }

    public void error(String str) {
        if (this.yM <= 3) {
            Log.e("GAV4", af(str));
        }
    }

    public int getLogLevel() {
        return this.yM;
    }

    public void info(String str) {
        if (this.yM <= 1) {
            Log.i("GAV4", af(str));
        }
    }

    public void setLogLevel(int i) {
        this.yM = i;
    }

    public void verbose(String str) {
        if (this.yM <= 0) {
            Log.v("GAV4", af(str));
        }
    }

    public void warn(String str) {
        if (this.yM <= 2) {
            Log.w("GAV4", af(str));
        }
    }
}
