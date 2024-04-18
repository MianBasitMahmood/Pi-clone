package com.google.android.gms.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchaseActivity;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.eo.C1105a;
import com.google.android.gms.location.LocationStatusCodes;

@ey
public class ee extends C1105a implements ServiceConnection {
    private final Activity nB;
    private eb sF;
    private final eh sG;
    private ek sI;
    private Context sO;
    private em sP;
    private ef sQ;
    private ej sR;
    private String sS;

    public ee(Activity activity) {
        this.sS = null;
        this.nB = activity;
        this.sG = eh.m4506j(this.nB.getApplicationContext());
    }

    public static void m4503a(Context context, boolean z, ea eaVar) {
        Intent intent = new Intent();
        intent.setClassName(context, InAppPurchaseActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", z);
        ea.m4486a(intent, eaVar);
        context.startActivity(intent);
    }

    private void m4504a(String str, boolean z, int i, Intent intent) {
        if (this.sR != null) {
            this.sR.m4517a(str, z, i, intent, this.sQ);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES) {
            boolean z = false;
            try {
                int d = ei.m4514d(intent);
                if (i2 != -1 || d != 0) {
                    this.sG.m4508a(this.sQ);
                } else if (this.sI.m4518a(this.sS, i2, intent)) {
                    z = true;
                }
                this.sP.recordPlayBillingResolution(d);
                this.nB.finish();
                m4504a(this.sP.getProductId(), z, i2, intent);
            } catch (RemoteException e) {
                gr.m4773W("Fail to process purchase result.");
                this.nB.finish();
            } finally {
                this.sS = null;
            }
        }
    }

    public void onCreate() {
        ea c = ea.m4487c(this.nB.getIntent());
        this.sR = c.sB;
        this.sI = c.md;
        this.sP = c.sz;
        this.sF = new eb(this.nB.getApplicationContext());
        this.sO = c.sA;
        if (this.nB.getResources().getConfiguration().orientation == 2) {
            this.nB.setRequestedOrientation(6);
        } else {
            this.nB.setRequestedOrientation(7);
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        this.nB.bindService(intent, this, 1);
    }

    public void onDestroy() {
        this.nB.unbindService(this);
        this.sF.destroy();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Throwable e;
        this.sF.m4491t(iBinder);
        try {
            this.sS = this.sI.cC();
            Bundle a = this.sF.m4488a(this.nB.getPackageName(), this.sP.getProductId(), this.sS);
            PendingIntent pendingIntent = (PendingIntent) a.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int b = ei.m4513b(a);
                this.sP.recordPlayBillingResolution(b);
                m4504a(this.sP.getProductId(), false, b, null);
                this.nB.finish();
                return;
            }
            this.sQ = new ef(this.sP.getProductId(), this.sS);
            this.sG.m4509b(this.sQ);
            this.nB.startIntentSenderForResult(pendingIntent.getIntentSender(), LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        } catch (RemoteException e2) {
            e = e2;
            gr.m4777d("Error when connecting in-app billing service", e);
            this.nB.finish();
        } catch (SendIntentException e3) {
            e = e3;
            gr.m4777d("Error when connecting in-app billing service", e);
            this.nB.finish();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        gr.m4771U("In-app billing service disconnected.");
        this.sF.destroy();
    }
}
