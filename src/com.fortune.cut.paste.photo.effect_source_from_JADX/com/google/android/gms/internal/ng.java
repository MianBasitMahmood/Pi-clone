package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.C1507c.C1376a;
import com.google.android.gms.location.C1507c.C1380b;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GeofencingRequest.Builder;
import com.google.android.gms.location.LocationServices.C1367a;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

public class ng implements GeofencingApi {

    /* renamed from: com.google.android.gms.internal.ng.a */
    private static abstract class C1378a extends C1367a<Status> {
        public C1378a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status m5565b(Status status) {
            return status;
        }

        public /* synthetic */ Result m5566c(Status status) {
            return m5565b(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.ng.1 */
    class C13791 extends C1378a {
        final /* synthetic */ GeofencingRequest agL;
        final /* synthetic */ PendingIntent agM;
        final /* synthetic */ ng agN;

        /* renamed from: com.google.android.gms.internal.ng.1.1 */
        class C13771 implements C1376a {
            final /* synthetic */ C13791 agO;

            C13771(C13791 c13791) {
                this.agO = c13791;
            }

            public void m5564a(int i, String[] strArr) {
                this.agO.m1615b(LocationStatusCodes.eD(i));
            }
        }

        C13791(ng ngVar, GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
            this.agN = ngVar;
            this.agL = geofencingRequest;
            this.agM = pendingIntent;
            super(googleApiClient);
        }

        protected void m5568a(nk nkVar) throws RemoteException {
            nkVar.m5667a(this.agL, this.agM, new C13771(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.ng.2 */
    class C13822 extends C1378a {
        final /* synthetic */ PendingIntent agM;
        final /* synthetic */ ng agN;

        /* renamed from: com.google.android.gms.internal.ng.2.1 */
        class C13811 implements C1380b {
            final /* synthetic */ C13822 agP;

            C13811(C13822 c13822) {
                this.agP = c13822;
            }

            public void m5571a(int i, PendingIntent pendingIntent) {
                this.agP.m1615b(LocationStatusCodes.eD(i));
            }

            public void m5572b(int i, String[] strArr) {
                Log.wtf("GeofencingImpl", "Request ID callback shouldn't have been called");
            }
        }

        C13822(ng ngVar, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
            this.agN = ngVar;
            this.agM = pendingIntent;
            super(googleApiClient);
        }

        protected void m5574a(nk nkVar) throws RemoteException {
            nkVar.m5666a(this.agM, new C13811(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.ng.3 */
    class C13843 extends C1378a {
        final /* synthetic */ ng agN;
        final /* synthetic */ List agQ;

        /* renamed from: com.google.android.gms.internal.ng.3.1 */
        class C13831 implements C1380b {
            final /* synthetic */ C13843 agR;

            C13831(C13843 c13843) {
                this.agR = c13843;
            }

            public void m5575a(int i, PendingIntent pendingIntent) {
                Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
            }

            public void m5576b(int i, String[] strArr) {
                this.agR.m1615b(LocationStatusCodes.eD(i));
            }
        }

        C13843(ng ngVar, GoogleApiClient googleApiClient, List list) {
            this.agN = ngVar;
            this.agQ = list;
            super(googleApiClient);
        }

        protected void m5578a(nk nkVar) throws RemoteException {
            nkVar.m5670a(this.agQ, new C13831(this));
        }
    }

    public PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        return googleApiClient.m1806b(new C13791(this, googleApiClient, geofencingRequest, pendingIntent));
    }

    @Deprecated
    public PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, List<Geofence> list, PendingIntent pendingIntent) {
        Builder builder = new Builder();
        builder.addGeofences(list);
        builder.setInitialTrigger(5);
        return addGeofences(googleApiClient, builder.build(), pendingIntent);
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.m1806b(new C13822(this, googleApiClient, pendingIntent));
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, List<String> list) {
        return googleApiClient.m1806b(new C13843(this, googleApiClient, list));
    }
}
