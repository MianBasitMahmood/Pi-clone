package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.ck.C1059b;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@ey
public class ga implements C1059b {
    private static final ga vX;
    public static final String vY;
    private Context mContext;
    private final Object mH;
    private am nE;
    private al nF;
    private ex nG;
    private gs qJ;
    private boolean uV;
    private boolean uW;
    public final String vZ;
    private final gb wa;
    private ld wb;
    private BigInteger wc;
    private final HashSet<fz> wd;
    private final HashMap<String, gd> we;
    private boolean wf;
    private boolean wg;
    private an wh;
    private LinkedList<Thread> wi;
    private boolean wj;
    private Bundle wk;
    private String wl;

    static {
        ga gaVar = new ga();
        vX = gaVar;
        vY = gaVar.vZ;
    }

    private ga() {
        this.mH = new Object();
        this.wc = BigInteger.ONE;
        this.wd = new HashSet();
        this.we = new HashMap();
        this.wf = false;
        this.uV = true;
        this.wg = false;
        this.uW = true;
        this.nE = null;
        this.wh = null;
        this.nF = null;
        this.wi = new LinkedList();
        this.wj = false;
        this.wk = bn.by();
        this.nG = null;
        this.vZ = gi.dx();
        this.wa = new gb(this.vZ);
    }

    public static Bundle m4685a(Context context, gc gcVar, String str) {
        return vX.m4695b(context, gcVar, str);
    }

    public static void m4686a(Context context, gs gsVar) {
        vX.m4696b(context, gsVar);
    }

    public static void m4687a(Context context, boolean z) {
        vX.m4697b(context, z);
    }

    public static void m4688b(HashSet<fz> hashSet) {
        vX.m4698c(hashSet);
    }

    public static Bundle bN() {
        return vX.dp();
    }

    public static String m4689c(int i, String str) {
        return vX.m4699d(i, str);
    }

    public static ga dc() {
        return vX;
    }

    public static String df() {
        return vX.dg();
    }

    public static gb dh() {
        return vX.di();
    }

    public static boolean dj() {
        return vX.dk();
    }

    public static boolean dl() {
        return vX.dm();
    }

    public static String dn() {
        return vX.m4700do();
    }

    public static void m4690e(Throwable th) {
        vX.m4701f(th);
    }

    public void m4691a(Bundle bundle) {
        synchronized (this.mH) {
            this.wj = true;
            this.wk = bundle;
            while (!this.wi.isEmpty()) {
                ex.m4538a(this.mContext, (Thread) this.wi.remove(0), this.qJ);
            }
        }
    }

    public void m4692a(fz fzVar) {
        synchronized (this.mH) {
            this.wd.add(fzVar);
        }
    }

    public void m4693a(String str, gd gdVar) {
        synchronized (this.mH) {
            this.we.put(str, gdVar);
        }
    }

    public void m4694a(Thread thread) {
        synchronized (this.mH) {
            if (this.wj) {
                ex.m4538a(this.mContext, thread, this.qJ);
            } else {
                this.wi.add(thread);
            }
        }
    }

    public Bundle m4695b(Context context, gc gcVar, String str) {
        Bundle bundle;
        synchronized (this.mH) {
            bundle = new Bundle();
            bundle.putBundle("app", this.wa.m4705b(context, str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.we.keySet()) {
                bundle2.putBundle(str2, ((gd) this.we.get(str2)).toBundle());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.wd.iterator();
            while (it.hasNext()) {
                arrayList.add(((fz) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            gcVar.m4707a(this.wd);
            this.wd.clear();
        }
        return bundle;
    }

    public void m4696b(Context context, gs gsVar) {
        synchronized (this.mH) {
            if (!this.wg) {
                this.mContext = context.getApplicationContext();
                this.qJ = gsVar;
                this.uV = gg.m4713o(context);
                iy.m5062H(context);
                ck.m4356a(context, this);
                m4694a(Thread.currentThread());
                this.wl = gi.m4735c(context, gsVar.wS);
                this.wb = new lf();
                this.wg = true;
            }
        }
    }

    public void m4697b(Context context, boolean z) {
        synchronized (this.mH) {
            if (z != this.uV) {
                this.uV = z;
                gg.m4711a(context, z);
            }
        }
    }

    public void m4698c(HashSet<fz> hashSet) {
        synchronized (this.mH) {
            this.wd.addAll(hashSet);
        }
    }

    public String m4699d(int i, String str) {
        Resources resources = this.qJ.wV ? this.mContext.getResources() : GooglePlayServicesUtil.getRemoteResource(this.mContext);
        return resources == null ? str : resources.getString(i);
    }

    public ld dd() {
        ld ldVar;
        synchronized (this.mH) {
            ldVar = this.wb;
        }
        return ldVar;
    }

    public boolean de() {
        boolean z;
        synchronized (this.mH) {
            z = this.uW;
        }
        return z;
    }

    public String dg() {
        String bigInteger;
        synchronized (this.mH) {
            bigInteger = this.wc.toString();
            this.wc = this.wc.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public gb di() {
        gb gbVar;
        synchronized (this.mH) {
            gbVar = this.wa;
        }
        return gbVar;
    }

    public boolean dk() {
        boolean z;
        synchronized (this.mH) {
            z = this.wf;
            this.wf = true;
        }
        return z;
    }

    public boolean dm() {
        boolean z;
        synchronized (this.mH) {
            z = this.uV;
        }
        return z;
    }

    public String m4700do() {
        String str;
        synchronized (this.mH) {
            str = this.wl;
        }
        return str;
    }

    public Bundle dp() {
        Bundle bundle;
        synchronized (this.mH) {
            bundle = this.wk;
        }
        return bundle;
    }

    public void m4701f(Throwable th) {
        if (this.wg) {
            new ex(this.mContext, this.qJ, null, null).m4544b(th);
        }
    }

    public an m4702l(Context context) {
        an anVar = null;
        if (bN().getBoolean(bn.pp.getKey(), false) && ll.ij() && !de()) {
            synchronized (this.mH) {
                if (this.nE == null) {
                    if (context instanceof Activity) {
                        this.nE = new am((Application) context.getApplicationContext(), (Activity) context);
                    }
                }
                if (this.nF == null) {
                    this.nF = new al();
                }
                if (this.wh == null) {
                    this.wh = new an(this.nE, this.nF, this.wk, new ex(this.mContext, this.qJ, null, null));
                }
                this.wh.ba();
                anVar = this.wh;
            }
        }
        return anVar;
    }

    public void m4703x(boolean z) {
        synchronized (this.mH) {
            this.uW = z;
        }
    }
}
