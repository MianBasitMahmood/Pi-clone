package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.cm.C1061a;
import com.google.android.gms.internal.jl.C1250e;

@ey
public class cl extends jl<cm> {
    final int qg;

    public cl(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, context.getMainLooper(), connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.qg = i;
    }

    protected void m4357a(jt jtVar, C1250e c1250e) throws RemoteException {
        jtVar.m5145g(c1250e, this.qg, getContext().getPackageName(), new Bundle());
    }

    protected String bK() {
        return "com.google.android.gms.ads.gservice.START";
    }

    protected String bL() {
        return "com.google.android.gms.ads.internal.gservice.IGservicesValueService";
    }

    public cm bM() throws DeadObjectException {
        return (cm) super.hw();
    }

    protected cm m4358k(IBinder iBinder) {
        return C1061a.m4360m(iBinder);
    }

    protected /* synthetic */ IInterface m4359l(IBinder iBinder) {
        return m4358k(iBinder);
    }
}
