package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api.C0489a;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.jm.C0499b;
import com.google.android.gms.internal.js.C1249a;
import com.google.android.gms.internal.jt.C1261a;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import java.util.ArrayList;

public abstract class jl<T extends IInterface> implements C0489a, C0499b {
    public static final String[] MP;
    private final Looper JF;
    private final jm JS;
    private T MJ;
    private final ArrayList<C1246b<?>> MK;
    private C1251f ML;
    private int MM;
    private final String[] MN;
    boolean MO;
    private final Context mContext;
    private final Object mH;
    final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.jl.a */
    final class C1245a extends Handler {
        final /* synthetic */ jl MQ;

        public C1245a(jl jlVar, Looper looper) {
            this.MQ = jlVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            C1246b c1246b;
            if (message.what == 1 && !this.MQ.isConnecting()) {
                c1246b = (C1246b) message.obj;
                c1246b.hx();
                c1246b.unregister();
            } else if (message.what == 3) {
                this.MQ.JS.m5097b(new ConnectionResult(((Integer) message.obj).intValue(), null));
            } else if (message.what == 4) {
                this.MQ.m2250a(4, null);
                this.MQ.JS.aE(((Integer) message.obj).intValue());
                this.MQ.m2252a(4, 1, null);
            } else if (message.what == 2 && !this.MQ.isConnected()) {
                c1246b = (C1246b) message.obj;
                c1246b.hx();
                c1246b.unregister();
            } else if (message.what == 2 || message.what == 1) {
                ((C1246b) message.obj).hy();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle this message.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.jl.b */
    protected abstract class C1246b<TListener> {
        final /* synthetic */ jl MQ;
        private boolean MR;
        private TListener mListener;

        public C1246b(jl jlVar, TListener tListener) {
            this.MQ = jlVar;
            this.mListener = tListener;
            this.MR = false;
        }

        protected abstract void m5087g(TListener tListener);

        protected abstract void hx();

        public void hy() {
            synchronized (this) {
                Object obj = this.mListener;
                if (this.MR) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (obj != null) {
                try {
                    m5087g(obj);
                } catch (RuntimeException e) {
                    hx();
                    throw e;
                }
            }
            hx();
            synchronized (this) {
                this.MR = true;
            }
            unregister();
        }

        public void hz() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        public void unregister() {
            hz();
            synchronized (this.MQ.MK) {
                this.MQ.MK.remove(this);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.jl.c */
    public static final class C1247c implements ConnectionCallbacks {
        private final GooglePlayServicesClient.ConnectionCallbacks MS;

        public C1247c(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
            this.MS = connectionCallbacks;
        }

        public final boolean equals(Object obj) {
            return obj instanceof C1247c ? this.MS.equals(((C1247c) obj).MS) : this.MS.equals(obj);
        }

        public final void onConnected(Bundle bundle) {
            this.MS.onConnected(bundle);
        }

        public final void onConnectionSuspended(int i) {
            this.MS.onDisconnected();
        }
    }

    /* renamed from: com.google.android.gms.internal.jl.d */
    public abstract class C1248d<TListener> extends C1246b<TListener> {
        private final DataHolder JG;
        final /* synthetic */ jl MQ;

        public C1248d(jl jlVar, TListener tListener, DataHolder dataHolder) {
            this.MQ = jlVar;
            super(jlVar, tListener);
            this.JG = dataHolder;
        }

        protected abstract void m5088b(TListener tListener, DataHolder dataHolder);

        protected final void m5089g(TListener tListener) {
            m5088b(tListener, this.JG);
        }

        protected void hx() {
            if (this.JG != null) {
                this.JG.close();
            }
        }

        public /* bridge */ /* synthetic */ void hy() {
            super.hy();
        }

        public /* bridge */ /* synthetic */ void hz() {
            super.hz();
        }

        public /* bridge */ /* synthetic */ void unregister() {
            super.unregister();
        }
    }

    /* renamed from: com.google.android.gms.internal.jl.e */
    public static final class C1250e extends C1249a {
        private jl MT;

        public C1250e(jl jlVar) {
            this.MT = jlVar;
        }

        public final void m5092b(int i, IBinder iBinder, Bundle bundle) {
            jx.m5219b((Object) "onPostInitComplete can be called only once per call to getServiceFromBroker", this.MT);
            this.MT.m2258a(i, iBinder, bundle);
            this.MT = null;
        }
    }

    /* renamed from: com.google.android.gms.internal.jl.f */
    public final class C1251f implements ServiceConnection {
        final /* synthetic */ jl MQ;

        public C1251f(jl jlVar) {
            this.MQ = jlVar;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.MQ.m2257N(iBinder);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            this.MQ.mHandler.sendMessage(this.MQ.mHandler.obtainMessage(4, Integer.valueOf(1)));
        }
    }

    /* renamed from: com.google.android.gms.internal.jl.g */
    public static final class C1252g implements OnConnectionFailedListener {
        private final GooglePlayServicesClient.OnConnectionFailedListener MU;

        public C1252g(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.MU = onConnectionFailedListener;
        }

        public final boolean equals(Object obj) {
            return obj instanceof C1252g ? this.MU.equals(((C1252g) obj).MU) : this.MU.equals(obj);
        }

        public final void onConnectionFailed(ConnectionResult connectionResult) {
            this.MU.onConnectionFailed(connectionResult);
        }
    }

    /* renamed from: com.google.android.gms.internal.jl.h */
    protected final class C1253h extends C1246b<Boolean> {
        final /* synthetic */ jl MQ;
        public final Bundle MV;
        public final IBinder MW;
        public final int statusCode;

        public C1253h(jl jlVar, int i, IBinder iBinder, Bundle bundle) {
            this.MQ = jlVar;
            super(jlVar, Boolean.valueOf(true));
            this.statusCode = i;
            this.MW = iBinder;
            this.MV = bundle;
        }

        protected final void m5093b(Boolean bool) {
            if (bool == null) {
                this.MQ.m2250a(1, null);
                return;
            }
            switch (this.statusCode) {
                case WalletFragmentState.UNKNOWN /*0*/:
                    try {
                        if (this.MQ.bL().equals(this.MW.getInterfaceDescriptor())) {
                            IInterface l = this.MQ.m2262l(this.MW);
                            if (l != null) {
                                this.MQ.m2250a(3, l);
                                this.MQ.JS.dU();
                                return;
                            }
                        }
                    } catch (RemoteException e) {
                    }
                    jn.m5106J(this.MQ.mContext).m5110b(this.MQ.bK(), this.MQ.ML);
                    this.MQ.ML = null;
                    this.MQ.m2250a(1, null);
                    this.MQ.JS.m5097b(new ConnectionResult(8, null));
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    this.MQ.m2250a(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    PendingIntent pendingIntent = this.MV != null ? (PendingIntent) this.MV.getParcelable("pendingIntent") : null;
                    if (this.MQ.ML != null) {
                        jn.m5106J(this.MQ.mContext).m5110b(this.MQ.bK(), this.MQ.ML);
                        this.MQ.ML = null;
                    }
                    this.MQ.m2250a(1, null);
                    this.MQ.JS.m5097b(new ConnectionResult(this.statusCode, pendingIntent));
            }
        }

        protected final /* synthetic */ void m5094g(Object obj) {
            m5093b((Boolean) obj);
        }

        protected final void hx() {
        }
    }

    static {
        MP = new String[]{"service_esmobile", "service_googleme"};
    }

    protected jl(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this.mH = new Object();
        this.MK = new ArrayList();
        this.MM = 1;
        this.MO = false;
        this.mContext = (Context) jx.m5223i(context);
        this.JF = (Looper) jx.m5219b((Object) looper, (Object) "Looper must not be null");
        this.JS = new jm(context, looper, this);
        this.mHandler = new C1245a(this, looper);
        m2261c(strArr);
        this.MN = strArr;
        registerConnectionCallbacks((ConnectionCallbacks) jx.m5223i(connectionCallbacks));
        registerConnectionFailedListener((OnConnectionFailedListener) jx.m5223i(onConnectionFailedListener));
    }

    @Deprecated
    protected jl(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this(context, context.getMainLooper(), new C1247c(connectionCallbacks), new C1252g(onConnectionFailedListener), strArr);
    }

    private void m2250a(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        jx.m5216L(z);
        synchronized (this.mH) {
            this.MM = i;
            this.MJ = t;
        }
    }

    private boolean m2252a(int i, int i2, T t) {
        boolean z;
        synchronized (this.mH) {
            if (this.MM != i) {
                z = false;
            } else {
                m2250a(i2, (IInterface) t);
                z = true;
            }
        }
        return z;
    }

    protected final void m2257N(IBinder iBinder) {
        try {
            m2260a(C1261a.m5207Q(iBinder), new C1250e(this));
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            aD(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    protected void m2258a(int i, IBinder iBinder, Bundle bundle) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new C1253h(this, i, iBinder, bundle)));
    }

    @Deprecated
    public final void m2259a(C1246b<?> c1246b) {
        synchronized (this.MK) {
            this.MK.add(c1246b);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, c1246b));
    }

    protected abstract void m2260a(jt jtVar, C1250e c1250e) throws RemoteException;

    public void aD(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(i)));
    }

    protected abstract String bK();

    protected abstract String bL();

    protected void m2261c(String... strArr) {
    }

    public void connect() {
        this.MO = true;
        m2250a(2, null);
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            m2250a(1, null);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(isGooglePlayServicesAvailable)));
            return;
        }
        if (this.ML != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + bK());
            jn.m5106J(this.mContext).m5110b(bK(), this.ML);
        }
        this.ML = new C1251f(this);
        if (!jn.m5106J(this.mContext).m5109a(bK(), this.ML)) {
            Log.e("GmsClient", "unable to connect to service: " + bK());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
        }
    }

