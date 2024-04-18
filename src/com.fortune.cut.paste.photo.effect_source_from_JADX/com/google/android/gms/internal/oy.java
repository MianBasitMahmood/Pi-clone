package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.C0490c;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.Plus.C1415a;
import com.google.android.gms.plus.internal.C1731e;

public final class oy implements Account {

    /* renamed from: com.google.android.gms.internal.oy.a */
    private static abstract class C1416a extends C1415a<Status> {
        private C1416a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status m5740b(Status status) {
            return status;
        }

        public /* synthetic */ Result m5741c(Status status) {
            return m5740b(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.oy.1 */
    class C14171 extends C1416a {
        final /* synthetic */ oy anY;

        C14171(oy oyVar, GoogleApiClient googleApiClient) {
            this.anY = oyVar;
            super(null);
        }

        protected void m5743a(C1731e c1731e) {
            c1731e.m6350l((C0433b) this);
        }
    }

    private static C1731e m5744a(GoogleApiClient googleApiClient, C0490c<C1731e> c0490c) {
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

    public final void clearDefaultAccount(GoogleApiClient googleApiClient) {
        m5744a(googleApiClient, Plus.DQ).clearDefaultAccount();
    }

    public final String getAccountName(GoogleApiClient googleApiClient) {
        return m5744a(googleApiClient, Plus.DQ).getAccountName();
    }

    public final PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient googleApiClient) {
        return googleApiClient.m1806b(new C14171(this, googleApiClient));
    }
}
