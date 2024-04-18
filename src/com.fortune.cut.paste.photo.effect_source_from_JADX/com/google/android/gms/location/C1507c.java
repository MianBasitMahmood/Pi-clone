package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.nk;

@Deprecated
/* renamed from: com.google.android.gms.location.c */
public class C1507c implements GooglePlayServicesClient {
    private final nk agq;

    /* renamed from: com.google.android.gms.location.c.a */
    public interface C1376a {
        void m5563a(int i, String[] strArr);
    }

    /* renamed from: com.google.android.gms.location.c.b */
    public interface C1380b {
        void m5569a(int i, PendingIntent pendingIntent);

        void m5570b(int i, String[] strArr);
    }

    public void connect() {
        this.agq.connect();
    }

    public void disconnect() {
        this.agq.disconnect();
    }

    public boolean isConnected() {
        return this.agq.isConnected();
    }

    public boolean isConnecting() {
        return this.agq.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks) {
        return this.agq.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener) {
        return this.agq.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    public void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        this.agq.registerConnectionCallbacks(connectionCallbacks);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        this.agq.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        this.agq.unregisterConnectionCallbacks(connectionCallbacks);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        this.agq.unregisterConnectionFailedListener(onConnectionFailedListener);
    }
}
