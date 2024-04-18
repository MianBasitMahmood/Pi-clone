package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition.C1362a;
import com.google.android.gms.location.ActivityRecognitionApi;

public class nb implements ActivityRecognitionApi {

    /* renamed from: com.google.android.gms.internal.nb.a */
    private static abstract class C1363a extends C1362a<Status> {
        public C1363a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status m5537b(Status status) {
            return status;
        }

        public /* synthetic */ Result m5538c(Status status) {
            return m5537b(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.nb.1 */
    class C13641 extends C1363a {
        final /* synthetic */ long agA;
        final /* synthetic */ PendingIntent agB;
        final /* synthetic */ nb agC;

        C13641(nb nbVar, GoogleApiClient googleApiClient, long j, PendingIntent pendingIntent) {
            this.agC = nbVar;
            this.agA = j;
            this.agB = pendingIntent;
            super(googleApiClient);
        }

        protected void m5540a(nk nkVar) throws RemoteException {
            nkVar.m5664a(this.agA, this.agB);
            m1615b(Status.Kw);
        }
    }

    /* renamed from: com.google.android.gms.internal.nb.2 */
    class C13652 extends C1363a {
        final /* synthetic */ PendingIntent agB;
        final /* synthetic */ nb agC;

        C13652(nb nbVar, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
            this.agC = nbVar;
            this.agB = pendingIntent;
            super(googleApiClient);
        }

        protected void m5542a(nk nkVar) throws RemoteException {
            nkVar.m5665a(this.agB);
            m1615b(Status.Kw);
        }
    }

    public PendingResult<Status> removeActivityUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.m1806b(new C13652(this, googleApiClient, pendingIntent));
    }

    public PendingResult<Status> requestActivityUpdates(GoogleApiClient googleApiClient, long j, PendingIntent pendingIntent) {
        return googleApiClient.m1806b(new C13641(this, googleApiClient, j, pendingIntent));
    }
}
