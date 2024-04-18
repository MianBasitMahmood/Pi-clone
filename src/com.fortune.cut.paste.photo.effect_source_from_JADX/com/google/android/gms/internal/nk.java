package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jl.C1246b;
import com.google.android.gms.internal.nh.C1386a;
import com.google.android.gms.location.C1507c.C1376a;
import com.google.android.gms.location.C1507c.C1380b;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

public class nk extends nc {
    private final nj agX;
    private final mz agY;
    private final ie agZ;

    /* renamed from: com.google.android.gms.internal.nk.a */
    private final class C1393a extends C1246b<C1376a> {
        private final int Iv;
        private final String[] aha;
        final /* synthetic */ nk ahb;

        public C1393a(nk nkVar, C1376a c1376a, int i, String[] strArr) {
            this.ahb = nkVar;
            super(nkVar, c1376a);
            this.Iv = LocationStatusCodes.eC(i);
            this.aha = strArr;
        }

        protected final void m5656a(C1376a c1376a) {
            if (c1376a != null) {
                c1376a.m5563a(this.Iv, this.aha);
            }
        }

        protected final /* synthetic */ void m5657g(Object obj) {
            m5656a((C1376a) obj);
        }

        protected final void hx() {
        }
    }

    /* renamed from: com.google.android.gms.internal.nk.b */
    private static final class C1394b extends C1386a {
        private C1376a ahc;
        private C1380b ahd;
        private nk ahe;

        public C1394b(C1376a c1376a, nk nkVar) {
            this.ahc = c1376a;
            this.ahd = null;
            this.ahe = nkVar;
        }

        public C1394b(C1380b c1380b, nk nkVar) {
            this.ahd = c1380b;
            this.ahc = null;
            this.ahe = nkVar;
        }

        public final void m5658a(int i, PendingIntent pendingIntent) {
            if (this.ahe == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
                return;
            }
            nk nkVar = this.ahe;
            nk nkVar2 = this.ahe;
            nkVar2.getClass();
            nkVar.m2259a(new C1395c(nkVar2, 1, this.ahd, i, pendingIntent));
            this.ahe = null;
            this.ahc = null;
            this.ahd = null;
        }

        public final void m5659a(int i, String[] strArr) throws RemoteException {
            if (this.ahe == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            nk nkVar = this.ahe;
            nk nkVar2 = this.ahe;
            nkVar2.getClass();
            nkVar.m2259a(new C1393a(nkVar2, this.ahc, i, strArr));
            this.ahe = null;
            this.ahc = null;
            this.ahd = null;
        }

        public final void m5660b(int i, String[] strArr) {
            if (this.ahe == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
                return;
            }
            nk nkVar = this.ahe;
            nk nkVar2 = this.ahe;
            nkVar2.getClass();
            nkVar.m2259a(new C1395c(nkVar2, 2, this.ahd, i, strArr));
            this.ahe = null;
            this.ahc = null;
            this.ahd = null;
        }
    }

    /* renamed from: com.google.android.gms.internal.nk.c */
    private final class C1395c extends C1246b<C1380b> {
        private final int Iv;
        private final String[] aha;
        final /* synthetic */ nk ahb;
        private final int ahf;
        private final PendingIntent mPendingIntent;

        public C1395c(nk nkVar, int i, C1380b c1380b, int i2, PendingIntent pendingIntent) {
            boolean z = true;
            this.ahb = nkVar;
            super(nkVar, c1380b);
            if (i != 1) {
                z = false;
            }
            je.m5079K(z);
            this.ahf = i;
            this.Iv = LocationStatusCodes.eC(i2);
            this.mPendingIntent = pendingIntent;
            this.aha = null;
        }

        public C1395c(nk nkVar, int i, C1380b c1380b, int i2, String[] strArr) {
            this.ahb = nkVar;
            super(nkVar, c1380b);
            je.m5079K(i == 2);
            this.ahf = i;
            this.Iv = LocationStatusCodes.eC(i2);
            this.aha = strArr;
            this.mPendingIntent = null;
        }

