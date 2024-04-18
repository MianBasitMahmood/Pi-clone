package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.C0426y.C0425a;
import com.google.android.gms.analytics.GoogleAnalytics.C0376a;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Tracker {
    private final TrackerHandler Ce;
    private final Map<String, String> Cf;
    private ah Cg;
    private final C0402k Ch;
    private final ai Ci;
    private final C0394g Cj;
    private boolean Ck;
    private C0378a Cl;
    private am Cm;
    private ExceptionReporter Cn;
    private Context mContext;
    private final Map<String, String> rd;

    /* renamed from: com.google.android.gms.analytics.Tracker.a */
    private class C0378a implements C0376a {
        private boolean Co;
        private int Cp;
        private long Cq;
        private boolean Cr;
        private long Cs;
        final /* synthetic */ Tracker Ct;
        private ld wb;

        public C0378a(Tracker tracker) {
            this.Ct = tracker;
            this.Co = false;
            this.Cp = 0;
            this.Cq = -1;
            this.Cr = false;
            this.wb = lf.m5325if();
        }

        private void fq() {
            GoogleAnalytics eY = GoogleAnalytics.eY();
            if (eY == null) {
                ae.m1485T("GoogleAnalytics isn't initialized for the Tracker!");
            } else if (this.Cq >= 0 || this.Co) {
                eY.m1469a(this.Ct.Cl);
            } else {
                eY.m1471b(this.Ct.Cl);
            }
        }

        public void enableAutoActivityTracking(boolean z) {
            this.Co = z;
            fq();
        }

        public long fn() {
            return this.Cq;
        }

        public boolean fo() {
            return this.Co;
        }

        public boolean fp() {
            boolean z = this.Cr;
            this.Cr = false;
            return z;
        }

        boolean fr() {
            return this.wb.elapsedRealtime() >= this.Cs + Math.max(1000, this.Cq);
        }

        public void m1475i(Activity activity) {
            C0426y.eK().m1600a(C0425a.EASY_TRACKER_ACTIVITY_START);
            if (this.Cp == 0 && fr()) {
                this.Cr = true;
            }
            this.Cp++;
            if (this.Co) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    this.Ct.setCampaignParamsOnNextHit(intent.getData());
                }
                Map hashMap = new HashMap();
                hashMap.put("&t", "screenview");
                C0426y.eK().m1599D(true);
                this.Ct.set("&cd", this.Ct.Cm != null ? this.Ct.Cm.m1520k(activity) : activity.getClass().getCanonicalName());
                this.Ct.send(hashMap);
                C0426y.eK().m1599D(false);
            }
        }

        public void m1476j(Activity activity) {
            C0426y.eK().m1600a(C0425a.EASY_TRACKER_ACTIVITY_STOP);
            this.Cp--;
            this.Cp = Math.max(0, this.Cp);
            if (this.Cp == 0) {
                this.Cs = this.wb.elapsedRealtime();
            }
        }

        public void setSessionTimeout(long j) {
            this.Cq = j;
            fq();
        }
    }

    Tracker(String str, TrackerHandler trackerHandler, Context context) {
        this(str, trackerHandler, C0402k.el(), ai.fl(), C0394g.dZ(), new ad("tracking"), context);
    }

    Tracker(String str, TrackerHandler trackerHandler, C0402k c0402k, ai aiVar, C0394g c0394g, ah ahVar, Context context) {
        this.rd = new HashMap();
        this.Cf = new HashMap();
        this.Ce = trackerHandler;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        if (str != null) {
            this.rd.put("&tid", str);
        }
        this.rd.put("useSecure", "1");
        this.Ch = c0402k;
        this.Ci = aiVar;
        this.Cj = c0394g;
        this.rd.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
        this.Cg = ahVar;
        this.Cl = new C0378a(this);
        enableAdvertisingIdCollection(false);
    }

    void m1479a(am amVar) {
        ae.m1487V("Loading Tracker config values.");
        this.Cm = amVar;
        if (this.Cm.ft()) {
            String fu = this.Cm.fu();
            set("&tid", fu);
            ae.m1487V("[Tracker] trackingId loaded: " + fu);
        }
        if (this.Cm.fv()) {
            fu = Double.toString(this.Cm.fw());
            set("&sf", fu);
            ae.m1487V("[Tracker] sample frequency loaded: " + fu);
        }
        if (this.Cm.fx()) {
            setSessionTimeout((long) this.Cm.getSessionTimeout());
            ae.m1487V("[Tracker] session timeout loaded: " + fn());
        }
        if (this.Cm.fy()) {
            enableAutoActivityTracking(this.Cm.fz());
            ae.m1487V("[Tracker] auto activity tracking loaded: " + fo());
        }
        if (this.Cm.fA()) {
            if (this.Cm.fB()) {
                set("&aip", "1");
                ae.m1487V("[Tracker] anonymize ip loaded: true");
            }
            ae.m1487V("[Tracker] anonymize ip loaded: false");
        }
        enableExceptionReporting(this.Cm.fC());
    }

    public void enableAdvertisingIdCollection(boolean z) {
        if (z) {
            if (this.rd.containsKey("&ate")) {
                this.rd.remove("&ate");
            }
            if (this.rd.containsKey("&adid")) {
                this.rd.remove("&adid");
                return;
            }
            return;
        }
        this.rd.put("&ate", null);
        this.rd.put("&adid", null);
    }

    public void enableAutoActivityTracking(boolean z) {
        this.Cl.enableAutoActivityTracking(z);
    }

    public void enableExceptionReporting(boolean z) {
        if (this.Ck != z) {
            this.Ck = z;
            if (z) {
                this.Cn = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), this.mContext);
                Thread.setDefaultUncaughtExceptionHandler(this.Cn);
                ae.m1487V("Uncaught exceptions will be reported to Google Analytics.");
                return;
            }
            if (this.Cn != null) {
                Thread.setDefaultUncaughtExceptionHandler(this.Cn.et());
            } else {
                Thread.setDefaultUncaughtExceptionHandler(null);
            }
            ae.m1487V("Uncaught exceptions will not be reported to Google Analytics.");
        }
    }

    long fn() {
        return this.Cl.fn();
    }

    boolean fo() {
        return this.Cl.fo();
    }

    public String get(String str) {
        C0426y.eK().m1600a(C0425a.GET);
        return TextUtils.isEmpty(str) ? null : this.rd.containsKey(str) ? (String) this.rd.get(str) : str.equals("&ul") ? an.m1523a(Locale.getDefault()) : (this.Ch == null || !this.Ch.ac(str)) ? (this.Ci == null || !this.Ci.ac(str)) ? (this.Cj == null || !this.Cj.ac(str)) ? null : this.Cj.getValue(str) : this.Ci.getValue(str) : this.Ch.getValue(str);
    }

    public void send(Map<String, String> map) {
        C0426y.eK().m1600a(C0425a.SEND);
        Map hashMap = new HashMap();
        hashMap.putAll(this.rd);
        if (map != null) {
            hashMap.putAll(map);
        }
        for (String str : this.Cf.keySet()) {
            if (!hashMap.containsKey(str)) {
                hashMap.put(str, this.Cf.get(str));
            }
        }
        this.Cf.clear();
        if (TextUtils.isEmpty((CharSequence) hashMap.get("&tid"))) {
            ae.m1488W(String.format("Missing tracking id (%s) parameter.", new Object[]{"&tid"}));
        }
        String str2 = (String) hashMap.get("&t");
        if (TextUtils.isEmpty(str2)) {
            ae.m1488W(String.format("Missing hit type (%s) parameter.", new Object[]{"&t"}));
            str2 = "";
        }
        if (this.Cl.fp()) {
            hashMap.put("&sc", "start");
        }
        String toLowerCase = str2.toLowerCase();
        if ("screenview".equals(toLowerCase) || "pageview".equals(toLowerCase) || "appview".equals(toLowerCase) || TextUtils.isEmpty(toLowerCase)) {
            int parseInt = Integer.parseInt((String) this.rd.get("&a")) + 1;
            if (parseInt >= Integer.MAX_VALUE) {
                parseInt = 1;
            }
            this.rd.put("&a", Integer.toString(parseInt));
        }
        if (toLowerCase.equals("transaction") || toLowerCase.equals("item") || this.Cg.fe()) {
            this.Ce.m1467u(hashMap);
        } else {
            ae.m1488W("Too many hits sent too quickly, rate limiting invoked.");
        }
    }

    public void set(String str, String str2) {
        jx.m5219b((Object) str, (Object) "Key should be non-null");
        C0426y.eK().m1600a(C0425a.SET);
        this.rd.put(str, str2);
    }

    public void setAnonymizeIp(boolean z) {
        set("&aip", an.m1521E(z));
    }

    public void setAppId(String str) {
        set("&aid", str);
    }

    public void setAppInstallerId(String str) {
        set("&aiid", str);
    }

    public void setAppName(String str) {
        set("&an", str);
    }

    public void setAppVersion(String str) {
        set("&av", str);
    }

    public void setCampaignParamsOnNextHit(Uri uri) {
        if (uri != null) {
            Object queryParameter = uri.getQueryParameter("referrer");
            if (!TextUtils.isEmpty(queryParameter)) {
                Uri parse = Uri.parse("http://hostname/?" + queryParameter);
                String queryParameter2 = parse.getQueryParameter("utm_id");
                if (queryParameter2 != null) {
                    this.Cf.put("&ci", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_campaign");
                if (queryParameter2 != null) {
                    this.Cf.put("&cn", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_content");
                if (queryParameter2 != null) {
                    this.Cf.put("&cc", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_medium");
                if (queryParameter2 != null) {
                    this.Cf.put("&cm", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_source");
                if (queryParameter2 != null) {
                    this.Cf.put("&cs", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_term");
                if (queryParameter2 != null) {
                    this.Cf.put("&ck", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("dclid");
                if (queryParameter2 != null) {
                    this.Cf.put("&dclid", queryParameter2);
                }
                String queryParameter3 = parse.getQueryParameter("gclid");
                if (queryParameter3 != null) {
                    this.Cf.put("&gclid", queryParameter3);
                }
            }
        }
    }

    public void setClientId(String str) {
        set("&cid", str);
    }

    public void setEncoding(String str) {
        set("&de", str);
    }

    public void setHostname(String str) {
        set("&dh", str);
    }

    public void setLanguage(String str) {
        set("&ul", str);
    }

    public void setLocation(String str) {
        set("&dl", str);
    }

    public void setPage(String str) {
        set("&dp", str);
    }

    public void setReferrer(String str) {
        set("&dr", str);
    }

    public void setSampleRate(double d) {
        set("&sf", Double.toHexString(d));
    }

    public void setScreenColors(String str) {
        set("&sd", str);
    }

    public void setScreenName(String str) {
        set("&cd", str);
    }

    public void setScreenResolution(int i, int i2) {
        if (i >= 0 || i2 >= 0) {
            set("&sr", i + "x" + i2);
        } else {
            ae.m1488W("Invalid width or height. The values should be non-negative.");
        }
    }

    public void setSessionTimeout(long j) {
        this.Cl.setSessionTimeout(1000 * j);
    }

    public void setTitle(String str) {
        set("&dt", str);
    }

    public void setUseSecure(boolean z) {
        set("useSecure", an.m1521E(z));
    }

    public void setViewportSize(String str) {
        set("&vp", str);
    }
}
