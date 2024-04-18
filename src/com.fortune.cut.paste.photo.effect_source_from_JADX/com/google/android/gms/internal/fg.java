package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.fl.C1149a;
import com.google.android.gms.internal.jl.C1250e;

@ey
public class fg extends jl<fl> {
    final int qg;

    public fg(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, context.getMainLooper(), connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.qg = i;
    }

    protected fl m4597B(IBinder iBinder) {
        return C1149a.m4608C(iBinder);
    }

    protected void m4598a(jt jtVar, C1250e c1250e) throws RemoteException {
        jtVar.m5145g(c1250e, this.qg, getContext().getPackageName(), new Bundle());
    }

    protected String bK() {
        return "com.google.android.gms.ads.service.START";
    }

    protected String bL() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public fl cL() throws DeadObjectException {
        return (fl) super.hw();
    }

    protected /* synthetic */ IInterface m4599l(IBinder iBinder) {
        return m4597B(iBinder);
    }
}
