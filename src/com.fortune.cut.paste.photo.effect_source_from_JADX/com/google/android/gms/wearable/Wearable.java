package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.C0430b;
import com.google.android.gms.common.api.Api.C0490c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import com.google.android.gms.wearable.internal.C1940e;
import com.google.android.gms.wearable.internal.C1953f;
import com.google.android.gms.wearable.internal.ah;
import com.google.android.gms.wearable.internal.ak;
import com.google.android.gms.wearable.internal.ay;
import com.google.android.gms.wearable.internal.ba;

public class Wearable {
    public static final Api<WearableOptions> API;
    public static final C0490c<ba> DQ;
    private static final C0430b<ba, WearableOptions> DR;
    public static final DataApi DataApi;
    public static final MessageApi MessageApi;
    public static final NodeApi NodeApi;
    public static final C1900b axl;
    public static final C1904f axm;

    /* renamed from: com.google.android.gms.wearable.Wearable.1 */
    static class C18911 implements C0430b<ba, WearableOptions> {
        C18911() {
        }

        public final ba m6822a(Context context, Looper looper, jg jgVar, WearableOptions wearableOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (wearableOptions == null) {
                WearableOptions wearableOptions2 = new WearableOptions(null);
            }
            return new ba(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public final int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public static final class WearableOptions implements Optional {

        public static class Builder {
            public WearableOptions build() {
                return new WearableOptions();
            }
        }

        private WearableOptions(Builder builder) {
        }
    }

    static {
        DataApi = new C1953f();
        MessageApi = new ah();
        NodeApi = new ak();
        axl = new C1940e();
        axm = new ay();
        DQ = new C0490c();
        DR = new C18911();
        API = new Api(DR, DQ, new Scope[0]);
    }

    private Wearable() {
    }
}
