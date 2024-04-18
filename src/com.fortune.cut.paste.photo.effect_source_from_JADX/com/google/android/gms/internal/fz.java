package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@ey
public class fz {
    private final Object mH;
    private boolean uQ;
    private final ga vL;
    private final LinkedList<C1161a> vM;
    private final String vN;
    private final String vO;
    private long vP;
    private long vQ;
    private long vR;
    private long vS;
    private long vT;
    private long vU;

    @ey
    /* renamed from: com.google.android.gms.internal.fz.a */
    private static final class C1161a {
        private long vV;
        private long vW;

        public C1161a() {
            this.vV = -1;
            this.vW = -1;
        }

        public final long cZ() {
            return this.vW;
        }

        public final void da() {
            this.vW = SystemClock.elapsedRealtime();
        }

        public final void db() {
            this.vV = SystemClock.elapsedRealtime();
        }

        public final Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", this.vV);
            bundle.putLong("tclose", this.vW);
            return bundle;
        }
    }

    public fz(ga gaVar, String str, String str2) {
        this.mH = new Object();
        this.vP = -1;
        this.vQ = -1;
        this.uQ = false;
        this.vR = -1;
        this.vS = 0;
        this.vT = -1;
        this.vU = -1;
        this.vL = gaVar;
        this.vN = str;
        this.vO = str2;
        this.vM = new LinkedList();
    }

    public fz(String str, String str2) {
        this(ga.dc(), str, str2);
    }

    public void cW() {
        synchronized (this.mH) {
            if (this.vU != -1 && this.vQ == -1) {
                this.vQ = SystemClock.elapsedRealtime();
                this.vL.m4692a(this);
            }
            ga gaVar = this.vL;
            ga.dh().cW();
        }
    }

    public void cX() {
        synchronized (this.mH) {
            if (this.vU != -1) {
                C1161a c1161a = new C1161a();
                c1161a.db();
                this.vM.add(c1161a);
                this.vS++;
                ga gaVar = this.vL;
                ga.dh().cX();
                this.vL.m4692a(this);
            }
        }
    }

    public void cY() {
        synchronized (this.mH) {
            if (!(this.vU == -1 || this.vM.isEmpty())) {
                C1161a c1161a = (C1161a) this.vM.getLast();
                if (c1161a.cZ() == -1) {
                    c1161a.da();
                    this.vL.m4692a(this);
                }
            }
        }
    }

    public void m4676e(av avVar) {
        synchronized (this.mH) {
            this.vT = SystemClock.elapsedRealtime();
            ga gaVar = this.vL;
            ga.dh().m4706b(avVar, this.vT);
        }
    }

    public void m4677j(long j) {
        synchronized (this.mH) {
            this.vU = j;
            if (this.vU != -1) {
                this.vL.m4692a(this);
            }
        }
    }

    public void m4678k(long j) {
        synchronized (this.mH) {
            if (this.vU != -1) {
                this.vP = j;
                this.vL.m4692a(this);
            }
        }
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.mH) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.vN);
            bundle.putString("slotid", this.vO);
            bundle.putBoolean("ismediation", this.uQ);
            bundle.putLong("treq", this.vT);
            bundle.putLong("tresponse", this.vU);
            bundle.putLong("timp", this.vQ);
            bundle.putLong("tload", this.vR);
            bundle.putLong("pcc", this.vS);
            bundle.putLong("tfetch", this.vP);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.vM.iterator();
            while (it.hasNext()) {
                arrayList.add(((C1161a) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public void m4679v(boolean z) {
        synchronized (this.mH) {
            if (this.vU != -1) {
                this.vR = SystemClock.elapsedRealtime();
                if (!z) {
                    this.vQ = this.vR;
                    this.vL.m4692a(this);
                }
            }
        }
    }

    public void m4680w(boolean z) {
        synchronized (this.mH) {
            if (this.vU != -1) {
                this.uQ = z;
                this.vL.m4692a(this);
            }
        }
    }
}
