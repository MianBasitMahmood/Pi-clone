package com.chartboost.sdk.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.chartboost.sdk.Libraries.CBLogging;
import java.util.Observable;

public class ay extends Observable {
    private static ay f571c;
    private static C0226b f572d;
    private boolean f573a;
    private boolean f574b;
    private C0225a f575e;

    /* renamed from: com.chartboost.sdk.impl.ay.a */
    private class C0225a extends BroadcastReceiver {
        final /* synthetic */ ay f564a;

        public C0225a(ay ayVar) {
            this.f564a = ayVar;
        }

        public void onReceive(Context context, Intent intent) {
            ay a = ay.m871a();
            a.m872a(context);
            a.notifyObservers();
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ay.b */
    public enum C0226b {
        CONNECTION_UNKNOWN(-1),
        CONNECTION_ERROR(0),
        CONNECTION_WIFI(1),
        CONNECTION_MOBILE(2);
        
        private int f570e;

        private C0226b(int i) {
            this.f570e = i;
        }

        public final int m870a() {
            return this.f570e;
        }
    }

    static {
        f571c = null;
        f572d = C0226b.CONNECTION_UNKNOWN;
    }

    private ay() {
        this.f573a = true;
        this.f574b = false;
        this.f575e = null;
        this.f575e = new C0225a(this);
    }

    public static ay m871a() {
        if (f571c == null) {
            f571c = new ay();
        }
        return f571c;
    }

    public int m874b() {
        return f572d.m870a();
    }

    public void m872a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                m873a(false);
                f572d = C0226b.CONNECTION_ERROR;
                CBLogging.m97a("CBReachability", "NETWORK TYPE: NO Network");
                return;
            }
            m873a(true);
            if (activeNetworkInfo.getType() == 1) {
                f572d = C0226b.CONNECTION_WIFI;
                CBLogging.m97a("CBReachability", "NETWORK TYPE: TYPE_WIFI");
            } else if (activeNetworkInfo.getType() == 0) {
                f572d = C0226b.CONNECTION_MOBILE;
                CBLogging.m97a("CBReachability", "NETWORK TYPE: TYPE_MOBILE");
            }
        } catch (SecurityException e) {
            f572d = C0226b.CONNECTION_UNKNOWN;
            throw new SecurityException("Chartboost SDK requires 'android.permission.ACCESS_NETWORK_STATE' permission set in your AndroidManifest.xml");
        }
    }

    public void notifyObservers() {
        if (this.f573a) {
            setChanged();
            super.notifyObservers(this);
        }
    }

    public void m873a(boolean z) {
        this.f573a = z;
    }

    public boolean m878c() {
        return this.f573a;
    }

    public Intent m875b(Context context) {
        if (context == null || this.f574b) {
            return null;
        }
        m876b(true);
        CBLogging.m97a("CBReachability", "Network broadcast successfully registered");
        return context.registerReceiver(this.f575e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void m877c(Context context) {
        if (context != null && this.f574b) {
            context.unregisterReceiver(this.f575e);
            m876b(false);
            CBLogging.m97a("CBReachability", "Network broadcast successfully unregistered");
        }
    }

    public void m876b(boolean z) {
        this.f574b = z;
    }
}
