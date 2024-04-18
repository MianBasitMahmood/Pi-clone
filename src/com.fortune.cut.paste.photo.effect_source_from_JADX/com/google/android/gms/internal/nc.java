package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jl.C1250e;
import com.google.android.gms.internal.ni.C1388a;

public class nc extends jl<ni> {
    protected final np<ni> Ee;
    private final String agD;

    /* renamed from: com.google.android.gms.internal.nc.1 */
    class C13661 implements np<ni> {
        final /* synthetic */ nc agE;

        C13661(nc ncVar) {
            this.agE = ncVar;
        }

        public void dS() {
            this.agE.dS();
        }

        public /* synthetic */ IInterface hw() throws DeadObjectException {
            return nh();
        }

        public ni nh() throws DeadObjectException {
            return (ni) this.agE.hw();
        }
    }

    public nc(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.Ee = new C13661(this);
        this.agD = str;
    }

    protected void m5544a(jt jtVar, C1250e c1250e) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.agD);
        jtVar.m5141e(c1250e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), bundle);
    }

    protected ni aM(IBinder iBinder) {
        return C1388a.aO(iBinder);
    }

    protected String bK() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected String bL() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    protected /* synthetic */ IInterface m5545l(IBinder iBinder) {
        return aM(iBinder);
    }
}
