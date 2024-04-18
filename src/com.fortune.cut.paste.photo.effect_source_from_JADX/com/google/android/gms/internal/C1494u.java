package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ViewSwitcher;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0752d;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.internal.C1497v.C1496b;
import com.google.android.gms.internal.bd.C1026a;
import com.google.android.gms.internal.bv.C1036a;
import com.google.android.gms.internal.ez.C1118a;
import com.google.android.gms.internal.fc.C1139a;
import com.google.android.gms.internal.fh.C1147a;
import com.google.android.gms.internal.fy.C1160a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@ey
/* renamed from: com.google.android.gms.internal.u */
public class C1494u extends C1026a implements cb, ce, cg, cs, ds, dv, ej, C1118a, C1139a, gc, C1486t, C1493w {
    private final cy lA;
    private final C1492b lB;
    private final ab lC;
    private final ae lD;
    private boolean lE;
    private final ComponentCallbacks lF;
    private av lz;

    /* renamed from: com.google.android.gms.internal.u.1 */
    class C14871 implements ComponentCallbacks {
        final /* synthetic */ C1494u lG;

        C14871(C1494u c1494u) {
            this.lG = c1494u;
        }

        public void onConfigurationChanged(Configuration configuration) {
            if (this.lG.lB != null && this.lG.lB.lT != null && this.lG.lB.lT.se != null) {
                this.lG.lB.lT.se.cb();
            }
        }

        public void onLowMemory() {
        }
    }

    /* renamed from: com.google.android.gms.internal.u.2 */
    class C14882 implements OnTouchListener {
        final /* synthetic */ C1494u lG;
        final /* synthetic */ C1497v lH;

        C14882(C1494u c1494u, C1497v c1497v) {
            this.lG = c1494u;
            this.lH = c1497v;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.lH.av();
            return false;
        }
    }

    /* renamed from: com.google.android.gms.internal.u.3 */
    class C14893 implements OnClickListener {
        final /* synthetic */ C1494u lG;
        final /* synthetic */ C1497v lH;

        C14893(C1494u c1494u, C1497v c1497v) {
            this.lG = c1494u;
            this.lH = c1497v;
        }

        public void onClick(View view) {
            this.lH.av();
        }
    }

    /* renamed from: com.google.android.gms.internal.u.4 */
    class C14904 implements Runnable {
        final /* synthetic */ C1494u lG;
        final /* synthetic */ Intent lI;

        C14904(C1494u c1494u, Intent intent) {
            this.lG = c1494u;
            this.lI = intent;
        }

        public void run() {
            if (!(ei.m4514d(this.lI) != 0 || this.lG.lB.lT == null || this.lG.lB.lT.se == null || this.lG.lB.lT.se.dC() == null)) {
                this.lG.lB.lT.se.dC().close();
            }
            this.lG.lB.mh = false;
        }
    }

    @ey
    /* renamed from: com.google.android.gms.internal.u.a */
    private static final class C1491a extends ViewSwitcher {
        private final gl lJ;

        public C1491a(Context context) {
            super(context);
            this.lJ = new gl(context);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.lJ.m4751c(motionEvent);
            return false;
        }
    }

    @ey
    /* renamed from: com.google.android.gms.internal.u.b */
    static class C1492b {
        public final C1491a lK;
        public final String lL;
        public final Context lM;
        public final C1266k lN;
        public final gs lO;
        public bc lP;
        public gf lQ;
        public gf lR;
        public ay lS;
        public fy lT;
        public C1160a lU;
        public fz lV;
        public bf lW;
        public er lX;
        public en lY;
        public by lZ;
        public bz ma;
        public br mb;
        public List<String> mc;
        public ek md;
        public gd me;
        public View mf;
        public int mg;
        public boolean mh;
        public boolean mi;
        private HashSet<fz> mj;

