package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.google.android.gms.internal.bv.C1036a;
import com.google.android.gms.internal.fy.C1160a;
import com.google.android.gms.internal.gn.C1152a;
import com.google.android.gms.plus.PlusShare;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class fn implements Callable<fy> {
    private final Context mContext;
    private final Object mH;
    private final C1494u pM;
    private final C1160a tB;
    private int tq;
    private final gn ul;
    private final ai um;
    private boolean un;
    private List<String> uo;

    /* renamed from: com.google.android.gms.internal.fn.1 */
    class C11511 implements cd {
        final /* synthetic */ ah up;
        final /* synthetic */ gj uq;
        final /* synthetic */ fn ur;

        C11511(fn fnVar, ah ahVar, gj gjVar) {
            this.ur = fnVar;
            this.up = ahVar;
            this.uq = gjVar;
        }

        public void m4611a(gu guVar, Map<String, String> map) {
            this.up.m4144g("/nativeAdPreProcess");
            try {
                String str = (String) map.get("success");
                if (!TextUtils.isEmpty(str)) {
                    this.uq.m4747a(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
                    return;
                }
            } catch (Throwable e) {
                gr.m4775b("Malformed native JSON response.", e);
            }
            this.ur.m4623t(0);
            jx.m5217a(this.ur.cO(), "Unable to set the ad state error!");
            this.uq.m4747a(null);
        }
    }

    /* renamed from: com.google.android.gms.internal.fn.2 */
    class C11532 implements C1152a<Drawable> {
        final /* synthetic */ fn ur;
        final /* synthetic */ boolean us;

        C11532(fn fnVar, boolean z) {
            this.ur = fnVar;
            this.us = z;
        }

        public Drawable m4613a(InputStream inputStream) {
            byte[] d;
            try {
                d = lh.m5331d(inputStream);
            } catch (IOException e) {
                d = null;
            }
            if (d == null) {
                this.ur.m4621a(2, this.us);
                return null;
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(d, 0, d.length);
            if (decodeByteArray != null) {
                return new BitmapDrawable(Resources.getSystem(), decodeByteArray);
            }
            this.ur.m4621a(2, this.us);
            return null;
        }

        public /* synthetic */ Object m4614b(InputStream inputStream) {
            return m4613a(inputStream);
        }

        public Drawable cP() {
            this.ur.m4621a(2, this.us);
            return null;
        }

        public /* synthetic */ Object cQ() {
            return cP();
        }
    }

    /* renamed from: com.google.android.gms.internal.fn.a */
    public interface C1154a<T extends C1036a> {
        T m4615a(fn fnVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException;
    }

    public fn(Context context, C1494u c1494u, ai aiVar, gn gnVar, C1160a c1160a) {
        this.mH = new Object();
        this.mContext = context;
        this.pM = c1494u;
        this.ul = gnVar;
        this.um = aiVar;
        this.tB = c1160a;
        this.un = false;
        this.tq = -2;
        this.uo = null;
    }

    private C1036a m4616a(ah ahVar, C1154a c1154a, JSONObject jSONObject) throws ExecutionException, InterruptedException, JSONException {
        if (cO()) {
            return null;
        }
        String[] b = m4618b(jSONObject.getJSONObject("tracking_urls_and_actions"), "impression_tracking_urls");
        this.uo = b == null ? null : Arrays.asList(b);
        C1036a a = c1154a.m4615a(this, jSONObject);
        if (a == null) {
            gr.m4770T("Failed to retrieve ad assets.");
            return null;
        }
        a.m4270a(new bv(this.pM, ahVar, jSONObject));
        return a;
    }

    private fy m4617a(C1036a c1036a) {
        int i;
        synchronized (this.mH) {
            i = this.tq;
            if (c1036a == null && this.tq == -2) {
                i = 0;
            }
        }
        return new fy(this.tB.vJ.tL, null, this.tB.vK.qw, i, this.tB.vK.qx, this.uo, this.tB.vK.orientation, this.tB.vK.qA, this.tB.vJ.tO, false, null, null, null, null, null, 0, this.tB.lS, this.tB.vK.tV, this.tB.vG, this.tB.vH, this.tB.vK.ub, this.tB.vD, i != -2 ? null : c1036a);
    }

    private String[] m4618b(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    private JSONObject m4619c(ah ahVar) throws TimeoutException, JSONException {
        if (cO()) {
            return null;
        }
        gj gjVar = new gj();
        ahVar.m4141a("/nativeAdPreProcess", new C11511(this, ahVar, gjVar));
        ahVar.m4142a("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.tB.vK.tU));
        return (JSONObject) gjVar.get();
    }

    private ah cN() throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        if (cO()) {
            return null;
        }
        ah ahVar = (ah) this.um.m4146a(this.mContext, this.tB.vJ.lO, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html").get();
        ahVar.m4140a(this.pM, this.pM, this.pM, this.pM, false, this.pM);
        return ahVar;
    }

    public Future<Drawable> m4620a(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        Object string = z ? jSONObject2.getString(PlusShare.KEY_CALL_TO_ACTION_URL) : jSONObject2.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
        if (!TextUtils.isEmpty(string)) {
            return this.ul.m4760a(string, new C11532(this, z));
        }
        m4621a(0, z);
        return new gk(null);
    }

    public void m4621a(int i, boolean z) {
        if (z) {
            m4623t(i);
        }
    }

    protected C1154a m4622b(JSONObject jSONObject) throws JSONException {
        if (cO()) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        if ("2".equals(string)) {
            return new fo();
        }
        if ("1".equals(string)) {
            return new fp();
        }
        m4623t(0);
        return null;
    }

    public fy cM() {
        try {
            ah cN = cN();
            JSONObject c = m4619c(cN);
            return m4617a(m4616a(cN, m4622b(c), c));
        } catch (CancellationException e) {
            if (!this.un) {
                m4623t(0);
            }
            return m4617a(null);
        } catch (ExecutionException e2) {
            if (this.un) {
                m4623t(0);
            }
            return m4617a(null);
        } catch (InterruptedException e3) {
            if (this.un) {
                m4623t(0);
            }
            return m4617a(null);
        } catch (Throwable e4) {
            gr.m4777d("Malformed native JSON response.", e4);
            if (this.un) {
                m4623t(0);
            }
            return m4617a(null);
        } catch (Throwable e42) {
            gr.m4777d("Timeout when loading native ad.", e42);
            if (this.un) {
                m4623t(0);
            }
            return m4617a(null);
        }
    }

    public boolean cO() {
        boolean z;
        synchronized (this.mH) {
            z = this.un;
        }
        return z;
    }

    public /* synthetic */ Object call() throws Exception {
        return cM();
    }

    public void m4623t(int i) {
        synchronized (this.mH) {
            this.un = true;
            this.tq = i;
        }
    }
}
