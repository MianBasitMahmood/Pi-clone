package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;

@ey
public class gb {
    private final Object mH;
    private final String vZ;
    private int wm;
    private long wn;
    private long wo;
    private int wp;
    private int wq;

    public gb(String str) {
        this.mH = new Object();
        this.wm = 0;
        this.wn = -1;
        this.wo = -1;
        this.wp = 0;
        this.wq = -1;
        this.vZ = str;
    }

    public static boolean m4704m(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            gr.m4771U("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            gr.m4771U("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (NameNotFoundException e) {
            gr.m4773W("Fail to fetch AdActivity theme");
            gr.m4771U("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public Bundle m4705b(Context context, String str) {
        Bundle bundle;
        synchronized (this.mH) {
            bundle = new Bundle();
            bundle.putString("session_id", this.vZ);
            bundle.putLong("basets", this.wo);
            bundle.putLong("currts", this.wn);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.wq);
            bundle.putInt("pclick", this.wm);
            bundle.putInt("pimp", this.wp);
            bundle.putBoolean("support_transparent_background", m4704m(context));
        }
        return bundle;
    }

    public void m4706b(av avVar, long j) {
        synchronized (this.mH) {
            if (this.wo == -1) {
                this.wo = j;
                this.wn = this.wo;
            } else {
                this.wn = j;
            }
            if (avVar.extras == null || avVar.extras.getInt("gw", 2) != 1) {
                this.wq++;
                return;
            }
        }
    }

    public void cW() {
        synchronized (this.mH) {
            this.wp++;
        }
    }

    public void cX() {
        synchronized (this.mH) {
            this.wm++;
        }
    }

    public long dq() {
        return this.wo;
    }
}
