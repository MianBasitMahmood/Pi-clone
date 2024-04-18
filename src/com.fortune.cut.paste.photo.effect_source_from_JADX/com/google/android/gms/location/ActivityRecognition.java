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
import com.google.android.gms.internal.nb;
import com.google.android.gms.internal.nk;

public class ActivityRecognition {
    public static final Api<NoOptions> API;
    public static ActivityRecognitionApi ActivityRecognitionApi = null;
    public static final String CLIENT_NAME = "activity_recognition";
    private static final C0490c<nk> DQ;
    private static final C0430b<nk, NoOptions> DR;

    /* renamed from: com.google.android.gms.location.ActivityRecognition.a */
    public static abstract class C1362a<R extends Result> extends C0435a<R, nk> {
        public C1362a(GoogleApiClient googleApiClient) {
            super(ActivityRecognition.DQ, googleApiClient);
        }
    }

    /* renamed from: com.google.android.gms.location.ActivityRecognition.1 */
    static class C15011 implements C0430b<nk, NoOptions> {
        C15011() {
        }

        public final /* synthetic */ C0489a m6080a(Context context, Looper looper, jg jgVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m6081e(context, looper, jgVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public final nk m6081e(Context context, Looper looper, jg jgVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new nk(context, looper, context.getPackageName(), connectionCallbacks, onConnectionFailedListener, ActivityRecognition.CLIENT_NAME);
        }

        public final int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    static {
        DQ = new C0490c();
        DR = new C15011();
        API = new Api(DR, DQ, new Scope[0]);
        ActivityRecognitionApi = new nb();
    }

    private ActivityRecognition() {
    }
}
