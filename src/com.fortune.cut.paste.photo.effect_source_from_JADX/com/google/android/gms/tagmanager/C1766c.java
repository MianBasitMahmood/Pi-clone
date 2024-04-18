package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.c */
class C1766c extends aj {
    private static final String ID;
    private final C1756a aqc;

    static {
        ID = C0997a.ADVERTISING_TRACKING_ENABLED.toString();
    }

    public C1766c(Context context) {
        this(C1756a.m6396W(context));
    }

    C1766c(C1756a c1756a) {
        super(ID, new String[0]);
        this.aqc = c1756a;
    }

    public C1070a m6485B(Map<String, C1070a> map) {
        return di.m6618u(Boolean.valueOf(!this.aqc.isLimitAdTrackingEnabled()));
    }

    public boolean pe() {
        return false;
    }
}