        public C1492b(Context context, ay ayVar, String str, gs gsVar) {
            this.me = null;
            this.mf = null;
            this.mg = 0;
            this.mh = false;
            this.mi = false;
            this.mj = null;
            if (ayVar.oq) {
                this.lK = null;
            } else {
                this.lK = new C1491a(context);
                this.lK.setMinimumWidth(ayVar.widthPixels);
                this.lK.setMinimumHeight(ayVar.heightPixels);
                this.lK.setVisibility(4);
            }
            this.lS = ayVar;
            this.lL = str;
            this.lM = context;
            this.lO = gsVar;
            this.lN = new C1266k(new C1498x(this));
        }

        public void m6040a(HashSet<fz> hashSet) {
            this.mj = hashSet;
        }

        public HashSet<fz> ay() {
            return this.mj;
        }
    }

    public C1494u(Context context, ay ayVar, String str, cy cyVar, gs gsVar) {
        this(new C1492b(context, ayVar, str, gsVar), cyVar, null);
    }

    C1494u(C1492b c1492b, cy cyVar, ab abVar) {
        this.lF = new C14871(this);
        this.lB = c1492b;
        this.lA = cyVar;
        if (abVar == null) {
            abVar = new ab(this);
        }
        this.lC = abVar;
        this.lD = new ae();
        gi.m4740q(this.lB.lM);
        ga.m4686a(this.lB.lM, this.lB.lO);
        ad();
    }

    private C1147a m6042a(av avVar, Bundle bundle) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo = this.lB.lM.getApplicationInfo();
        try {
            packageInfo = this.lB.lM.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        Bundle bundle2 = null;
        if (!(this.lB.lS.oq || this.lB.lK.getParent() == null)) {
            int[] iArr = new int[2];
            this.lB.lK.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            DisplayMetrics displayMetrics = this.lB.lM.getResources().getDisplayMetrics();
            int width = this.lB.lK.getWidth();
            int height = this.lB.lK.getHeight();
            int i3 = 0;
            if (this.lB.lK.isShown() && i + width > 0 && i2 + height > 0 && i <= displayMetrics.widthPixels && i2 <= displayMetrics.heightPixels) {
                i3 = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i);
            bundle2.putInt("y", i2);
            bundle2.putInt("width", width);
            bundle2.putInt("height", height);
            bundle2.putInt("visible", i3);
        }
        String df = ga.df();
        this.lB.lV = new fz(df, this.lB.lL);
        this.lB.lV.m4676e(avVar);
        return new C1147a(bundle2, avVar, this.lB.lS, this.lB.lL, applicationInfo, packageInfo, df, ga.vY, this.lB.lO, ga.m4685a(this.lB.lM, this, df), this.lB.mc, bundle, ga.dl());
    }

    private gu m6043a(C1497v c1497v) {
        if (this.lB.lS.oq) {
            gu a = gu.m4782a(this.lB.lM, this.lB.lS, false, false, this.lB.lN, this.lB.lO);
            a.dD().m4798a(this, null, this, this, true, this, this, c1497v);
            return a;
        }
        gu guVar;
        View nextView = this.lB.lK.getNextView();
        if (nextView instanceof gu) {
            guVar = (gu) nextView;
            guVar.m4784a(this.lB.lM, this.lB.lS);
        } else {
            if (nextView != null) {
                this.lB.lK.removeView(nextView);
            }
            guVar = gu.m4782a(this.lB.lM, this.lB.lS, false, false, this.lB.lN, this.lB.lO);
            if (this.lB.lS.or == null) {
                m6047c(guVar);
            }
        }
        guVar.dD().m4799a(this, this, this, this, false, this, c1497v);
        return guVar;
    }

