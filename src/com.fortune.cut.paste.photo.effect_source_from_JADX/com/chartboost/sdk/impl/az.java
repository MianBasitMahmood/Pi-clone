package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.chartboost.sdk.C0153b;
import com.chartboost.sdk.Libraries.C0105b;
import com.chartboost.sdk.Libraries.C0108c;
import com.chartboost.sdk.Libraries.C0108c.C0107a;
import com.chartboost.sdk.Libraries.C0113e;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.C0131g;
import com.chartboost.sdk.Libraries.C0131g.C0101a;
import com.chartboost.sdk.Libraries.C0131g.C0125k;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.impl.C0182l.C0332a;
import com.google.android.gms.cast.Cast;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class az {
    private static C0111a f578g;
    private String f579a;
    private String f580b;
    private C0111a f581c;
    private Map<String, Object> f582d;
    private Map<String, Object> f583e;
    private String f584f;
    private C0085c f585h;
    private boolean f586i;
    private boolean f587j;
    private C0101a f588k;
    private ba f589l;
    private int f590m;
    private boolean f591n;
    private boolean f592o;
    private C0332a f593p;

    /* renamed from: com.chartboost.sdk.impl.az.c */
    public interface C0085c {
        void m20a(C0111a c0111a, az azVar);

        void m21a(C0111a c0111a, az azVar, CBError cBError);
    }

    /* renamed from: com.chartboost.sdk.impl.az.d */
    public static abstract class C0086d implements C0085c {
        public void m22a(C0111a c0111a, az azVar, CBError cBError) {
        }
    }

    /* renamed from: com.chartboost.sdk.impl.az.a */
    private static class C0227a implements C0085c {
        private C0086d f576a;
        private C0228b f577b;

        public C0227a(C0086d c0086d, C0228b c0228b) {
            this.f576a = c0086d;
            this.f577b = c0228b;
        }

        public void m879a(C0111a c0111a, az azVar) {
            if (this.f576a != null) {
                this.f576a.m20a(c0111a, azVar);
            }
        }

        public void m880a(C0111a c0111a, az azVar, CBError cBError) {
            if (this.f577b != null) {
                this.f577b.m21a(c0111a, azVar, cBError);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.az.b */
    public static abstract class C0228b implements C0085c {
    }

    static {
        f578g = null;
    }

    public az(String str) {
        this.f585h = null;
        this.f586i = false;
        this.f587j = false;
        this.f588k = null;
        this.f591n = false;
        this.f592o = true;
        this.f593p = C0332a.NORMAL;
        this.f579a = str;
        this.f584f = "POST";
        this.f589l = ba.m938a(C0153b.m400l());
        m883a(0);
    }

    protected final void m882a() {
        if (this.f583e == null) {
            this.f583e = new HashMap();
        }
        this.f583e.put("Accept", "application/json");
        this.f583e.put("X-Chartboost-Client", CBUtility.m119d());
        this.f583e.put("X-Chartboost-API", "5.1.2");
        this.f583e.put("X-Chartboost-Client", CBUtility.m119d());
    }

    protected final String m895b() {
        return "application/json";
    }

    public final void m891a(String str, Object obj) {
        if (this.f581c == null) {
            this.f581c = C0111a.m145a();
        }
        this.f581c.m152a(str, obj);
    }

    public final void m892a(String str, String str2) {
        if (this.f583e == null) {
            this.f583e = new HashMap();
        }
        this.f583e.put(str, str2);
    }

    public final void m890a(String str, C0111a c0111a) {
        if (c0111a != null && c0111a.m159c(str)) {
            m891a(str, c0111a.m162e(str));
        }
    }

    protected final void m884a(Context context) {
        Object obj = null;
        m891a("app", C0153b.m381b());
        if ("sdk".equals(Build.PRODUCT)) {
            m891a("model", (Object) "Android Simulator");
        } else {
            m891a("model", Build.MODEL);
        }
        m891a("device_type", Build.MANUFACTURER + " " + Build.MODEL);
        m891a("os", "Android " + VERSION.RELEASE);
        m891a("country", Locale.getDefault().getCountry());
        m891a("language", Locale.getDefault().getLanguage());
        m891a("sdk", (Object) "5.1.2");
        m891a("timestamp", String.valueOf(Long.valueOf(new Date().getTime() / 1000).intValue()));
        m891a("session", Integer.valueOf(CBUtility.m110a().getInt("cbPrefSessionCount", 0)));
        m891a("reachability", Integer.valueOf(ay.m871a().m874b()));
        m896b(context);
        m891a("scale", context.getResources().getDisplayMetrics().density);
        try {
            Object packageName = context.getPackageName();
            m891a("bundle", context.getPackageManager().getPackageInfo(packageName, Cast.MAX_NAMESPACE_LENGTH).versionName);
            m891a("bundle_id", packageName);
        } catch (Throwable e) {
            CBLogging.m102b("CBRequest", "Exception raised getting package mager object", e);
        }
        if (f578g == null) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null || telephonyManager.getPhoneType() == 0) {
                f578g = C0111a.m145a();
            } else {
                Object obj2;
                String simOperator = telephonyManager.getSimOperator();
                if (TextUtils.isEmpty(simOperator)) {
                    obj2 = null;
                } else {
                    obj = simOperator.substring(0, 3);
                    obj2 = simOperator.substring(3);
                }
                f578g = C0113e.m180a(C0113e.m181a("carrier-name", telephonyManager.getNetworkOperatorName()), C0113e.m181a("mobile-country-code", obj), C0113e.m181a("mobile-network-code", obj2), C0113e.m181a("iso-country-code", telephonyManager.getNetworkCountryIso()), C0113e.m181a("phone-type", Integer.valueOf(telephonyManager.getPhoneType())));
            }
        }
        m891a("carrier", f578g);
        m891a("custom_id", C0153b.m399k());
    }

    public final void m900c() {
        m891a("identity", C0108c.m133b());
        C0107a c = C0108c.m135c();
        if (c.m129b()) {
            m891a("tracking", Integer.valueOf(c.m128a()));
        }
    }

    public final void m902d() {
        String b = C0153b.m381b();
        String c = C0153b.m384c();
        c = C0105b.m127b(C0105b.m126a(String.format(Locale.US, "%s %s\n%s\n%s", new Object[]{this.f584f, m904e(), c, m905f()}).getBytes()));
        m892a("X-Chartboost-App", b);
        m892a("X-Chartboost-Signature", c);
    }

    public final String m904e() {
        return m906g() + CBUtility.m111a(this.f582d);
    }

    public final String m905f() {
        return this.f581c.toString();
    }

    public final void m896b(Context context) {
        int width;
        int height;
        Throwable th;
        DisplayMetrics displayMetrics;
        int i;
        int i2 = 0;
        if (this.f581c == null || !this.f581c.m151a("w").m158c() || !this.f581c.m151a("h").m158c()) {
            try {
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    Rect rect = new Rect();
                    activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    width = rect.width();
                    try {
                        height = rect.height();
                        i2 = width;
                    } catch (Throwable e) {
                        Throwable th2 = e;
                        height = width;
                        th = th2;
                        CBLogging.m104c("CBRequest", "Exception getting activity size", th);
                        i2 = height;
                        height = 0;
                        displayMetrics = context.getResources().getDisplayMetrics();
                        i = displayMetrics.widthPixels;
                        width = displayMetrics.heightPixels;
                        m891a("dw", i);
                        m891a("dh", width);
                        m891a("dpi", displayMetrics.densityDpi);
                        i2 = i;
                        height = width;
                        m891a("w", i2);
                        m891a("h", height);
                    }
                }
                height = 0;
            } catch (Throwable e2) {
                th = e2;
                height = 0;
                CBLogging.m104c("CBRequest", "Exception getting activity size", th);
                i2 = height;
                height = 0;
                displayMetrics = context.getResources().getDisplayMetrics();
                i = displayMetrics.widthPixels;
                width = displayMetrics.heightPixels;
                m891a("dw", i);
                m891a("dh", width);
                m891a("dpi", displayMetrics.densityDpi);
                i2 = i;
                height = width;
                m891a("w", i2);
                m891a("h", height);
            }
            displayMetrics = context.getResources().getDisplayMetrics();
            i = displayMetrics.widthPixels;
            width = displayMetrics.heightPixels;
            m891a("dw", i);
            m891a("dh", width);
            m891a("dpi", displayMetrics.densityDpi);
            if (i2 <= 0 || i2 > i) {
                i2 = i;
            }
            if (height <= 0 || height > width) {
                height = width;
            }
            m891a("w", i2);
            m891a("h", height);
        }
    }

    public final String m906g() {
        if (this.f579a == null) {
            return "/";
        }
        return (this.f579a.startsWith("/") ? "" : "/") + this.f579a;
    }

    public final void m889a(String str) {
        this.f579a = str;
    }

    public final boolean m907h() {
        return m906g().equals("/api/track");
    }

    public final C0111a m908i() {
        return this.f581c;
    }

    public final Map<String, Object> m909j() {
        return this.f583e;
    }

    public final boolean m910k() {
        return this.f587j;
    }

    public final void m893a(boolean z) {
        this.f587j = z;
    }

    public final C0101a m911l() {
        return this.f588k;
    }

    public final boolean m912m() {
        return this.f591n;
    }

    public final void m899b(boolean z) {
        this.f591n = z;
    }

    public final void m885a(C0101a c0101a) {
        if (C0131g.m228c(c0101a)) {
            this.f588k = c0101a;
            return;
        }
        throw new IllegalArgumentException("Validation predicate must be a dictionary style -- either VDictionary, VDictionaryExact, VDictionaryWithValues, or just a list of KV pairs.");
    }

    public final void m894a(C0125k... c0125kArr) {
        this.f588k = C0131g.m221a(c0125kArr);
    }

    public final void m898b(String str) {
        this.f580b = str;
    }

    public final void m888a(C0332a c0332a) {
        this.f593p = c0332a;
    }

    public final C0332a m913n() {
        return this.f593p;
    }

    public final int m914o() {
        return this.f590m;
    }

    public final void m883a(int i) {
        this.f590m = i;
    }

    public final boolean m915p() {
        return this.f592o;
    }

    public final void m901c(boolean z) {
        this.f592o = z;
    }

    public final boolean m916q() {
        return this.f586i;
    }

    public final void m903d(boolean z) {
        this.f586i = z;
    }

    public final C0085c m917r() {
        return this.f585h;
    }

    public final void m918s() {
        m887a(null, null);
    }

    public final void m886a(C0085c c0085c) {
        this.f585h = c0085c;
        this.f586i = true;
        this.f589l.m950a(this, c0085c);
    }

    public final void m887a(C0086d c0086d, C0228b c0228b) {
        this.f586i = true;
        this.f585h = new C0227a(c0086d, c0228b);
        this.f589l.m950a(this, this.f585h);
    }

    public final void m897b(C0085c c0085c) {
        if (c0085c != null) {
            this.f585h = c0085c;
        }
    }

    public static az m881a(C0111a c0111a) {
        try {
            az azVar = new az(c0111a.m162e("path"));
            azVar.f584f = c0111a.m162e("method");
            azVar.f582d = c0111a.m151a("query").m165f();
            azVar.f581c = c0111a.m151a("body");
            azVar.f583e = c0111a.m151a("headers").m165f();
            azVar.f587j = c0111a.m171i("ensureDelivery");
            azVar.f580b = c0111a.m162e("eventType");
            azVar.f579a = c0111a.m162e("path");
            azVar.f590m = c0111a.m164f("retryCount");
            if (c0111a.m151a("callback") instanceof C0085c) {
                azVar.f585h = (C0085c) c0111a.m151a("callback");
            }
            return azVar;
        } catch (Throwable e) {
            CBLogging.m106d("CBRequest", "Unable to deserialize failed request", e);
            return null;
        }
    }

    public final C0111a m919t() {
        return C0113e.m180a(C0113e.m181a("path", this.f579a), C0113e.m181a("method", this.f584f), C0113e.m181a("query", C0113e.m186a(this.f582d)), C0113e.m181a("body", this.f581c), C0113e.m181a("eventType", this.f580b), C0113e.m181a("headers", C0113e.m186a(this.f583e)), C0113e.m181a("ensureDelivery", Boolean.valueOf(this.f587j)), C0113e.m181a("retryCount", Integer.valueOf(this.f590m)), C0113e.m181a("callback", this.f585h));
    }
}
