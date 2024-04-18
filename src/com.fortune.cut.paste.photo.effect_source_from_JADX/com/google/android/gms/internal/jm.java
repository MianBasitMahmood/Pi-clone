package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.ArrayList;
import java.util.Iterator;

public final class jm {
    private final C0499b MX;
    private final ArrayList<ConnectionCallbacks> MY;
    final ArrayList<ConnectionCallbacks> MZ;
    private boolean Na;
    private final ArrayList<OnConnectionFailedListener> Nb;
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.jm.b */
    public interface C0499b {
        Bundle fX();

        boolean gN();

        boolean isConnected();
    }

    /* renamed from: com.google.android.gms.internal.jm.a */
    final class C1254a extends Handler {
        final /* synthetic */ jm Nc;

        public C1254a(jm jmVar, Looper looper) {
            this.Nc = jmVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                synchronized (this.Nc.MY) {
                    if (this.Nc.MX.gN() && this.Nc.MX.isConnected() && this.Nc.MY.contains(message.obj)) {
                        ((ConnectionCallbacks) message.obj).onConnected(this.Nc.MX.fX());
                    }
                }
                return;
            }
            Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
        }
    }

    public jm(Context context, Looper looper, C0499b c0499b) {
        this.MY = new ArrayList();
        this.MZ = new ArrayList();
        this.Na = false;
        this.Nb = new ArrayList();
        this.MX = c0499b;
        this.mHandler = new C1254a(this, looper);
    }

    public final void aE(int i) {
        this.mHandler.removeMessages(1);
        synchronized (this.MY) {
            this.Na = true;
            Iterator it = new ArrayList(this.MY).iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!this.MX.gN()) {
                    break;
                } else if (this.MY.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.Na = false;
        }
    }

    public final void m5097b(ConnectionResult connectionResult) {
        this.mHandler.removeMessages(1);
        synchronized (this.Nb) {
            Iterator it = new ArrayList(this.Nb).iterator();
            while (it.hasNext()) {
                OnConnectionFailedListener onConnectionFailedListener = (OnConnectionFailedListener) it.next();
                if (!this.MX.gN()) {
                    return;
                } else if (this.Nb.contains(onConnectionFailedListener)) {
                    onConnectionFailedListener.onConnectionFailed(connectionResult);
                }
            }
        }
    }

    protected final void dU() {
        synchronized (this.MY) {
            m5098f(this.MX.fX());
        }
    }

    public final void m5098f(Bundle bundle) {
        boolean z = true;
        synchronized (this.MY) {
            jx.m5215K(!this.Na);
            this.mHandler.removeMessages(1);
            this.Na = true;
            if (this.MZ.size() != 0) {
                z = false;
            }
            jx.m5215K(z);
            Iterator it = new ArrayList(this.MY).iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (this.MX.gN() && this.MX.isConnected()) {
                    if (!this.MZ.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnected(bundle);
                    }
                }
            }
            this.MZ.clear();
            this.Na = false;
        }
    }

    public final boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        jx.m5223i(connectionCallbacks);
        synchronized (this.MY) {
            contains = this.MY.contains(connectionCallbacks);
        }
        return contains;
    }

    public final boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        jx.m5223i(onConnectionFailedListener);
        synchronized (this.Nb) {
            contains = this.Nb.contains(onConnectionFailedListener);
        }
        return contains;
    }

    public final void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        jx.m5223i(connectionCallbacks);
        synchronized (this.MY) {
            if (this.MY.contains(connectionCallbacks)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + connectionCallbacks + " is already registered");
            } else {
                this.MY.add(connectionCallbacks);
            }
        }
        if (this.MX.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, connectionCallbacks));
        }
    }

    public final void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        jx.m5223i(onConnectionFailedListener);
        synchronized (this.Nb) {
            if (this.Nb.contains(onConnectionFailedListener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + onConnectionFailedListener + " is already registered");
            } else {
                this.Nb.add(onConnectionFailedListener);
            }
        }
    }

    public final void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        jx.m5223i(connectionCallbacks);
        synchronized (this.MY) {
            if (this.MY != null) {
                if (!this.MY.remove(connectionCallbacks)) {
                    Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + connectionCallbacks + " not found");
                } else if (this.Na) {
                    this.MZ.add(connectionCallbacks);
                }
            }
        }
    }

    public final void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        jx.m5223i(onConnectionFailedListener);
        synchronized (this.Nb) {
            if (!(this.Nb == null || this.Nb.remove(onConnectionFailedListener))) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + onConnectionFailedListener + " not found");
            }
        }
    }
}
