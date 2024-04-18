package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.ah.C1000a;
import com.google.android.gms.internal.gv.C1012a;
import org.json.JSONObject;

@ey
public class aj implements ah {
    private final gu mo;

    /* renamed from: com.google.android.gms.internal.aj.1 */
    class C10101 implements Runnable {
        final /* synthetic */ String nl;
        final /* synthetic */ JSONObject nm;
        final /* synthetic */ aj nn;

        C10101(aj ajVar, String str, JSONObject jSONObject) {
            this.nn = ajVar;
            this.nl = str;
            this.nm = jSONObject;
        }

        public void run() {
            this.nn.mo.m4788a(this.nl, this.nm);
        }
    }

    /* renamed from: com.google.android.gms.internal.aj.2 */
    class C10112 implements Runnable {
        final /* synthetic */ String ni;
        final /* synthetic */ aj nn;

        C10112(aj ajVar, String str) {
            this.nn = ajVar;
            this.ni = str;
        }

        public void run() {
            this.nn.mo.loadUrl(this.ni);
        }
    }

    /* renamed from: com.google.android.gms.internal.aj.3 */
    class C10133 implements C1012a {
        final /* synthetic */ aj nn;
        final /* synthetic */ C1000a no;

        C10133(aj ajVar, C1000a c1000a) {
            this.nn = ajVar;
            this.no = c1000a;
        }

        public void m4148a(gu guVar) {
            this.no.aR();
        }
    }

    public aj(Context context, gs gsVar) {
        this.mo = gu.m4782a(context, new ay(), false, false, null, gsVar);
    }

    private void runOnUiThread(Runnable runnable) {
        if (gq.dB()) {
            runnable.run();
        } else {
            gq.wR.post(runnable);
        }
    }

    public void m4150a(C1000a c1000a) {
        this.mo.dD().m4797a(new C10133(this, c1000a));
    }

    public void m4151a(C1486t c1486t, ds dsVar, cb cbVar, dv dvVar, boolean z, ce ceVar) {
        this.mo.dD().m4799a(c1486t, dsVar, cbVar, dvVar, z, ceVar, new C1497v(false));
    }

    public void m4152a(String str, cd cdVar) {
        this.mo.dD().m4800a(str, cdVar);
    }

    public void m4153a(String str, JSONObject jSONObject) {
        runOnUiThread(new C10101(this, str, jSONObject));
    }

    public void destroy() {
        this.mo.destroy();
    }

    public void m4154f(String str) {
        runOnUiThread(new C10112(this, str));
    }

    public void m4155g(String str) {
        this.mo.dD().m4800a(str, null);
    }

    public void pause() {
        gi.m4729a(this.mo);
    }

    public void resume() {
        gi.m4734b(this.mo);
    }
}
