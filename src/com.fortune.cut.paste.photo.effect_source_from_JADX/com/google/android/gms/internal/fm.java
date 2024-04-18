package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.fc.C1139a;
import com.google.android.gms.internal.fy.C1160a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@ey
public class fm extends gf {
    private final Object mH;
    private final C1139a tA;
    private final C1160a tB;
    private final fj tn;
    private final fn ui;
    private Future<fy> uj;

    /* renamed from: com.google.android.gms.internal.fm.1 */
    class C11501 implements Runnable {
        final /* synthetic */ fy tG;
        final /* synthetic */ fm uk;

        C11501(fm fmVar, fy fyVar) {
            this.uk = fmVar;
            this.tG = fyVar;
        }

        public void run() {
            this.uk.tA.m4581a(this.tG);
        }
    }

    public fm(Context context, C1494u c1494u, ai aiVar, C1160a c1160a, C1139a c1139a) {
        this(c1160a, c1139a, new fn(context, c1494u, aiVar, new gn(), c1160a));
    }

    fm(C1160a c1160a, C1139a c1139a, fn fnVar) {
        this.mH = new Object();
        this.tB = c1160a;
        this.tn = c1160a.vK;
        this.tA = c1139a;
        this.ui = fnVar;
    }

    private fy m4610s(int i) {
        return new fy(this.tB.vJ.tL, null, null, i, null, null, this.tn.orientation, this.tn.qA, this.tB.vJ.tO, false, null, null, null, null, null, this.tn.tX, this.tB.lS, this.tn.tV, this.tB.vG, this.tn.ua, this.tn.ub, this.tB.vD, null);
    }

    public void cx() {
        fy fyVar;
        int i;
        try {
            synchronized (this.mH) {
                this.uj = gh.submit(this.ui);
            }
            fyVar = (fy) this.uj.get(60000, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (TimeoutException e) {
            gr.m4773W("Timed out waiting for native ad.");
            i = 2;
            fyVar = null;
        } catch (ExecutionException e2) {
            i = 0;
            fyVar = null;
        } catch (InterruptedException e3) {
            fyVar = null;
            i = -1;
        } catch (CancellationException e4) {
            fyVar = null;
            i = -1;
        }
        if (fyVar == null) {
            fyVar = m4610s(i);
        }
        gq.wR.post(new C11501(this, fyVar));
    }

    public void onStop() {
        synchronized (this.mH) {
            if (this.uj != null) {
                this.uj.cancel(true);
            }
        }
    }
}
