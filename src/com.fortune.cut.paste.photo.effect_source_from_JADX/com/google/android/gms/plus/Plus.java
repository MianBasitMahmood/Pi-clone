package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.C0430b;
import com.google.android.gms.common.api.Api.C0490c;
import com.google.android.gms.common.api.BaseImplementation.C0435a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.oy;
import com.google.android.gms.internal.oz;
import com.google.android.gms.internal.pa;
import com.google.android.gms.internal.pb;
import com.google.android.gms.internal.pc;
import com.google.android.gms.plus.internal.C1731e;
import com.google.android.gms.plus.internal.C1734h;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api<PlusOptions> API;
    public static final Account AccountApi;
    public static final C0490c<C1731e> DQ;
    static final C0430b<C1731e, PlusOptions> DR;
    public static final Moments MomentsApi;
    public static final People PeopleApi;
    public static final Scope SCOPE_PLUS_LOGIN;
    public static final Scope SCOPE_PLUS_PROFILE;
    public static final C1420b anp;
    public static final C1418a anq;

    /* renamed from: com.google.android.gms.plus.Plus.a */
    public static abstract class C1415a<R extends Result> extends C0435a<R, C1731e> {
        public C1415a(GoogleApiClient googleApiClient) {
            super(Plus.DQ, googleApiClient);
        }
    }

    /* renamed from: com.google.android.gms.plus.Plus.1 */
    static class C17001 implements C0430b<C1731e, PlusOptions> {
        C17001() {
        }

        public final C1731e m6254a(Context context, Looper looper, jg jgVar, PlusOptions plusOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (plusOptions == null) {
                plusOptions = new PlusOptions();
            }
            return new C1731e(context, looper, connectionCallbacks, onConnectionFailedListener, new C1734h(jgVar.hm(), jgVar.hp(), (String[]) plusOptions.ans.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()));
        }

        public final int getPriority() {
            return 2;
        }
    }

    public static final class PlusOptions implements Optional {
        final String anr;
        final Set<String> ans;

        public static final class Builder {
            String anr;
            final Set<String> ans;

            public Builder() {
                this.ans = new HashSet();
            }

            public final Builder addActivityTypes(String... strArr) {
                jx.m5219b((Object) strArr, (Object) "activityTypes may not be null.");
                for (Object add : strArr) {
                    this.ans.add(add);
                }
                return this;
            }

            public final PlusOptions build() {
                return new PlusOptions();
            }

            public final Builder setServerClientId(String str) {
                this.anr = str;
                return this;
            }
        }

        private PlusOptions() {
            this.anr = null;
            this.ans = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.anr = builder.anr;
            this.ans = builder.ans;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    static {
        DQ = new C0490c();
        DR = new C17001();
        API = new Api(DR, DQ, new Scope[0]);
        SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
        SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
        MomentsApi = new pb();
        PeopleApi = new pc();
        AccountApi = new oy();
        anp = new pa();
        anq = new oz();
    }

    private Plus() {
    }

    public static C1731e m6255a(GoogleApiClient googleApiClient, C0490c<C1731e> c0490c) {
        boolean z = true;
        jx.m5221b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        jx.m5217a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        C1731e c1731e = (C1731e) googleApiClient.m1803a((C0490c) c0490c);
        if (c1731e == null) {
            z = false;
        }
        jx.m5217a(z, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        return c1731e;
    }
}
