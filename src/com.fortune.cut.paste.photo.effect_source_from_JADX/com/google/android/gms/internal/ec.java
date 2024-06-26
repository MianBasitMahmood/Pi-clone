package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.List;

@ey
public class ec extends gf implements ServiceConnection {
    private Context mContext;
    private final Object mH;
    private boolean sD;
    private er sE;
    private eb sF;
    private eh sG;
    private List<ef> sH;
    private ek sI;

    /* renamed from: com.google.android.gms.internal.ec.1 */
    class C11031 implements Runnable {
        final /* synthetic */ ef sJ;
        final /* synthetic */ Intent sK;
        final /* synthetic */ ec sL;

        C11031(ec ecVar, ef efVar, Intent intent) {
            this.sL = ecVar;
            this.sJ = efVar;
            this.sK = intent;
        }

        public void run() {
            try {
                if (this.sL.sI.m4518a(this.sJ.sU, -1, this.sK)) {
                    this.sL.sE.m4528a(new eg(this.sL.mContext, this.sJ.sV, true, -1, this.sK, this.sJ));
                } else {
                    this.sL.sE.m4528a(new eg(this.sL.mContext, this.sJ.sV, false, -1, this.sK, this.sJ));
                }
            } catch (RemoteException e) {
                gr.m4773W("Fail to verify and dispatch pending transaction");
            }
        }
    }

    public ec(Context context, er erVar, ek ekVar) {
        this.mH = new Object();
        this.sD = false;
        this.sH = null;
        this.mContext = context;
        this.sE = erVar;
        this.sI = ekVar;
        this.sF = new eb(context);
        this.sG = eh.m4506j(this.mContext);
        this.sH = this.sG.m4510d(10);
    }

    private void m4494a(ef efVar, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("RESPONSE_CODE", 0);
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        gq.wR.post(new C11031(this, efVar, intent));
    }

    private void m4496b(long j) {
        do {
            if (!m4498c(j)) {
                gr.m4773W("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.sD);
    }

    private boolean m4498c(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.mH.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            gr.m4773W("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cy() {
        /*
        r12 = this;
        r0 = r12.sH;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r6 = new java.util.HashMap;
        r6.<init>();
        r0 = r12.sH;
        r1 = r0.iterator();
    L_0x0014:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0026;
    L_0x001a:
        r0 = r1.next();
        r0 = (com.google.android.gms.internal.ef) r0;
        r2 = r0.sV;
        r6.put(r2, r0);
        goto L_0x0014;
    L_0x0026:
        r0 = 0;
    L_0x0027:
        r1 = r12.sF;
        r2 = r12.mContext;
        r2 = r2.getPackageName();
        r0 = r1.m4490d(r2, r0);
        if (r0 == 0) goto L_0x009b;
    L_0x0035:
        r1 = com.google.android.gms.internal.ei.m4513b(r0);
        if (r1 != 0) goto L_0x009b;
    L_0x003b:
        r1 = "INAPP_PURCHASE_ITEM_LIST";
        r7 = r0.getStringArrayList(r1);
        r1 = "INAPP_PURCHASE_DATA_LIST";
        r8 = r0.getStringArrayList(r1);
        r1 = "INAPP_DATA_SIGNATURE_LIST";
        r9 = r0.getStringArrayList(r1);
        r1 = "INAPP_CONTINUATION_TOKEN";
        r5 = r0.getString(r1);
        r0 = 0;
        r4 = r0;
    L_0x0055:
        r0 = r7.size();
        if (r4 >= r0) goto L_0x0093;
    L_0x005b:
        r0 = r7.get(r4);
        r0 = r6.containsKey(r0);
        if (r0 == 0) goto L_0x008f;
    L_0x0065:
        r0 = r7.get(r4);
        r0 = (java.lang.String) r0;
        r1 = r8.get(r4);
        r1 = (java.lang.String) r1;
        r2 = r9.get(r4);
        r2 = (java.lang.String) r2;
        r3 = r6.get(r0);
        r3 = (com.google.android.gms.internal.ef) r3;
        r10 = com.google.android.gms.internal.ei.m4511D(r1);
        r11 = r3.sU;
        r10 = r11.equals(r10);
        if (r10 == 0) goto L_0x008f;
    L_0x0089:
        r12.m4494a(r3, r1, r2);
        r6.remove(r0);
    L_0x008f:
        r0 = r4 + 1;
        r4 = r0;
        goto L_0x0055;
    L_0x0093:
        if (r5 == 0) goto L_0x009b;
    L_0x0095:
        r0 = r6.isEmpty();
        if (r0 == 0) goto L_0x00bb;
    L_0x009b:
        r0 = r6.keySet();
        r1 = r0.iterator();
    L_0x00a3:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0008;
    L_0x00a9:
        r0 = r1.next();
        r0 = (java.lang.String) r0;
        r2 = r12.sG;
        r0 = r6.get(r0);
        r0 = (com.google.android.gms.internal.ef) r0;
        r2.m4508a(r0);
        goto L_0x00a3;
    L_0x00bb:
        r0 = r5;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ec.cy():void");
    }

    public void cx() {
        synchronized (this.mH) {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
            this.mContext.bindService(intent, this, 1);
            m4496b(SystemClock.elapsedRealtime());
            this.mContext.unbindService(this);
            this.sF.destroy();
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.mH) {
            this.sF.m4491t(iBinder);
            cy();
            this.sD = true;
            this.mH.notify();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        gr.m4771U("In-app billing service disconnected.");
        this.sF.destroy();
    }

    public void onStop() {
        synchronized (this.mH) {
            this.mContext.unbindService(this);
            this.sF.destroy();
        }
    }
}
