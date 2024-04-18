package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.BaseImplementation.C0435a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.C0776k;
import com.google.android.gms.fitness.data.C0781l.C0780a;
import com.google.android.gms.fitness.request.C0825o;
import com.google.android.gms.fitness.request.C0827q;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.lu.C1297b;
import com.google.android.gms.internal.lx.C1302a;
import com.google.android.gms.internal.md.C1296a;

public class mm implements SensorsApi {

    /* renamed from: com.google.android.gms.internal.mm.a */
    private static abstract class C1334a<R extends Result> extends C0435a<R, lu> {
        public C1334a(GoogleApiClient googleApiClient) {
            super(Fitness.DQ, googleApiClient);
        }
    }

    /* renamed from: com.google.android.gms.internal.mm.1 */
    class C13351 extends C1334a<DataSourcesResult> {
        final /* synthetic */ DataSourcesRequest Vo;
        final /* synthetic */ mm Vp;

        C13351(mm mmVar, GoogleApiClient googleApiClient, DataSourcesRequest dataSourcesRequest) {
            this.Vp = mmVar;
            this.Vo = dataSourcesRequest;
            super(googleApiClient);
        }

        protected void m5467a(lu luVar) throws RemoteException {
            luVar.jM().m5362a(this.Vo, new C1340c(null), luVar.getContext().getPackageName());
        }

        protected /* synthetic */ Result m5468c(Status status) {
            return m5469z(status);
        }

        protected DataSourcesResult m5469z(Status status) {
            return DataSourcesResult.m2788D(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.mm.2 */
    class C13362 extends C1334a<Status> {
        final /* synthetic */ mm Vp;
        final /* synthetic */ C0825o Vq;

        C13362(mm mmVar, GoogleApiClient googleApiClient, C0825o c0825o) {
            this.Vp = mmVar;
            this.Vq = c0825o;
            super(googleApiClient);
        }

        protected void m5471a(lu luVar) throws RemoteException {
            luVar.jM().m5376a(this.Vq, new C1297b(this), luVar.getContext().getPackageName());
        }

        protected Status m5472b(Status status) {
            return status;
        }

        protected /* synthetic */ Result m5473c(Status status) {
            return m5472b(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.mm.b */
    private interface C1337b {
        void jO();
    }

    /* renamed from: com.google.android.gms.internal.mm.3 */
    class C13383 implements C1337b {
        final /* synthetic */ mm Vp;
        final /* synthetic */ OnDataPointListener Vr;

        C13383(mm mmVar, OnDataPointListener onDataPointListener) {
            this.Vp = mmVar;
            this.Vr = onDataPointListener;
        }

        public void jO() {
            C0780a.jG().m2666c(this.Vr);
        }
    }

    /* renamed from: com.google.android.gms.internal.mm.4 */
    class C13394 extends C1334a<Status> {
        final /* synthetic */ mm Vp;
        final /* synthetic */ C1337b Vs;
        final /* synthetic */ C0827q Vt;

        C13394(mm mmVar, GoogleApiClient googleApiClient, C1337b c1337b, C0827q c0827q) {
            this.Vp = mmVar;
            this.Vs = c1337b;
            this.Vt = c0827q;
            super(googleApiClient);
        }

        protected void m5475a(lu luVar) throws RemoteException {
            luVar.jM().m5377a(this.Vt, new C1341d(this.Vs, null), luVar.getContext().getPackageName());
        }

        protected Status m5476b(Status status) {
            return status;
        }

        protected /* synthetic */ Result m5477c(Status status) {
            return m5476b(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.mm.c */
    private static class C1340c extends C1302a {
        private final C0433b<DataSourcesResult> Ea;

        private C1340c(C0433b<DataSourcesResult> c0433b) {
            this.Ea = c0433b;
        }

        public void m5478a(DataSourcesResult dataSourcesResult) {
            this.Ea.m1609b(dataSourcesResult);
        }
    }

    /* renamed from: com.google.android.gms.internal.mm.d */
    private static class C1341d extends C1296a {
        private final C0433b<Status> Ea;
        private final C1337b Vu;

        private C1341d(C0433b<Status> c0433b, C1337b c1337b) {
            this.Ea = c0433b;
            this.Vu = c1337b;
        }

        public void m5479j(Status status) {
            if (this.Vu != null && status.isSuccess()) {
                this.Vu.jO();
            }
            this.Ea.m1609b(status);
        }
    }

    private PendingResult<Status> m5480a(GoogleApiClient googleApiClient, C0825o c0825o) {
        return googleApiClient.m1804a(new C13362(this, googleApiClient, c0825o));
    }

    private PendingResult<Status> m5481a(GoogleApiClient googleApiClient, C0827q c0827q, C1337b c1337b) {
        return googleApiClient.m1806b(new C13394(this, googleApiClient, c1337b, c0827q));
    }

    public PendingResult<Status> add(GoogleApiClient googleApiClient, SensorRequest sensorRequest, PendingIntent pendingIntent) {
        return m5480a(googleApiClient, new C0825o(sensorRequest, null, pendingIntent));
    }

    public PendingResult<Status> add(GoogleApiClient googleApiClient, SensorRequest sensorRequest, OnDataPointListener onDataPointListener) {
        return m5480a(googleApiClient, new C0825o(sensorRequest, C0780a.jG().m2664a(onDataPointListener), null));
    }

    public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient googleApiClient, DataSourcesRequest dataSourcesRequest) {
        return googleApiClient.m1804a(new C13351(this, googleApiClient, dataSourcesRequest));
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return m5481a(googleApiClient, new C0827q(null, pendingIntent), null);
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, OnDataPointListener onDataPointListener) {
        C0776k b = C0780a.jG().m2665b(onDataPointListener);
        return b == null ? new me(Status.Kw) : m5481a(googleApiClient, new C0827q(b, null), new C13383(this, onDataPointListener));
    }
}
