package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.jx;

/* renamed from: com.google.android.gms.common.api.d */
public final class C0509d<L> {
    private final C0508a Kt;
    private volatile L mListener;

    /* renamed from: com.google.android.gms.common.api.d.b */
    public interface C0493b<L> {
        void m1809c(L l);

        void gG();
    }

    /* renamed from: com.google.android.gms.common.api.d.a */
    private final class C0508a extends Handler {
        final /* synthetic */ C0509d Ku;

        public C0508a(C0509d c0509d, Looper looper) {
            this.Ku = c0509d;
            super(looper);
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            if (message.what != 1) {
                z = false;
            }
            jx.m5216L(z);
            this.Ku.m1841b((C0493b) message.obj);
        }
    }

    C0509d(Looper looper, L l) {
        this.Kt = new C0508a(this, looper);
        this.mListener = jx.m5219b((Object) l, (Object) "Listener must not be null");
    }

    public final void m1840a(C0493b<? super L> c0493b) {
        jx.m5219b((Object) c0493b, (Object) "Notifier must not be null");
        this.Kt.sendMessage(this.Kt.obtainMessage(1, c0493b));
    }

    final void m1841b(C0493b<? super L> c0493b) {
        Object obj = this.mListener;
        if (obj == null) {
            c0493b.gG();
            return;
        }
        try {
            c0493b.m1809c(obj);
        } catch (Throwable e) {
            Log.w("ListenerHolder", "Notifying listener failed", e);
            c0493b.gG();
        }
    }

    public final void clear() {
        this.mListener = null;
    }
}
