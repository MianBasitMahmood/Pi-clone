package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.z */
class C1836z extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C0997a.DEVICE_ID.toString();
    }

    public C1836z(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public C1070a m6704B(Map<String, C1070a> map) {
        String Y = m6705Y(this.mContext);
        return Y == null ? di.rb() : di.m6618u(Y);
    }

    protected String m6705Y(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public boolean pe() {
        return true;
    }
}
