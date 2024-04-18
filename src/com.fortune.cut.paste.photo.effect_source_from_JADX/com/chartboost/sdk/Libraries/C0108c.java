package com.chartboost.sdk.Libraries;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import com.chartboost.sdk.C0153b;
import com.chartboost.sdk.impl.ax;
import com.chartboost.sdk.impl.ba;
import com.chartboost.sdk.impl.cj;
import com.chartboost.sdk.impl.cl;
import com.chartboost.sdk.impl.cm;
import java.util.UUID;

/* renamed from: com.chartboost.sdk.Libraries.c */
public final class C0108c {
    private static String f91a;
    private static String f92b;
    private static C0107a f93c;
    private static String f94d;

    /* renamed from: com.chartboost.sdk.Libraries.c.1 */
    static class C01061 implements Runnable {
        C01061() {
        }

        public final void run() {
            try {
                C0108c.m134b(C0109d.m144a());
                ba.m944b();
            } catch (VerifyError e) {
                C0108c.m139g();
            }
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.c.a */
    public enum C0107a {
        PRELOAD(-1),
        LOADING(-1),
        UNKNOWN(-1),
        TRACKING_ENABLED(0),
        TRACKING_DISABLED(1);
        
        private int f90f;

        private C0107a(int i) {
            this.f90f = i;
        }

        public final int m128a() {
            return this.f90f;
        }

        public final boolean m129b() {
            return this.f90f != -1;
        }
    }

    static {
        f91a = null;
        f92b = null;
        f93c = C0107a.PRELOAD;
        f94d = null;
    }

    private C0108c() {
    }

    public static void m130a() {
        synchronized (C0109d.class) {
            if (C0108c.m135c() != C0107a.PRELOAD) {
                return;
            }
            C0108c.m131a(C0107a.LOADING);
            Class cls = null;
            try {
                cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            } catch (ClassNotFoundException e) {
            }
            if (cls == null) {
                C0108c.m139g();
            } else {
                ax.m867a().execute(new C01061());
            }
        }
    }

    private static void m139g() {
        CBLogging.m101b("CBIdentity", "WARNING: It looks like you've forgotten to include the Google Play Services library in your project. Please review the SDK documentation for more details.");
        C0108c.m131a(C0107a.UNKNOWN);
        ba.m944b();
    }

    public static String m133b() {
        if (f91a == null) {
            f91a = C0105b.m127b(C0108c.m140h());
        }
        return f91a;
    }

    public static synchronized C0107a m135c() {
        C0107a c0107a;
        synchronized (C0108c.class) {
            c0107a = f93c;
        }
        return c0107a;
    }

    protected static synchronized void m131a(C0107a c0107a) {
        synchronized (C0108c.class) {
            f93c = c0107a;
        }
    }

    public static synchronized String m136d() {
        String str;
        synchronized (C0108c.class) {
            str = f92b;
        }
        return str;
    }

    private static synchronized void m134b(String str) {
        synchronized (C0108c.class) {
            f92b = str;
        }
    }

    private static byte[] m140h() {
        Object e = C0108c.m137e();
        if (e == null || "9774d56d682e549c".equals(e)) {
            e = C0108c.m141i();
        }
        String j = C0108c.m142j();
        String d = C0108c.m136d();
        cj cmVar = new cm();
        cmVar.m1150a("uuid", e);
        cmVar.m1150a("macid", j);
        cmVar.m1150a("gaid", d);
        return new cl().m1230a(cmVar);
    }

    public static String m137e() {
        return Secure.getString(C0153b.m400l().getContentResolver(), "android_id");
    }

    private static String m141i() {
        if (f94d == null) {
            SharedPreferences a = CBUtility.m110a();
            String string = a.getString("cbUUID", null);
            f94d = string;
            if (string == null) {
                f94d = UUID.randomUUID().toString();
                Editor edit = a.edit();
                edit.putString("cbUUID", f94d);
                edit.commit();
            }
        }
        return f94d;
    }

    private static String m142j() {
        return C0105b.m127b(C0105b.m126a(C0108c.m143k()));
    }

    private static byte[] m143k() {
        try {
            String macAddress = ((WifiManager) C0153b.m400l().getSystemService("wifi")).getConnectionInfo().getMacAddress();
            if (macAddress == null || macAddress.equals("")) {
                return null;
            }
            String[] split = macAddress.split(":");
            byte[] bArr = new byte[6];
            for (int i = 0; i < split.length; i++) {
                bArr[i] = Integer.valueOf(Integer.parseInt(split[i], 16)).byteValue();
            }
            return bArr;
        } catch (Exception e) {
            return null;
        }
    }
}
