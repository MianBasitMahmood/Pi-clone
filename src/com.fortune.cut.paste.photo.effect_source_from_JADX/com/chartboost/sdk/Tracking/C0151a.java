package com.chartboost.sdk.Tracking;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.chartboost.sdk.C0153b;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.C0104a;
import com.chartboost.sdk.Libraries.C0105b;
import com.chartboost.sdk.Libraries.C0108c;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.C0131g;
import com.chartboost.sdk.Libraries.C0132h;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.impl.C0182l.C0332a;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.ba;
import com.google.android.gms.tagmanager.DataLayer;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Tracking.a */
public class C0151a implements C0104a {
    private static final String f226b;
    private static C0151a f227k;
    private static boolean f228l;
    private String f229c;
    private String f230d;
    private JSONArray f231e;
    private long f232f;
    private long f233g;
    private long f234h;
    private C0132h f235i;
    private C0132h f236j;

    static {
        f226b = C0151a.class.getSimpleName();
        f228l = false;
    }

    private C0151a() {
        this.f234h = System.currentTimeMillis();
        this.f230d = m369p();
        this.f231e = new JSONArray();
        this.f235i = new C0132h("CBTrackingDirectory", false);
        this.f236j = new C0132h("CBSessionDirectory", false);
    }

    public static C0151a m323a() {
        if (f227k == null) {
            synchronized (Chartboost.class) {
                if (f227k == null) {
                    f227k = new C0151a();
                }
            }
        }
        return f227k;
    }

    public static void m337b() {
        C0151a.m326a("start");
        C0151a.m326a("did-become-active");
    }

    public static void m326a(String str) {
        f227k.m355a("session", str, null, null, null, null, "session");
    }

    public void m359c() {
        m357a(false);
    }

    public void m357a(boolean z) {
        C0111a a = C0111a.m145a();
        a.m152a("complete", Boolean.valueOf(z));
        f227k.m356a("session", "end", null, null, null, null, a.m163e(), "session");
        C0151a.m326a("did-become-active");
    }

    public static void m335a(String str, String str2, boolean z) {
        f227k.m355a("ad-get", str, str2, C0151a.m336b(z), "single", null, "system");
    }

    public static void m341b(String str, String str2, boolean z) {
        f227k.m355a("ad-has", str, str2, C0151a.m336b(z), null, null, "system");
    }

    public static void m344c(String str, String str2, boolean z) {
        f227k.m355a("ad-loaded", str, str2, C0151a.m336b(z), null, null, "system");
    }

    public static void m330a(String str, String str2, String str3) {
        f227k.m355a("ad-show", str, str2, str3, null, null, "system");
    }

    public static void m340b(String str, String str2, String str3) {
        f227k.m355a("ad-click", str, str2, str3, null, null, "system");
    }

    public static void m331a(String str, String str2, String str3, int i) {
        f227k.m355a("ad-click", str, str2, str3, C0151a.m325a(i), null, "system");
    }

    public static void m343c(String str, String str2, String str3) {
        f227k.m355a("ad-close", str, str2, str3, null, null, "system");
    }

    public static void m329a(String str, String str2, CBImpressionError cBImpressionError) {
        f227k.m355a("ad-error", str, str2, cBImpressionError != null ? cBImpressionError.toString() : "", null, null, "system");
    }

    public static void m345d() {
        f227k.m355a("video-prefetcher", "begin", null, null, null, null, "system");
    }

    public static void m349e() {
        f227k.m355a("video-prefetcher", null, null, null, null, null, "system");
    }

    public static void m327a(String str, String str2) {
        f227k.m355a("start", str, str2, null, null, null, "system");
    }

    public static void m333a(String str, String str2, String str3, String str4) {
        f227k.m355a("failure", str, str2, str3, str4, null, "system");
    }

    public static void m347d(String str, String str2, String str3) {
        f227k.m355a("success", str, str2, str3, null, null, "system");
    }

    public static void m350e(String str, String str2, String str3) {
        f227k.m355a(str, str2, str3, null, null, null, "system");
    }

    public static void m338b(String str, String str2) {
        f227k.m355a("confirmation-show", str, str2, null, null, null, "system");
    }

    public static void m348d(String str, String str2, boolean z) {
        f227k.m355a("confirmation-dismiss", str, str2, C0151a.m336b(z), null, null, "system");
    }

    public static void m342c(String str, String str2) {
        f227k.m355a("replay", str, str2, null, null, null, "system");
    }

    public static void m328a(String str, String str2, int i) {
        f227k.m355a("playback-start", str, str2, C0151a.m325a(i), null, null, "system");
    }

    public static void m346d(String str, String str2) {
        f227k.m355a("playback-stop", str, str2, null, null, null, "system");
    }

    public static void m339b(String str, String str2, int i) {
        f227k.m355a("close-show", str, str2, C0151a.m325a(i), null, null, "system");
    }

    public static void m351e(String str, String str2, boolean z) {
        f227k.m355a("controls-toggle", str, str2, C0151a.m336b(z), null, null, "system");
    }

    public static void m332a(String str, String str2, String str3, int i, int i2) {
        f227k.m355a("install-click", str, str3, str2, C0151a.m325a(i), C0151a.m325a(i2), "system");
    }

