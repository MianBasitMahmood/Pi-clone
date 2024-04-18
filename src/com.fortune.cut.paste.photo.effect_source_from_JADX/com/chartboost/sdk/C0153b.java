package com.chartboost.sdk;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.chartboost.sdk.C0161c.C0155a;
import com.chartboost.sdk.Chartboost.CBFramework;
import com.chartboost.sdk.Libraries.C0104a;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.C0131g;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBLogging.Level;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.impl.C0182l.C0332a;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.az.C0085c;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.b */
public final class C0153b {
    protected static Context f238a;
    protected static Application f239b;
    public static C0155a f240c;
    private static String f241d;
    private static String f242e;
    private static C0092a f243f;
    private static boolean f244g;
    private static boolean f245h;
    private static boolean f246i;
    private static CBFramework f247j;
    private static String f248k;
    private static SharedPreferences f249l;
    private static boolean f250m;
    private static volatile boolean f251n;
    private static boolean f252o;
    private static boolean f253p;
    private static boolean f254q;
    private static boolean f255r;

    /* renamed from: com.chartboost.sdk.b.a */
    public interface C0088a {
        void m24a();
    }

    /* renamed from: com.chartboost.sdk.b.1 */
    static class C01521 implements C0085c {
        final /* synthetic */ C0088a f237a;

        C01521(C0088a c0088a) {
            this.f237a = c0088a;
        }

        public final void m371a(C0111a c0111a, az azVar) {
            if (c0111a != null) {
                C0153b.m376a(c0111a.m151a("response"));
            }
            if (this.f237a != null) {
                this.f237a.m24a();
            }
        }

        public final void m372a(C0111a c0111a, az azVar, CBError cBError) {
            if (this.f237a != null) {
                this.f237a.m24a();
            }
        }
    }

    static {
        f244g = false;
        f245h = false;
        f246i = false;
        f247j = null;
        f248k = null;
        f249l = null;
        f250m = true;
        f251n = false;
        f238a = null;
        f239b = null;
        f252o = false;
        f253p = true;
        f254q = false;
        f255r = true;
    }

    private C0153b() {
    }

    private static SharedPreferences m409u() {
        if (f249l == null) {
            f249l = CBUtility.m110a();
        }
        return f249l;
    }

    public static void m374a(CBFramework cBFramework) {
        C0153b.m404p();
        if (cBFramework == null) {
            throw new RuntimeException("Pass a valid CBFramework enum value");
        }
        f247j = cBFramework;
    }

    public static CBFramework m373a() {
        C0153b.m404p();
        return f247j == null ? null : f247j;
    }

    public static String m381b() {
        C0153b.m404p();
        String string = C0153b.m409u().getString("appId", f241d);
        f241d = string;
        return string;
    }

    public static void m379a(String str) {
        C0153b.m404p();
        f241d = str;
        C0153b.m409u().edit().putString("appId", str).commit();
    }

    public static String m384c() {
        C0153b.m404p();
        String string = C0153b.m409u().getString("appSignature", f242e);
        f242e = string;
        return string;
    }

    public static void m382b(String str) {
        C0153b.m404p();
        f242e = str;
        C0153b.m409u().edit().putString("appSignature", str).commit();
    }

    public static C0092a m387d() {
        C0153b.m404p();
        return f243f;
    }

    public static void m377a(C0092a c0092a) {
        C0153b.m404p();
        f243f = c0092a;
    }

    public static boolean m390e() {
        C0153b.m404p();
        return f244g;
    }

    public static void m380a(boolean z) {
        C0153b.m404p();
        f244g = z;
    }

    public static boolean m392f() {
        C0153b.m404p();
        return f246i;
    }

    public static boolean m394g() {
        return f250m;
    }

    public static void m383b(boolean z) {
        f250m = z;
    }

    public static JSONObject m395h() {
        C0153b.m404p();
        Object string = C0153b.m409u().getString("trackingLevels", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        C0111a j = C0111a.m147j(string);
        if (j.m158c()) {
            return j.m163e();
        }
        return null;
    }

    public static boolean m397i() {
        C0153b.m404p();
        JSONObject h = C0153b.m395h();
        if (h == null || (!h.optBoolean("debug") && !h.optBoolean("session") && !h.optBoolean("system") && !h.optBoolean("user"))) {
            return false;
        }
        return true;
    }

    public static void m375a(Level level) {
        C0153b.m404p();
        CBLogging.f77a = level;
    }

    public static Level m398j() {
        C0153b.m404p();
        return CBLogging.f77a;
    }

    public static String m399k() {
        C0153b.m404p();
        return f248k;
    }

    public static void m385c(String str) {
        C0153b.m404p();
        f248k = str;
    }

    public static void m376a(C0111a c0111a) {
        if (c0111a != null) {
            Map f = c0111a.m165f();
            if (f != null) {
                Editor edit = C0153b.m409u().edit();
                for (String str : f.keySet()) {
                    Object obj = f.get(str);
                    if (obj instanceof String) {
                        edit.putString(str, (String) obj);
                    } else if (obj instanceof Integer) {
                        edit.putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Float) {
                        edit.putFloat(str, ((Float) obj).floatValue());
                    } else if (obj instanceof Long) {
                        edit.putLong(str, ((Long) obj).longValue());
                    } else if (obj instanceof Boolean) {
                        edit.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj != null) {
                        edit.putString(str, obj.toString());
                    }
                }
                edit.commit();
            }
        }
    }

    public static void m378a(C0088a c0088a) {
        az azVar = new az("/api/config");
        azVar.m893a(false);
        azVar.m899b(false);
        azVar.m888a(C0332a.HIGH);
        azVar.m885a(C0131g.m221a(C0131g.m223a("status", C0104a.f83a)));
        azVar.m886a(new C01521(c0088a));
    }

    public static Context m400l() {
        return f238a;
    }

    public static boolean m401m() {
        return f251n;
    }

    protected static void m386c(boolean z) {
        f251n = z;
    }

    public static void m402n() {
        if (!C0153b.m401m()) {
            throw new IllegalStateException("You need call Chartboost.onStart() before calling any public APIs ");
        }
    }

    public static void m403o() {
        if (Chartboost.f36b == null) {
            throw new IllegalStateException("The activity context must be set through the Chartboost onCreate method");
        }
    }

    public static void m404p() {
        if (f239b == null) {
            throw new IllegalStateException("Need to intialize chartboost using Chartboost.init() as the application object is null");
        }
    }

    public static void m388d(boolean z) {
        if (f240c != null) {
            f240c.m410a(z);
        }
    }

    protected static void m389e(boolean z) {
        f252o = z;
    }

    public static boolean m405q() {
        return f252o;
    }

    public static void m391f(boolean z) {
        f253p = z;
    }

    public static boolean m406r() {
        return f253p;
    }

    public static void m393g(boolean z) {
        f254q = z;
    }

    public static boolean m407s() {
        return f254q;
    }

    public static void m396h(boolean z) {
        f255r = z;
    }

    public static boolean m408t() {
        return f255r;
    }
}
