package com.google.android.gms.internal;

import com.google.android.gms.common.api.BaseImplementation.C0435a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class kf<R extends Result> extends C0435a<R, kg> {

    /* renamed from: com.google.android.gms.internal.kf.a */
    static abstract class C1269a extends kf<Status> {
        public C1269a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status m5246b(Status status) {
            return status;
        }

        public /* synthetic */ Result m5247c(Status status) {
            return m5246b(status);
        }
    }

    public kf(GoogleApiClient googleApiClient) {
        super(kc.DQ, googleApiClient);
    }
}
