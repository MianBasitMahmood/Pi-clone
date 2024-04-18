package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.internal.ah.C1000a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class af implements OnGlobalLayoutListener, OnScrollChangedListener {
    private final Object mH;
    private final WeakReference<fy> mK;
    private WeakReference<ViewTreeObserver> mL;
    private final WeakReference<View> mM;
    private final ad mN;
    private final Context mO;
    private final ah mP;
    private boolean mQ;
    private final WindowManager mR;
    private final PowerManager mS;
    private final KeyguardManager mT;
    private ag mU;
    private boolean mV;
    private final BlockingQueue<Runnable> mW;
    private long mX;
    private boolean mY;
    private boolean mZ;
    private boolean my;
    private BroadcastReceiver na;
    private final HashSet<ac> nb;

    /* renamed from: com.google.android.gms.internal.af.1 */
    class C10011 implements C1000a {
        final /* synthetic */ View nc;
        final /* synthetic */ af nd;

        C10011(af afVar, View view) {
            this.nd = afVar;
            this.nc = view;
        }

        public void aR() {
            this.nd.mQ = true;
            this.nd.m4134d(this.nc);
            this.nd.aI();
        }
    }

    /* renamed from: com.google.android.gms.internal.af.2 */
    class C10022 implements Runnable {
        final /* synthetic */ af nd;
        final /* synthetic */ JSONObject ne;

        C10022(af afVar, JSONObject jSONObject) {
            this.nd = afVar;
            this.ne = jSONObject;
        }

        public void run() {
            this.nd.m4131a(this.ne);
        }
    }

    /* renamed from: com.google.android.gms.internal.af.3 */
    class C10033 implements Runnable {
        final /* synthetic */ af nd;

        C10033(af afVar) {
            this.nd = afVar;
        }

        public void run() {
            this.nd.m4138g(false);
        }
    }

    /* renamed from: com.google.android.gms.internal.af.4 */
    class C10044 extends BroadcastReceiver {
        final /* synthetic */ af nd;

        C10044(af afVar) {
            this.nd = afVar;
        }

        public void onReceive(Context context, Intent intent) {
            this.nd.m4138g(false);
        }
    }

    /* renamed from: com.google.android.gms.internal.af.5 */
    class C10055 implements cd {
        final /* synthetic */ af nd;

        C10055(af afVar) {
            this.nd = afVar;
        }

        public void m4121a(gu guVar, Map<String, String> map) {
            if (this.nd.m4132a((Map) map)) {
                this.nd.m4127a((View) guVar, (Map) map);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.af.6 */
    class C10066 implements cd {
        final /* synthetic */ af nd;

        C10066(af afVar) {
            this.nd = afVar;
        }

        public void m4122a(gu guVar, Map<String, String> map) {
            if (this.nd.m4132a((Map) map)) {
                gr.m4769S("Received request to untrack: " + this.nd.mN.aH());
                this.nd.destroy();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.af.7 */
    class C10077 implements cd {
        final /* synthetic */ af nd;

        C10077(af afVar) {
            this.nd = afVar;
        }

        public void m4123a(gu guVar, Map<String, String> map) {
            if (this.nd.m4132a((Map) map) && map.containsKey("isVisible")) {
                boolean z = "1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"));
                this.nd.m4136f(Boolean.valueOf(z).booleanValue());
            }
        }
    }

    public af(Context context, ay ayVar, fy fyVar, View view, gs gsVar) {
        this(ayVar, fyVar, gsVar, view, new aj(context, gsVar));
    }

    public af(ay ayVar, fy fyVar, gs gsVar, View view, ah ahVar) {
        this.mH = new Object();
        this.my = false;
        this.mV = false;
        this.mW = new ArrayBlockingQueue(2);
        this.mX = Long.MIN_VALUE;
        this.nb = new HashSet();
        this.mK = new WeakReference(fyVar);
        this.mM = new WeakReference(view);
        this.mL = new WeakReference(null);
        this.mY = true;
        this.mN = new ad(UUID.randomUUID().toString(), gsVar, ayVar.op, fyVar.vD);
        this.mP = ahVar;
        this.mR = (WindowManager) view.getContext().getSystemService("window");
        this.mS = (PowerManager) view.getContext().getApplicationContext().getSystemService("power");
        this.mT = (KeyguardManager) view.getContext().getSystemService("keyguard");
        this.mO = view.getContext().getApplicationContext();
        m4130a(ahVar);
        this.mP.m4139a(new C10011(this, view));
        m4133b(this.mP);
        try {
            this.mW.add(new C10022(this, m4135e(view)));
        } catch (Throwable th) {
        }
        this.mW.add(new C10033(this));
        gr.m4769S("Tracking ad unit: " + this.mN.aH());
    }

    protected final int m4126a(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    protected final void m4127a(View view, Map<String, String> map) {
        m4138g(false);
    }

    public final void m4128a(ac acVar) {
        this.nb.add(acVar);
    }

    public final void m4129a(ag agVar) {
        synchronized (this.mH) {
            this.mU = agVar;
        }
    }

    protected final void m4130a(ah ahVar) {
        ahVar.m4143f("https://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
    }

    protected final void m4131a(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(jSONObject);
            jSONObject2.put("units", jSONArray);
            this.mP.m4142a("AFMA_updateActiveView", jSONObject2);
        } catch (Throwable th) {
            gr.m4775b("Skipping active view message.", th);
        }
    }

    protected final boolean m4132a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.mN.aH());
    }

    protected final void aI() {
        synchronized (this.mH) {
            if (this.na != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.na = new C10044(this);
            this.mO.registerReceiver(this.na, intentFilter);
        }
    }

    protected final void aJ() {
        synchronized (this.mH) {
            if (this.na != null) {
                this.mO.unregisterReceiver(this.na);
                this.na = null;
            }
        }
    }

    public final void aK() {
        synchronized (this.mH) {
            if (this.mY) {
                this.mZ = true;
                try {
                    m4131a(aQ());
                } catch (Throwable e) {
                    gr.m4775b("JSON Failure while processing active view data.", e);
                }
                gr.m4769S("Untracking ad unit: " + this.mN.aH());
            }
        }
    }

    protected final void aL() {
        if (this.mU != null) {
            this.mU.m4114a(this);
        }
    }

    public final boolean aM() {
        boolean z;
        synchronized (this.mH) {
            z = this.mY;
        }
        return z;
    }

    protected final void aN() {
        View view = (View) this.mM.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.mL.get();
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2 != viewTreeObserver) {
                this.mL = new WeakReference(viewTreeObserver2);
                viewTreeObserver2.addOnScrollChangedListener(this);
                viewTreeObserver2.addOnGlobalLayoutListener(this);
            }
        }
    }

    protected final void aO() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.mL.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    protected final JSONObject aP() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.mN.aF()).put("activeViewJSON", this.mN.aG()).put("timestamp", ga.dc().dd().elapsedRealtime()).put("adFormat", this.mN.aE()).put("hashCode", this.mN.aH());
        return jSONObject;
    }

    protected final JSONObject aQ() throws JSONException {
        JSONObject aP = aP();
        aP.put("doneReasonCode", "u");
        return aP;
    }

    protected final void m4133b(ah ahVar) {
        ahVar.m4141a("/updateActiveView", new C10055(this));
        ahVar.m4141a("/untrackActiveViewUnit", new C10066(this));
        ahVar.m4141a("/visibilityChanged", new C10077(this));
        ahVar.m4141a("/viewabilityChanged", cc.pQ);
    }

    protected final void m4134d(View view) {
        Object arrayList = new ArrayList();
        this.mW.drainTo(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    protected final void destroy() {
        synchronized (this.mH) {
            aO();
            aJ();
            this.mY = false;
            try {
                this.mP.destroy();
            } catch (Throwable th) {
            }
            aL();
        }
    }

    protected final JSONObject m4135e(View view) throws JSONException {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr);
        view.getLocationInWindow(iArr2);
        JSONObject aP = aP();
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.mR.getDefaultDisplay().getWidth();
        rect2.bottom = this.mR.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, null);
        Rect rect4 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect4);
        Rect rect5 = new Rect();
        view.getHitRect(rect5);
        aP.put("viewBox", new JSONObject().put("top", m4126a(rect2.top, displayMetrics)).put("bottom", m4126a(rect2.bottom, displayMetrics)).put("left", m4126a(rect2.left, displayMetrics)).put("right", m4126a(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", m4126a(rect.top, displayMetrics)).put("bottom", m4126a(rect.bottom, displayMetrics)).put("left", m4126a(rect.left, displayMetrics)).put("right", m4126a(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", m4126a(rect3.top, displayMetrics)).put("bottom", m4126a(rect3.bottom, displayMetrics)).put("left", m4126a(rect3.left, displayMetrics)).put("right", m4126a(rect3.right, displayMetrics))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", m4126a(rect4.top, displayMetrics)).put("bottom", m4126a(rect4.bottom, displayMetrics)).put("left", m4126a(rect4.left, displayMetrics)).put("right", m4126a(rect4.right, displayMetrics))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", m4126a(rect5.top, displayMetrics)).put("bottom", m4126a(rect5.bottom, displayMetrics)).put("left", m4126a(rect5.left, displayMetrics)).put("right", m4126a(rect5.right, displayMetrics))).put("windowVisibility", view.getWindowVisibility()).put("screenDensity", (double) displayMetrics.density).put("isVisible", m4137f(view)).put("isStopped", this.mV).put("isPaused", this.my);
        if (ll.im()) {
            aP.put("isAttachedToWindow", view.isAttachedToWindow());
        }
        return aP;
    }

    protected final void m4136f(boolean z) {
        Iterator it = this.nb.iterator();
        while (it.hasNext()) {
            ((ac) it.next()).m4108a(this, z);
        }
    }

    protected final boolean m4137f(View view) {
        return view.getVisibility() == 0 && view.isShown() && this.mS.isScreenOn() && !this.mT.inKeyguardRestrictedInputMode();
    }

    protected final void m4138g(boolean z) {
        synchronized (this.mH) {
            if (this.mQ && this.mY) {
                long elapsedRealtime = ga.dc().dd().elapsedRealtime();
                if (!z || this.mX + 200 <= elapsedRealtime) {
                    this.mX = elapsedRealtime;
                    View view = (View) this.mM.get();
                    Object obj = (view == null || ((fy) this.mK.get()) == null) ? 1 : null;
                    if (obj != null) {
                        aK();
                        return;
                    }
                    try {
                        m4131a(m4135e(view));
                    } catch (Throwable e) {
                        gr.m4774a("Active view update failed.", e);
                    }
                    aN();
                    aL();
                    return;
                }
                return;
            }
        }
    }

    public final void onGlobalLayout() {
        m4138g(false);
    }

    public final void onScrollChanged() {
        m4138g(true);
    }

    public final void pause() {
        synchronized (this.mH) {
            this.my = true;
            m4138g(false);
            this.mP.pause();
        }
    }

    public final void resume() {
        synchronized (this.mH) {
            this.mP.resume();
            this.my = false;
            m4138g(false);
        }
    }

    public final void stop() {
        synchronized (this.mH) {
            this.mV = true;
            m4138g(false);
            this.mP.pause();
        }
    }
}
