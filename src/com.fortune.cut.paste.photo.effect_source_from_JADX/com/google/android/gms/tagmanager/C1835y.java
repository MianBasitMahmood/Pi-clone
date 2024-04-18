package com.google.android.gms.tagmanager;

import android.content.Context;
import java.net.URLEncoder;

/* renamed from: com.google.android.gms.tagmanager.y */
class C1835y implements aq {
    private static C1835y arl;
    private static final Object xO;
    private cg aqC;
    private String arm;
    private String arn;
    private ar aro;

    static {
        xO = new Object();
    }

    private C1835y(Context context) {
        this(as.m6424Z(context), new cw());
    }

    C1835y(ar arVar, cg cgVar) {
        this.aro = arVar;
        this.aqC = cgVar;
    }

    public static aq m6703X(Context context) {
        aq aqVar;
        synchronized (xO) {
            if (arl == null) {
                arl = new C1835y(context);
            }
            aqVar = arl;
        }
        return aqVar;
    }

    public boolean cB(String str) {
        if (this.aqC.fe()) {
            if (!(this.arm == null || this.arn == null)) {
                try {
                    str = this.arm + "?" + this.arn + "=" + URLEncoder.encode(str, "UTF-8");
                    bh.m6460V("Sending wrapped url hit: " + str);
                } catch (Throwable e) {
                    bh.m6463d("Error wrapping URL for testing.", e);
                    return false;
                }
            }
            this.aro.cE(str);
            return true;
        }
        bh.m6461W("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return false;
    }
}
