package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.op.C1410a;

public class ou implements ConnectionCallbacks, OnConnectionFailedListener {
    private ox amU;
    private final C1410a ane;
    private boolean anf;

    public ou(C1410a c1410a) {
        this.ane = c1410a;
        this.amU = null;
        this.anf = true;
    }

    public void m5731T(boolean z) {
        this.anf = z;
    }

    public void m5732a(ox oxVar) {
        this.amU = oxVar;
    }

    public void onConnected(Bundle bundle) {
        this.amU.m5736U(false);
        if (this.anf && this.ane != null) {
            this.ane.on();
        }
        this.anf = false;
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.amU.m5736U(true);
        if (this.anf && this.ane != null) {
            if (connectionResult.hasResolution()) {
                this.ane.m5717d(connectionResult.getResolution());
            } else {
                this.ane.oo();
            }
        }
        this.anf = false;
    }

    public void onDisconnected() {
        this.amU.m5736U(true);
    }
}
