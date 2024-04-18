package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.ah.C1000a;
import java.util.concurrent.Future;

@ey
public class ai {

    /* renamed from: com.google.android.gms.internal.ai.1 */
    class C10081 implements Runnable {
        final /* synthetic */ Context nf;
        final /* synthetic */ gs ng;
        final /* synthetic */ gj nh;
        final /* synthetic */ String ni;
        final /* synthetic */ ai nj;

        C10081(ai aiVar, Context context, gs gsVar, gj gjVar, String str) {
            this.nj = aiVar;
            this.nf = context;
            this.ng = gsVar;
            this.nh = gjVar;
            this.ni = str;
        }

        public void run() {
            this.nj.m4145a(this.nf, this.ng, this.nh).m4143f(this.ni);
        }
    }

    /* renamed from: com.google.android.gms.internal.ai.2 */
    class C10092 implements C1000a {
        final /* synthetic */ gj nh;
        final /* synthetic */ ai nj;
        final /* synthetic */ ah nk;

        C10092(ai aiVar, gj gjVar, ah ahVar) {
            this.nj = aiVar;
            this.nh = gjVar;
            this.nk = ahVar;
        }

        public void aR() {
            this.nh.m4747a(this.nk);
        }
    }

    protected ah m4145a(Context context, gs gsVar, gj<ah> gjVar) {
        ah ajVar = new aj(context, gsVar);
        ajVar.m4139a(new C10092(this, gjVar, ajVar));
        return ajVar;
    }

    public Future<ah> m4146a(Context context, gs gsVar, String str) {
        Future gjVar = new gj();
        gq.wR.post(new C10081(this, context, gsVar, gjVar, str));
        return gjVar;
    }
}