        protected final void m5661a(C1380b c1380b) {
            if (c1380b != null) {
                switch (this.ahf) {
                    case DataEvent.TYPE_CHANGED /*1*/:
                        c1380b.m5569a(this.Iv, this.mPendingIntent);
                    case DataEvent.TYPE_DELETED /*2*/:
                        c1380b.m5570b(this.Iv, this.aha);
                    default:
                        Log.wtf("LocationClientImpl", "Unsupported action: " + this.ahf);
                }
            }
        }

        protected final /* synthetic */ void m5662g(Object obj) {
            m5661a((C1380b) obj);
        }

        protected final void hx() {
        }
    }

    public nk(Context context, Looper looper, String str, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str2) {
        this(context, looper, str, connectionCallbacks, onConnectionFailedListener, str2, null);
    }

    public nk(Context context, Looper looper, String str, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str2, String str3) {
        this(context, looper, str, connectionCallbacks, onConnectionFailedListener, str2, str3, null);
    }

    public nk(Context context, Looper looper, String str, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str2, String str3, String str4) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str2);
        this.agX = new nj(context, this.Ee);
        this.agY = mz.m5533a(context, str3, str4, this.Ee);
        this.agZ = ie.m4966a(context, this.Ee);
    }

    public void m5663S(boolean z) throws RemoteException {
        this.agX.m5650S(z);
    }

    public void m5664a(long j, PendingIntent pendingIntent) throws RemoteException {
        dS();
        jx.m5223i(pendingIntent);
        jx.m5221b(j >= 0, (Object) "detectionIntervalMillis must be >= 0");
        ((ni) hw()).m5586a(j, true, pendingIntent);
    }

    public void m5665a(PendingIntent pendingIntent) throws RemoteException {
        dS();
        jx.m5223i(pendingIntent);
        ((ni) hw()).m5587a(pendingIntent);
    }

    public void m5666a(PendingIntent pendingIntent, C1380b c1380b) throws RemoteException {
        nh nhVar;
        dS();
        jx.m5219b((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        jx.m5219b((Object) c1380b, (Object) "OnRemoveGeofencesResultListener not provided.");
        if (c1380b == null) {
            nhVar = null;
        } else {
            Object c1394b = new C1394b(c1380b, this);
        }
        ((ni) hw()).m5588a(pendingIntent, nhVar, getContext().getPackageName());
    }

    public void m5667a(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, C1376a c1376a) throws RemoteException {
        nh nhVar;
        dS();
        jx.m5219b((Object) geofencingRequest, (Object) "geofencingRequest can't be null.");
        jx.m5219b((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        jx.m5219b((Object) c1376a, (Object) "OnAddGeofencesResultListener not provided.");
        if (c1376a == null) {
            nhVar = null;
        } else {
            Object c1394b = new C1394b(c1376a, this);
        }
        ((ni) hw()).m5600a(geofencingRequest, pendingIntent, nhVar);
    }

    public void m5668a(LocationListener locationListener) throws RemoteException {
        this.agX.m5651a(locationListener);
    }

    public void m5669a(LocationRequest locationRequest, LocationListener locationListener, Looper looper) throws RemoteException {
        synchronized (this.agX) {
            this.agX.m5652a(locationRequest, locationListener, looper);
        }
    }

    public void m5670a(List<String> list, C1380b c1380b) throws RemoteException {
        nh nhVar;
        dS();
        boolean z = list != null && list.size() > 0;
        jx.m5221b(z, (Object) "geofenceRequestIds can't be null nor empty.");
        jx.m5219b((Object) c1380b, (Object) "OnRemoveGeofencesResultListener not provided.");
        String[] strArr = (String[]) list.toArray(new String[0]);
        if (c1380b == null) {
            nhVar = null;
        } else {
            Object c1394b = new C1394b(c1380b, this);
        }
        ((ni) hw()).m5612a(strArr, nhVar, getContext().getPackageName());
    }

    public void m5671b(Location location) throws RemoteException {
        this.agX.m5653b(location);
    }

    public void m5672b(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
        this.agX.m5654b(locationRequest, pendingIntent);
    }

    public void m5673c(PendingIntent pendingIntent) throws RemoteException {
        this.agX.m5655c(pendingIntent);
    }

    public void disconnect() {
        synchronized (this.agX) {
            if (isConnected()) {
                try {
                    this.agX.removeAllListeners();
                    this.agX.nm();
                } catch (Throwable e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.disconnect();
        }
    }

    public Location nl() {
        return this.agX.nl();
    }
}
