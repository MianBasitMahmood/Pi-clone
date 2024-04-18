package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Api.C0489a;
import com.google.android.gms.common.api.Api.C0490c;
import com.google.android.gms.common.api.C0507c.C0434d;
import com.google.android.gms.common.api.C0507c.C0496b;
import com.google.android.gms.common.api.PendingResult.C0491a;
import com.google.android.gms.internal.jr;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BaseImplementation {

    /* renamed from: com.google.android.gms.common.api.BaseImplementation.b */
    public interface C0433b<R> {
        void m1609b(R r);
    }

    public static abstract class AbstractPendingResult<R extends Result> implements C0433b<R>, PendingResult<R> {
        private final Object Jp;
        private final ArrayList<C0491a> Jq;
        private ResultCallback<R> Jr;
        private volatile R Js;
        private volatile boolean Jt;
        private boolean Ju;
        private boolean Jv;
        private jr Jw;
        protected final CallbackHandler<R> mHandler;
        private final CountDownLatch mr;

        protected AbstractPendingResult(Looper looper) {
            this.Jp = new Object();
            this.mr = new CountDownLatch(1);
            this.Jq = new ArrayList();
            this.mHandler = new CallbackHandler(looper);
        }

        protected AbstractPendingResult(CallbackHandler<R> callbackHandler) {
            this.Jp = new Object();
            this.mr = new CountDownLatch(1);
            this.Jq = new ArrayList();
            this.mHandler = callbackHandler;
        }

        private void m1612c(R r) {
            this.Js = r;
            this.Jw = null;
            this.mr.countDown();
            Status status = this.Js.getStatus();
            if (this.Jr != null) {
                this.mHandler.removeTimeoutMessages();
                if (!this.Ju) {
                    this.mHandler.sendResultCallback(this.Jr, gA());
                }
            }
            Iterator it = this.Jq.iterator();
            while (it.hasNext()) {
                ((C0491a) it.next()).m1791m(status);
            }
            this.Jq.clear();
        }

        private R gA() {
            R r;
            synchronized (this.Jp) {
                jx.m5217a(!this.Jt, "Result has already been consumed.");
                jx.m5217a(isReady(), "Result is not ready.");
                r = this.Js;
                gB();
            }
            return r;
        }

        private void gC() {
            synchronized (this.Jp) {
                if (!isReady()) {
                    m1615b(m1617c(Status.Kx));
                    this.Jv = true;
                }
            }
        }

        private void gD() {
            synchronized (this.Jp) {
                if (!isReady()) {
                    m1615b(m1617c(Status.Kz));
                    this.Jv = true;
                }
            }
        }

        public final void m1613a(C0491a c0491a) {
            jx.m5217a(!this.Jt, "Result has already been consumed.");
            synchronized (this.Jp) {
                if (isReady()) {
                    c0491a.m1791m(this.Js.getStatus());
                } else {
                    this.Jq.add(c0491a);
                }
            }
        }

        protected final void m1614a(jr jrVar) {
            synchronized (this.Jp) {
                this.Jw = jrVar;
            }
        }

        public final R await() {
            boolean z = true;
            jx.m5217a(Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread");
            if (this.Jt) {
                z = false;
            }
            jx.m5217a(z, "Result has already been consumed");
            try {
                this.mr.await();
            } catch (InterruptedException e) {
                gC();
            }
            jx.m5217a(isReady(), "Result is not ready.");
            return gA();
        }

        public final R await(long j, TimeUnit timeUnit) {
            boolean z = true;
            boolean z2 = j <= 0 || Looper.myLooper() != Looper.getMainLooper();
            jx.m5217a(z2, "await must not be called on the UI thread when time is greater than zero.");
            if (this.Jt) {
                z = false;
            }
            jx.m5217a(z, "Result has already been consumed.");
            try {
                if (!this.mr.await(j, timeUnit)) {
                    gD();
                }
            } catch (InterruptedException e) {
                gC();
            }
            jx.m5217a(isReady(), "Result is not ready.");
            return gA();
        }

        public final void m1615b(R r) {
            boolean z = true;
            synchronized (this.Jp) {
                if (this.Jv || this.Ju) {
                    BaseImplementation.m1790a(r);
                    return;
                }
                jx.m5217a(!isReady(), "Results have already been set");
                if (this.Jt) {
                    z = false;
                }
                jx.m5217a(z, "Result has already been consumed");
                m1612c((Result) r);
            }
        }

        protected abstract R m1617c(Status status);

        public void cancel() {
            synchronized (this.Jp) {
                if (this.Ju || this.Jt) {
                    return;
                }
                if (this.Jw != null) {
                    try {
                        this.Jw.cancel();
                    } catch (RemoteException e) {
                    }
                }
                BaseImplementation.m1790a(this.Js);
                this.Jr = null;
                this.Ju = true;
                m1612c(m1617c(Status.KA));
            }
        }

        protected void gB() {
            this.Jt = true;
            this.Js = null;
            this.Jr = null;
        }

        public boolean isCanceled() {
            boolean z;
            synchronized (this.Jp) {
                z = this.Ju;
            }
            return z;
        }

        public final boolean isReady() {
            return this.mr.getCount() == 0;
        }

        public final void setResultCallback(ResultCallback<R> resultCallback) {
            jx.m5217a(!this.Jt, "Result has already been consumed.");
            synchronized (this.Jp) {
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.mHandler.sendResultCallback(resultCallback, gA());
                } else {
                    this.Jr = resultCallback;
                }
            }
        }

        public final void setResultCallback(ResultCallback<R> resultCallback, long j, TimeUnit timeUnit) {
            boolean z = true;
            jx.m5217a(!this.Jt, "Result has already been consumed.");
            if (this.mHandler == null) {
                z = false;
            }
            jx.m5217a(z, "CallbackHandler has not been set before calling setResultCallback.");
            synchronized (this.Jp) {
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.mHandler.sendResultCallback(resultCallback, gA());
                } else {
                    this.Jr = resultCallback;
                    this.mHandler.sendTimeoutResultCallback(this, timeUnit.toMillis(j));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.BaseImplementation.a */
    public static abstract class C0435a<R extends Result, A extends C0489a> extends AbstractPendingResult<R> implements C0434d<A> {
        private final C0490c<A> Jn;
        private final GoogleApiClient Jx;
        private C0496b Jy;

        protected C0435a(C0490c<A> c0490c, GoogleApiClient googleApiClient) {
            super(googleApiClient.getLooper());
            this.Jn = (C0490c) jx.m5223i(c0490c);
            this.Jx = googleApiClient;
        }

        private void m1621a(RemoteException remoteException) {
            m1625l(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        protected abstract void m1622a(A a) throws RemoteException;

        public void m1623a(C0496b c0496b) {
            this.Jy = c0496b;
        }

        public final void m1624b(A a) throws DeadObjectException {
            try {
                m1622a((C0489a) a);
            } catch (RemoteException e) {
                m1621a(e);
                throw e;
            } catch (RemoteException e2) {
                m1621a(e2);
            }
        }

        protected void gB() {
            super.gB();
            if (this.Jy != null) {
                this.Jy.m1812b(this);
                this.Jy = null;
            }
        }

        public final C0435a gE() {
            jx.m5219b(this.Jx, (Object) "GoogleApiClient was not set.");
            this.Jx.m1806b(this);
            return this;
        }

        public int gF() {
            return 0;
        }

        public final C0490c<A> gz() {
            return this.Jn;
        }

        public final void m1625l(Status status) {
            jx.m5221b(!status.isSuccess(), (Object) "Failed result must not be success");
            m1615b(m1617c(status));
        }
    }

    public static class CallbackHandler<R extends Result> extends Handler {
        public static final int CALLBACK_ON_COMPLETE = 1;
        public static final int CALLBACK_ON_TIMEOUT = 2;

        public CallbackHandler() {
            this(Looper.getMainLooper());
        }

        public CallbackHandler(Looper looper) {
            super(looper);
        }

        protected void deliverResultCallback(ResultCallback<R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                BaseImplementation.m1790a(r);
                throw e;
            }
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case CALLBACK_ON_COMPLETE /*1*/:
                    Pair pair = (Pair) message.obj;
                    deliverResultCallback((ResultCallback) pair.first, (Result) pair.second);
                case CALLBACK_ON_TIMEOUT /*2*/:
                    ((AbstractPendingResult) message.obj).gD();
                default:
                    Log.wtf("GoogleApi", "Don't know how to handle this message.");
            }
        }

        public void removeTimeoutMessages() {
            removeMessages(CALLBACK_ON_TIMEOUT);
        }

        public void sendResultCallback(ResultCallback<R> resultCallback, R r) {
            sendMessage(obtainMessage(CALLBACK_ON_COMPLETE, new Pair(resultCallback, r)));
        }

        public void sendTimeoutResultCallback(AbstractPendingResult<R> abstractPendingResult, long j) {
            sendMessageDelayed(obtainMessage(CALLBACK_ON_TIMEOUT, abstractPendingResult), j);
        }
    }

    static void m1790a(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                Log.w("GoogleApi", "Unable to release " + result, e);
            }
        }
    }
}
