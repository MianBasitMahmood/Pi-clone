package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0430b;
import com.google.android.gms.common.api.Api.C0489a;
import com.google.android.gms.common.api.Api.C0490c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;

public final class kc {
    public static final Api<NoOptions> API;
    public static final C0490c<kg> DQ;
    private static final C0430b<kg, NoOptions> DR;
    public static final kd Nu;

    /* renamed from: com.google.android.gms.internal.kc.1 */
    static class C12681 implements C0430b<kg, NoOptions> {
        C12681() {
        }

        public final /* synthetic */ C0489a m5243a(Context context, Looper looper, jg jgVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m5244c(context, looper, jgVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public final kg m5244c(Context context, Looper looper, jg jgVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new kg(context, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        }

        public final int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    static {
        DQ = new C0490c();
        DR = new C12681();
        API = new Api(DR, DQ, new Scope[0]);
        Nu = new ke();
    }
}
