package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api.C0489a;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.BaseImplementation.C0435a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.internal.md.C1296a;

public interface lu extends C0489a {

    /* renamed from: com.google.android.gms.internal.lu.a */
    public static abstract class C1295a<R extends Result> extends C0435a<R, lu> {
        public C1295a(GoogleApiClient googleApiClient) {
            super(Fitness.DQ, googleApiClient);
        }
    }

    /* renamed from: com.google.android.gms.internal.lu.b */
    public static class C1297b extends C1296a {
        private final C0433b<Status> Ea;

        public C1297b(C0433b<Status> c0433b) {
            this.Ea = c0433b;
        }

        public void m5349j(Status status) {
            this.Ea.m1609b(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.lu.c */
    public static abstract class C1298c extends C1295a<Status> {
        C1298c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Status m5350b(Status status) {
            jx.m5216L(!status.isSuccess());
            return status;
        }

        protected /* synthetic */ Result m5351c(Status status) {
            return m5350b(status);
        }
    }

    Context getContext();

    lz jM() throws DeadObjectException;
}
