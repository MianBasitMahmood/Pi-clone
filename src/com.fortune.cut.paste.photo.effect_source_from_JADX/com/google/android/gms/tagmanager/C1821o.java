package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.BaseImplementation.AbstractPendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C1048c.C1043f;
import com.google.android.gms.internal.C1048c.C1047j;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import com.google.android.gms.internal.pu.C1446a;
import com.google.android.gms.tagmanager.C1814n.C1812a;
import com.google.android.gms.tagmanager.bg.C1763a;
import com.google.android.gms.tagmanager.ce.C1770a;
import com.google.android.gms.tagmanager.cr.C1782c;

/* renamed from: com.google.android.gms.tagmanager.o */
class C1821o extends AbstractPendingResult<ContainerHolder> {
    private final Looper JF;
    private final C1820d aqB;
    private final cg aqC;
    private final int aqD;
    private C1778f aqE;
    private volatile C1814n aqF;
    private volatile boolean aqG;
    private C1047j aqH;
    private String aqI;
    private C1775e aqJ;
    private C1816a aqK;
    private final String aqm;
    private long aqr;
    private final TagManager aqy;
    private final Context mContext;
    private final ld wb;

    /* renamed from: com.google.android.gms.tagmanager.o.e */
    interface C1775e extends Releasable {
        void m6517a(bg<C1047j> bgVar);

        void cw(String str);

        void m6518e(long j, String str);
    }

    /* renamed from: com.google.android.gms.tagmanager.o.f */
    interface C1778f extends Releasable {
        void m6523a(bg<C1446a> bgVar);

        void m6524b(C1446a c1446a);

        C1782c fH(int i);

        void pt();
    }

    /* renamed from: com.google.android.gms.tagmanager.o.1 */
    class C18151 implements C1812a {
        final /* synthetic */ C1821o aqL;

        C18151(C1821o c1821o) {
            this.aqL = c1821o;
        }

        public void ct(String str) {
            this.aqL.ct(str);
        }

        public String pl() {
            return this.aqL.pl();
        }

