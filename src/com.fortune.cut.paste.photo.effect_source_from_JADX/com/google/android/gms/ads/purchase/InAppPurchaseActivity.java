package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.internal.eo;
import com.google.android.gms.internal.et;
import com.google.android.gms.internal.gr;

public final class InAppPurchaseActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.purchase.InAppPurchaseActivity";
    public static final String SIMPLE_CLASS_NAME = "InAppPurchaseActivity";
    private eo xz;

    protected final void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (this.xz != null) {
                this.xz.onActivityResult(i, i2, intent);
            }
        } catch (Throwable e) {
            gr.m4777d("Could not forward onActivityResult to in-app purchase manager:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.xz = et.m4533e(this);
        if (this.xz == null) {
            gr.m4773W("Could not create in-app purchase manager.");
            finish();
            return;
        }
        try {
            this.xz.onCreate();
        } catch (Throwable e) {
            gr.m4777d("Could not forward onCreate to in-app purchase manager:", e);
            finish();
        }
    }

    protected final void onDestroy() {
        try {
            if (this.xz != null) {
                this.xz.onDestroy();
            }
        } catch (Throwable e) {
            gr.m4777d("Could not forward onDestroy to in-app purchase manager:", e);
        }
        super.onDestroy();
    }
}
