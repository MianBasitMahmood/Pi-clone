package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.eq.C1106a;

@ey
public final class eg extends C1106a implements ServiceConnection {
    private Context mContext;
    private eb sF;
    private String sM;
    private ef sQ;
    private boolean sW;
    private int sX;
    private Intent sY;

    public eg(Context context, String str, boolean z, int i, Intent intent, ef efVar) {
        this.sW = false;
        this.sM = str;
        this.sX = i;
        this.sY = intent;
        this.sW = z;
        this.mContext = context;
        this.sQ = efVar;
    }

    public final void finishPurchase() {
        int d = ei.m4514d(this.sY);
        if (this.sX == -1 && d == 0) {
            this.sF = new eb(this.mContext);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
            this.mContext.bindService(intent, this, 1);
        }
    }

    public final String getProductId() {
        return this.sM;
    }

    public final Intent getPurchaseData() {
        return this.sY;
    }

    public final int getResultCode() {
        return this.sX;
    }

    public final boolean isVerified() {
        return this.sW;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        gr.m4771U("In-app billing service connected.");
        this.sF.m4491t(iBinder);
        String E = ei.m4512E(ei.m4515e(this.sY));
        if (E != null) {
            if (this.sF.m4489c(this.mContext.getPackageName(), E) == 0) {
                eh.m4506j(this.mContext).m4508a(this.sQ);
            }
            this.mContext.unbindService(this);
            this.sF.destroy();
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        gr.m4771U("In-app billing service disconnected.");
        this.sF.destroy();
    }
}
