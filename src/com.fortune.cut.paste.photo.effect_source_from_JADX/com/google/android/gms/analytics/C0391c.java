package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.C1185a;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.c */
class C0391c implements C0387b {
    private Context mContext;
    private ServiceConnection xV;
    private C0389b xW;
    private C0390c xX;
    private hb xY;

    /* renamed from: com.google.android.gms.analytics.c.a */
    final class C0388a implements ServiceConnection {
        final /* synthetic */ C0391c xZ;

        C0388a(C0391c c0391c) {
            this.xZ = c0391c;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ae.m1487V("service connected, binder: " + iBinder);
            try {
                if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(iBinder.getInterfaceDescriptor())) {
                    ae.m1487V("bound to service");
                    this.xZ.xY = C1185a.m4829D(iBinder);
                    this.xZ.dU();
                    return;
                }
            } catch (RemoteException e) {
            }
            try {
                this.xZ.mContext.unbindService(this);
            } catch (IllegalArgumentException e2) {
            }
            this.xZ.xV = null;
            this.xZ.xX.m1528a(2, null);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            ae.m1487V("service disconnected: " + componentName);
            this.xZ.xV = null;
            this.xZ.xW.onDisconnected();
        }
    }

    /* renamed from: com.google.android.gms.analytics.c.b */
    public interface C0389b {
        void onConnected();

        void onDisconnected();
    }

    /* renamed from: com.google.android.gms.analytics.c.c */
    public interface C0390c {
        void m1528a(int i, Intent intent);
    }

    public C0391c(Context context, C0389b c0389b, C0390c c0390c) {
        this.mContext = context;
        if (c0389b == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.xW = c0389b;
        if (c0390c == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.xX = c0390c;
    }

    private hb dR() {
        dS();
        return this.xY;
    }

    private void dT() {
        dU();
    }

    private void dU() {
        this.xW.onConnected();
    }

    public void m1535a(Map<String, String> map, long j, String str, List<ha> list) {
        try {
            dR().m4827a(map, j, str, list);
        } catch (RemoteException e) {
            ae.m1485T("sendHit failed: " + e);
        }
    }

    public void connect() {
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.analytics.service.AnalyticsService"));
        intent.putExtra("app_package_name", this.mContext.getPackageName());
        if (this.xV != null) {
            ae.m1485T("Calling connect() while still connected, missing disconnect().");
            return;
        }
        this.xV = new C0388a(this);
        boolean bindService = this.mContext.bindService(intent, this.xV, 129);
        ae.m1487V("connect: bindService returned " + bindService + " for " + intent);
        if (!bindService) {
            this.xV = null;
            this.xX.m1528a(1, null);
        }
    }

    public void dQ() {
        try {
            dR().dQ();
        } catch (RemoteException e) {
            ae.m1485T("clear hits failed: " + e);
        }
    }

    protected void dS() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void disconnect() {
        this.xY = null;
        if (this.xV != null) {
            try {
                this.mContext.unbindService(this.xV);
            } catch (IllegalStateException e) {
            } catch (IllegalArgumentException e2) {
            }
            this.xV = null;
            this.xW.onDisconnected();
        }
    }

    public boolean isConnected() {
        return this.xY != null;
    }
}
