package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationServices.C1367a;

public class nf implements FusedLocationProviderApi {

    /* renamed from: com.google.android.gms.internal.nf.a */
    private static abstract class C1368a extends C1367a<Status> {
        public C1368a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status m5547b(Status status) {
            return status;
        }

        public /* synthetic */ Result m5548c(Status status) {
            return m5547b(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.nf.1 */
    class C13691 extends C1368a {
        final /* synthetic */ LocationRequest agF;
        final /* synthetic */ LocationListener agG;
        final /* synthetic */ nf agH;

        C13691(nf nfVar, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
            this.agH = nfVar;
            this.agF = locationRequest;
            this.agG = locationListener;
            super(googleApiClient);
        }

        protected void m5550a(nk nkVar) throws RemoteException {
            nkVar.m5669a(this.agF, this.agG, null);
            m1615b(Status.Kw);
        }
    }

    /* renamed from: com.google.android.gms.internal.nf.2 */
    class C13702 extends C1368a {
        final /* synthetic */ nf agH;
        final /* synthetic */ Location agI;

        C13702(nf nfVar, GoogleApiClient googleApiClient, Location location) {
            this.agH = nfVar;
            this.agI = location;
            super(googleApiClient);
        }

        protected void m5552a(nk nkVar) throws RemoteException {
            nkVar.m5671b(this.agI);
            m1615b(Status.Kw);
        }
    }

    /* renamed from: com.google.android.gms.internal.nf.3 */
    class C13713 extends C1368a {
        final /* synthetic */ LocationRequest agF;
        final /* synthetic */ LocationListener agG;
        final /* synthetic */ nf agH;
        final /* synthetic */ Looper agJ;

        C13713(nf nfVar, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
            this.agH = nfVar;
            this.agF = locationRequest;
            this.agG = locationListener;
            this.agJ = looper;
            super(googleApiClient);
        }

        protected void m5554a(nk nkVar) throws RemoteException {
            nkVar.m5669a(this.agF, this.agG, this.agJ);
            m1615b(Status.Kw);
        }
    }

    /* renamed from: com.google.android.gms.internal.nf.4 */
    class C13724 extends C1368a {
        final /* synthetic */ PendingIntent agB;
        final /* synthetic */ LocationRequest agF;
        final /* synthetic */ nf agH;

        C13724(nf nfVar, GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
            this.agH = nfVar;
            this.agF = locationRequest;
            this.agB = pendingIntent;
            super(googleApiClient);
        }

        protected void m5556a(nk nkVar) throws RemoteException {
            nkVar.m5672b(this.agF, this.agB);
            m1615b(Status.Kw);
        }
    }

    /* renamed from: com.google.android.gms.internal.nf.5 */
    class C13735 extends C1368a {
        final /* synthetic */ LocationListener agG;
        final /* synthetic */ nf agH;

        C13735(nf nfVar, GoogleApiClient googleApiClient, LocationListener locationListener) {
            this.agH = nfVar;
            this.agG = locationListener;
            super(googleApiClient);
        }

        protected void m5558a(nk nkVar) throws RemoteException {
            nkVar.m5668a(this.agG);
            m1615b(Status.Kw);
        }
    }

    /* renamed from: com.google.android.gms.internal.nf.6 */
    class C13746 extends C1368a {
        final /* synthetic */ PendingIntent agB;
        final /* synthetic */ nf agH;

        C13746(nf nfVar, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
            this.agH = nfVar;
            this.agB = pendingIntent;
            super(googleApiClient);
        }

        protected void m5560a(nk nkVar) throws RemoteException {
            nkVar.m5673c(this.agB);
            m1615b(Status.Kw);
        }
    }

    /* renamed from: com.google.android.gms.internal.nf.7 */
    class C13757 extends C1368a {
        final /* synthetic */ nf agH;
        final /* synthetic */ boolean agK;

        C13757(nf nfVar, GoogleApiClient googleApiClient, boolean z) {
            this.agH = nfVar;
            this.agK = z;
            super(googleApiClient);
        }

        protected void m5562a(nk nkVar) throws RemoteException {
            nkVar.m5663S(this.agK);
            m1615b(Status.Kw);
        }
    }

    public Location getLastLocation(GoogleApiClient googleApiClient) {
        try {
            return LocationServices.m6091f(googleApiClient).nl();
        } catch (Exception e) {
            return null;
        }
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.m1806b(new C13746(this, googleApiClient, pendingIntent));
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, LocationListener locationListener) {
        return googleApiClient.m1806b(new C13735(this, googleApiClient, locationListener));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        return googleApiClient.m1806b(new C13724(this, googleApiClient, locationRequest, pendingIntent));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
        return googleApiClient.m1806b(new C13691(this, googleApiClient, locationRequest, locationListener));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        return googleApiClient.m1806b(new C13713(this, googleApiClient, locationRequest, locationListener, looper));
    }

    public PendingResult<Status> setMockLocation(GoogleApiClient googleApiClient, Location location) {
        return googleApiClient.m1806b(new C13702(this, googleApiClient, location));
    }

    public PendingResult<Status> setMockMode(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.m1806b(new C13757(this, googleApiClient, z));
    }
}
