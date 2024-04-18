package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.C0430b;
import com.google.android.gms.common.api.Api.C0489a;
import com.google.android.gms.common.api.Api.C0490c;
import com.google.android.gms.common.api.BaseImplementation.C0435a;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jm;
import com.google.android.gms.internal.jm.C0499b;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.kc;
import com.google.android.gms.wearable.DataEvent;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.gms.common.api.c */
final class C0507c implements GoogleApiClient {
    private final Looper JF;
    private final Condition JR;
    private final jm JS;
    private final int JT;
    final Queue<C0434d<?>> JU;
    private ConnectionResult JV;
    private int JW;
    private volatile int JX;
    private volatile boolean JY;
    private boolean JZ;
    private final C0496b Jy;
    private int Ka;
    private long Kb;
    private long Kc;
    final Handler Kd;
    BroadcastReceiver Ke;
    private final Bundle Kf;
    private final Map<C0490c<?>, C0489a> Kg;
    private final List<String> Kh;
    private boolean Ki;
    private final Set<C0509d<?>> Kj;
    final Set<C0434d<?>> Kk;
    private final ConnectionCallbacks Kl;
    private final C0499b Km;
    private final Context mContext;
    private final Lock zO;

    /* renamed from: com.google.android.gms.common.api.c.d */
    interface C0434d<A extends C0489a> {
        void m1618a(C0496b c0496b);

        void m1619b(A a) throws DeadObjectException;

        void cancel();

        int gF();

        C0490c<A> gz();

        void m1620l(Status status);
    }

    /* renamed from: com.google.android.gms.common.api.c.b */
    interface C0496b {
        void m1812b(C0434d<?> c0434d);
    }

    /* renamed from: com.google.android.gms.common.api.c.1 */
    class C04971 implements C0496b {
        final /* synthetic */ C0507c Kn;

        C04971(C0507c c0507c) {
            this.Kn = c0507c;
        }

        public void m1813b(C0434d<?> c0434d) {
            this.Kn.Kk.remove(c0434d);
        }
    }

    /* renamed from: com.google.android.gms.common.api.c.2 */
    class C04982 implements ConnectionCallbacks {
        final /* synthetic */ C0507c Kn;

        C04982(C0507c c0507c) {
            this.Kn = c0507c;
        }

        public void onConnected(Bundle bundle) {
            this.Kn.zO.lock();
            try {
                if (this.Kn.JX == 1) {
                    if (bundle != null) {
                        this.Kn.Kf.putAll(bundle);
                    }
                    this.Kn.gJ();
                }
                this.Kn.zO.unlock();
            } catch (Throwable th) {
                this.Kn.zO.unlock();
            }
        }

