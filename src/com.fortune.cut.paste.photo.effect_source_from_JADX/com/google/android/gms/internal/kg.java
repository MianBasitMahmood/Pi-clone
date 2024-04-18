package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jl.C1250e;
import com.google.android.gms.internal.ki.C1274a;

public class kg extends jl<ki> {
    public kg(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
    }

    protected ki m5251T(IBinder iBinder) {
        return C1274a.m5256V(iBinder);
    }

    protected void m5252a(jt jtVar, C1250e c1250e) throws RemoteException {
        jtVar.m5150j(c1250e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    public String bK() {
        return "com.google.android.gms.common.service.START";
    }

    protected String bL() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }

    protected /* synthetic */ IInterface m5253l(IBinder iBinder) {
        return m5251T(iBinder);
    }
}