        public void pn() {
            bh.m6461W("Refresh ignored: container loaded as default only.");
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.a */
    interface C1816a {
        boolean m6650b(Container container);
    }

    /* renamed from: com.google.android.gms.tagmanager.o.2 */
    class C18172 implements C1816a {
        final /* synthetic */ C1821o aqL;
        final /* synthetic */ boolean aqM;

        C18172(C1821o c1821o, boolean z) {
            this.aqL = c1821o;
            this.aqM = z;
        }

        public boolean m6651b(Container container) {
            return this.aqM ? container.getLastRefreshTime() + 43200000 >= this.aqL.wb.currentTimeMillis() : !container.isDefault();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.b */
    private class C1818b implements bg<C1446a> {
        final /* synthetic */ C1821o aqL;

        private C1818b(C1821o c1821o) {
            this.aqL = c1821o;
        }

        public void m6652a(C1446a c1446a) {
            C1047j c1047j;
            if (c1446a.auC != null) {
                c1047j = c1446a.auC;
            } else {
                C1043f c1043f = c1446a.gs;
                c1047j = new C1047j();
                c1047j.gs = c1043f;
                c1047j.gr = null;
                c1047j.gt = c1043f.version;
            }
            this.aqL.m6661a(c1047j, c1446a.auB, true);
        }

        public void m6653a(C1763a c1763a) {
            if (!this.aqL.aqG) {
                this.aqL.m6671w(0);
            }
        }

        public /* synthetic */ void m6654l(Object obj) {
            m6652a((C1446a) obj);
        }

        public void ps() {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.c */
    private class C1819c implements bg<C1047j> {
        final /* synthetic */ C1821o aqL;

        private C1819c(C1821o c1821o) {
            this.aqL = c1821o;
        }

        public void m6655a(C1763a c1763a) {
            if (this.aqL.aqF != null) {
                this.aqL.m1615b(this.aqL.aqF);
            } else {
                this.aqL.m1615b(this.aqL.aD(Status.Kz));
            }
            this.aqL.m6671w(3600000);
        }

        public void m6656b(C1047j c1047j) {
            synchronized (this.aqL) {
                if (c1047j.gs == null) {
                    if (this.aqL.aqH.gs == null) {
                        bh.m6458T("Current resource is null; network resource is also null");
                        this.aqL.m6671w(3600000);
                        return;
                    }
                    c1047j.gs = this.aqL.aqH.gs;
                }
                this.aqL.m6661a(c1047j, this.aqL.wb.currentTimeMillis(), false);
                bh.m6460V("setting refresh time to current time: " + this.aqL.aqr);
                if (!this.aqL.pr()) {
                    this.aqL.m6660a(c1047j);
                }
            }
        }

        public /* synthetic */ void m6657l(Object obj) {
            m6656b((C1047j) obj);
        }

        public void ps() {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.d */
    private class C1820d implements C1812a {
        final /* synthetic */ C1821o aqL;

        private C1820d(C1821o c1821o) {
            this.aqL = c1821o;
        }

        public void ct(String str) {
            this.aqL.ct(str);
        }

        public String pl() {
            return this.aqL.pl();
        }

        public void pn() {
            if (this.aqL.aqC.fe()) {
                this.aqL.m6671w(0);
            }
        }
    }

    C1821o(Context context, TagManager tagManager, Looper looper, String str, int i, C1778f c1778f, C1775e c1775e, ld ldVar, cg cgVar) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.aqy = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.JF = looper;
        this.aqm = str;
        this.aqD = i;
        this.aqE = c1778f;
        this.aqJ = c1775e;
        this.aqB = new C1820d();
        this.aqH = new C1047j();
        this.wb = ldVar;
        this.aqC = cgVar;
        if (pr()) {
            ct(ce.qa().qc());
        }
    }

    public C1821o(Context context, TagManager tagManager, Looper looper, String str, int i, C1824r c1824r) {
        this(context, tagManager, looper, str, i, new cq(context, str), new cp(context, str, c1824r), lf.m5325if(), new bf(30, 900000, 5000, "refreshing", lf.m5325if()));
    }

    private void m6658V(boolean z) {
        this.aqE.m6523a(new C1818b());
        this.aqJ.m6517a(new C1819c());
        C1782c fH = this.aqE.fH(this.aqD);
        if (fH != null) {
            this.aqF = new C1814n(this.aqy, this.JF, new Container(this.mContext, this.aqy.getDataLayer(), this.aqm, 0, fH), this.aqB);
        }
        this.aqK = new C18172(this, z);
        if (pr()) {
            this.aqJ.m6518e(0, "");
        } else {
            this.aqE.pt();
        }
    }

    private synchronized void m6660a(C1047j c1047j) {
        if (this.aqE != null) {
            C1446a c1446a = new C1446a();
            c1446a.auB = this.aqr;
            c1446a.gs = new C1043f();
            c1446a.auC = c1047j;
            this.aqE.m6524b(c1446a);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m6661a(com.google.android.gms.internal.C1048c.C1047j r9, long r10, boolean r12) {
        /*
        r8 = this;
        r6 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        monitor-enter(r8);
        if (r12 == 0) goto L_0x000c;
    L_0x0006:
        r0 = r8.aqG;	 Catch:{ all -> 0x0068 }
        if (r0 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r8);
        return;
    L_0x000c:
        r0 = r8.isReady();	 Catch:{ all -> 0x0068 }
        if (r0 == 0) goto L_0x0014;
    L_0x0012:
        r0 = r8.aqF;	 Catch:{ all -> 0x0068 }
    L_0x0014:
        r8.aqH = r9;	 Catch:{ all -> 0x0068 }
        r8.aqr = r10;	 Catch:{ all -> 0x0068 }
        r0 = 0;
        r2 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        r4 = r8.aqr;	 Catch:{ all -> 0x0068 }
        r4 = r4 + r6;
        r6 = r8.wb;	 Catch:{ all -> 0x0068 }
        r6 = r6.currentTimeMillis();	 Catch:{ all -> 0x0068 }
        r4 = r4 - r6;
        r2 = java.lang.Math.min(r2, r4);	 Catch:{ all -> 0x0068 }
        r0 = java.lang.Math.max(r0, r2);	 Catch:{ all -> 0x0068 }
        r8.m6671w(r0);	 Catch:{ all -> 0x0068 }
        r0 = new com.google.android.gms.tagmanager.Container;	 Catch:{ all -> 0x0068 }
        r1 = r8.mContext;	 Catch:{ all -> 0x0068 }
        r2 = r8.aqy;	 Catch:{ all -> 0x0068 }
        r2 = r2.getDataLayer();	 Catch:{ all -> 0x0068 }
        r3 = r8.aqm;	 Catch:{ all -> 0x0068 }
        r4 = r10;
        r6 = r9;
        r0.<init>(r1, r2, r3, r4, r6);	 Catch:{ all -> 0x0068 }
        r1 = r8.aqF;	 Catch:{ all -> 0x0068 }
        if (r1 != 0) goto L_0x006b;
    L_0x0047:
        r1 = new com.google.android.gms.tagmanager.n;	 Catch:{ all -> 0x0068 }
        r2 = r8.aqy;	 Catch:{ all -> 0x0068 }
        r3 = r8.JF;	 Catch:{ all -> 0x0068 }
        r4 = r8.aqB;	 Catch:{ all -> 0x0068 }
        r1.<init>(r2, r3, r0, r4);	 Catch:{ all -> 0x0068 }
        r8.aqF = r1;	 Catch:{ all -> 0x0068 }
    L_0x0054:
        r1 = r8.isReady();	 Catch:{ all -> 0x0068 }
        if (r1 != 0) goto L_0x000a;
    L_0x005a:
        r1 = r8.aqK;	 Catch:{ all -> 0x0068 }
        r0 = r1.m6650b(r0);	 Catch:{ all -> 0x0068 }
        if (r0 == 0) goto L_0x000a;
    L_0x0062:
        r0 = r8.aqF;	 Catch:{ all -> 0x0068 }
        r8.m1615b(r0);	 Catch:{ all -> 0x0068 }
        goto L_0x000a;
    L_0x0068:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x006b:
        r1 = r8.aqF;	 Catch:{ all -> 0x0068 }
        r1.m6649a(r0);	 Catch:{ all -> 0x0068 }
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.o.a(com.google.android.gms.internal.c$j, long, boolean):void");
    }

    private boolean pr() {
        ce qa = ce.qa();
        return (qa.qb() == C1770a.CONTAINER || qa.qb() == C1770a.CONTAINER_DEBUG) && this.aqm.equals(qa.getContainerId());
    }

    private synchronized void m6671w(long j) {
        if (this.aqJ == null) {
            bh.m6461W("Refresh requested, but no network load scheduler.");
        } else {
            this.aqJ.m6518e(j, this.aqH.gt);
        }
    }

    protected ContainerHolder aD(Status status) {
        if (this.aqF != null) {
            return this.aqF;
        }
        if (status == Status.Kz) {
            bh.m6458T("timer expired: setting result to failure");
        }
        return new C1814n(status);
    }

    protected /* synthetic */ Result m6672c(Status status) {
        return aD(status);
    }

    synchronized void ct(String str) {
        this.aqI = str;
        if (this.aqJ != null) {
            this.aqJ.cw(str);
        }
    }

    synchronized String pl() {
        return this.aqI;
    }

    public void po() {
        C1782c fH = this.aqE.fH(this.aqD);
        if (fH != null) {
            m1615b(new C1814n(this.aqy, this.JF, new Container(this.mContext, this.aqy.getDataLayer(), this.aqm, 0, fH), new C18151(this)));
        } else {
            String str = "Default was requested, but no default container was found";
            bh.m6458T(str);
            m1615b(aD(new Status(10, str, null)));
        }
        this.aqJ = null;
        this.aqE = null;
    }

    public void pp() {
        m6658V(false);
    }

    public void pq() {
        m6658V(true);
    }
}
