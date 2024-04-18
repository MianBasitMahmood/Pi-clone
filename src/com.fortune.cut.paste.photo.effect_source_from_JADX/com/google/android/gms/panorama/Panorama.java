package com.google.android.gms.panorama;

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
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.ol;
import com.google.android.gms.internal.om;

public final class Panorama {
    public static final Api<NoOptions> API;
    public static final C0490c<om> DQ;
    static final C0430b<om, NoOptions> DR;
    public static final PanoramaApi PanoramaApi;

    /* renamed from: com.google.android.gms.panorama.Panorama.1 */
    static class C16991 implements C0430b<om, NoOptions> {
        C16991() {
        }

        public final /* synthetic */ C0489a m6251a(Context context, Looper looper, jg jgVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m6252f(context, looper, jgVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public final om m6252f(Context context, Looper looper, jg jgVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new om(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public final int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    static {
        DQ = new C0490c();
        DR = new C16991();
        API = new Api(DR, DQ, new Scope[0]);
        PanoramaApi = new ol();
    }

    private Panorama() {
    }
}
