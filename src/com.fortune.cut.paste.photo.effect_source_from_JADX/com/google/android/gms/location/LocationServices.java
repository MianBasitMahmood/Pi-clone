package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0430b;
import com.google.android.gms.common.api.Api.C0489a;
import com.google.android.gms.common.api.Api.C0490c;
import com.google.android.gms.common.api.BaseImplementation.C0435a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.nf;
import com.google.android.gms.internal.ng;
import com.google.android.gms.internal.nk;

public class LocationServices {
    public static final Api<NoOptions> API;
    private static final C0490c<nk> DQ;
    private static final C0430b<nk, NoOptions> DR;
    public static FusedLocationProviderApi FusedLocationApi;
    public static GeofencingApi GeofencingApi;

    /* renamed from: com.google.android.gms.location.LocationServices.a */
    public static abstract class C1367a<R extends Result> extends C0435a<R, nk> {
        public C1367a(GoogleApiClient googleApiClient) {
            super(LocationServices.DQ, googleApiClient);
        }
    }

    /* renamed from: com.google.android.gms.location.LocationServices.1 */
    static class C15041 implements C0430b<nk, NoOptions> {
        C15041() {
        }

        public final /* synthetic */ C0489a m6089a(Context context, Looper looper, jg jgVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m6090e(context, looper, jgVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public final nk m6090e(Context context, Looper looper, jg jgVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new nk(context, looper, context.getPackageName(), connectionCallbacks, onConnectionFailedListener, "locationServices", jgVar.getAccountName());
        }

        public final int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    static {
        DQ = new C0490c();
        DR = new C15041();
        API = new Api(DR, DQ, new Scope[0]);
        FusedLocationApi = new nf();
        GeofencingApi = new ng();
    }

    private LocationServices() {
    }

    public static nk m6091f(GoogleApiClient googleApiClient) {
        boolean z = true;
        jx.m5221b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        nk nkVar = (nk) googleApiClient.m1803a(DQ);
        if (nkVar == null) {
            z = false;
        }
        jx.m5217a(z, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return nkVar;
    }
}
