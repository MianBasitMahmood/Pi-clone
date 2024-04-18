package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jl.C1250e;
import com.google.android.gms.internal.ok.C1403a;

public class om extends jl<ok> {
    public om(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, null);
    }

    protected void m5715a(jt jtVar, C1250e c1250e) throws RemoteException {
        jtVar.m5123a((js) c1250e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), new Bundle());
    }

    public ok bH(IBinder iBinder) {
        return C1403a.bG(iBinder);
    }

    protected String bK() {
        return "com.google.android.gms.panorama.service.START";
    }

    protected String bL() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }

    public /* synthetic */ IInterface m5716l(IBinder iBinder) {
        return bH(iBinder);
    }
}
