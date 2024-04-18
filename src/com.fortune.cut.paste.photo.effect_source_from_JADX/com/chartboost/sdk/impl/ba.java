package com.chartboost.sdk.impl;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.chartboost.sdk.C0153b;
import com.chartboost.sdk.Libraries.C0108c;
import com.chartboost.sdk.Libraries.C0108c.C0107a;
import com.chartboost.sdk.Libraries.C0113e;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.C0113e.C0112b;
import com.chartboost.sdk.Libraries.C0131g.C0101a;
import com.chartboost.sdk.Libraries.C0132h;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Model.CBError.C0142a;
import com.chartboost.sdk.Tracking.C0151a;
import com.chartboost.sdk.impl.C0182l.C0332a;
import com.chartboost.sdk.impl.az.C0085c;
import com.google.android.gms.wallet.WalletConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ba implements Observer {
    private static ba f608b;
    private static ConcurrentHashMap<az, File> f609e;
    private static ConcurrentHashMap<az, File> f610f;
    private static List<Runnable> f611g;
    private ay f612a;
    private C0335m f613c;
    private C0132h f614d;
    private CountDownTimer f615h;

    /* renamed from: com.chartboost.sdk.impl.ba.1 */
    class C02311 extends CountDownTimer {
        final /* synthetic */ ba f600a;

        C02311(ba baVar, long j, long j2) {
            this.f600a = baVar;
            super(j, j2);
        }

        public void onTick(long j) {
        }

        public void onFinish() {
            this.f600a.m952c();
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ba.a */
    public static class C0232a extends C0178s {
        private CBError f601b;

        public C0232a(CBError cBError) {
            this.f601b = cBError;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ba.b */
    public static class C0233b {
        private C0111a f602a;
        private C0328i f603b;

        public C0233b(C0111a c0111a, C0328i c0328i) {
            this.f602a = c0111a;
            this.f603b = c0328i;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ba.c */
    private class C0235c implements Runnable {
        final /* synthetic */ ba f606a;
        private az f607b;

        /* renamed from: com.chartboost.sdk.impl.ba.c.a */
        private class C0234a extends C0182l<C0233b> {
            final /* synthetic */ C0235c f604a;
            private az f605b;

            protected /* synthetic */ void m931b(Object obj) {
                m929a((C0233b) obj);
            }

            public C0234a(C0235c c0235c, int i, String str, az azVar) {
                this.f604a = c0235c;
                super(i, str, null);
                this.f605b = azVar;
            }

            public String m933p() {
                String b = this.f605b.m895b();
                if (b == null) {
                    return "application/json; charset=utf-8";
                }
                return b;
            }

            public byte[] m934q() {
                return (this.f605b.m908i() == null ? "" : this.f605b.m908i().toString()).getBytes();
            }

            public C0332a m935s() {
                return this.f605b.m913n();
            }

            public Map<String, String> m932i() throws C0179a {
                Map<String, String> hashMap = new HashMap();
                for (Entry entry : this.f605b.m909j().entrySet()) {
                    hashMap.put(entry.getKey(), entry.getValue() != null ? entry.getValue().toString() : null);
                }
                return hashMap;
            }

            protected C0336n<C0233b> m928a(C0328i c0328i) {
                CBError cBError;
                Exception e;
                int i = c0328i.f912a;
                Object a;
                if (i <= 300 || i >= 200) {
                    try {
                        String str;
                        byte[] bArr = c0328i.f913b;
                        if (bArr != null) {
                            str = new String(bArr);
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            a = C0111a.m146a(new JSONObject(new JSONTokener(str)));
                            try {
                                C0101a l = this.f605b.m911l();
                                CBLogging.m103c("CBRequestManager", "Request " + this.f605b.m906g() + " succeeded. Response code: " + i + ", body: " + str);
                                if (a.m164f("status") == WalletConstants.ERROR_CODE_INVALID_PARAMETERS) {
                                    cBError = new CBError(C0142a.HTTP_NOT_FOUND, "404 error from server");
                                } else {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    if (l == null || l.m123a(a, stringBuilder)) {
                                        cBError = null;
                                    } else {
                                        cBError = new CBError(C0142a.UNEXPECTED_RESPONSE, "Json response failed validation");
                                        CBLogging.m101b("CBRequestManager", "Json response failed validation: " + stringBuilder.toString());
                                    }
                                }
                            } catch (Exception e2) {
                                e = e2;
                                cBError = new CBError(C0142a.MISCELLANEOUS, e.getLocalizedMessage());
                                if (a == null) {
                                }
                                return C0336n.m1361a(new C0232a(cBError));
                            }
                        }
                        cBError = new CBError(C0142a.INVALID_RESPONSE, "Response is not a valid json object");
                        a = null;
                    } catch (Exception e3) {
                        e = e3;
                        a = null;
                        cBError = new CBError(C0142a.MISCELLANEOUS, e.getLocalizedMessage());
                        if (a == null) {
                        }
                        return C0336n.m1361a(new C0232a(cBError));
                    }
                }
                CBLogging.m105d("CBRequestManager", "Request " + this.f605b.m906g() + " failed. Response code: " + i);
                cBError = new CBError(C0142a.NETWORK_FAILURE, "Request failed. Response code: " + i + " is not valid ");
                a = null;
                if (a == null && cBError == null) {
                    return C0336n.m1362a(new C0233b(C0111a.m146a(a), c0328i), null);
                }
                return C0336n.m1361a(new C0232a(cBError));
            }

            protected void m929a(C0233b c0233b) {
                if (!(this.f604a.f607b.m917r() == null || c0233b == null)) {
                    this.f604a.f607b.m917r().m20a(c0233b.f602a, this.f604a.f607b);
                }
                if (this.f604a.f607b.m907h()) {
                    C0151a.m323a().m366m().m242c((File) ba.f610f.get(this.f604a.f607b));
                    C0151a.m323a().m370q();
                    CBLogging.m97a("CBRequestManager", "### Removing track events sent to server...");
                    ba.f610f.remove(this.f604a.f607b);
                    return;
                }
                this.f604a.f606a.f614d.m242c((File) ba.f609e.get(this.f604a.f607b));
                ba.f609e.remove(this.f604a.f607b);
                this.f604a.f606a.m941a(this.f604a.f607b, c0233b.f603b, null, true);
            }

            public void m930b(C0178s c0178s) {
                if (c0178s != null) {
                    CBError a;
                    if (c0178s instanceof C0232a) {
                        a = ((C0232a) c0178s).f601b;
                    } else {
                        a = new CBError(C0142a.NETWORK_FAILURE, c0178s.getMessage());
                    }
                    C0111a c0111a = C0111a.f95a;
                    if (c0178s != null) {
                        try {
                            if (!(c0178s.f315a == null || c0178s.f315a.f913b == null || c0178s.f315a.f913b.length <= 0)) {
                                c0111a = C0111a.m147j(new String(c0178s.f315a.f913b));
                            }
                        } catch (Throwable e) {
                            CBLogging.m106d("CBRequestManager", "unable to read error json", e);
                        }
                    }
                    if (c0178s.f315a == null || c0178s.f315a.f912a != 200) {
                        if (this.f604a.f607b.m917r() != null) {
                            this.f604a.f607b.m917r().m21a(c0111a, this.f604a.f607b, a);
                        }
                        if (this.f604a.f607b.m907h()) {
                            ba.f610f.remove(this.f604a.f607b);
                            return;
                        }
                        this.f604a.f607b.m903d(false);
                        this.f604a.f606a.m941a(this.f604a.f607b, c0178s.f315a, a, false);
                        return;
                    }
                    m929a(new C0233b(c0111a, c0178s.f315a));
                }
            }
        }

        public C0235c(ba baVar, az azVar) {
            this.f606a = baVar;
            this.f607b = azVar;
        }

        public void run() {
            this.f607b.m884a(C0153b.m400l());
            this.f607b.m900c();
            String format = String.format("%s%s", new Object[]{"https://live.chartboost.com", this.f607b.m904e()});
            this.f607b.m902d();
            this.f607b.m882a();
            C0182l c0234a = new C0234a(this, 1, format, this.f607b);
            c0234a.m541a(new C0303d(30000, 0, 0.0f));
            this.f606a.f613c.m1353a(c0234a);
        }
    }

    static {
        f611g = new ArrayList();
    }

    public static ba m938a(Context context) {
        if (f608b == null) {
            synchronized (ba.class) {
                if (f608b == null) {
                    f608b = new ba(context);
                }
            }
        }
        return f608b;
    }

    private ba(Context context) {
        this.f612a = null;
        this.f613c = ad.m579a(context.getApplicationContext());
        this.f612a = ay.m871a();
        this.f614d = new C0132h("CBRequestManager", false);
        f609e = new ConcurrentHashMap();
        f610f = new ConcurrentHashMap();
        this.f612a.addObserver(this);
    }

    public C0335m m949a() {
        return this.f613c;
    }

    private void m941a(az azVar, C0328i c0328i, CBError cBError, boolean z) {
        if (azVar != null) {
            String str;
            C0112b[] c0112bArr = new C0112b[5];
            c0112bArr[0] = C0113e.m181a("endpoint", azVar.m906g());
            c0112bArr[1] = C0113e.m181a("statuscode", c0328i == null ? "None" : Integer.valueOf(c0328i.f912a));
            c0112bArr[2] = C0113e.m181a("error", cBError == null ? "None" : cBError.m280a());
            c0112bArr[3] = C0113e.m181a("errorDescription", cBError == null ? "None" : cBError.m281b());
            c0112bArr[4] = C0113e.m181a("retryCount", Integer.valueOf(azVar.m914o()));
            C0111a a = C0113e.m180a(c0112bArr);
            String str2 = "request_manager";
            String str3 = "request";
            if (z) {
                str = "success";
            } else {
                str = "failure";
            }
            C0151a.m334a(str2, str3, str, null, null, null, a.m163e());
        }
    }

    protected void m950a(az azVar, C0085c c0085c) {
        if (azVar != null) {
            if (this.f612a.m878c()) {
                if (!azVar.m907h() && azVar.m915p()) {
                    azVar.m901c(false);
                    m940a(azVar);
                }
                m951a(new C0235c(this, azVar));
                return;
            }
            CBError cBError = new CBError(C0142a.INTERNET_UNAVAILABLE, null);
            azVar.m903d(false);
            if (!azVar.m907h()) {
                if (azVar.m915p()) {
                    azVar.m901c(false);
                    m940a(azVar);
                }
                m941a(azVar, null, cBError, false);
                if (c0085c != null) {
                    c0085c.m21a(null, azVar, cBError);
                }
            }
        }
    }

    public void m951a(Runnable runnable) {
        Object obj = null;
        synchronized (C0108c.class) {
            C0107a c = C0108c.m135c();
            if (c == C0107a.PRELOAD || c == C0107a.LOADING) {
                f611g.add(runnable);
            } else {
                obj = 1;
            }
        }
        if (obj != null) {
            ax.m867a().execute(runnable);
        }
    }

    public static void m944b() {
        List<Runnable> arrayList = new ArrayList();
        synchronized (C0108c.class) {
            arrayList.addAll(f611g);
            f611g.clear();
        }
        for (Runnable execute : arrayList) {
            ax.m867a().execute(execute);
        }
    }

    public synchronized void m952c() {
        synchronized (this) {
            if (f609e == null || f609e.isEmpty()) {
                String[] a = this.f614d.m238a();
                if (a != null) {
                    for (String str : a) {
                        az a2 = m937a(str);
                        if (a2 != null) {
                            f609e.put(a2, this.f614d.m244d(str));
                            a2.m901c(false);
                            a2.m883a(a2.m914o() + 1);
                            a2.m886a(a2.m917r());
                        }
                    }
                }
            } else {
                for (az azVar : f609e.keySet()) {
                    if (!(azVar == null || azVar.m916q())) {
                        azVar.m883a(azVar.m914o() + 1);
                        azVar.m886a(azVar.m917r());
                    }
                }
            }
            m953e();
            m954f();
        }
    }

    public static synchronized void m945d() {
        synchronized (ba.class) {
            try {
                String[] a;
                C0132h c = C0132h.m230c();
                if (c != null) {
                    a = c.m238a();
                } else {
                    a = null;
                }
                if (a != null && a.length > 0) {
                    for (String str : a) {
                        C0111a a2 = c.m233a(str);
                        if (a2.m158c()) {
                            c.m240b(str);
                            az a3 = az.m881a(a2);
                            if (a3 != null) {
                                a3.m893a(true);
                                a3.m918s();
                            } else {
                                CBLogging.m101b("CBRequestManager", "Error processing video completeion event");
                            }
                        }
                    }
                }
            } catch (Throwable e) {
                CBLogging.m102b("CBRequestManager", "Error executing saved requests", e);
            }
        }
    }

    public void m953e() {
        C0151a a = C0151a.m323a();
        if (C0153b.m397i()) {
            synchronized (this) {
                if (f610f.isEmpty()) {
                    try {
                        String[] a2;
                        C0132h m = a.m366m();
                        if (m != null) {
                            a2 = m.m238a();
                        } else {
                            a2 = null;
                        }
                        if (a2 != null) {
                            for (String str : a2) {
                                if (!a.m358b(str)) {
                                    C0111a a3 = m.m233a(str);
                                    if (a3.m158c()) {
                                        CBLogging.m97a("CBRequestManager", "### Flushing out " + str + "track events from cache to server...");
                                        az a4 = a.m353a(a3);
                                        f610f.put(a4, m.m244d(str));
                                        a4.m918s();
                                    }
                                }
                            }
                        }
                    } catch (Throwable e) {
                        CBLogging.m102b("CBRequestManager", "Error executing saved requests", e);
                    }
                } else {
                    for (az azVar : f610f.keySet()) {
                        if (!(azVar == null || azVar.m916q())) {
                            azVar.m883a(azVar.m914o() + 1);
                            azVar.m886a(azVar.m917r());
                        }
                    }
                }
            }
            return;
        }
        if (!(f610f == null || f610f.isEmpty())) {
            f610f.clear();
        }
        a.m366m().m239b();
    }

    private void m940a(az azVar) {
        Object obj = null;
        if (azVar != null) {
            if (azVar.m910k() && (azVar instanceof az)) {
                obj = this.f614d.m234a(null, azVar.m919t());
            }
            if ((azVar.m910k() || azVar.m912m()) && obj != null) {
                f609e.put(azVar, obj);
            }
        }
    }

    private az m937a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0111a a = this.f614d.m233a(str);
        if (a != null) {
            return az.m881a(a);
        }
        return null;
    }

    public void m954f() {
        if (this.f615h == null) {
            this.f615h = new C02311(this, 240000, 1000).start();
        }
    }

    public void m955g() {
        CBLogging.m97a("CBRequestManager", "Timer stopped:");
        if (this.f615h != null) {
            this.f615h.cancel();
            this.f615h = null;
        }
    }

    public void update(Observable observable, Object obj) {
        if (this.f615h != null) {
            m955g();
        }
        m952c();
    }

    public static synchronized boolean m946h() {
        boolean z;
        synchronized (ba.class) {
            if (f610f == null || f610f.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
        }
        return z;
    }

    public ConcurrentHashMap<az, File> m956i() {
        return f609e;
    }

    public C0132h m957j() {
        return this.f614d;
    }
}
