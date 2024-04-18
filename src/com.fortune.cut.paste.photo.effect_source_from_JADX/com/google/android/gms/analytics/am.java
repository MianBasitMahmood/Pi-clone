package com.google.android.gms.analytics;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

class am implements C0381m {
    int CA;
    Map<String, String> CB;
    String Cv;
    double Cw;
    int Cx;
    int Cy;
    int Cz;

    am() {
        this.Cw = -1.0d;
        this.Cx = -1;
        this.Cy = -1;
        this.Cz = -1;
        this.CA = -1;
        this.CB = new HashMap();
    }

    public String am(String str) {
        String str2 = (String) this.CB.get(str);
        return str2 != null ? str2 : str;
    }

    public boolean fA() {
        return this.Cz != -1;
    }

    public boolean fB() {
        return this.Cz == 1;
    }

    public boolean fC() {
        return this.CA == 1;
    }

    public boolean ft() {
        return this.Cv != null;
    }

    public String fu() {
        return this.Cv;
    }

    public boolean fv() {
        return this.Cw >= 0.0d;
    }

    public double fw() {
        return this.Cw;
    }

    public boolean fx() {
        return this.Cx >= 0;
    }

    public boolean fy() {
        return this.Cy != -1;
    }

    public boolean fz() {
        return this.Cy == 1;
    }

    public int getSessionTimeout() {
        return this.Cx;
    }

    public String m1520k(Activity activity) {
        return am(activity.getClass().getCanonicalName());
    }
}