    protected final void dS() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void disconnect() {
        this.MO = false;
        synchronized (this.MK) {
            int size = this.MK.size();
            for (int i = 0; i < size; i++) {
                ((C1246b) this.MK.get(i)).hz();
            }
            this.MK.clear();
        }
        m2250a(1, null);
        if (this.ML != null) {
            jn.m5106J(this.mContext).m5110b(bK(), this.ML);
            this.ML = null;
        }
    }

    public Bundle fX() {
        return null;
    }

    public boolean gN() {
        return this.MO;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.JF;
    }

    public final String[] hv() {
        return this.MN;
    }

    public final T hw() throws DeadObjectException {
        T t;
        synchronized (this.mH) {
            if (this.MM == 4) {
                throw new DeadObjectException();
            }
            dS();
            jx.m5217a(this.MJ != null, "Client is connected but service is null");
            t = this.MJ;
        }
        return t;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.mH) {
            z = this.MM == 3;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.mH) {
            z = this.MM == 2;
        }
        return z;
    }

    @Deprecated
    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        return this.JS.isConnectionCallbacksRegistered(new C1247c(connectionCallbacks));
    }

    @Deprecated
    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.JS.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    protected abstract T m2262l(IBinder iBinder);

    @Deprecated
    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.JS.registerConnectionCallbacks(new C1247c(connectionCallbacks));
    }

    public void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        this.JS.registerConnectionCallbacks(connectionCallbacks);
    }

    @Deprecated
    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.JS.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        this.JS.registerConnectionFailedListener(onConnectionFailedListener);
    }

    @Deprecated
    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.JS.unregisterConnectionCallbacks(new C1247c(connectionCallbacks));
    }

    @Deprecated
    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.JS.unregisterConnectionFailedListener(onConnectionFailedListener);
    }
}
