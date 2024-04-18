package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.data.Subscription.C0765a;
import com.google.android.gms.fitness.request.C0823m;
import com.google.android.gms.fitness.request.C0823m.C0822a;
import com.google.android.gms.fitness.request.af;
import com.google.android.gms.fitness.request.af.C0805a;
import com.google.android.gms.fitness.request.aj;
import com.google.android.gms.fitness.request.aj.C0807a;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;
import com.google.android.gms.internal.lu.C1295a;
import com.google.android.gms.internal.lu.C1297b;
import com.google.android.gms.internal.lu.C1298c;
import com.google.android.gms.internal.ma.C1308a;

public class ml implements RecordingApi {

    /* renamed from: com.google.android.gms.internal.ml.1 */
    class C13301 extends C1295a<ListSubscriptionsResult> {
        final /* synthetic */ C0823m Vk;
        final /* synthetic */ ml Vl;

        C13301(ml mlVar, GoogleApiClient googleApiClient, C0823m c0823m) {
            this.Vl = mlVar;
            this.Vk = c0823m;
            super(googleApiClient);
        }

        protected void m5455a(lu luVar) throws RemoteException {
            luVar.jM().m5375a(this.Vk, new C1333a(null), luVar.getContext().getPackageName());
        }

        protected /* synthetic */ Result m5456c(Status status) {
            return m5457y(status);
        }

        protected ListSubscriptionsResult m5457y(Status status) {
            return ListSubscriptionsResult.m2792F(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.ml.2 */
    class C13312 extends C1298c {
        final /* synthetic */ ml Vl;
        final /* synthetic */ af Vm;

        C13312(ml mlVar, GoogleApiClient googleApiClient, af afVar) {
            this.Vl = mlVar;
            this.Vm = afVar;
            super(googleApiClient);
        }

        protected void m5459a(lu luVar) throws RemoteException {
            luVar.jM().m5369a(this.Vm, new C1297b(this), luVar.getContext().getPackageName());
        }
    }

    /* renamed from: com.google.android.gms.internal.ml.3 */
    class C13323 extends C1298c {
        final /* synthetic */ ml Vl;
        final /* synthetic */ aj Vn;

        C13323(ml mlVar, GoogleApiClient googleApiClient, aj ajVar) {
            this.Vl = mlVar;
            this.Vn = ajVar;
            super(googleApiClient);
        }

        protected void m5461a(lu luVar) throws RemoteException {
            luVar.jM().m5371a(this.Vn, new C1297b(this), luVar.getContext().getPackageName());
        }
    }

    /* renamed from: com.google.android.gms.internal.ml.a */
    private static class C1333a extends C1308a {
        private final C0433b<ListSubscriptionsResult> Ea;

        private C1333a(C0433b<ListSubscriptionsResult> c0433b) {
            this.Ea = c0433b;
        }

        public void m5462a(ListSubscriptionsResult listSubscriptionsResult) {
            this.Ea.m1609b(listSubscriptionsResult);
        }
    }

    private PendingResult<ListSubscriptionsResult> m5463a(GoogleApiClient googleApiClient, C0823m c0823m) {
        return googleApiClient.m1804a(new C13301(this, googleApiClient, c0823m));
    }

    public PendingResult<Status> m5464a(GoogleApiClient googleApiClient, af afVar) {
        return googleApiClient.m1804a(new C13312(this, googleApiClient, afVar));
    }

    public PendingResult<Status> m5465a(GoogleApiClient googleApiClient, aj ajVar) {
        return googleApiClient.m1806b(new C13323(this, googleApiClient, ajVar));
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient googleApiClient) {
        return m5463a(googleApiClient, new C0822a().ka());
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient googleApiClient, DataType dataType) {
        return m5463a(googleApiClient, new C0822a().m2763c(dataType).ka());
    }

    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, DataSource dataSource) {
        return m5464a(googleApiClient, new C0805a().m2742b(new C0765a().m2648b(dataSource).jK()).kp());
    }

    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, DataType dataType) {
        return m5464a(googleApiClient, new C0805a().m2742b(new C0765a().m2649b(dataType).jK()).kp());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, DataSource dataSource) {
        return m5465a(googleApiClient, new C0807a().m2747d(dataSource).kq());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, DataType dataType) {
        return m5465a(googleApiClient, new C0807a().m2748d(dataType).kq());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, Subscription subscription) {
        return subscription.getDataType() == null ? unsubscribe(googleApiClient, subscription.getDataSource()) : unsubscribe(googleApiClient, subscription.getDataType());
    }
}
