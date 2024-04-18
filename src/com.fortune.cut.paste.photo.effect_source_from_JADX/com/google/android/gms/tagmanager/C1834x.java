package com.google.android.gms.tagmanager;

import android.util.Log;

/* renamed from: com.google.android.gms.tagmanager.x */
class C1834x implements bi {
    private int yM;

    C1834x() {
        this.yM = 5;
    }

    public void m6696S(String str) {
        if (this.yM <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    public void m6697T(String str) {
        if (this.yM <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    public void m6698U(String str) {
        if (this.yM <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    public void m6699V(String str) {
        if (this.yM <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    public void m6700W(String str) {
        if (this.yM <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    public void m6701b(String str, Throwable th) {
        if (this.yM <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    public void m6702d(String str, Throwable th) {
        if (this.yM <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }

    public void setLogLevel(int i) {
        this.yM = i;
    }
}
