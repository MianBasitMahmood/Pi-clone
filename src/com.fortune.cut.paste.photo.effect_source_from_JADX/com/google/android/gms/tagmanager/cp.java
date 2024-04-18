package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C1048c.C1047j;
import com.google.android.gms.tagmanager.C1821o.C1775e;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class cp implements C1775e {
    private String aqI;
    private final String aqm;
    private bg<C1047j> asC;
    private C1824r asD;
    private final ScheduledExecutorService asF;
    private final C1773a asG;
    private ScheduledFuture<?> asH;
    private boolean mClosed;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.cp.b */
    interface C1771b {
        ScheduledExecutorService qh();
    }

    /* renamed from: com.google.android.gms.tagmanager.cp.1 */
    class C17721 implements C1771b {
        final /* synthetic */ cp asI;

        C17721(cp cpVar) {
            this.asI = cpVar;
        }

        public ScheduledExecutorService qh() {
            return Executors.newSingleThreadScheduledExecutor();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cp.a */
    interface C1773a {
        co m6515a(C1824r c1824r);
    }

    /* renamed from: com.google.android.gms.tagmanager.cp.2 */
    class C17742 implements C1773a {
        final /* synthetic */ cp asI;

        C17742(cp cpVar) {
            this.asI = cpVar;
        }

        public co m6516a(C1824r c1824r) {
            return new co(this.asI.mContext, this.asI.aqm, c1824r);
        }
    }

    public cp(Context context, String str, C1824r c1824r) {
        this(context, str, c1824r, null, null);
    }

    cp(Context context, String str, C1824r c1824r, C1771b c1771b, C1773a c1773a) {
        this.asD = c1824r;
        this.mContext = context;
        this.aqm = str;
        if (c1771b == null) {
            c1771b = new C17721(this);
        }
        this.asF = c1771b.qh();
        if (c1773a == null) {
            this.asG = new C17742(this);
        } else {
            this.asG = c1773a;
        }
    }

    private co cM(String str) {
        co a = this.asG.m6515a(this.asD);
        a.m6514a(this.asC);
        a.cw(this.aqI);
        a.cL(str);
        return a;
    }

    private synchronized void qg() {
        if (this.mClosed) {
            throw new IllegalStateException("called method after closed");
        }
    }

    public synchronized void m6521a(bg<C1047j> bgVar) {
        qg();
        this.asC = bgVar;
    }

    public synchronized void cw(String str) {
        qg();
        this.aqI = str;
    }

    public synchronized void m6522e(long j, String str) {
        bh.m6460V("loadAfterDelay: containerId=" + this.aqm + " delay=" + j);
        qg();
        if (this.asC == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.asH != null) {
            this.asH.cancel(false);
        }
        this.asH = this.asF.schedule(cM(str), j, TimeUnit.MILLISECONDS);
    }

    public synchronized void release() {
        qg();
        if (this.asH != null) {
            this.asH.cancel(false);
        }
        this.asF.shutdown();
        this.mClosed = true;
    }
}
