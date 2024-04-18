package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.C1390b;
import com.google.android.gms.location.C1390b.C1391a;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashMap;

public class nj {
    private final np<ni> Ee;
    private ContentProviderClient agS;
    private boolean agT;
    private HashMap<LocationListener, C1392b> agU;
    private final Context mContext;

    /* renamed from: com.google.android.gms.internal.nj.a */
    private static class C1389a extends Handler {
        private final LocationListener agV;

        public C1389a(LocationListener locationListener) {
            this.agV = locationListener;
        }

        public C1389a(LocationListener locationListener, Looper looper) {
            super(looper);
            this.agV = locationListener;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    this.agV.onLocationChanged(new Location((Location) message.obj));
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.nj.b */
    private static class C1392b extends C1391a {
        private Handler agW;

        C1392b(LocationListener locationListener, Looper looper) {
            this.agW = looper == null ? new C1389a(locationListener) : new C1389a(locationListener, looper);
        }

        public void onLocationChanged(Location location) {
            if (this.agW == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.agW.sendMessage(obtain);
        }

        public void release() {
            this.agW = null;
        }
    }

    public nj(Context context, np<ni> npVar) {
        this.agS = null;
        this.agT = false;
        this.agU = new HashMap();
        this.mContext = context;
        this.Ee = npVar;
    }

    private C1392b m5649a(LocationListener locationListener, Looper looper) {
        C1392b c1392b;
        if (looper == null) {
            jx.m5219b(Looper.myLooper(), (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        }
        synchronized (this.agU) {
            c1392b = (C1392b) this.agU.get(locationListener);
            if (c1392b == null) {
                c1392b = new C1392b(locationListener, looper);
            }
            this.agU.put(locationListener, c1392b);
        }
        return c1392b;
    }

    public void m5650S(boolean z) throws RemoteException {
        this.Ee.dS();
        ((ni) this.Ee.hw()).m5585S(z);
        this.agT = z;
    }

    public void m5651a(LocationListener locationListener) throws RemoteException {
        this.Ee.dS();
        jx.m5219b((Object) locationListener, (Object) "Invalid null listener");
        synchronized (this.agU) {
            C1390b c1390b = (C1392b) this.agU.remove(locationListener);
            if (this.agS != null && this.agU.isEmpty()) {
                this.agS.release();
                this.agS = null;
            }
            if (c1390b != null) {
                c1390b.release();
                ((ni) this.Ee.hw()).m5604a(c1390b);
            }
        }
    }

    public void m5652a(LocationRequest locationRequest, LocationListener locationListener, Looper looper) throws RemoteException {
        this.Ee.dS();
        ((ni) this.Ee.hw()).m5602a(locationRequest, m5649a(locationListener, looper));
    }

    public void m5653b(Location location) throws RemoteException {
        this.Ee.dS();
        ((ni) this.Ee.hw()).m5614b(location);
    }

    public void m5654b(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
        this.Ee.dS();
        ((ni) this.Ee.hw()).m5601a(locationRequest, pendingIntent);
    }

    public void m5655c(PendingIntent pendingIntent) throws RemoteException {
        this.Ee.dS();
        ((ni) this.Ee.hw()).m5613b(pendingIntent);
    }

    public Location nl() {
        this.Ee.dS();
        try {
            return ((ni) this.Ee.hw()).bZ(this.mContext.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void nm() {
        if (this.agT) {
            try {
                m5650S(false);
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.agU) {
                for (C1390b c1390b : this.agU.values()) {
                    if (c1390b != null) {
                        ((ni) this.Ee.hw()).m5604a(c1390b);
                    }
                }
                this.agU.clear();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
