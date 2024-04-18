package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.ez.C1118a;
import com.google.android.gms.internal.fe.C1137a;
import com.google.android.gms.internal.fh.C1147a;
import com.google.android.gms.internal.fy.C1160a;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class fa extends gf implements C1137a {
    private final Context mContext;
    private final Object mH;
    private cr qi;
    private final C1118a ti;
    private final Object tj;
    private final C1147a tk;
    private final C1266k tl;
    private gf tm;
    private fj tn;

    /* renamed from: com.google.android.gms.internal.fa.1 */
    class C11341 implements Runnable {
        final /* synthetic */ fa to;

        C11341(fa faVar) {
            this.to = faVar;
        }

        public void run() {
            this.to.onStop();
        }
    }

    /* renamed from: com.google.android.gms.internal.fa.2 */
    class C11352 implements Runnable {
        final /* synthetic */ fa to;
        final /* synthetic */ C1160a tp;

        C11352(fa faVar, C1160a c1160a) {
            this.to = faVar;
            this.tp = c1160a;
        }

        public void run() {
            synchronized (this.to.mH) {
                this.to.ti.m4546a(this.tp);
            }
        }
    }

    @ey
    /* renamed from: com.google.android.gms.internal.fa.a */
    private static final class C1136a extends Exception {
        private final int tq;

        public C1136a(String str, int i) {
            super(str);
            this.tq = i;
        }

        public final int getErrorCode() {
            return this.tq;
        }
    }

    public fa(Context context, C1147a c1147a, C1266k c1266k, C1118a c1118a) {
        this.tj = new Object();
        this.mH = new Object();
        this.ti = c1118a;
        this.mContext = context;
        this.tk = c1147a;
        this.tl = c1266k;
    }

    private ay m4563a(fh fhVar) throws C1136a {
        if (this.tn.tZ == null) {
            throw new C1136a("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.tn.tZ.split("x");
        if (split.length != 2) {
            throw new C1136a("Could not parse the ad size from the ad response: " + this.tn.tZ, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (ay ayVar : fhVar.lS.or) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i = ayVar.width == -1 ? (int) (((float) ayVar.widthPixels) / f) : ayVar.width;
                int i2 = ayVar.height == -2 ? (int) (((float) ayVar.heightPixels) / f) : ayVar.height;
                if (parseInt == i && parseInt2 == i2) {
                    return new ay(ayVar, fhVar.lS.or);
                }
            }
            throw new C1136a("The ad size from the ad response was not one of the requested sizes: " + this.tn.tZ, 0);
        } catch (NumberFormatException e) {
            throw new C1136a("Could not parse the ad size from the ad response: " + this.tn.tZ, 0);
        }
    }

    private boolean m4566c(long j) throws C1136a {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.mH.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new C1136a("Ad request cancelled.", -1);
        }
    }

    private void cE() throws C1136a {
        if (this.tn.errorCode != -3) {
            if (TextUtils.isEmpty(this.tn.tU)) {
                throw new C1136a("No fill from ad server.", 3);
            }
            ga.m4687a(this.mContext, this.tn.tT);
            if (this.tn.tW) {
                try {
                    this.qi = new cr(this.tn.tU);
                } catch (JSONException e) {
                    throw new C1136a("Could not parse mediation config: " + this.tn.tU, 0);
                }
            }
        }
    }

    private void m4567e(long j) throws C1136a {
        while (m4566c(j)) {
            if (this.tn != null) {
                synchronized (this.tj) {
                    this.tm = null;
                }
                if (this.tn.errorCode != -2 && this.tn.errorCode != -3) {
                    throw new C1136a("There was a problem getting an ad response. ErrorCode: " + this.tn.errorCode, this.tn.errorCode);
                }
                return;
            }
        }
        throw new C1136a("Timed out waiting for ad response.", 2);
    }

    private void m4568t(boolean z) {
        ga.dc().m4703x(z);
        an l = ga.dc().m4702l(this.mContext);
        if (l != null && !l.isAlive()) {
            gr.m4769S("start fetching content...");
            l.ba();
        }
    }

    public void m4569a(fj fjVar) {
        synchronized (this.mH) {
            gr.m4769S("Received ad response.");
            this.tn = fjVar;
            this.mH.notify();
        }
    }

    public void cx() {
        ay a;
        C1136a e;
        JSONObject jSONObject;
        synchronized (this.mH) {
            long elapsedRealtime;
            gr.m4769S("AdLoaderBackgroundTask started.");
            fh fhVar = new fh(this.tk, this.tl.m5236C().m4681a(this.mContext));
            int i = -2;
            long j = -1;
            try {
                elapsedRealtime = SystemClock.elapsedRealtime();
                gf a2 = fe.m4593a(this.mContext, fhVar, this);
                synchronized (this.tj) {
                    this.tm = a2;
                    if (this.tm == null) {
                        throw new C1136a("Could not start the ad request service.", 0);
                    }
                }
                m4567e(elapsedRealtime);
                j = SystemClock.elapsedRealtime();
                cE();
                a = fhVar.lS.or != null ? m4563a(fhVar) : null;
                try {
                    m4568t(this.tn.uh);
                    elapsedRealtime = j;
                } catch (C1136a e2) {
                    e = e2;
                    i = e.getErrorCode();
                    if (i != 3) {
                    }
                    gr.m4771U(e.getMessage());
                    if (this.tn != null) {
                        this.tn = new fj(i, this.tn.qA);
                    } else {
                        this.tn = new fj(i);
                    }
                    gq.wR.post(new C11341(this));
                    elapsedRealtime = j;
                    if (!TextUtils.isEmpty(this.tn.ue)) {
                        try {
                            jSONObject = new JSONObject(this.tn.ue);
                        } catch (Throwable e3) {
                            gr.m4775b("Error parsing the JSON for Active View.", e3);
                        }
                        gq.wR.post(new C11352(this, new C1160a(fhVar, this.tn, this.qi, a, i, elapsedRealtime, this.tn.ua, jSONObject)));
                    }
                    jSONObject = null;
                    gq.wR.post(new C11352(this, new C1160a(fhVar, this.tn, this.qi, a, i, elapsedRealtime, this.tn.ua, jSONObject)));
                }
            } catch (C1136a e4) {
                e = e4;
                a = null;
                i = e.getErrorCode();
                if (i != 3 || i == -1) {
                    gr.m4771U(e.getMessage());
                } else {
                    gr.m4773W(e.getMessage());
                }
                if (this.tn != null) {
                    this.tn = new fj(i);
                } else {
                    this.tn = new fj(i, this.tn.qA);
                }
                gq.wR.post(new C11341(this));
                elapsedRealtime = j;
                if (TextUtils.isEmpty(this.tn.ue)) {
                    jSONObject = new JSONObject(this.tn.ue);
                    gq.wR.post(new C11352(this, new C1160a(fhVar, this.tn, this.qi, a, i, elapsedRealtime, this.tn.ua, jSONObject)));
                }
                jSONObject = null;
                gq.wR.post(new C11352(this, new C1160a(fhVar, this.tn, this.qi, a, i, elapsedRealtime, this.tn.ua, jSONObject)));
            }
            if (TextUtils.isEmpty(this.tn.ue)) {
                jSONObject = new JSONObject(this.tn.ue);
                gq.wR.post(new C11352(this, new C1160a(fhVar, this.tn, this.qi, a, i, elapsedRealtime, this.tn.ua, jSONObject)));
            }
            jSONObject = null;
            gq.wR.post(new C11352(this, new C1160a(fhVar, this.tn, this.qi, a, i, elapsedRealtime, this.tn.ua, jSONObject)));
        }
    }

    public void onStop() {
        synchronized (this.tj) {
            if (this.tm != null) {
                this.tm.cancel();
            }
        }
    }
}
