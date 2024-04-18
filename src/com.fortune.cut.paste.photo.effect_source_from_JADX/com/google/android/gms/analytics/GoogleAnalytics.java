package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.analytics.C0426y.C0425a;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class GoogleAnalytics extends TrackerHandler {
    private static boolean Bm;
    private static GoogleAnalytics Bs;
    private aj Bn;
    private volatile Boolean Bo;
    private Logger Bp;
    private Set<C0376a> Bq;
    private boolean Br;
    private Context mContext;
    private C0393f yV;
    private String ya;
    private String yb;
    private boolean yt;

    /* renamed from: com.google.android.gms.analytics.GoogleAnalytics.a */
    interface C0376a {
        void m1465i(Activity activity);

        void m1466j(Activity activity);
    }

    /* renamed from: com.google.android.gms.analytics.GoogleAnalytics.b */
    class C0377b implements ActivityLifecycleCallbacks {
        final /* synthetic */ GoogleAnalytics Bt;

        C0377b(GoogleAnalytics googleAnalytics) {
            this.Bt = googleAnalytics;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            this.Bt.m1472g(activity);
        }

        public void onActivityStopped(Activity activity) {
            this.Bt.m1473h(activity);
        }
    }

    protected GoogleAnalytics(Context context) {
        this(context, C0424x.m1589A(context), C0410v.eu());
    }

    private GoogleAnalytics(Context context, C0393f c0393f, aj ajVar) {
        this.Bo = Boolean.valueOf(false);
        this.Br = false;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.yV = c0393f;
        this.Bn = ajVar;
        C0394g.m1538y(this.mContext);
        ai.m1507y(this.mContext);
        C0402k.m1553y(this.mContext);
        this.Bp = new C0404p();
        this.Bq = new HashSet();
        eZ();
    }

    private Tracker m1468a(Tracker tracker) {
        if (this.ya != null) {
            tracker.set("&an", this.ya);
        }
        if (this.yb != null) {
            tracker.set("&av", this.yb);
        }
        return tracker;
    }

    private int ai(String str) {
        String toLowerCase = str.toLowerCase();
        return "verbose".equals(toLowerCase) ? 0 : "info".equals(toLowerCase) ? 1 : "warning".equals(toLowerCase) ? 2 : "error".equals(toLowerCase) ? 3 : -1;
    }

    static GoogleAnalytics eY() {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            googleAnalytics = Bs;
        }
        return googleAnalytics;
    }

    private void eZ() {
        if (!Bm) {
            ApplicationInfo applicationInfo;
            try {
                applicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 129);
            } catch (NameNotFoundException e) {
                ae.m1487V("PackageManager doesn't know about package: " + e);
                applicationInfo = null;
            }
            if (applicationInfo == null) {
                ae.m1488W("Couldn't get ApplicationInfo to load gloabl config.");
                return;
            }
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
                if (i > 0) {
                    aa aaVar = (aa) new C0428z(this.mContext).m1519x(i);
                    if (aaVar != null) {
                        m1470a(aaVar);
                    }
                }
            }
        }
    }

    public static GoogleAnalytics getInstance(Context context) {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            if (Bs == null) {
                Bs = new GoogleAnalytics(context);
            }
            googleAnalytics = Bs;
        }
        return googleAnalytics;
    }

    void m1469a(C0376a c0376a) {
        this.Bq.add(c0376a);
        if (this.mContext instanceof Application) {
            enableAutoActivityReports((Application) this.mContext);
        }
    }

    void m1470a(aa aaVar) {
        ae.m1487V("Loading global config values.");
        if (aaVar.eO()) {
            this.ya = aaVar.eP();
            ae.m1487V("app name loaded: " + this.ya);
        }
        if (aaVar.eQ()) {
            this.yb = aaVar.eR();
            ae.m1487V("app version loaded: " + this.yb);
        }
        if (aaVar.eS()) {
            int ai = ai(aaVar.eT());
            if (ai >= 0) {
                ae.m1487V("log level loaded: " + ai);
                getLogger().setLogLevel(ai);
            }
        }
        if (aaVar.eU()) {
            this.Bn.setLocalDispatchPeriod(aaVar.eV());
        }
        if (aaVar.eW()) {
            setDryRun(aaVar.eX());
        }
    }

    void m1471b(C0376a c0376a) {
        this.Bq.remove(c0376a);
    }

    void dY() {
        this.yV.dY();
    }

    @Deprecated
    public void dispatchLocalHits() {
        this.Bn.dispatchLocalHits();
    }

    public void enableAutoActivityReports(Application application) {
        if (VERSION.SDK_INT >= 14 && !this.Br) {
            application.registerActivityLifecycleCallbacks(new C0377b(this));
            this.Br = true;
        }
    }

    void m1472g(Activity activity) {
        for (C0376a i : this.Bq) {
            i.m1465i(activity);
        }
    }

    public boolean getAppOptOut() {
        C0426y.eK().m1600a(C0425a.GET_APP_OPT_OUT);
        return this.Bo.booleanValue();
    }

    public Logger getLogger() {
        return this.Bp;
    }

    void m1473h(Activity activity) {
        for (C0376a j : this.Bq) {
            j.m1466j(activity);
        }
    }

    public boolean isDryRunEnabled() {
        C0426y.eK().m1600a(C0425a.GET_DRY_RUN);
        return this.yt;
    }

    public Tracker newTracker(int i) {
        Tracker a;
        synchronized (this) {
            C0426y.eK().m1600a(C0425a.GET_TRACKER);
            Tracker tracker = new Tracker(null, this, this.mContext);
            if (i > 0) {
                am amVar = (am) new al(this.mContext).m1519x(i);
                if (amVar != null) {
                    tracker.m1479a(amVar);
                }
            }
            a = m1468a(tracker);
        }
        return a;
    }

    public Tracker newTracker(String str) {
        Tracker a;
        synchronized (this) {
            C0426y.eK().m1600a(C0425a.GET_TRACKER);
            a = m1468a(new Tracker(str, this, this.mContext));
        }
        return a;
    }

    public void reportActivityStart(Activity activity) {
        if (!this.Br) {
            m1472g(activity);
        }
    }

    public void reportActivityStop(Activity activity) {
        if (!this.Br) {
            m1473h(activity);
        }
    }

    public void setAppOptOut(boolean z) {
        C0426y.eK().m1600a(C0425a.SET_APP_OPT_OUT);
        this.Bo = Boolean.valueOf(z);
        if (this.Bo.booleanValue()) {
            this.yV.dQ();
        }
    }

    public void setDryRun(boolean z) {
        C0426y.eK().m1600a(C0425a.SET_DRY_RUN);
        this.yt = z;
    }

    @Deprecated
    public void setLocalDispatchPeriod(int i) {
        this.Bn.setLocalDispatchPeriod(i);
    }

    public void setLogger(Logger logger) {
        C0426y.eK().m1600a(C0425a.SET_LOGGER);
        this.Bp = logger;
    }

    void m1474u(Map<String, String> map) {
        synchronized (this) {
            if (map == null) {
                throw new IllegalArgumentException("hit cannot be null");
            }
            an.m1525a((Map) map, "&ul", an.m1523a(Locale.getDefault()));
            an.m1524a((Map) map, "&sr", ai.fl());
            map.put("&_u", C0426y.eK().eM());
            C0426y.eK().eL();
            this.yV.m1537u(map);
        }
    }
}
