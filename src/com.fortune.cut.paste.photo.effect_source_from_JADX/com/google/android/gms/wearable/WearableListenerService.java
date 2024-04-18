package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.ae.C1897a;
import com.google.android.gms.wearable.internal.ai;
import com.google.android.gms.wearable.internal.al;

public abstract class WearableListenerService extends Service implements DataListener, MessageListener, NodeListener {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    private String CS;
    private IBinder Nk;
    private volatile int Pj;
    private Handler axn;
    private Object axo;
    private boolean axp;

    /* renamed from: com.google.android.gms.wearable.WearableListenerService.a */
    private class C1898a extends C1897a {
        final /* synthetic */ WearableListenerService axq;

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.a.1 */
        class C18931 implements Runnable {
            final /* synthetic */ DataHolder axr;
            final /* synthetic */ C1898a axs;

            C18931(C1898a c1898a, DataHolder dataHolder) {
                this.axs = c1898a;
                this.axr = dataHolder;
            }

            public void run() {
                DataEventBuffer dataEventBuffer = new DataEventBuffer(this.axr);
                try {
                    this.axs.axq.onDataChanged(dataEventBuffer);
                } finally {
                    dataEventBuffer.release();
                }
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.a.2 */
        class C18942 implements Runnable {
            final /* synthetic */ C1898a axs;
            final /* synthetic */ ai axt;

            C18942(C1898a c1898a, ai aiVar) {
                this.axs = c1898a;
                this.axt = aiVar;
            }

            public void run() {
                this.axs.axq.onMessageReceived(this.axt);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.a.3 */
        class C18953 implements Runnable {
            final /* synthetic */ C1898a axs;
            final /* synthetic */ al axu;

            C18953(C1898a c1898a, al alVar) {
                this.axs = c1898a;
                this.axu = alVar;
            }

            public void run() {
                this.axs.axq.onPeerConnected(this.axu);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.a.4 */
        class C18964 implements Runnable {
            final /* synthetic */ C1898a axs;
            final /* synthetic */ al axu;

            C18964(C1898a c1898a, al alVar) {
                this.axs = c1898a;
                this.axu = alVar;
            }

            public void run() {
                this.axs.axq.onPeerDisconnected(this.axu);
            }
        }

        private C1898a(WearableListenerService wearableListenerService) {
            this.axq = wearableListenerService;
        }

        public void m6826a(ai aiVar) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onMessageReceived: " + aiVar);
            }
            this.axq.rl();
            synchronized (this.axq.axo) {
                if (this.axq.axp) {
                    return;
                }
                this.axq.axn.post(new C18942(this, aiVar));
            }
        }

        public void m6827a(al alVar) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerConnected: " + this.axq.CS + ": " + alVar);
            }
            this.axq.rl();
            synchronized (this.axq.axo) {
                if (this.axq.axp) {
                    return;
                }
                this.axq.axn.post(new C18953(this, alVar));
            }
        }

        public void aa(DataHolder dataHolder) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onDataItemChanged: " + this.axq.CS + ": " + dataHolder);
            }
            this.axq.rl();
            synchronized (this.axq.axo) {
                if (this.axq.axp) {
                    dataHolder.close();
                    return;
                }
                this.axq.axn.post(new C18931(this, dataHolder));
            }
        }

        public void m6828b(al alVar) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerDisconnected: " + this.axq.CS + ": " + alVar);
            }
            this.axq.rl();
            synchronized (this.axq.axo) {
                if (this.axq.axp) {
                    return;
                }
                this.axq.axn.post(new C18964(this, alVar));
            }
        }
    }

    public WearableListenerService() {
        this.Pj = -1;
        this.axo = new Object();
    }

    private boolean bh(int i) {
        String str = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE;
        String[] packagesForUid = getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    private void rl() throws SecurityException {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.Pj) {
            if (GooglePlayServicesUtil.m1782b(getPackageManager(), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE) && bh(callingUid)) {
                this.Pj = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    public final IBinder onBind(Intent intent) {
        return BIND_LISTENER_INTENT_ACTION.equals(intent.getAction()) ? this.Nk : null;
    }

    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onCreate: " + getPackageName());
        }
        this.CS = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.axn = new Handler(handlerThread.getLooper());
        this.Nk = new C1898a();
    }

    public void onDataChanged(DataEventBuffer dataEventBuffer) {
    }

    public void onDestroy() {
        synchronized (this.axo) {
            this.axp = true;
            this.axn.getLooper().quit();
        }
        super.onDestroy();
    }

    public void onMessageReceived(MessageEvent messageEvent) {
    }

    public void onPeerConnected(Node node) {
    }

    public void onPeerDisconnected(Node node) {
    }
}
