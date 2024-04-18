package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.b */
class C1760b extends aj {
    private static final String ID;
    private final C1756a aqc;

    static {
        ID = C0997a.ADVERTISER_ID.toString();
    }

    public C1760b(Context context) {
        this(C1756a.m6396W(context));
    }

    C1760b(C1756a c1756a) {
        super(ID, new String[0]);
        this.aqc = c1756a;
    }

    public C1070a m6447B(Map<String, C1070a> map) {
        String pa = this.aqc.pa();
        return pa == null ? di.rb() : di.m6618u(pa);
    }

    public boolean pe() {
        return false;
    }
}
