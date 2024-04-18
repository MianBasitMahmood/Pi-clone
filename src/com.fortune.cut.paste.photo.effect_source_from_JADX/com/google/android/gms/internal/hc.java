package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0430b;
import com.google.android.gms.common.api.Api.C0490c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;

public final class hc {
    public static final C0490c<hx> CG;
    private static final C0430b<hx, NoOptions> CH;
    public static final Api<NoOptions> CI;
    public static final ht CJ;

    /* renamed from: com.google.android.gms.internal.hc.1 */
    static class C11861 implements C0430b<hx, NoOptions> {
        C11861() {
        }

        public final hx m4831a(Context context, Looper looper, jg jgVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new hx(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public final int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    static {
        CG = new C0490c();
        CH = new C11861();
        CI = new Api(CH, CG, new Scope[0]);
        CJ = new hz();
    }
}