    private void m6045a(int i) {
        gr.m4773W("Failed to load ad: " + i);
        if (this.lB.lP != null) {
            try {
                this.lB.lP.onAdFailedToLoad(i);
            } catch (Throwable e) {
                gr.m4777d("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
    }

    private void ad() {
        if (VERSION.SDK_INT >= 14 && this.lB != null && this.lB.lM != null) {
            this.lB.lM.registerComponentCallbacks(this.lF);
        }
    }

    private void ae() {
        if (VERSION.SDK_INT >= 14 && this.lB != null && this.lB.lM != null) {
            this.lB.lM.unregisterComponentCallbacks(this.lF);
        }
    }

    private void ao() {
        gr.m4771U("Ad closing.");
        if (this.lB.lP != null) {
            try {
                this.lB.lP.onAdClosed();
            } catch (Throwable e) {
                gr.m4777d("Could not call AdListener.onAdClosed().", e);
            }
        }
    }

    private void ap() {
        gr.m4771U("Ad leaving application.");
        if (this.lB.lP != null) {
            try {
                this.lB.lP.onAdLeftApplication();
            } catch (Throwable e) {
                gr.m4777d("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
    }

    private void aq() {
        gr.m4771U("Ad opening.");
        if (this.lB.lP != null) {
            try {
                this.lB.lP.onAdOpened();
            } catch (Throwable e) {
                gr.m4777d("Could not call AdListener.onAdOpened().", e);
            }
        }
    }

    private void ar() {
        gr.m4771U("Ad finished loading.");
        if (this.lB.lP != null) {
            try {
                this.lB.lP.onAdLoaded();
            } catch (Throwable e) {
                gr.m4777d("Could not call AdListener.onAdLoaded().", e);
            }
        }
    }

    private void as() {
        try {
            if ((this.lB.lT.vI instanceof bt) && this.lB.lZ != null) {
                this.lB.lZ.m4277a((bt) this.lB.lT.vI);
            }
        } catch (Throwable e) {
            gr.m4777d("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
        }
    }

    private void at() {
        try {
            if ((this.lB.lT.vI instanceof bu) && this.lB.ma != null) {
                this.lB.ma.m4278a((bu) this.lB.lT.vI);
            }
        } catch (Throwable e) {
            gr.m4777d("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
        }
    }

    private void ax() {
        if (this.lB.lT != null) {
            if (this.lB.mg == 0) {
                this.lB.lT.se.destroy();
            }
            this.lB.lT = null;
            this.lB.mi = false;
        }
    }

    private boolean m6046b(fy fyVar) {
        View view;
        if (fyVar.tW) {
            try {
                view = (View) C0755e.m2593f(fyVar.qQ.getView());
                View nextView = this.lB.lK.getNextView();
                if (nextView != null) {
                    this.lB.lK.removeView(nextView);
                }
                try {
                    m6047c(view);
                } catch (Throwable th) {
                    gr.m4777d("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            } catch (Throwable th2) {
                gr.m4777d("Could not get View from mediation adapter.", th2);
                return false;
            }
        } else if (fyVar.vF != null) {
            fyVar.se.m4785a(fyVar.vF);
            this.lB.lK.removeAllViews();
            this.lB.lK.setMinimumWidth(fyVar.vF.widthPixels);
            this.lB.lK.setMinimumHeight(fyVar.vF.heightPixels);
            m6047c(fyVar.se);
        }
        if (this.lB.lK.getChildCount() > 1) {
            this.lB.lK.showNext();
        }
        if (this.lB.lT != null) {
            view = this.lB.lK.getNextView();
            if (view instanceof gu) {
                ((gu) view).m4784a(this.lB.lM, this.lB.lS);
            } else if (view != null) {
                this.lB.lK.removeView(view);
            }
            if (this.lB.lT.qQ != null) {
                try {
                    this.lB.lT.qQ.destroy();
                } catch (RemoteException e) {
                    gr.m4773W("Could not destroy previous mediation adapter.");
                }
            }
        }
        this.lB.lK.setVisibility(0);
        return true;
    }

    private void m6047c(View view) {
        this.lB.lK.addView(view, new LayoutParams(-2, -2));
    }

    private void m6048e(boolean z) {
        if (this.lB.lT == null) {
            gr.m4773W("Ad state was null when trying to ping impression URLs.");
            return;
        }
        gr.m4769S("Pinging Impression URLs.");
        this.lB.lV.cW();
        if (this.lB.lT.qx != null) {
            gi.m4724a(this.lB.lM, this.lB.lO.wS, this.lB.lT.qx);
        }
        if (!(this.lB.lT.vE == null || this.lB.lT.vE.qx == null)) {
            cw.m4381a(this.lB.lM, this.lB.lO.wS, this.lB.lT, this.lB.lL, z, this.lB.lT.vE.qx);
        }
        if (this.lB.lT.qP != null && this.lB.lT.qP.qs != null) {
            cw.m4381a(this.lB.lM, this.lB.lO.wS, this.lB.lT, this.lB.lL, z, this.lB.lT.qP.qs);
        }
    }

    Bundle m6049a(an anVar) {
        if (anVar == null) {
            return null;
        }
        String aT;
        if (anVar.be()) {
            anVar.wakeup();
        }
        ak bc = anVar.bc();
        if (bc != null) {
            aT = bc.aT();
            gr.m4769S("In AdManger: loadAd, " + bc.toString());
        } else {
            aT = null;
        }
        if (aT == null) {
            return null;
        }
        Bundle bundle = new Bundle(1);
        bundle.putString("fingerprint", aT);
        bundle.putInt("v", 1);
        return bundle;
    }

    public void m6050a(ay ayVar) {
        jx.aU("setAdSize must be called on the main UI thread.");
        this.lB.lS = ayVar;
        if (this.lB.lT != null && this.lB.mg == 0) {
            this.lB.lT.se.m4785a(ayVar);
        }
        if (this.lB.lK.getChildCount() > 1) {
            this.lB.lK.removeView(this.lB.lK.getNextView());
        }
        this.lB.lK.setMinimumWidth(ayVar.widthPixels);
        this.lB.lK.setMinimumHeight(ayVar.heightPixels);
        this.lB.lK.requestLayout();
    }

    public void m6051a(bc bcVar) {
        jx.aU("setAdListener must be called on the main UI thread.");
        this.lB.lP = bcVar;
    }

    public void m6052a(bf bfVar) {
        jx.aU("setAppEventListener must be called on the main UI thread.");
        this.lB.lW = bfVar;
    }

    public void m6053a(br brVar) {
        jx.aU("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.lB.mb = brVar;
    }

    public void m6054a(en enVar) {
        jx.aU("setInAppPurchaseListener must be called on the main UI thread.");
        this.lB.lY = enVar;
    }

    public void m6055a(er erVar, String str) {
        jx.aU("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.lB.md = new ek(str);
        this.lB.lX = erVar;
        if (!ga.dj() && erVar != null) {
            new ec(this.lB.lM, this.lB.lX, this.lB.md).start();
        }
    }

    public void m6056a(C1160a c1160a) {
        gu guVar;
        String str = null;
        this.lB.lQ = null;
        this.lB.lU = c1160a;
        m6061a(null);
        if (c1160a.vK.ug) {
            guVar = null;
        } else {
            C1497v c1497v = new C1497v();
            guVar = m6043a(c1497v);
            c1497v.m6069a(new C1496b(c1160a, guVar));
            guVar.setOnTouchListener(new C14882(this, c1497v));
            guVar.setOnClickListener(new C14893(this, c1497v));
        }
        if (c1160a.lS != null) {
            this.lB.lS = c1160a.lS;
        }
        if (c1160a.errorCode != -2) {
            m6057a(new fy(c1160a, guVar, null, null, null, null, null));
            return;
        }
        if (!c1160a.vK.tW && c1160a.vK.uf) {
            if (c1160a.vK.sg != null) {
                str = Uri.parse(c1160a.vK.sg).buildUpon().query(null).build().toString();
            }
            bq boVar = new bo(this, str, c1160a.vK.tU);
            try {
                if (this.lB.mb != null) {
                    this.lB.mg = 1;
                    this.lB.mb.m4265a(boVar);
                    return;
                }
            } catch (Throwable e) {
                gr.m4777d("Could not call the onCustomRenderedAdLoadedListener.", e);
            }
        }
        this.lB.mg = 0;
        this.lB.lR = fc.m4582a(this.lB.lM, this, c1160a, guVar, this.lA, this);
    }

    public void m6057a(fy fyVar) {
        this.lB.lR = null;
        boolean z = fyVar.vI != null;
        if (!(fyVar.errorCode == -2 || fyVar.errorCode == 3)) {
            ga.m4688b(this.lB.ay());
        }
        if (fyVar.errorCode != -1) {
            if (m6063a(fyVar, z)) {
                gr.m4769S("Ad refresh scheduled.");
            }
            if (!(fyVar.errorCode != 3 || fyVar.vE == null || fyVar.vE.qy == null)) {
                gr.m4769S("Pinging no fill URLs.");
                cw.m4381a(this.lB.lM, this.lB.lO.wS, fyVar, this.lB.lL, false, fyVar.vE.qy);
            }
            if (fyVar.errorCode != -2) {
                m6045a(fyVar.errorCode);
                return;
            }
            int i;
            int i2;
            if (!(this.lB.lS.oq || z || this.lB.mg != 0)) {
                if (!m6046b(fyVar)) {
                    m6045a(0);
                    return;
                } else if (this.lB.lK != null) {
                    this.lB.lK.lJ.m4750Q(fyVar.ub);
                }
            }
            if (!(this.lB.lT == null || this.lB.lT.qS == null)) {
                this.lB.lT.qS.m4366a(null);
            }
            if (fyVar.qS != null) {
                fyVar.qS.m4366a((cs) this);
            }
            this.lD.m4119d(this.lB.lT);
            this.lB.lT = fyVar;
            this.lB.lV.m4677j(fyVar.vG);
            this.lB.lV.m4678k(fyVar.vH);
            this.lB.lV.m4679v(this.lB.lS.oq);
            this.lB.lV.m4680w(fyVar.tW);
            if (!(this.lB.lS.oq || z || this.lB.mg != 0)) {
                m6048e(false);
            }
            if (this.lB.me == null) {
                this.lB.me = new gd(this.lB.lL);
            }
            if (fyVar.vE != null) {
                i = fyVar.vE.qB;
                i2 = fyVar.vE.qC;
            } else {
                i2 = 0;
                i = 0;
            }
            this.lB.me.m4708d(i, i2);
            if (this.lB.mg == 0) {
                if (!(this.lB.lS.oq || fyVar.se == null || (!fyVar.se.dD().dN() && fyVar.vD == null))) {
                    af a = this.lD.m4116a(this.lB.lS, this.lB.lT);
                    if (fyVar.se.dD().dN() && a != null) {
                        a.m4128a(new aa(fyVar.se));
                    }
                }
                if (this.lB.lT.se != null) {
                    this.lB.lT.se.cb();
                    this.lB.lT.se.dD().dO();
                }
                if (z) {
                    C1036a c1036a = fyVar.vI;
                    if ((c1036a instanceof bu) && this.lB.ma != null) {
                        at();
                    } else if (!(c1036a instanceof bt) || this.lB.lZ == null) {
                        gr.m4773W("No matching listener for retrieved native ad template.");
                        m6045a(0);
                        return;
                    } else {
                        as();
                    }
                }
                ar();
            } else if (this.lB.mf != null && fyVar.vD != null) {
                this.lD.m4115a(this.lB.lM, this.lB.lS, this.lB.lT, this.lB.mf, this.lB.lO);
            }
        }
    }

    public void m6058a(String str, ArrayList<String> arrayList) {
        em edVar = new ed(str, arrayList, this.lB.lM, this.lB.lO.wS);
        if (this.lB.lY == null) {
            gr.m4773W("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.lB.lM) != 0) {
                gr.m4773W("Google Play Service unavailable, cannot launch default purchase flow.");
                return;
            } else if (this.lB.lX == null) {
                gr.m4773W("PlayStorePurchaseListener is not set.");
                return;
            } else if (this.lB.md == null) {
                gr.m4773W("PlayStorePurchaseVerifier is not initialized.");
                return;
            } else if (this.lB.mh) {
                gr.m4773W("An in-app purchase request is already in progress, abort");
                return;
            } else {
                this.lB.mh = true;
                try {
                    if (this.lB.lX.isValidPurchase(str)) {
                        ee.m4503a(this.lB.lM, this.lB.lO.wV, new ea(this.lB.lM, this.lB.md, edVar, this));
                        return;
                    } else {
                        this.lB.mh = false;
                        return;
                    }
                } catch (RemoteException e) {
                    gr.m4773W("Could not start In-App purchase.");
                    this.lB.mh = false;
                    return;
                }
            }
        }
        try {
            this.lB.lY.m4522a(edVar);
        } catch (RemoteException e2) {
            gr.m4773W("Could not start In-App purchase.");
        }
    }

    public void m6059a(String str, boolean z, int i, Intent intent, ef efVar) {
        try {
            if (this.lB.lX != null) {
                this.lB.lX.m4528a(new eg(this.lB.lM, str, z, i, intent, efVar));
            }
        } catch (RemoteException e) {
            gr.m4773W("Fail to invoke PlayStorePurchaseListener.");
        }
        gq.wR.postDelayed(new C14904(this, intent), 500);
    }

    public void m6060a(HashSet<fz> hashSet) {
        this.lB.m6040a(hashSet);
    }

    public void m6061a(List<String> list) {
        jx.aU("setNativeTemplates must be called on the main UI thread.");
        this.lB.mc = list;
    }

    public boolean m6062a(av avVar) {
        jx.aU("loadAd must be called on the main UI thread.");
        if (this.lB.lQ != null || this.lB.lR != null) {
            if (this.lz != null) {
                gr.m4773W("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
            }
            this.lz = avVar;
            return false;
        } else if (this.lB.lS.oq && this.lB.lT != null) {
            gr.m4773W("An interstitial is already loading. Aborting.");
            return false;
        } else if (!au()) {
            return false;
        } else {
            gr.m4771U("Starting ad request.");
            if (!avVar.og) {
                gr.m4771U("Use AdRequest.Builder.addTestDevice(\"" + gq.m4768v(this.lB.lM) + "\") to get test ads on this device.");
            }
            Bundle a = m6049a(ga.dc().m4702l(this.lB.lM));
            this.lC.cancel();
            this.lB.mg = 0;
            C1147a a2 = m6042a(avVar, a);
            this.lB.lQ = ez.m4547a(this.lB.lM, a2, this.lB.lN, this);
            return true;
        }
    }

    boolean m6063a(fy fyVar, boolean z) {
        av avVar;
        int i = 0;
        if (this.lz != null) {
            avVar = this.lz;
            this.lz = null;
        } else {
            avVar = fyVar.tL;
            if (avVar.extras != null) {
                i = avVar.extras.getBoolean("_noRefresh", false);
            }
        }
        i |= z;
        if (this.lB.lS.oq) {
            if (this.lB.mg == 0) {
                gi.m4729a(fyVar.se);
            }
        } else if (i == 0 && this.lB.mg == 0) {
            if (fyVar.qA > 0) {
                this.lC.m4112a(avVar, fyVar.qA);
            } else if (fyVar.vE != null && fyVar.vE.qA > 0) {
                this.lC.m4112a(avVar, fyVar.vE.qA);
            } else if (!fyVar.tW && fyVar.errorCode == 2) {
                this.lC.m4113c(avVar);
            }
        }
        return this.lC.aD();
    }

    public C0752d ab() {
        jx.aU("getAdFrame must be called on the main UI thread.");
        return C0755e.m2594k(this.lB.lK);
    }

    public ay ac() {
        jx.aU("getAdSize must be called on the main UI thread.");
        return this.lB.lS;
    }

    public void af() {
        ap();
    }

    public void ag() {
        this.lD.m4119d(this.lB.lT);
        if (this.lB.lS.oq) {
            ax();
        }
        this.lE = false;
        ao();
        this.lB.lV.cY();
    }

    public void ah() {
        if (this.lB.lS.oq) {
            m6048e(false);
        }
        this.lE = true;
        aq();
    }

    public void ai() {
        onAdClicked();
    }

    public void aj() {
        ag();
    }

    public void ak() {
        af();
    }

    public void al() {
        ah();
    }

    public void am() {
        if (this.lB.lT != null) {
            gr.m4773W("Mediation adapter " + this.lB.lT.qR + " refreshed, but mediation adapters should never refresh.");
        }
        m6048e(true);
        ar();
    }

    public void an() {
        jx.aU("recordManualImpression must be called on the main UI thread.");
        if (this.lB.lT == null) {
            gr.m4773W("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        gr.m4769S("Pinging manual tracking URLs.");
        if (this.lB.lT.tY != null) {
            gi.m4724a(this.lB.lM, this.lB.lO.wS, this.lB.lT.tY);
        }
    }

    public boolean au() {
        boolean z = true;
        if (!gi.m4732a(this.lB.lM.getPackageManager(), this.lB.lM.getPackageName(), "android.permission.INTERNET")) {
            if (!this.lB.lS.oq) {
                gq.m4767a(this.lB.lK, this.lB.lS, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            }
            z = false;
        }
        if (!gi.m4739p(this.lB.lM)) {
            if (!this.lB.lS.oq) {
                gq.m4767a(this.lB.lK, this.lB.lS, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            }
            z = false;
        }
        if (!(z || this.lB.lS.oq)) {
            this.lB.lK.setVisibility(0);
        }
        return z;
    }

    public void av() {
        if (this.lB.lT == null) {
            gr.m4773W("Ad state was null when trying to ping click URLs.");
            return;
        }
        gr.m4769S("Pinging click URLs.");
        this.lB.lV.cX();
        if (this.lB.lT.qw != null) {
            gi.m4724a(this.lB.lM, this.lB.lO.wS, this.lB.lT.qw);
        }
        if (this.lB.lT.vE != null && this.lB.lT.vE.qw != null) {
            cw.m4381a(this.lB.lM, this.lB.lO.wS, this.lB.lT, this.lB.lL, false, this.lB.lT.vE.qw);
        }
    }

    public void aw() {
        m6048e(false);
    }

    public void m6064b(View view) {
        this.lB.mf = view;
        m6057a(new fy(this.lB.lU, null, null, null, null, null, null));
    }

    public void m6065b(av avVar) {
        ViewParent parent = this.lB.lK.getParent();
        if ((parent instanceof View) && ((View) parent).isShown() && gi.dt() && !this.lE) {
            m6062a(avVar);
            return;
        }
        gr.m4771U("Ad is not visible. Not refreshing ad.");
        this.lC.m4113c(avVar);
    }

    public void m6066d(boolean z) {
        this.lB.mi = z;
    }

    public void destroy() {
        jx.aU("destroy must be called on the main UI thread.");
        ae();
        this.lB.lP = null;
        this.lB.lW = null;
        this.lB.lX = null;
        this.lB.lY = null;
        this.lB.mb = null;
        this.lC.cancel();
        this.lD.stop();
        stopLoading();
        if (this.lB.lK != null) {
            this.lB.lK.removeAllViews();
        }
        if (!(this.lB.lT == null || this.lB.lT.se == null)) {
            this.lB.lT.se.destroy();
        }
        if (this.lB.lT != null && this.lB.lT.qQ != null) {
            try {
                this.lB.lT.qQ.destroy();
            } catch (RemoteException e) {
                gr.m4773W("Could not destroy mediation adapter.");
            }
        }
    }

    public String getMediationAdapterClassName() {
        return this.lB.lT != null ? this.lB.lT.qR : null;
    }

    public boolean isReady() {
        jx.aU("isLoaded must be called on the main UI thread.");
        return this.lB.lQ == null && this.lB.lR == null && this.lB.lT != null;
    }

    public void onAdClicked() {
        av();
    }

    public void onAppEvent(String str, String str2) {
        if (this.lB.lW != null) {
            try {
                this.lB.lW.onAppEvent(str, str2);
            } catch (Throwable e) {
                gr.m4777d("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        jx.aU("pause must be called on the main UI thread.");
        if (this.lB.lT != null && this.lB.mg == 0) {
            gi.m4729a(this.lB.lT.se);
        }
        if (!(this.lB.lT == null || this.lB.lT.qQ == null)) {
            try {
                this.lB.lT.qQ.pause();
            } catch (RemoteException e) {
                gr.m4773W("Could not pause mediation adapter.");
            }
        }
        this.lD.pause();
        this.lC.pause();
    }

    public void resume() {
        jx.aU("resume must be called on the main UI thread.");
        if (this.lB.lT != null && this.lB.mg == 0) {
            gi.m4734b(this.lB.lT.se);
        }
        if (!(this.lB.lT == null || this.lB.lT.qQ == null)) {
            try {
                this.lB.lT.qQ.resume();
            } catch (RemoteException e) {
                gr.m4773W("Could not resume mediation adapter.");
            }
        }
        this.lC.resume();
        this.lD.resume();
    }

    public void showInterstitial() {
        jx.aU("showInterstitial must be called on the main UI thread.");
        if (!this.lB.lS.oq) {
            gr.m4773W("Cannot call showInterstitial on a banner ad.");
        } else if (this.lB.lT == null) {
            gr.m4773W("The interstitial has not loaded.");
        } else if (this.lB.mg == 1) {
        } else {
            if (this.lB.lT.se.dH()) {
                gr.m4773W("The interstitial is already showing.");
                return;
            }
            this.lB.lT.se.m4791z(true);
            if (this.lB.lT.se.dD().dN() || this.lB.lT.vD != null) {
                af a = this.lD.m4116a(this.lB.lS, this.lB.lT);
                if (this.lB.lT.se.dD().dN() && a != null) {
                    a.m4128a(new aa(this.lB.lT.se));
                }
            }
            if (this.lB.lT.tW) {
                try {
                    this.lB.lT.qQ.showInterstitial();
                    return;
                } catch (Throwable e) {
                    gr.m4777d("Could not show interstitial.", e);
                    ax();
                    return;
                }
            }
            C1499y c1499y = new C1499y(this.lB.mi, false);
            if (this.lB.lM instanceof Activity) {
                Window window = ((Activity) this.lB.lM).getWindow();
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                window.getDecorView().getGlobalVisibleRect(rect);
                window.getDecorView().getWindowVisibleDisplayFrame(rect2);
                if (!(rect.bottom == 0 || rect2.bottom == 0)) {
                    c1499y = new C1499y(this.lB.mi, rect.top == rect2.top);
                }
            }
            dp.m4448a(this.lB.lM, new dr(this, this, this, this.lB.lT.se, this.lB.lT.orientation, this.lB.lO, this.lB.lT.ub, c1499y));
        }
    }

    public void stopLoading() {
        jx.aU("stopLoading must be called on the main UI thread.");
        if (this.lB.lT != null && this.lB.mg == 0) {
            this.lB.lT.se.stopLoading();
            this.lB.lT = null;
        }
        if (this.lB.lQ != null) {
            this.lB.lQ.cancel();
        }
        if (this.lB.lR != null) {
            this.lB.lR.cancel();
        }
    }
}
