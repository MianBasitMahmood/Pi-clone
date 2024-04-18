package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;

public class is {
    private static boolean HN;
    private boolean HO;
    private boolean HP;
    private String HQ;
    protected final String mTag;

    static {
        HN = false;
    }

    public is(String str) {
        this(str, go());
    }

    public is(String str, boolean z) {
        this.mTag = str;
        this.HO = z;
        this.HP = false;
    }

    public static boolean go() {
        return HN;
    }

    public void m5048a(String str, Object... objArr) {
        if (gn()) {
            Log.v(this.mTag, m5053e(str, objArr));
        }
    }

    public void m5049a(Throwable th, String str, Object... objArr) {
        if (gm() || HN) {
            Log.d(this.mTag, m5053e(str, objArr), th);
        }
    }

    public void aK(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = null;
        } else {
            str2 = String.format("[%s] ", new Object[]{str});
        }
        this.HQ = str2;
    }

    public void m5050b(String str, Object... objArr) {
        if (gm() || HN) {
            Log.d(this.mTag, m5053e(str, objArr));
        }
    }

    public void m5051c(String str, Object... objArr) {
        Log.i(this.mTag, m5053e(str, objArr));
    }

    public void m5052d(String str, Object... objArr) {
        Log.w(this.mTag, m5053e(str, objArr));
    }

    protected String m5053e(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        return !TextUtils.isEmpty(this.HQ) ? this.HQ + str : str;
    }

    public boolean gm() {
        return this.HO;
    }

    public boolean gn() {
        return this.HP;
    }
}
