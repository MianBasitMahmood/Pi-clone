package com.google.android.gms.internal;

import java.util.Map;
import java.util.concurrent.Future;

@ey
public final class fs {
    private final Object mH;
    gu mo;
    private String uE;
    private gj<fu> uF;
    public final cd uG;
    public final cd uH;

    /* renamed from: com.google.android.gms.internal.fs.1 */
    class C11581 implements cd {
        final /* synthetic */ fs uI;

        C11581(fs fsVar) {
            this.uI = fsVar;
        }

        public void m4643a(gu guVar, Map<String, String> map) {
            synchronized (this.uI.mH) {
                if (this.uI.uF.isDone()) {
                    return;
                }
                fu fuVar = new fu(1, map);
                gr.m4773W("Invalid " + fuVar.getType() + " request error: " + fuVar.cT());
                this.uI.uF.m4747a(fuVar);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.fs.2 */
    class C11592 implements cd {
        final /* synthetic */ fs uI;

        C11592(fs fsVar) {
            this.uI = fsVar;
        }

        public void m4644a(gu guVar, Map<String, String> map) {
            synchronized (this.uI.mH) {
                if (this.uI.uF.isDone()) {
                    return;
                }
                fu fuVar = new fu(-2, map);
                String url = fuVar.getUrl();
                if (url == null) {
                    gr.m4773W("URL missing in loadAdUrl GMSG.");
                    return;
                }
                if (url.contains("%40mediation_adapters%40")) {
                    String replaceAll = url.replaceAll("%40mediation_adapters%40", ge.m4709a(guVar.getContext(), (String) map.get("check_adapters"), this.uI.uE));
                    fuVar.setUrl(replaceAll);
                    gr.m4772V("Ad request URL modified to " + replaceAll);
                }
                this.uI.uF.m4747a(fuVar);
            }
        }
    }

    public fs(String str) {
        this.mH = new Object();
        this.uF = new gj();
        this.uG = new C11581(this);
        this.uH = new C11592(this);
        this.uE = str;
    }

    public final void m4648b(gu guVar) {
        jx.aU("setAdWebView must be called on the main thread.");
        this.mo = guVar;
    }

    public final Future<fu> cR() {
        return this.uF;
    }

    public final void cS() {
        jx.aU("destroyAdWebView must be called on the main thread.");
        if (this.mo != null) {
            this.mo.destroy();
            this.mo = null;
        }
    }
}