    public static void m334a(String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject) {
        f227k.m356a(str, str2, str3, str4, str5, str6, jSONObject, "system");
    }

    public void m355a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        f227k.m356a(str, str2, str3, str4, str5, str6, new JSONObject(), str7);
    }

    public void m356a(String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject, String str7) {
        JSONObject jSONObject2;
        try {
            Method declaredMethod = C0153b.class.getDeclaredMethod("h", new Class[0]);
            declaredMethod.setAccessible(true);
            jSONObject2 = (JSONObject) declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable e) {
            CBLogging.m102b(this, "Error encountered getting tracking levels", e);
            CBUtility.throwProguardError(e);
            jSONObject2 = null;
        }
        C0111a a = C0111a.m145a();
        if (jSONObject2 != null && jSONObject2.optBoolean(str7)) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - this.f232f;
            currentTimeMillis -= this.f234h;
            a.m152a(DataLayer.EVENT_KEY, C0151a.m324a((Object) str));
            a.m152a("kingdom", C0151a.m324a((Object) str2));
            a.m152a("phylum", C0151a.m324a((Object) str3));
            a.m152a("class", C0151a.m324a((Object) str4));
            a.m152a("family", C0151a.m324a((Object) str5));
            a.m152a("genus", C0151a.m324a((Object) str6));
            String str8 = "meta";
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            a.m152a(str8, jSONObject);
            a.m152a("clientTimestamp", Long.valueOf(System.currentTimeMillis() / 1000));
            a.m152a("session_id", m365l());
            a.m152a("totalSessionTime", Long.valueOf(j / 1000));
            a.m152a("currentSessionTime", Long.valueOf(currentTimeMillis / 1000));
            synchronized (this) {
                if (ba.m946h() || m360f()) {
                    m370q();
                }
                this.f231e.put(a.m163e());
                Object a2 = C0111a.m145a();
                a2.m152a("events", this.f231e);
                CBLogging.m97a(f226b, "###Writing" + C0151a.m324a((Object) str) + "to tracking cache dir");
                this.f235i.m236a(this.f230d, C0111a.m146a(a2));
                m364k();
            }
        }
    }

    public boolean m360f() {
        if (this.f231e == null || this.f231e.length() < 50) {
            return false;
        }
        return true;
    }

    public String m361g() {
        C0111a a = C0111a.m145a();
        a.m152a("startTime", Long.valueOf(System.currentTimeMillis()));
        a.m152a("deviceID", C0108c.m137e());
        this.f229c = C0105b.m127b(a.toString().getBytes());
        return this.f229c;
    }

    public void m362h() {
        C0111a a = this.f236j.m233a("cb_previous_session_info");
        if (a != null) {
            this.f233g = a.m168h("timestamp");
            this.f232f = a.m168h("start_timestamp");
            this.f229c = a.m162e("session_id");
            if (System.currentTimeMillis() - this.f233g > 180000) {
                m357a(true);
            } else if (!TextUtils.isEmpty(this.f229c)) {
                m364k();
                f228l = false;
                return;
            }
        }
        m363j();
        f228l = true;
    }

    public static boolean m352i() {
        return f228l;
    }

    public void m363j() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f232f = currentTimeMillis;
        this.f233g = currentTimeMillis;
        this.f229c = m361g();
        m354a(currentTimeMillis, currentTimeMillis);
        SharedPreferences a = CBUtility.m110a();
        int i = a.getInt("cbPrefSessionCount", 0) + 1;
        Editor edit = a.edit();
        edit.putInt("cbPrefSessionCount", i);
        edit.commit();
    }

    public void m364k() {
        m354a(this.f232f, System.currentTimeMillis());
    }

    public void m354a(long j, long j2) {
        C0111a a = C0111a.m145a();
        a.m152a("start_timestamp", Long.valueOf(j));
        a.m152a("timestamp", Long.valueOf(j2));
        a.m152a("session_id", this.f229c);
        this.f236j.m236a("cb_previous_session_info", a);
    }

    public az m353a(C0111a c0111a) {
        az azVar = new az("/api/track");
        azVar.m891a("track", (Object) c0111a);
        azVar.m885a(C0131g.m221a(C0131g.m223a("status", C0104a.f83a)));
        azVar.m888a(C0332a.LOW);
        return azVar;
    }

    public String toString() {
        return "Session [ startTime: " + m368o() + " sessionEvents: " + m367n() + " ]";
    }

    public String m365l() {
        return this.f229c;
    }

    public C0132h m366m() {
        return this.f235i;
    }

    public JSONArray m367n() {
        return this.f231e;
    }

    public long m368o() {
        return this.f232f;
    }

    public String m369p() {
        return new Long(System.nanoTime()).toString();
    }

    public static String m336b(boolean z) {
        return z ? "1" : "0";
    }

    public static String m325a(int i) {
        return new Integer(i).toString();
    }

    private static Object m324a(Object obj) {
        return obj != null ? obj : "";
    }

    public boolean m358b(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return str.equals("cb_previous_session_info");
    }

    public void m370q() {
        this.f231e = new JSONArray();
        this.f230d = m369p();
    }
}
