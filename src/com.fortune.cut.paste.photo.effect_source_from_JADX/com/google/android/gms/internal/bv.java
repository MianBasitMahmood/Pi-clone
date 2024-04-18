package com.google.android.gms.internal;

import com.google.android.gms.analytics.ecommerce.Promotion;
import org.json.JSONObject;

@ey
public class bv {
    private C1494u pM;
    private ah pN;
    private JSONObject pO;

    /* renamed from: com.google.android.gms.internal.bv.a */
    public interface C1036a {
        void m4270a(bv bvVar);
    }

    public bv(C1494u c1494u, ah ahVar, JSONObject jSONObject) {
        this.pM = c1494u;
        this.pN = ahVar;
        this.pO = jSONObject;
    }

    public void aw() {
        this.pM.an();
    }

    public void m4276b(String str, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset", i);
            jSONObject.put("template", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad", this.pO);
            jSONObject2.put(Promotion.ACTION_CLICK, jSONObject);
            this.pN.m4142a("google.afma.nativeAds.handleClick", jSONObject2);
        } catch (Throwable e) {
            gr.m4775b("Unable to create click JSON.", e);
        }
    }
}
