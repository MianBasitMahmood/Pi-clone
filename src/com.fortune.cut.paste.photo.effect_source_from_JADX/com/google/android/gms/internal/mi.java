package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.C0818j;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.result.DataTypeResult;
import com.google.android.gms.internal.lu.C1295a;
import com.google.android.gms.internal.lu.C1297b;
import com.google.android.gms.internal.lu.C1298c;
import com.google.android.gms.internal.ly.C1304a;

public class mi implements ConfigApi {

    /* renamed from: com.google.android.gms.internal.mi.1 */
    class C13221 extends C1295a<DataTypeResult> {
        final /* synthetic */ DataTypeCreateRequest Vb;
        final /* synthetic */ mi Vc;

        C13221(mi miVar, GoogleApiClient googleApiClient, DataTypeCreateRequest dataTypeCreateRequest) {
            this.Vc = miVar;
            this.Vb = dataTypeCreateRequest;
            super(googleApiClient);
        }

        protected void m5435a(lu luVar) throws RemoteException {
            luVar.jM().m5363a(this.Vb, new C1325a(null), luVar.getContext().getPackageName());
        }

        protected /* synthetic */ Result m5436c(Status status) {
            return m5437w(status);
        }

        protected DataTypeResult m5437w(Status status) {
            return DataTypeResult.m2790E(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.mi.2 */
    class C13232 extends C1295a<DataTypeResult> {
        final /* synthetic */ mi Vc;
        final /* synthetic */ C0818j Vd;

        C13232(mi miVar, GoogleApiClient googleApiClient, C0818j c0818j) {
            this.Vc = miVar;
            this.Vd = c0818j;
            super(googleApiClient);
        }

        protected void m5439a(lu luVar) throws RemoteException {
            luVar.jM().m5374a(this.Vd, new C1325a(null), luVar.getContext().getPackageName());
        }

        protected /* synthetic */ Result m5440c(Status status) {
            return m5441w(status);
        }

        protected DataTypeResult m5441w(Status status) {
            return DataTypeResult.m2790E(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.mi.3 */
    class C13243 extends C1298c {
        final /* synthetic */ mi Vc;

        C13243(mi miVar, GoogleApiClient googleApiClient) {
            this.Vc = miVar;
            super(googleApiClient);
        }

        protected void m5443a(lu luVar) throws RemoteException {
            luVar.jM().m5381a(new C1297b(this), luVar.getContext().getPackageName());
        }
    }

    /* renamed from: com.google.android.gms.internal.mi.a */
    private static class C1325a extends C1304a {
        private final C0433b<DataTypeResult> Ea;

        private C1325a(C0433b<DataTypeResult> c0433b) {
            this.Ea = c0433b;
        }

        public void m5444a(DataTypeResult dataTypeResult) {
            this.Ea.m1609b(dataTypeResult);
        }
    }

    public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient googleApiClient, DataTypeCreateRequest dataTypeCreateRequest) {
        return googleApiClient.m1806b(new C13221(this, googleApiClient, dataTypeCreateRequest));
    }

    public PendingResult<Status> disableFit(GoogleApiClient googleApiClient) {
        return googleApiClient.m1806b(new C13243(this, googleApiClient));
    }

    public PendingResult<DataTypeResult> readDataType(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.m1804a(new C13232(this, googleApiClient, new C0818j(str)));
    }
}