        public void onConnectionSuspended(int i) {
            this.Kn.zO.lock();
            switch (i) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    if (!this.Kn.gL()) {
                        this.Kn.JY = true;
                        this.Kn.Ke = new C0505a(this.Kn);
                        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                        intentFilter.addDataScheme("package");
                        this.Kn.mContext.registerReceiver(this.Kn.Ke, intentFilter);
                        this.Kn.Kd.sendMessageDelayed(this.Kn.Kd.obtainMessage(1), this.Kn.Kb);
                        this.Kn.Kd.sendMessageDelayed(this.Kn.Kd.obtainMessage(2), this.Kn.Kc);
                        this.Kn.al(i);
                        break;
                    }
                    this.Kn.zO.unlock();
                    return;
                case DataEvent.TYPE_DELETED /*2*/:
                    try {
                        this.Kn.al(i);
                        this.Kn.connect();
                        break;
                    } catch (Throwable th) {
                        this.Kn.zO.unlock();
                    }
            }
            this.Kn.zO.unlock();
        }
    }

    /* renamed from: com.google.android.gms.common.api.c.3 */
    class C05003 implements C0499b {
        final /* synthetic */ C0507c Kn;

        C05003(C0507c c0507c) {
            this.Kn = c0507c;
        }

        public Bundle fX() {
            return null;
        }

        public boolean gN() {
            return this.Kn.Ki;
        }

        public boolean isConnected() {
            return this.Kn.isConnected();
        }
    }

    /* renamed from: com.google.android.gms.common.api.c.4 */
    class C05014 implements OnConnectionFailedListener {
        final /* synthetic */ C0507c Kn;
        final /* synthetic */ C0430b Ko;

        C05014(C0507c c0507c, C0430b c0430b) {
            this.Kn = c0507c;
            this.Ko = c0430b;
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            this.Kn.zO.lock();
            try {
                if (this.Kn.JV == null || this.Ko.getPriority() < this.Kn.JW) {
                    this.Kn.JV = connectionResult;
                    this.Kn.JW = this.Ko.getPriority();
                }
                this.Kn.gJ();
            } finally {
                this.Kn.zO.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.c.5 */
    class C05025 implements ConnectionCallbacks {
        final /* synthetic */ C0507c Kn;
        final /* synthetic */ AtomicReference Kp;
        final /* synthetic */ C0511f Kq;

        C05025(C0507c c0507c, AtomicReference atomicReference, C0511f c0511f) {
            this.Kn = c0507c;
            this.Kp = atomicReference;
            this.Kq = c0511f;
        }

        public void onConnected(Bundle bundle) {
            this.Kn.m1818a((GoogleApiClient) this.Kp.get(), this.Kq, true);
        }

        public void onConnectionSuspended(int i) {
        }
    }

    /* renamed from: com.google.android.gms.common.api.c.6 */
    class C05036 implements OnConnectionFailedListener {
        final /* synthetic */ C0507c Kn;
        final /* synthetic */ C0511f Kq;

        C05036(C0507c c0507c, C0511f c0511f) {
            this.Kn = c0507c;
            this.Kq = c0511f;
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            this.Kq.m1615b(new Status(8));
        }
    }

    /* renamed from: com.google.android.gms.common.api.c.7 */
    class C05047 implements ResultCallback<Status> {
        final /* synthetic */ GoogleApiClient GB;
        final /* synthetic */ C0507c Kn;
        final /* synthetic */ C0511f Kq;
        final /* synthetic */ boolean Kr;

        C05047(C0507c c0507c, C0511f c0511f, boolean z, GoogleApiClient googleApiClient) {
            this.Kn = c0507c;
            this.Kq = c0511f;
            this.Kr = z;
            this.GB = googleApiClient;
        }

        public void m1814j(Status status) {
            if (status.isSuccess() && this.Kn.isConnected()) {
                this.Kn.reconnect();
            }
            this.Kq.m1615b((Result) status);
            if (this.Kr) {
                this.GB.disconnect();
            }
        }

        public /* synthetic */ void onResult(Result result) {
            m1814j((Status) result);
        }
    }

    /* renamed from: com.google.android.gms.common.api.c.a */
    private static class C0505a extends BroadcastReceiver {
        private WeakReference<C0507c> Ks;

        C0505a(C0507c c0507c) {
            this.Ks = new WeakReference(c0507c);
        }

        public void onReceive(Context context, Intent intent) {
            Uri data = intent.getData();
            String str = null;
            if (data != null) {
                str = data.getSchemeSpecificPart();
            }
            if (str != null && str.equals(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE)) {
                C0507c c0507c = (C0507c) this.Ks.get();
                if (c0507c != null && !c0507c.isConnected() && !c0507c.isConnecting() && c0507c.gL()) {
                    c0507c.connect();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.c.c */
    private class C0506c extends Handler {
        final /* synthetic */ C0507c Kn;

        C0506c(C0507c c0507c, Looper looper) {
            this.Kn = c0507c;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    this.Kn.gM();
                case DataEvent.TYPE_DELETED /*2*/:
                    this.Kn.resume();
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
            }
        }
    }

    public C0507c(Context context, Looper looper, jg jgVar, Map<Api<?>, ApiOptions> map, Set<ConnectionCallbacks> set, Set<OnConnectionFailedListener> set2, int i) {
        this.zO = new ReentrantLock();
        this.JR = this.zO.newCondition();
        this.JU = new LinkedList();
        this.JX = 4;
        this.JZ = false;
        this.Kb = 120000;
        this.Kc = 5000;
        this.Kf = new Bundle();
        this.Kg = new HashMap();
        this.Kj = Collections.newSetFromMap(new WeakHashMap());
        this.Kk = Collections.newSetFromMap(new ConcurrentHashMap());
        this.Jy = new C04971(this);
        this.Kl = new C04982(this);
        this.Km = new C05003(this);
        this.mContext = context;
        this.JS = new jm(context, looper, this.Km);
        this.JF = looper;
        this.Kd = new C0506c(this, looper);
        this.JT = i;
        for (ConnectionCallbacks registerConnectionCallbacks : set) {
            this.JS.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : set2) {
            this.JS.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        for (Api api : map.keySet()) {
            C0430b gx = api.gx();
            Object obj = map.get(api);
            this.Kg.put(api.gz(), C0507c.m1816a(gx, obj, context, looper, jgVar, this.Kl, new C05014(this, gx)));
        }
        this.Kh = Collections.unmodifiableList(jgVar.ho());
    }

    private static <C extends C0489a, O> C m1816a(C0430b<C, O> c0430b, Object obj, Context context, Looper looper, jg jgVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return c0430b.m1606a(context, looper, jgVar, obj, connectionCallbacks, onConnectionFailedListener);
    }

    private void m1818a(GoogleApiClient googleApiClient, C0511f c0511f, boolean z) {
        kc.Nu.m5245c(googleApiClient).setResultCallback(new C05047(this, c0511f, z, googleApiClient));
    }

    private <A extends C0489a> void m1819a(C0434d<A> c0434d) throws DeadObjectException {
        this.zO.lock();
        try {
            jx.m5221b(c0434d.gz() != null, (Object) "This task can not be executed or enqueued (it's probably a Batch or malformed)");
            this.Kk.add(c0434d);
            c0434d.m1618a(this.Jy);
            if (gL()) {
                c0434d.m1620l(new Status(8));
                return;
            }
            c0434d.m1619b(m1835a(c0434d.gz()));
            this.zO.unlock();
        } finally {
            this.zO.unlock();
        }
    }

    private void al(int i) {
        this.zO.lock();
        try {
            if (this.JX != 3) {
                if (i == -1) {
                    Iterator it;
                    C0434d c0434d;
                    if (isConnecting()) {
                        it = this.JU.iterator();
                        while (it.hasNext()) {
                            c0434d = (C0434d) it.next();
                            if (c0434d.gF() != 1) {
                                c0434d.cancel();
                                it.remove();
                            }
                        }
                    } else {
                        this.JU.clear();
                    }
                    for (C0434d c0434d2 : this.Kk) {
                        c0434d2.cancel();
                    }
                    this.Kk.clear();
                    for (C0509d clear : this.Kj) {
                        clear.clear();
                    }
                    this.Kj.clear();
                    if (this.JV == null && !this.JU.isEmpty()) {
                        this.JZ = true;
                        return;
                    }
                }
                boolean isConnecting = isConnecting();
                boolean isConnected = isConnected();
                this.JX = 3;
                if (isConnecting) {
                    if (i == -1) {
                        this.JV = null;
                    }
                    this.JR.signalAll();
                }
                this.Ki = false;
                for (C0489a c0489a : this.Kg.values()) {
                    if (c0489a.isConnected()) {
                        c0489a.disconnect();
                    }
                }
                this.Ki = true;
                this.JX = 4;
                if (isConnected) {
                    if (i != -1) {
                        this.JS.aE(i);
                    }
                    this.Ki = false;
                }
            }
            this.zO.unlock();
        } finally {
            this.zO.unlock();
        }
    }

    private void gJ() {
        this.Ka--;
        if (this.Ka != 0) {
            return;
        }
        if (this.JV != null) {
            this.JZ = false;
            al(3);
            if (!(gL() && GooglePlayServicesUtil.m1787e(this.mContext, this.JV.getErrorCode()))) {
                gM();
                this.JS.m5097b(this.JV);
            }
            this.Ki = false;
            return;
        }
        this.JX = 2;
        gM();
        this.JR.signalAll();
        gK();
        if (this.JZ) {
            this.JZ = false;
            al(-1);
            return;
        }
        this.JS.m5098f(this.Kf.isEmpty() ? null : this.Kf);
    }

    private void gK() {
        this.zO.lock();
        try {
            boolean z = isConnected() || gL();
            jx.m5217a(z, "GoogleApiClient is not connected yet.");
            while (!this.JU.isEmpty()) {
                m1819a((C0434d) this.JU.remove());
            }
            this.zO.unlock();
        } catch (Throwable e) {
            Log.w("GoogleApiClientImpl", "Service died while flushing queue", e);
        } catch (Throwable th) {
            this.zO.unlock();
        }
    }

    private void gM() {
        this.zO.lock();
        try {
            if (this.JY) {
                this.JY = false;
                this.Kd.removeMessages(2);
                this.Kd.removeMessages(1);
                this.mContext.unregisterReceiver(this.Ke);
                this.zO.unlock();
            }
        } finally {
            this.zO.unlock();
        }
    }

    private void resume() {
        this.zO.lock();
        try {
            if (gL()) {
                connect();
            }
            this.zO.unlock();
        } catch (Throwable th) {
            this.zO.unlock();
        }
    }

    public final <C extends C0489a> C m1835a(C0490c<C> c0490c) {
        Object obj = (C0489a) this.Kg.get(c0490c);
        jx.m5219b(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public final <A extends C0489a, R extends Result, T extends C0435a<R, A>> T m1836a(T t) {
        this.zO.lock();
        try {
            if (isConnected()) {
                m1838b((C0435a) t);
            } else {
                this.JU.add(t);
            }
            this.zO.unlock();
            return t;
        } catch (Throwable th) {
            this.zO.unlock();
        }
    }

    public final boolean m1837a(Scope scope) {
        return this.Kh.contains(scope.gO());
    }

    public final <A extends C0489a, T extends C0435a<? extends Result, A>> T m1838b(T t) {
        boolean z = isConnected() || gL();
        jx.m5217a(z, "GoogleApiClient is not connected yet.");
        gK();
        try {
            m1819a((C0434d) t);
        } catch (DeadObjectException e) {
            al(1);
        }
        return t;
    }

    public final ConnectionResult blockingConnect() {
        ConnectionResult connectionResult;
        jx.m5217a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zO.lock();
        try {
            connect();
            while (isConnecting()) {
                this.JR.await();
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.Iu;
            } else if (this.JV != null) {
                connectionResult = this.JV;
                this.zO.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.zO.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.zO.unlock();
        }
        return connectionResult;
    }

    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        ConnectionResult connectionResult;
        jx.m5217a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zO.lock();
        try {
            connect();
            long toNanos = timeUnit.toNanos(j);
            while (isConnecting()) {
                toNanos = this.JR.awaitNanos(toNanos);
                if (toNanos <= 0) {
                    connectionResult = new ConnectionResult(14, null);
                    break;
                }
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.Iu;
                this.zO.unlock();
            } else if (this.JV != null) {
                connectionResult = this.JV;
                this.zO.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.zO.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.zO.unlock();
        }
        return connectionResult;
    }

    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        jx.m5217a(isConnected(), "GoogleApiClient is not connected yet.");
        C0511f c0511f = new C0511f(this.JF);
        if (this.Kg.containsKey(kc.DQ)) {
            m1818a(this, c0511f, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            ConnectionCallbacks c05025 = new C05025(this, atomicReference, c0511f);
            GoogleApiClient build = new Builder(this.mContext).addApi(kc.API).addConnectionCallbacks(c05025).addOnConnectionFailedListener(new C05036(this, c0511f)).setHandler(this.Kd).build();
            atomicReference.set(build);
            build.connect();
        }
        return c0511f;
    }

    public final void connect() {
        this.zO.lock();
        try {
            this.JZ = false;
            if (isConnected() || isConnecting()) {
                this.zO.unlock();
                return;
            }
            this.Ki = true;
            this.JV = null;
            this.JX = 1;
            this.Kf.clear();
            this.Ka = this.Kg.size();
            for (C0489a connect : this.Kg.values()) {
                connect.connect();
            }
            this.zO.unlock();
        } catch (Throwable th) {
            this.zO.unlock();
        }
    }

    public final <L> C0509d<L> m1839d(L l) {
        jx.m5219b((Object) l, (Object) "Listener must not be null");
        this.zO.lock();
        try {
            C0509d<L> c0509d = new C0509d(this.JF, l);
            this.Kj.add(c0509d);
            return c0509d;
        } finally {
            this.zO.unlock();
        }
    }

    public final void disconnect() {
        gM();
        al(-1);
    }

    final boolean gL() {
        return this.JY;
    }

    public final Looper getLooper() {
        return this.JF;
    }

    public final boolean isConnected() {
        return this.JX == 2;
    }

    public final boolean isConnecting() {
        return this.JX == 1;
    }

    public final boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks) {
        return this.JS.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    public final boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener) {
        return this.JS.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    public final void reconnect() {
        disconnect();
        connect();
    }

    public final void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        this.JS.registerConnectionCallbacks(connectionCallbacks);
    }

    public final void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        this.JS.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public final void stopAutoManage(FragmentActivity fragmentActivity) {
        jx.m5217a(this.JT >= 0, "Called stopAutoManage but automatic lifecycle management is not enabled.");
        C0516g.m1847a(fragmentActivity).ao(this.JT);
    }

    public final void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        this.JS.unregisterConnectionCallbacks(connectionCallbacks);
    }

    public final void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        this.JS.unregisterConnectionFailedListener(onConnectionFailedListener);
    }
}
