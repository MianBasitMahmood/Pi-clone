package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

class cj extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C0997a.RESOLUTION.toString();
    }

    public cj(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public C1070a m6513B(Map<String, C1070a> map) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        return di.m6618u(i + "x" + displayMetrics.heightPixels);
    }

    public boolean pe() {
        return true;
    }
}
