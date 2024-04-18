package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.BaseImplementation.C0435a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;

/* renamed from: com.google.android.gms.drive.internal.q */
abstract class C0591q<R extends Result> extends C0435a<R, C0613r> {

    /* renamed from: com.google.android.gms.drive.internal.q.a */
    static abstract class C0598a extends C0591q<Status> {
        C0598a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Status m2224b(Status status) {
            return status;
        }

        protected /* synthetic */ Result m2225c(Status status) {
            return m2224b(status);
        }
    }

    public C0591q(GoogleApiClient googleApiClient) {
        super(Drive.DQ, googleApiClient);
    }
}
