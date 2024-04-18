package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.C0813e.C0812a;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResult;
import com.google.android.gms.internal.lu.C1295a;
import com.google.android.gms.internal.lu.C1297b;
import com.google.android.gms.internal.lu.C1298c;
import com.google.android.gms.internal.lw.C1300a;

public class mj implements HistoryApi {

    /* renamed from: com.google.android.gms.internal.mj.1 */
    class C13261 extends C1298c {
        final /* synthetic */ DataSet Ve;
        final /* synthetic */ mj Vf;

        C13261(mj mjVar, GoogleApiClient googleApiClient, DataSet dataSet) {
            this.Vf = mjVar;
            this.Ve = dataSet;
            super(googleApiClient);
        }

        protected void m5446a(lu luVar) throws RemoteException {
            luVar.jM().m5373a(new C0812a().m2754b(this.Ve).jU(), new C1297b(this), luVar.getContext().getPackageName());
        }
    }

    /* renamed from: com.google.android.gms.internal.mj.2 */
    class C13272 extends C1298c {
        final /* synthetic */ mj Vf;
        final /* synthetic */ DataDeleteRequest Vg;

        C13272(mj mjVar, GoogleApiClient googleApiClient, DataDeleteRequest dataDeleteRequest) {
            this.Vf = mjVar;
            this.Vg = dataDeleteRequest;
            super(googleApiClient);
        }

        protected void m5448a(lu luVar) throws RemoteException {
            luVar.jM().m5360a(this.Vg, new C1297b(this), luVar.getContext().getPackageName());
        }
    }

    /* renamed from: com.google.android.gms.internal.mj.3 */
    class C13283 extends C1295a<DataReadResult> {
        final /* synthetic */ mj Vf;
        final /* synthetic */ DataReadRequest Vh;

        C13283(mj mjVar, GoogleApiClient googleApiClient, DataReadRequest dataReadRequest) {
            this.Vf = mjVar;
            this.Vh = dataReadRequest;
            super(googleApiClient);
        }

        protected void m5450a(lu luVar) throws RemoteException {
            luVar.jM().m5361a(this.Vh, new C1329a(null), luVar.getContext().getPackageName());
        }

        protected /* synthetic */ Result m5451c(Status status) {
            return m5452x(status);
        }

        protected DataReadResult m5452x(Status status) {
            return DataReadResult.m2783a(status, this.Vh);
        }
    }

    /* renamed from: com.google.android.gms.internal.mj.a */
    private static class C1329a extends C1300a {
        private final C0433b<DataReadResult> Ea;
        private int Vi;
        private DataReadResult Vj;

        private C1329a(C0433b<DataReadResult> c0433b) {
            this.Vi = 0;
            this.Vj = null;
            this.Ea = c0433b;
        }

        public void m5453a(DataReadResult dataReadResult) {
            synchronized (this) {
                Log.v("Fitness", "Received batch result");
                if (this.Vj == null) {
                    this.Vj = dataReadResult;
                } else {
                    this.Vj.m2787b(dataReadResult);
                }
                this.Vi++;
                if (this.Vi == this.Vj.kr()) {
                    this.Ea.m1609b(this.Vj);
                }
            }
        }
    }

    public PendingResult<Status> deleteData(GoogleApiClient googleApiClient, DataDeleteRequest dataDeleteRequest) {
        return googleApiClient.m1804a(new C13272(this, googleApiClient, dataDeleteRequest));
    }

    public PendingResult<Status> insertData(GoogleApiClient googleApiClient, DataSet dataSet) {
        return googleApiClient.m1804a(new C13261(this, googleApiClient, dataSet));
    }

    public PendingResult<DataReadResult> readData(GoogleApiClient googleApiClient, DataReadRequest dataReadRequest) {
        return googleApiClient.m1804a(new C13283(this, googleApiClient, dataReadRequest));
    }
}
